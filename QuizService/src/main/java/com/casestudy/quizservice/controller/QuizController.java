package com.casestudy.quizservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.casestudy.quizservice.model.Category;
import com.casestudy.quizservice.model.Quiz;
import com.casestudy.quizservice.model.QuizResult;
import com.casestudy.quizservice.model.ResultHistory;
import com.casestudy.quizservice.model.User;
import com.casestudy.quizservice.service.QuizService;

@Controller
@CrossOrigin
@RequestMapping(path = "/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

	@GetMapping("/{quizId}")
	public @ResponseBody Optional<Quiz> getUser(@PathVariable long quizId) {
		Optional<Quiz> quiz = quizService.getQuiz(quizId);
		return quiz;
	}

	@GetMapping("/categories")
	public @ResponseBody List<Category> getAllCategory() {
		List<Category> categoryList = quizService.getAllCategory();
		return categoryList;
	}

	@GetMapping("result-history/{userId}")
	public @ResponseBody List<ResultHistory> getResultHistory(@PathVariable long userId) {
		List<ResultHistory> quiz = quizService.getResultHistory(userId);
		return quiz;
	}

	@PostMapping("assess/{quizId}")
	public @ResponseBody QuizResult assessQuiz(@RequestBody User user, @PathVariable long quizId) {
		QuizResult quizResult = quizService.assessQuiz(user, quizId);
		return quizResult;
	}

}
