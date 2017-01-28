package com.restaurant.DAO;

/*import com.restaurant.model.ItemsList;
import com.restaurant.model.Sessions;*/

public class DAOTestItems {
	public static void main(String[] args) {
		ItemsListDAO testitems = new ItemsListDAO();
		/*
		 * ItemsList itemslist = new ItemsList(); Sessions session = new
		 * Sessions(); session.setSessionId(1); itemslist.setItemId(20);
		 * itemslist.setSessionId(session); itemslist.setItems("vadacurry");
		 */
		System.out.println(testitems.listbyid(0));
		/*
		 * testitems.save(itemslist); testitems.update(itemslist);
		 * testitems.delete(1);
		 */
		testitems.delete(101);
	}
}