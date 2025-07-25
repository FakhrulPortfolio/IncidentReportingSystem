package com.incident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class IncidentDAO {
    // Update these with your DB info
    private static final String DB_URL = "jdbc:mysql://localhost:3306/incident_system?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Fakh090@";

    public void insertIncident(String name, String email, String issue, String description, String imageFileName) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO incidents (name, email, issue, description, image_filename) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, issue);
                stmt.setString(4, description);
                stmt.setString(5, imageFileName);
                stmt.executeUpdate();
            }
        }
    }
    
    public List<Incident> getAllIncidents() throws Exception {
        List<Incident> list = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM incidents";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Incident inc = new Incident(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("issue"),
                        rs.getString("description"),
                        rs.getString("image_filename"),
                        rs.getString("status"),
                        rs.getString("assigned_to"),
                        rs.getTimestamp("submitted_at")
                    );
                    list.add(inc);
                }
            }
        }
        return list;
    }
    
    public void updateStatus(int id, String status) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE incidents SET status=? WHERE id=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, status);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }
    }
    
    public void assignTo(int id, String assignedTo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE incidents SET assigned_to=? WHERE id=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, assignedTo);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }
    }
}
