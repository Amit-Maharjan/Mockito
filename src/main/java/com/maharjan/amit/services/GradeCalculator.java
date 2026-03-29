package com.maharjan.amit.services;

public class GradeCalculator {
    private int grade;

    public void calculateGrade(int assignmentScore, int finalExamScore) {
        if (assignmentScore < 0 || assignmentScore > 100 || finalExamScore < 0 || finalExamScore > 100) {
            grade = -1;
        } else {
            grade = (assignmentScore + finalExamScore) / 2;
        }
    }

    public int getGrade() {
        return grade;
    }
}
