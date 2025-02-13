package com.javarush.dzhalilov.quest.service;
import com.javarush.dzhalilov.quest.entity.Question;

public class GameState {
    private Question nextQuestion;
    private String result;

    public GameState(Question nextQuestion, String result) {
        this.nextQuestion = nextQuestion;
        this.result = result;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public String getResult() {
        return result;
    }

    public boolean isGameOver() {
        return result != null;
    }
}