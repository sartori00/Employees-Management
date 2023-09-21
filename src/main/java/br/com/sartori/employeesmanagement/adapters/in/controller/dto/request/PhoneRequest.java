package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;

public record PhoneRequest(PhoneType phoneType, String phoneNumber) {
}
