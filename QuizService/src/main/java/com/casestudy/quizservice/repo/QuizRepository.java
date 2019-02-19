package com.casestudy.quizservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.quizservice.model.Quiz;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

}
