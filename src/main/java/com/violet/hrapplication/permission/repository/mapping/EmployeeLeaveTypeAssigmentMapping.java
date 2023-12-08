package com.violet.hrapplication.permission.repository.mapping;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum EmployeeLeaveTypeAssigmentMapping {

    ID("ID", "id"),
    EMPLOYEE_ID("EMPLOYEE_ID", "employeeId"),
    LEAVE_TYPE_ID("LEAVE_TYPE_ID", "leaveTypeId");

    private final String columnName;

    private final String propertyName;

    EmployeeLeaveTypeAssigmentMapping(String columnName, String propertyName) {
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
            .collect(Collectors.toMap(EmployeeLeaveTypeAssigmentMapping::getColumnName, EmployeeLeaveTypeAssigmentMapping::getPropertyName));

}
