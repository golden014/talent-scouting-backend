package org.enrichment.talent_scouting_backend.api.dao.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.enrichment.talent_scouting_backend.api.dto.StudentFilter;
import org.enrichment.talent_scouting_backend.api.model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Override
    public List<Student> getStudentByFilter(StudentFilter studentFilter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> student = query.from(Student.class);
        List<Predicate> predicates = new ArrayList<>();

        if (studentFilter.getMajor() != null && !studentFilter.getMajor().isEmpty()) {
            predicates.add(cb.equal(student.get("major"), studentFilter.getMajor()));
        }

        if (studentFilter.getPositions() != null && !studentFilter.getPositions().isEmpty()) {
            Predicate positionPredicate = student.get("positions").in(studentFilter.getPositions());
            predicates.add(positionPredicate);
        }

        if (studentFilter.getSearchKeyword() != null && !studentFilter.getSearchKeyword().isEmpty()) {
            String searchPattern = "%" + studentFilter.getSearchKeyword() + "%";
            Predicate namePredicate = cb.like(cb.lower(student.get("name")), searchPattern);
            Predicate nimPredicate = cb.like(cb.lower(student.get("nim")), searchPattern);
            Predicate descriptionPredicate = cb.like(student.get("description"), searchPattern);
            predicates.add(cb.or(namePredicate, nimPredicate, descriptionPredicate));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
