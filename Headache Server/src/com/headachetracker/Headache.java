package com.headachetracker;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "headache")
public class Headache {
	
	@Id
    @GeneratedValue
    private Integer id;
    private String htime;
	
	Integer getId() {
		return this.id;
	}
	
	void setHtime(String htime) {
		this.htime = htime;
	}
	
	String getHtime() {
		return this.htime;
	}
}
