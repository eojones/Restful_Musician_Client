package br.com.fiap.entity;

import java.util.Calendar;

public class Musician {
	private int id;

	private String name;

	private String genre;

	private Calendar debutDate;

	private String country;

	public Musician(int id, String name, String genre, Calendar debutDate, String country) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.debutDate = debutDate;
		this.country = country;
	}

	public Musician() {
		super();
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

	public Calendar getDebutDate() {
		return debutDate;
	}

	public void setDebutDate(Calendar debutDate) {
		this.debutDate = debutDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
