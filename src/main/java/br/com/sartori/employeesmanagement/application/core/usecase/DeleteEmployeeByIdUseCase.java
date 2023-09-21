package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.ports.in.DeleteEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.in.FindEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.DeleteEmployeeByIdOutputPort;

public class DeleteEmployeeByIdUseCase implements DeleteEmployeeByIdInputPort {

    private final FindEmployeeByIdInputPort findEmployeeByIdInputPort;

    private final DeleteEmployeeByIdOutputPort deleteEmployeeByIdOutputPort;

    public DeleteEmployeeByIdUseCase(FindEmployeeByIdInputPort findEmployeeByIdInputPort, DeleteEmployeeByIdOutputPort deleteEmployeeByIdOutputPort) {
        this.findEmployeeByIdInputPort = findEmployeeByIdInputPort;
        this.deleteEmployeeByIdOutputPort = deleteEmployeeByIdOutputPort;
    }


    @Override
    public void deleteById(Integer id) {
        findEmployeeByIdInputPort.findById(id);

        deleteEmployeeByIdOutputPort.deleteById(id);
    }
}
