package servlet;

import database.ApplicantDAO;
import model.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindByIdServlet", urlPatterns = "/findById")
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != "") {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Applicant applicant = ApplicantDAO.findById(id);
                req.setAttribute("applicant", applicant);
            } catch (SQLException | ClassNotFoundException | IndexOutOfBoundsException e) {
                req.setAttribute("errorCode", e.toString());
            }
        }
        req.getServletContext().getRequestDispatcher("/findByID.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}