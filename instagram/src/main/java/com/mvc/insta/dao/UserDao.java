package com.mvc.insta.dao;

import java.util.List;

import com.mvc.insta.vo.UserVO;

public interface UserDao {
	public void insertUser(UserVO userVO) throws Exception;

	public UserVO loginUser(UserVO userVO) throws Exception;

	public List<UserVO> userList() throws Exception;
	public UserVO viewUser(UserVO userVO) throws Exception;

	public void delUser(UserVO userVO) throws Exception;

	public int check_id(String user_id) throws Exception;

	public void updateUser(UserVO userVO) throws Exception;


	

}
