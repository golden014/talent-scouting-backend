package org.enrichment.talent_scouting_backend.api.dao.student;

import org.enrichment.talent_scouting_backend.api.model.Student;

import java.util.List;

public interface StudentDAO {
    Student get(int id);

    Student save(Student student);

    void delete(int id);

    List<Student> getAllStudents();
}
