package com.casestudy.quizservice.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.quizservice.model.Category;
import com.casestudy.quizservice.model.Quiz;
import com.casestudy.quizservice.model.QuizResult;
import com.casestudy.quizservice.model.ResultHistory;
import com.casestudy.quizservice.model.User;

public interface QuizService {

	public Optional<Quiz> getQuiz(long quizId);

	public List<ResultHistory> getResultHistory(long userId);

	public List<Category> getAllCategory();

	public QuizResult assessQuiz(User user, long quizId);

}
