package kr.cloudsc.admin.service.impl;

import java.util.List;

import kr.cloudsc.admin.entity.CustomerUser;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public interface ICustomerUserService {

	CustomerUser register(CustomerUser user);

	List<CustomerUser> getAllCustomerUsers();

	List<CustomerUser> updateUsers(List<CustomerUser> cUsers);

	int setGearCnt(List<CustomerUser> cUsers);

	

}
