package br.com.sartori.employeesmanagement.infrastructure.database;

import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.infrastructure.database.mapper.EmployeeEntityMapper;
import br.com.sartori.employeesmanagement.infrastructure.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
