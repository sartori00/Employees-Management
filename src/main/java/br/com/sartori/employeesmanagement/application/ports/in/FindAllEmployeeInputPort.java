package br.com.sartori.employeesmanagement.application.ports.in;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;

import java.util.List;

public interface FindAllEmployeeInputPort {

    List<Employee> findAll();
}
