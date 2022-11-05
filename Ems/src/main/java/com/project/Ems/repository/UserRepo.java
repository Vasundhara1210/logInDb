package com.project.Ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ems.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByUserId(String userId);

}
