package com.jconcept.week_8_taskmanagerapp.repository;

import com.jconcept.week_8_taskmanagerapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllByOrderByDueDateAscPriorityAsc();

	List<Task> findAllByOrderByDueDateAscPriorityDesc();

	List<Task> findAllByOrderByPriorityAscDueDateAsc();

}
