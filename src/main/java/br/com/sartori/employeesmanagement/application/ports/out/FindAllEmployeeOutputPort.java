package br.com.sartori.employeesmanagement.application.ports.out;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;

import java.util.List;

public interface FindAllEmployeeOutputPort {

    List<Employee> findAll();
}
