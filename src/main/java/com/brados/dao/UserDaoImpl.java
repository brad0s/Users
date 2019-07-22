package com.brados.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brados.model.User;
import com.brados.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from quiz_user";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			User user = new User();
			user.setId((Integer)row.get("user_id"));
			user.setUser_name((String)row.get("user_name"));
			users.add(user);
		}
		return users;
	}
	@Override
	public User getUserById(int userId) {
		User user = new User();
		String sql = "select user_id, user_name from quiz_user where user_id = ?";
		user = (User)jdbcTemplate.queryForObject(sql, new Object[] {userId}, new UserRowMapper() );
		return user;
	}
	@Override
	public void save(final User user) {
		String sql = "insert into quiz_user (user_name) values (?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUser_name());
			}
		});
	}
	@Override
	public void update(final User user) {
		String sql = "update quiz_user set user_name  = ? where user_id = ?";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUser_name());
				ps.setInt(2, user.getId());
			}
		});
	}
	@Override
	public void delete(final int userId) {
		String sql = "delete from quiz_user where user_id = ?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, userId);
			}
		});
	}
}


//private EntityManager entityManager;
//@PersistenceContext
//public void setEntityManager(EntityManager entityManager) {
//	this.entityManager = entityManager;
//}
//@SuppressWarnings("unchecked")
//@Transactional(readOnly = true)
//public List<User> getAllUsers() {
//	return entityManager.createQuery("select q from quiz_user q").getResultList();
//}
//@Transactional(readOnly = true)
//public User getUserById(int userId) {
//	return entityManager.find(User.class, userId);
//}
//@Transactional
//public void save(User user) {
//	entityManager.persist(user);
//}
//@Transactional
//public void update(User user) {
//	entityManager.merge(user);
//}
//@Transactional
//public void delete(int userId) {
//	User user = getUserById(userId);
//	delete(user);
//}
//@Transactional
//public void delete(User user) {
//	entityManager.remove(user);
//}
