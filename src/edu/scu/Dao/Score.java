package edu.scu.Dao;

import java.util.Date;

public class Score {
	private int id;
	private String name;
	private int score;
	private Date date; 
	public Score() {}
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public Score(int id, String name, int score, Date date) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.date = date;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
