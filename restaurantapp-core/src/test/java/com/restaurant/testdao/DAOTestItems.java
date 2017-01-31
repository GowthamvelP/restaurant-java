package com.restaurant.testdao;

import java.util.logging.Logger;

import com.restaurant.dao.ItemsListDAO;
import com.restaurant.model.ItemsList;
import com.restaurant.model.Sessions;

public class DAOTestItems {
	final Logger logger = Logger.getLogger(DAOTestItems.class.getName());

	public static void main(String[] args) {
		ItemsListDAO testitems = new ItemsListDAO();
		ItemsList itemslist = new ItemsList();
		Sessions session = new Sessions();
		session.setSessionId(1);
		itemslist.setItemId(20);
		testitems.delete(101);
		testitems.save(itemslist);
		testitems.update(itemslist);
		testitems.listbyid(1);
		testitems.list();

	}
}