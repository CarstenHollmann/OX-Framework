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
package org.n52.oxf.ows;

import java.io.*;
import java.util.*;

/**
 * Encapsulates Exceptions which occur on service side processing.
 * 
 * @author <a href="mailto:foerster@52north.org">Theodor Foerster</a>
 */
public class ExceptionReport extends Exception {

    private String version;

    private String language;

    private ArrayList<OWSException> exceptions;

    public ExceptionReport(String version, String language) {
        this.version = version;
        this.language = language;

        exceptions = new ArrayList<OWSException>();
    }

    /**
     * @return Returns the exceptions.
     */
    public Iterator<OWSException> getExceptionsIterator() {
        return exceptions.iterator();
    }

    /**
     * @param exceptions
     *        The exceptions to set.
     */
    public void addException(OWSException exception) {
        this.exceptions.add(exception);
    }

    /**
     * prints all contained Exceptions to the System.err stream.
     */
    @Override
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /**
     * 
     */
    @Override
    public void printStackTrace(PrintStream s) {
        s.println("- OGC Web Service returned exception:");

        super.printStackTrace(s);

        for (OWSException e : exceptions) {
            e.printStackTrace(s);
        }
    }

    /**
     * @return a HTML representation of this OWSException
     */
    public String toHtmlString() {
        String res = "<b>OGC Web Service returned exception:</b><br>";

        for (OWSException e : exceptions) {
            res += e.toHtmlString();
        }
        
        return res;
    }
    
    /**
     * 
     * @return the number of exceptions contained in this ExceptionReport.
     */
    public int countExceptions() {
        return exceptions.size();
    }

    /**
     * @return Returns the language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     *        The language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return Returns the version.
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     *        The version to set.
     */
    public void setVersion(String version) {
        this.version = version;
    }
}