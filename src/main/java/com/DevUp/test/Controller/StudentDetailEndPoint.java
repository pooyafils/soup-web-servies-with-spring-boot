package com.DevUp.test.Controller;

import com.DevUp.test.Bean.Student;
import com.pooyaspring.student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class StudentDetailEndPoint {
    @Autowired
    StudentDetailsService studentDetailsService;
    @PayloadRoot(namespace = "http://pooyaspring.com/student",
            localPart = "GetStudentDetailsRequest")
    @ResponsePayload
    public GetStudentDetailsResponse processStudentDetailRequest(@RequestPayload GetStudentDetailsRequest request){
        Student student= studentDetailsService.findById(request.getId());
        if(student==null)
            throw new StudentNotFound("Invalid student id "+request.getId());
        return  mapStudentDetailRequest(student);
    }



    private  GetStudentDetailsResponse mapStudentDetailRequest(Student student){
        GetStudentDetailsResponse response=new GetStudentDetailsResponse();
        StudentDetails studentDetails = mapStudent(student);
        response.setStudentDetails(studentDetails);
        return  response;
    }


    //get all
    @PayloadRoot(namespace = "http://pooyaspring.com/student",
            localPart = "AllGetStudentDetailsRequest")
    @ResponsePayload
    public AllGetStudentDetailsResponse AllprocessStudentDetailRequest(@RequestPayload AllGetStudentDetailsRequest request){
        List<Student> student= studentDetailsService.findAll();

        return  AllmapStudentDetail(student);
    }

    private StudentDetails mapStudent(Student student) {
        StudentDetails studentDetails=new StudentDetails();
        studentDetails.setId(student.getId());
        studentDetails.setName(student.getName());
        studentDetails.setFamilyname(student.getFamilyname());
        return studentDetails;
    }
    private AllGetStudentDetailsResponse AllmapStudentDetail(List<Student> student) {
        AllGetStudentDetailsResponse response=new AllGetStudentDetailsResponse();
        for (Student student1: student){
           StudentDetails mapStudent= mapStudent(student1);
           response.getStudentDetails().add(mapStudent);
        }
        return response;
    }

    //delete
    @PayloadRoot(namespace = "http://pooyaspring.com/student",
            localPart = "DeleteStudentDetailsRequest")
    @ResponsePayload
    public DeleteStudentDetailsResponse deleteprocessStudentDetailRequest(@RequestPayload DeleteStudentDetailsRequest request){
        int status= studentDetailsService.deleteById(request.getId());
        DeleteStudentDetailsResponse response=new DeleteStudentDetailsResponse();
        response.setStatus(status);
        return  response;
    }


}
