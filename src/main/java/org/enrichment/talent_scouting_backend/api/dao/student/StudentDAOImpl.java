package org.enrichment.talent_scouting_backend.api.dao.student;

import jakarta.persistence.EntityManager;
import org.enrichment.talent_scouting_backend.api.model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Student get(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        try {
            entityManager.persist(student);
//            System.out.println(student.getDob());
            return student;
        } catch (Exception e) {
            // Log the exception (use a logging framework such as SLF4J)
            System.err.println("Error persisting student: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = entityManager.unwrap(Session.class);
        Query<Student> query = session.createQuery("from Student", Student.class);
        return query.getResultList();
    }
}
