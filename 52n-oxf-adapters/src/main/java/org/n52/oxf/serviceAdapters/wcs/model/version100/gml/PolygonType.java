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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "PolygonType", namespace = "http://www.opengis.net/gml")
public class PolygonType
    extends AbstractSurfaceType
{

    @XmlElement(name = "exterior", namespace = "http://www.opengis.net/gml", type = AbstractRingPropertyType.class)
    protected AbstractRingPropertyType exterior;
    @XmlElement(name = "interior", namespace = "http://www.opengis.net/gml", type = AbstractRingPropertyType.class)
    protected List<AbstractRingPropertyType> interior;

    /**
     * Gets the value of the exterior property.
     * 
     * @return
     *     possible object is
     *     {@link org.n52.oxf.serviceAdapters.wcs.model.version100.gml.AbstractRingPropertyType}
     */
    public AbstractRingPropertyType getExterior() {
        return exterior;
    }

    /**
     * Sets the value of the exterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.n52.oxf.serviceAdapters.wcs.model.version100.gml.AbstractRingPropertyType}
     */
    public void setExterior(AbstractRingPropertyType value) {
        this.exterior = value;
    }

    protected List<AbstractRingPropertyType> _getInterior() {
        if (interior == null) {
            interior = new ArrayList<AbstractRingPropertyType>();
        }
        return interior;
    }

    /**
     * Gets the value of the interior property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interior property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterior().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link org.n52.oxf.serviceAdapters.wcs.model.version100.gml.AbstractRingPropertyType}
     * 
     */
    public List<AbstractRingPropertyType> getInterior() {
        return this._getInterior();
    }

}
