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
	
	//ȸ������
//	@RequestMapping(value = "/signUp.do")
//	public ModelAndView signUp(UserVO userVO) throws Exception {
//		System.out.println(userVO);
//		userService.insertUser(userVO);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/user/signInForm");
//		return mav;
//		
//	}

	
	//ȸ������
	@RequestMapping(value = "/signUp.do")
	public String MemberInit(@ModelAttribute UserVO userVO, Errors errors, Model model) throws Exception {
    	new UserValidator().validate(userVO, errors);
        
    	//validator ���� ������ ���������� �̵�
        if(errors.hasErrors()){ 
            return "user/signUpForm";  
        }

        
        userService.insertUser(userVO);
		return "user/signUpOk";
	    
    }
	
	
	//ȸ�� ��ü ����Ʈ
//	@RequestMapping(value="/")
	public String userList(Model model) throws Exception {
		List<UserVO> list = userService.userList();
		model.addAttribute("list", list);
		return "user/signUpOk";
	}
	
	//ȸ�� ������
	@RequestMapping("/viewUser.do")
	public String userView(String user_email, Model model) throws Exception {
		model.addAttribute("vo", userService.viewUser(user_email));
		logger.info("Ŭ���� �̸��� : " + user_email);
		
		return "user/viewUser";
	}

	
	
	
	

	
	
	
	
		
	
}
