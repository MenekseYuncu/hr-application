package com.violet.hrapplication.approvals.service.impl;

import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;
import com.violet.hrapplication.approvals.model.domain.LeaveRequest;
import com.violet.hrapplication.approvals.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.approvals.repository.PermissionRepository;
import com.violet.hrapplication.approvals.service.PermissionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final EmployeeRepository employeeRepository;

    PermissionServiceImpl(PermissionRepository permissionRepository, EmployeeRepository employeeRepository) {
        this.permissionRepository = permissionRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<LeaveRequestResponse> getAllLeaves() {
        List<LeaveRequestEntity> leaveRequestEntities = permissionRepository.findAll();
        return leaveRequestEntities.stream()
                .map(leaveRequestEntity -> new LeaveRequestResponse(
                        leaveRequestEntity.getStartDate(),
                        leaveRequestEntity.getEndDate(),
                        leaveRequestEntity.getLeaveTypeId()
                )).toList();
    }

    @Override
    public List<LeaveResponse> getLeaves(String employeeId) {
        if (employeeRepository.findById(employeeId) == null) {
            throw new UserNotFoundException("User not found");
        }
        List<LeaveRequestEntity> leaveRequestEntities = permissionRepository.findByEmployeeId(employeeId);
        return leaveRequestEntities.stream()
                .map(leaveEntity -> new LeaveResponse(
                        leaveEntity.getStartDate(),
                        leaveEntity.getEndDate(),
                        leaveEntity.getLeaveTypeId()
                )).toList();
    }

    @Override
    public void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException {

        LeaveRequest leave = new LeaveRequest();
        leave.setId(UUID.randomUUID().toString());
        leave.setEmployeeId(createLeaveRequest.employeeId());
        leave.setStartDate(createLeaveRequest.startDate());
        leave.setEndDate(createLeaveRequest.endDate());
        leave.setLeaveTypeId(createLeaveRequest.leaveTypeId());
        leave.setState(createLeaveRequest.state());
        leave.setCreator(createLeaveRequest.creator());
        leave.setCreationTime(LocalDateTime.now());

        permissionRepository.save(leave.toLeaveRequest());
    }

    @Override
    public void update(String id, UpdateLeaveRequest updateLeaveRequest) throws UserNotFoundException {
        LeaveRequestEntity leaveRequestEntity = permissionRepository.findById(id);

        if (leaveRequestEntity == null) {
            return;
        }

        leaveRequestEntity.update(
                updateLeaveRequest.startDate(),
                updateLeaveRequest.endDate()
        );
        permissionRepository.update(leaveRequestEntity);

    }
}
