package com.myAPI.mySplitAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myAPI.mySplitAPI.entity.Person;
import com.myAPI.mySplitAPI.entity.SplitGroup;
import com.myAPI.mySplitAPI.entity.SplitRequest;
import com.myAPI.mySplitAPI.entity.SplitResponse;
import com.myAPI.mySplitAPI.exception.SplitException;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class SplitService {

	private double splitValueforEachPerson;
	private double updatedValue;

	// primary method that performs the split functionality
	public SplitResponse calculateSplit(SplitRequest splitRequest) {
		List<Person> updatedGroup = new ArrayList<Person>();
		if(isValidSplit(splitRequest))
		{
			log.debug("split will be performed");
		splitValueforEachPerson = (splitRequest.getSplitValue().getTotalSplitAmount())
				/ (splitRequest.getSplitValue().getTotalSplitGroupCount());
		
		for (Person p : splitRequest.getSplitGroup().getSplitGroupMembers()) {
			updatedValue = splitValueforEachPerson + p.getIOwe();

			p.updateIOwe(updatedValue);
			updatedGroup.add(p);
		}

		SplitGroup splitResponseGroup = SplitGroup.builder().splitGroupMembers(updatedGroup).build();
		log.info("split performed successfully..");
		return new SplitResponse(splitResponseGroup);
		}else{
			throw new SplitException("500.BADSPLIT","Error while performing split, group size and split value members count do not match");
		}
	}

	// Method to validate the given input request
	private boolean isValidSplit(SplitRequest splitRequest) {
		
		if(splitRequest.getSplitGroup().getSplitGroupMembers().size() == splitRequest.getSplitValue().getTotalSplitGroupCount())
		{
			log.info("split request is valid and split will be performed");
			return true;
		}
		
		return false;
		
	}

}
