package br.com.sartori.employeesmanagement.adapters.in.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProblemDTO{
    private String message;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private LocalDateTime dateTime;

}