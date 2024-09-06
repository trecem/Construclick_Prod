package com.construclick.construclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construclick.construclick.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
