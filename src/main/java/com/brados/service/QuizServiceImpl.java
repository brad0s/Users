package com.brados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.brados.dao.QuizDao;
import com.brados.model.Quiz;

public class QuizServiceImpl implements QuizService {

	@Autowired
	@Qualifier("quizRepo")
	private QuizDao quizRepo;
	public void setQuizRepo(QuizDao quizRepo) {
		this.quizRepo = quizRepo;
	}
	
	@Override
	public void addQuiz(Quiz quiz) {
		
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQuiz(int quizId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quiz getQuizById(int quizId) {
		// TODO Auto-generated method stub
		return null;
	}

}
