package com.mitchell.examples.exception;


public class ServiceDAOException extends ServiceException
{

    
    private static final long serialVersionUID = 65718474634319846L;

    public ServiceDAOException(String message)
    {
        super(message);
    }

    public ServiceDAOException(Throwable t)
    {
        super(t);
    }

    public ServiceDAOException(String message, Throwable t)
    {
        super(message, t);
    }

}
