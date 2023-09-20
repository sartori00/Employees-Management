package br.com.sartori.employeesmanagement.infrastructure.database;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.infrastructure.database.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class InMemoryDataBaseImpl implements EmployeeRepository {


    @Override
    public Employee save(Employee employee) {
        return null;
    }
}
