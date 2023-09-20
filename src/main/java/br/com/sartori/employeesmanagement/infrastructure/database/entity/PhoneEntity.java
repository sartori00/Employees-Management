package br.com.sartori.employeesmanagement.infrastructure.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneEntity {

    private Long id;

    private String phoneType;

    private String phone;
}
