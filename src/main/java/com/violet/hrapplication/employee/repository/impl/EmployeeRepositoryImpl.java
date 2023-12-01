package com.violet.hrapplication.employee.repository.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.model.scriptsandmap.EmployeeMapping;
import com.violet.hrapplication.employee.model.scriptsandmap.EmployeeScripts;
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
                .addParameter(EmployeeMapping.USERNAME.getPropertyName())
                .addParameter(EmployeeMapping.PASSWORD.getPropertyName())
                .addParameter(EmployeeMapping.FIRST_NAME.getPropertyName())
                .addParameter(EmployeeMapping.LAST_NAME.getPropertyName())
                .addParameter(EmployeeMapping.EMAIL.getPropertyName())
                .addParameter(EmployeeMapping.GENDER.getPropertyName())) {
            query.addParameter(EmployeeMapping.ID.getPropertyName(), employeeEntity.getId());
            query.executeUpdate();
        }
    }

    @Override
    public Set<EmployeeEntity> findAll() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_ALL)
                .setColumnMappings(EmployeeMapping.getMapping())) {
            List<EmployeeEntity> employeeList = query.executeAndFetch(EmployeeEntity.class);
            return new HashSet<>(employeeList);
        }
    }

    @Override
    public Optional<EmployeeEntity> findByUsername(String username) {

        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_USERNAME)
                .addParameter("username", username)
                .addColumnMapping(EmployeeMapping.ID.getColumnName(), EmployeeMapping.ID.getPropertyName())
                .addColumnMapping(EmployeeMapping.USERNAME.getColumnName(), EmployeeMapping.USERNAME.getPropertyName())
                .addColumnMapping(EmployeeMapping.PASSWORD.getColumnName(), EmployeeMapping.PASSWORD.getPropertyName())
                .addColumnMapping(EmployeeMapping.FIRST_NAME.getColumnName(), EmployeeMapping.FIRST_NAME.getPropertyName())
                .addColumnMapping(EmployeeMapping.LAST_NAME.getColumnName(), EmployeeMapping.LAST_NAME.getPropertyName())
                .addColumnMapping(EmployeeMapping.EMAIL.getColumnName(), EmployeeMapping.EMAIL.getPropertyName())
                .addColumnMapping(EmployeeMapping.BIRTHDAY.getColumnName(), EmployeeMapping.BIRTHDAY.getPropertyName())
                .addColumnMapping(EmployeeMapping.START_WORKING_DATE.getColumnName(), EmployeeMapping.START_WORKING_DATE.getPropertyName())
                .addColumnMapping(EmployeeMapping.ROLE.getColumnName(), EmployeeMapping.ROLE.getPropertyName())
                .addColumnMapping(EmployeeMapping.GENDER.getColumnName(), EmployeeMapping.GENDER.getPropertyName())
                .addColumnMapping(EmployeeMapping.CREATOR.getColumnName(), EmployeeMapping.CREATOR.getPropertyName())
                .addColumnMapping(EmployeeMapping.CREATION_TIME.getColumnName(), EmployeeMapping.CREATION_TIME.getPropertyName())) {
            EmployeeEntity result = query.executeAndFetchFirst(EmployeeEntity.class);
            return Optional.ofNullable(result);
        }
    }

    @Override
    public List<String> findAllByUsername(String username) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_ALL_USERNAMES)) {
            return query.executeScalarList(String.class);
        }
    }

    @Override
    public Optional<EmployeeEntity> findById(String id) {

        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.FIND_BY_ID)
                .addParameter("id", id)
                .addColumnMapping(EmployeeMapping.ID.getColumnName(), EmployeeMapping.ID.getPropertyName())
                .addColumnMapping(EmployeeMapping.USERNAME.getColumnName(), EmployeeMapping.USERNAME.getPropertyName())
                .addColumnMapping(EmployeeMapping.PASSWORD.getColumnName(), EmployeeMapping.PASSWORD.getPropertyName())
                .addColumnMapping(EmployeeMapping.FIRST_NAME.getColumnName(), EmployeeMapping.FIRST_NAME.getPropertyName())
                .addColumnMapping(EmployeeMapping.LAST_NAME.getColumnName(), EmployeeMapping.LAST_NAME.getPropertyName())
                .addColumnMapping(EmployeeMapping.EMAIL.getColumnName(), EmployeeMapping.EMAIL.getPropertyName())
                .addColumnMapping(EmployeeMapping.BIRTHDAY.getColumnName(), EmployeeMapping.BIRTHDAY.getPropertyName())
                .addColumnMapping(EmployeeMapping.START_WORKING_DATE.getColumnName(), EmployeeMapping.START_WORKING_DATE.getPropertyName())
                .addColumnMapping(EmployeeMapping.ROLE.getColumnName(), EmployeeMapping.ROLE.getPropertyName())
                .addColumnMapping(EmployeeMapping.GENDER.getColumnName(), EmployeeMapping.GENDER.getPropertyName())
                .addColumnMapping(EmployeeMapping.CREATOR.getColumnName(), EmployeeMapping.CREATOR.getPropertyName())
                .addColumnMapping(EmployeeMapping.CREATION_TIME.getColumnName(), EmployeeMapping.CREATION_TIME.getPropertyName())) {

            EmployeeEntity result = query.executeAndFetchFirst(EmployeeEntity.class);
            return Optional.of(result);
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
                .addParameter(EmployeeMapping.ID.getPropertyName())
                .addParameter(EmployeeMapping.PASSWORD.getPropertyName())) {
            query.executeUpdate();
        }
    }

    @Override
    public void authenticateUser(String username, String password) {

        try (Connection con = sql2o.open(); Query query = con.createQuery(EmployeeScripts.AUTHENTICATE_USER)
                .addParameter(EmployeeMapping.USERNAME.getPropertyName())
                .addParameter(EmployeeMapping.PASSWORD.getPropertyName())) {

            query.executeScalar(Integer.class);
        }
    }
}


