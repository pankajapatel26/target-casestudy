package com.casestudy.quizservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private long questionId;

	@ManyToOne
	@JoinColumn(name = "QUIZ_ID", nullable = false)
	@JsonIgnore
	private Quiz quiz;

	@NotNull
	@Column(name = "QUESTION_DESCRIPTION")
	private String questionDescription;

	@NotNull
	@Column(name = "CHOICE1")
	private String choice1;

	@NotNull
	@Column(name = "CHOICE2")
	private String choice2;

	@Column(name = "CHOICE3")
	private String choice3;

	@Column(name = "CHOICE4")
	private String choice4;

	@NotNull
	@Column(name = "QUESTION_TYPE")
	private String questionType;

	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Question(long questionId, Quiz quiz, @NotNull String questionDescription, @NotNull String choice1,
			@NotNull String choice2, String choice3, String choice4, @NotNull String questionType,
			LocalDateTime createdDate) {
		super();
		this.questionId = questionId;
		this.quiz = quiz;
		this.questionDescription = questionDescription;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.questionType = questionType;
		this.createdDate = createdDate;
	}

	public Question() {
		super();
	}
	
	

}
