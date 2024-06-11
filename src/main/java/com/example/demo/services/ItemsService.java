package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Items;
import com.example.demo.repositories.ItemsRepository;

@Service
@Component
public class ItemsService {
	
	@Autowired
	ItemsRepository itemsrepo;
	
	
	public List<Items> getAllItems(){
		return itemsrepo.findAll();
	}
	
	public Items getItemById(int id) {
		return itemsrepo.findById(id).get();
	}
	
	public int getMaxId() {
		return itemsrepo.findAll().size() + 1;
	}

	
	public Items createItems(Items items) {
		items.setId(getMaxId());
		return itemsrepo.save(items);
	}
	
	public Items updateItems(Items items) {
		itemsrepo.save(items);
		return items;
	}
	
	public String deleteItems(int id) {
		if (itemsrepo.existsById(id)) {
			itemsrepo.deleteById(id);
			return "Item Deleted !!";
		}else {
			return "Item Not Found";
		}
	}

}
