package com.headachetracker;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


public class HandlerTest {

	public static void main (String[] args) {
		// test comment, can discard
		SymptomModel headacheDataHandler = new SymptomModel();
		
		// create a timestamp to pass into the database 
		Calendar calendar = Calendar.getInstance(); 
		java.util.Date currentTime = calendar.getTime();
		
		// insert the timestamp
		headacheDataHandler.insertHeadacheAtTime(currentTime);
		
		// get a list of all timestamps from the database
		List<Headache> headacheList = headacheDataHandler.selectHeadaches();
		System.out.println("Headaches Count: " + headacheList.size());
		
		Iterator<Headache> iterator = headacheList.iterator();
        while(iterator.hasNext()) {
            Headache headache = iterator.next();
            System.out.println(headache.toString());
        }
        
	}
}