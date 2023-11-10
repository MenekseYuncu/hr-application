package com.violet.hrapplication.employee.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;

import java.time.LocalDate;

public class CreateEmployeeRequest {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private LocalDate startWorkingDate;
    private Role role;
    private Gender gender;

    public CreateEmployeeRequest(String firstName, String lastName, String email, LocalDate birthday, LocalDate startWorkingDate, Role role, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.startWorkingDate = startWorkingDate;
        this.role = role;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getStartWorkingDate() {
        return startWorkingDate;
    }

    public Role getRole() {
        return role;
    }

    public Gender getGender() {
        return gender;
    }
}
