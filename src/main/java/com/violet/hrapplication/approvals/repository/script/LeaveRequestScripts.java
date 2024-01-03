package com.violet.hrapplication.approvals.repository.script;

public class LeaveRequestScripts {

    private LeaveRequestScripts() {
    }

    public static final String FIND_ALL = "SELECT ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID, STATE, CREATOR, CREATION_TIME " +
            "FROM LEAVE_REQUEST" +
            " ORDER BY ID LIMIT :limit OFFSET :offset";

    public static final String FIND_BY_ID = "SELECT ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID, STATE, CREATOR, CREATION_TIME " +
            "FROM LEAVE_REQUEST WHERE ID = :id";

    public static final String FIND_BY_EMPLOYEE_ID = "SELECT ID, EMPLOYEE_ID, START_DATE, END_DATE, STATE, LEAVE_TYPE_ID " +
            "FROM LEAVE_REQUEST " +
            "WHERE EMPLOYEE_ID = :employeeId" +
            " ORDER BY ID LIMIT :limit OFFSET :offset";

    public static final String FIND_BY_DATE = "SELECT ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID, STATE, CREATOR, CREATION_TIME FROM LEAVE_REQUEST " +
            "WHERE :date BETWEEN START_DATE AND END_DATE " +
            "AND STATE IN ('APPROVED', 'PENDING')";

    public static final String FIND_BY_STATE = "SELECT ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID, STATE, CREATOR, CREATION_TIME " +
            "FROM LEAVE_REQUEST WHERE STATE = :state";

    public static final String SAVE = "INSERT INTO LEAVE_REQUEST (" +
            "ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID,STATE,CREATOR, CREATION_TIME) " +
            "VALUES (" +
            ":id, :employeeId, :startDate, :endDate,:leaveTypeId,:state ,:creator, :creationTime)";

    public static final String UPDATE = "UPDATE LEAVE_REQUEST SET STATE = :state WHERE ID = :id";

    public static final String IS_EXIST_BY_DATE = "SELECT COUNT(*) > 0 AS RESULT FROM LEAVE_REQUEST " +
            "WHERE EMPLOYEE_ID = :employeeId AND " +
            "(START_DATE =:startDate OR END_DATE =:endDate)";


}
