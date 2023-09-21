package br.com.sartori.employeesmanagement.adapters.out;

import br.com.sartori.employeesmanagement.application.ports.out.DeleteEmployeeByIdOutputPort;
import br.com.sartori.employeesmanagement.infrastructure.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmployeeByIdAdapter implements DeleteEmployeeByIdOutputPort {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
