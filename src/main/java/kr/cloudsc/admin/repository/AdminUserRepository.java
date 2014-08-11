/**
 * 
 */
package kr.cloudsc.admin.repository;

import kr.cloudsc.admin.entity.AdminUser;

import org.springframework.data.repository.CrudRepository;

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
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {

}
