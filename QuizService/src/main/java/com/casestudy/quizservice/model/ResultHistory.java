package com.casestudy.quizservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "result_history")
public class ResultHistory {

	@EmbeddedId
	private ResultHistoryId id;

	@Column(name = "RESULT")
	private boolean result;

	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	@Column(name = "PERCENTAGE")
	private Double percentage;

	public ResultHistoryId getId() {
		return id;
	}

	public void setId(ResultHistoryId id) {
		this.id = id;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public ResultHistory(ResultHistoryId id, boolean result, LocalDateTime createdDate, Double percentage) {
		super();
		this.id = id;
		this.result = result;
		this.createdDate = createdDate;
		this.percentage = percentage;
	}

	public ResultHistory() {
		super();
	}

}
