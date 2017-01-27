package com.restaurant.DAO;

/*import com.restaurant.model.Sessions;*/

public class DAOtest {
	public static void main(String[] args) {
       SessionsDAO sessionsdao = new SessionsDAO();
		/*sessions session = new sessions();
		session.setSessionId(16);
		session.setSessionName("chatitems");
		session.setFromTime("08:00:00");
		session.setToTime("11:00:00");
		session.setQuantity(100);
        sessionsdao.delete(16);
	  
		sessionsdao.save(session);
		sessionsdao.delete(5);
		sessionsdao.update(session);
		sessionsdao.list();*/
		System.out.println(sessionsdao.listById(1));
		 
	}
}