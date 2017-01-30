package com.restaurant.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.SeatDetails;
import com.restaurant.util.ConnectionUtil;

public class SeatDetailsDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeatDetails seat) {

		String sql = "insert into seat_details(seat_id,seat_no,seat_status) values(?,?,?)";
		Object[] params = { seat.getSeatId(), seat.getSeatNo(), seat.getSeatStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(SeatDetails seat) {

		String sql = "update seat_details set seat_stautus=? where seat_no=?";
		Object[] params = { seat.getSeatId(), seat.getSeatNo(), seat.getSeatStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int seatno) {

		String sql = "delete from seat_details where seat_no=?";
		Object[] params = { seatno };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<SeatDetails> list() {
		String sql = "select * from seat_details";
		SeatDetails seat = new SeatDetails();
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			seat.setSeatId(rs.getInt("seat_id"));
			seat.setSeatNo(rs.getInt("seat_no"));
			seat.setSeatStatus(rs.getString("seat_status"));
			return seat;

		});
	}

	public SeatDetails listBySeatno(int id) {
		String sql = "select seat_status from seat_details where seat_no=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			SeatDetails s = new SeatDetails();
			s.setSeatNo(rs.getInt("seat_no"));
			s.setSeatStatus(rs.getString("seat_status"));
			return s;
		});

	}

}