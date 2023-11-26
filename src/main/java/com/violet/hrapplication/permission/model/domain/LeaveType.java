package com.violet.hrapplication.permission.model.domain;

import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.permission.model.entity.LeaveTypeEntity;

import java.time.LocalDateTime;

public class LeaveType {

    private String id;
    private String name;
    private int maydays;
    private Gender gender;
    private String creator;
    private LocalDateTime creationTime;

    public LeaveTypeEntity toLeaveType() {
        return new LeaveTypeEntity(
                id,
                name,
                maydays,
                gender,
                creator,
                creationTime
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaydays() {
        return maydays;
    }

    public void setMaydays(int maydays) {
        this.maydays = maydays;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
