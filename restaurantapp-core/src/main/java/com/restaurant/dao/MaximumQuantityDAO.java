package com.restaurant.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.MaximumQuantity;
import com.restaurant.util.ConnectionUtil;

public class MaximumQuantityDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(MaximumQuantity maxi) {

		String sql = "insert into maximum_quantity(sno,day_name,max_quantity) values(?,?,?)";
		Object[] params = { maxi.getSno(), maxi.getDayName(), maxi.getMaxQuantity() };
		jdbcTemplate.update(sql, params);

	}

	public void update(MaximumQuantity maxi) {

		String sql = "update maximum_quantity set max_quantity=? where day_name=?";
		Object[] params = { maxi.getMaxQuantity(), maxi.getDayName() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(String Dayname) {
		String sql = "delete from maximum_quantity where day_name=?";
		Object[] params = { Dayname };
		jdbcTemplate.update(sql, params);

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
