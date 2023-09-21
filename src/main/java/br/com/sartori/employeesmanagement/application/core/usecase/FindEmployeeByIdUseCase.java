package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.ports.in.FindEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.FindEmployeeByIdOutputPort;

public class FindEmployeeByIdUseCase implements FindEmployeeByIdInputPort {

    private final FindEmployeeByIdOutputPort findEmployeeByIdOutputPort;

    public FindEmployeeByIdUseCase(FindEmployeeByIdOutputPort findEmployeeByIdOutputPort) {
        this.findEmployeeByIdOutputPort = findEmployeeByIdOutputPort;
    }

    @Override
    public Employee findById(Integer id) {
        return findEmployeeByIdOutputPort.findById(id);
    }
}
