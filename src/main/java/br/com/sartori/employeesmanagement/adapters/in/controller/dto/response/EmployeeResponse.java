package br.com.sartori.employeesmanagement.adapters.in.controller.dto.response;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record EmployeeResponse(Long id, String fullName, Occupation occupation, BigDecimal salary, List<PhoneResponse> phones, AddressResponse address) {
    public EmployeeResponse(Employee employee) {
        this(employee.getId(), employee.getFullName(), employee.getOccupation(), employee.getSalary(), employee.getPhones().stream().map(PhoneResponse::new).collect(Collectors.toList()), new AddressResponse(employee.getAddress()));
    }
}
