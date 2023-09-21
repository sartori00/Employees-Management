package br.com.sartori.employeesmanagement.adapters.in.controller.dto.response;

import br.com.sartori.employeesmanagement.application.core.domain.Address;

public record AddressResponse(String street, Long number, String district, String city, String state, String zipCode) {
    public AddressResponse(Address address){
        this(address.getStreet(), address.getNumber(), address.getDistrict(), address.getCity(), address.getState(), address.getZipCode());
    }
}

