package com.casestudy.quizservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.quizservice.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}