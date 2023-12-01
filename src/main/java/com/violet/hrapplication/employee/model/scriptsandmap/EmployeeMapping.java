package com.violet.hrapplication.employee.model.scriptsandmap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum EmployeeMapping {

    ID("ID", "id"),
    USERNAME("USERNAME", "username"),
    PASSWORD("PASSWORD", "password"),
    FIRST_NAME("FIRST_NAME", "firstName"),
    LAST_NAME("LAST_NAME", "lastName"),
    EMAIL("EMAIL", "email"),
    BIRTHDAY("BIRTHDAY", "birthday"),
    START_WORKING_DATE("START_WORKING_DATE", "startWorkingDate"),
    ROLE("ROLE", "role"),
    GENDER("GENDER", "gender"),
    CREATOR("CREATOR", "creator"),
    CREATION_TIME("CREATION_TIME", "creationTime");

    private final String columnName;

    private final String propertyName;

    private static final List<EmployeeMapping> employeeMappings = Arrays.asList(values());


    EmployeeMapping(String columnName, String propertyName) {
        this.columnName = columnName;
        this.propertyName = propertyName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public static Map<String, String> getMapping() {
        return employeeMappings.stream().collect(
                Collectors.toMap(EmployeeMapping::getColumnName, EmployeeMapping::getPropertyName)
        );
    }
}
