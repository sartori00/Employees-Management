package br.com.sartori.employeesmanagement.adapters.in.controller.dto.response;

import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;

public record PhoneResponse(PhoneType phoneType, String phoneNumber) {
    public PhoneResponse(Phone phone) {
        this(phone.getPhoneType(), phone.getPhoneNumber());
    }
}
