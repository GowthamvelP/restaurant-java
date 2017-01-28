package com.restaurant.DAO;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.MaximumQuantity;
import com.restaurant.util.ConnectionUtil;

public class MaximumQuantityDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(MaximumQuantity maxi) {
		try {
			String sql = "insert into maximum_quantity(sno,day_name,max_quantity) values(?,?,?)";
			Object[] params = { maxi.getSno(), maxi.getDayName(), maxi.getMaxQuantity() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows inserted: " + rows);
		} catch (DuplicateKeyException e) {
			System.out.println("Cannot have a duplicate key");

		}
	}

	public void update(MaximumQuantity maxi) {

		String sql = "update maximum_quantity set max_quantity=? where day_name=?";
		Object[] params = { maxi.getMaxQuantity(), maxi.getDayName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(String DayName) {
		String sql = "delete from maximum_quantity where day_name=?";
		Object[] params = { DayName };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<MaximumQuantity> list() {

		String sql = "select * from maximum_quantity";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			MaximumQuantity max = new MaximumQuantity();
			max.setSno(rs.getInt("sno"));
			max.setDayName(rs.getString("day_name"));
			max.setMaxQuantity(rs.getInt("max_quantity"));
			return max;

		});

	}

}
