package br.com.sartori.employeesmanagement.application.ports.in;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;

public interface UpdateEmployeeInputPort {

    Employee update(Employee employee, Integer id);
}
