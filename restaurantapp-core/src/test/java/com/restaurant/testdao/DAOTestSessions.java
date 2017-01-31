package com.restaurant.testdao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.restaurant.dao.SessionsDAO;
import com.restaurant.model.Sessions;

public class DAOTestSessions {
	public static void main(String[] args) {
		SessionsDAO sessionsdao = new SessionsDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
		LocalTime time = LocalTime.now();
		String timeForm = formatter.format(time);
		Sessions session = new Sessions();
		session.setSessionId(1);
		session.setSessionName(" ");
		session.setFromTime(LocalTime.parse(timeForm));
		session.setToTime(LocalTime.parse(timeForm));
		session.setQuantity(100);
		sessionsdao.save(session);
		sessionsdao.list();
		sessionsdao.delete(1);
	}
}