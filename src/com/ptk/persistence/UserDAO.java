package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.UserVO;

public interface UserDAO {
	
	public void signup(UserVO user);
	public UserVO login(UserVO user);
	public UserVO userIDsearch(UserVO user);
	public UserVO userPasswordsearch(UserVO user);
	public void userPasswordChange(UserVO user);
	public UserVO getUser(String userID);
	/**
	 * 	user 오브젝트를 list 형태로 가지고 옵니다
	 * @return Userlist <UserVO>
	 */
	public List<UserVO> getUserList();
	/**
	 *  지정한 값으로 UserVO에있는 userLevel을 세팅해줍니다
	 * 
	 */
	public void setUserLevel(UserVO user);
	public UserVO getuserInfo(String userID);
	public void setuserInfo(UserVO user);
	public List<UserVO> useridCheck(UserVO user);
	public boolean usercheck(String id); 
	public int checkuserid(String user_id);
}
