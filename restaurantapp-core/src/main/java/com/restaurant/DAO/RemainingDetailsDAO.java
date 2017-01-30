package com.restaurant.DAO;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.ItemsList;
import com.restaurant.model.RemainingDetails;
import com.restaurant.model.Sessions;
import com.restaurant.util.ConnectionUtil;

public class RemainingDetailsDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(RemainingDetails remains) {

		String sql = "insert into remaining_details(sno,se_id,item_id,remaining) values(?,?,?,?)";
		Object[] params = { remains.getSno(), remains.getSeId().getSessionId(), remains.getItemId().getItemId(),
				remains.getRemaining() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(RemainingDetails remains) {

		String sql = "update remaining_details set remaining=? where item_Id=?";
		Object[] params = { remains.getSeId().getSessionId(), remains.getItemId().getItemId(), remains.getRemaining() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int itemid) {

		String sql = "delete from remaining_details where item_id=?";
		Object[] params = { itemid };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<RemainingDetails> list() {

		String sql = "select * from remaining_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			RemainingDetails remaining = new RemainingDetails();

			ItemsList items = new ItemsList();
			Sessions session = new Sessions();
			remaining.setSno(rs.getInt("sno"));
			items.setItemId(rs.getInt("item_id"));
			remaining.setItemId(items);
			session.setSessionId(rs.getInt("se_id"));
			remaining.setSeId(session);
			remaining.setRemaining(rs.getInt("remaining"));
			return remaining;

		});
	}

	/*
	 * public ItemsLIst listbyId(int id) { String
	 * sql="select remaining from remaining_details where item_id=? and session_id=?"
	 * ; Object[] params = {id}; return
	 * jdbcTemplate.queryForObject(sql,params,(rs,rowNum) -> { ItemsLIst items =
	 * new ItemsLIst(); RemainingDetails remaining = new RemainingDetails();
	 * Sessions session = new Sessions();
	 * 
	 * items.setItemId(rs.getInt("item_id")); remaining.setItemId(items);
	 * session.setSessionId(rs.getInt("session_id"));
	 * remaining.setSeId(session);
	 * remaining.setRemaining(rs.getInt("remaining")); return remaining;
	 * 
	 * 
	 * 
	 * 
	 * });
	 */

}
