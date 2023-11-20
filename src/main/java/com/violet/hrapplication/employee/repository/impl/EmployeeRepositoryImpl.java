package com.violet.hrapplication.employee.repository.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(EmployeeEntity employeeEntity) {
        final String sql = "INSERT INTO EMPLOYEE (" +
                "ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, BIRTHDAY, START_WORKING_DATE,ROLE ,GENDER,CREATOR,CREATION_TIME) " +
                "VALUES (" +
                ":id, :username, :password, :firstName, :lastName, :email, :birthday, :startWorkingDate, :role, :gender, :creator, :creationTime)";

        try (Connection con = sql2o.open();
             Query query = con.createQuery(sql)
                     .addParameter("id", employeeEntity.getId())
                     .addParameter("username", employeeEntity.getUsername())
                     .addParameter("password", employeeEntity.getPassword())
                     .addParameter("firstName", employeeEntity.getFirstName())
                     .addParameter("lastName", employeeEntity.getLastName())
                     .addParameter("email", employeeEntity.getEmail())
                     .addParameter("birthday", employeeEntity.getBirthday())
                     .addParameter("startWorkingDate", employeeEntity.getStartWorkingDate())
                     .addParameter("role", employeeEntity.getRole())
                     .addParameter("gender", employeeEntity.getGender())
                     .addParameter("creator", employeeEntity.getCreator())
                     .addParameter("creationTime", employeeEntity.getCreationTime())) {
            query.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean findByUsername(String username) {
        final String checkUsernameSql = "SELECT COUNT(*) FROM EMPLOYEE WHERE USERNAME = :username";

        try (Connection con = sql2o.open();
             Query query = con.createQuery(checkUsernameSql)
                     .addParameter("username", username)) {

            int existingUserCount = query.executeScalar(Integer.class);
            return existingUserCount == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

