package com.DevUp.test.Controller;

import com.DevUp.test.Bean.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class StudentDetailsService {
    private static List<Student> students = new ArrayList<>();

    static {
        Student student1 = new Student(1, "alex", "podman");
        students.add(student1);
        Student student2 = new Student(2, "sara", "podman");
        students.add(student2);

        Student student3 = new Student(3, "uliana", "podman");
        students.add(student3);

        Student student4 = new Student(4, "james", "bond");
        students.add(student4);

    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    List<Student> findAll() {
        return students;
    }


    public int deleteById(int id) {
  Iterator<Student> iterable=students.iterator();
  while (iterable.hasNext()){
      Student studentt=iterable.next();
      if(studentt.getId()==id){
          iterable.remove();
          return 1;
      }
  }
  return 0;
    }
}