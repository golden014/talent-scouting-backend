package org.enrichment.talent_scouting_backend.service.student;

import org.enrichment.talent_scouting_backend.api.dto.StudentFilter;
import org.enrichment.talent_scouting_backend.api.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> get();

    Student get(int id);

    Student save(Student student);

    void delete(int id);

    List<Student> getStudentByFilter(StudentFilter studentFilter);

}
