package com.jsp.hibernate_one_to_one_mapping.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.hibernate_one_to_one_mapping.dao.PersonAdharDao;
import com.jsp.hibernate_one_to_one_mapping.dto.Adhar;

public class InsertAdharByPersonId {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter person id");
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Adhar number");
	long adharNumber=sc.nextLong();
	System.out.println("dob in yyyy-mm-dd");
	String dob=sc.next();
	System.out.println("Address");
	String address=sc.next();
	sc.nextLine();
	System.out.println("Father Name");
	String fatherName=sc.next();
	
	PersonAdharDao dao=new PersonAdharDao();
	if(dao.insertAdharByPersonIdDao(id, 
			new Adhar(adharNumber,LocalDate.parse(dob), address, fatherName))) {
		System.out.println("Adhar has attached with id- "+id);
	}
	else {
		System.out.println("Adhar has not saved");
	}
sc.close();			
}
}
