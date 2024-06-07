package com.jsp.hibernate_one_to_one_mapping.controller;

import java.time.LocalDate;

import com.jsp.hibernate_one_to_one_mapping.dao.PersonAdharDao;
import com.jsp.hibernate_one_to_one_mapping.dto.Adhar;
import com.jsp.hibernate_one_to_one_mapping.dto.Person;

public class PersonAdharInsertController {
public static void main(String[] args) {
	PersonAdharDao dao=new PersonAdharDao();
	
	Adhar adhar=new Adhar(123214665232l, LocalDate.parse("1997-09-13"),"1/218 AF10 Gautham city" ,"Master wayn");
	Person person=new Person(124, "Batman", "batman012@gmail.com", 102232104123l, null);
	
	dao.savePersonAdharDao(person, adhar);
}
}
