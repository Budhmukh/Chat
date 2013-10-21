package com.cg.service;

public interface IBusinessLogic {
	public boolean validate(String userid, String password);
	public String findName(String userid);

}
