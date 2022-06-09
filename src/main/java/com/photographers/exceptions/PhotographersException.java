package com.photographers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PhotographersException extends RuntimeException {

    private String exceptionDetail;
    private Object fieldValue;
    public PhotographersException( String exceptionDetail, Long fieldValue) {
        super(exceptionDetail+" - "+fieldValue);
        this.exceptionDetail = exceptionDetail;
        this.fieldValue = fieldValue;
    }
    public PhotographersException( String exceptionDetail, Throwable e) {
        super(exceptionDetail);
        this.exceptionDetail = exceptionDetail;
    }
    public String getExceptionDetail() {
        return exceptionDetail;
    }
    public Object getFieldValue() {
        return fieldValue;
    }
}
