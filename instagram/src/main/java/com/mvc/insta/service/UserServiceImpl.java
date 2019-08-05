package com.mvc.insta.service;

import java.util.List;

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

	@Override
	public List<UserVO> userList() throws Exception {
		return userDao.userList();
	}

	@Override
	public UserVO viewUser(String user_email) throws Exception {
		return userDao.viewUser(user_email);
	}

	@Override
	public void delUser(UserVO userVO) throws Exception {
		userDao.delUser(userVO);
		
	}

	@Override
	public int check_email(String user_email) throws Exception {
		int check_email =  userDao.check_email(user_email);
		return check_email;
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDao.updateUser(userVO);
		
	}

}
