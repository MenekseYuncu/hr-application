package com.violet.hrapplication.modules.entity;

import com.violet.hrapplication.employee.model.entity.Employee;

public class EmployeeLeaveTypeAssigment {

    private Long id;

    private Employee employee;

    private LeaveType leaveType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
