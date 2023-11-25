package com.violet.hrapplication.employee.repository;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

public interface EmployeeRepository {

    void save(EmployeeEntity employeeEntity);

    Boolean findByUsername(String username);

    Boolean checkPassword(String username, String password);

    Boolean changePassword(String username, String newPassword);

}
