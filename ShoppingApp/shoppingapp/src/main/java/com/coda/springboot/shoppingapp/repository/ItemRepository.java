package com.coda.springboot.shoppingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coda.springboot.shoppingapp.model.Item;

//@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, String>{

	/*
	@Query("SELECT * FROM item WHERE itemtype = :itemtype")
	public List<Item> findByItemtype(@Param("itemtype")String itemtype);
	*/
	
	List<Item> findByItemtype(String itemtype);
	
}
