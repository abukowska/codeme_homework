package com.codeme.homework2.tablica;

public class TestClass {

	public static void main(String[] args) {
		
		Appendable app = new AppendableArray();
		
		Object a = new Object();
		Object b = new Object();
		app.append(a);
		app.append(b);
		app.append(null);

		Object c = new Object();
		app.append(c, 2);

		Object d = new Object();
		app.append(d, 2);
		
		Object e = new Object();
		Appendable k = app.append(e, 3);
				
		Object f = new Object();
		Appendable aa = app.append(f, 16);
		
		System.out.println(aa);
	}

}
