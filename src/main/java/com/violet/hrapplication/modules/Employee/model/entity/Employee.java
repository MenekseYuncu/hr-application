package com.violet.hrapplication.modules.Employee.model.entity;

import com.violet.hrapplication.annotations.Column;
import com.violet.hrapplication.annotations.Table;
import com.violet.hrapplication.modules.Employee.model.enums.Gender;
import com.violet.hrapplication.modules.Employee.model.enums.Role;

import java.time.LocalDate;

@Table(table = "employee")
public class Employee {

    @Column(column = "id")
    private Long id;

    @Column(column = "username")
    private String username;

    @Column(column = "password")
    private String password;

    @Column(column = "first_name")
    private String firstName;

    @Column(column = "last_name")
    private String lastName;

    @Column(column = "email")
    private String email;

    @Column(column = "birthday")
    private LocalDate birthday;

    @Column(column = "start_working_date")
    private LocalDate startWorkingDate;

    @Column(column = "role")
    private Role role;

    @Column(column = "gender")
    private Gender gender;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
