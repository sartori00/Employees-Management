package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AddressRequest(@NotBlank String street,
                             @Positive Long number,
                             @NotBlank String district,
                             @NotBlank String city,
                             @NotBlank String state,
                             @NotBlank String zipCode) {
}
