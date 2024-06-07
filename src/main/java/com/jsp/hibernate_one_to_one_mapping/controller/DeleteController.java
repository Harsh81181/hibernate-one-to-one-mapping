package com.jsp.hibernate_one_to_one_mapping.controller;

import com.jsp.hibernate_one_to_one_mapping.dao.PersonAdharDao;

public class DeleteController {
public static void main(String[] args) {
	PersonAdharDao dao=new PersonAdharDao();
	
	 if(dao.deletePersonByID(121)){ System.out.println("deleted"); } else {
	 System.out.println("not deleted"); }
	 
//	if(dao.deleteAdharByPersonID(120)){ System.out.println("deleted"); }
//	else {
//		System.out.println("not deleted"); }
}
}
