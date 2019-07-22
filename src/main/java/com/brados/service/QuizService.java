package com.brados.service;

import com.brados.model.Quiz;

public interface QuizService {
	
	void addQuiz(Quiz quiz);
	void updateQuiz(Quiz quiz);
	void deleteQuiz(int quizId);
	Quiz getQuizById(int quizId);

}
