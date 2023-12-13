package com.violet.hrapplication.approvals.repository.script;

public class LeaveTypeScripts {

    private LeaveTypeScripts() {
    }

    public static final String SAVE = "INSERT INTO LEAVE_TYPE (" +
            "ID, NAME, MAX_DAYS, CREATOR, CREATION_TIME) " +
            "VALUES (" +
            ":id, :name, :maxDays, :creator, :creationTime)";

    public static final String UPDATE = "UPDATE LEAVE_TYPE SET NAME = :name, MAX_DAYS = :maxDays WHERE ID = :id";

    public static final String FIND_BY_ID = "SELECT ID, NAME, MAX_DAYS, CREATOR, CREATION_TIME FROM LEAVE_TYPE WHERE ID = :id";

    public static final String DELETE = "DELETE FROM LEAVE_TYPE WHERE ID = :id";
}
