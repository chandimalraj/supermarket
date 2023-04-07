package com.chandimal.supermarket.advisor;

import com.chandimal.supermarket.exception.DuplicateDataException;
import com.chandimal.supermarket.exception.NotFoundException;
import com.chandimal.supermarket.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<StandardResponse> handleDuplicateDataException(DuplicateDataException e){
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(500,"Duplicate Data Insert", e.getMessage() ),
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleCustomerNotFoundException(NotFoundException e){
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(404,"Customer not found", e.getMessage() ),
                HttpStatus.NOT_FOUND
        );
        return response;
    }
}
