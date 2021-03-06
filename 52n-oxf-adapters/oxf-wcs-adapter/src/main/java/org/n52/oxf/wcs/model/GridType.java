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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b11-EA 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.06.25 at 02:38:11 CEST 
//


package org.n52.oxf.wcs.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "GridType", namespace = "http://www.opengis.net/gml")
public class GridType
    extends AbstractGeometryType
{

    @XmlElement(name = "limits", namespace = "http://www.opengis.net/gml", type = GridLimitsType.class)
    protected GridLimitsType limits;
    @XmlElement(name = "axisName", namespace = "http://www.opengis.net/gml", type = String.class)
    protected List<String> axisName;
    @XmlAttribute(name = "dimension", namespace = "", required = true)
    protected BigInteger dimension;

    /**
     * Gets the value of the limits property.
     * 
     * @return
     *     possible object is
     *     {@link org.n52.oxf.wcs.model.GridLimitsType}
     */
    public GridLimitsType getLimits() {
        return limits;
    }

    /**
     * Sets the value of the limits property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.n52.oxf.wcs.model.GridLimitsType}
     */
    public void setLimits(GridLimitsType value) {
        this.limits = value;
    }

    protected List<String> _getAxisName() {
        if (axisName == null) {
            axisName = new ArrayList<String>();
        }
        return axisName;
    }

    /**
     * Gets the value of the axisName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the axisName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAxisName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String}
     * 
     */
    public List<String> getAxisName() {
        return this._getAxisName();
    }

    /**
     * Gets the value of the dimension property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger}
     */
    public BigInteger getDimension() {
        return dimension;
    }

    /**
     * Sets the value of the dimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger}
     */
    public void setDimension(BigInteger value) {
        this.dimension = value;
    }

}
