package com.viktor.QuestionService.service;

import com.viktor.QuestionService.dao.QuestionDao;
import com.viktor.QuestionService.entity.Question;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class QuestionServiceTest {

    @Mock
    QuestionDao questionDao;

    @InjectMocks
    QuestionService questionService;


    @Test
    void getQuestions() {

        when(questionDao.findAll()).thenReturn(getAllQuestion());

        ResponseEntity<List<Question>> questionList = questionService.getQuestions();
//        System.out.println(questionList.getBody().size());
        assert(!CollectionUtils.isEmpty(questionList.getBody()));
    }

    List<Question> getAllQuestion(){
        List<Question> questionList = new ArrayList<>();
        Question question1 = new Question(111,"java","easy","1","2","3",
                "4","HESOYAM","1");
        questionList.add(question1);
        return questionList;
    }

    @Test
    void getQuestionsByCategory() {

    }
}
