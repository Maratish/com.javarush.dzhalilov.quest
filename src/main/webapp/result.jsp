<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <%@ include file="header.jsp" %>
  <title>Результат</title>
  <style>
    .result-card {
      padding: 2rem;
      margin: 2rem auto;
    }
  </style>
</head>
<body class="${resultClass} d-flex align-items-center">
<div class="main-card">
  <div class="result-card text-center">
    <h1 class="${result == 'WIN' ? 'text-success' : 'text-danger'} big-title mb-4">
      ${result == "WIN" ? "Победа!" : "Поражение!"}
    </h1>
    <p class="lead mb-4">
      ${result == "WIN" ? "Красавчик жи есть!" : "ЗРЯ!"}
    </p>
    <a href="game" class="btn button-style btn-lg px-5">⟳ Начать заново</a>
  </div>
</div>
</body>