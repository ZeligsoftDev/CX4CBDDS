/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.validation;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.uml.internal.validation.LoadableConstraintProvider;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * A CompleteOCLConstraintParser supports registration and lazy resolution of
 * the constraints defined in a Complete OCL document for use with the EMF.Validation
 * framework.
 * <p>
 * Since the ConstraintProvider is not extensible, it is necessary to provide
 * support using a ConstraintParser for the CompleteOCL language.
 * <p>
 * The redirection to e.g Loans.ocl should be defined as:
 * <p>
<extension point="org.eclipse.emf.validation.constraintProviders" id="oclProvider">
  <category
            name="Loans.ocl"
            id="org.eclipse.ocl.xtext.completeocl.validation.CompleteOCL/Loans.ocl">
         Constraints determined by parsing Loans.ocl
      </category>
      <constraintProvider cache="true">
         <package namespaceUri="platform:/resource/Play/Loans.ecore"/>

         <constraints categories="org.eclipse.ocl.xtext.completeocl.validation.CompleteOCL/Loans.ocl">
            <constraint id="placeholder" lang="CompleteOCL" mode="Batch" statusCode="101"
                name="=== The Loans.ocl Constraints ===">
               <description>
Placeholder for the actual constraints in Loans.ocl.

The actual constraints are lazily loaded by the first validation run that uses them.</description>
               <message>No message</message>
               <param name="path" value="Loans.ocl"/>
            </constraint>
         </constraints>
      </constraintProvider>
  </extension>
 * <p>
 * and a binding to a client context as:
 * <p>
   <extension point="org.eclipse.emf.validation.constraintBindings">
      <clientContext id="oclProvider.context" default="false">
         <selector class="org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLClientSelector"/>
      </clientContext>
      <binding
            context="oclProvider.context"
            category="org.eclipse.ocl.xtext.completeocl.validation.CompleteOCL/Loans.ocl"/>
   </extension>
 * <p>
 * and a lazy constraint creation as:
 * <p>
   <extension point="org.eclipse.emf.validation.traversal">
      <traversalStrategy
            class="org.eclipse.ocl.xtext.completeocl.validation.LazyLoadingTraversalStrategy"
            namespaceUri="platform:/resource/Play/Loans.ecore">
         <eclass name="Model"/>
      </traversalStrategy>
   </extension>
 */
public class CompleteOCLConstraintProvider extends LoadableConstraintProvider
{
	private static final Logger logger = LogManager.getLogger(CompleteOCLConstraintProvider.class);

	public CompleteOCLConstraintProvider() {
		System.out.println("new CompleteOCLConstraintProvider");
	}

	@Override
	protected boolean load(@NonNull EnvironmentFactory environmentFactory, @NonNull URI uri, @NonNull Set<@NonNull Category> categories) {
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		CSResource xtextResource = null;
		try {
			xtextResource = (CSResource) resourceSet.getResource(uri, true);
		}
		catch (WrappedException e) {
			logger.error("Failed to load '" + uri, e);
			throw e;
		}
		List<Resource.Diagnostic> errors = xtextResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load '" + uri + message);
			return false;
		}
		Resource asResource = xtextResource.getASResource();
		return installResource(asResource, categories);
	}
}
