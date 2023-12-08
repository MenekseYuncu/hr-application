package com.violet.hrapplication.permission.model.entity;

import java.time.LocalDateTime;

public class LeaveTypeEntity {

    private String id;
    private String name;
    private int maxDays;
    private String creator;
    private LocalDateTime creationTime;

    public LeaveTypeEntity(String id, String name, int maxDays, String creator, LocalDateTime creationTime) {
        this.id = id;
        this.name = name;
        this.maxDays = maxDays;
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
