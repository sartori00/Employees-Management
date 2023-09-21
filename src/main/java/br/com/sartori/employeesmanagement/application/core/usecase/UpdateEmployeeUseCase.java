package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.ports.in.FindEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.in.UpdateEmployeeInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.UpdateEmployeeOutputPort;

public class UpdateEmployeeUseCase implements UpdateEmployeeInputPort {

    private final FindEmployeeByIdInputPort findEmployeeByIdInputPort;

    private final UpdateEmployeeOutputPort updateEmployeeOutputPort;

    public UpdateEmployeeUseCase(FindEmployeeByIdInputPort findEmployeeByIdInputPort,
                                 UpdateEmployeeOutputPort updateEmployeeOutputPort) {
        this.findEmployeeByIdInputPort = findEmployeeByIdInputPort;
        this.updateEmployeeOutputPort = updateEmployeeOutputPort;
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        var finded = findEmployeeByIdInputPort.findById(id);
        finded.setFullName(employee.getFullName());
        finded.setOccupation(employee.getOccupation());
        finded.setSalary(employee.getSalary());
        finded.getPhones().clear();
        finded.setPhones(employee.getPhones());
        finded.setAddress(employee.getAddress());

        var asda = updateEmployeeOutputPort.update(finded);
        //System.out.println(asda.getFullName());

        return asda;
    }
}
