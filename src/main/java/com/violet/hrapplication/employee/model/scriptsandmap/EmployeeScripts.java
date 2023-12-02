package com.violet.hrapplication.employee.model.scriptsandmap;

public final class EmployeeScripts {

    private EmployeeScripts() {}

    public static final String SAVE = "INSERT INTO EMPLOYEE (" +
            "ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, BIRTHDAY, START_WORKING_DATE,ROLE ,GENDER,CREATOR,CREATION_TIME) " +
            "VALUES (" +
            ":id, :username, :password, :firstName, :lastName, :email, :birthday, :startWorkingDate, :role, :gender, :creator, :creationTime)";

    public static final String UPDATE = "UPDATE EMPLOYEE SET USERNAME = :username, PASSWORD = :password, FIRST_NAME = :firstName, LAST_NAME = :lastName, EMAIL = :email, GENDER = :gender  WHERE ID = :id";

    public static final String FIND_ALL = "SELECT * FROM EMPLOYEE";

    public static final String FIND_BY_USERNAME = "SELECT ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, BIRTHDAY, START_WORKING_DATE, ROLE, GENDER, CREATOR, CREATION_TIME " +
            "FROM EMPLOYEE WHERE USERNAME = :username";

    //public static final String FIND_BY_ID = "SELECT * FROM EMPLOYEE WHERE ID = :id";
    public static final String FIND_BY_ID = "SELECT ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, BIRTHDAY, START_WORKING_DATE, ROLE, GENDER, CREATOR, CREATION_TIME FROM EMPLOYEE WHERE ID = :id";

    public static final String FIND_BY_EMAIL = "SELECT EMAIL FROM EMPLOYEE WHERE EMAIL = :email";

    public static final String FIND_ALL_USERNAMES = "SELECT USERNAME FROM EMPLOYEE";

    public static final String CHANGE_PASSWORD = "UPDATE EMPLOYEE SET PASSWORD = :password WHERE ID = :id";

    public static final String AUTHENTICATE_USER = "SELECT COUNT(*) FROM EMPLOYEE WHERE USERNAME = :username AND PASSWORD = :password";
}
