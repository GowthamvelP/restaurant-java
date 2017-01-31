package com.restaurant.testdao;

import com.restaurant.dao.RemainingDetailsDAO;
import com.restaurant.model.ItemsList;
import com.restaurant.model.RemainingDetails;
import com.restaurant.model.Sessions;

public class DAOTestRemaining {

	public static void main(String[] args) {
		RemainingDetailsDAO remain = new RemainingDetailsDAO();
		RemainingDetails remains = new RemainingDetails();
		Sessions sessionobj = new Sessions();
		ItemsList iid = new ItemsList();
		sessionobj.setSessionId(1);
		iid.setItemId(20);
		remains.setSno(17);
		remains.setSeId(sessionobj);
		remains.setItemId(iid);
		remains.setRemaining(100);
		remain.delete(20);
		remain.save(remains);
		remain.update(remains);
		remain.list();

	}
}