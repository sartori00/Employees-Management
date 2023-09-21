package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.ports.in.FindAllEmployeeInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.FindAllEmployeeOutputPort;

public class FindAllEmployeeUseCase implements FindAllEmployeeInputPort {

    private final FindAllEmployeeOutputPort findAllEmployeeOutputPort;

    public FindAllEmployeeUseCase(FindAllEmployeeOutputPort findAllEmployeeOutputPort) {
        this.findAllEmployeeOutputPort = findAllEmployeeOutputPort;
    }


    @Override
    public Employee findAll() {
        return findAllEmployeeOutputPort.findAll();
    }
}
