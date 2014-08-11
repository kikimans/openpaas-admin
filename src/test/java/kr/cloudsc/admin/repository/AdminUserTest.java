package kr.cloudsc.admin.repository;

import static org.junit.Assert.*;
import kr.cloudsc.admin.entity.AdminUser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
"file:src/main/webapp/WEB-INF/configuration/spring/application-spring.xml",
"file:src/test/resources/configuration/context_root.xml"})
public class AdminUserTest {
	
	@Autowired
	private AdminUserRepository adminUserRepo;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_사용자_등록() {
		AdminUser adminUser = new AdminUser();
		adminUser.setName("test");
		adminUser.setCorpName("testCorp");
		adminUser.setEmail("kikimans@jyes.co.kr");
		adminUser.setPasswd("alsgh@1716");
		
		AdminUser saveUser = adminUserRepo.save(adminUser);
		
		System.out.println(saveUser.getId());
		
		
		
	}

}
