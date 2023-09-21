package br.com.sartori.employeesmanagement.infrastructure.beans;

import br.com.sartori.employeesmanagement.adapters.out.UpdateEmployeeAdapter;
import br.com.sartori.employeesmanagement.application.core.usecase.FindEmployeeByIdUseCase;
import br.com.sartori.employeesmanagement.application.core.usecase.UpdateEmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateEmployeeConfig {

    @Bean
    public UpdateEmployeeUseCase updateEmployeeUseCase(FindEmployeeByIdUseCase findEmployeeByIdUseCase,
                                                       UpdateEmployeeAdapter updateEmployeeAdapter){
        return new UpdateEmployeeUseCase(findEmployeeByIdUseCase, updateEmployeeAdapter);
    }
}
