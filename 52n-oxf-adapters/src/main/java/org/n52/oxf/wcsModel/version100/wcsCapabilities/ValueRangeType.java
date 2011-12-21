//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b11-EA 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.06.25 at 02:38:11 CEST 
//


package org.n52.oxf.wcsModel.version100.wcsCapabilities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "valueRangeType", namespace = "http://www.opengis.net/wcs")
public class ValueRangeType {

    @XmlElement(name = "min", namespace = "http://www.opengis.net/wcs", type = TypedLiteralType.class)
    protected TypedLiteralType min;
    @XmlElement(name = "max", namespace = "http://www.opengis.net/wcs", type = TypedLiteralType.class)
    protected TypedLiteralType max;
    @XmlAttribute(name = "atomic", namespace = "")
    protected Boolean atomic;
    @XmlAttribute(name = "closure", namespace = "http://www.opengis.net/wcs")
    protected List<String> closure;
    @XmlAttribute(name = "semantic", namespace = "http://www.opengis.net/wcs")
    protected String semantic;
    @XmlAttribute(name = "type", namespace = "http://www.opengis.net/wcs")
    protected String type;

    /**
     * Gets the value of the min property.
     * 
     * @return
     *     possible object is
     *     {@link org.n52.oxf.wcsModel.version100.wcsCapabilities.TypedLiteralType}
     */
    public TypedLiteralType getMin() {
        return min;
    }

    /**
     * Sets the value of the min property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.n52.oxf.wcsModel.version100.wcsCapabilities.TypedLiteralType}
     */
    public void setMin(TypedLiteralType value) {
        this.min = value;
    }

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link org.n52.oxf.wcsModel.version100.wcsCapabilities.TypedLiteralType}
     */
    public TypedLiteralType getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.n52.oxf.wcsModel.version100.wcsCapabilities.TypedLiteralType}
     */
    public void setMax(TypedLiteralType value) {
        this.max = value;
    }

    /**
     * Gets the value of the atomic property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.Boolean}
     */
    public boolean isAtomic() {
        if (atomic == null) {
            return false;
        } else {
            return atomic;
        }
    }

    /**
     * Sets the value of the atomic property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.Boolean}
     */
    public void setAtomic(Boolean value) {
        this.atomic = value;
    }

    protected List<String> _getClosure() {
        if (closure == null) {
            closure = new ArrayList<String>();
        }
        return closure;
    }

    /**
     * Gets the value of the closure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the closure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClosure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String}
     * 
     */
    public List<String> getClosure() {
        return this._getClosure();
    }

    /**
     * Gets the value of the semantic property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    public String getSemantic() {
        if (semantic == null) {
            return "closed";
        } else {
            return semantic;
        }
    }

    /**
     * Sets the value of the semantic property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setSemantic(String value) {
        this.semantic = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    public String getType() {
        if (type == null) {
            return "closed";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setType(String value) {
        this.type = value;
    }

}
