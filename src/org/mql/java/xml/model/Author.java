package org.mql.java.xml.model;

public class Author {
	private int id;
	private String name;
	private Date dateOfBirth;
	private String country;
	
	public Author(int id, String name, Date dateOfBirth, String country) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", country=" + country + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
