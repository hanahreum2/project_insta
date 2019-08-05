package com.mvc.insta.dao;

import java.util.List;

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

	@Override
	public List<UserVO> userList() throws Exception {
		return sqlSession.selectList(namespace+ ".userList");
	}

	@Override
	public UserVO viewUser(String user_email) throws Exception {
		return sqlSession.selectOne(namespace+".viewUser", user_email);
	}

	@Override
	public void delUser(UserVO userVO) throws Exception {
		sqlSession.delete(namespace+".delUser", userVO); 
		
	}

	@Override
	public int check_email(String user_email) throws Exception {
		int check_email = sqlSession.selectOne(namespace+".check_email", user_email);
		return check_email;
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		sqlSession.update(namespace + ".updateUser", userVO); 
		
	}

}
