package br.com.sartori.employeesmanagement.application.core.usecase;

import br.com.sartori.employeesmanagement.application.core.domain.Address;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.core.domain.Phone;
import br.com.sartori.employeesmanagement.application.core.domain.enums.Occupation;
import br.com.sartori.employeesmanagement.application.core.domain.enums.PhoneType;
import br.com.sartori.employeesmanagement.application.core.exceptions.EntityNotFoundException;
import br.com.sartori.employeesmanagement.application.ports.out.FindEmployeeByIdOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindEmployeeByIdUseCaseTest {

    private FindEmployeeByIdUseCase findEmployeeByIdUseCase;

    @Mock
    FindEmployeeByIdOutputPort findEmployeeByIdOutputPort;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.findEmployeeByIdUseCase = new FindEmployeeByIdUseCase(findEmployeeByIdOutputPort);
    }


    @Test
    public void shouldGetEmployeeById(){
        var list = this.employeesList();

        Mockito.when(findEmployeeByIdOutputPort.findById(1)).thenReturn(list.get(0));

        var finded = findEmployeeByIdUseCase.findById(1);

        assertEquals(1, finded.getId());
    }

    @Test
    public void shouldThrowsExceptionWhenGetIdNotFound(){
        Mockito.when(findEmployeeByIdOutputPort.findById(Mockito.any())).thenThrow(EntityNotFoundException.class);

        try{
            assertThrows(EntityNotFoundException.class, () -> findEmployeeByIdUseCase.findById(Mockito.any()));
        }catch (Exception ignored){}
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