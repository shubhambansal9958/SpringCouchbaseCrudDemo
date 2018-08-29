package com.inventory.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.SimpleN1qlQuery;
import com.inventory.model.Item;
import com.inventory.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public Item save(Item Item) {
		return itemRepository.save(Item);
	}

	public Optional<Item> findById(String id) {
		return itemRepository.findById(id);
	}

	public void deleteById(String id) {
		itemRepository.deleteById(id);
	}

	public List<Item> findAll() {
		Iterable<Item> data = itemRepository.findAll();
		List<Item> list = new ArrayList<>();
		data.forEach(item -> list.add(item));
		return list;
	}

	public List<Item> findByItemName(String itemName) {		
		return itemRepository.findByItemName(itemName);
	}
	
	
	
	
	// Update Operations
	
	public void updateServiceCentre(String id, List<String> serviceCentre) {
		Item item = itemRepository.findById(id).get();
		item.setServiceCentre(serviceCentre);
		CouchbaseOperations operations = itemRepository.getCouchbaseOperations();
		operations.update(item);
	}
	public void updateName(String id, String name) {
		Item item = itemRepository.findById(id).get();
		item.setName(name);
		CouchbaseOperations operations = itemRepository.getCouchbaseOperations();
		operations.update(item);
	}
	public void updatePrice(String id, int price) {
		Item item = itemRepository.findById(id).get();
		item.setPrice(price);
		CouchbaseOperations operations = itemRepository.getCouchbaseOperations();
		operations.update(item);
	}
	public void updateQuantity(String id, int quantity) {
		Item item = itemRepository.findById(id).get();
		item.setQuantity(quantity);
		CouchbaseOperations operations = itemRepository.getCouchbaseOperations();
		operations.update(item);
	}
}
