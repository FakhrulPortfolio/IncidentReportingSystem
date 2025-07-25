package com.incident;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ReportIncidentServlet")
@MultipartConfig
public class ReportIncidentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
    	request.setCharacterEncoding("UTF-8");
        
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
        String issue = request.getParameter("issue");
        String description = request.getParameter("description");
        
        Part imagePart = request.getPart("image");
        String imageFileName = null;
        String uploadPath = getServletContext().getRealPath("/uploads");

        // Create uploads directory if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Handle image upload
        if (imagePart != null && imagePart.getSize() > 0) {
            imageFileName = System.currentTimeMillis() + "_" + imagePart.getSubmittedFileName();
            File file = new File(uploadDir, imageFileName);
            Files.copy(imagePart.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        
        // For now, just print to server log
        System.out.println("Incident Reported:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Issue: " + issue);
        System.out.println("Description: " + description);

     // Store data in MySQL using DAO
        try {
            IncidentDAO dao = new IncidentDAO();
            dao.insertIncident(name, email, issue, description, imageFileName);
        } catch (Exception e) {
            e.printStackTrace();
            // Optionally, set an error attribute and forward to an error page
        }

        // Forward to thank you page
        request.getRequestDispatcher("ThankYou.jsp").forward(request, response);
    }
}
