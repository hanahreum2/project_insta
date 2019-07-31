package com.mvc.insta.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvc.insta.vo.UserVO;

public class UserValidator implements Validator{
	
//	private static final String emailRegExp =
//	            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
//	            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//	
//	private Pattern pattern;
//	 
//	public UserValidator() {
//		pattern = Pattern.compile(emailRegExp);
//	}


	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UserVO userVO = (UserVO) obj;
		
//		if(userVO.getUser_email() == null || userVO.getUser_email().trim().isEmpty()) {
//			errors.rejectValue("user_email", "required","필수 정보 입니다.");
//		}else {
//			Matcher matcher = pattern.matcher(userVO.getUser_email());
//				if(!matcher.matches()) {
//					errors.rejectValue("user_email", "bad", "올바르지 않는 형식입니다.");
//				}
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_email", "required", "필수입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name", "required", "필수입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_pw", "required", "필수입력 사항입니다.");
		//이름 유효성 체크
//		if(userVO.getUser_name() == null || userVO.getUser_name().trim().isEmpty()) {
//			System.out.println("회원 이름 입력");
//			errors.rejectValue("user_name", "empty","이름을 입력해주세요");
//		}
		
		if(!userVO.getUser_pw().isEmpty()) {
            if(!userVO.getUser_pw().equals(userVO.getUser_check_pw())) {
                errors.rejectValue("user_check_pw", "nomatch", "비밀번호가 일치하지 않습니다.");
            }
        }

	}

}
