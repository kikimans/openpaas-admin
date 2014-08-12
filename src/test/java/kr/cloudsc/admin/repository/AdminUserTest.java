package kr.cloudsc.admin.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import kr.cloudsc.admin.cipher.IAESCipher;
import kr.cloudsc.admin.cipher.MockAESCipher;
import kr.cloudsc.admin.entity.AdminUser;
import kr.cloudsc.admin.service.impl.IAdminUserSerivce;

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
	private IAdminUserSerivce adminUserService;
	
	@Autowired
	private AdminUserRepository adminUserRepo;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_사용자_등록_체크() {
		AdminUser adminUser = new AdminUser();
		adminUser.setName("test");
		adminUser.setCorpName("testCorp");
		adminUser.setEmail("kikimans@jyes.co.kr");
		adminUser.setPasswd("alsgh@1716");
		
		AdminUser saveUser = adminUserRepo.save(adminUser);
		
		AdminUser selUser = adminUserService.findByEmail(adminUser.getEmail());
		
		assertThat(saveUser.getEmail(), is(selUser.getEmail()));	
		
	}
	
	@Test
	public void test_사용자_등록_로그인(){
		String email = "kikimans@jyes.co.kr";
		String password = "alsgh@1716";
		
		//사용자 등록
		AdminUser adminUser = new AdminUser();
		adminUser.setName("test");
		adminUser.setCorpName("testCorp");
		adminUser.setEmail("kikimans@jyes.co.kr");
		adminUser.setPasswd("alsgh@1716");
		
		AdminUser registerUser = adminUserService.registerUser(adminUser);
		
		AdminUser loginUser = adminUserService.login(email,password);
		
		assertThat(loginUser.getEmail(), is(email));
		assertThat(loginUser.getPasswd(), is(password));
	}
	
	@Test
	public void test_사용자_등록_비밀번호_암호화() throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String password = "alsgh@1716";
		String email = "kikimans@jyes.co.kr";
		IAESCipher cipher = new MockAESCipher();
		
		String eccryptPasswd = cipher.encrypt(password, cipher.getDecodedSecretKey(null) );
		
		AdminUser adminUser = new AdminUser();
		adminUser.setName("test");
		adminUser.setCorpName("testCorp");
		adminUser.setEmail("kikimans@jyes.co.kr");
		adminUser.setPasswd(eccryptPasswd);
		
		AdminUser registerUser = adminUserService.registerUser(adminUser);	
		
		assertThat(password, is(cipher.decrypt(registerUser.getPasswd(),cipher.getDecodedSecretKey(null))));
		
	}
	
	@Test
	public void test_사용자_등록_암호화_로그인() throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String password = "alsgh@1716";
		String email = "kikimans@jyes.co.kr";
		IAESCipher cipher = new MockAESCipher();
		
		String eccryptPasswd = cipher.encrypt(password, cipher.getDecodedSecretKey(null) );
		
		AdminUser adminUser = new AdminUser();
		adminUser.setName("test");
		adminUser.setCorpName("testCorp");
		adminUser.setEmail("kikimans@jyes.co.kr");
		adminUser.setPasswd(eccryptPasswd);
		
		AdminUser registerUser = adminUserService.registerUser(adminUser);			
		AdminUser loginUser = adminUserService.login(email,eccryptPasswd);		
		assertThat(loginUser.getEmail(), is(email));		
	}
	
	

}
