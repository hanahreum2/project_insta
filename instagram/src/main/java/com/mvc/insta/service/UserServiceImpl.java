package com.mvc.insta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.insta.dao.UserDao;
import com.mvc.insta.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userDao.insertUser(userVO);
	}

	@Override
	public UserVO loginUser(UserVO userVO) throws Exception {
		return userDao.loginUser(userVO);
	}

}
