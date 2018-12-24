package servlet;

import database.ApplicantDAO;
import model.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "FindByNameServlet", urlPatterns = "/findByName")
public class FindByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String surname = req.getParameter("surname");
        try {
            List<Applicant> list = ApplicantDAO.findByName(firstName, lastName, surname);
            req.setAttribute("list", list);
        } catch (SQLException | ClassNotFoundException e) {
            req.setAttribute("errorCode", e.toString());
        }
        req.getServletContext().getRequestDispatcher("/findByName.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}