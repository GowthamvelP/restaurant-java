package com.restaurant.DAO;

import com.restaurant.model.items_list;
import com.restaurant.model.order_transaction;
import com.restaurant.model.seat_details;
import com.restaurant.model.sessions;

public class DAOtestorders {
	public static void main(String[] args) {
order_transactionDAO trans = new order_transactionDAO();
order_transaction transaction = new order_transaction();
items_list iid = new items_list();
seat_details seats = new seat_details();
sessions sess = new sessions();
iid.setItemId(1);
iid.setItems("idly");
sess.setSessionId(1);
seats.setSeatNo(111);
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
