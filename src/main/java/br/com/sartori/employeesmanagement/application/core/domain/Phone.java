package br.com.sartori.employeesmanagement.application.core.domain;

import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;

public class Phone {

    private Long id;

    private PhoneType phoneType;

    private String phone;

    public Phone(Long id, PhoneType phoneType, String phone) {
        this.id = id;
        this.phoneType = phoneType;
        this.phone = phone;
    }

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
