/**
 * 
 */
package kr.cloudsc.admin.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cloudsc.admin.entity.CustomerUser;
import kr.cloudsc.admin.repository.CustomerUserRepository;
import kr.cloudsc.admin.service.impl.ICustomerUserService;

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
	
	@Autowired
	private CustomerUserRepository cUserRepo;

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
	
	@SuppressWarnings("unused")
	private static <T> List<T> copyIterator(Iterator<T> iter){
		List<T> copyList = new ArrayList<T>();		
		while(iter.hasNext()) copyList.add(iter.next());		
		return copyList;
	}

}
