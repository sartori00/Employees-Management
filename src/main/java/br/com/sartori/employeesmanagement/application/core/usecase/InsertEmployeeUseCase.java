package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.ports.in.InsertEmployeeInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.InsertEmployeeOutputPort;

public class InsertEmployeeUseCase implements InsertEmployeeInputPort {

    private final InsertEmployeeOutputPort insertEmployeeOutputPort;

    public InsertEmployeeUseCase(InsertEmployeeOutputPort insertEmployeeOutputPort) {
        this.insertEmployeeOutputPort = insertEmployeeOutputPort;
    }


    @Override
    public Employee insert(Employee employee) {
        return insertEmployeeOutputPort.save(employee);
    }
}
