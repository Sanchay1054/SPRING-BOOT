package com.example.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.ui;

import com.example.Entity.Content;
import com.example.Entity.User;
import com.example.Service.ContentService;
import com.example.Service.ProjectsUserService;
//import com.example.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;

@ComponentScan(basePackages= {"com.example.Service.UserService","com.example.Repository.UserRepository"})



@Controller
public class ProjectsController {
	//@Autowired
	//private UserService service;
	@Autowired
	private ProjectsUserService pus;
	@Autowired
	private ContentService cs;
	
	@GetMapping("/")
	public String login()
	{
		int id = 5;
		return "login";
	}
	 @PostMapping("/save")
	 public String save(@ModelAttribute User user)
	 {
		 //service.save(user);
		 pus.addUser(user);
		 System.out.print(user.getName());
		 return "signin";
	 }
	 @GetMapping("/search/{id}")
	 public String search(@PathVariable int id, Model m)
	 {
		 int i;
		 List<User>u = pus.getAllUser();
		 System.out.print(id);
		 m.addAttribute("user",u);
		 m.addAttribute("id",id);
		 for(i=0; i<u.size(); i++)
		 {
			 System.out.print(u.get(i).getName()+" ");
			 if(i==10)
			 {
				 break;
			 }
		 }
		 return "search";
	 }
	 @PostMapping("/savecontent/{id}")
	 public String saveContent(@PathVariable int id, @ModelAttribute Content content)
	 {
		 content.setUserId(id);
		 cs.addContent(content);
		 //content.setUserId(id);
		 System.out.print(content.getUserId());
		 return "redirect:/repository/"+id;
	 }
	 @GetMapping("/addcontent/{id}")
	 public String addContent(@PathVariable int id, Model m)
	 {
		 m.addAttribute("id",id);
		 return "addcontent";
	 }
	 @GetMapping("/repository/{id}")
	 public String repository(@PathVariable int id, Model m)
	 {
		 List <Content> c = cs.getAllContent();
		 String name[];
		 int i,size = c.size();
		 name = new String[size];
		 m.addAttribute("content",c);
		 m.addAttribute("id",id);
		 m.addAttribute("size",size);
		 //System.out.print(pus.getName(cs.getUserId(1)));
		 for(i=0; i<size; i++)
		 {
			 try
			 {
			 name[i] = pus.getName(cs.getUserId(i+1));
			 }
			 catch(Exception e)
			 {
				 name[i] = "";
				 break;
			 }
			 //System.out.print(name[i]);
		 }
		 m.addAttribute("name",name);
		 return "repository";
	 }
	 @GetMapping("/signin")
	 public String signin()
	 {
		 return "signin";
	 }
	 @PostMapping("/valid")
	 public String valid(String name, String password)
	 {
		 int id;
		 List <User> u = pus.getAllUser();
		 System.out.print(name);
		 for(User ur:u)
		 {
			 System.out.print(ur.getName());
			 if(ur.getName().compareTo(name)==0 && ur.getPassword().compareTo(password)==0)
			 {
				 id = ur.getId();
				 System.out.print(ur.getId());
				 return "redirect:/repository/"+id;
			 }
		 }
		 return "signin";
	 }
	 @GetMapping("/content/{id}")
	 public String content(@PathVariable int id, Model m)
	 {
		 int i=0,good[];
		 List <User> u = pus.getAllUser();
		 //List <Content> c = cs.getAllContent();
		 List <Content> con = new ArrayList<>();
		 User us = null;
		 String title[],lang[],about[],comm[];
		 title = new String[100];
		 lang = new String[100];
		 about = new String[100];
		 comm = new String[100];
		 good = new int[100];
		 
		 List <Content> c = cs.getAllContent();
		 
		 for(User ur:u)
		 {
			 if(ur.getId()==id)
			 {
				 System.out.print(ur.getId()+"   ");
				 us = ur;
				 break;
			 }
		 }
		 /*for(Content cn:c)
		 {
			 if(cn.getUserId()==id)
			 {
					 title[i] = cn.getTitle();
					 lang[i] = cn.getLanguage();
					 about[i] = cn.getAbout();
					 comm[i] = cn.getComment();
					 good[i] = cn.getGood();
					 i++;
			 }
		 }
		 for(Content cn:con)
		 {
			 System.out.print(cn.getTitle());
		 }*/
		 //System.out.print(title);
		 int size = c.size();
		 i=0;
		 int useri[] = new int[size];
		 for(Content cn:c)
		 {
			 useri[i] = cn.getUserId();
			 i++;
		 }
		 m.addAttribute("user",us);
		 m.addAttribute("content",c);
		 m.addAttribute("size",size);
		 m.addAttribute("id",id);
		 m.addAttribute("userid",useri);
		 /*m.addAttribute("t",title);
		 m.addAttribute("l",lang);
		 m.addAttribute("a",comm);
		 m.addAttribute("c",about);
		 m.addAttribute("g",good);
		 m.addAttribute("size",(i-1));*/
		 if(us!=null)
		 {
			 return "content";
		 }
		 else
		 {
			 return "redirect:/signin";
		 }
	 }
	 

}
