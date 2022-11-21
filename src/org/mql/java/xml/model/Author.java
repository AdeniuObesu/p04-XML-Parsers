package org.mql.java.xml.model;

public class Author {
	private int id;
	private Date dateOfBirth;
	private String name;
	private String country;
	
	public Author(int id) {
		this.id = id;
	}
	
	public Author(int id, Date dateOfBirth, String name, String country) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
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
