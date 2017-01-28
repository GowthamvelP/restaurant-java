package com.restaurant.DAO;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
/*import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;*/
import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.Sessions;
import com.restaurant.util.ConnectionUtil;

public class SessionsDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Sessions session) {

		try {
			String sql = "insert into sessions(session_id,session_name,from_time,to_time,quantity) values(?,?,?,?,?)";
			Object[] params = { session.getSessionId(), session.getSessionName(), session.getFromTime(),
					session.getToTime(), session.getQuantity() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows inserted: " + rows);
		} catch (DuplicateKeyException e) {
			System.out.println("Cannot have a duplicate key");

		}
	}

	public void update(Sessions session) {

		String sql = "update sessions set session_name=? where session_id=?";
		Object[] params = { session.getSessionId(), session.getSessionName(), session.getFromTime(),
				session.getFromTime(), session.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int SessionId) {

		String sql = "delete from sessions where session_id=?";
		Object[] params = { SessionId };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<Sessions> list() {
		String sql = "select * from sessions";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Sessions session = new Sessions();
			session.setSessionId(rs.getInt("session_id"));
			session.setSessionName(rs.getString("session_name"));
			session.setFromTime(rs.getTime("from_time").toLocalTime());
			session.setToTime(rs.getTime("to_time").toLocalTime());
			session.setQuantity(rs.getInt("quantity"));
			return session;

		});
	}

	public Sessions listById(int id) {

		String sql = "select session_name,session_id from sessions where session_id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Sessions s = new Sessions();
			s.setSessionId(rs.getInt("session_id"));
			s.setSessionName(rs.getString("session_name"));
			return s;
		});

	}
}
