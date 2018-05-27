package com.codeme.homework2.warehouse.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Warehouse{
	
	private Map<ProductItem, Integer> warehouse;
	private ArrayList<ProductItem> test;

	public Warehouse() {
		warehouse = new LinkedHashMap<>();
		test = new ArrayList<ProductItem>();
	}

	public boolean addToWarehouse(ProductItem productItem, Integer amount) {
		if (amount >= 0) {
			if(warehouse.size() > 0) {
				for(ProductItem pI : warehouse.keySet()) {
					if (pI.equals(productItem)) {
						int itemAmount = warehouse.get(pI) + amount;
						warehouse.replace(pI, itemAmount);
						return true;
					}
				}
				warehouse.put(productItem, amount);
				test.add(productItem);
				return true;
			} else {
				warehouse.put(productItem, amount);
				test.add(productItem);
				return true;
			}
		}
		return false;			
	}
	
	public boolean addToWarehouse(Integer itemFromWarehouseIndex, Integer amount) throws IllegalArgumentException {
		if (amount > 0) {
			if(warehouse.size() > 0) {
				for(ProductItem pItem : warehouse.keySet()) {
					ProductItem searchedProduct = test.get(itemFromWarehouseIndex - 1);
					Integer storedProductAmount = warehouse.get(searchedProduct);
					warehouse.replace(searchedProduct, storedProductAmount + amount);
					return true;		
				}
			} else {
				System.out.println("There are no products in the warehouse you could increase its amount");
				return false;
			}
		}
		throw new IllegalArgumentException("Amount ought to be higher than zero.");	
	}
	
	public boolean addToWarehouse(ProductItem productItem) {
		warehouse.put(productItem, 0);
		test.add(productItem);
		return true;
	}
	
	public Integer getNoOfProductItemsBasedOnProdNo(Integer prodNo) {
		ProductItem searchedProduct = test.get(prodNo - 1);
		Integer storedProductAmount = warehouse.get(searchedProduct);
		return storedProductAmount;
	}
	
	
	public Map<ProductItem, Integer> getWarehouseItems() {
		return warehouse;
	}
	
	public boolean removeFromWarehouse(Integer productNo, Integer amount) {
		if(amount > 0) {
			ProductItem searchedProduct = test.get(productNo - 1);
			Integer storedProductAmount = warehouse.get(searchedProduct);
			if (storedProductAmount - amount >= 0) {
				warehouse.replace(searchedProduct, storedProductAmount - amount);
				return true;
			} else {
				System.out.printf("Unable to remove the product. Maximum amount of %s in the store is %s.", searchedProduct.getName(), storedProductAmount);
			}			
		}
		return false;			
	}
}
