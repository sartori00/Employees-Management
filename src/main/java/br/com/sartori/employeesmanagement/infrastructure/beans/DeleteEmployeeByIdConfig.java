package br.com.sartori.employeesmanagement.infrastructure.beans;

import br.com.sartori.employeesmanagement.application.core.usecase.DeleteEmployeeByIdUseCase;
import br.com.sartori.employeesmanagement.application.core.usecase.FindEmployeeByIdUseCase;
import br.com.sartori.employeesmanagement.application.ports.out.DeleteEmployeeByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteEmployeeByIdConfig {

    @Bean
    public DeleteEmployeeByIdUseCase deleteEmployeeByIdUseCase(FindEmployeeByIdUseCase findEmployeeByIdUseCase,
                                                               DeleteEmployeeByIdOutputPort deleteEmployeeByIdOutputPort){
        return new DeleteEmployeeByIdUseCase(findEmployeeByIdUseCase, deleteEmployeeByIdOutputPort);
    }
}
