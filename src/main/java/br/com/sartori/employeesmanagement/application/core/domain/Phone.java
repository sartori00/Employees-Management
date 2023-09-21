package br.com.sartori.employeesmanagement.application.core.domain;

import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;

public class Phone {

    private PhoneType phoneType;

    private String phoneNumber;

    public Phone(PhoneType phoneType, String phoneNumber) {
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
    }

    public Phone() {
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
