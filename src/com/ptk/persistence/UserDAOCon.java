package com.ptk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.UserVO;

@Repository
public class UserDAOCon implements UserDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.UserMapper";
	/**
	 * SQL 실행구문(NAMESPACE+".id" )
	 */
	@Override
	public void signup(UserVO user) {
		sqlSession.insert(NAMESPACE+".signup", user); 
	}
	
	@Override
	public UserVO login(UserVO user) {
		return sqlSession.selectOne(NAMESPACE+".loginUser", user);
	}
	
	@Override
	public UserVO userIDsearch(UserVO user) {
		return sqlSession.selectOne(NAMESPACE+".IDsearch", user);
	}
	
	@Override
	public UserVO userPasswordsearch(UserVO user) {
		System.out.println(user.toString());
		return sqlSession.selectOne(NAMESPACE+".passwordsearch", user);
	}
	
	@Override
	public void userPasswordChange(UserVO user) {
		sqlSession.update(NAMESPACE+".passwordUpdate", user);	
	}
	
	@Override
	public UserVO getUser(String userID) {
		return sqlSession.selectOne(NAMESPACE+".getUserOne", userID);
	}
	/**
	 * 유저를 list형태로 읽어와 list 형식으로 리턴함
	 * @return 유저리스트를 list 형태로 리턴
	 */
	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getUserList");
	}
	@Override
	public void setUserLevel(UserVO user) {
		sqlSession.update(NAMESPACE+".setUserLevel",user);
	}
	@Override
	public void setuserInfo(UserVO user) {
		sqlSession.update(NAMESPACE+".setUserInfo",user);
	}
	@Override
	public UserVO getuserInfo(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getuserInfo", userID);
	}
	@Override
	public List<UserVO> useridCheck(UserVO vo) {
		return sqlSession.selectList(NAMESPACE+".useridCheck");
	}
	@Override
	public boolean usercheck(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".idcheck",id);
	}

	@Override
	public int checkuserid(String user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".checkid",user_id);
	}
	
}
