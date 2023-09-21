package br.com.sartori.employeesmanagement.infrastructure.database.repository;


import br.com.sartori.employeesmanagement.application.core.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee save(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();

    Employee update(Employee employee);
}
