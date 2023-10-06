package com.viktor.quizservice.feign;

import com.viktor.quizservice.entity.QuestionWrapper;
import com.viktor.quizservice.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question-service/question/generate")
    public ResponseEntity<List<Integer>> generate(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("question-service/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionByIds(@RequestBody List<Integer> id);

    @PostMapping("question-service/question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
