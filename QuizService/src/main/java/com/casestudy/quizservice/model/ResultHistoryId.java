package com.casestudy.quizservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ResultHistoryId implements Serializable {

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "QUIZ_ID")
	private Long quizId;

	@Column(name = "ATTEMPT")
	private Long attempt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getAttempt() {
		return attempt;
	}

	public void setAttempt(Long attempt) {
		this.attempt = attempt;
	}

	public ResultHistoryId(Long userId, Long quizId, Long attempt) {
		super();
		this.userId = userId;
		this.quizId = quizId;
		this.attempt = attempt;
	}

	public ResultHistoryId() {
		super();
	}

}
