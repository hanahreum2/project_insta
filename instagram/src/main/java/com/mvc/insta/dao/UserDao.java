package com.mvc.insta.dao;

import java.util.List;

import com.mvc.insta.vo.UserVO;

public interface UserDao {
	public void insertUser(UserVO userVO) throws Exception;
<<<<<<< HEAD

	public UserVO loginUser(UserVO userVO) throws Exception;

	public List<UserVO> userList() throws Exception;
	public UserVO viewUser(String user_email) throws Exception;
	
=======


	public UserVO loginUser(UserVO userVO) throws Exception;


	public List<UserVO> userList() throws Exception;
	public UserVO viewUser(String user_email) throws Exception;
	

>>>>>>> bcc46bb4c996083c5bf8f663f777138e3226fa13
}
