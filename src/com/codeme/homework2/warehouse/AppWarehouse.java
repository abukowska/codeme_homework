package com.codeme.homework2.warehouse;

import com.codeme.homework2.warehouse.model.ProductItem;
import com.codeme.homework2.warehouse.model.Water;

public class AppWarehouse {

	public static void main(String[] args) {

		Water water = new Water("woda", 2.5, "1l");
		water.setPrice(8.8);
		System.out.println(water.getPrice());
		
		
	}

}
