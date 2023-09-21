package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import br.com.sartori.employeesmanagement.application.ports.in.FindEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.DeleteEmployeeByIdOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class DeleteEmployeeByIdUseCaseTest {

    private DeleteEmployeeByIdUseCase deleteEmployeeByIdUseCase;

    @Mock
    FindEmployeeByIdInputPort findEmployeeByIdInputPort;

    @Mock
    DeleteEmployeeByIdOutputPort deleteEmployeeByIdOutputPort;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.deleteEmployeeByIdUseCase = new DeleteEmployeeByIdUseCase(findEmployeeByIdInputPort, deleteEmployeeByIdOutputPort);
    }

    @Test
    public void shouldDeleteEmployee(){
        Integer id = 1;
        Mockito.when(findEmployeeByIdInputPort.findById(id)).thenReturn(this.employeeSaved());

        deleteEmployeeByIdUseCase.deleteById(id);

        Mockito.verify(deleteEmployeeByIdOutputPort).deleteById(Mockito.any());
    }

    private Employee employeeSaved(){
        var employee = new Employee();
        employee.setId(1);
        employee.setFullName("João da Silva");
        employee.setOccupation(Occupation.MANAGEMENT);
        employee.setSalary(BigDecimal.valueOf(15000));
        employee.setPhones(this.buildPhones());
        employee.setAddress(new Address("Avenida Paulista", 1230L, "Bela Vista", "São Paulo", "SP", "01310=100"));
        return employee;
    }

    private List<Phone> buildPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(PhoneType.HOME, "1156642255"));
        phones.add(new Phone(PhoneType.CELL, "11965286445"));
        return phones;
    }

}