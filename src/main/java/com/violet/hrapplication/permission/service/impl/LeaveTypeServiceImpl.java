package com.violet.hrapplication.permission.service.impl;

import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.permission.model.domain.LeaveType;
import com.violet.hrapplication.permission.repository.LeaveTypeRepository;
import com.violet.hrapplication.permission.service.LeaveTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
class LeaveTypeServiceImpl implements LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeServiceImpl(LeaveTypeRepository leaveTypeRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
    }

    @Override
    public void create(CreateLeaveTypeRequest leaveTypeRequest) {

        LeaveType leaveType = new LeaveType();
        leaveType.setId(UUID.randomUUID().toString());
        leaveType.setName(leaveTypeRequest.name());
        leaveType.setMaxDays(leaveTypeRequest.maxDays());
        leaveType.setCreator(leaveTypeRequest.creator());
        leaveType.setCreationTime(LocalDateTime.now());

        leaveTypeRepository.save(leaveType.toLeaveType());
    }
}
