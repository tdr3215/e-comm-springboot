//package com.tts.EcommProject.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//
//@ControllerAdvice
//public class BaseExceptionHandler {
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
////	How do I throw this error in my service?
//		
//	       BindingResult result = ex.getBindingResult();
//    List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
//    return processFieldErrors(fieldErrors);
//}
//
//private Error processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
//    Error error = new Error(HttpStatus.BAD_REQUEST.value(), "validation error");
//    for (org.springframework.validation.FieldError fieldError: fieldErrors) {
//        error.addFieldError(fieldError.getObjectName(),fieldError.getField(), fieldError.getDefaultMessage());
//    }
//    return error;
//}
//
//static class Error {
//    private final int status;
//    private final String message;
//    private List<FieldError> fieldErrors = new ArrayList<>();
//
//    Error(int status, String message) {
//        this.status = status;
//        this.message = message;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void addFieldError(String fieldName, String path, String message) {
//        FieldError error = new FieldError(fieldName,path, message);
//        fieldErrors.add(error);
//    }
//
//    public List<FieldError> getFieldErrors() {
//        return fieldErrors;
//    }
//}
//}