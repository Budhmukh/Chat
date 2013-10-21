package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.service.BusinessLogic;
import com.cg.service.IBusinessLogic;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller1 {
	private static List<String> adminList=new ArrayList<String>();
	@Autowired
	IBusinessLogic bs;
	@RequestMapping(method=RequestMethod.GET)
		public String index(){
		return "home";
	}
	@RequestMapping(value="/representative", method=RequestMethod.POST)
	public String validate(HttpServletRequest request,ModelMap map,@RequestParam("userid") String userid,@RequestParam("password") String password){
		System.out.println("Request Received");
		System.out.println(userid);
		System.out.println(password);
		boolean isValid=bs.validate(userid,password);
		if(isValid){
			String username=bs.findName(userid);
			map.put("username", username);
			adminList.add(username);
			ServletContext sc=request.getSession().getServletContext();
			sc.setAttribute("adminlist", adminList);
			return "representative_welcome";
		}
		else{
			return "faild";
		}
		
	
		
	}
	@RequestMapping(value="/res_login",method=RequestMethod.GET)
	public String res(){
	return "res_login";
}
	@RequestMapping(value="/customerlogin",method=RequestMethod.GET)
	public String cus(){
	return "customerlogin";
}
	@RequestMapping(value="/customerwelcome",method=RequestMethod.POST)
	public String cuswel(){
	return "customerwelcome";
}
	@RequestMapping(value="/clogout",method=RequestMethod.GET)
	public String clogout(){
	return "clogout";
}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String rlogout(@RequestParam("username") String username,HttpServletRequest request){
		ServletContext sc=request.getSession().getServletContext();
		List<String> adminlist=(List<String>) sc.getAttribute("adminlist");
		adminlist.remove(username);
	return "logout";
}
}
