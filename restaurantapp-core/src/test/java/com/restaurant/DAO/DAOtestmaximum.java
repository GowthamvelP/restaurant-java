package com.restaurant.DAO;

import com.restaurant.model.maximum_quantity;

public class DAOtestmaximum {
	public static void main(String[] args) {
maximum_quantityDAO max = new maximum_quantityDAO();
maximum_quantity maxi = new maximum_quantity();
maxi.setSno(2);
maxi.setDayName("week_end");
maxi.setMaxQuantity(4);
/*max.save(maxi);
max.update(maxi);
max.delete("week_day");*/

System.out.println(max.list());

	}
}
