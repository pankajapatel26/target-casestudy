package com.casestudy.quizservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class QuizResultId {

	@Id
	@Column(name = "user_id")
	private long userId;

	@Id
	@Column(name = "quiz_id")
	private long quizId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public QuizResultId(long userId, long quizId) {
		super();
		this.userId = userId;
		this.quizId = quizId;
	}

	public QuizResultId() {
		super();
	}
	
	

}
