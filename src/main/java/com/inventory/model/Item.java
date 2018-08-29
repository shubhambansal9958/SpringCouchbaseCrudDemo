package com.inventory.model;

import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Item {

	@Id
	@Field
	private String id;

	@Field
	private String name;

	@Field
	private int price;

	@Field
	private int quantity;
	
	@Field
	private List<String> serviceCentre;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public List<String> getServiceCentre() {
		return serviceCentre;
	}

	public void setServiceCentre(List<String> serviceCentre) {
		this.serviceCentre = serviceCentre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object obj) {
		Item item = (Item) obj;
		return id.equals(item.getId()) && name.equals(item.getName());
	}

}
