package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Items;
import com.example.demo.services.ItemsService;

@RestController
public class ItemsControllers {

	@Autowired
	ItemsService itemsservice;
	
	@GetMapping("/AllItems")
	public List<Items> getAllItems(){
		return itemsservice.getAllItems();
	}
	
	@GetMapping("/Allitems/{id}")
	public Items getItemById(@PathVariable(value="id")int id) {
		return itemsservice.getItemById(id);
	}
	
	@PostMapping("/createitem")
	public Items createItems(@RequestBody Items items) {
		return itemsservice.createItems(items);
	}

	
	
	@PutMapping("/updateitem/{id}")
	public Items updateItems(@PathVariable(value="id")int id, @RequestBody Items items) {
		Items existItems = itemsservice.getItemById(id);
		existItems.setProduct(items.getProduct());
		existItems.setPrice(items.getPrice());
		existItems.setCompany(items.getCompany());
		
		return itemsservice.updateItems(existItems);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable(value="id")int id) {
		String result = itemsservice.deleteItems(id);
		if(result.equals("Item Deleted !!")) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.status(404).body(result);
		}
	}
	
}
