package com.violet.hrapplication.permission.repository.script;

public class EmployeeLeaveTypeAssigmentScripts {

    private EmployeeLeaveTypeAssigmentScripts() {

    }

    public static final String SAVE = "INSERT INTO Employee_Leave_Type_Assigment (" +
            "ID,EMPLOYEE_ID, LEAVE_TYPE_ID) " +
            "VALUES " +
            "(:id, :employeeId, :leaveTypeId)" ;
}
