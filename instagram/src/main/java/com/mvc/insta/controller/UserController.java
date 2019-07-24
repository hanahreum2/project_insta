package com.mvc.insta.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.insta.service.UserService;
import com.mvc.insta.vo.UserVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Model model) {

		return "user/signUpForm";
	}
	
	@RequestMapping(value = "/user/signInForm")
	public void signIn(HttpSession session) {	
		
	}
	
	@RequestMapping(value = "/signUp.do")
	public ModelAndView signUp(UserVO userVO) throws Exception {
		System.out.println(userVO);
		userService.insertUser(userVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/signInForm");
		return mav;
		
	}
	
	@RequestMapping(value = "/")
	public String home2(Model model) {

		return "user/signUpForm";
	}
	
	
	
	
	
		
	
}
