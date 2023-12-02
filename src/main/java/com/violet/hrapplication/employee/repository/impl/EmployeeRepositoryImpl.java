package com.violet.hrapplication.employee.repository.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.model.scriptsandmap.EmployeeMapping;
import com.violet.hrapplication.employee.model.scriptsandmap.EmployeeScripts;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(EmployeeEntity employeeEntity) {

        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.SAVE)
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
                .addParameter(EmployeeMapping.PASSWORD.getPropertyName(), employeeEntity.getPassword())) {
            query.executeUpdate();
        }
    }

    @Override
    public void update(EmployeeEntity employeeEntity) {

        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.UPDATE)
                .addParameter(EmployeeMapping.ID.getPropertyName(), employeeEntity.getId())
                .addParameter(EmployeeMapping.USERNAME.getPropertyName(), employeeEntity.getUsername())
                .addParameter(EmployeeMapping.PASSWORD.getPropertyName(), employeeEntity.getPassword())
                .addParameter(EmployeeMapping.FIRST_NAME.getPropertyName(), employeeEntity.getFirstName())
                .addParameter(EmployeeMapping.LAST_NAME.getPropertyName(), employeeEntity.getLastName())
                .addParameter(EmployeeMapping.EMAIL.getPropertyName(), employeeEntity.getEmail())
                .addParameter(EmployeeMapping.GENDER.getPropertyName(), employeeEntity.getGender())) {
            query.executeUpdate();
        }
    }


    @Override
    public Optional<EmployeeEntity> findByUsername(String username) {

        String sql = "SELECT ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, BIRTHDAY, START_WORKING_DATE, ROLE, GENDER, CREATOR, CREATION_TIME " +
                "FROM EMPLOYEE WHERE USERNAME = :username";

        try (Connection con = sql2o.open(); Query query = con.createQuery(sql)) {
            EmployeeEntity result = query
                    .addParameter("username", username)
                    .addColumnMapping("ID", "id")
                    .addColumnMapping("USERNAME", "username")
                    .addColumnMapping("PASSWORD", "password")
                    .addColumnMapping("FIRST_NAME", "firstName")
                    .addColumnMapping("LAST_NAME", "lastName")
                    .addColumnMapping("EMAIL", "email")
                    .addColumnMapping("BIRTHDAY", "birthday")
                    .addColumnMapping("START_WORKING_DATE", "startWorkingDate")
                    .addColumnMapping("ROLE", "role")
                    .addColumnMapping("GENDER", "gender")
                    .addColumnMapping("CREATOR", "creator")
                    .addColumnMapping("CREATION_TIME", "creationTime")
                    .executeAndFetchFirst(EmployeeEntity.class);

            return Optional.ofNullable(result);
        }
    }

    @Override
    public EmployeeEntity findById(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_ID)) {
            return query
                    .addParameter("id", id)
                    .addColumnMapping("ID", "id")
                    .addColumnMapping("USERNAME", "username")
                    .addColumnMapping("PASSWORD", "password")
                    .addColumnMapping("FIRST_NAME", "firstName")
                    .addColumnMapping("LAST_NAME", "lastName")
                    .addColumnMapping("EMAIL", "email")
                    .addColumnMapping("BIRTHDAY", "birthday")
                    .addColumnMapping("START_WORKING_DATE", "startWorkingDate")
                    .addColumnMapping("ROLE", "role")
                    .addColumnMapping("GENDER", "gender")
                    .addColumnMapping("CREATOR", "creator")
                    .addColumnMapping("CREATION_TIME", "creationTime")
                    .executeAndFetchFirst(EmployeeEntity.class);
        }

    }

    @Override
    public Optional<EmployeeEntity> findByEmail(String email) {

        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_EMAIL)
                .addParameter(EmployeeMapping.EMAIL.getPropertyName(), email)
                .setColumnMappings(EmployeeMapping.getMapping())) {

            EmployeeEntity result = query.executeAndFetchFirst(EmployeeEntity.class);
            return Optional.of(result);
        }
    }

    @Override
    public void changePassword(String id, String newPassword) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.CHANGE_PASSWORD)
                .addParameter("id", id)
                .addParameter("newPassword", newPassword)) {
            query.executeUpdate();
        }
    }
}


