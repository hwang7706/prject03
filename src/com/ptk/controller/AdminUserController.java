package com.ptk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptk.domain.UserVO;
import com.ptk.persistence.UserDAO;

@Controller //컨트롤러로 지정
@RequestMapping("/admin/user") //경로지정
public class AdminUserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//콘솔 출력
	
	@Inject
	private UserDAO dao;
	//UserDAO 주입
	
	/**
	 * value="jsp이름" method = RequestMehod.요청값(GET,POST)"
	 * @param request
	 */
	@RequestMapping(value="userTool", method = RequestMethod.GET)
	public void userTool(HttpServletRequest request){ //HttpServletRequest=값을 가져오는 것
		logger.info("유저관리 페이지");
		request.setAttribute("userList",dao.getUserList()); // userDAO에서 불러온 유저리스트를 userList라는 아이템으로 담아서 userTool로 보내줌 
	}
	@RequestMapping(value="/userTool", method = RequestMethod.POST)
	public String userToolPOST(UserVO user) {
		logger.info("레벨변경");
		logger.info(user.toString()); //toString=불러오는 값들을 String형태로 다 가져오는것
		dao.setUserLevel(user); 
		return"redirect:/admin/user/userTool";
	}
}
