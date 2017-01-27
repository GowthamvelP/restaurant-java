package com.restaurant.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restaurant.model.OrderTransaction;
import com.restaurant.util.ConnectionUtil;

public class OrderTransactionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(OrderTransaction transaction) {

		String sql = "insert into order_transaction(trans_id,order_id,item_id,seat_no,food_ordered,quantity,order_time,order_status) values(?,?,?,?,?,?,?,?)";
		Object[] params = { transaction.getTransId(), transaction.getOrderId(), transaction.getItemId(),
				transaction.getSeatNo(), transaction.getFoodOrdered(), transaction.getQuantity(),
				transaction.getOrderTime(), transaction.getOrderStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public List<OrderTransaction> list() {
		String sql = "select * from order_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderTransaction trans = new OrderTransaction();
			trans.setTransId(rs.getInt("trans_id"));
			trans.setOrderId(rs.getInt("order_id"));
			trans.setItemId(rs.getInt("item_id"));
			trans.setSeatNo(rs.getInt("seat_no"));
			trans.setFoodOrdered(rs.getString("food_ordered"));
			trans.setQuantity(rs.getInt("quantity"));
			trans.setOrderTime(rs.getString("order_time"));
			trans.setOrderStatus(rs.getString("order_status"));

			return trans;

		});

	}
}
