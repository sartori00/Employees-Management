package br.com.sartori.employeesmanagement.infrastructure.beans;

import br.com.sartori.employeesmanagement.adapters.out.FindAllEmployeeAdapter;
import br.com.sartori.employeesmanagement.application.core.usecase.FindAllEmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllEmployeeConfig {

    @Bean
    public FindAllEmployeeUseCase findAllEmployeeUseCase(FindAllEmployeeAdapter findAllEmployeeAdapter){
        return new FindAllEmployeeUseCase(findAllEmployeeAdapter);
    }
}
