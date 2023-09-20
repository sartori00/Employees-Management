package br.com.sartori.employeesmanagement.application.core.domain;

import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;

import java.math.BigDecimal;
import java.util.List;

public class Employee {

    private Long id;

    private String fullName;

    private Occupation occupation;

    private BigDecimal salary;

    private List<Phone> phones;

    private Address address;

    public Employee(Long id, String fullName, Occupation occupation, BigDecimal salary, List<Phone> phones, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.occupation = occupation;
        this.salary = salary;
        this.phones = phones;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
