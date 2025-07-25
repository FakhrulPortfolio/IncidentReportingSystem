<%@ page import="java.util.List,com.incident.Incident" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Administration - Incident Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <h2 class="mb-4">Incident Management</h2>
    <table class="table table-bordered table-hover bg-white shadow-sm">
        <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Issue</th>
                <th>Description</th>
                <th>Status</th>
                <th>Assigned To</th>
                <th>Submitted At</th>
            </tr>
        </thead>
        <tbody>
        <%
        	String role = (String) session.getAttribute("role");
        	if (role == null || !"admin".equals(role)) {
            	response.sendRedirect("Login.jsp");
            	return;
        	}
        	
            List<Incident> incidents = (List<Incident>)request.getAttribute("incidents");
            if (incidents != null) {
                for (Incident inc : incidents) {
        %>
            <tr>
                <td><%= inc.getId() %></td>
                <td><%= inc.getName() %></td>
                <td><%= inc.getEmail() %></td>
                <td><%= inc.getIssue() %></td>
                <td><%= inc.getDescription() %></td>
                <td>
                    <form action="UpdateStatusServlet" method="post" class="d-flex align-items-center">
                        <input type="hidden" name="id" value="<%= inc.getId() %>">
                        <select name="status" class="form-select form-select-sm me-2">
                            <option value="Open" <%= "Open".equals(inc.getStatus()) ? "selected" : "" %>>Open</option>
                            <option value="In Progress" <%= "In Progress".equals(inc.getStatus()) ? "selected" : "" %>>In Progress</option>
                            <option value="Closed" <%= "Closed".equals(inc.getStatus()) ? "selected" : "" %>>Closed</option>
                        </select>
                        <button type="submit" class="btn btn-sm btn-primary">Update</button>
                    </form>
                </td>
                <td>
                    <form action="UpdateStatusServlet" method="post" class="d-flex align-items-center">
                        <input type="hidden" name="id" value="<%= inc.getId() %>">
                        <input type="text" name="assignedTo" class="form-control form-control-sm me-2" value="<%= inc.getAssignedTo() == null ? "" : inc.getAssignedTo() %>">
                        <button type="submit" class="btn btn-sm btn-secondary" name="assign" value="1">Assign</button>
                    </form>
                </td>
                <td><small><%= inc.getSubmittedAt() %></small></td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <form action="LogoutServlet" method="get">
	    <button type="submit" class="btn btn-outline-primary mt-3">Log Out</button>
	</form>
</div>
</body>
</html> 