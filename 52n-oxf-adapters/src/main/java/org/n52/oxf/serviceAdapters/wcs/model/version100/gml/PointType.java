//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b11-EA 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.06.25 at 02:38:11 CEST 
//


package org.n52.oxf.serviceAdapters.wcs.model.version100.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "PointType", namespace = "http://www.opengis.net/gml")
public class PointType
    extends AbstractGeometryType
{

    @XmlElement(name = "pos", namespace = "http://www.opengis.net/gml", type = DirectPositionType.class)
    protected DirectPositionType pos;

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link org.n52.oxf.serviceAdapters.wcs.model.version100.gml.DirectPositionType}
     */
    public DirectPositionType getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.n52.oxf.serviceAdapters.wcs.model.version100.gml.DirectPositionType}
     */
    public void setPos(DirectPositionType value) {
        this.pos = value;
    }

}
