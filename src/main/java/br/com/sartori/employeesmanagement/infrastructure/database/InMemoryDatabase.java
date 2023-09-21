package br.com.sartori.employeesmanagement.infrastructure.database;

import br.com.sartori.employeesmanagement.application.core.exceptions.EntityNotFoundException;
import br.com.sartori.employeesmanagement.infrastructure.database.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDatabase {

    private static final List<EmployeeEntity> database = new ArrayList<>();

    public EmployeeEntity save(EmployeeEntity employeeEntity){
        employeeEntity.setId(database.size() + 1);
        database.add(employeeEntity);
        return employeeEntity;
    }


    public EmployeeEntity findById(Integer id) {
        try {
            return database.get(id - 1);
        } catch (IndexOutOfBoundsException e){
            throw new EntityNotFoundException("Funcionário não encontrado");
        }
    }

    public List<EmployeeEntity> findAll() {
        return database;
    }

    public EmployeeEntity update(EmployeeEntity entity) {
        var finded = this.findById(entity.getId());
        finded.setFullName(entity.getFullName());
        finded.setOccupationName(entity.getOccupationName());
        finded.setSalary(entity.getSalary());
        finded.getPhones().clear();
        finded.setPhones(entity.getPhones());
        finded.setAddress(entity.getAddress());
        return finded;
    }

    public void deleteById(Integer id) {
        var finded = this.findById(id);
        database.remove(finded);
    }
}
