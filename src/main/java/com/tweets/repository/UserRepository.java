package com.tweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweets.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
