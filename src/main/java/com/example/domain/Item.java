package com.example.domain;

public class Item {

	/** 商品名 */
	private String name;
	/** 価格 */
	private Integer price;
	
	// コンストラクタ
	public Item(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	// getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
