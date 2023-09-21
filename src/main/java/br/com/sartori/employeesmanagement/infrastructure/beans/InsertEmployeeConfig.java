package br.com.sartori.employeesmanagement.infrastructure.beans;

import br.com.sartori.employeesmanagement.adapters.out.InsertEmployeeAdapter;
import br.com.sartori.employeesmanagement.application.core.usecase.InsertEmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertEmployeeConfig {

    @Bean
    public InsertEmployeeUseCase insertEmployeeUseCase(InsertEmployeeAdapter insertEmployeeAdapter){
        return new InsertEmployeeUseCase(insertEmployeeAdapter);
    }
}
