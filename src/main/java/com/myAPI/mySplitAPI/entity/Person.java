package com.myAPI.mySplitAPI.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {

	private String name;
	private String email;
	private Integer IOwe;
	private Integer UOwe;

	public int getTotalBalance() {
		return (this.UOwe - this.IOwe);
	}
	
	public Person(){
		
	}

	public Person(String name, String email, Integer iOwe, Integer uOwe) {

		this.name = name;
		this.email = email;
		IOwe = iOwe;
		UOwe = uOwe;
	}

}
