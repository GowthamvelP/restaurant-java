package com.restaurant.Validator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.restaurant.model.Sessions;
import com.restaurant.validator.Service;

public class TestService {
	public static void main(String[] args) {
		Sessions session = new Sessions();
		Service serve = new Service();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
		LocalTime time = LocalTime.now();
		String timeForm = formatter.format(time);
		session.setSessionId(1);
		session.setSessionName("idlyyyy");
		session.setFromTime(LocalTime.parse(timeForm));
		session.setToTime(LocalTime.parse(timeForm));
		session.setQuantity(100);
		serve.check(session);
	}
}