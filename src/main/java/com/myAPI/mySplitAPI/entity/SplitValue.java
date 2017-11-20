package com.myAPI.mySplitAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SplitValue {

	private double totalSplitAmount;
	private int totalSplitGroupCount;

}
