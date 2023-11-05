package com.viktor.QuestionService.dao;

import com.viktor.QuestionService.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionDaoTest {

    @Autowired
    QuestionDao questionDao;

    @Test
    void getQuestionByCategory() {
        List<Question> questionList = questionDao.getQuestionByCategory("java");
        assert(!CollectionUtils.isEmpty(questionList));
    }

    @Test
    void getQuestionsForQuiz() {
        List<Integer> questionList = questionDao.getQuestionsForQuiz("java",1);
        assert(!CollectionUtils.isEmpty(questionList));
    }
}