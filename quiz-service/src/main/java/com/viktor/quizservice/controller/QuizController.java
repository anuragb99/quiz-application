package com.viktor.quizservice.controller;

import com.viktor.quizservice.dao.QuizDao;
import com.viktor.quizservice.entity.QuestionWrapper;
import com.viktor.quizservice.entity.QuizDto;
import com.viktor.quizservice.entity.Response;
import com.viktor.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @Autowired
    private QuizDao quizDao;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getQuizName(), quizDto.getNumQ());
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("calculateResult/{id}")
    public ResponseEntity<Integer> calculateResult(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
