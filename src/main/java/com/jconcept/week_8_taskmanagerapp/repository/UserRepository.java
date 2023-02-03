package com.jconcept.week_8_taskmanagerapp.repository;


import com.jconcept.week_8_taskmanagerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
