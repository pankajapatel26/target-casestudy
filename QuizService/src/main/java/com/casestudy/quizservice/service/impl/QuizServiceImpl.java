package com.casestudy.quizservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.quizservice.model.Answer;
import com.casestudy.quizservice.model.Category;
import com.casestudy.quizservice.model.Quiz;
import com.casestudy.quizservice.model.QuizResult;
import com.casestudy.quizservice.model.ResultHistory;
import com.casestudy.quizservice.model.ResultHistoryId;
import com.casestudy.quizservice.model.User;
import com.casestudy.quizservice.model.UserSelection;
import com.casestudy.quizservice.repo.AnswerRepository;
import com.casestudy.quizservice.repo.CategoryRepository;
import com.casestudy.quizservice.repo.QuestionRepository;
import com.casestudy.quizservice.repo.QuizRepository;
import com.casestudy.quizservice.repo.QuizResultRepository;
import com.casestudy.quizservice.repo.ResultHistoryRepository;
import com.casestudy.quizservice.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuizResultRepository quizResultRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ResultHistoryRepository resultHistoryRepository;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public Optional<Quiz> getQuiz(long quizId) {
		try {
			Optional<Quiz> quiz = quizRepository.findById(quizId);
			return quiz;
		} catch (Exception e) {
			LOGGER.info("Exception occured in getQuiz. Message " + e.getMessage());
		}
		return null;

	}

	@Override
	public List<ResultHistory> getResultHistory(long userId) {
		try {
			List<ResultHistory> resultHistory = resultHistoryRepository.getResultHistoryByUserId(userId);
			return resultHistory;
		} catch (Exception e) {
			LOGGER.info("Exception occured in getResultHistory. Message " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		try {
			ArrayList<Category> categoryList = (ArrayList<Category>) categoryRepository.findAll();
			return categoryList;
		} catch (Exception e) {
			LOGGER.info("Exception occured in getAllCategory. Message " + e.getMessage());
		}
		return null;
	}

	@Override
	public QuizResult assessQuiz(User user, long quizId) {
		try {
			Optional<Quiz> quiz = quizRepository.findById(quizId);
			List<Long> questionIds = questionRepository.findByQuizId(quizId);
			List<Answer> answers = answerRepository.findByQuestionId(questionIds);
			//Map<Long, String> selectedAnswerMap = user.getUserSelections();
			
			Map<Long, String> selectedAnswerMap = user.getUserSelections().stream()
					.collect(Collectors.toMap(a -> a.getQueId(), a -> a.getAnswer()));

			Map<Long, String> answerMap = answers.stream()
					.collect(Collectors.toMap(a -> a.getQuestion().getQuestionId(), a -> a.getAnswer()));

			Map<Long, Boolean> resultMap = selectedAnswerMap.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().equals(answerMap.get(e.getKey()))));
			List<ResultHistory> resultHistoryList = resultHistoryRepository.getResultHistoryById(quizId, user.getId());
			int count = (int) resultMap.values().stream().filter(i -> i == true).count();
			Double percentage = ((double) count / (double) questionIds.size()) * 100;
			boolean result = percentage > 35 ? true : false;
			QuizResult quizResult = new QuizResult();
			quizResult.setAttempt((long) (resultHistoryList.size() + 1));
			quizResult.setPercentage(percentage);
			quizResult.setQuiz(quiz.get());
			quizResult.setResult(result);
			quizResult.setStatus("COMPLETED");
			quizResult.setUser(user);
			quizResultRepository.save(quizResult);

			ResultHistory newResultHistory = new ResultHistory();
			ResultHistoryId resultHistoryId = new ResultHistoryId();
			resultHistoryId.setAttempt((long) (resultHistoryList.size() + 1));
			resultHistoryId.setQuizId(quizId);
			resultHistoryId.setUserId(user.getId());
			newResultHistory.setPercentage(percentage);
			newResultHistory.setResult(result);
			newResultHistory.setId(resultHistoryId);

			resultHistoryRepository.save(newResultHistory);

			return quizResult;
		} catch (Exception e) {
			LOGGER.info("Exception occured in assessQuiz. Message " + e.getMessage());
		}
		return null;
	}

}
