<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <%@ include file="header.jsp" %>
  <title>Игра</title>
  <style>
    .answer-card label {
      display: flex !important;
      align-items: center;
      gap: 15px;
      padding: 12px;
      margin: 0 auto;
      width: fit-content;
    }

    .answer-card input[type="radio"] {
      margin: 0;
      width: 20px;
      height: 20px;
    }
  </style>
</head>
<body class="game-page d-flex align-items-center">
<div class="main-card">
  <div class="mb-4">
    <h1 class="big-title text-center">${question.questionText}</h1>
  </div>
  <form action="game" method="get">
    <div class="answers-list">
      <c:forEach items="${question.answers}" var="answer">
        <div class="answer-card">
          <label class="d-block m-0">
            <input type="radio" name="answer" value="${answer.answerId}">
            <div class="flex-grow-1">${answer.answerText}</div>
          </label>
        </div>
      </c:forEach>
    </div>
    <div class="text-center mt-4">
      <button type="submit" class="btn button-style btn-lg px-5">Ответить</button>
    </div>
  </form>
</div>
</body>
</html>