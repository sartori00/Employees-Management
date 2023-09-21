package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import br.com.sartori.employeesmanagement.application.ports.in.FindEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.out.UpdateEmployeeOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class UpdateEmployeeUseCaseTest {

    private UpdateEmployeeUseCase updateEmployeeUseCase;

    @Mock
    FindEmployeeByIdInputPort findEmployeeByIdInputPort;

    @Mock
    UpdateEmployeeOutputPort updateEmployeeOutputPort;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.updateEmployeeUseCase = new UpdateEmployeeUseCase(findEmployeeByIdInputPort, updateEmployeeOutputPort);
    }

    @Test
    public void shouldUpdateEmployeeWithoutChangeId(){
        Integer id = 1;
        Mockito.when(findEmployeeByIdInputPort.findById(id)).thenReturn(this.employeeSaved());
        Mockito.when(updateEmployeeOutputPort.update(Mockito.any())).thenReturn(this.employeeChanged());

        var saved = this.employeeSaved();

        Employee updated = updateEmployeeUseCase.update(this.employeeChanged(), id);

        assertEquals(id, updated.getId());
        assertNotEquals(saved.getFullName(), updated.getFullName());
        assertNotEquals(saved.getOccupation(), updated.getOccupation());
        assertNotEquals(saved.getSalary(), updated.getSalary());
        assertNotEquals(saved.getAddress().getNumber(), updated.getAddress().getNumber());
    }


    private List<Phone> buildPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(PhoneType.HOME, "1156642255"));
        phones.add(new Phone(PhoneType.CELL, "11965286445"));
        return phones;
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

    private Employee employeeChanged(){
        var employee = new Employee();
        employee.setId(1);
        employee.setFullName("Maria da Silva");
        employee.setOccupation(Occupation.SENIOR);
        employee.setSalary(BigDecimal.valueOf(14000));
        employee.setPhones(this.buildPhones());
        employee.setAddress(new Address("Avenida Paulista", 1231L, "Bela Vista", "São Paulo", "SP", "01310=100"));
        return employee;
    }

}