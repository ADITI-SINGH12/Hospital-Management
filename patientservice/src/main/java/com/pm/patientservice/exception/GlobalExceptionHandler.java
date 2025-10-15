package com.pm.patientservice.exception;

import com.pm.patientservice.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(EmailAlreadyExistsException.class)
public ResponseEntity<ErrorResponseDTO> handlesEmailAlreadyExistsException(EmailAlreadyExistsException exception,
                                                                           WebRequest webRequest){
    ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(
            webRequest.getDescription(false), HttpStatus.BAD_REQUEST,exception.getMessage(), LocalDateTime.now());
    return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(PatientNotFoundException.class)
public ResponseEntity<ErrorResponseDTO> handlesEmailAlreadyExistsException(PatientNotFoundException exception,
                                                                               WebRequest webRequest){
        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(
                webRequest.getDescription(false), HttpStatus.BAD_REQUEST,exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

}
