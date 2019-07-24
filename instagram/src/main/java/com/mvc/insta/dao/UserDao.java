package com.mvc.insta.dao;

import com.mvc.insta.vo.UserVO;

public interface UserDao {
	public void insertUser(UserVO userVO) throws Exception;

	public UserVO loginUser(UserVO userVO) throws Exception;

}
