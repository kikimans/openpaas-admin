package kr.cloudsc.admin.openshift;

import kr.cloudsc.admin.openshift.openpaas.OpenPaasConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.IUser;
import com.openshift.client.OpenShiftConnectionFactory;
import com.openshift.client.OpenShiftException;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */

public class OpenPaasConnection implements IOpenPaasConnection {
	
	static final Logger logger = LoggerFactory.getLogger(OpenPaasConnection.class);	
	
	private IOpenShiftConnection openshiftConn;
	private String userName;
	private String password;

	
	public OpenPaasConnection(IOpenShiftConnection openshiftConn){
		this.openshiftConn = openshiftConn;
	}
	
	public OpenPaasConnection(String userName, String password) {		
		if(userName ==null || password == null ){
			throw new NullPointerException("userName or password was null");
		}
		this.userName = userName;
		this.password = password;
		openshiftConn = new OpenPaasConnectionFactory().getConnection("openpaasAdmin", userName, password);
		
		
	}


	@Override
	public int getConsumedGear() throws OpenShiftException{
		// TODO Auto-generated method stub
		int gearCunsume = 0;
		if(openshiftConn == null){
			logger.error("IOpenShiftConnection was null");
			throw new NullPointerException("IOpenShiftConnection was null");
		}
		try {
			IUser iUser = openshiftConn.getUser();
			if(iUser != null){
				gearCunsume = iUser.getConsumedGears();
			}
		} catch (OpenShiftException e) {
			// TODO: handle exception
			logger.error(e.getMessage() + " : UserName - " + userName + " password : " + password);
			throw e;
		}
		
		return gearCunsume;
	}

}
