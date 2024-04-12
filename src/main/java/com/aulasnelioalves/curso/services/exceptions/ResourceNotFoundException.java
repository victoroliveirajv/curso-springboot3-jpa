package com.aulasnelioalves.curso.services.exceptions;

import java.util.Optional;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Error not found: "+ id);
    }
}
