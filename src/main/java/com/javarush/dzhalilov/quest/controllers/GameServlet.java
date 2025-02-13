package com.javarush.dzhalilov.quest.controllers;
import com.javarush.dzhalilov.quest.entity.Question;
import com.javarush.dzhalilov.quest.service.GameService;
import com.javarush.dzhalilov.quest.service.GameState;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    private GameService gameService;

    public void init() {
        try {
            gameService = new GameService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String answerIdString = request.getParameter("answer");
        Long currentQuestionId = (Long) session.getAttribute("currentQuestionId");

        if (currentQuestionId == null) {
            currentQuestionId = 1L;
        }

        if (answerIdString != null && !answerIdString.isEmpty()) {
            Long answerId = Long.parseLong(answerIdString);

            GameState gameState = gameService.chooseAnswer(currentQuestionId, answerId);
            if (gameState.isGameOver()) {
                String resultClass = gameState.getResult().equals("WIN") ? "win-page" : "lose-page";
                session.setAttribute("result", gameState.getResult());
                session.setAttribute("resultClass", resultClass);
                request.setAttribute("result", gameState.getResult());
                session.removeAttribute("currentQuestionId");
                request.getRequestDispatcher("/result.jsp").forward(request, response);
                return;
            } else {
                currentQuestionId = gameState.getNextQuestion().getQuestionId();
                session.setAttribute("currentQuestionId", currentQuestionId);
            }
        }
        Question currentQuestion = gameService.getQuestionById(currentQuestionId);
        request.setAttribute("question", currentQuestion);
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
}