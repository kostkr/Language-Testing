package com.WebSite.demo.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Answers implements Iterable<String> {
    private String good;
    private String bad1;
    private String bad2;
    private String bad3;

    public Answers(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            this.good = jsonNode.get("good").asText();
            this.bad1 = jsonNode.get("bad1").asText();
            this.bad2 = jsonNode.get("bad2").asText();
            this.bad3 = jsonNode.get("bad3").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getGood() {
        return good;
    }

    public String getBad1() {
        return bad1;
    }

    public String getBad2() {
        return bad2;
    }

    public String getBad3() {
        return bad3;
    }

    @Override
    public Iterator<String> iterator() {
        return new AnswersIterator();
    }

    private class AnswersIterator implements Iterator<String> {
        private final List<String> answersList;

        private int currentIndex = 0;

        public AnswersIterator() {
            answersList = new ArrayList<>();
            answersList.add(good);
            answersList.add(bad1);
            answersList.add(bad2);
            answersList.add(bad3);
            Collections.shuffle(answersList);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < answersList.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return answersList.get(currentIndex++);
        }
    }

    public static List<Answers> createAnswersList(List<String> jsonStrings) {
        List<Answers> answersList = new ArrayList<>();
        for (String jsonString : jsonStrings) {
            answersList.add(new Answers(jsonString));
        }
        return answersList;
    }

}

