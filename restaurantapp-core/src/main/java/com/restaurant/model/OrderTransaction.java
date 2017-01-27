package com.restaurant.model;

import lombok.Data;

@Data
public class OrderTransaction {
	private int transId;
	private int orderId;
	private int itemId;
	private int seatNo;
	private String foodOrdered;
	private int quantity;
	private String orderTime;
	private String orderStatus;
}
