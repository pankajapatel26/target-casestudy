package com.casestudy.quizservice;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.casestudy.quizservice.model.Quiz;
import com.casestudy.quizservice.repo.QuizRepository;
import com.casestudy.quizservice.service.QuizService;
import com.casestudy.quizservice.service.impl.QuizServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizServiceApplicationTests {

	@Mock
	private static QuizRepository quizRepository;

	@InjectMocks
	private static QuizService accountService = new QuizServiceImpl();

	private Quiz quiz;

	@Test
	public void testFindQuiz() {

		Long quizId = new Long(1);

		quiz = new Quiz();
		quiz.setQuizId(1);
		quiz.setDifficultyLevel("EASY");
		quiz.setQuizName("Java Test");
		quiz.setQuizDesc("Jave questions");

		Mockito.when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));

		Optional<Quiz> retrivedquiz = accountService.getQuiz(quizId);

		Assert.assertEquals(quiz, retrivedquiz.get());
	}

}
