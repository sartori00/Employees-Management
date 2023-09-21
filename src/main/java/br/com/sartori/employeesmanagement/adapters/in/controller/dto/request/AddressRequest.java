package br.com.sartori.employeesmanagement.adapters.in.controller.dto.request;

public record AddressRequest(String street, Long number, String district, String city, String state, String zipCode) {
}
