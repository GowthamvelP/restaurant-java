package com.restaurant.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.seat_details;
import com.restaurant.util.ConnectionUtil;
public class seat_detailsDAO {

		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		public void save(seat_details seat) {

			String sql = "insert into seat_details(seat_id,seat_no,seat_status) values(?,?,?)";
			Object[] params = { seat.getSeatId(), seat.getSeatNo(),seat.getSeatStatus()};
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows inserted: " + rows);

		}

		public void update(seat_details seat) {

			String sql = "update seat_details set seat_stautus=? where seat_no=?";
			Object[] params = {seat.getSeatId(),seat.getSeatNo(),seat.getSeatStatus()};
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows updated: " + rows);

		}

		public void delete(int seatno) {

			String sql = "delete from seat_details where seat_no=?";
			Object[] params = { seatno };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No of rows deleted: " + rows);

		}
		public List<seat_details> list()
		{
			String sql="select * from seat_details";
			seat_details seat = new seat_details();
			return jdbcTemplate.query(sql, (rs,rowNum) ->
			{	
		    seat.setSeatId(rs.getInt("seat_id"));
			seat.setSeatNo(rs.getInt("seat_no"));
			seat.setSeatStatus(rs.getString("seat_status"));
			return seat;
				
			});
			
			
			
			
		}

}