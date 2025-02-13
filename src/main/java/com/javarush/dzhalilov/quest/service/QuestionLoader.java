package com.javarush.dzhalilov.quest.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.dzhalilov.quest.entity.Question;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class QuestionLoader {
    public List<Question> loadQuestions() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json")) {
            if (inputStream == null) {
                throw new IOException("Не найден ресурс questions.json");
            }
            Question[] questionsArray = mapper.readValue(inputStream, Question[].class);
            return Arrays.asList(questionsArray);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка чтения данных из questions.json", e);
        }
    }
}
