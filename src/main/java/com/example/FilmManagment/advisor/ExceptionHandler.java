package com.example.FilmManagment.advisor;

import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.model.response.MetaResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.WebSocket;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    public ExceptionHandler() {
        super();
    }

    @Override
    public void setMessageSource(@NotNull MessageSource messageSource) {
        super.setMessageSource(messageSource);
    }

    @Override
    protected MessageSource getMessageSource() {
        return super.getMessageSource();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(@NotNull HttpRequestMethodNotSupportedException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Method not supported exception"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(@NotNull HttpMediaTypeNotSupportedException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Media not supported this type exception"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(@NotNull HttpMediaTypeNotAcceptableException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Media not acceptable this type exception"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(@NotNull MissingPathVariableException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Missing path variable"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(@NotNull MissingServletRequestParameterException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Missing servlet request parameter"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(@NotNull MissingServletRequestPartException ex,@NotNull HttpHeaders headers,@NotNull HttpStatusCode status,@NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Missing servlet request part"));
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(@NotNull ServletRequestBindingException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Servlet request binding exception"));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NotNull MethodArgumentNotValidException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Method argument not valid"));
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(@NotNull NoHandlerFoundException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "No handler found exception"));
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(@NotNull AsyncRequestTimeoutException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Async request timeout exception"));
    }

    @Override
    protected ResponseEntity<Object> handleErrorResponseException(@NotNull ErrorResponseException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Error response exception"));
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(@NotNull ConversionNotSupportedException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Conversion not supported"));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(@NotNull TypeMismatchException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Type mismatch"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(@NotNull HttpMessageNotReadableException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Http message not readable"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(@NotNull HttpMessageNotWritableException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Http message not writable"));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(@NotNull Exception ex, Object body, @NotNull HttpHeaders headers, @NotNull HttpStatusCode statusCode, @NotNull WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Exception internal"));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    protected ResponseEntity<MetaResponse> handleResourceNotFound(ResourceNotFoundException exception, WebSocket ignoredWebSocket){
        return ResponseEntity
                .status(NOT_FOUND)
                .body(new MetaResponse(Boolean.FALSE, NOT_FOUND.value(), exception.getLocalizedMessage().toUpperCase()));
    }

}
