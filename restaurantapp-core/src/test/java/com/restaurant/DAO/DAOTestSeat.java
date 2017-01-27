package com.restaurant.DAO;

import com.restaurant.model.SeatDetails;

public class DAOTestSeat {
	public static void main(String[] args) {
		SeatDetailsDAO seats = new SeatDetailsDAO();
		SeatDetails seat = new SeatDetails();
seat.setSeatId(11);
seat.setSeatNo(111);
seat.setSeatStatus("Available");
/*seats.delete(111);
seats.update(seat);*/
seats.save(seat);
/*seats.list();*/
}
}
