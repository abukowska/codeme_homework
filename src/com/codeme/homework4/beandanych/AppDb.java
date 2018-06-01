package com.codeme.homework4.beandanych;

import java.sql.SQLException;
import java.util.List;

import com.codeme.homework4.beandanych.model.Book;
import com.codeme.homework4.beandanych.model.Books;

public class AppDb {

	
	public static void main (String[] args ) {

		Books books = new Books();
		List<Book> bookList = null;
		
		try {
			bookList = books.loadBooksFromDb();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Book book : bookList) {
			System.out.println(book.toString());
		}
		
	}
	
}
