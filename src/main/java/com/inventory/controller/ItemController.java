package com.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Item;
import com.inventory.model.NameWrapper;
import com.inventory.model.PriceWrapper;
import com.inventory.model.QuantityWrapper;
import com.inventory.model.ServiceCentreWrapper;
import com.inventory.service.ItemService;;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping
	public void save(@RequestBody Item Item) {
		itemService.save(Item);
	}

	@GetMapping
	public List<Item> findAll() {
		return itemService.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Item> findById(@PathVariable("id") String id) {
		return itemService.findById(id);
	}

	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable("id") String id) {
		itemService.deleteById(id);
	}

	@GetMapping("/name/{name}")
	public List<Item> findByItemName(@PathVariable("name") String itemName) {
		return itemService.findByItemName(itemName);
	}
	
	@PostMapping(value = "/id/{id}/service_centre")
	public void updateServiceCentre(@PathVariable("id") String id, @RequestBody ServiceCentreWrapper wrapper) {
		itemService.updateServiceCentre(id, wrapper.getServiceCentre());
	}

	@PostMapping(value = "/id/{id}/price")
	public void updatePrice(@PathVariable("id") String id, @RequestBody PriceWrapper wrapper) {
		itemService.updatePrice(id, wrapper.getPrice());
	}

	@PostMapping(value = "/id/{id}/name")
	public void updateName(@PathVariable("id") String id, @RequestBody NameWrapper wrapper) {
		itemService.updateName(id, wrapper.getName());
	}

	@PostMapping(value = "/id/{id}/quantity")
	public void updateQuantity(@PathVariable("id") String id, @RequestBody QuantityWrapper wrapper) {
		itemService.updateQuantity(id, wrapper.getQuantity());
	}

}
