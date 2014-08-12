/**
 * 
 */
package kr.cloudsc.admin.repository;

import kr.cloudsc.admin.entity.CustomerUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.admin.repository
 * CustomerUserRepository.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 12.
 * @Version : 
 */
@Transactional
public interface CustomerUserRepository extends CrudRepository<CustomerUser, Integer> {

}
