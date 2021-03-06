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
package org.n52.oxf.ows.capabilities;

/**
 * This class builds the foundation to inspect the possible operations of the
 * WebService. This class contains all important information to access an OWS.
 * 
 * @author <a href="mailto:foerster@52north.org">Theodor Foerster</a>
 * @author <a href="mailto:broering@52north.org">Arne Broering</a>
 */
public class OperationsMetadata {

	/**
	 * Metadata for the operations that this server interface implements <br>
	 * <br>
	 * One or more (mandatory)
	 */
	private Operation[] operations;

	/**
	 * ParameterContainer applies to one or more operations which this server
	 * implements.<br>
	 * The parameter can be an input and/or output parameter of the operations.<br>
	 * <br>
	 * Zero or more (optional)
	 */
    //TODO: these parameters should be applied to all Operations
	private Parameter[] parameters;

	/**
	 * Constraint on valid domain of a non-parameter quantity that applies to
	 * this server.<br>
	 * <br>
	 * Zero or more (optional)
	 */
	private String[] constraints;

	public OperationsMetadata(final Operation[] operations) {
		setOperations(operations);
	}

	public OperationsMetadata(final Operation[] operations, final Parameter[] parameters,
			final String[] constraints) {
		setOperations(operations);
		setParameters(parameters);
		setConstraints(constraints);
	}

	/**
	 * @return a XML representation of this OperationsMetadata-section.
	 */
	public String toXML() {
		String res = "<OperationsMetadata>";

		res += "<Operations>";
		if (operations != null) {
			for (final Operation operation : operations) {
				res += operation.toXML();
			}
		}
		res += "</Operations>";

		res += "<Parameters>";
		if (parameters != null) {
			for (final Parameter parameter : parameters) {
				res += parameter.toXML();
			}
		}
		res += "</Parameters>";

		res += "<Constraints>";
		if (constraints != null) {
			for (final String c : constraints) {
				res += "<Constraint>";
				res += c;
				res += "<Constraint>";
			}
		}
		res += "</Constraints>";

		res += "</OperationsMetadata>";

		return res;
	}

	/**
	 * Representation of possible Constraints. These constraints will be
	 * inherited by all underlying operations.
	 * 
	 * @return a String representation of the constraints.
	 */
	public String[] getConstraints() {
		return constraints;
	}

	/**
	 * Representation of possible Constraints. These constraints will be
	 * inherited by all underlying operations.
	 * 
	 * @param constraints
	 *            The constraints to set.
	 */
	protected void setConstraints(final String[] constraints) {
		this.constraints = constraints;
	}

	/**
	 * @param operationName a name of an operation
	 * @return the Operation with the specified operationName. Returns
	 *         <code>null</code> if there isn't such an Operation.
	 */
	public Operation getOperationByName(final String operationName) {
		for (final Operation op : operations) {
			if (op != null && op.getName().equals(operationName)) {
				return op;
			}
		}
		return null;
	}

	public Operation[] getOperations() {
		return operations;
	}

	protected void setOperations(final Operation[] operations) {
		this.operations = operations;
	}

	/**
	 * This parameters are inherited by ALL operations. (ie. parameter version)
	 * 
	 * @return Returns the parameters.
	 */
	public Parameter[] getParameters() {
		return parameters;
	}

	/**
	 * This parameters are inherited by ALL operations
	 * 
	 * @param parameters
	 *            The parameters to set.
	 */
	protected void setParameters(final Parameter[] parameters) {
		this.parameters = parameters;
	}
}