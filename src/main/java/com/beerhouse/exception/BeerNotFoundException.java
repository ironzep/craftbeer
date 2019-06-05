package com.beerhouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException(Long id) {
        super("Could not find beer " + id);
        }

}
