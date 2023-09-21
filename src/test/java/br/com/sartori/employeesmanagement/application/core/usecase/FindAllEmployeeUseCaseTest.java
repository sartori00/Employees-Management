package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import br.com.sartori.employeesmanagement.application.ports.out.FindAllEmployeeOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class FindAllEmployeeUseCaseTest {

    private FindAllEmployeeUseCase findAllEmployeeUseCase;

    @Mock
    FindAllEmployeeOutputPort findAllEmployeeOutputPort;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.findAllEmployeeUseCase = new FindAllEmployeeUseCase(findAllEmployeeOutputPort);
    }

    @Test
    public void shouldGetAllOfEmployees(){
        Mockito.when(findAllEmployeeOutputPort.findAll()).thenReturn(this.employeesList());

        var finded = findAllEmployeeUseCase.findAll();

        assertEquals(2, finded.size());
        assertInstanceOf(List.class, finded);
        assertInstanceOf(Employee.class, finded.get(0));
    }

    @Test
    public void shouldGetEmptyListWhenDbIsEmpty(){
        Mockito.when(findAllEmployeeOutputPort.findAll()).thenReturn(new ArrayList<Employee>());

        var finded = findAllEmployeeUseCase.findAll();

        assertEquals(0, finded.size());
    }

    private List<Employee> employeesList(){
        List<Employee> employees = new ArrayList<>();

        var employee1 = new Employee();
        employee1.setId(1);
        employee1.setFullName("João da Silva");
        employee1.setOccupation(Occupation.MANAGEMENT);
        employee1.setSalary(BigDecimal.valueOf(15000));
        employee1.setPhones(this.buildPhones());
        employee1.setAddress(new Address("Avenida Paulista", 1230L, "Bela Vista", "São Paulo", "SP", "01310=100"));

        var employee2 = new Employee();
        employee2.setId(1);
        employee2.setFullName("Maria da Silva");
        employee2.setOccupation(Occupation.SENIOR);
        employee2.setSalary(BigDecimal.valueOf(140000));
        employee2.setPhones(this.buildPhones());
        employee2.setAddress(new Address("Avenida Paulista", 1231L, "Bela Vista", "São Paulo", "SP", "01310=100"));

        employees.add(employee1);
        employees.add(employee2);

        return employees;
    }

    private List<Phone> buildPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(PhoneType.HOME, "1156642255"));
        phones.add(new Phone(PhoneType.CELL, "11965286445"));
        return phones;
    }
}