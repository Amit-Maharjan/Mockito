package com.maharjan.amit.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RepositoryManager {
    public static final String GET_ALL_STUDENTS_QUERY = "SELECT * FROM student_table";

    private final EntityManager entityManager;

    public RepositoryManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = getStudentsQuery(entityManager, GET_ALL_STUDENTS_QUERY);
        entityManager.close();
        return studentList;
    }

    private static List<Student> getStudentsQuery(EntityManager entityManager, String sql) {
        Query allStudentQuery = entityManager.createNamedQuery(sql);
        return allStudentQuery.getResultList();
    }
}
