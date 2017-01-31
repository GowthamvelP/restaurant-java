package com.restaurant.testdao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.restaurant.dao.ProcedureDAO;

public class DAOTestProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProcedureDAO dao = new ProcedureDAO();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
		LocalTime time = LocalTime.now();
		String timeForm = formatter.format(time);
		String status = dao.placeorder(101, "Chappathi", LocalTime.parse(timeForm), "2");
		System.out.println(status);
		String status1 = dao.cancelorder(101, "VarietyRice", 2);
		System.out.println(status1);
		dao.updateremaining(1, 5);
		dao.fnitemslimit(11);
		dao.fncheckseat(1231);
		dao.fncheckremaining(1, 80);
	}

}
