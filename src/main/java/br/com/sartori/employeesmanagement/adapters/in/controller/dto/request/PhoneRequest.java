package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import jakarta.validation.constraints.NotBlank;

public record PhoneRequest(@NotBlank PhoneType phoneType,
                           @NotBlank String phoneNumber) {
}
