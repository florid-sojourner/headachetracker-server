package com.headachetracker;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "headache")
public class Headache {
	
	@Id
    @GeneratedValue
    private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date time;
	
	Integer getId() {
		return this.id;
	}
	
	void setTime(Date time) {
		this.time = time;
	}
	
	Date getTime() {
		return this.time;
	}
	
	public String toString() {
		return this.time.toString();
	}
}
