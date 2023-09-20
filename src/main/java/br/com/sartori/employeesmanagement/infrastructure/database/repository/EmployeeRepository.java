package br.com.sartori.employeesmanagement.infrastructure.database.repository;


import br.com.sartori.employeesmanagement.application.core.domain.Employee;

public interface EmployeeRepository {
    Employee save(Employee employee);
}
