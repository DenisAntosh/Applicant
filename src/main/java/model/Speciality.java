package model;

public class Speciality {
    private String university;
    private String faculty;
    private String speciality;

    public Speciality() {
        university = "";
        faculty = "";
        speciality = "";
    }

    public Speciality(String university, String faculty, String speciality) {
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}