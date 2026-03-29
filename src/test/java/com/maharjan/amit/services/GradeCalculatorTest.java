package com.maharjan.amit.services;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GradeCalculatorTest {
    private static Object[] testValues() {
        return new Object[] {
                new Object[] {50,50,50},
                new Object[] {100,100,100},
                new Object[] {200,20,-1},
                new Object[] {-1,30,-1},
                new Object[] {20,400,-1},
                new Object[] {30,-5,-1},
        };
    }

    @Test
    @Parameters(method = "testValues")
    public void testCalculateGrade(int assignmentScore, int finalExamScore, int grade) {
        GradeCalculator gradeCalculator = new GradeCalculator();
        gradeCalculator.calculateGrade(assignmentScore,finalExamScore);
        Assert.assertEquals(grade, gradeCalculator.getGrade());
    }
}
