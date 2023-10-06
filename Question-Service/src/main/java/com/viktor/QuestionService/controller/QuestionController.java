package com.viktor.QuestionService.controller;


import com.viktor.QuestionService.entity.Question;
import com.viktor.QuestionService.entity.QuestionWrapper;
import com.viktor.QuestionService.entity.Response;
import com.viktor.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/getQuestions")
    public ResponseEntity<List<Question>> getQuestion() {
        return questionService.getQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generate(@RequestParam String category, @RequestParam Integer numQ){
        return questionService.generateQuestions(category, numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionByIds(@RequestBody List<Integer> id){
        return questionService.getQuestionByIds(id);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);

    }
}
