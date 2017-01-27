package com.restaurant.DAO;

import com.restaurant.model.ItemsList;
import com.restaurant.model.OrderTransaction;
import com.restaurant.model.SeatDetails;
import com.restaurant.model.Sessions;

public class DAOtestorders {
	public static void main(String[] args) {
OrderTransactionDAO trans = new OrderTransactionDAO();
OrderTransaction transaction = new OrderTransaction();
ItemsList iid = new ItemsList();
SeatDetails seats = new SeatDetails();
Sessions sess = new Sessions();
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
