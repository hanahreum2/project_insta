package com.mvc.insta.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		model.addAttribute("userVO", new UserVO());
		return "user/signUpForm";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		model.addAttribute("userVO", new UserVO());
		return "main/main";
	}
	
	@RequestMapping(value = "/user/signInForm")
	public void signIn(HttpSession session) {	
		
	}

	@RequestMapping(value = "/signIn.do", method = RequestMethod.POST)
	public ModelAndView signIn(UserVO userVO, HttpSession session) throws Exception {
		System.out.println(userVO);
		ModelAndView mav = new ModelAndView();
		System.out.println(userService.loginUser(userVO));
		if(userService.loginUser(userVO) != null) {
			System.out.println("占싸깍옙占싸쇽옙占쏙옙");
			mav.setViewName("/main/main");
			session.setAttribute("user", userService.loginUser(userVO));
			session.setMaxInactiveInterval(30*60); //占싣뱄옙占싶듸옙 占쏙옙占싹곤옙 30占싻듸옙占싫몌옙 占싸깍옙占쏙옙 占쏙옙占쏙옙
		}
		else {
			System.out.println("占싸깍옙占쏙옙 占쏙옙占쏙옙");
			mav.setViewName("/user/signInForm");
			mav.addObject("resultMav","fail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/signOut.do", method = RequestMethod.GET)
	public String signOut(UserVO userVO, HttpSession session) throws Exception {
		System.out.println(userVO);
		System.out.println("濡쒓렇�븘�썐");
		session.invalidate(); 
		
		return "user/signInForm";
	}
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String MemberInit(@ModelAttribute UserVO userVO, Errors errors, Model model) throws Exception {
    	new UserValidator().validate(userVO, errors);
        System.out.println("signup.do");
    	
        if(errors.hasErrors()){ 
        	System.out.println("에러있따");
            return "user/signUpForm";  
        }else {
        	
        	userService.insertUser(userVO);
        	return "user/signInForm";
        }

    }
	
	
	//회占쏙옙 占쏙옙체 占쏙옙占쏙옙트
	@RequestMapping(value="/listUser.do")
	public String userList(Model model) throws Exception {
		List<UserVO> list = userService.userList();
		model.addAttribute("list", list);
		return "user/listUser";
	}
	
	
	@RequestMapping(value="/viewUser.do")
	public String userView(UserVO userVO, Model model) throws Exception {
		
		model.addAttribute("user", userService.viewUser(userVO));
		
		return "user/viewUser";
	}

	//회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	@RequestMapping("/delUser.do")
	public String delUser(UserVO userVO, HttpSession session) throws Exception {
		userService.delUser(userVO);
		session.invalidate();
		
		return "redirect:/listUser.do";
	}
	
	
	// email 占쌩븝옙 체크
	@RequestMapping(value = "/check_id.do", method = RequestMethod.POST)
	@ResponseBody
	public int check_email(@RequestBody String input_id) throws Exception {
		int check_id = userService.check_id(input_id);
		return check_id;
	}
	
	
		
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
	public String update(@ModelAttribute UserVO userVO, HttpSession session) throws Exception {
		userService.updateUser(userVO);
		session.setAttribute("user", userVO);
		return "redirect:/listUser.do";
		
	}
		
		


	
}
