package com.restaurant.DAO;

import com.restaurant.model.MaximumQuantity;

public class DAOtestmaximum {
	public static void main(String[] args) {
MaximumQuantityDAO max = new MaximumQuantityDAO();
MaximumQuantity maxi = new MaximumQuantity();
maxi.setSno(2);
maxi.setDayName("week_end");
maxi.setMaxQuantity(4);
/*max.save(maxi);
max.update(maxi);
max.delete("week_day");*/

System.out.println(max.list());

	}
}
