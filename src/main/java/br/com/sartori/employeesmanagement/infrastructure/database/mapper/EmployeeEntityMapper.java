package br.com.sartori.employeesmanagement.infrastructure.database.mapper;

import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import br.com.sartori.employeesmanagement.infrastructure.database.entity.AddressEntity;
import br.com.sartori.employeesmanagement.infrastructure.database.entity.EmployeeEntity;
import br.com.sartori.employeesmanagement.infrastructure.database.entity.PhoneEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeEntityMapper {
    public EmployeeEntity toEntity(Employee employee) {
        return EmployeeEntity.builder()
                .id(employee.getId())
                .fullName(employee.getFullName())
                .occupationName(employee.getOccupation().toString())
                .salary(employee.getSalary())
                .phones(employee.getPhones().stream().map(this::buildPhoneEntity).collect(Collectors.toList()))
                .address(this.buildAddressEntity(employee.getAddress()))
                .build();
    }

    private PhoneEntity buildPhoneEntity(Phone phone) {
        return PhoneEntity.builder()
                .phoneType(phone.getPhoneType().toString())
                .phoneNumber(phone.getPhoneNumber())
                .build();
    }

    private AddressEntity buildAddressEntity(Address address) {
        return AddressEntity.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();
    }

    public Employee toDomain(EmployeeEntity entity) {
        var employee = new Employee();
        employee.setId(entity.getId());
        employee.setFullName(entity.getFullName());
        employee.setOccupation(Occupation.valueOf(entity.getOccupationName()));
        employee.setSalary(entity.getSalary());
        employee.setPhones(entity.getPhones().stream().map(this::buildPhoneDomain).collect(Collectors.toList()));
        employee.setAddress(this.addressDomain(entity.getAddress()));

        return employee;
    }

    private Address addressDomain(AddressEntity addressEntity) {
        var address = new Address();
        address.setStreet(addressEntity.getStreet());
        address.setNumber(addressEntity.getNumber());
        address.setDistrict(addressEntity.getDistrict());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setZipCode(addressEntity.getZipCode());

        return address;

    }

    private Phone buildPhoneDomain(PhoneEntity phoneEntity) {
        var phone = new Phone();
        phone.setPhoneType(PhoneType.valueOf(phoneEntity.getPhoneType()));
        phone.setPhoneNumber(phoneEntity.getPhoneNumber());
        return phone;
    }
}
