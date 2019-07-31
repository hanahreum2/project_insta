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
	
	@RequestMapping(value = "/user/signInForm")
	public void signIn(HttpSession session) {	
		
	}

	@RequestMapping(value = "/signIn.do", method = RequestMethod.POST)
	public ModelAndView signIn(UserVO userVO, HttpSession session) throws Exception {
		System.out.println(userVO);
		ModelAndView mav = new ModelAndView();
		System.out.println(userService.loginUser(userVO));
		if(userService.loginUser(userVO) != null) {
			System.out.println("�α��μ���");
			mav.setViewName("/main/main");
			session.setAttribute("login", userService.loginUser(userVO));
			session.setMaxInactiveInterval(30*60); //�ƹ��͵� ���ϰ� 30�е��ȸ� �α��� ����
		}
		else {
			System.out.println("�α��� ����");
			mav.setViewName("/user/signInForm");
			mav.addObject("resultMav","fail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/signOut.do", method = RequestMethod.GET)
	public String signOut(UserVO userVO, HttpSession session) throws Exception {
		System.out.println(userVO);
		System.out.println("로그아웃");
		session.invalidate(); // 제거
		
		return "user/signInForm";
	}
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String MemberInit(@ModelAttribute UserVO userVO, Errors errors, Model model) throws Exception {
    	new UserValidator().validate(userVO, errors);
        //validator ���� ������ ���������� �̵�
        if(errors.hasErrors()){ 
            return "user/signUpForm";  
        }

        userService.insertUser(userVO);
		return "user/signInForm";
    }
	
	
	//ȸ�� ��ü ����Ʈ
	@RequestMapping(value="/listUser.do")
	public String userList(Model model) throws Exception {
		List<UserVO> list = userService.userList();
		model.addAttribute("list", list);
		return "user/listUser";
	}
	
	//ȸ�� ������
	@RequestMapping("/viewUser.do")
	public String userView(String user_email, Model model) throws Exception {
		model.addAttribute("vo", userService.viewUser(user_email));
		logger.info("Ŭ���� �̸��� : " + user_email);
		
		return "user/viewUser";
	}

	//ȸ������ ����
	@RequestMapping("/delUser.do")
	public String delUser(UserVO userVO, HttpSession session) throws Exception {
		userService.delUser(userVO);
		session.invalidate();
		
		return "redirect:/listUser.do";
	}
	
	

	// email �ߺ� üũ
		@RequestMapping(value = "/check_email.do", method = RequestMethod.POST)
		@ResponseBody
		public int check_email(@RequestBody String input_email, UserVO userVO) throws Exception {
			int check_email = userService.check_email(input_email);

			return check_email;
		}
	// email �ߺ� üũ
	@RequestMapping(value = "/check_email.do", method = RequestMethod.POST)
	@ResponseBody
	public int check_email(@RequestBody String input_email) throws Exception {
		int check_email = userService.check_email(input_email);
		return check_email;
	}

	
	
	

	
	
	
		
	
}
