package com.myAPI.mySplitAPI.entity;

import java.util.Date;
import java.util.GregorianCalendar;


import lombok.Getter;

@Getter 
public class Person {
	
	private String name;
	private String email;
	private Date DOB;
	private Integer IOwe;
	private Integer UOwe;
	
	public String getDOB()
	{
		return DOB.toGMTString();
	}
	
    public int getTotalBalance()
    {
    	return (this.UOwe - this.IOwe);
    }

	public Person(String name, String email, String dOB, Integer iOwe, Integer uOwe) {
		
		this.name = name;
		this.email = email;
		DOB = new GregorianCalendar(Integer.valueOf(dOB.substring(6,10)),Integer.valueOf(dOB.substring(3,5)),Integer.valueOf(dOB.substring(0,2))).getTime();
		IOwe = iOwe;
		UOwe = uOwe;
	}
    
   
}
