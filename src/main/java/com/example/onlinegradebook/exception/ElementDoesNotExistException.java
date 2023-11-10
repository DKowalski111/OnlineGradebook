package com.example.onlinegradebook.exception;

public class ElementDoesNotExistException extends Exception
{
    public ElementDoesNotExistException() {}

    // Constructor that accepts a message
    public ElementDoesNotExistException(String message)
    {
        super(message);
    }
}
