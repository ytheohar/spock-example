package org.ytheohar.book;

import java.util.Date;

public class Book {
	private final String title;
	private final String author;
	private final Date published;

	public Book(final String title, final String author, final Date published) {
		this.title = title;
		this.author = author;
		this.published = published;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getPublished() {
		return published;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [title=").append(title).append(", author=").append(author).append(", published=").append(published).append("]");
		return builder.toString();
	}
}
