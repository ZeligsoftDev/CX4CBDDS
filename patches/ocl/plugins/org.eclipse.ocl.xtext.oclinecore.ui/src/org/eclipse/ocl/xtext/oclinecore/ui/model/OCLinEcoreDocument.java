/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.model;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.uml.internal.as2es.AS2UML;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.ui.model.BaseDocument;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * An OCLinEcoreDocument refines a document to support generation of an alternate (XMI) content
 * for use during save in place of its normal textual content.
 */
public class OCLinEcoreDocument extends BaseDocument
{
	@Inject
	public OCLinEcoreDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		super(tokenSource, composer);
	}

	/**
	 * Write the XMI representation of the Ecore to be saved.
	 * @param exportDelegateURI
	 */
	public void saveAsEcore(final @NonNull Writer writer, final @NonNull URI ecoreURI, final @Nullable String exportDelegateURI) throws IOException, CoreException {
		readOnly(new IUnitOfWork<Object, XtextResource>()
		{
			@Override
			public Object exec(@Nullable XtextResource resource) throws Exception {
				if (resource != null) {
					XMLResource asResource = getASResource();
					if (asResource != null) {
						CS2AS cs2as = ((BaseCSResource)resource).findCS2AS();
						if (cs2as != null) {
						//	Resource csResource = cs2as.getCSResource();
						//	checkForErrors(csResource);
							Map<@NonNull String, @Nullable Object> options = new HashMap<>();
							options.put(ClassUtil.nonNullState(OCLConstants.OCL_DELEGATE_URI), exportDelegateURI);
							XMLResource ecoreResource = AS2Ecore.createResource(cs2as.getEnvironmentFactory(), asResource, ecoreURI, options);
							//					ResourceSetImpl resourceSet = new ResourceSetImpl();
							//					XMLResource ecoreResource = (XMLResource) resourceSet.createResource(ecoreURI);
							//					ecoreResource.getContents().addAll(ecoreContents);
						//	Map<Object, Object> saveOptions = XMIUtil.createSaveOptions();
						//	XMIUtil.retainLineWidth(saveOptions, ecoreResource);
							ecoreResource.save(writer, null);
							checkForErrors(ecoreResource);
						}
					}
				}
				return null;
			}
		});
	}

	/**
	 * Write the XMI representation of the UML to be saved.
	 */
	public void saveAsUML(final @NonNull Writer writer, final @NonNull URI umlURI) throws IOException, CoreException {
		readOnly(new IUnitOfWork<Object, XtextResource>()
		{
			@Override
			public Object exec(@Nullable XtextResource resource) throws Exception {
				if (resource != null) {
					XMLResource asResource = getASResource();
					if (asResource != null) {
						CS2AS cs2as = ((BaseCSResource)resource).findCS2AS();
						if (cs2as != null) {
							List<@NonNull EObject> umlContents = ClassUtil.nullFree(AS2UML.createResource(cs2as.getEnvironmentFactory(), asResource));
							ResourceSetImpl resourceSet = new ResourceSetImpl();
							//				URI umlURI = URI.createURI("internal.uml");
							UMLResource umlResource = (UMLResource) resourceSet.createResource(umlURI);
							umlResource.getContents().addAll(umlContents);
							checkForErrors(umlResource);
							umlResource.save(writer, null);
						}
					}
				}
				return null;
			}
		});
	}

	/**
	 * Write the XMI representation of the Ecore to be saved.
	 */
	public void saveInEcore(final @NonNull Writer writer, final @NonNull URI ecoreURI, final @Nullable String exportDelegateURI) throws IOException, CoreException {
		readOnly(new IUnitOfWork<Object, XtextResource>()
		{
			@Override
			public Object exec(@Nullable XtextResource resource) throws Exception {
				if (resource != null) {
					XMLResource asResource = getASResource();
					if (asResource != null) {
						CS2AS cs2as = ((BaseCSResource)resource).findCS2AS();
						if (cs2as != null) {
							Map<@NonNull String, @Nullable Object> options = new HashMap<>();
							options.put(PivotConstants.PRIMITIVE_TYPES_URI_PREFIX, "primitives.ecore#//");
							options.put(ClassUtil.nonNullState(OCLConstants.OCL_DELEGATE_URI), exportDelegateURI);
							XMLResource ecoreResource = AS2Ecore.createResource(cs2as.getEnvironmentFactory(), asResource, ecoreURI, options);
							ecoreResource.save(writer, null);
							checkForErrors(ecoreResource);
						}
					}
				}
				return null;
			}
		});
	}
}
