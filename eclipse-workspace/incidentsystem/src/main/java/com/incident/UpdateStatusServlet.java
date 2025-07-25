package com.incident;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            IncidentDAO dao = new IncidentDAO();
            if (request.getParameter("assign") != null) {
                String assignedTo = request.getParameter("assignedTo");
                dao.assignTo(id, assignedTo);
            } else {
                String status = request.getParameter("status");
                dao.updateStatus(id, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("AdminViewServlet");
    }
}