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
//			errors.rejectValue("user_email", "required","�ʼ� ���� �Դϴ�.");
//		}else {
//			Matcher matcher = pattern.matcher(userVO.getUser_email());
//				if(!matcher.matches()) {
//					errors.rejectValue("user_email", "bad", "�ùٸ��� �ʴ� �����Դϴ�.");
//				}
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_email", "required", "�ʼ��Է� �����Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name", "required", "�ʼ��Է� �����Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_pw", "required", "�ʼ��Է� �����Դϴ�.");
		//�̸� ��ȿ�� üũ
//		if(userVO.getUser_name() == null || userVO.getUser_name().trim().isEmpty()) {
//			System.out.println("ȸ�� �̸� �Է�");
//			errors.rejectValue("user_name", "empty","�̸��� �Է����ּ���");
//		}
		
		if(!userVO.getUser_pw().isEmpty()) {
            if(!userVO.getUser_pw().equals(userVO.getUser_check_pw())) {
                errors.rejectValue("user_check_pw", "nomatch", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
            }
        }

	}

}
