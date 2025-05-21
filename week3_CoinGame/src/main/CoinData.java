package main;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

public class CoinData {
	
	
	Queue<String> queue = new LinkedList<String>();

	public Queue<String> getQueue() {
		return queue;
	}

	public void setQueue(Queue<String> queue) {
		this.queue = queue;
	}
	
	public void Queueset(String data) {
		this.queue.add(data);
	}
	
	public void printQueue() {
		for(String item : queue) {
			System.out.println(item);
		}
	}

	public CoinData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

