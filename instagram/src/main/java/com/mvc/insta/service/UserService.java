package com.mvc.insta.service;

import com.mvc.insta.vo.UserVO;

public interface UserService {
	public void insertUser(UserVO userVO)throws Exception;

	public UserVO loginUser(UserVO userVO)throws Exception;
		
	

}
