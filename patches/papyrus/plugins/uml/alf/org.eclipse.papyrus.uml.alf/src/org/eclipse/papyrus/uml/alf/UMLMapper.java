/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Jeremie Tatibouet
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.xtext.resource.XtextResourceSet;


public class UMLMapper extends AbstractMapper {

	public static final String UML_TO_ALF_TRANSFORMATION = "platform:/plugin/org.eclipse.papyrus.uml.alf.to.fuml/transformation/UML2Alf.qvto";

	protected final URI transformationURI;

	public UMLMapper() {
		super();
		this.transformationURI = URIConverter.INSTANCE.normalize(URI.createURI(UML_TO_ALF_TRANSFORMATION));
		this.executor = new TransformationExecutor(this.transformationURI);
	}

	/**
	 * Map the provided NamedElement into an equivalent Alf model
	 * 
	 * @param semanticObject
	 * @return the ALF model corresponding to the semantic element
	 */
	public Resource map(EObject umlElement) throws MappingError {
		Resource alfModelResource = new ResourceImpl();
		alfModelResource.setURI(URI.createURI("AlfModel.tmp"));
		ResourceSet resourceSet = new XtextResourceSet();
		resourceSet.getResources().add(alfModelResource);
		Diagnostic diagnostic = this.executor.loadTransformation();
		if (diagnostic.getCode() == Diagnostic.OK) {
			List<EObject> inputList = new ArrayList<EObject>();
			inputList.add(umlElement);
			ModelExtent input = new BasicModelExtent(inputList);
			ModelExtent output = new BasicModelExtent();
			diagnostic = this.executor.execute(this.context, input, output);
			if (diagnostic.getCode() == Diagnostic.ERROR) {
				throw new MappingError((ExecutionDiagnostic) diagnostic);
			} else {
				alfModelResource.getContents().addAll(output.getContents());
			}
		}
		return alfModelResource;
	}
}
