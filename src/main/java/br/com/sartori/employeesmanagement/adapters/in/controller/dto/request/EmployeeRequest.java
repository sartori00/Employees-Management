package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record EmployeeRequest(@NotBlank String fullName,
                              @NotNull Occupation occupation,
                              @Positive BigDecimal salary,
                              @Valid List<PhoneRequest> phones,
                              @Valid AddressRequest address) {
}
