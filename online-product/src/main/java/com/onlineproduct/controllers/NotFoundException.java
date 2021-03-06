package com.onlineproduct.controllers;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException
{
	public NotFoundException(Long id) {
        super("The id " + id + " cannot be found");
    }
}
