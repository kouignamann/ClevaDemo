package demo.cleva.web.error;

import demo.cleva.core.exception.AventureException;
import demo.cleva.core.exception.LectureCarteException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClevaRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LectureCarteException.class)
    protected ResponseEntity<Object> handleLectureCarteException(LectureCarteException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AventureException.class)
    protected ResponseEntity<Object> handleAventureException(AventureException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
