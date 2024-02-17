package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repository.ProjectsUserRepository;

@Service
public class ProjectsUserService {

	@Autowired
	private ProjectsUserRepository pur;
	
	public void addUser(User u)
	{
		pur.save(u);
	}
	public List<User> getAllUser()
	{
		return pur.findAll();
	}
	public String getName(int id)
	{
		Optional <User> u = pur.findById(id);
		User us = u.get();
		if(us.getName() != null)
		{
			return us.getName();
		}
		else
		{
			return "USER";
		}
	}
}
