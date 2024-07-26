package org.enrichment.talent_scouting_backend.service;

import org.enrichment.talent_scouting_backend.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> get();

    Student get(int id);

    Student save(Student student);

    void delete(int id);
}
