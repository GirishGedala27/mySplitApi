package com.myAPI.mySplitAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myAPI.mySplitAPI.entity.SplitGroup;
import com.myAPI.mySplitAPI.entity.SplitRequest;
import com.myAPI.mySplitAPI.entity.SplitResponse;
import com.myAPI.mySplitAPI.entity.SplitValue;
import com.myAPI.mySplitAPI.service.PersonService;
import com.myAPI.mySplitAPI.service.SplitService;

@RestController
public class SplitThisController {

	@Autowired
	SplitService splitService;

	@Autowired
	PersonService pservice;

	@RequestMapping(method = RequestMethod.POST, value = "/split")
	public SplitResponse performSplit(@RequestBody SplitRequest request) {
		return splitService.calculateSplit(request);

	}


}
