package com.restaurant.DAO;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.restaurant.model.Sessions;

public class DAOTestSessions {
	public static void main(String[] args) {
		SessionsDAO sessionsdao = new SessionsDAO();
		/*
		 * sessions session = new sessions(); session.setSessionId(16);
		 * session.setSessionName("chatitems"); session.setFromTime("08:00:00");
		 * session.setToTime("11:00:00"); session.setQuantity(100);
		 * sessionsdao.delete(16);
		 * 
		 * sessionsdao.save(session); sessionsdao.delete(5);
		 * sessionsdao.update(session); sessionsdao.list();
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
		LocalTime time = LocalTime.now();
		String timeForm = formatter.format(time);
		Sessions session = new Sessions();
		session.setSessionId(1);
		session.setSessionName(" ");
		session.setFromTime(LocalTime.parse(timeForm));
		session.setToTime(LocalTime.parse(timeForm));
		session.setQuantity(100);

		// sessionsdao.save(session);
		// System.out.println(sessionsdao.list());
		sessionsdao.save(session);
	}
}