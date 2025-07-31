package com.mynotes.exception;

import com.mynotes.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class NotesApiExceptionHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class, RecordNotFoundException.class})
    public ErrorResponseDto handleNotFoundError(Exception ex, HttpServletRequest request){
        ErrorResponseDto errorBody = new ErrorResponseDto(
                ex.getMessage(),
                404,
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                LocalDateTime.now(),
                request.getRequestURI()
        );
        return errorBody;
    }

}
