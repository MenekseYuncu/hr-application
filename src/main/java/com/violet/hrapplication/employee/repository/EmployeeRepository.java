package com.violet.hrapplication.employee.repository;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeRepository {

    void save(EmployeeEntity employeeEntity);

    void update(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAll();

    Optional<EmployeeEntity> findByUsername(String username);

    EmployeeEntity findById(String id);

    Optional<EmployeeEntity> findByEmail(String email);

    void changePassword(String id, String newPassword);

}
