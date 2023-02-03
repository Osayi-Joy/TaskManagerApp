package com.example.ToDoList.service;

import com.example.ToDoList.entity.Item;
import com.example.ToDoList.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findAllByOrderByDateAsc() {
		return itemRepository.findAllByOrderByDueDateAscPriorityAsc();
	}

	public List<Item> findAllByOrderByDateDesc() {
		return itemRepository.findAllByOrderByDueDateAscPriorityAsc();
	}

	public List<Item> findAllByOrderByPriorityAsc() {
		return itemRepository.findAllByOrderByPriorityAscDueDateAsc();
	}

	public Item getOne(Long id) {
		Optional<Item> result = itemRepository.findById(id);

		Item item = null;

		if (result.isPresent()) {
			item = result.get();
		}
		else {
			throw new RuntimeException("Did not find item id - " + id);
		}

		return item;
	}

	public void save (Item item) {
		itemRepository.save(item);
	}

	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}


}
