package com.javarush.dzhalilov.quest.service;
import com.javarush.dzhalilov.quest.entity.Answer;
import com.javarush.dzhalilov.quest.entity.Question;
import java.util.List;

public class GameService {

    private List<Question> questions;

    public GameService() {
        QuestionLoader questionLoader = new QuestionLoader();
        questions = questionLoader.loadQuestions();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestionById(Long id) {
        for (Question question : questions) {
            if (question.getQuestionId() == id)
                return question;
        }
        return null;
    }

    public Answer getAnswerById(Question question, Long answerId) {
        if (question == null) {
            return null;
        }
        for (Answer answer : question.getAnswers()) {
            if (answer.getAnswerId() == answerId)
                return answer;
        }
        return null;
    }

//    public String getNextQuestionOfSelectedAnswer(Long currentQuestionId, Long answerId) {
//        Question currentQuestion = getQuestionById(currentQuestionId);
//        if (currentQuestion == null) {
//            return "LOSS";
//        }
//        Answer selectedAnswer = getAnswerById(currentQuestion, answerId);
//        if (selectedAnswer == null) {
//            return "LOSS";
//        }
//        if (selectedAnswer.getNextQuestionId() == null) {
//            if (selectedAnswer.isWin() != null && selectedAnswer.isWin()) {
//                return "WIN";
//            } else {
//                return "LOSS";
//            }
//        }
//
//        return null;
//    }
    public GameState chooseAnswer(Long currentQuestionId, Long answerId) {
        Question currentQuestion = getQuestionById(currentQuestionId);
        if (currentQuestion == null) {
            return new GameState(null, "LOSS");
        }

        Answer selectedAnswer = getAnswerById(currentQuestion, answerId);
        if (selectedAnswer == null) {
            return new GameState(null, "LOSS");
        }

        if (selectedAnswer.getNextQuestionId() == null) {
            if (selectedAnswer.isWin() != null && selectedAnswer.isWin()) {
                return new GameState(null, "WIN");
            } else {
                return new GameState(null, "LOSS");
            }
        }

        Question nextQuestion = getQuestionById(selectedAnswer.getNextQuestionId());
        return new GameState(nextQuestion, null);
    }
}