package com.sathish.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.springboot.web.model.Question;
import com.sathish.springboot.web.service.SurveyService;

@RestController
class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }
    
    @GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveDetailsForQuestion(@PathVariable String surveyId,
            @PathVariable String questionId) {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }
}