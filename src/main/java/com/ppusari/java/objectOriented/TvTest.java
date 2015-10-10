package com.ppusari.java.objectOriented;
class Tv {
	String color;
	boolean power;
	int channel;
	
	Tv(String color, boolean power, int channel) {
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	
	void power() {
		power = !power;
	}
	
	void channelUp()  {
		++channel;	 
	}
	
	void channelDown() {
		--channel;		
	}
	
	public String toString()
	{
		return String.format("color:%s, power:%s, channel:%d", color, String.valueOf(power), channel );
	} 
	
	public boolean isEqual(Tv tv) {
		if ( this.color == tv.color && this.power == tv.power && this.channel == tv.channel )
			return true;
		else
			return false;
	}
}

public class TvTest {
	public static void main(String[] args)
	{
		Tv tv = new Tv("RedTv", false, 5);  
	
		System.out.println(tv.toString());
		
		tv.power();
		tv.channelUp();
		System.out.println(tv.toString());
		
		Tv tv2 = new Tv("Blue", true, 11);
		System.out.println(tv2.toString()); 
		System.out.println(tv.toString());
	}
}
