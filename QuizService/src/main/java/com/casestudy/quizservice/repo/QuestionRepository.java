package com.casestudy.quizservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casestudy.quizservice.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

	@Query("SELECT q.questionId FROM Question q WHERE q.quiz.quizId = :quizId")
	public List<Long> findByQuizId(@Param("quizId") long quizId);

}
