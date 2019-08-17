package com.banksteel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value="testRestDelete/{id}", method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") int id) {
		System.out.println("testRestDelete:" + id);
		return "hello";
	}
	@RequestMapping(value="testRestPut/{id}", method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") int id) {
		System.out.println("testRestPut:" + id);
		return "hello";
	}
	@RequestMapping(value="testRestPost", method=RequestMethod.POST)
	public String testRestPost() {
		System.out.println("testRestPost:");
		return "hello";
	}
	@RequestMapping(value="testRestGet/{id}", method=RequestMethod.GET)
	public String testRestGet(@PathVariable("id") int id) {
		System.out.println("testRestGet:" + id);
		return "hello";
	}
	@RequestMapping(value="testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") int id) {
		System.out.println("id:" + id);
		return "hello";
	}
	@RequestMapping(value="testParamsAndHeaders", params= {"userName","age!=10"}, headers = {"Connection=keep-alive"})
	public String testParamsAndHeaders() {
		return "hello";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	@RequestMapping(value="/helloPost", method=RequestMethod.POST)
	public String helloPost() {
		return "hello";
	}
}
