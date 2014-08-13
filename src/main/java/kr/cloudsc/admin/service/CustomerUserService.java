/**
 * 
 */
package kr.cloudsc.admin.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cloudsc.admin.entity.CustomerUser;
import kr.cloudsc.admin.repository.CustomerUserRepository;
import kr.cloudsc.admin.service.impl.ICustomerUserService;
import kr.cloudsc.admin.service.impl.IOpenPaasService;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.admin.repository
 * CustomerUserService.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 12.
 * @Version : 
 */
@Service
public class CustomerUserService implements ICustomerUserService {
	
	static final Logger logger = LoggerFactory.getLogger(CustomerUserService.class);
	
	@Autowired
	private CustomerUserRepository cUserRepo;
	
	@Autowired
	private IOpenPaasService openpaasService;

	/**
	 * 
	 */
	public CustomerUserService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	@Override
	public CustomerUser register(CustomerUser user) {
		// TODO Auto-generated method stub
		CustomerUser rUser = null;
		try {
			rUser = cUserRepo.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rUser;
	}

	@Override
	public List<CustomerUser> getAllCustomerUsers() {
		// TODO Auto-generated method stub			
		return copyIterator(cUserRepo.findAll().iterator());
	}
	
	
	private static <T> List<T> copyIterator(Iterator<T> iter){
		List<T> copyList = new ArrayList<T>();		
		while(iter.hasNext()) copyList.add(iter.next());		
		return copyList;
	}

	/* (non-Javadoc)
	 * @see kr.cloudsc.admin.service.impl.ICustomerUserService#updateUsers(java.util.List)
	 *
	 * <pre>
	 * 1. 개요 : 사용자 일괄 업데이트 처리
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : updateUsers * 
	 * @date   : 2014. 8. 13.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 13.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param cUsers
	 */
	@Transactional 
	@Override
	public List<CustomerUser> updateUsers(List<CustomerUser> cUsers) {
		// TODO Auto-generated method stub
		return copyIterator(cUserRepo.save(cUsers).iterator());
	}

	/* (non-Javadoc)
	 * @see kr.cloudsc.admin.service.impl.ICustomerUserService#setGearCnt(java.util.List)
	 *
	 * <pre>
	 * 1. 개요 : 사용 GearCnt set
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : setGearCnt * 
	 * @date   : 2014. 8. 13.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 13.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param cUsers
	 */
	 
	@Override
	public int setGearCnt(List<CustomerUser> cUsers) {
		// TODO Auto-generated method stub
		List<CustomerUser> updateUsers = new ArrayList<CustomerUser>();
		for(CustomerUser cUser : cUsers){
			try {				
				if(cUser.getStatus() != '1'){
					int gearCnt = openpaasService.getConsumedGear(cUser.getEmail(), cUser.getPasswd());
					cUser.setGearCnt(gearCnt);
					updateUsers.add(cUser);
				}
			} catch (Exception e) {
				// TODO: handle exception
				logger.error(e.getMessage());
			}
		}
		List<CustomerUser> resultUser = updateUsers(updateUsers);
		return resultUser.size();
	}

}
