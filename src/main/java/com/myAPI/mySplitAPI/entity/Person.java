package com.myAPI.mySplitAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String name;
	private String email;
	private double IOwe;
	private double UOwe;

	public double getTotalBalance() {
		return (this.UOwe - this.IOwe);
	}

	public void updateIOwe(double updatedValue) {
		this.IOwe = updatedValue;
	}

	public void updateUOwe(double updatedValue) {
		this.UOwe = updatedValue;
	}
}
