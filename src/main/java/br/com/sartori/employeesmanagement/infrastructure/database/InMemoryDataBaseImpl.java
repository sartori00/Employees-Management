package br.com.sartori.employeesmanagement.infrastructure.database;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.infrastructure.database.entity.EmployeeEntity;
import br.com.sartori.employeesmanagement.infrastructure.database.mapper.EmployeeEntityMapper;
import br.com.sartori.employeesmanagement.infrastructure.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryDataBaseImpl implements EmployeeRepository {

    @Autowired
    private InMemoryDatabase database;

    @Autowired
    private EmployeeEntityMapper mapper;


    @Override
    public Employee save(Employee employee) {
        var entity = mapper.toEntity(employee);
        var saved = database.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Employee findById(Integer id) {
        EmployeeEntity employee = database.findById(id);
        return mapper.toDomain(employee);
    }

    @Override
    public List<Employee> findAll() {
        var entities = database.findAll();
        return entities.stream().map(entity -> mapper.toDomain(entity)).collect(Collectors.toList());
    }

    @Override
    public Employee update(Employee employee) {
        var entity = mapper.toEntity(employee);
        var saved = database.update(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteById(Integer id) {
        database.deleteById(id);
    }
}
