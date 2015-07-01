package com.headachetracker;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import com.headachetracker.Headache;

public class SymptomModel {
	private List<Headache> headaches;
	
	public SymptomModel() {
		
	}
	
	public void insertHeadacheAtTime(Date time) {
		
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Headache newHeadache = new Headache();
        newHeadache.setTime(time);
                
        session.save(newHeadache);
        transaction.commit();
        
        System.out.println("New headache ID is: " + newHeadache.getId());
	}
	
	public List<Headache> selectHeadaches() {
		
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query headachesQuery = session.createQuery("select h from Headache as h");
        headaches = headachesQuery.list();
        
        return headaches;

	}
}