/**
 * 
 */
package kr.cloudsc.admin.service;

import org.springframework.stereotype.Service;

import kr.cloudsc.admin.openshift.IOpenPaasConnection;
import kr.cloudsc.admin.openshift.OpenPaasConnection;
import kr.cloudsc.admin.service.impl.IOpenPaasService;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.admin.service
 * OpenPaasService.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 13.
 * @Version : 
 */
@Service
public class OpenPaasService implements IOpenPaasService {
	
	private IOpenPaasConnection conn;

	/**
	 * 
	 */
	public OpenPaasService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see kr.cloudsc.admin.service.impl.IOpenPaasService#getConsumedGear(java.lang.String, java.lang.String)
	 *
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : getConsumedGear * 
	 * @date   : 2014. 8. 13.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 13.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param email
	 * @param passwd
	 * @return
	 */

	@Override
	public int getConsumedGear(String userName, String passwd) {
		// TODO Auto-generated method stub
		
		if(conn == null){
			getConnection(userName, passwd);
		}		
		return conn.getConsumedGear();
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : getConnection
	 * @Return : void
	 * @date   : 2014. 8. 13.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 8. 13.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param email
	 * @param passwd
	 */
	private void getConnection(String userName, String passwd) {
		// TODO Auto-generated method stub
		conn = new OpenPaasConnection(userName,passwd);
	}

}
