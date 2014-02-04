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
package org.n52.oxf.render;

import java.util.*;
import org.n52.oxf.*;
import org.n52.oxf.adapter.*;
import org.n52.oxf.feature.*;
import org.n52.oxf.ows.capabilities.*;

/**
 * @author <a href="mailto:broering@52north.org">Arne Broering</a>
 * 
 */
public interface IFeatureDataRenderer extends IRenderer {

    /**
     * 
     * @param featuresToRender
     *        die in dieser Collection enthaltenen Features beschreiben die zu visualisierenden Daten.
     * @param parameterContainer
     *        der Renderer kann hier Parameter-Werte entnehmen, die bei der Datenanfrage benutzt wurden.
     * @param screenWidth
     *        die Breite des "Views"
     * @param screenHeight
     *        die H�he des "Views"
     * @param bbox
     *        die geografische Ausdehnung
     * @param selectedFeatures
     *        diese Menge enth�lt selektierte Features. Somit k�nnen selektierte Features bei der
     *        Visualisierung separat behandelt werden.
     * @return
     */
    public IVisualization renderLayer(OXFFeatureCollection featuresToRender,
                                      ParameterContainer parameterContainer,
                                      int screenWidth,
                                      int screenHeight,
                                      IBoundingBox bbox,
                                      Set<OXFFeature> selectedFeatures) throws OXFException;
}