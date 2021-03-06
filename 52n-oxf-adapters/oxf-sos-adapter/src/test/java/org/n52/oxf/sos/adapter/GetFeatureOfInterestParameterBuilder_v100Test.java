/**
 * ﻿Copyright (C) 2012-2015 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as publishedby the Free
 * Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of the
 * following licenses, the combination of the program with the linked library is
 * not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed under
 * the aforementioned licenses, is permitted by the copyright holders if the
 * distribution is compliant with both the GNU General Public License version 2
 * and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */
package org.n52.oxf.sos.adapter;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.n52.oxf.sos.adapter.wrapper.builder.GetFeatureOfInterestParameterBuilder_v100;

/**
 * Test of correctness for:
 * 		- legal and illegal constructor parameters
 * 		- applying and getting mandatory parameters
 * 		- applying and getting optional parameters
 * 
 * @author Eric
 */
public class GetFeatureOfInterestParameterBuilder_v100Test {

	/**
	 * Checks the behaviour on valid constructor parameters.
	 */
	@Test
	public void testValidConstructorParameters() {
		new GetFeatureOfInterestParameterBuilder_v100("", ISOSRequestBuilder.GET_FOI_ID_PARAMETER);
		new GetFeatureOfInterestParameterBuilder_v100("", ISOSRequestBuilder.GET_FOI_LOCATION_PARAMETER);
	}
	
	/**
	 * Checks the behaviour on invalid constructor parameters.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidConstructorParameters() {
		new GetFeatureOfInterestParameterBuilder_v100(null, null);
		new GetFeatureOfInterestParameterBuilder_v100("", null);
		new GetFeatureOfInterestParameterBuilder_v100(null, "");
		new GetFeatureOfInterestParameterBuilder_v100("", "");
	}
	
	/**
	 * Checks, whether the mandatory parameters were applied correctly.
	 */
	@Test
	public void testApplyingAndGettingMandatoryParameters() {
		GetFeatureOfInterestParameterBuilder_v100 gfpb = new GetFeatureOfInterestParameterBuilder_v100
				("identification", ISOSRequestBuilder.GET_FOI_ID_PARAMETER);
		
		HashMap<String, String> hm = (HashMap<String, String>) gfpb.getParameters();
		String parMan_01 = hm.get(ISOSRequestBuilder.GET_FOI_ID_PARAMETER);
		
		assertEquals("identification", parMan_01);
	}
	
	/**
	 * Checks, whether the optional parameters were applied correctly.
	 */
	@Test
	public void testApplyingAndGettingOptionalParameters() {
		GetFeatureOfInterestParameterBuilder_v100 gfpb = new GetFeatureOfInterestParameterBuilder_v100
				("identification", ISOSRequestBuilder.GET_FOI_ID_PARAMETER);
		
		HashMap<String, String> hm = (HashMap<String, String>) gfpb.getParameters();
		
		assertNull(hm.get(ISOSRequestBuilder.GET_FOI_EVENT_TIME_PARAMETER));
		
		gfpb.addEventTime("eventTimeOld");
		gfpb.addEventTime("eventTime");
		
		String parOpt_01 = hm.get(ISOSRequestBuilder.GET_FOI_EVENT_TIME_PARAMETER);
		
		assertEquals("eventTime", parOpt_01);
	}

}
