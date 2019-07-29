package com.mvc.insta.dao;

import java.util.List;

import com.mvc.insta.vo.UserVO;

public interface UserDao {
	public void insertUser(UserVO userVO) throws Exception;
	public List<UserVO> userList() throws Exception;
	public UserVO viewUser(String user_email) throws Exception;
	
}
