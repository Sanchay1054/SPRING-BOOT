package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.User;

@Repository
public interface ProjectsUserRepository extends JpaRepository<User,Integer>{

}
