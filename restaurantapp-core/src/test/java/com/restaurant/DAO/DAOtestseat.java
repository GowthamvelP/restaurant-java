package com.restaurant.DAO;

import com.restaurant.model.seat_details;

public class DAOtestseat {
	public static void main(String[] args) {
seat_detailsDAO seats = new seat_detailsDAO();
seat_details seat = new seat_details();
seat.setSeatId(11);
seat.setSeatNo(111);
seat.setSeatStatus("Available");
seats.delete(111);
seats.update(seat);
seats.save(seat);
seats.list();
}
}
