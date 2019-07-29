package com.mvc.insta.service;

import java.util.HashMap;
import java.util.List;

import com.mvc.insta.vo.UserVO;

public interface UserService {
	public void insertUser(UserVO userVO)throws Exception;
<<<<<<< HEAD

	public UserVO loginUser(UserVO userVO)throws Exception;
=======
	public List<UserVO> userList() throws Exception;
	public UserVO viewUser(String user_email) throws Exception;
>>>>>>> 9ed9b3f539f9ae8e9373f755aabc1098d035faa8
		
	

}
