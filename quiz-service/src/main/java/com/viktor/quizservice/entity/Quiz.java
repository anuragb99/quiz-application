package com.viktor.quizservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String quizName;

    @ElementCollection
    List<Integer> questionIds;

}
