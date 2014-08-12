package kr.cloudsc.admin.service.impl;

import kr.cloudsc.admin.entity.AdminUser;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public interface IAdminUserSerivce {

	AdminUser findByEmail(String email);

	AdminUser login(String email, String password);

	AdminUser registerUser(AdminUser adminUser);

}
