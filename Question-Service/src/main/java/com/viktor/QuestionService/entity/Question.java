package com.viktor.QuestionService.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String category;

    String difficultyLevel;

    String option1;

    String option2;

    String option3;

    String option4;

    String questionTitle;

    String rightAnswer;

}
