package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import br.com.sartori.employeesmanagement.application.ports.out.InsertEmployeeOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InsertEmployeeUseCaseTest {

    private InsertEmployeeUseCase insertEmployeeUseCase;

    @Mock
    InsertEmployeeOutputPort insertEmployeeOutputPort;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.insertEmployeeUseCase = new InsertEmployeeUseCase(insertEmployeeOutputPort);
    }

    @Test
    public void shouldInsertEmployee(){
        var toSave = this.employeeToSave();

        Mockito.when(insertEmployeeOutputPort.save(toSave)).thenReturn(this.employeeSaved());

        var saved = insertEmployeeUseCase.insert(toSave);

        Mockito.verify(insertEmployeeOutputPort).save(toSave);
        assertNotNull(saved.getId());
        assertEquals(toSave.getFullName(), saved.getFullName());
        assertEquals(toSave.getOccupation(), saved.getOccupation());
        assertEquals(toSave.getSalary(), saved.getSalary());
        assertEquals(toSave.getPhones().size(), saved.getPhones().size());
        assertEquals(toSave.getAddress().getStreet(), saved.getAddress().getStreet());
    }

    private Employee employeeToSave(){
        var employee = new Employee();
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


}