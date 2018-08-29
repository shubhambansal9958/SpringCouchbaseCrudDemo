package com.inventory.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.inventory.controller.ItemController;
import com.inventory.model.Item;
import com.inventory.repository.ItemRepository;
import com.inventory.service.ItemService;

class ItemTestCase {

	@Test
	void test_forRepository() {

		Item item = new Item("101", "Computer", 25000, 15);
		ItemRepository itemRepository = mock(ItemRepository.class);

		when(itemRepository.findById("101")).thenReturn(Optional.of(item));
		assertEquals(item, itemRepository.findById("101").get());

	}

	@Test
	void test_forService() {

		Item item = new Item("111", "Mobile", 12000, 10);
		ItemService itemService = mock(ItemService.class);

		when(itemService.findById("111")).thenReturn(Optional.of(item));
		assertEquals(item, itemService.findById("111").get());

	}

	@Test
	void test_forController() {

		Item item = new Item("105", "Printer", 2300, 25);
		ItemController itemController = mock(ItemController.class);

		when(itemController.findById("105")).thenReturn(Optional.of(item));
		assertEquals(item, itemController.findById("105").get());

	}

	@Test
	void test_forRepository_negativeCase() {

		ItemRepository itemRepository = mock(ItemRepository.class);

		when(itemRepository.findById(anyString())).thenReturn(null);
		assertEquals(null, itemRepository.findById("101"));

	}

	@Test
	void test_forService_negativeCase() {

		ItemService itemService = mock(ItemService.class);

		when(itemService.findById(anyString())).thenReturn(null);
		assertEquals(null, itemService.findById("111"));

	}

	@Test
	void test_forController_negativeCase() {

		ItemController itemController = mock(ItemController.class);

		when(itemController.findById(anyString())).thenReturn(null);
		assertEquals(null, itemController.findById("105"));

	}

}
