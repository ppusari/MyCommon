package com.ppusari.java.structure.list;

public class Item {

	private int id;
	private String name;
	private long price;
	private static int counter = 0;
	
	Item(String name, long price) {
		id = counter++;
		this.name = name;
		this.price = price;				
	}
	
	public String toString()
	{
		return String.format("id: %d, name: %s, prive: %d", id, name, price);		
	}
}
