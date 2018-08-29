package com.inventory.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.inventory.model.Item;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "item")
public interface ItemRepository extends CouchbaseRepository<Item, String> {

	@Query("#{#n1ql.selectEntity} where name = $1")
	List<Item> findByItemName(String itemName);
}
