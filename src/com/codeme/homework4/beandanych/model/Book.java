package com.codeme.homework4.beandanych.model;

import java.util.Date;

public class Book {
	
	private Integer id = null;
	private String title = null;
	private String author = null;
	private Date publishYear = new Date();
	private Integer amount = null;
	
	public Book() {
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getPublishYear() {
		return publishYear;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublishYear(Date publishYear) {
		this.publishYear = publishYear;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
