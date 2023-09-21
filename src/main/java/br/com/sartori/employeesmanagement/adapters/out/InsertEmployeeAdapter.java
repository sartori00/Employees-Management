package br.com.sartori.employeesmanagement.adapters.out;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.ports.out.InsertEmployeeOutputPort;
import br.com.sartori.employeesmanagement.infrastructure.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertEmployeeAdapter implements InsertEmployeeOutputPort {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
