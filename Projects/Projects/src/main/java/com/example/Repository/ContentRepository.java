package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content,Integer>{

}
