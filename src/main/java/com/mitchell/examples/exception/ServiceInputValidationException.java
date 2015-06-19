package com.mitchell.examples.exception;


public class ServiceInputValidationException extends IllegalArgumentException
{
    
    private static final long serialVersionUID = -3519545849772318203L;

    public ServiceInputValidationException(Throwable t)
    {
        super(t);
    }

    public ServiceInputValidationException(String message)
    {
        super(message);
    }

    public ServiceInputValidationException(String message, Throwable t)
    {
        super(message, t);
    }

}
