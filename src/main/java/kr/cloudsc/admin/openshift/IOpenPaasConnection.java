package kr.cloudsc.admin.openshift;

import com.openshift.client.OpenShiftException;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public interface IOpenPaasConnection {

	int getConsumedGear() throws OpenShiftException;

}
