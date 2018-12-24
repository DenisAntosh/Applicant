package database;

import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ApplicantDAO {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + Configs.DB_HOST + ":" + Configs.DB_PORT + "/" + Configs.DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionURL, Configs.DB_USER, Configs.DB_PASS);
        return conn;
    }

    public static Applicant findById(int id) throws SQLException, ClassNotFoundException {
        return ApplicantDAO.find("SELECT * FROM exams JOIN applicant ON applicant.applID = exams.applID WHERE applicant.applID = " + id + ";").get(0);
    }

    public static List<Applicant> findByName(String firstName, String lastName, String surname)
            throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM exams JOIN applicant ON applicant.applID = exams.applID WHERE applicant.firstName = ? AND applicant.lastName = ? AND applicant.surname = ? ;";
        try (PreparedStatement preparedStatement = ApplicantDAO.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, surname);
            ResultSet rs = preparedStatement.executeQuery();
            List<Applicant> list = new ArrayList<Applicant>();
            while (rs.next()) {
                Applicant a = ApplicantDAO.resultSetToAppicant(rs);
                list.add(a);
            }
            return list;
        }
    }

    public static List<Applicant> findExcelentApplicants(double excelentMark)
            throws SQLException, ClassNotFoundException {
        List<Applicant> allApplicants = ApplicantDAO.find("SELECT * FROM exams JOIN applicant ON applicant.applID = exams.applID ;");
        return new University(allApplicants).getExcellentApplicants(excelentMark);
    }

    public static List<Applicant> findApplicantWithRuralCoef() throws SQLException, ClassNotFoundException {
        return ApplicantDAO.find("SELECT * FROM exams JOIN applicant ON applicant.applID = exams.applID WHERE applicant.ruralCoef = TRUE;");
    }

    public static List<Applicant> findApplicantsPassedExamGraterThanGivenMarkFilter(String nameOfExam, int givenMark)
            throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM applicant JOIN exams ON applicant.applID = exams.applID WHERE exams.title = ? AND exams.score >= ? ;";

        try (PreparedStatement preparedStatement = ApplicantDAO.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, nameOfExam);
            preparedStatement.setInt(2, givenMark);
            ResultSet rs = preparedStatement.executeQuery();
            List<Applicant> list = new ArrayList<Applicant>();
            while (rs.next()) {
                int id = rs.getInt("applID");
                list.add(ApplicantDAO.findById(id));
            }
            return list;
        }
    }

    public static Applicant saveApplicant(Applicant applicant) throws SQLException, ClassNotFoundException {
        String sqlInsertApplicant = "INSERT INTO applicant(firstName, lastName, surname, passportCode, certificateCode, avgMarkCertificate, university, faculty, speciality, ruralCoef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        String sqlInsertExams = "INSERT INTO exams(title, score, applID) VALUES (?, ?, ?);";
        String sqlUpdateApplicant = "UPDATE applicant SET firstName = ?, lastName = ?, surname = ?, passportCode = ?, certificateCode = ?, avgMarkCertificate = ?, " + "university = ?, faculty = ?, speciality = ?, ruralCoef = ? WHERE applicant.applID = " + applicant.getId() + ";";
        String sqlUpdateExams = "UPDATE exams SET title = ?, score = ? WHERE exams.applID = " + applicant.getId() + ";";

        if (applicant.getId() == 0) {
            try (Connection dbConnection = getConnection();
                 PreparedStatement prStmApplicant = dbConnection.prepareStatement(sqlInsertApplicant, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement prStmExams = dbConnection.prepareStatement(sqlInsertExams)) {
                ApplicantDAO.fillPreparedStatmentApplicant(prStmApplicant, applicant);
                prStmApplicant.executeUpdate();

                ResultSet rs = prStmApplicant.getGeneratedKeys();
                rs.first();
                int id = rs.getInt(1);

                prStmExams.setString(1, applicant.getExam().getFirstExam().getNameOfExam());
                prStmExams.setInt(2, applicant.getExam().getFirstExam().getResult());
                prStmExams.setInt(3, id);
                prStmExams.executeUpdate();

                prStmExams.setString(1, applicant.getExam().getSecondExam().getNameOfExam());
                prStmExams.setInt(2, applicant.getExam().getSecondExam().getResult());
                prStmExams.executeUpdate();

                prStmExams.setString(1, applicant.getExam().getThirdExam().getNameOfExam());
                prStmExams.setInt(2, applicant.getExam().getThirdExam().getResult());
                prStmExams.executeUpdate();

                applicant = new Applicant.Builder().setIDForApplicant(applicant, id);
                return applicant;
            }
        } else {
            try (Connection dbConnection = getConnection();
                 PreparedStatement prStmApplicant = dbConnection.prepareStatement(sqlUpdateApplicant);
                 PreparedStatement prStmExams = dbConnection.prepareStatement(sqlUpdateExams)) {
                dbConnection.setAutoCommit(false);
                ApplicantDAO.fillPreparedStatmentApplicant(prStmApplicant, applicant);
                prStmApplicant.executeUpdate();

                prStmExams.setString(1, applicant.getExam().getFirstExam().getNameOfExam());
                prStmExams.setInt(2, applicant.getExam().getFirstExam().getResult());
                prStmExams.addBatch();

                prStmExams.setString(1, applicant.getExam().getSecondExam().getNameOfExam());
                prStmExams.setInt(2, applicant.getExam().getSecondExam().getResult());
                prStmExams.addBatch();

                prStmExams.setString(1, applicant.getExam().getThirdExam().getNameOfExam());
                prStmExams.setInt(2, applicant.getExam().getThirdExam().getResult());
                prStmExams.addBatch();

                dbConnection.commit();
                prStmExams.executeBatch();

                return applicant;
            }
        }
    }

    public static boolean deleteApplicant(Applicant applicant) throws SQLException, ClassNotFoundException {
        if (applicant == null)
            return false;
        int countApplicant, countExams;

        String deleteApplicant = "DELETE FROM applicant WHERE applID = ?;";
        String deleteExams = "DELETE FROM exams WHERE applID = ?;";
        try (PreparedStatement prApplicant = ApplicantDAO.getConnection().prepareStatement(deleteApplicant);
             PreparedStatement prExams = ApplicantDAO.getConnection().prepareStatement(deleteExams)) {
            if (prApplicant == null || prExams == null)
                return false;
            prApplicant.setInt(1, applicant.getId());
            prExams.setInt(1, applicant.getId());
            countExams = prExams.executeUpdate();
            countApplicant = prApplicant.executeUpdate();
        }
        return countApplicant > 0 && countExams > 0;
    }

    public static List<Applicant> find(String query) throws SQLException, ClassNotFoundException {
        List<Applicant> list = new ArrayList<Applicant>();
        try (Statement stmt = ApplicantDAO.getConnection().createStatement()) {
            ResultSet applicantRs = stmt.executeQuery(query);
            while (applicantRs.next()) {
                Applicant c = ApplicantDAO.resultSetToAppicant(applicantRs);
                list.add(c);
            }
            return list;
        }
    }

    private static void fillPreparedStatmentApplicant(PreparedStatement prStmApplicant, Applicant applicant) throws SQLException {
        prStmApplicant.setString(1, applicant.getFirstName());
        prStmApplicant.setString(2, applicant.getLastName());
        prStmApplicant.setString(3, applicant.getSurname());
        prStmApplicant.setString(4, applicant.getPassportCode());
        prStmApplicant.setString(5, applicant.getCertificateCode());
        prStmApplicant.setDouble(6, applicant.getAverangeMarkOfTheCertificate());
        prStmApplicant.setString(7, applicant.getSpeciality().getUniversity());
        prStmApplicant.setString(8, applicant.getSpeciality().getFaculty());
        prStmApplicant.setString(9, applicant.getSpeciality().getSpeciality());
        prStmApplicant.setBoolean(10, applicant.getRuralCoef());
    }

    private static Applicant resultSetToAppicant(ResultSet applicantRs) throws SQLException {
        String[] args = new String[17];
        args[0] = applicantRs.getString("applID");
        args[1] = applicantRs.getString("firstName");
        args[2] = applicantRs.getString("lastName");
        args[3] = applicantRs.getString("surname");
        args[4] = applicantRs.getString("passportCode");
        args[5] = applicantRs.getString("certificateCode");
        args[6] = applicantRs.getString("title");
        args[7] = applicantRs.getString("score");
        applicantRs.next();
        args[8] = applicantRs.getString("title");
        args[9] = applicantRs.getString("score");
        applicantRs.next();
        args[10] = applicantRs.getString("title");
        args[11] = applicantRs.getString("score");
        args[12] = applicantRs.getString("university");
        args[13] = applicantRs.getString("faculty");
        args[14] = applicantRs.getString("speciality");
        args[15] = applicantRs.getString("avgMarkCertificate");
        args[16] = applicantRs.getString("ruralCoef");
        if (Integer.parseInt(args[16]) == 0)
            args[16] = Boolean.toString(false);
        else
            args[16] = Boolean.toString(true);
        return new Applicant.Builder().buildApplicant(args);
    }
}