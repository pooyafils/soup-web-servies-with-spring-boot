package com.DevUp.test.Controller;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode= FaultCode.CUSTOM,
        customFaultCode="{http://pooyaspring.com/student}001_COURSE_NOT_FOUND")
public class StudentNotFound extends RuntimeException {
    private static final long serialVersionUID = 3518170101751491969L;

    public StudentNotFound(String message) {
        super(message);
    }
}

