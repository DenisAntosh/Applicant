package model;

public class Exam {
    private String nameOfExam;
    private int result;

    public final static int MIN_SCORE_EXAM = 100;
    public final static int MAX_SCORE_EXAM = 200;

    public Exam() {
        nameOfExam = "";
        result = 0;
    }

    public Exam(String nameOfExam, int result) {
        this.nameOfExam = nameOfExam;
        if (result >= MIN_SCORE_EXAM && result <= MAX_SCORE_EXAM)
            this.result = result;
        else
            throw new IllegalArgumentException("The exam must be bigger then " +  MIN_SCORE_EXAM + " and less then " + MAX_SCORE_EXAM);
    }

    public String getNameOfExam() {
        return nameOfExam;
    }

    public int getResult() {
        return result;
    }

    public void setNameOfExam(String nameOfExam) {
        this.nameOfExam = nameOfExam;
    }

    public void setResult(int result) {
        if (result >= Exam.MIN_SCORE_EXAM && result <= Exam.MAX_SCORE_EXAM)
            this.result = result;
        else
            throw new IllegalArgumentException("The exam must be bigger then " +  MIN_SCORE_EXAM + " and less then " + MAX_SCORE_EXAM);
    }
}