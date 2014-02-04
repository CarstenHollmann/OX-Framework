/**
 * ﻿Copyright (C) 2012-2014 52°North Initiative for Geospatial Open Source
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

/**
 * The OXFEventException will be thrown, if an error occures during event-handling-process.
 * 
 * @author <a href="mailto:broering@52north.org">Arne Broering</a>
 *
 */
public class OXFEventException extends Exception {

    /**
     * Constructs a new OXFEventException.
     */
    public OXFEventException() {
        super();
    }
    
    /**
     * Constructs a new OXFEventException with the specified reason.
     * 
     * @param reason
     *        the reason of the exception.
     */
    public OXFEventException(String reason) {
        super(reason);
    }

    /**
     * Constructs a new OXFEventException with the specified cause.
     * 
     * @param cause
     *        the cause which is saved for later retrieval by the Throwable.getCause() method. A null value is
     *        permitted, and indicates that the cause is nonexistent or unknown.
     */
    public OXFEventException(Throwable cause) {
        super.initCause(cause);
    }

    /**
     * Constructs a new OXFEventException with the specified reason and cause.
     * 
     * @param reason
     *        the reason of the exception.
     * 
     * @param cause
     *        the cause which is saved for later retrieval by the Throwable.getCause() method. A null value is
     *        permitted, and indicates that the cause is nonexistent or unknown.
     */
    public OXFEventException(String reason, Throwable cause) {
        super(reason);
        super.initCause(cause);
    }

}