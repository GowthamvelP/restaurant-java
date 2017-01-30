package com.restaurant.DAO;

import com.restaurant.DAO.ProcedureDAO;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DAOTestProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProcedureDAO dao = new ProcedureDAO();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
		LocalTime time = LocalTime.now();
		String timeForm = formatter.format(time);
		String status = dao.PlaceOrder(101, "Chappathi", LocalTime.parse(timeForm), "2", "@message_status");
		System.out.println(status);
		String status1 = dao.CancelOrder(101, "VarietyRice", 2, "@statement");
		System.out.println(status1);
		dao.UpdateRemaining(1, 5);
		dao.UpdateRemainingCancelled(1, 5);
		System.out.println(dao.FnItemsLimit(11));
		System.out.println(dao.FnCheckSeat(1231));
		System.out.println(dao.FnCheckRemaining(1, 80));
	}

}
