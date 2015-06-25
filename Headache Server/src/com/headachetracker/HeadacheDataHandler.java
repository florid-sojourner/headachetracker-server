package com.headachetracker;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class HeadacheDataHandler {

	public HeadacheDataHandler() {
		
	}
	
	public static void main(String[] args) {
		
		HeadacheDataHandler libraryTransaction = new HeadacheDataHandler();
		
		libraryTransaction.insertHtime("The Black Cauldron");
		
	}
	
	void insertHtime(String htime) {
		
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Headache newHeadache = new Headache();
        newHeadache.setHtime(htime);
                
        session.save(newHeadache);
        transaction.commit();
        
        System.out.println("New headache ID is: " + newHeadache.getId());
	}
	
	void selectHtimes() {
		
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query singleBookQuery = session.createQuery("select h from Headache as h");

	}
}