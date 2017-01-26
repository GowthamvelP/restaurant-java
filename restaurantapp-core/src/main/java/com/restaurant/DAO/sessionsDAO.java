package com.restaurant.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.sessions;
import com.restaurant.util.ConnectionUtil;

public class sessionsDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(sessions session) {

		String sql = "insert into sessions(session_id,session_name,from_time,to_time,quantity) values(?,?,?,?,?)";
		Object[] params = { session.getSessionId(), session.getSessionName(),session.getFromTime(),session.getToTime(),session.getQuantity()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(sessions session) {

		String sql = "update sessions set session_name=? where session_id=?";
		Object[] params = {session.getSessionId(), session.getSessionName(),session.getFromTime(),session.getFromTime(),session.getQuantity()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int SessionId) {

		String sql = "delete from sessions where session_id=?";
		Object[] params = { SessionId };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<sessions> list()
	{
		String sql = "select * from sessions";
		sessions session = new sessions();
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			session.setSessionId(rs.getInt("session_id"));
			session.setSessionName(rs.getString("session_name"));
			session.setFromTime(rs.getString("from_time"));
			session.setToTime(rs.getString("to_time"));
			session.setQuantity(rs.getInt("quantity"));
			return session;
			
		});
		
		public sessions listById(int id)
		{
		  String sql = "select session_name from sessions where session_id=?";	
		  Object[] params = { id };
		  return jdbcTemplate.query(sql,params,(rs,rowNum) ->
		  {
			  sessions session1 = new sessions();

			session1.setSessionId(rs.getInt("session_id"));
			session1.setSessionName(rs.getString("session_name"));
			return session1;
			  
		  });
			
			
		}
		
		
		
	}

}