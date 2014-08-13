package kr.cloudsc.admin.openshift;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class OpenShiftConnectionTest {

	static final Logger logger = LoggerFactory.getLogger(OpenShiftConnectionTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_OpenShiftConn_gearCnt() {
		String userName = "kikimans@jyes.co.kr1111";
		String password = "alsgh@1716";
		IOpenPaasConnection conn = new OpenPaasConnection(userName,password);
		
		int gear_cnt = conn.getConsumedGear();
		assertThat(gear_cnt, is(1));
		//logger.info("사용 기어 숫자 : " + gear_cnt);		
		
	}
	
}
