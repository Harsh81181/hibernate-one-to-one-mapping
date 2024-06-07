package com.jsp.hibernate_one_to_one_mapping.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_one_mapping.dto.Adhar;
import com.jsp.hibernate_one_to_one_mapping.dto.Person;

public class PersonAdharDao {
	EntityManager em=Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Person savePersonAdharDao(Person person,Adhar adhar) {
		try {
			
			et.begin();
			//em.persist(adhar);
			person.setAdhar(adhar); 
			em.persist(person);
			et.commit();
			return person;
			 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deletePersonByID(int personId) {
		Person person=em.find(Person.class, personId);
		System.out.println(person);
		if(person!=null) {
			try {
				et.begin();
				em.remove(person);
				et.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}return false;
	}
	public boolean deleteAdharByPersonID(int personId) {
		Person person=em.find(Person.class, personId);
		if(person!=null) {
			try {
				Adhar adhar=person.getAdhar();
				person.setAdhar(null);
				et.begin();
				if(adhar!=null) {
				em.remove(adhar);
				et.commit();
				return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}return false;
	}
	
	public boolean deleteAdharBYAdharNumberByPerson(long adharId) {
		String selectQuery="Select p from Person p Where p.adhar.adharNumber=?1";
		Query query=em.createQuery(selectQuery);
		query.setParameter(1, adharId);
		try {
			Person person=(Person)query.getSingleResult();
			if(person!=null) {
				Adhar adhar=person.getAdhar();
				person.setAdhar(null);
				et.begin();
				em.remove(adhar);
				et.commit();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteAdharBYAdharNumber(long adharNumber) {
		Adhar adhar=em.find(Adhar.class, adharNumber);
		try {
			et.begin();
			em.remove(adhar);
			et.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertAdharByPersonIdDao(int id,Adhar adhar) {
	Person person=	em.find(Person.class, id);
	if(person!=null) {
		person.setAdhar(adhar);
		try {
			et.begin();
			em.persist(adhar);
			em.merge(person);
			et.commit();
			return true;
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}else {
		System.out.println("Given id is wrong");
	}
	return false;
	}
	
	public boolean updateAdharDobbyPersonPhone(long phone,String dob) {
		String selectQuery="Select p from Person p Where p.phone=?1	";
		try {
		Query query=em.createQuery(selectQuery);
		query.setParameter(1, phone);
		
			Person person=(Person)query.getSingleResult();
			if(person!=null) {
				person.getAdhar().setDob(LocalDate.parse(dob));;
				et.begin();
				em.merge(person);
				et.commit();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}

