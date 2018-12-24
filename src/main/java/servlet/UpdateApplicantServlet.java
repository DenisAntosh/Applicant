package servlet;

import database.ApplicantDAO;
import model.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateApplicantServlet", urlPatterns = "/update")
public class UpdateApplicantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Applicant applicant = ApplicantDAO.findById(id);
            req.setAttribute("applicant", applicant);
        } catch (SQLException | ClassNotFoundException e) {
            req.setAttribute("errorCode", e.toString());
        }
        req.getServletContext().getRequestDispatcher("/updateApplicant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String surname = req.getParameter("surname");
        String passportCode = req.getParameter("passportCode");
        String certificateCode = req.getParameter("certificateCode");
        String firstExamName = req.getParameter("firstExamName");
        String firstExamResult = req.getParameter("firstExamResult");
        String secondExamName = req.getParameter("secondExamName");
        String secondExamResult = req.getParameter("secondExamResult");
        String thirdExamName = req.getParameter("thirdExamName");
        String thirdExamResult = req.getParameter("thirdExamResult");
        String university = req.getParameter("university");
        String faculty = req.getParameter("faculty");
        String speciality = req.getParameter("speciality");
        String averageMarkOfTheCertificate = req.getParameter("averageMarkOfTheCertificate");
        String ruralCoef;
        if (req.getParameter("ruralCoef") == null)
            ruralCoef = "false";
        else
            ruralCoef = "true";
        String[] args = {id, firstName, lastName, surname, passportCode, certificateCode, firstExamName, firstExamResult, secondExamName, secondExamResult, thirdExamName, thirdExamResult, university, faculty, speciality, averageMarkOfTheCertificate, ruralCoef};
        Applicant applicant = new Applicant.Builder().buildApplicant(args);
        try {
            ApplicantDAO.saveApplicant(applicant);
        } catch (SQLException | ClassNotFoundException e) {
            req.setAttribute("errorString", e.toString());
        }
        req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}