package br.com.sartori.employeesmanagement.adapters.in.controller.dto.response;

import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;

public record PhoneResponse(PhoneType phoneType, String phone) {
    public PhoneResponse(Phone phoneNumber) {
        this(phoneNumber.getPhoneType(), phoneNumber.getPhone());
    }
}
