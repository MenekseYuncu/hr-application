package com.violet.hrapplication.employee.model.entity;

import com.violet.hrapplication.annotations.Column;
import com.violet.hrapplication.annotations.Table;
import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;

import java.time.LocalDate;

@Table(table = "employee")
public class Employee {

    @Column(column = "id")
    private String id;

    @Column(column = "username")
    private String username;

    @Column(column = "password")
    private String password;

    @Column(column = "first_name")
    private String first_name;

    @Column(column = "last_name")
    private String last_name;

    @Column(column = "email")
    private String email;

    @Column(column = "birthday")
    private LocalDate birthday;

    @Column(column = "start_working_date")
    private LocalDate start_working_date;

    @Column(column = "role")
    private Role role;

    @Column(column = "gender")
    private Gender gender;

    public Employee(String id, String username, String password, String first_name, String last_name, String email, LocalDate birthday, LocalDate start_working_date, Role role, Gender gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.birthday = birthday;
        this.start_working_date = start_working_date;
        this.role = role;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
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
        return start_working_date;
    }

    public void setStartWorkingDate(LocalDate startWorkingDate) {
        this.start_working_date = startWorkingDate;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", start_working_date=" + start_working_date +
                ", role=" + role +
                ", gender=" + gender +
                '}';
    }
}
