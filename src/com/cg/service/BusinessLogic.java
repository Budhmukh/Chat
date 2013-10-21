package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pojo.Representative;
import com.cg.repository.IRepresentative;
@Service
public class BusinessLogic implements IBusinessLogic{
	@Autowired
	IRepresentative rep;
	@Transactional
	public boolean validate(String userid, String password) {
		System.out.println("hi");
		Representative r=rep.findOne(userid);
		if(r==null){
			return false;
		}
		
		System.out.println(r);
		if(password.equals(r.getPassword())){
			return true;
		}
		
		return true;
		// TODO Auto-generated method stub
		
	}
	public String findName(String userid){
		Representative r=rep.findOne(userid);
		return r.getRepresentative_Name();
		
	}

}
