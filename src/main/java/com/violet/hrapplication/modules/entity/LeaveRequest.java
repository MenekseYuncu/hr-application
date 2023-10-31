package com.violet.hrapplication.modules.entity;

import com.violet.hrapplication.modules.Employee.model.entity.Employee;

import java.time.LocalDate;

public class LeaveRequest {

    private Long id;

    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
