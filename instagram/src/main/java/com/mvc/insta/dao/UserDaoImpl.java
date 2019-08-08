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
	public UserVO viewUser(UserVO userVO) throws Exception {
		return sqlSession.selectOne(namespace+".viewUser", userVO);
	}

	@Override
	public void delUser(UserVO userVO) throws Exception {
		sqlSession.delete(namespace+".delUser", userVO); 
		
	}

	@Override
	public int check_id(String user_id) throws Exception {
		int check_id = sqlSession.selectOne(namespace+".check_id", user_id);
		return check_id;
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		sqlSession.update(namespace + ".updateUser", userVO); 
		
	}

}
