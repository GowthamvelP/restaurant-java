package com.restaurant.dao;

import java.util.List;

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
		jdbcTemplate.update(sql, params);

	}

	public void update(RemainingDetails remains) {

		String sql = "update remaining_details set remaining=? where item_Id=?";
		Object[] params = { remains.getSeId().getSessionId(), remains.getItemId().getItemId(), remains.getRemaining() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int itemid) {

		String sql = "delete from remaining_details where item_id=?";
		Object[] params = { itemid };
		jdbcTemplate.update(sql, params);

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

}
