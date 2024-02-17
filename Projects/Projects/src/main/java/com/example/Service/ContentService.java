package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Content;
import com.example.Repository.ContentRepository;

@Service
public class ContentService {

	@Autowired
	private ContentRepository c;
	
	public void addContent(Content content)
	{
		c.save(content);
	}
	public List<Content> getAllContent()
	{
		return c.findAll();
	}
	public int getUserId(int id)
	{
		Optional <Content> con = c.findById(id);
		//System.out.print(con.get().getUserId());
		Content con1 = con.get();
		return con1.getUserId();
	}
	public List<Content> getContent(int id)
	{
		List <Content> com = c.findAll();
		return com;
		
	}
}
