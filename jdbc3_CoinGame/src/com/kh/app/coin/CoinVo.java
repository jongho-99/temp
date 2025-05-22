package com.kh.app.coin;

public class CoinVo {
    private int no;
    private String name;
    private int price;
    private int cnt;
    
    public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setNo(int no) {
		this.no = no;
	}



	@Override
	public String toString() {
		return "CoinVo [no=" + no + ", name=" + name + ", price=" + price + ", cnt=" + cnt + "]";
	}

	public CoinVo(int no, String name, int price, int cnt) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CoinVo() {
    	
    }
    
    public CoinVo(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}