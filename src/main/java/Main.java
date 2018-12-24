import ioservice.*;
import model.*;
import database.*;

import javax.validation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String id = "1";
        String firstName = "Vasya";
        String lastName = "Boyko";
        String surname = "Ivanovich";
        String passportCode = "DD061380";
        String certificateCode = "PZ385069";
        String nameOfFirstExam = "Ukrainian";
        String firstExam = "154";
        String nameOfSecondExam = "Math";
        String secondExam = "126";
        String nameOfThirdExam = "English";
        String thirdExam = "125";
        String university = "Kiev university I.Sykorskiy";
        String faculty = "Faculty of Psychology";
        String speciality = "Psychology";
        String averangeMarkOfTheCertificate = "7.5";
        String ruralCoef = "false";

        Serializer jsonSerialize = new JsonSerialize();
        String path = "ser." + "json";
        String[] applicant1 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                               firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university, faculty,
                               speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl1 = new Applicant.Builder().buildApplicant(applicant1);

        id = "2";
        firstName = "Mykola";
        lastName = "Tkachenko";
        surname = "Mykolayovich";
        passportCode = "PR697056";
        certificateCode = "MC452506";
        nameOfFirstExam = "Ukrainian";
        firstExam = "127";
        nameOfSecondExam = "Physics";
        secondExam = "190";
        nameOfThirdExam = "Math";
        thirdExam = "144";
        university = "Kharkiv National University VN Karazin";
        faculty = "Historical faculty";
        speciality = "History";
        averangeMarkOfTheCertificate = "11.1";
        ruralCoef = "true";

        String[] applicant2 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                               firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university, faculty,
                               speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl2 = new Applicant.Builder().buildApplicant(applicant2);

        id = "3";
        firstName = "Volodymir";
        lastName = "Pynchuk";
        surname = "Viktorovich";
        passportCode = "JC410803";
        certificateCode = "CH923387";
        nameOfFirstExam = "Ukrainian";
        firstExam = "195";
        nameOfSecondExam = "English";
        secondExam = "148";
        nameOfThirdExam = "History";
        thirdExam = "116";
        university = "National University \"Lviv Polytechnic\"";
        faculty = "Faculty of Physics";
        speciality = "Physics";
        averangeMarkOfTheCertificate = "10.6";
        ruralCoef = "false";

        String[] applicant3 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                               firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university, faculty,
                               speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl3 = new Applicant.Builder().buildApplicant(applicant3);

        id = "4";
        firstName = "Viktor";
        lastName = "Ivanov";
        surname = "Ivanovich";
        passportCode = "QI416156";
        certificateCode = "VP206982";
        nameOfFirstExam = "Ukrainian";
        firstExam = "167";
        nameOfSecondExam = "Geography";
        secondExam = "106";
        nameOfThirdExam = "Math";
        thirdExam = "154";
        university = "CHNU";
        faculty = "Faculty of Applied Mathematics";
        speciality = "Applied Math";
        averangeMarkOfTheCertificate = "9.5";
        ruralCoef = "false";

        String[] applicant4 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                               firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university, faculty,
                               speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl4 = new Applicant.Builder().buildApplicant(applicant4);

        id = "5";
        firstName = "Sergiy";
        lastName = "Kravchenko";
        surname = "Vasilyovich";
        passportCode = "YA516125";
        certificateCode = "NO786100";
        nameOfFirstExam = "Ukrainian";
        firstExam = "125";
        nameOfSecondExam = "History";
        secondExam = "128";
        nameOfThirdExam = "English";
        thirdExam = "108";
        university = "Uzhhorod National University";
        faculty = "Institute of Computer Science";
        speciality = "Computer science";
        averangeMarkOfTheCertificate = "8.7";
        ruralCoef = "false";

        String[] applicant5 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                               firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university, faculty,
                               speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl5 = new Applicant.Builder().buildApplicant(applicant5);

        id = "6";
        firstName = "Anatoliy";
        lastName = "Lyashenko";
        surname = "Fedorovych";
        passportCode = "YK287194";
        certificateCode = "IB311499";
        nameOfFirstExam = "Ukrainian";
        firstExam = "130";
        nameOfSecondExam = "Biology";
        secondExam = "163";
        nameOfThirdExam = "Chemistry";
        thirdExam = "150";
        university = "BDMU";
        faculty = "Medical faculty";
        speciality = "Doctor";
        averangeMarkOfTheCertificate = "8.1";
        ruralCoef = "true";

        String[] applicant6 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                               firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university, faculty,
                               speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl6 = new Applicant.Builder().buildApplicant(applicant6);

        id = "0";
        firstName = "Andriy";
        lastName = "Kozak";
        surname = "Yuriyovich";
        passportCode = "ZK456312";
        certificateCode = "GF957261";
        nameOfFirstExam = "Ukrainian";
        firstExam = "170";
        nameOfSecondExam = "Math";
        secondExam = "185";
        nameOfThirdExam = "Physics";
        thirdExam = "184";
        university = "Kiev National university";
        faculty = "Mathematics faculty";
        speciality = "Math";
        averangeMarkOfTheCertificate = "7.3";
        ruralCoef = "false";

        String[] applicant11 = {id, firstName, lastName, surname, passportCode, certificateCode, nameOfFirstExam,
                                firstExam, nameOfSecondExam, secondExam, nameOfThirdExam, thirdExam, university,
                                faculty, speciality, averangeMarkOfTheCertificate, ruralCoef
        };
        Applicant appl11 = new Applicant.Builder().buildApplicant(applicant11);

        System.out.println("Validation");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        if (!Applicant.validate(appl1, validator)) {
            System.out.println("VValidation has not passed");
            return;
        }
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        if (!Applicant.validate(appl2, validator)) {
            System.out.println("VValidation has not passed");
            return;
        }
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        if (!Applicant.validate(appl3, validator)) {
            System.out.println("VValidation has not passed");
            return;
        }
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        if (!Applicant.validate(appl4, validator)) {
            System.out.println("VValidation has not passed");
            return;
        }
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        if (!Applicant.validate(appl5, validator)) {
            System.out.println("VValidation has not passed");
            return;
        }
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        if (!Applicant.validate(appl6, validator)) {
            System.out.println("VValidation has not passed");
            return;
        }

        // SERIALIZATION
        System.out.println("\nJSON SERIALIZE");
        Applicant appl = Applicant.createApplicant();
        try {
            jsonSerialize.serialize(appl3, path);
            appl = jsonSerialize.deserialize(path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(appl.getId() + " " + appl.getFirstName() + " " + appl.getLastName() + " " + appl.getSurname());
        System.out.println(appl.getPassportCode() + " " + appl.getCertificateCode());
        System.out.println("EXAM");
        System.out.println(appl.getExam().getFirstExam().getNameOfExam() + " " + appl.getExam().getFirstExam().getResult() + " " + appl.getExam().getSecondExam().getNameOfExam() + " " + appl.getExam().getSecondExam().getResult() + " " + appl.getExam().getThirdExam().getNameOfExam() + " " + appl.getExam().getThirdExam().getResult());
        System.out.println("SPECIALITY");
        System.out.println(appl.getSpeciality().getUniversity() + " " + appl.getSpeciality().getFaculty() + " " + appl.getSpeciality().getSpeciality());
        System.out.println(appl.getAverangeMarkOfTheCertificate() + " " + appl.getRuralCoef());
        System.out.println();

        System.out.println("XML SERIAIZE");
        Serializer xmlSerialize = new XmlSerialize();
        path = "ser." + "xml";
        appl = Applicant.createApplicant();
        try {
            xmlSerialize.serialize(appl3, path);
            appl = xmlSerialize.deserialize(path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(appl.getId() + " " + appl.getFirstName() + " " + appl.getLastName() + " " + appl.getSurname());
        System.out.println(appl.getPassportCode() + " " + appl.getCertificateCode());
        System.out.println("EXAM");
        System.out.println(appl.getExam().getFirstExam().getNameOfExam() + " " + appl.getExam().getFirstExam().getResult() + " " + appl.getExam().getSecondExam().getNameOfExam() + " " + appl.getExam().getSecondExam().getResult() + " " + appl.getExam().getThirdExam().getNameOfExam() + " " + appl.getExam().getThirdExam().getResult());
        System.out.println("SPECIALITY");
        System.out.println(appl.getSpeciality().getUniversity() + " " + appl.getSpeciality().getFaculty() + " " + appl.getSpeciality().getSpeciality());
        System.out.println(appl.getAverangeMarkOfTheCertificate() + " " + appl.getRuralCoef());
        System.out.println();

        System.out.println("TXT SERIALIZE");
        Serializer txtSerialize = new TxtSerialize();
        appl = Applicant.createApplicant();
        path = "ser." + "txt";
        try {
            txtSerialize.serialize(appl3, path);
            appl = txtSerialize.deserialize(path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(appl.getId() + " " + appl.getFirstName() + " " + appl.getLastName() + " " + appl.getSurname());
        System.out.println(appl.getPassportCode() + " " + appl.getCertificateCode());
        System.out.println("EXAM");
        System.out.println(appl.getExam().getFirstExam().getNameOfExam() + " " + appl.getExam().getFirstExam().getResult() + " " + appl.getExam().getSecondExam().getNameOfExam() + " " + appl.getExam().getSecondExam().getResult() + " " + appl.getExam().getThirdExam().getNameOfExam() + " " + appl.getExam().getThirdExam().getResult());
        System.out.println("SPECIALITY");
        System.out.println(appl.getSpeciality().getUniversity() + " " + appl.getSpeciality().getFaculty() + " " + appl.getSpeciality().getSpeciality());
        System.out.println(appl.getAverangeMarkOfTheCertificate() + " " + appl.getRuralCoef());

        University univ = new University();
        univ.addApplicant(appl1);
        univ.addApplicant(appl2);
        univ.addApplicant(appl3);
        univ.addApplicant(appl4);
        univ.addApplicant(appl5);
        univ.addApplicant(appl6);
        univ.addApplicant(appl11);

        System.out.println("\nTHE LIST");
        for (Applicant applicant : univ.getStudents()) {
            System.out.println(applicant);
        }
        System.out.println("\nStreams");

        univ.getExcellentApplicantsFilter(160).forEach(item -> System.out.println(item.toString()));
        System.out.println();
        univ.getApplicantWithRuralCoefFilter().forEach(item -> System.out.println(item.toString()));
        System.out.println();
        univ.getApplicantsPassedExamGraterThanGivenMarkFilter("Math", 140).forEach(item -> System.out.println(item.toString()));

        System.out.printf("\nDatabase");
        // Connecting to database and do the query
        ApplicantDAO utils = new ApplicantDAO();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = utils.getConnection();
            statement = connection.createStatement();
            Applicant a = ApplicantDAO.findById(3);
            List<Applicant> b = ApplicantDAO.findByName("Viktor", "Ivanov", "Ivanovich");
            System.out.println("\nApplicant id=3: " + a);
            System.out.println("\nSearch applicant in dataase with name Viktor Ivanov Ivanovich");
            for (Applicant applicant : b) {
                System.out.println(applicant);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        // Save in database
//        Applicant temp = Applicant.createApplicant();
//        try {
//            temp = ApplicantDAO.saveApplicant(appl11);
//            System.out.println(temp);
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        // Delete for database
//
//        try {
//            System.out.println("Delete applicant for database: " + ApplicantDAO.deleteApplicant(appl11));
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            List<Applicant> list = ApplicantDAO.findExcelentApplicants(165);
            System.out.println("\nExcelent applicant for database: ");
            list.forEach(applicant -> System.out.println(applicant));

            list = new ArrayList<Applicant>();
            System.out.println("\nApplicant with rural coeficient for database: ");
            list = ApplicantDAO.findApplicantWithRuralCoef();
            list.forEach(applicant -> System.out.println(applicant));

            list = new ArrayList<Applicant>();
            System.out.println("\nApplicant who passed a exam grater than given mark: ");
            list = ApplicantDAO.findApplicantsPassedExamGraterThanGivenMarkFilter("Ukrainian", 160);
            list.forEach(applicant -> System.out.println(applicant));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}