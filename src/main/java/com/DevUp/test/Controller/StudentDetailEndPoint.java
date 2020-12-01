package com.DevUp.test.Controller;

import com.pooyaspring.student.GetStudentDetailsRequest;
import com.pooyaspring.student.GetStudentDetailsResponse;
import com.pooyaspring.student.StudentDetails;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentDetailEndPoint {
    @PayloadRoot(namespace = "http://pooyaspring.com/student",
            localPart = "GetStudentDetailsRequest")
    @ResponsePayload
    public GetStudentDetailsResponse processStudentDetailRequest(@RequestPayload GetStudentDetailsRequest request){
        GetStudentDetailsResponse response=new GetStudentDetailsResponse();
        StudentDetails studentDetails=new StudentDetails();
        studentDetails.setId(request.getId());
        studentDetails.setName("alex");
        studentDetails.setFamilyname("padson");
        response.setStudentDetails(studentDetails);
        return  response;
    }
}
