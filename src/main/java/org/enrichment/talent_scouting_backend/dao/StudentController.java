package org.enrichment.talent_scouting_backend.dao;

import org.enrichment.talent_scouting_backend.model.Student;
import org.enrichment.talent_scouting_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentById")
    public Student getStudentById(int studentId) {
        return studentService.get(studentId);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.get();
    }

    @PostMapping("/insertStudent")
    public Student insertStudent(Student student) {
        return studentService.save(student);
    }

    @PostMapping("/deleteStudentById")
    public void deleteStudentById(int studentId) {
        studentService.delete(studentId);
    }

}
