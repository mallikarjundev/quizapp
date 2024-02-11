package com.example.quizapp.controller;

import com.example.quizapp.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{quizId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("quizId") Integer quizId){
        return questionService.deleteQuestion(quizId);
    }

    @PutMapping("updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
       return questionService.updateQuestion(question);

    }
}
