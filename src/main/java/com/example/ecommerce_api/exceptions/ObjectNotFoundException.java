package com.example.ecommerce_api.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String objectName, long id) {
        super("Could not find " + objectName + " with id: " + id);
    }

}