package com.restaurant.validator;

import com.restaurant.dao.SessionsDAO;
import com.restaurant.model.Sessions;

public class Service {

	public void check(Sessions session) {
		SessionNameValidator sess = new SessionNameValidator();
		sess.validateSave(session);
		SessionsDAO sessionsdao = new SessionsDAO();
		sessionsdao.save(session);
	}
}
