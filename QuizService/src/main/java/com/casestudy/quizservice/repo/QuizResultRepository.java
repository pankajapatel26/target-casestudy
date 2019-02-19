package com.casestudy.quizservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.quizservice.model.QuizResult;

@Repository
public interface QuizResultRepository extends CrudRepository<QuizResult, Long> {

}