package com.violet.hrapplication.modules;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.permission.model.entity.LeaveTypeEntity;

public class EmployeeLeaveTypeAssigment {

    private Long id;

    private EmployeeEntity employeeEntity;

    private LeaveTypeEntity leaveTypeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employeeEntity;
    }

    public void setEmployee(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public LeaveTypeEntity getLeaveType() {
        return leaveTypeEntity;
    }

    public void setLeaveType(LeaveTypeEntity leaveTypeEntity) {
        this.leaveTypeEntity = leaveTypeEntity;
    }
}
