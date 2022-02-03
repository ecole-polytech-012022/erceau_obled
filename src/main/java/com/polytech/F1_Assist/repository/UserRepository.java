package com.polytech.F1_Assist.repository;

import com.polytech.F1_Assist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { // using JpaRepository super class
}
