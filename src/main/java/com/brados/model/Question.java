package com.brados.model;
import java.util.ArrayList;
import java.util.List;

import com.brados.model.Answer;

public class Question {
	
	private String id;
	private String question;
	private List<Answer> answers = new ArrayList<Answer>();
	private int quizId;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
//	public Answer getAnswer() {
//		return answer;
//	}
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Answer answer) {
		this.answers.add(answer);
	}

}
