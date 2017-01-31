package com.restaurant.validator;

import com.restaurant.exception.SessionNameNotFoundException;
import com.restaurant.model.Sessions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionNameValidator {
	final Logger logger = Logger.getLogger(SessionNameValidator.class.getName());
	public void validateSave(Sessions session) {
		

		if (" ".equals(session.getSessionName())) {
			try {
				throw new SessionNameNotFoundException("Invalid Session");
			} catch (SessionNameNotFoundException e) {
				logger.log(Level.SEVERE, "Session Name cannot be null", e);
			}

		}

	}
}