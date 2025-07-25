package com.incident;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);
    	if (session == null || !"admin".equals(session.getAttribute("role"))) {
    	    response.sendRedirect("Login.jsp");
    	    return;
    	}
    	
    	try {
            IncidentDAO dao = new IncidentDAO();
            List<Incident> incidents = dao.getAllIncidents();
            request.setAttribute("incidents", incidents);
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}