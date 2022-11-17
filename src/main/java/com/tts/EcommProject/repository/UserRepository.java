package com.tts.EcommProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.EcommProject.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	User findByUsername(String username);
}
