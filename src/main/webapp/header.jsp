<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Text Quest</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<style>
    body { font-family: 'Roboto', sans-serif; }
</style>
<div class="session-id">Сессия: <%= session.getId().substring(0, 8) %></div>
