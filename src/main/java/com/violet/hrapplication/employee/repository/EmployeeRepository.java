package com.violet.hrapplication.employee.repository;

import com.violet.hrapplication.employee.model.entity.Employee;

public interface EmployeeRepository {

    void createEmployee(Employee employee);

    Boolean isUsernameExists(String username);

}
