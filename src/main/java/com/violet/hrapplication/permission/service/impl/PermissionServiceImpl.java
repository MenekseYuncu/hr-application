package com.violet.hrapplication.permission.service.impl;

import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.permission.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.permission.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.permission.model.domain.LeaveRequest;
import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.permission.repository.PermissionRepository;
import com.violet.hrapplication.permission.service.PermissionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
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
    public List<LeaveRequestResponse> getAllLeaves() {
        List<LeaveRequestEntity> leaveRequestEntities = permissionRepository.findAll();
        return leaveRequestEntities.stream()
                .map(leaveRequestEntity -> new LeaveRequestResponse(
                        leaveRequestEntity.getStartDate(),
                        leaveRequestEntity.getEndDate(),
                        leaveRequestEntity.getLeaveTypeId()))
                .toList();
    }


}
