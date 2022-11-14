package org.mql.java.xml.model;

import java.util.List;
import java.util.Vector;

public class Document {
	private int id;
	private String title;
	private List<Author> authors;
	private Publisher publisher;
	
	public Document() {
	}
	
	public Document(int id) {
		this.id = id;
	}

	public Document(int id, String title, Publisher publisher) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		authors = new Vector<>();
	}
	
	public void add(Author a) {
		authors.add(a);
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", authors=" + authors + ", publisher=" + publisher + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
