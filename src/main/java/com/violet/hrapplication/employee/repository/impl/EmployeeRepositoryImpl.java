package com.violet.hrapplication.employee.repository.impl;

import com.violet.hrapplication.employee.model.entity.Employee;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createEmployee(Employee employee) {
        var sql = "INSERT INTO Employee (" +
                "id, username, password, first_name, last_name, email, birthday, start_working_date, Role, Gender) " +
                "VALUES (" +
                ":id, :username, :password, :first_name, :last_name, :email, :birthday, :start_working_date, :role, :gender)";

        try (Connection con = sql2o.open()) {
            try (Query query = con.createQuery(sql)
                    .addParameter("id", employee.getId())
                    .addParameter("username", employee.getUsername())
                    .addParameter("password", employee.getPassword())
                    .addParameter("first_name", employee.getFirstName())
                    .addParameter("last_name", employee.getLastName())
                    .addParameter("email", employee.getEmail())
                    .addParameter("birthday", employee.getBirthday())
                    .addParameter("start_working_date", employee.getStartWorkingDate())
                    .addParameter("role", employee.getRole())
                    .addParameter("gender", employee.getGender())) {
                query.executeUpdate();
            }
        }
    }

    @Override
    public Boolean isUsernameExists(String username) {
        String sql = "SELECT * FROM Employee WHERE username = :username";
        try (Connection con = sql2o.open()) {
            try (Query query = con.createQuery(sql)) {
                query.addParameter("username", username);
                List<Employee> employees = query.executeAndFetch(Employee.class);
                return !employees.isEmpty();
            }
        }
    }
}
