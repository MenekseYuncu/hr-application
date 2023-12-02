package com.violet.hrapplication.permission.model.mapandscript;

public class LeaveRequestScripts {

    private LeaveRequestScripts(){}

    public static final String SAVE = "INSERT INTO LEAVE_REQUEST (" +
            "ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID,STATE,CREATOR, CREATION_TIME) " +
            "VALUES (" +
            ":id, :employeeId, :startDate, :endDate,:leaveTypeId,:state ,:creator, :creationTime)";


    public static final String FIND_BY_EMPLOYEE_ID = "SELECT START_DATE, END_DATE,LEAVE_TYPE_ID  FROM LEAVE_REQUEST WHERE EMPLOYEE_ID = :employeeId";

    public static final String UPDATE = "UPDATE LEAVE_REQUEST SET ";

    public static final String FIND_ALL = "SELECT * FROM LEAVE_REQUEST";

    public static final String FIND_BY_ID = "SELECT ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID,STATE,CREATOR, CREATION_TIME" +
            "FROM LEAVE_REQUEST WHERE ID = :id";


}
