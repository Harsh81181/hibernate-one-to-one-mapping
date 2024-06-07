package com.jsp.hibernate_one_to_one_mapping.controller;

import java.util.Scanner;

import com.jsp.hibernate_one_to_one_mapping.dao.PersonAdharDao;

public class UpdateAdharDobByPersonPhone {
public static void main(String[] args) {
	PersonAdharDao dao=new PersonAdharDao();
	Scanner sc= new Scanner(System.in);
	System.out.print("Enter phone number:- ");
	long phone=sc.nextLong();
	sc.nextLine();
	System.out.print("Enter dob in yyyy-mm-dd:- ");
	String dob=sc.next();
	if(dao.updateAdharDobbyPersonPhone(phone, dob)) {
		System.out.println("Adhar has updated");
	}
	else {
		System.out.println("Adhar hasn't updated");
	}
	sc.close();
}
}
