package com.violet.hrapplication.approvals.service.impl;

import com.violet.hrapplication.approvals.controller.request.PaginationAndFilter;
import com.violet.hrapplication.approvals.controller.request.PaginationRequest;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.email.EmployeeEmailService;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.exception.LeaveRequestNotFoundException;
import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;
import com.violet.hrapplication.approvals.model.domain.LeaveRequest;
import com.violet.hrapplication.approvals.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.approvals.repository.LeaveRequestRepository;
import com.violet.hrapplication.approvals.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeEmailService emailService;

    LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository, EmployeeRepository employeeRepository, EmployeeEmailService emailService) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
    }

    @Override
    public List<LeaveRequestResponse> getAllLeaves(PaginationAndFilter paginationAndFilter) {

        List<LeaveRequestEntity> leaveRequestEntities = leaveRequestRepository.findAll(
                paginationAndFilter.getPaginationRequest().page(),
                paginationAndFilter.getPaginationRequest().size(),
                paginationAndFilter.getFilterState()
        );
        return leaveRequestEntities.stream()
                .map(leaveRequestEntity -> new LeaveRequestResponse(
                        leaveRequestEntity.getId(),
                        leaveRequestEntity.getStartDate(),
                        leaveRequestEntity.getEndDate(),
                        leaveRequestEntity.getState(),
                        leaveRequestEntity.getLeaveTypeId()))
                .toList();
    }

    @Override
    public List<LeaveResponse> getLeaves(String employeeId, PaginationAndFilter paginationAndFilter) {
        if (employeeRepository.findById(employeeId).isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        List<LeaveRequestEntity> leaveEntities =
                leaveRequestRepository.findByEmployeeId(
                        employeeId,
                        paginationAndFilter.getPaginationRequest().page(),
                        paginationAndFilter.getPaginationRequest().size(),
                        paginationAndFilter.getFilterState());

        return leaveEntities.stream()
                .map(leaveEntity -> new LeaveResponse(
                        leaveEntity.getId(),
                        leaveEntity.getEmployeeId(),
                        leaveEntity.getStartDate(),
                        leaveEntity.getEndDate(),
                        leaveEntity.getState(),
                        leaveEntity.getLeaveTypeId(),
                        leaveEntity.getCreator(),
                        leaveEntity.getCreationTime()))
                .toList();
    }

    @Override
    public List<LeaveRequestResponse> getLeavesByState(State state, PaginationRequest paginationRequest) {
        List<LeaveRequestEntity> leaveEntities = leaveRequestRepository.findByState(
                state,
                paginationRequest.page(),
                paginationRequest.size()
        );
        return leaveEntities.stream()
                .map(leaveEntity -> new LeaveRequestResponse(
                        leaveEntity.getId(),
                        leaveEntity.getStartDate(),
                        leaveEntity.getEndDate(),
                        leaveEntity.getState(),
                        leaveEntity.getLeaveTypeId()))
                .toList();
    }


    @Override
    public List<LeaveResponse> getLeaveRequestsForDate() {
        List<LeaveRequestEntity> leaveEntities = leaveRequestRepository.findByStateAndDate(LocalDate.now());
        return leaveEntities.stream()
                .map(leaveEntity -> new LeaveResponse(
                        leaveEntity.getId(),
                        leaveEntity.getEmployeeId(),
                        leaveEntity.getStartDate(),
                        leaveEntity.getEndDate(),
                        leaveEntity.getState(),
                        leaveEntity.getLeaveTypeId(),
                        leaveEntity.getCreator(),
                        leaveEntity.getCreationTime()))
                .toList();
    }

    @Override
    public void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException {

        if (employeeRepository.findById(createLeaveRequest.employeeId()).isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        if (isLeaveRequestDuplicated(createLeaveRequest)) {
            throw new LeaveRequestNotFoundException("Leave request already exists");
        }
        LeaveRequest leave = new LeaveRequest();
        leave.setId(UUID.randomUUID().toString());
        leave.setEmployeeId(createLeaveRequest.employeeId());
        leave.setStartDate(createLeaveRequest.startDate());
        leave.setEndDate(createLeaveRequest.endDate());
        leave.setLeaveTypeId(createLeaveRequest.leaveTypeId());
        leave.setState(State.PENDING);
        leave.setCreator(createLeaveRequest.creator());
        leave.setCreationTime(LocalDateTime.now());

        leaveRequestRepository.save(leave.toLeaveRequest());
    }

    private boolean isLeaveRequestDuplicated(CreateLeaveRequest createLeaveRequest) {
        return leaveRequestRepository.isExistByDate(
                createLeaveRequest.employeeId(),
                createLeaveRequest.startDate(),
                createLeaveRequest.endDate()
        );
    }

    @Override
    public void update(String id, UpdateLeaveRequest updateLeaveRequest) throws UserNotFoundException {
        LeaveRequestEntity leaveRequestEntity = leaveRequestRepository.findById(id);

        if (leaveRequestEntity == null) {
            throw new LeaveRequestNotFoundException("Leave request not found with id: " + id);
        }

        leaveRequestEntity.update(updateLeaveRequest.state());
        leaveRequestRepository.update(leaveRequestEntity);

        String employeeId = leaveRequestEntity.getEmployeeId();
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        String employeeEmail = employeeEntity.map(EmployeeEntity::getEmail)
                .orElseThrow(() -> new UserNotFoundException("Employee not found with id: " + employeeId));

        emailService.sendLeaveRequestStatusChange(leaveRequestEntity.toLeaveRequest(), employeeEmail);
    }
}
