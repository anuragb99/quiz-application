package com.viktor.QuestionService.dao;


import com.viktor.QuestionService.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> getQuestionByCategory(String category);

    @Query(value = "SELECT q.id FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> getQuestionsForQuiz(String category,Integer numQ);

}
