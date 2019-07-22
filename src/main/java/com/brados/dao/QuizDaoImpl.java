package com.brados.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.brados.model.Quiz;
import com.brados.rowmapper.QuizRowMapper;

@Repository
public class QuizDaoImpl implements QuizDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Quiz getQuizById(int quizId) {
		Quiz quiz = new Quiz();
		String sql = "select * from quiz where id = ?";
		quiz = (Quiz)jdbcTemplate.queryForObject(sql, new Object[] {quizId}, new QuizRowMapper() );
		return quiz;
	}

	@Override
	public void save(final Quiz quiz) {
		String sql = "insert into quiz (user_id) values (?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter () {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, quiz.getUserId());
			}
		});
	}

	@Override
	public void update(final Quiz quiz) {
		String sql = "update quiz set user_id = ? where user_id = ?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, quiz.getUserId());
			}
		});
	}

	@Override
	public void delete(final int quizId) {
		String sql = "delete from quiz where id = ?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, quizId);
			}
		});
	}

}
