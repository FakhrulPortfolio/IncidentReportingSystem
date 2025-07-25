<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Report Incident</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-6">
                <div class="card shadow-lg">
                    <div class="card-header bg-primary text-white text-center">
                        <h3 class="mb-0">Report an Incident</h3>
                    </div>
                    <div class="card-body">
                        <form action="ReportIncidentServlet" method="post" enctype="multipart/form-data">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="mb-3">
                                <label for="issue" class="form-label">Main Issue</label>
                                <input type="text" class="form-control" id="issue" name="issue" required>
                            </div>
                            <div class="mb-3">
                                <label for="description" class="form-label">Description</label>
                                <textarea class="form-control" id="description" name="description" rows="4" required></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="image" class="form-label">Upload Image (optional)</label>
                                <input class="form-control" type="file" id="image" name="image" accept="image/*">
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Submit Incident</button>
                        </form>
                    </div>
                </div>
                <div class="text-center mt-3">
                    <small class="text-muted">Your report helps us improve safety. Thank you!</small>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
