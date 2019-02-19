package com.casestudy.quizservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casestudy.quizservice.model.ResultHistory;
import com.casestudy.quizservice.model.ResultHistoryId;

@Repository
public interface ResultHistoryRepository extends CrudRepository<ResultHistory, ResultHistoryId> {

	@Query("SELECT rh from ResultHistory rh WHERE rh.id.quizId = :quizId and rh.id.userId = :userId")
	public List<ResultHistory> getResultHistoryById(@Param("quizId") long quizId, @Param("userId") long userId);

	@Query("SELECT rh from ResultHistory rh WHERE rh.id.userId = :userId")
	public List<ResultHistory> getResultHistoryByUserId(@Param("userId") long userId);

}