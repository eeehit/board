package com.eeehit.board.article;

import javax.persistence.*;

@Entity
public class Article {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 255, nullable = false)
	private String title;

	@Column(length = 255, nullable = false)
	private String content;

	@Column(length = 30, nullable = true)
	private String author;

	public Article() {
		this.setTitle(null);
		this.setContent(null);
	}

	public Article(String title, String content, String author) {
		this.setTitle(title);
		this.setContent(content);
		this.setAuthor(author);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
