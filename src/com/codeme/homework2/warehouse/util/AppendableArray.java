package com.codeme.homework2.warehouse.util;

import java.util.Arrays;

/**
 * Implementacja interfejsu do zwiększania kolekcji
 *
 * @author Asia Zawadzka
 *
 */
public class AppendableArray implements Appendable {
	
	private Object[] appendArray;
	
	public AppendableArray() {
		appendArray = new Object[1];
	}

	@Override
	public Appendable append(Object item) {
		if (appendArray.length == 1 && appendArray[0] == null) {
			appendArray[0] = item;
		} else {
			Object[] appendArrayNew = Arrays.copyOf(appendArray, appendArray.length + 1);
			appendArrayNew[appendArray.length] = item; 
			appendArray = appendArrayNew;
		}
		return this;
	}
	
	public Object[] getAppendableArray() {
		return appendArray;
	}
	
	@Override
	public Appendable removeElement(Object item) {
		Object[] appendArrayNew1 = new Object[appendArray.length - 1];
		int counter = 0;
		int itemOccurenceCounter = 0;
		for(Object element : appendArray) {
			if(!element.equals(item)) {
				appendArrayNew1[counter] = element;
				counter++;
			} else {
				itemOccurenceCounter++;
			}
		}
		if(itemOccurenceCounter > 1) {
			Object[] appendArrayNewIfManySameItems = Arrays.copyOf(appendArrayNew1, appendArray.length - itemOccurenceCounter);
			appendArray = appendArrayNewIfManySameItems;
			return this;
		}
		appendArray = appendArrayNew1;
		return this;
	}

}
