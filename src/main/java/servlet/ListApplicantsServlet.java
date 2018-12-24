package servlet;

import database.ApplicantDAO;
import model.Applicant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "ListApplicantsServlet",  urlPatterns= "/list")
public class ListApplicantsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Applicant> allApplicants = ApplicantDAO.find("SELECT * FROM exams JOIN applicant ON applicant.applID = exams.applID ");
            req.setAttribute("applicantsList", allApplicants);
        } catch (SQLException | ClassNotFoundException e) {
            req.setAttribute("errorString", e.toString());
        }
        req.getServletContext().getRequestDispatcher("/allApplicants.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}