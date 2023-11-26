package com.violet.hrapplication.permission.model.entity;

import com.violet.hrapplication.employee.model.enums.Gender;

import java.time.LocalDateTime;

public class LeaveTypeEntity {

    private String id;
    private String name;
    private int maxDays;
    private Gender gender;
    private String creator;
    private LocalDateTime creationTime;

    public LeaveTypeEntity(String id, String name, int maxDays, Gender gender, String creator, LocalDateTime creationTime) {
        this.id = id;
        this.name = name;
        this.maxDays = maxDays;
        this.gender = gender;
        this.creator = creator;
        this.creationTime = creationTime;
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

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
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
