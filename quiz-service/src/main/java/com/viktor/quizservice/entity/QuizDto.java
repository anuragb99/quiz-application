package com.viktor.quizservice.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class QuizDto {
    String category;
    String quizName;
    Integer numQ;
}
