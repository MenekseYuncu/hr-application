package com.violet.hrapplication.approvals.service.impl;

import com.violet.hrapplication.approvals.controller.request.leavetype.CreateLeaveTypeRequest;
import com.violet.hrapplication.approvals.controller.request.leavetype.UpdateLeaveTypeRequest;
import com.violet.hrapplication.approvals.model.domain.LeaveType;
import com.violet.hrapplication.approvals.model.entity.LeaveTypeEntity;
import com.violet.hrapplication.approvals.repository.LeaveTypeRepository;
import com.violet.hrapplication.approvals.service.LeaveTypeService;
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

    @Override
    public void update(String id, UpdateLeaveTypeRequest leaveTypeRequest) {
        LeaveTypeEntity leaveTypeEntity = leaveTypeRepository.findById(id);

        if (leaveTypeEntity == null) {
            return;
        }
        leaveTypeEntity.update(
                leaveTypeRequest.name(),
                leaveTypeRequest.maxDays()
        );

        leaveTypeRepository.update(leaveTypeEntity);
    }

    @Override
    public void delete(String id) {
        LeaveTypeEntity leaveType = leaveTypeRepository.findById(id);
        if (leaveType == null) {
            throw new IllegalArgumentException("LeaveRequestNotFoundException type not found");
        }
        leaveTypeRepository.delete(id);
    }
}
