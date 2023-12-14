package com.violet.hrapplication.employee.repository;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<EmployeeEntity> findAll();

    Optional<EmployeeEntity> findById(String id);

    Optional<EmployeeEntity> findByEmail(String email);

    Optional<EmployeeEntity> findByUsername(String username);

    void save(EmployeeEntity employeeEntity);

    void update(EmployeeEntity employeeEntity);

    void changePassword(String id, String newPassword);
}
