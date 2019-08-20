package com.banksteel.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.banksteel.bean.User;
/**
 * @CookieValue
 * 	cookie 值
	@RequestHeader
	请求头
 * @author wukaifeng123
 *
 */
@Controller
@SessionAttributes(names= {"time"})
public class HelloController {
	
	@ModelAttribute  
	public String testModeAttributes(String str) {
		System.out.println("str:" +str);
		
		return "aaaaa";
	}
	
	@RequestMapping(value="testModel", method=RequestMethod.POST)
	public String testModel(Model model) {
		model.addAttribute("time", System.currentTimeMillis());
		return "hello";
	}
	
	@RequestMapping(value="testMap", method=RequestMethod.POST)
	public String testMap(Map<String, Object> map) {
		map.put("time", System.currentTimeMillis());
		return "hello";
	}
	
	@RequestMapping(value="testModelAndView", method=RequestMethod.POST)
	public ModelAndView testModeAndView() {
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("time", System.currentTimeMillis());
		return modelAndView;
	}
	
	@RequestMapping(value="testServlet", method=RequestMethod.POST)
	public String testServlet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request:" + request + "====" + "response:" + response);
		
		return "hello";
	}
	
	@RequestMapping(value="testUserObj/{id}", method= RequestMethod.POST)
	public String testUserObj(User user) {
		System.out.println("User:" + user);
		return "hello";
	}
	
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
