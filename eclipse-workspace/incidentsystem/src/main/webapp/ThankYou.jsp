<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thank You</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-lg text-center">
                    <div class="card-header bg-success text-white">
                        <h3 class="mb-0">Thank You!</h3>
                    </div>
                    <div class="card-body">
                        <p class="lead">Your incident report has been submitted successfully.</p>
                        <form action="Incident.jsp" method="get">
                            <button type="submit" class="btn btn-outline-primary mt-3">Submit Another Incident</button>
                        </form>
                    </div>
                </div>
                <div class="text-center mt-3">
                    <small class="text-muted">We appreciate your effort for reporting.</small>
                    <form action="LogoutServlet" method="get">
                            <button type="submit" class="btn btn-outline-primary mt-3">Log Out</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>