package edu.practice.hw12.entities;

import org.springframework.http.HttpStatus;

public class HttpResponse {
    private HttpStatus httpStatus;
    private String massege;


    public HttpResponse(HttpStatus httpStatus, String massege) {
        this.httpStatus = httpStatus;
        this.massege = massege;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }


}
