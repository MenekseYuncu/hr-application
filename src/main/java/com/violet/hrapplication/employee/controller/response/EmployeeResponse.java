package com.violet.hrapplication.employee.controller.response;

import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeResponse {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private LocalDate startWorkingDate;
    private Role role;
    private Gender gender;
    private String creator;
    private LocalDateTime creationTime;

    public EmployeeResponse(String username, String firstName, String lastName, String email, LocalDate birthday, LocalDate startWorkingDate, Role role, Gender gender, String creator, LocalDateTime creationTime) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.startWorkingDate = startWorkingDate;
        this.role = role;
        this.gender = gender;
        this.creator = creator;
        this.creationTime = creationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(LocalDate startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
