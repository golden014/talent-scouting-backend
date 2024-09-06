package org.enrichment.talent_scouting_backend.api.dao.student;

import org.enrichment.talent_scouting_backend.api.dto.StudentFilter;
import org.enrichment.talent_scouting_backend.api.model.Student;

import java.util.List;

public interface StudentDAO {
    Student get(int id);

    Student save(Student student);

    void delete(int id);

    List<Student> getAllStudents();

    Student getStudentByEmail(String email);

    List<Student> getStudentByFilter(StudentFilter studentFilter);

    List<String> getStudentMajors();
}
