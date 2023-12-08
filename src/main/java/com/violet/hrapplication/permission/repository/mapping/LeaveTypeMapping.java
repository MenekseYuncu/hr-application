package com.violet.hrapplication.permission.repository.mapping;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LeaveTypeMapping {

    ID("ID", "id"),
    NAME("NAME", "name"),
    MAX_DAYS("MAX_DAYS", "maxDays"),
    CREATOR("CREATOR", "creator"),
    CREATION_TIME("CREATION_TIME", "creationTime");

    private final String columnName;

    private final String propertyName;

    LeaveTypeMapping(String columnName, String propertyName) {
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
            .collect(Collectors.toMap(LeaveTypeMapping::getColumnName, LeaveTypeMapping::getPropertyName));
}
