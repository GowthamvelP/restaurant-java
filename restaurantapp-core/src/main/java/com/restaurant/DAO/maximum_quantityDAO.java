package com.restaurant.DAO;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.maximum_quantity;
import com.restaurant.util.ConnectionUtil;
public class maximum_quantityDAO {

		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		public void save(maximum_quantity maxi) {

			String sql = "insert into maximum_quantity(sno,day_name,max_quantity) values(?,?,?)";
			Object[] params = { maxi.getSno(), maxi.getDayName(),maxi.getMaxQuantity()};
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows inserted: " + rows);

		}

		public void update(maximum_quantity maxi ) {

			String sql = "update maximum_quantity set max_quantity=? where day_name=?";
			Object[] params = {maxi.getSno(),maxi.getDayName(),maxi.getMaxQuantity()};
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows updated: " + rows);

		}

		public void delete(String DayName) {

			String sql = "delete from items_list where item_id=?";
			Object[] params = { DayName };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows deleted: " + rows);

		}
		public List<maximum_quantity> list()
		{
			
			String sql = "select * from maximum_quantity";
			return jdbcTemplate.query(sql, (rs,rowNum) ->
			{
				maximum_quantity max = new maximum_quantity();
				max.setSno(rs.getInt("sno"));
				max.setDayName(rs.getString("day_name"));
				max.setMaxQuantity(rs.getInt("max_quantity"));
				return max;
				
			});
			
		}

}
