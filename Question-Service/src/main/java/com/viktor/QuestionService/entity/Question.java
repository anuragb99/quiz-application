package com.viktor.QuestionService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
