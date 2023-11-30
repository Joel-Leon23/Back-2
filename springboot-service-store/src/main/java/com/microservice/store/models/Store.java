package com.microservice.store.models;

public class Store {
	
	
	
	private Cellphone cel;
	private Integer quantity;
	
	public Store() {
		
	}

	public Store(Cellphone cel, Integer quantity) {
		super();
		this.cel = cel;
		this.quantity = quantity;
	}
	
	 public Cellphone getCel() {
		return this.cel;
	}
	
	public void setCel(Cellphone cel) {
		this.cel = cel;
	}
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
