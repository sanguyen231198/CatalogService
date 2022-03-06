package com.humana.dhp.eventproc.service.catalogservice.exeption;

public class BadRequestException extends CatalogException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
