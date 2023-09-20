package br.com.sartori.employeesmanagement.infrastructure.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private String street;

    private Long number;

    private String district;

    private String city;

    private String state;

    private String zipCode;
}
