package com.viktor.quizservice.service;


import com.viktor.quizservice.dao.QuizDao;
import com.viktor.quizservice.entity.QuestionWrapper;
import com.viktor.quizservice.entity.Quiz;
import com.viktor.quizservice.entity.Response;
import com.viktor.quizservice.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, String quizName, Integer numQ){

        try {

            List<Integer> questionIds = quizInterface.generate(category , numQ).getBody();
            Quiz quiz = new Quiz();
            quiz.setQuizName(quizName);
            quiz.setQuestionIds(questionIds);
            quizDao.save(quiz);

            return new ResponseEntity<>("success", HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        try{
            Optional<Quiz> quiz = quizDao.findById(id);

            ResponseEntity<List<QuestionWrapper>> response = quizInterface.getQuestionByIds(quiz.get().getQuestionIds());

            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        try {
            Quiz quiz = quizDao.findById(id).get();
            Integer score = quizInterface.getScore(responses).getBody();
            return new ResponseEntity<>(score, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(-1,HttpStatus.BAD_REQUEST);
    }
}
