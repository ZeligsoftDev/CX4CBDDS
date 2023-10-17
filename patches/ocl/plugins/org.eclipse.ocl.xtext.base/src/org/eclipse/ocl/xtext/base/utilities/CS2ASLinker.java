/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.LibraryDiagnostic;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;

/**
 * CS2ASLinker ensures that the CS 2 Pivot mappings are refreshed after
 * and CS Resource modification is committed.
 */
public class CS2ASLinker extends LazyLinker
{
	@Deprecated /* @deprecatedc Use EnvironmentView.DiagnosticWrappedException */
	public static class DiagnosticWrappedException extends EnvironmentView.DiagnosticWrappedException
	{
		private static final long serialVersionUID = 1L;

		public DiagnosticWrappedException(Exception exception)
		{
			super(exception);
		}
	}

	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		Resource eResource = model.eResource();		// FIXME Try to do a narrower refresh
		//		PivotUtilInternal.debugPrintln("afterModelLinking " + NameUtil.debugSimpleName(eResource));
		//		System.out.println(Thread.currentThread().getName() + " afterModelLinked " + getClass().getSimpleName() + "@" + hashCode()
		//			+ " " + eResource.getClass().getSimpleName() + "@" + eResource.hashCode() + " " + eResource.getURI());
		if ((diagnosticsConsumer != null) && eResource instanceof BaseCSResource) {
			@NonNull List<Diagnostic> errors = eResource.getErrors();
			if (!ElementUtil.hasSyntaxError(errors)) {
				//				System.out.println("Starting to refreshPivotMappings for " + eResource.getURI());
				BaseCSResource csResource = (BaseCSResource) eResource;
				try {
					CS2AS cs2as = csResource.getCS2AS();
					ParserContext parserContext = ElementUtil.basicGetParserContext(model);
					if (parserContext != null) {
						Element rootElement = parserContext.getRootElement();
						if (rootElement != null) {
							cs2as.installPivotDefinition((ModelElementCS) model, rootElement);
						}
					}
					cs2as.update(diagnosticsConsumer);
					/*					Resource asResource = resourceAdapter.getPivotResource(csResource);
					ResourceSet resourceSet = csResource.getResourceSet();
					if (resourceSet instanceof ResourceSetImpl) {
						ResourceSetImpl resourceSetImpl = (ResourceSetImpl) resourceSet;
						Map<URI, Resource> uriResourceMap = resourceSetImpl.getURIResourceMap();
						if (uriResourceMap == null) {
							uriResourceMap = new HashMap<URI, Resource>();
							resourceSetImpl.setURIResourceMap(uriResourceMap);
						}
						uriResourceMap.put(asResource.getURI(), asResource);
					} */
				}
				catch (Exception exception) {	// Never let an Exception leak out to abort Xtext
					Exception cause = exception instanceof Resource.IOWrappedException ? (Exception)exception.getCause() : exception;
					//			    	DiagnosticWrappedException wrappedException = new DiagnosticWrappedException(cause);
					//					eResource.getErrors().add(wrappedException);
					if (cause instanceof IllegalLibraryException) {
						errors.add(new LibraryDiagnostic(cause));
					}
					else {
						errors.add(new ExceptionDiagnostic(cause));
						BasePlugin.error(0, csResource.getEditorName() + " Editor linking error", cause);
					}
				}
				//				System.out.println("Finished refreshPivotMappings for " + eResource.getURI());
			}
		}
		//		PivotUtilInternal.debugPrintln("afterModelLinked " + NameUtil.debugSimpleName(eResource));
	}
}