package com.restaurant.DAO;

import com.restaurant.model.MaximumQuantity;

public class DAOTestMaximum {
	public static void main(String[] args) {
		MaximumQuantityDAO max = new MaximumQuantityDAO();
		MaximumQuantity maxi = new MaximumQuantity();
		//*maxi.setSno(3);*/
		maxi.setDayName("week");
		maxi.setMaxQuantity(4);
		 max.update(maxi);
		/*
		 * max.save(maxi); max.update(maxi); 
		 */

		/*System.out.println(max.list());*/
		/*max.delete("week");*/
	}
}
