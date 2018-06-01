package com.codeme.homework4.beandanych.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	
	private Integer id = null;
	private String title = null;
	private String author = null;
	private Date publishYear = new Date();
	private DateFormat df = new SimpleDateFormat("yyyy");
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

	public String getPublishYear() {
		return df.format(publishYear);
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

	public void setPublishYear(String publishYear) {
		try {
			this.publishYear = df.parse(publishYear);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format("%d) %s by %s", id, title, author);
		
	}
}
