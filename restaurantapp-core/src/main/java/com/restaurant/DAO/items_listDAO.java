package com.restaurant.DAO;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.items_list;
import com.restaurant.model.sessions;
import com.restaurant.util.ConnectionUtil;

public class items_listDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(items_list itemslist) {

		String sql = "insert into items_list(item_id,session_id,items) values(?,?,?)";
		Object[] params = { itemslist.getItemId(), itemslist.getSessionId().getSessionId(),itemslist.getItems()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(items_list itemslist) {

		String sql = "update items_list set session_name=? where session_id=?";
		Object[] params = {itemslist.getItemId(), itemslist.getSessionId(),itemslist.getItems()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int ItemId) {

		String sql = "delete from items_list where item_id=?";
		Object[] params = { ItemId };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<items_list> list()
	{
		String sql="select * from items_list";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		
				
		{
			items_list items = new items_list();
			sessions session = new sessions();
			session.setSessionId(rs.getInt("session_id"));
			items.setItemId(rs.getInt("item_id"));
			items.setSessionId(session);
			items.setItems(rs.getString("items"));
			
			return items;
	
			
		});
		
		
		
	}


}
