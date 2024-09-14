    package com.casa.demospring.demo.services.exceptions;

public class ConflictException extends RuntimeException{
    public ConflictException(Object id){
        super("Cannot delete user "+id+" because there are associated orders.");
    }
}
