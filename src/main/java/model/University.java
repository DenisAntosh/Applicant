package model;

import java.util.*;
import java.util.stream.Collectors;

public class University {
    private List<Applicant> students;

    public University() {
        students = new ArrayList<Applicant>();
    }

    public University(List<Applicant> students) {
        this.students = students;
    }

    public List<Applicant> getStudents() {
        return students;
    }

    public boolean addApplicant(Applicant applicant) {
         return students.add(applicant);
    }

    public List<Applicant> getExcellentApplicants(double excelentMark) {
        List<Applicant> excelentApplicants = new LinkedList<Applicant>();
        for (Applicant appl : students)
            if (appl.getFinalMark() >= excelentMark)
                excelentApplicants.add(appl);
        return excelentApplicants;
    }

    public List<Applicant> getExcellentApplicantsFilter(double excelentMark) {
        return students.stream().filter(applicant -> applicant.getFinalMark() >= excelentMark).collect(Collectors.toList());
    }

    public List<Applicant> getApplicantWithRuralCoef() {
        List<Applicant> applWithRuralCoef = new LinkedList<Applicant>();
        for (Applicant appl : students)
            if (appl.getRuralCoef())
                students.add(appl);
        return applWithRuralCoef;
    }

    public List<Applicant> getApplicantWithRuralCoefFilter() {
        return students.stream().filter(applicant -> applicant.getRuralCoef()).collect(Collectors.toList());
    }

    /**
     * @param nameOfExam - check if applicant passed the this exam
     * @param givenMark  - the score with which we will compare
     * @return those applicants, that passed given exam grater than given mark
     */
    public List<Applicant> getApplicantsPassedExamGraterThanGivenMark(String nameOfExam, int givenMark) {
        List<Applicant> res = new LinkedList<Applicant>();
        for (Applicant appl : students)
            if (appl.hasExam(nameOfExam))
                if (appl.getFinalMark() >= givenMark)
                    res.add(appl);
        return res;
    }

    public List<Applicant> getApplicantsPassedExamGraterThanGivenMarkFilter(String nameOfExam, int givenMark) {
        return students.stream().filter(applicant -> applicant.hasExam(nameOfExam) && applicant.getFinalMark() >= givenMark).collect(Collectors.toList());
    }
}