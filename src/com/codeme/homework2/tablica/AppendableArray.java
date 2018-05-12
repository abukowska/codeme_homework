package com.codeme.homework2.tablica;

import java.util.Arrays;


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

	@Override
	public Appendable append(Object item, int index) {
		if (index <= appendArray.length - 1) {
			appendArray[index] = item;
		} else if (index == appendArray.length) {
			append(item);
		}
		return this;
	}

}
