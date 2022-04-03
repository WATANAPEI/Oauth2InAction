package dev.wpei.oauth2.auth.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorResponse createApiError(Exception e) {
        ErrorResponse response = new ErrorResponse("E-001", e.getMessage());
        return response;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception e,
            Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ErrorResponse response = createApiError(e);
        return super.handleExceptionInternal(e, response, headers, status, request);
    }
}
