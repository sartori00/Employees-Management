package br.com.sartori.employeesmanagement.application.ports.out;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;

public interface InsertEmployeeOutputPort {

    Employee save(Employee employee);
}
