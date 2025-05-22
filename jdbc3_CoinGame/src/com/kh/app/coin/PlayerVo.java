package com.kh.app.coin;




public class PlayerVo {
    private String name;
    private int money;
    
    private String id;
    private String pwd;
    
    public void setName(String name) {
		this.name = name;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	public PlayerVo() {
		
	}
	
	public PlayerVo(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}


    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
