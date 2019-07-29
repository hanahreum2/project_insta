package com.mvc.insta.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//@RequestMapping(value = "/")
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
	public ModelAndView signUp(UserVO userVO) throws Exception {
		System.out.println(userVO);
		userService.insertUser(userVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/signInForm");
		return mav;
	}
	
	@RequestMapping(value = "/signIn.do", method = RequestMethod.POST)
	public ModelAndView signIn(UserVO userVO,HttpSession session) throws Exception {
		System.out.println(userVO);
		ModelAndView mav = new ModelAndView();
		System.out.println(userService.loginUser(userVO));
		if(userService.loginUser(userVO) != null) {
			System.out.println("�α��μ���");
			mav.setViewName("/user/timeLine");
			session.setAttribute("login", userService.loginUser(userVO));
			session.setMaxInactiveInterval(30*60); //�ƹ��͵� ���ϰ� 30�е��ȸ� �α��� ����
			//session.invalidate(); --> �α׾ƿ�(���ǻ���)
		}
		else {
			System.out.println("�α��� ����");
			mav.setViewName("/user/signInForm");
			mav.addObject("resultMav","fail");
		}
		return mav;
	}
	public String MemberInit(@ModelAttribute UserVO userVO, BindingResult bindingResult, Model model) throws Exception {
    	new UserValidator().validate(userVO, bindingResult);
        
    	//validator ���� ������ ���������� �̵�
        if(bindingResult.hasErrors()){ 
            return "user/signUpForm";  
        }
        
        userService.insertUser(userVO);
		return "user/signUpOk";
	    
    }
	
	
	//ȸ�� ��ü ����Ʈ
	@RequestMapping(value="/")
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
