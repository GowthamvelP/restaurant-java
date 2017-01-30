package com.restaurant.Validator;

import com.restaurant.model.Sessions;
import com.restaurant.validator.SessionNameValidator;

public class TestSessionValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sessions session = new Sessions();
		session.setSessionName(" ");
		SessionNameValidator sess = new SessionNameValidator();
		sess.validateSave(session);

	}

}
