package com.kh.app;

import com.kh.app.coin.GameManager;

public class Main {

	public static void main(String[] args) {
		
		GameManager gameManager = new GameManager();
		String name = gameManager.addPlayer();
		while(gameManager.menu(name)) {
			
	}
	}
}
