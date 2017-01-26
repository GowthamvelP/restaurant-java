package com.restaurant.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.items_list;
import com.restaurant.model.remaining_details;
import com.restaurant.model.sessions;
import com.restaurant.util.ConnectionUtil;
public class remaining_detailsDAO {

		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		public void save(remaining_details remains) {

			String sql = "insert into remaining_details(sno,se_id,item_id,remaining) values(?,?,?,?)";
			Object[] params = { remains.getSno(),remains.getSeId().getSessionId(), remains.getItemId().getItemId(),remains.getRemaining()};
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows inserted: " + rows);

		}

		public void update(remaining_details remains) {

			String sql = "update remaining_details set remaining=? where item_Id=?";
			Object[] params = {remains.getSeId().getSessionId(), remains.getItemId().getItemId(),remains.getRemaining()};
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows updated: " + rows);

		}

		public void delete(int itemid) {

			String sql = "delete from remaining_details where item_id=?";
			Object[] params = { itemid };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows deleted: " + rows);

		}
		public List<remaining_details> list()
		{
			
			
			remaining_details remaining = new remaining_details();
			items_list items = new items_list();
			sessions session = new sessions();
			String sql="select * from remaining_details";
			return jdbcTemplate.query(sql,(rs,rowNum) ->
			{
			remaining.setSno(rs.getInt("sno"));
			items.setItemId(rs.getInt("item_id"));
			remaining.setItemId(items);
			session.setSessionId(rs.getInt("session_id"));
			remaining.setSeId(session);
			remaining.setRemaining(rs.getInt("remaining"));
			return remaining;
		
			});
		}
		
		
		/*public items_list listbyId(int id)
		{
			String sql="select remaining from remaining_details where item_id=? and session_id=?"; 
			Object[] params = {id};
			return jdbcTemplate.queryForObject(sql,params,(rs,rowNum) ->
			{
				items_list items = new items_list();
				remaining_details remaining = new remaining_details();
				sessions session = new sessions();
				
				items.setItemId(rs.getInt("item_id"));
				remaining.setItemId(items);
				session.setSessionId(rs.getInt("session_id"));
				remaining.setSeId(session);
				remaining.setRemaining(rs.getInt("remaining"));
				return remaining;
				
				
				
				
			});*/
			
			
			
		}

