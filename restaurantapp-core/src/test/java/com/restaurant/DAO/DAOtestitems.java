package com.restaurant.DAO;

import com.restaurant.model.items_list;
import com.restaurant.model.sessions;

public class DAOtestitems {
	public static void main(String[] args) {
items_listDAO testitems = new items_listDAO();
items_list itemslist = new items_list();
sessions session = new sessions();
session.setSessionId(1);
itemslist.setItemId(20);
itemslist.setSessionId(session);
itemslist.setItems("vadacurry");
testitems.list();
testitems.save(itemslist);
testitems.update(itemslist);
testitems.delete(1);
}
}