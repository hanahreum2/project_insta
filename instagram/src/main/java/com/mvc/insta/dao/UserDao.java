package com.mvc.insta.dao;

import java.util.List;

import com.mvc.insta.vo.UserVO;

public interface UserDao {
	public void insertUser(UserVO userVO) throws Exception;
<<<<<<< HEAD

	public UserVO loginUser(UserVO userVO) throws Exception;

=======
	public List<UserVO> userList() throws Exception;
	public UserVO viewUser(String user_email) throws Exception;
	
>>>>>>> 9ed9b3f539f9ae8e9373f755aabc1098d035faa8
}
