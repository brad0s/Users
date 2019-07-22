package com.brados.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Quiz {
	
	@Autowired
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	@Autowired
	private ArrayList<Question> questions = new ArrayList<Question>();
	private int id;
	private int userId;
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Quiz [answers=" + answers + ", questions=" + questions + ", id=" + id + "]";
	}
	
}
