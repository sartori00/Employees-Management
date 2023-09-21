package br.com.sartori.employeesmanagement.application.ports.in;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;

public interface FindAllEmployeeInputPort {

    Employee findAll();
}
