package com.casestudy.quizservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casestudy.quizservice.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	@Query("SELECT a FROM Answer a WHERE a.question.questionId in  ( :questionIds )")
	public List<Answer> findByQuestionId(@Param("questionIds") List<Long> questionIds);

}