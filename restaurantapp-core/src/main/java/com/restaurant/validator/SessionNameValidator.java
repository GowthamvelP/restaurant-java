package com.restaurant.validator;

import com.restaurant.exception.SessionNameNotFoundException;
import com.restaurant.model.Sessions;

public class SessionNameValidator {
	public void validateSave(Sessions session) {

		if (" ".equals(session.getSessionName())) {
			try {
				throw new SessionNameNotFoundException("Invalid Session");
			} catch (SessionNameNotFoundException e) {
				System.out.println("Session Name cannot be null");
			}

		}

	}
}