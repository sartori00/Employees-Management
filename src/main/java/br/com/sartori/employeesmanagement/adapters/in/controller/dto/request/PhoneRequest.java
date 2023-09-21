package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PhoneRequest(@NotNull PhoneType phoneType,
                           @NotBlank String phoneNumber) {
}
