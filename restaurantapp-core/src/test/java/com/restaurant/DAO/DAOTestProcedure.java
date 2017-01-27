package com.restaurant.DAO;

import com.restaurant.DAO.ProcedureDAO;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DAOTestProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProcedureDAO dao = new ProcedureDAO();

		/*
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss",
		 * Locale.ENGLISH); LocalTime time = LocalTime.now(); String timeForm =
		 * formatter.format(time);
		 * 
		 * 
		 * 
		 * String status =
		 * dao.placeOrder(101,"VarietyRice,NorthIndianThali",LocalTime.parse(
		 * timeForm),"2,3","@message"); System.out.println(status);
		 */
		String status = dao.cancelOrder(101, "VarietyRice", 2, "@statement");
		System.out.println(status);

	}

}
