package com.example.ecommerce_api.exceptions;

public class EmptyException extends RuntimeException {

  public EmptyException() { super("No data was found."); }

}
