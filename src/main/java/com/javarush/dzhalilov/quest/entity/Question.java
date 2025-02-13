package com.javarush.dzhalilov.quest.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Question {
    @JsonProperty("questionId")
    private long questionId;
    @JsonProperty("question")
    private String questionText;
    @JsonProperty("answers")
    private List<Answer> answers;

    public Question() {
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long id) {
        this.questionId = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}