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
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "/user/signInForm")
	public void signIn(HttpSession session) {	
		
	}
	
	//회원가입
//	@RequestMapping(value = "/signUp.do")
//	public ModelAndView signUp(UserVO userVO) throws Exception {
//		System.out.println(userVO);
//		userService.insertUser(userVO);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/user/signInForm");
//		return mav;
//		
//	}

	
	//회원가입
	@RequestMapping(value = "/signUp.do")
	public String MemberInit(@ModelAttribute UserVO userVO, Errors errors, Model model) throws Exception {
    	new UserValidator().validate(userVO, errors);
        
    	//validator 에러 있으면 이페이지로 이동
        if(errors.hasErrors()){ 
            return "user/signUpForm";  
        }

        
        userService.insertUser(userVO);
		return "user/signUpOk";
	    
    }
	
	
	//회원 전체 리스트
//	@RequestMapping(value="/")
	public String userList(Model model) throws Exception {
		List<UserVO> list = userService.userList();
		model.addAttribute("list", list);
		return "user/signUpOk";
	}
	
	//회원 상세정보
	@RequestMapping("/viewUser.do")
	public String userView(String user_email, Model model) throws Exception {
		model.addAttribute("vo", userService.viewUser(user_email));
		logger.info("클릭한 이메일 : " + user_email);
		
		return "user/viewUser";
	}

	
	
	
	

	
	
	
	
		
	
}
