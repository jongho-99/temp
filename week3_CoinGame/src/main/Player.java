package main;

public class Player {
	
	private String name;
	private int money;
	private int[] coinArr;
	
	public Player() {
		this.money = 10000000;
		this.coinArr = new int[5];
	}
	
	public Player(String name) {
		this.name = name;
		this.money = 10000000;
		this.coinArr = new int[5];
	}
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
		this.coinArr = new int[5];
	}
	
	
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int[] getCoinArr() {
		return coinArr;
	}
	public void setCoinArr(int[] coinArr) {
		this.coinArr = coinArr;
	}
	
	
	
	
	
}
