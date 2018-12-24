package model;

import java.util.*;

public class Exams {

    private Exam firstExam;
    private Exam secondExam;
    private Exam thirdExam;

    public static final double RURALCOEF = 1.02;
    public static final double AGRICULTURALCOEF = 1.05;
    public static final double FIRSTCOEF = 0.25;
    public static final double SECONDCOEF = 0.35;
    public static final double THIRDCOEF = 0.25;
    public static final double CEFTIFICATECOEF = 0.1;

    private static final List<String> AGRICULTURALSCIENCE = Arrays.asList("Агрономія", "Біологія", "Біотехнології та біоінженерія", "Геодезія та землеустрій", "Екологія", "Середня освіта (біологія та здоров'я людини)", "Середня освіта (хім0ія)", "Харчові технології", "Хімія", "Видавництво та поліг    рафія", "Електроенергетика, електротехніка та електромеханіка", "Метрологія та інформаційно-вимірювальна техніка", "Мікро- та наносистемна техніка", "Прикладна фізика та наноматеріали", "Професійна освіта (машинобудування)", "Середня освіта (трудове навчання та технології)", "Середня освіта (фізика)", "Телекомунікації та радіотехніка", "Будівництво та цивільна інженерія", "Географія", "Геодезія та землеустрій", "Науки про Землю", "Середня освіта (географія)", "Математика", "Середня освіта (інформатика)", "Середня освіта (математика)", "Системний аналіз");

    public Exams(Exam first, Exam second, Exam third) {
        if (first.getResult() >= Exam.MIN_SCORE_EXAM && first.getResult() <= Exam.MAX_SCORE_EXAM && second.getResult() >= Exam.MIN_SCORE_EXAM && second.getResult() <= Exam.MAX_SCORE_EXAM && third.getResult() >= Exam.MIN_SCORE_EXAM && third.getResult() <= Exam.MAX_SCORE_EXAM) {
            firstExam = first;
            secondExam = second;
            thirdExam = third;
        } else
            throw new IllegalArgumentException("The exam must be bigger then " + Exam.MIN_SCORE_EXAM + " and less then " + Exam.MAX_SCORE_EXAM);
    }

    public Exams() {
        firstExam = new Exam();
        secondExam = new Exam();
        thirdExam = new Exam();
    }

    public Exam getFirstExam() {
        return firstExam;
    }

    public Exam getSecondExam() {
        return secondExam;
    }

    public Exam getThirdExam() {
        return thirdExam;
    }

    public void setFirstExam(Exam firstExam) {
        if (firstExam.getResult() >= Exam.MIN_SCORE_EXAM && firstExam.getResult() <= Exam.MAX_SCORE_EXAM)
            this.firstExam = firstExam;
        else
            throw new IllegalArgumentException("The exam must be bigger then " + Exam.MIN_SCORE_EXAM + " and less then " + Exam.MAX_SCORE_EXAM);
    }

    public void setSecondExam(Exam secondExam) {
        if (secondExam.getResult() >= Exam.MIN_SCORE_EXAM && secondExam.getResult() <= Exam.MAX_SCORE_EXAM)
            this.secondExam = secondExam;
        else
            throw new IllegalArgumentException("The exam must be bigger then " + Exam.MIN_SCORE_EXAM + " and less then " + Exam.MAX_SCORE_EXAM);
    }

    public void setThirdExam(Exam thirdExam) {
        if (thirdExam.getResult() >= Exam.MIN_SCORE_EXAM && thirdExam.getResult() <= Exam.MAX_SCORE_EXAM)
            this.thirdExam = thirdExam;
        else
            throw new IllegalArgumentException("The exam must be bigger then " + Exam.MIN_SCORE_EXAM + " and less then " + Exam.MAX_SCORE_EXAM);
    }

    public double getIntroductoryAssessment(double averangeMarkOfTheCertificate, boolean ruralCoef, String speciality) {
        assert (averangeMarkOfTheCertificate >= 2 && averangeMarkOfTheCertificate <= 12);
        double res = firstExam.getResult() * FIRSTCOEF + secondExam.getResult() * SECONDCOEF + thirdExam.getResult() * THIRDCOEF + convertTo200PointScale(averangeMarkOfTheCertificate) * CEFTIFICATECOEF;
        if (ruralCoef)
            res *= RURALCOEF;
        if (AGRICULTURALSCIENCE.contains(speciality))
            res *= AGRICULTURALCOEF;
        return res;
    }

    private static double convertTo200PointScale(double number) {
        assert (number <= 12);
        number += 8;
        number *= 10;
        return number;
    }
}