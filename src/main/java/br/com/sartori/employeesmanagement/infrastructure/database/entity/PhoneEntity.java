package br.com.sartori.employeesmanagement.infrastructure.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneEntity {

    private String phoneType;

    private String phoneNumber;
}
