package main;

import java.util.LinkedList;
import java.util.Queue;

public class Coin {
	private String name;
	private int price;
	private Queue<String> queue = new LinkedList<String>();
		
	public Coin() {
		
	}
	
	public Coin(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	Queue<String> getPriceQueue() {
		return queue;
	}
	
	void addPriceQueue(String data) {
		if (queue.size() >= 5) {
			queue.poll();
		}
		queue.offer(data);
	}
	
}
