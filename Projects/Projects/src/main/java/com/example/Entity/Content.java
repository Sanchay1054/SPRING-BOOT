package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="content")
public class Content {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int userid;
	private String title;
	private String language;
	private String about;
	private String comment;
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public int getUserId()
	{
		return userid;
	}
	private int good;
	public Content()
	{
		super();
	}
	public Content(String title, int userid, String language, String about, String comment) {
		super();
		this.userid = userid;
		this.title = title;
		this.language = language;
		this.about = about;
		this.comment = comment;
		this.good = 0;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	
}
