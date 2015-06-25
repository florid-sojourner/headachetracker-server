package com.headachetracker;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

//test the github

public class HandlerTest {

	public static void main (String[] args) {
		
		HeadacheDataHandler headacheDataHandler = new HeadacheDataHandler();
		
		// create a timestamp to pass into the database 
		Calendar calendar = Calendar.getInstance(); 
		java.util.Date currentDate = calendar.getTime();
		
		// insert the timestamp
		headacheDataHandler.insertTime(currentDate);
		
		// get a list of all timestamps from the database
		List<Headache> headacheList = headacheDataHandler.selectTimes();
		System.out.println("Headaches Count: " + headacheList.size());
		
		Iterator<Headache> iterator = headacheList.iterator();
        while(iterator.hasNext()) {
            Headache headache = iterator.next();
            System.out.println(headache.toString());
        }
        
	}
}
