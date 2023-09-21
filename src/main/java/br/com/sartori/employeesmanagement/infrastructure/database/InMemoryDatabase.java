package br.com.sartori.employeesmanagement.infrastructure.database;

import br.com.sartori.employeesmanagement.infrastructure.database.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDatabase {

    private static List<EmployeeEntity> database = new ArrayList<>();

    public EmployeeEntity save(EmployeeEntity employeeEntity){
        employeeEntity.setId(Long.valueOf(database.size() + 1));
        database.add(employeeEntity);
        return employeeEntity;
    }


}
