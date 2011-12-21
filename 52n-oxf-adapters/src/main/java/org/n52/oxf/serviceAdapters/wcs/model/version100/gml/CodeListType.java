//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b11-EA 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.06.25 at 02:38:11 CEST 
//


package org.n52.oxf.serviceAdapters.wcs.model.version100.gml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "CodeListType", namespace = "http://www.opengis.net/gml")
public class CodeListType {

    @XmlValue
    protected List<String> value;
    @XmlAttribute(name = "codeSpace", namespace = "")
    protected String codeSpace;

    protected List<String> _getValue() {
        if (value == null) {
            value = new ArrayList<String>();
        }
        return value;
    }

    /**
     * XML List based on XML Schema Name type.  An element of this type contains a space-separated list of Name valuesGets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String}
     * 
     */
    public List<String> getValue() {
        return this._getValue();
    }

    /**
     * Gets the value of the codeSpace property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    public String getCodeSpace() {
        return codeSpace;
    }

    /**
     * Sets the value of the codeSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setCodeSpace(String value) {
        this.codeSpace = value;
    }

}
