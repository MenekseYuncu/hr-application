package com.violet.hrapplication.employee.repository.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.repository.mapping.EmployeeMapping;
import com.violet.hrapplication.employee.repository.script.EmployeeScripts;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public List<EmployeeEntity> findAll() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_ALL)) {
            List<EmployeeEntity> result = query
                    .setColumnMappings(EmployeeMapping.COLUMN_MAPPING)
                    .executeAndFetch(EmployeeEntity.class);
            return Objects.requireNonNullElse(result, Collections.emptyList());
        }
    }


    @Override
    public Optional<EmployeeEntity> findById(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_ID)) {
            return Optional.ofNullable(query
                    .addParameter(EmployeeMapping.ID.getPropertyName(), id)
                    .setColumnMappings(EmployeeMapping.COLUMN_MAPPING)
                    .executeAndFetchFirst(EmployeeEntity.class));
        }
    }


    @Override
    public Optional<EmployeeEntity> findByUsername(String username) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_USERNAME)) {
            return Optional.ofNullable(query
                    .addParameter(EmployeeMapping.USERNAME.getPropertyName(), username)
                    .setColumnMappings(EmployeeMapping.COLUMN_MAPPING)
                    .executeAndFetchFirst(EmployeeEntity.class));
        }
    }

    @Override
    public Optional<EmployeeEntity> findByEmail(String email) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_EMAIL)) {
            return Optional.ofNullable(query
                    .addParameter(EmployeeMapping.EMAIL.getPropertyName(), email)
                    .setColumnMappings(EmployeeMapping.COLUMN_MAPPING)
                    .executeAndFetchFirst(EmployeeEntity.class));
        }
    }


    @Override
    public void save(EmployeeEntity employeeEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.SAVE)) {
            query
                    .addParameter(EmployeeMapping.ID.getPropertyName(), employeeEntity.getId())
                    .addParameter(EmployeeMapping.FIRST_NAME.getPropertyName(), employeeEntity.getFirstName())
                    .addParameter(EmployeeMapping.LAST_NAME.getPropertyName(), employeeEntity.getLastName())
                    .addParameter(EmployeeMapping.EMAIL.getPropertyName(), employeeEntity.getEmail())
                    .addParameter(EmployeeMapping.BIRTHDAY.getPropertyName(), employeeEntity.getBirthday())
                    .addParameter(EmployeeMapping.START_WORKING_DATE.getPropertyName(), employeeEntity.getStartWorkingDate())
                    .addParameter(EmployeeMapping.ROLE.getPropertyName(), employeeEntity.getRole())
                    .addParameter(EmployeeMapping.GENDER.getPropertyName(), employeeEntity.getGender())
                    .addParameter(EmployeeMapping.CREATOR.getPropertyName(), employeeEntity.getCreator())
                    .addParameter(EmployeeMapping.CREATION_TIME.getPropertyName(), employeeEntity.getCreationTime())
                    .addParameter(EmployeeMapping.USERNAME.getPropertyName(), employeeEntity.getUsername())
                    .addParameter(EmployeeMapping.PASSWORD.getPropertyName(), employeeEntity.getPassword())
                    .executeUpdate();
        }
    }

    @Override
    public void update(EmployeeEntity employeeEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.UPDATE)) {
            query
                    .addParameter(EmployeeMapping.ID.getPropertyName(), employeeEntity.getId())
                    .addParameter(EmployeeMapping.FIRST_NAME.getPropertyName(), employeeEntity.getFirstName())
                    .addParameter(EmployeeMapping.LAST_NAME.getPropertyName(), employeeEntity.getLastName())
                    .addParameter(EmployeeMapping.EMAIL.getPropertyName(), employeeEntity.getEmail())
                    .addParameter(EmployeeMapping.GENDER.getPropertyName(), employeeEntity.getGender())
                    .executeUpdate();
        }
    }


    @Override
    public void changePassword(String id, String newPassword) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.CHANGE_PASSWORD)) {
            query
                    .addParameter(EmployeeMapping.ID.getPropertyName(), id)
                    .addParameter(EmployeeMapping.PASSWORD.getPropertyName(), newPassword)
                    .executeUpdate();
        }
    }
}


