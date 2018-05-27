package com.codeme.homework2.warehouse;

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
		println("Choose option, 1 OR 2:");
		println("(1) See available products.");
		println("(2) Under construction.");
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
		Water waterN = new Water("woda Naleczowianka", 2.5, "1l");
		Water waterZ = new Water("woda Zywiec", 2.4, "1l");
		Bread bread = new Bread("bread", 3.30, "1 piece");
		Potatoes potatoes = new Potatoes("potatoes", 4.5, "1kg");
		warehouse.addToWarehouse(waterZ, 1);
		warehouse.addToWarehouse(waterZ, 3);
		warehouse.addToWarehouse(bread, 11);
		warehouse.addToWarehouse(potatoes, 30);
		warehouse.addToWarehouse(potatoes, 12);
		warehouse.addToWarehouse(potatoes, -10);
		warehouse.removeFromWarehouse(1, 2);
		warehouse.removeFromWarehouse(1, 3);
		warehouse.removeFromWarehouse(2, 3);
		warehouse.removeFromWarehouse(3, -50);
		try {
			do {
				displayMenu();
				String option = read().toLowerCase().trim();
				if (option.equals("1")) {
					displayAvailableProducts(warehouse);
				} else if (option.equals("2")) {
					println("Under construction.");
				} else if (option.equals("exit")) {
					break;
				} else {
					println("Please choose option 1, 2 OR exit.");
				}
			} while (true);
			println("Enjoy.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
