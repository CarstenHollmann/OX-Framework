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
package org.n52.ows.exception;

import java.util.ArrayList;
import java.util.List;

public abstract class OwsException extends Exception {
    
    private static final long serialVersionUID = 3899044347528650839L;
    
    public static final int BAD_REQUEST = 400;
    public static final int FORBIDDEN = 403;
    public static final int GONE = 410;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;

    private List<String> exceptionTexts = new ArrayList<String>();
    private String exceptionCode;
    private String locator;

    public OwsException(String exceptionCode) {
        this(exceptionCode, null);
    }

    public OwsException(String exceptionCode, String locator) {
        this.exceptionCode = exceptionCode;
        this.locator = locator;
    }

    public void addExceptionText(String exceptionText) {
        this.exceptionTexts.add(exceptionText);
    }

    public String getExceptionCode() {
        return this.exceptionCode;
    }

    public String[] getExceptionTextsAsArray() {
        return exceptionTexts.toArray(new String[exceptionTexts.size()]);
    }

    public List<String> getExceptionTexts() {
        return this.exceptionTexts;
    }

    public String getLocator() {
        return this.locator;
    }
    
    public boolean isSetLocator() {
        return locator != null;
    }

    public abstract int getHttpStatusCode();

}
