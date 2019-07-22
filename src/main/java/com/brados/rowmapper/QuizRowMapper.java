package com.brados.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brados.model.Quiz;

public class QuizRowMapper implements RowMapper<Quiz> {
	@Override
	public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
		Quiz quiz = new Quiz();
		quiz.setId(rs.getInt("id"));
		quiz.setUserId(rs.getInt("user_id"));
		return quiz;
	}
}
