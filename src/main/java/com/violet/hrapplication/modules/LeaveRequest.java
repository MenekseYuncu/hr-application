package com.violet.hrapplication.modules;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

import java.time.LocalDate;

public class LeaveRequest {

    private Long id;

    private EmployeeEntity employeeEntity;

    private LocalDate startDate;
    private LocalDate endDate;

    private LeaveType leaveType;

    private boolean approved; // doğrudan onaylanmış olduğu için true dönmeli

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
