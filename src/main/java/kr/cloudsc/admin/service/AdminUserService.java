/**
 * 
 */
package kr.cloudsc.admin.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cloudsc.admin.entity.AdminUser;
import kr.cloudsc.admin.repository.AdminUserRepository;
import kr.cloudsc.admin.service.impl.IAdminUserSerivce;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.admin.service
 * AdminUserService.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 12.
 * @Version : 
 */
@Service
public class AdminUserService implements IAdminUserSerivce {

	static final Logger logger = LoggerFactory.getLogger(AdminUserService.class);
	
	@Autowired
	private AdminUserRepository adminUserRepo;
	/**
	 * 
	 */
	public AdminUserService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see kr.cloudsc.admin.service.impl.IAdminUserSerivce#findByEmail(java.lang.String)
	 *
	 * <pre>
	 * 1. 개요 : 사용자가져오기
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : findByEmail * 
	 * @date   : 2014. 8. 12.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 12.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param email
	 * @return
	 */

	@Override
	public AdminUser findByEmail(String email) {
		// TODO Auto-generated method stub
		if(email == null){
			throw new NullPointerException(this.getClass().getName() + ": findByEmail() is parameter email was null");
		}
		return adminUserRepo.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see kr.cloudsc.admin.service.impl.IAdminUserSerivce#login(java.lang.String, java.lang.String)
	 *
	 * <pre>
	 * 1. 개요 : adminUser 사용자 로그인
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : login * 
	 * @date   : 2014. 8. 12.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 12.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	 
	@Override
	public AdminUser login(String email, String password) {
		// TODO Auto-generated method stub
		return adminUserRepo.findByEmailAndPasswd(email, password);
	}

	/* (non-Javadoc)
	 * @see kr.cloudsc.admin.service.impl.IAdminUserSerivce#registerUser(kr.cloudsc.admin.entity.AdminUser)
	 *
	 * <pre>
	 * 1. 개요 : Admin 사용자 등록
	 * 2. 처리내용 : 등록시간과 변경시간을 추가하여 등록한다.
	 * </pre>
	 *
	 * @Method : registerUser * 
	 * @date   : 2014. 8. 12.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 12.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param adminUser
	 * @return
	 */
	 
	@Override
	public AdminUser registerUser(AdminUser adminUser) {
		if(adminUser == null){
			throw new NullPointerException(this.getClass().getName() + ": registerUser() is parameter adminUser Object was null");
		}		
		return adminUserRepo.save(adminUser);
	}

}
