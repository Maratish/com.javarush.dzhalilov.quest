package com.javarush.dzhalilov.quest.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
    @JsonProperty("answerId")
    private long answerId;
    @JsonProperty("answerText")
    private String answerText;
    @JsonProperty("nextQuestionId")
    private Long nextQuestionId;
    @JsonProperty("win")
    private Boolean win = false;

    public Answer() {
    }

    public Boolean isWin() {
        return win;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }
}