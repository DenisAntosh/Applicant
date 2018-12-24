package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

@XmlRootElement
public class Applicant implements Serializable {
    @XmlElement
    private int id;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    private String surname;
    @XmlElement
    private String passportCode;
    @XmlElement
    private String certificateCode;
    @XmlElement
    private Exams exam;
    @XmlElement
    private Speciality speciality;
    @DecimalMax(value = "11.0", message = "Averange mark must be in the range [2.0 , 12.0]")
    @DecimalMin(value = "2.0", message = "Averange mark must be in the range [2.0 , 12.0]")
    @XmlElement
    private double averangeMarkOfTheCertificate;
    @XmlElement
    private boolean ruralCoef;

    private final static String NAME_PATTERN = "^[A-Z][a-z -]+?$";
    private final static String CODE_PATTERN = "^[A-Z]{2}\\d{6}$";

    public static class Builder {
        private Applicant applicantToBuild;

        public Builder() {
            applicantToBuild = new Applicant();
        }

        private Applicant build() {
            Applicant builtApplicant = applicantToBuild;
            applicantToBuild = null;
            return builtApplicant;
        }

        public Applicant setIDForApplicant(Applicant applicant, int id) {
            applicantToBuild = applicant;
            applicantToBuild.id = id;
            Applicant buildApplicant = applicantToBuild;
            applicantToBuild = null;
            return buildApplicant;
        }

        public Applicant buildApplicant(String[] args) throws IllegalArgumentException {
            StringBuilder sb = new StringBuilder();

            this.setId(Integer.parseInt(args[0]));

            try {
                this.setFirstName(args[1]);
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString()).append("\n");
            }

            try {
                this.setLastName(args[2]);
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString()).append("\n");
            }

            try {
                this.setSurname(args[3]);
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString()).append("\n");
            }

            try {
                this.setPassportCode(args[4]);
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString()).append("\n");
            }

            try {
                this.setCertificateCode(args[5]);
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString()).append("\n");
            }

            try {
                this.setExams(new Exams(new Exam(args[6], Integer.parseInt(args[7])), new Exam(args[8], Integer.parseInt(args[9])), new Exam(args[10], Integer.parseInt(args[11]))));
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString()).append("\n");
            }

            this.setSpeciality(new Speciality(args[12], args[13], args[14]));

            try {
                this.setAverangeMarkOfTheCertificate(Double.parseDouble(args[15]));
            } catch (IllegalArgumentException ex) {
                sb.append(ex.toString());
            }

            this.setRuralCoef(Boolean.valueOf(args[16]));

            if (sb.length() == 0)
                return this.build();
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setId(int id) {
            this.applicantToBuild.id = id;
            return this;
        }

        public Builder setFirstName(String name) {
            if (Pattern.matches(NAME_PATTERN, name))
                this.applicantToBuild.firstName = name;
            else
                throw new IllegalArgumentException("First name is incorrect");
            return this;
        }

        public Builder setLastName(String name) {
            if (Pattern.matches(NAME_PATTERN, name))
                this.applicantToBuild.lastName = name;
            else
                throw new IllegalArgumentException("Last name is incorrect");
            return this;
        }

        public Builder setSurname(String name) {
            if (Pattern.matches(NAME_PATTERN, name))
                this.applicantToBuild.surname = name;
            else
                throw new IllegalArgumentException("Surname is incorrect");
            return this;
        }

        public Builder setPassportCode(String passportCode) {
            if (Pattern.matches(CODE_PATTERN, passportCode))
                this.applicantToBuild.passportCode = passportCode;
            else
                throw new IllegalArgumentException("Passport code is incorrect");
            return this;
        }

        public Builder setCertificateCode(String certificateCode) {
            if (Pattern.matches(CODE_PATTERN, certificateCode))
                this.applicantToBuild.certificateCode = certificateCode;
            else
                throw new IllegalArgumentException("Certificate code is incorrect");
            return this;
        }

        public Builder setExams(Exams exam) {
            if (exam.getFirstExam().getResult() >= Exam.MIN_SCORE_EXAM && exam.getFirstExam().getResult() <= Exam.MAX_SCORE_EXAM && exam.getSecondExam().getResult() >= Exam.MIN_SCORE_EXAM && exam.getSecondExam().getResult() <= Exam.MAX_SCORE_EXAM && exam.getThirdExam().getResult() >= Exam.MIN_SCORE_EXAM && exam.getThirdExam().getResult() <= Exam.MAX_SCORE_EXAM)
                this.applicantToBuild.exam = exam;
            else
                throw new IllegalArgumentException("The exam must be bigger then " + Exam.MIN_SCORE_EXAM + " and less then " + Exam.MAX_SCORE_EXAM);
            return this;
        }

        public Builder setSpeciality(Speciality speciality) {
            this.applicantToBuild.speciality = speciality;
            return this;
        }

        public Builder setAverangeMarkOfTheCertificate(double averangeMarkOfTheCertificate) {
            this.applicantToBuild.averangeMarkOfTheCertificate = averangeMarkOfTheCertificate;
            return this;
        }

        public Builder setRuralCoef(Boolean ruralCoef) {
            this.applicantToBuild.ruralCoef = ruralCoef;
            return this;
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public Exams getExam() {
        return exam;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public double getAverangeMarkOfTheCertificate() {
        return averangeMarkOfTheCertificate;
    }

    public boolean getRuralCoef() {
        return ruralCoef;
    }

    private Applicant() {
        firstName = "";
        lastName = "";
        surname = "";
        passportCode = "";
        certificateCode = "";
        exam = new Exams();
        speciality = new Speciality("", "", "");
        averangeMarkOfTheCertificate = 0;
        ruralCoef = false;
    }

    private Applicant(int id, String firstName, String lastName, String surname, String passportCode,
                      String certificateCode, Exams exam, Speciality speciality, double averangeMarkOfTheCertificate,
                      boolean ruralCoef) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.passportCode = passportCode;
        this.certificateCode = certificateCode;
        this.exam = exam;
        this.speciality = speciality;
        this.averangeMarkOfTheCertificate = averangeMarkOfTheCertificate;
        this.ruralCoef = ruralCoef;
    }

    public static Applicant createApplicant() {
        return new Applicant();
    }

    /**
     * @return the finaly mark of the applicant
     */
    @JsonIgnore
    public double getFinalMark() {
        return exam.getIntroductoryAssessment(averangeMarkOfTheCertificate, ruralCoef, speciality.getSpeciality());
    }

    /**
     * @param obj - the object with which we will compare with our object
     * @return true if the object are equals, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (getClass() != obj.getClass()))
            return false;
        Applicant other = (Applicant) obj;
        if (firstName != other.getFirstName() || lastName != other.getLastName() || surname != other.getSurname() || passportCode != other.getPassportCode())
            return false;
        return true;
    }

    /**
     * @return hashCode of the name, passport and certificate in the amount
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((passportCode == null) ? 0 : passportCode.hashCode());
        return result;
    }

    /**
     * @return string result of converting all ZNO into one string
     * this metod will be use for serialization in TXT
     */
    @Override
    public String toString() {
        String separator = ";";
        String str = id + separator + firstName + separator + lastName + separator + surname + separator;
        str += passportCode + separator + certificateCode + separator;
        str += exam.getFirstExam().getNameOfExam() + separator + exam.getFirstExam().getResult() + separator + exam.getSecondExam().getNameOfExam() + separator + exam.getSecondExam().getResult() + separator + exam.getThirdExam().getNameOfExam() + separator + exam.getThirdExam().getResult() + separator;
        str += speciality.getUniversity() + separator + speciality.getFaculty() + separator + speciality.getSpeciality() + separator;
        str += averangeMarkOfTheCertificate + separator + ruralCoef;
        return str;
    }

    public static boolean validate(Object object, Validator validator) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        System.out.println(String.format("Number of errors: %d", constraintViolations.size()));
        for (ConstraintViolation<Object> cv : constraintViolations) {
            System.out.println(String.format("Eror in validation! Property: [%s], value: [%s], message: [%s]", cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
        return constraintViolations.size() == 0;
    }

    /**
     * @param nameOfExam - name of exam
     * @return boolean value - the result of an applicant passed this exam
     */
    public boolean hasExam(String nameOfExam) {
        return (this.getExam().getFirstExam().getNameOfExam().equals(nameOfExam) || this.getExam().getSecondExam().getNameOfExam().equals(nameOfExam) || this.getExam().getThirdExam().getNameOfExam().equals(nameOfExam));
    }
}