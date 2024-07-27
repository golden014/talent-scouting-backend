package org.enrichment.talent_scouting_backend.dao.student;

import org.enrichment.talent_scouting_backend.model.Student;

import java.util.List;

public interface StudentDAO {
    Student get(int id);

    Student save(Student student);

    void delete(int id);

    List<Student> getAllStudents();
}
