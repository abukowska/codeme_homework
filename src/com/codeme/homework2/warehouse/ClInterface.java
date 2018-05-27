package com.codeme.homework2.warehouse;

import java.awt.Choice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

import com.codeme.homework2.warehouse.model.Bread;
import com.codeme.homework2.warehouse.model.Potatoes;
import com.codeme.homework2.warehouse.model.ProductItem;
import com.codeme.homework2.warehouse.model.Warehouse;
import com.codeme.homework2.warehouse.model.Water;


public class ClInterface {
	private BufferedWriter writer;
	private BufferedReader reader;

	public ClInterface() {
		writer = new BufferedWriter(new OutputStreamWriter(System.out)); 
		reader = new BufferedReader(new InputStreamReader(System.in)); 
	}

	private void print(String text) throws IOException {
		writer.write(text);
		writer.flush();
	}

	private void println(String text) throws IOException {
		print(text + "\r\n");
	}

	private String read() throws IOException {
		return reader.readLine();
	}

	private Integer readInt() throws IOException {
		return Integer.valueOf(reader.readLine());
	}

	private void displayMenu() throws IOException {
		println("\n--- Virtual Shop ---");
		println("Choose option, 1, 2, 3 OR 4:");
		println("(1) See available products.");
		println("(2) Create a new product and add it to the warehouse.");
		println("(3) Add more already existing products to the warehouse.");
		println("(4) Remove already existing products from the warehouse.");
		println("");
		println("//For exit: \"exit\"");
	}
	
	private void displayAvailableProducts(Warehouse warehouse) {
		try {
			println("Products available:");
			Map<ProductItem, Integer> warehouseItems = warehouse.getWarehouseItems();
			int count = 0;
			for(Map.Entry<ProductItem, Integer> entry : warehouseItems.entrySet()) {
				println(String.valueOf(++count) + ") " + entry.getKey().toString() + "  ilosc: " + entry.getValue());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void start() {
		Warehouse warehouse = new Warehouse();
		warehouse.addToWarehouse(new ProductItem("woda Naleczowianka", 2.5, "l"), 1);
		warehouse.addToWarehouse(new ProductItem("woda Zywiec", 2.4, "l"), 3);
		warehouse.addToWarehouse(new ProductItem("bread", 3.30, "piece"), 11);
		warehouse.addToWarehouse(new ProductItem("potatoes", 4.5, "kg"), 30);
		try {
			do {
				displayMenu();
				String option = read().toLowerCase().trim();
				if (option.trim().equals("1")) {
					displayAvailableProducts(warehouse);
				} else if (option.trim().equals("2")) {
					Boolean exit = false;
					do {
						String productsName;
						Double prodPrice = 0.0;
						String productsMeasure;
						
						do {
							println("Add a new product's name: ");
							productsName = read().trim();
							if (productsName.equals("")) {
								println("Name can't be empty. Please provide one.");
							} else if (productsName.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else {
								println("Name added!");
								break;
							}
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						
						do {
							println("Add product's price: ");
							String productsPrice = read().trim();
							if (productsPrice.equals("")) {
								println("Price can't be empty. Please provide one.");
							} else if (productsPrice.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else {
								try {
									prodPrice = Double.valueOf(productsPrice);
									println("Price added!");
									break;
								} catch (NumberFormatException nfe) {
									println("Please add price in a numerical format.");
								}
							}
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						
						do {
							println("Add product's measure (l/kg/piece): ");
							productsMeasure = read().trim();
							if (productsMeasure.equals("")) {
								println("Measure can't be empty. Please provide one.");
							} else if (productsMeasure.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else if (productsMeasure.trim().equals("l") || productsMeasure.trim().equals("kg")
									|| productsMeasure.equals("piece")) {
								println("Measure added!");
								break;
							} else {
								println("Please choose measure: l OR kg OR piece.");
							}
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						ProductItem newItem = new ProductItem(productsName, prodPrice, productsMeasure);
						warehouse.addToWarehouse(newItem);
						System.out.printf("Product >%s< created and added to warehouse. Now you can add the amount of it to be stored.", newItem.toString());
						break;					
					} while (true);
				
				} else if (option.trim().equals("3")) {
					displayAvailableProducts(warehouse);				
					Integer prodNoToBeIncreased = 0;
					Integer newAmount = 0;
					Boolean exit = false;
					do {
						do {
							println("Choose which of the products amount you'd like to increase:");
							String productNoToBeIncreased = read().trim();
							int noOfWarehoseItems = warehouse.getWarehouseItems().size();
							
							if (productNoToBeIncreased.equals("")) {
								println("Please provide a product no to be increased.");
							} else if (productNoToBeIncreased.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else {
								try {
									prodNoToBeIncreased = Integer.valueOf(productNoToBeIncreased);
									if (noOfWarehoseItems - prodNoToBeIncreased < 0 || prodNoToBeIncreased <= 0) {
										println("Index out of range. Provide valid no.");
										continue;
									}
									break;
								} catch (NumberFormatException nfe) {
									println("Please add amount in a numerical format.");
								}
							}	
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						
						do {
							println("Add amount: ");
							String amountToBeIncreased = read().trim();		
							if (amountToBeIncreased.equals("")) {
								println("Please provide one. Product no to be increased.");
							} else if (amountToBeIncreased.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else {
								try {
									newAmount = Integer.valueOf(amountToBeIncreased);
									break;
								} catch (NumberFormatException nfe) {
									println("Please add amount in a numerical format.");
								}
							}				
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						
						try {
							warehouse.addToWarehouse(prodNoToBeIncreased, newAmount);
						} catch (IllegalArgumentException iae) {
							System.out.println("aaa");
							iae.printStackTrace();
							break;
						}
						println("Product increased!");
						displayAvailableProducts(warehouse);
						break;				
				} while (true);
				
				} else if (option.trim().equals("4")) {
					displayAvailableProducts(warehouse);				
					Integer prodNoToBeDecreased = 0;
					Integer amountDecreased = 0;
					Boolean exit = false;
					do {
						do {
							println("Choose which of the products amount you'd like to decrease:");
							String productNoToBeDecreased = read().trim();
							int noOfWarehoseItems = warehouse.getWarehouseItems().size();
							
							if (productNoToBeDecreased.equals("")) {
								println("Please provide a product no to be increased.");
							} else if (productNoToBeDecreased.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else {
								try {
									prodNoToBeDecreased = Integer.valueOf(productNoToBeDecreased);
									if (noOfWarehoseItems - prodNoToBeDecreased < 0 || prodNoToBeDecreased <= 0) {
										println("Index out of range. Provide valid no.");
										continue;
									}
									break;
								} catch (NumberFormatException nfe) {
									println("Please add amount in a numerical format.");
								}
							}
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						
						do {
							println("Add amount: ");
							String amountToBeDecreased = read().trim();		
							if (amountToBeDecreased.equals("")) {
								println("Please provide one. Product no to be decreased.");
							} else if (amountToBeDecreased.trim().toLowerCase().equals("exit")) {
								exit = true;
								break;
							} else {
								try {
									amountDecreased = Integer.valueOf(amountToBeDecreased);
									if ( warehouse.getNoOfProductItemsBasedOnProdNo(prodNoToBeDecreased)- amountDecreased < 0 || amountDecreased <= 0) {
										println("There are not enough products to proceed wih the operation.");
										continue;
									}									
									break;
								} catch (NumberFormatException nfe) {
									println("Please add amount in a numerical format.");
								}
							}				
						} while (true);
						
						if (exit == true) {
							println("Product not created. Exiting.");
							break;
						}
						warehouse.removeFromWarehouse(prodNoToBeDecreased, amountDecreased);
						println("Product decreased!");
						displayAvailableProducts(warehouse);
						break;					
				} while (true);				
				} else if (option.toLowerCase().equals("exit")) {
					break;
				} else {
					println("Please choose option 1, 2, 3, 4 OR exit.");
				}
			} while (true);
			println("Enjoy.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
