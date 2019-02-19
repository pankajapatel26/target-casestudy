package com.casestudy.quizservice.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUIZ_ID")
	private long quizId;

	@ManyToOne
	@JoinColumn(name = "CAT_ID", nullable = false)
	@JsonIgnore
	private Category category;

	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Question> questions;

	@Column(name = "QUIZ_DESC")
	private String quizDesc;

	@NotNull
	@Column(name = "QUIZ_NAME")
	private String quizName;

	@Column(name = "DIFFICULTY_LEVEL")
	private String difficultyLevel;

	@NotNull
	@Column(name = "DURATION")
	private long duration;

	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> question) {
		this.questions = question;
	}

	public String getQuizDesc() {
		return quizDesc;
	}

	public void setQuizDesc(String quizDesc) {
		this.quizDesc = quizDesc;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Quiz(long quizId, Category category, Set<Question> questions, String quizDesc, @NotNull String quizName,
			String difficultyLevel, @NotNull long duration, LocalDateTime createdDate) {
		super();
		this.quizId = quizId;
		this.category = category;
		this.questions = questions;
		this.quizDesc = quizDesc;
		this.quizName = quizName;
		this.difficultyLevel = difficultyLevel;
		this.duration = duration;
		this.createdDate = createdDate;
	}

	public Quiz() {
		super();
	}

}
