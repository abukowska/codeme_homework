package com.codeme.homework2.warehouse.model;

import com.codeme.homework2.warehouse.util.Appendable;
import com.codeme.homework2.warehouse.util.AppendableArray;

public class Warehouse implements Appendable {
	
	private Appendable app;

	public Warehouse() {
		app = new AppendableArray();
	}

	@Override
	public Appendable append(Object item) {
		return app.append(item);
	}

	@Override
	public Object[] getAppendableArray() {
		return app.getAppendableArray();
	}

	@Override
	public Appendable removeElement(Object item) {
		return app.removeElement(item);
	}
	
}
