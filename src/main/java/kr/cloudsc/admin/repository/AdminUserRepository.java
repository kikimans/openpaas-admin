/**
 * 
 */
package kr.cloudsc.admin.repository;

import kr.cloudsc.admin.entity.AdminUser;

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
 * AdminUserRepository.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 11.
 * @Version : 
 */
@Transactional
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {

	AdminUser findByEmail(String email);

	AdminUser findByEmailAndPasswd(String email, String password);

}
