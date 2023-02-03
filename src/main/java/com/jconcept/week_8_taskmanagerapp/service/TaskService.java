package com.jconcept.week_8_taskmanagerapp.service;

import com.jconcept.week_8_taskmanagerapp.entity.Task;
import com.jconcept.week_8_taskmanagerapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findAllByOrderByDateAsc() {
		return taskRepository.findAllByOrderByDueDateAscPriorityAsc();
	}

	public List<Task> findAllByOrderByDateDesc() {
		return taskRepository.findAllByOrderByDueDateAscPriorityAsc();
	}

	public List<Task> findAllByOrderByPriorityAsc() {
		return taskRepository.findAllByOrderByPriorityAscDueDateAsc();
	}

	public Task getOne(Long id) {
		Optional<Task> result = taskRepository.findById(id);

		Task task = null;

		if (result.isPresent()) {
			task = result.get();
		}
		else {
			throw new RuntimeException("Did not find item id - " + id);
		}

		return task;
	}

	public void save (Task task) {
		taskRepository.save(task);
	}

	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}


}
