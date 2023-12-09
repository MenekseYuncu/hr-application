package com.violet.hrapplication.permission.repository.mapping;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LeaveRequestMapping {

    ID("ID", "id"),
    EMPLOYEE_ID("EMPLOYEE_ID", "employeeId"),
    START_DATE("START_DATE", "startDate"),
    END_DATE("END_DATE", "endDate"),
    LEAVE_TYPE_ID("LEAVE_TYPE_ID", "leaveTypeId"),
    STATE("STATE", "state"),
    CREATOR("CREATOR", "creator"),
    CREATION_TIME("CREATION_TIME", "creationTime");

    private final String columnName;

    private final String propertyName;

    LeaveRequestMapping(String columnName, String propertyName) {
        this.columnName = columnName;
        this.propertyName = propertyName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public static final Map<String, String> COLUMN_MAPPING = Arrays.stream(values())
            .collect(Collectors.toMap(LeaveRequestMapping::getColumnName, LeaveRequestMapping::getPropertyName));
}
