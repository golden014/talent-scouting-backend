package org.enrichment.talent_scouting_backend.api.controller;
import org.enrichment.talent_scouting_backend.api.dto.StudentFilter;
import org.enrichment.talent_scouting_backend.service.student.StudentService;

import org.enrichment.talent_scouting_backend.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

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

    @PostMapping("/getStudentByFilter")
    public List<Student> getStudentByFilter(@RequestBody StudentFilter studentFilter) {
        return studentService.getStudentByFilter(studentFilter);
    }

    @GetMapping("/getStudentMajors")
    public ResponseEntity<List<String>> getStudentMajors() {
        List<String> output = studentService.getStudentMajors();
        if (output != null) {
            return ResponseEntity.ok(output);
        }
        return ResponseEntity.badRequest().build();
    }

}
