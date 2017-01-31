package com.restaurant.dao;

import java.sql.Types;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.restaurant.util.*;

public class ProcedureDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String placeorder(int seatno, String items, LocalTime orderTime, String quantity) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pr_multi_menu").declareParameters(
				new SqlParameter("seat_no", Types.INTEGER), new SqlParameter("order_list", Types.VARCHAR),
				new SqlParameter("order_time", Types.TIME), new SqlParameter("quantity_list", Types.VARCHAR),
				new SqlOutParameter("message_status", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("seat_no", seatno).addValue("order_list", items)
				.addValue("order_time", orderTime).addValue("quantity_list", quantity);

		Map<String, Object> execute = call.execute(in);
		return (String) execute.get("message_status");

	}

	public String cancelorder(int seatno, String items, int quan) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pr_cancel_order").declareParameters(
				new SqlParameter("seat_no_par", Types.INTEGER), new SqlParameter("item", Types.VARCHAR),
				new SqlParameter("cancel_quantity", Types.VARCHAR), new SqlOutParameter("statement", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("seat_no_par", seatno).addValue("item", items)
				.addValue("cancel_quantity", quan);

		Map<String, Object> execute = call.execute(in);
		return (String) execute.get("statement");

	}

	public String updateremaining(int itemid, int quant) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pr_to_update_remiaining")
				.declareParameters(new SqlParameter("item_id_par", Types.INTEGER),
						new SqlOutParameter("quantity", Types.INTEGER));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("item_id_par", itemid).addValue("quantity",
				quant);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get("quantity");

	}

	public int fnitemslimit(int orderId) {
		String sql = "select fn_check_items_limit(?)";
		Object[] params = { orderId };
		return jdbcTemplate.queryForObject(sql, params, int.class);
	}

	public int fncheckseat(int seatno) {
		String sql = "select fn_check_seat(?)";
		Object[] params = { seatno };
		return jdbcTemplate.queryForObject(sql, params, int.class);
	}

	public int fncheckremaining(int itemid, int quantity) {
		String sql = "select fn_check_remaining(?,?)";
		Object[] params = { itemid, quantity };
		return jdbcTemplate.queryForObject(sql, params, int.class);
	}

}