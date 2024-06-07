package com.jsp.hibernate_one_to_one_mapping.controller;

import java.util.Scanner;

import com.jsp.hibernate_one_to_one_mapping.dao.PersonAdharDao;

public class DeleteAdharByAdharNumber {
public static void main(String[] args) {
	System.out.println("Enter Adhar number");
	Scanner sc=new Scanner(System.in);
	long adharNumber=sc.nextLong();
	PersonAdharDao da=new PersonAdharDao();
	if(da.deleteAdharBYAdharNumber(adharNumber)) {
		System.out.println("Adhar record has removed");
	}
	else {
		System.out.println("Adhar record can't remove");
	}
	sc.close();
}
}
