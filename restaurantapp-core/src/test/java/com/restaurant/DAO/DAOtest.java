package com.restaurant.DAO;

import com.restaurant.model.sessions;

public class DAOtest {
	public static void main(String[] args) {
       sessionsDAO sessionsdao = new sessionsDAO();
		sessions session = new sessions();
		session.setSessionId(16);
		session.setSessionName("chatitems");
		session.setFromTime("08:00:00");
		session.setToTime("11:00:00");
		session.setQuantity(100);
        sessionsdao.delete(16);
	  
		sessionsdao.save(session);
		sessionsdao.delete(5);
		sessionsdao.update(session);
		sessionsdao.list();
		
	}
}