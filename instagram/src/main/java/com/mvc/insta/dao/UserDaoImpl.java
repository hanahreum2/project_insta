package com.mvc.insta.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.insta.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "user";

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		sqlSession.insert(namespace+".insertUser", userVO);
		System.out.println("insert");
	}

	@Override
	public UserVO loginUser(UserVO userVO) throws Exception {
		return sqlSession.selectOne(namespace+".loginUser", userVO);
	}

}
