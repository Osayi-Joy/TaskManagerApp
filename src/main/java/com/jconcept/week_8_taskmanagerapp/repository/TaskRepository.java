package com.example.ToDoList.repository;

import com.example.ToDoList.entity.Item;
import com.example.ToDoList.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findAllByOrderByDueDateAscPriorityAsc();

	List<Item> findAllByOrderByDueDateAscPriorityDesc();

	List<Item> findAllByOrderByPriorityAscDueDateAsc();

}
