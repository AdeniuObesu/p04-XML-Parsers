package org.mql.java.xml.model;

public class Author {
	private int id;
<<<<<<< HEAD
	private String name;
	private Date dateOfBirth;
=======
	private Date dateOfBirth;
	private String name;
>>>>>>> reference
	private String country;
	
	public Author(int id) {
		this.id = id;
	}
	
<<<<<<< HEAD
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

=======
	public Author(int id, Date dateOfBirth, String name, String country) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}

>>>>>>> reference
	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

=======
>>>>>>> reference
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

<<<<<<< HEAD
=======
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

>>>>>>> reference
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
<<<<<<< HEAD
=======

	@Override
	public String toString() {
		return "Author [id=" + id + ", dateOfBirth=" + dateOfBirth + ", name=" + name + ", country=" + country + "]";
	}
>>>>>>> reference
}
