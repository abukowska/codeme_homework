package com.codeme.homework2.warehouse.util;

/**
 * Interfejs do zwiększania kolekcji
 *
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public interface Appendable {

	/**
	 * Dodanie kolejnego elementu do kolekcji
	 * 
	 * @param item
	 *            Nowy element kolekcji
	 * 
	 * @return Powiększana kolekcja
	 */
	public Appendable append(Object item);
	
	public Object[] getAppendableArray();
	
	public Appendable removeElement(Object item);

}