package com.maharjan.amit.entityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryManagerTest2 {
    @Mock
    Query mockQuery;

    @Mock
    EntityManager mockEntityManager;

    @InjectMocks
    RepositoryManager repositoryManager;

    @Test
    public void getAllStudentTest() {
        Student student1 = new Student(1,"Amit");
        Student student2 = new Student(2,"Amrit");
        Student student3 = new Student(3,"Arjun");
        List<Student> students = Arrays.asList(student1, student2, student3);

        when(mockQuery.getResultList()).thenReturn(students);

        when(mockEntityManager.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS_QUERY)).thenReturn(mockQuery);

        List<Student> result = repositoryManager.getAllStudent();

        Assert.assertEquals(students, result);
    }
}
