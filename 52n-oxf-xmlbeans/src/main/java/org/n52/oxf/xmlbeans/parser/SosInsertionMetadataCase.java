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
package org.n52.oxf.xmlbeans.parser;

import java.util.Collection;
import java.util.List;

import javax.xml.namespace.QName;

import net.opengis.sos.x20.SosInsertionMetadataType;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlValidationError;
import org.n52.oxf.xml.XMLConstants;

/**
 * @author <a href="mailto:e.h.juerrens@52north.org">Eike Hinderk J&uuml;rrens</a>
 * TODO not working atm because InsertionMetadata is not found, too. Two errors, that should be fixed by this case!
 */
public class SosInsertionMetadataCase extends AbstractLaxValidationCase {

	private static SosInsertionMetadataCase instance;

	@Override
	public boolean shouldPass(final XmlValidationError xve)
	{
		final QName offending = xve.getOffendingQName();
		final List<?> expected = xve.getExpectedQNames();
		final QName field = xve.getFieldQName();
		if (offending != null && 
				offending.equals(XMLConstants.QN_SOS_2_0_SOS_INSERTION_METADATA) &&
				field.equals(XMLConstants.QN_SWES_2_0_METADATA) &&
				expected.contains(XMLConstants.QN_SWES_2_0_INSERTION_METADATA))
		{
			return validateSubstitutionGroup(xve);
		}
		return false;
	}

	private boolean validateSubstitutionGroup(final XmlValidationError xve)
	{
		try {
			final SosInsertionMetadataType sosInsertionMetadataType = SosInsertionMetadataType.Factory.parse(xve.getObjectLocation().xmlText());
			final Collection<XmlError> revalidation = XMLBeansParser.validate(sosInsertionMetadataType);
			return revalidation.size()==0?true:false;
		} catch (final XmlException e) {}
		return false;
	}

	public static SosInsertionMetadataCase getInstance()
	{
		if (instance == null) {
			instance = new SosInsertionMetadataCase();
		}
		return instance;
	}

	private SosInsertionMetadataCase() {}

}
