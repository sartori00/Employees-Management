package br.com.sartori.employeesmanagement.adapters.in.controller.exceptions;

import org.springframework.validation.FieldError;

public record ErrorsValidateData(String field, String message){
    public ErrorsValidateData(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}