package com.codeme.homework4.beandanych.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codeme.homework4.beandanych.GetConfigValues;

public class Books {

	private List<Book> books = new ArrayList<>();
	private Book newBook = null;
	private Connection conn = null;
	private PreparedStatement stm = null;
	private ResultSet resSet = null;

	public enum Columns {
		ID("id"), TITLE("title"), AUTHOR("author"), PUBLISHYEAR("publishYear"), AMOUNT("amount");

		private String columnName;

		private Columns(String columnName) {
			this.columnName = columnName;
		}
	}

	public List<Book> loadBooksFromDb() throws SQLException {
		// getting config values from a file
		GetConfigValues getConfigValues = new GetConfigValues();
		getConfigValues.loadConfigValues();
		String dbUrl = getConfigValues.getDbUrl();
		String dbUser = getConfigValues.getUserName();
		String dbPass = getConfigValues.getPass();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			stm = conn.prepareStatement("select * from books");
			resSet = stm.executeQuery();

			while (resSet.next()) {
				newBook = new Book();

				for (int i = 1; i <= resSet.getMetaData().getColumnCount(); i++) {

					Columns colName = getColumnName(resSet.getMetaData().getColumnName(i));

					switch (colName) {
					case ID:
						newBook.setId(Integer.valueOf(resSet.getString(i)));
						break;
					case TITLE:
						newBook.setTitle(resSet.getString(i));
						break;
					case AUTHOR:
						newBook.setAuthor(resSet.getString(i));
						break;
					case PUBLISHYEAR:
						newBook.setPublishYear(resSet.getString(i));
						break;
					case AMOUNT:
						newBook.setAmount(Integer.valueOf(resSet.getString(i)));
						break;
					}
				}
				books.add(newBook);
			}
			return books;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			resSet.close();
			stm.close();
			conn.close();
		}
		return null;
	}

	private Columns getColumnName(String colName) {
		for (Columns columnName : Columns.values()) {
			if (columnName.columnName.equals(colName)) {
				return columnName;
			}
		}
		return null;
	}

}
