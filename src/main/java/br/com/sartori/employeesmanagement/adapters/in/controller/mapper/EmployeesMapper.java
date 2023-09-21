package br.com.sartori.employeesmanagement.adapters.in.controller.mapper;

import br.com.sartori.employeesmanagement.adapters.in.controller.dto.request.AddressRequest;
import br.com.sartori.employeesmanagement.adapters.in.controller.dto.request.EmployeeRequest;
import br.com.sartori.employeesmanagement.adapters.in.controller.dto.request.PhoneRequest;
import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeesMapper {

    public Employee toEmployee(EmployeeRequest employeeRequest){
        var employee = new Employee();
        employee.setFullName(employeeRequest.fullName());
        employee.setOccupation(employeeRequest.occupation());
        employee.setSalary(employeeRequest.salary());
        employee.setPhones(this.toEmployeePhones(employeeRequest.phones()));
        employee.setAddress(this.toEmployeeAddress(employeeRequest.address()));

        return employee;
    }

    private Address toEmployeeAddress(AddressRequest addressRequest) {
        var address = new Address();
        address.setStreet(addressRequest.street());
        address.setNumber(addressRequest.number());
        address.setDistrict(addressRequest.district());
        address.setCity(addressRequest.city());
        address.setState(addressRequest.state());
        address.setZipCode(addressRequest.zipCode());
        return address;
    }

    private List<Phone> toEmployeePhones(List<PhoneRequest> phones) {
        return phones.stream()
                .map(number -> new Phone(number.phoneType(), number.phone()))
                .collect(Collectors.toList());
    }

}
