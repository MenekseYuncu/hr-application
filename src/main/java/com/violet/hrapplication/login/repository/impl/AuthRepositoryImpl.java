package com.violet.hrapplication.login.repository.impl;

import com.violet.hrapplication.login.repository.AuthRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
class AuthRepositoryImpl implements AuthRepository {

    private final Sql2o sql2o;

    public AuthRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        String sql = "SELECT COUNT(*) FROM EMPLOYEE WHERE USERNAME = :username AND PASSWORD = :password";

        try (Connection con = sql2o.open();
             Query query = con.createQuery(sql)
                     .addParameter("username", username)
                     .addParameter("password", password)) {

            int count = query.executeScalar(Integer.class);
            return count > 0;
        }
    }
}
