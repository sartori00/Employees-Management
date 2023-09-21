package br.com.sartori.employeesmanagement.application.core.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException (String message) {
        super(message);
    }
}
