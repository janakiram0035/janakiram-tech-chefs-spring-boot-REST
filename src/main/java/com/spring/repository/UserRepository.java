package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query(value = "Select user From user u where u.name=:userName")
	 User getUserByName(@Param("userName") String userName);

}
