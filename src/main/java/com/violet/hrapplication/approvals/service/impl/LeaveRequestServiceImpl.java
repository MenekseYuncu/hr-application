package com.violet.hrapplication.approvals.service.impl;

import com.violet.hrapplication.approvals.controller.request.FilterByStateRequest;
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
    public List<LeaveRequestResponse> getAllLeaves(PaginationRequest pagination, FilterByStateRequest filter) {
        int page = pagination.page();
        int size = pagination.size();

        if (filter == null || filter.state() == null) {
            return leaveRequestRepository.findAll((page - 1) * size, size).stream()
                    .map(leaveRequestEntity -> new LeaveRequestResponse(
                            leaveRequestEntity.getId(),
                            leaveRequestEntity.getStartDate(),
                            leaveRequestEntity.getEndDate(),
                            leaveRequestEntity.getState(),
                            leaveRequestEntity.getLeaveTypeId()))
                    .toList();
        } else {
            
            State state = filter.state();
            return leaveRequestRepository.findByState(state).stream()
                    .map(leaveRequestEntity -> new LeaveRequestResponse(
                            leaveRequestEntity.getId(),
                            leaveRequestEntity.getStartDate(),
                            leaveRequestEntity.getEndDate(),
                            leaveRequestEntity.getState(),
                            leaveRequestEntity.getLeaveTypeId()))
                    .toList();
        }
    }



    @Override
    public List<LeaveResponse> getLeaves(String employeeId, PaginationRequest paginationRequest, FilterByStateRequest filterByStateRequest) {
        if (employeeRepository.findById(employeeId).isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        int page = paginationRequest.page();
        int size = paginationRequest.size();

        List<LeaveRequestEntity> leaveEntities =
                leaveRequestRepository.findByEmployeeId(employeeId, (page - 1) * size, size);

        if (filterByStateRequest == null || filterByStateRequest.state() == null) {
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
        }else {
            return leaveEntities.stream()
                    .filter(leaveEntity -> leaveEntity.getState() == filterByStateRequest.state())
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
    }

    @Override
    public List<LeaveRequestResponse> getLeavesByState(State state, PaginationRequest paginationRequest) {
        List<LeaveRequestEntity> leaveEntities = leaveRequestRepository.findByState(state);
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
