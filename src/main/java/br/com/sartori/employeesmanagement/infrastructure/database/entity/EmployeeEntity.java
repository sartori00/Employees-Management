package br.com.sartori.employeesmanagement.infrastructure.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    private Integer id;

    private String fullName;

    private String occupationName;

    private BigDecimal salary;

    private List<PhoneEntity> phones;

    private AddressEntity address;
}
