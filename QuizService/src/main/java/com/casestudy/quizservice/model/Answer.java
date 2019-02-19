package com.casestudy.quizservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ANSWER")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANSWER_ID")
	private long ansId;

	@OneToOne
	@JoinColumn(name = "QUESTION_ID", unique = true)
	private Question question;

	@NotNull
	@Column(name = "ANSWER")
	private String answer;

	@CreationTimestamp
	private LocalDateTime createdDate;

	public long getAnsId() {
		return ansId;
	}

	public void setAnsId(long ansId) {
		this.ansId = ansId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Answer(long ansId, Question question, @NotNull String answer, LocalDateTime createdDate) {
		super();
		this.ansId = ansId;
		this.question = question;
		this.answer = answer;
		this.createdDate = createdDate;
	}

	public Answer() {
		super();
	}
	
	
	

}