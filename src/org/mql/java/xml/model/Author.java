package org.mql.java.xml.model;

public class Author {
	private int id;
	private String name;
	private Date dateOfBirth;
	private String country;
	
	public Author(int id) {
		this.id = id;
	}
	
	public Author(int id, String name, Date dateOfBirth, String country) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", dateOfBirth=" + dateOfBirth + ", name=" + name + ", country=" + country + "]";
	}
}
