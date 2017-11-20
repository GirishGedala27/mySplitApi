package com.myAPI.mySplitAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myAPI.mySplitAPI.entity.Person;
import com.myAPI.mySplitAPI.entity.SplitGroup;
import com.myAPI.mySplitAPI.entity.SplitRequest;
import com.myAPI.mySplitAPI.entity.SplitResponse;

@Service
public class SplitService {

	private double splitValueforEachPerson;
	private double updatedValue;
	private List<Person> updatedGroup = new ArrayList<Person>();

	public SplitResponse calculateSplit(SplitRequest splitRequest) {
		splitValueforEachPerson = (splitRequest.getSplitValue().getTotalSplitAmount())
				/ (splitRequest.getSplitValue().getTotalSplitGroupCount());

		for (Person p : splitRequest.getSplitGroup().getSplitGroupMembers()) {
			updatedValue = splitValueforEachPerson + p.getIOwe();
			p.updateIOwe(updatedValue);
			updatedGroup.add(p);
		}

		SplitGroup splitResponseGroup = SplitGroup.builder().splitGroupMembers(updatedGroup).build();
		return new SplitResponse(splitResponseGroup);
	}

}
