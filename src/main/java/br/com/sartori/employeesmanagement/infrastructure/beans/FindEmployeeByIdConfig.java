package br.com.sartori.employeesmanagement.infrastructure.beans;

import br.com.sartori.employeesmanagement.adapters.out.FindEmployeeByIdAdapter;
import br.com.sartori.employeesmanagement.adapters.out.InsertEmployeeAdapter;
import br.com.sartori.employeesmanagement.application.core.usecase.FindEmployeeByIdUseCase;
import br.com.sartori.employeesmanagement.application.core.usecase.InsertEmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindEmployeeByIdConfig {

    @Bean
    public FindEmployeeByIdUseCase findEmployeeByIdUseCase(FindEmployeeByIdAdapter findEmployeeByIdAdapter){
        return new FindEmployeeByIdUseCase(findEmployeeByIdAdapter);
    }
}
