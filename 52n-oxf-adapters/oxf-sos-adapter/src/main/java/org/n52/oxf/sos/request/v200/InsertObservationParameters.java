/**
 * ﻿Copyright (C) 2012
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
package org.n52.oxf.sos.request.v200;

import static org.n52.oxf.sos.adapter.ISOSRequestBuilder.INSERT_OBSERVATION_OFFERINGS_PARAMETER;

import java.util.Collection;

import org.n52.oxf.sos.observation.ObservationParameters;

/**
 * Assembles all parameters needed for an InsertObservation request according to 
 * SOS 2.0.0 specification version.
 */
public class InsertObservationParameters extends org.n52.oxf.sos.request.InsertObservationParameters {
    
    private final ObservationParameters observation;
	
	public InsertObservationParameters(
			final ObservationParameters observationParameters,
			final Collection<String> offerings)
			throws IllegalArgumentException
	{
        if (observationParameters == null || 
        		observationParameters.isEmpty() || 
        		!observationParameters.isValid()) {
        	throw new IllegalArgumentException(
        			"Parameter 'ObservationParameters' is required and may not be null or empty!");
        }
        addNonEmpty(INSERT_OBSERVATION_OFFERINGS_PARAMETER,offerings);
		mergeWith(observationParameters);
		observation = observationParameters;
	}

    public boolean isValid() {
        return !isEmptyValue(INSERT_OBSERVATION_OFFERINGS_PARAMETER) && 
        		observation.isValid();
    }
	
}