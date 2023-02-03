package com.example.ToDoList.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;

	private String priority;

	private String status;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	public Item() {
	}

	public Item(String name, LocalDate dueDate, String priority, String status, User user) {
		this.name = name;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", title='" + name + '\'' +
				", dueDate=" + dueDate +
				", priority='" + priority + '\'' +
				", status='" + status + '\'' +
				", user=" + user +
				'}';
	}
}
