package com.restaurant.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.ItemsList;
import com.restaurant.model.Sessions;
import com.restaurant.util.ConnectionUtil;

public class ItemsListDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(ItemsList itemslist) {

		String sql = "insert into items_list(item_id,session_id,items) values(?,?,?)";
		Object[] params = { itemslist.getItemId(), itemslist.getSessionId().getSessionId(), itemslist.getItems() };
		jdbcTemplate.update(sql, params);
	}

	public void update(ItemsList itemslist) {

		String sql = "update items_list set session_name=? where session_id=?";
		Object[] params = { itemslist.getItemId(), itemslist.getSessionId(), itemslist.getItems() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int itemid) {

		String sql = "delete from items_list where item_id=?";
		Object[] params = { itemid };
		jdbcTemplate.update(sql, params);

	}

	public List<ItemsList> list() {
		String sql = "select * from items_list";

		return jdbcTemplate.query(sql, (rs, rowNum) ->

		{
			ItemsList items = new ItemsList();
			Sessions session = new Sessions();
			session.setSessionId(rs.getInt("session_id"));
			items.setItemId(rs.getInt("item_id"));
			items.setSessionId(session);
			items.setItems(rs.getString("items"));

			return items;

		});

	}

	public ItemsList listbyid(int id) {

		String sql = "select items from items_list where item_id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			ItemsList items = new ItemsList();
			items.setItemId(rs.getInt("item_id"));
			items.setItems(rs.getString("items"));
			return items;

		});

	}
}
