package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;

import java.math.BigDecimal;
import java.util.List;

public record EmployeeRequest(String fullName, Occupation occupation, BigDecimal salary, List<PhoneRequest> phones, AddressRequest address) {
}
