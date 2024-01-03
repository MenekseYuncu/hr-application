package com.violet.hrapplication.approvals.controller.request;

import com.violet.hrapplication.approvals.model.enums.State;
public record FilterByStateRequest (
    State state
){
}
