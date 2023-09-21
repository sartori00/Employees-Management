package br.com.sartori.employeesmanagement.application.core.domain;

import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;

public class Phone {

    private PhoneType phoneType;

    private String phone;

    public Phone(PhoneType phoneType, String phone) {
        this.phoneType = phoneType;
        this.phone = phone;
    }

    public Phone() {
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
