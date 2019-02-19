package com.casestudy.quizservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "quiz_result")
public class QuizResult implements Serializable {

	@Id
	private long quizResultId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	// @JoinColumns(value = { @JoinColumn(name = "id", referencedColumnName = "id")
	// })
	private User user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "QUIZ_ID", nullable = false)
	// @JoinColumns(value = { @JoinColumn(name = "quizId", referencedColumnName =
	// "quiz_id") })
	private Quiz quiz;

	@Column(name = "RESULT")
	private boolean result;

	@Column(name = "PERCENTAGE")
	private Double percentage;

	@NotNull
	@Column(name = "STATUS")
	private String status;

	@NotNull
	@Column(name = "ATTEMPT")
	private Long attempt;

	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	public long getQuizResultId() {
		return quizResultId;
	}

	public void setQuizResultId(long quizResultId) {
		this.quizResultId = quizResultId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAttempt() {
		return attempt;
	}

	public void setAttempt(Long attempt) {
		this.attempt = attempt;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public QuizResult(QuizResultId id, User user, Quiz quiz, boolean result, Double percentage, @NotNull String status,
			@NotNull Long attempt, LocalDateTime createdDate) {
		super();
		// this.id = id;
		this.user = user;
		this.quiz = quiz;
		this.result = result;
		this.percentage = percentage;
		this.status = status;
		this.attempt = attempt;
		this.createdDate = createdDate;
	}

	public QuizResult() {
		super();
	}
	
	

}
