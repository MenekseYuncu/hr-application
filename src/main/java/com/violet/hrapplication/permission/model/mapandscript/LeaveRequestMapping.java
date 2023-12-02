package com.violet.hrapplication.permission.model.mapandscript;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    private static final Map<String, String> mapping = new HashMap<>();


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

    static {
        for (LeaveRequestMapping leaveRequestMapping : LeaveRequestMapping.values()) {
            mapping.put(leaveRequestMapping.getColumnName(), leaveRequestMapping.getPropertyName());
        }
    }

    public static Map<String, String> getMapping() {
        return mapping;
    }
}
