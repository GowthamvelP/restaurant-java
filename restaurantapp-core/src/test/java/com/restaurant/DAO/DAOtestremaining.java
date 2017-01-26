package com.restaurant.DAO;

import com.restaurant.model.items_list;
import com.restaurant.model.remaining_details;
import com.restaurant.model.sessions;

public class DAOtestremaining {

	public static void main(String[] args) {
remaining_detailsDAO remain = new remaining_detailsDAO();
remaining_details remains = new remaining_details();
sessions sessionobj = new sessions();
items_list iid = new items_list();
sessionobj.setSessionId(1);
iid.setItemId(20);
remains.setSno(17);
remains.setSeId(sessionobj);
remains.setItemId(iid);
remains.setRemaining(100);
remain.delete(20);

}
}