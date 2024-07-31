package org.enrichment.talent_scouting_backend.service.student;

import org.enrichment.talent_scouting_backend.api.dao.student.StudentDAO;
import org.enrichment.talent_scouting_backend.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    @Override
    public List<Student> get() {
        return studentDAO.getAllStudents();
    }

    @Transactional
    @Override
    public Student get(int id) {
        return studentDAO.get(id);
    }
    @Transactional
    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Transactional
    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }
}
