package com.viktor.QuestionService.service;

import com.viktor.QuestionService.dao.QuestionDao;
import com.viktor.QuestionService.entity.Question;
import com.viktor.QuestionService.entity.QuestionWrapper;
import com.viktor.QuestionService.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.getQuestionByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> generateQuestions(String category, Integer numQ) {
        return new ResponseEntity<>(questionDao.getQuestionsForQuiz(category, numQ), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionByIds(List<Integer> id) {
        List<QuestionWrapper> questionWrapperList = new ArrayList<>();
        for (Integer i : id) {
            Question question = questionDao.findById(i).get();
            questionWrapperList.add(new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()));
        }
        return new ResponseEntity<>(questionWrapperList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        try {
            int score = 0;

            for (Response r : responses) {
                Question question = questionDao.findById(r.getId()).get();
                if (question.getRightAnswer().equalsIgnoreCase(r.getSelectedAns())) {
                    score+=1;
                }
            }

            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
    }
}
