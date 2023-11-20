package com.violet.hrapplication.modules;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

public class EmployeeLeaveTypeAssigment {

    private Long id;

    private EmployeeEntity employeeEntity;

    private LeaveType leaveType;

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

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
