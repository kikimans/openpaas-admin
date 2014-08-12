package kr.cloudsc.admin.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.cloudsc.admin.entity.CustomerUser;
import kr.cloudsc.admin.service.CustomerUserService;
import kr.cloudsc.admin.service.impl.ICustomerUserService;

import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.isolateAggregation;
import org.slf4j.LoggerFactory;
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
public class CustomerUserTest {

	@Autowired
	private ICustomerUserService cUserSerice;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test_사용자_등록() {		
		
		CustomerUser user = new CustomerUser();
		user.setPublicNm("조민호");
		user.setChargeNm("제이예스");
		user.setEmail("kikimans@jyes.co.kr");
		user.setPasswd("alsgh@1716");
		user.setStatus('1');
		user.setGearKind("S");
		user.setUsertype("01");
		
		CustomerUser rUser = cUserSerice.register(user);
		
		assertThat(rUser.getPublicNm(), is("조민호"));		
	}
	
	@Test
	public void test_사용자리스트(){
		CustomerUser user = new CustomerUser();
		user.setPublicNm("조민호");
		user.setChargeNm("제이예스");
		user.setEmail("kikimans@jyes.co.kr1");
		user.setPasswd("alsgh@1716");
		user.setStatus('1');
		user.setGearKind("S");
		user.setUsertype("01");
		
		cUserSerice.register(user);
		
		CustomerUser user1 = new CustomerUser();
		user1.setPublicNm("조민호");
		user1.setChargeNm("제이예스");
		user1.setEmail("kikimans@jyes.co.kr2");
		user1.setPasswd("alsgh@1716");
		user1.setStatus('1');
		user1.setGearKind("S");
		user1.setUsertype("01");
		
		cUserSerice.register(user1);
		
		List<CustomerUser> cUsers = cUserSerice.getAllCustomerUsers();
		
		for(CustomerUser cUser : cUsers){
			System.out.println("사용자 Email : " + cUser.getEmail());
		}
		
		assertThat(cUsers.isEmpty(), is(false));
	}

}
