package com.beerhouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FieldPatchParseException extends RuntimeException{

    public FieldPatchParseException(String field) {
        super("Error parsing field: " + field);
    }
}
