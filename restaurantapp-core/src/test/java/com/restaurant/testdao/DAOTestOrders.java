package com.restaurant.testdao;

import com.restaurant.dao.OrderTransactionDAO;
import com.restaurant.model.OrderTransaction;

public class DAOTestOrders {
	public static void main(String[] args) {
		OrderTransactionDAO trans = new OrderTransactionDAO();
		OrderTransaction transaction = new OrderTransaction();
		transaction.setTransId(100);
		transaction.setOrderId(777);
		transaction.setItemId(1);
		transaction.setSeatNo(101);
		transaction.setFoodOrdered("idly");
		transaction.setOrderTime("09:00:00");
		transaction.setOrderStatus("Order Placed");
		trans.save(transaction);
		System.out.println(trans.list());

	}
}
