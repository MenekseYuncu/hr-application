package com.violet.hrapplication.permission.service.impl;

import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.permission.repository.PermissionRepository;
import com.violet.hrapplication.permission.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void create(CreateLeaveTypeRequest createLeaveTypeRequest) throws UserNotFoundException {

    }
}
