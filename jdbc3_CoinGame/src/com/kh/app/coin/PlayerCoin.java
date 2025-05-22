package com.kh.app.coin;

public class PlayerCoin {
	String name;
	String coinname;
	int cnt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoinname() {
		return coinname;
	}
	public void setCoinname(String coiname) {
		this.coinname = coiname;
	}
	@Override
	public String toString() {
		return "PlayerCoin [name=" + name + ", coiname=" + coinname + ", cnt=" + cnt + "]";
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
