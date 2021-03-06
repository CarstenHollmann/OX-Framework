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
package org.n52.oxf.util;

import java.util.Collection;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlObject;
import org.n52.oxf.swes.exception.InvalidRequestException;
import org.n52.oxf.xmlbeans.parser.XMLBeansParser;

public class SwesXmlHelper {

    /**
     * @param request the request to validate
     * @throws InvalidRequestException if request is invalid. Contains validation errors as locator.
     */
    public static void validateSwesRequest(XmlObject request) throws InvalidRequestException {
        Collection<XmlError> validationErrors = XMLBeansParser.validate(request);
        if (!validationErrors.isEmpty()) {
            String locator = createValidationMessageLocator(validationErrors);
            throw new InvalidRequestException(locator);
        }
    }

    private static String createValidationMessageLocator(Collection<XmlError> validationErrors) {
        StringBuilder errorBuilder = new StringBuilder();
        for (XmlError xmlError : validationErrors) {
            errorBuilder.append(xmlError.getMessage()).append(";");
        }
        errorBuilder.deleteCharAt(errorBuilder.length() - 1);
        return errorBuilder.toString();
    }
}
