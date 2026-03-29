package com.maharjan.amit.entityManager;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class RepositoryManagerTest {
    @Test
    public void getAllStudentTest() {
        EntityManager entityManagerMock = Mockito.mock(EntityManager.class);
        RepositoryManager repositoryManager = new RepositoryManager(entityManagerMock);

        Student student1 = new Student(1,"Amit");
        Student student2 = new Student(2,"Amrit");
        Student student3 = new Student(3,"Arjun");
        List<Student> students = Arrays.asList(student1, student2, student3);

        Query queryMock = Mockito.mock(Query.class);
        when(queryMock.getResultList()).thenReturn(students);

        when(entityManagerMock.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS_QUERY)).thenReturn(queryMock);

        List<Student> result = repositoryManager.getAllStudent();

        Assert.assertEquals(students, result);
    }
}
