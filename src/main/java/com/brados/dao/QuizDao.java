package com.brados.dao;

import com.brados.model.Quiz;

public interface QuizDao {
	
	public Quiz getQuizById(int quizId);
	public void save(Quiz quiz);
	public void update(Quiz quiz);
	public void delete (int quizId);

}
