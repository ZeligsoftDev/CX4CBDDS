/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.AbstractInjectableValidator;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxEValidator;

import com.google.common.collect.Lists;

/**
 * PivotResourceValidator extends CS Resource validation to the referenced Pivot resources and attempts
 * to indicate Pivot validation problems in the appropriate CS context.
 */
public class PivotResourceValidator extends ResourceValidatorImpl
{
	public static class ValidationDiagnostic extends BasicDiagnostic implements Resource.Diagnostic
	{
		private ValidationDiagnostic(String message) {
			super(WARNING, EObjectValidator.DIAGNOSTIC_SOURCE, 0, message, null);
		}

		@Override
		public int getColumn() {
			return 0;		// This could be computed from the CS
		}

		@Override
		public int getLine() {
			return 0;		// This could be computed from the CS
		}

		@Override
		public String getLocation() {
			return null;		// This could be computed from the CS
		}

		public Integer getOffset() {
			return null;		// This could be computed from the CS
		}

		public Integer getLength() {
			return 10;		// This could be computed from the CS
		}
	}

	private static final Logger log = LogManager.getLogger(PivotResourceValidator.class);
	public static final String HAS_SYNTAX_ERRORS = "has_syntax_errors";

	protected ValidationDiagnostic createDefaultDiagnostic(Diagnostician diagnostician, EObject pivotObject) {
		//		Object objectLabel = diagnostician.getObjectLabel(pivotObject);
		//		return new ValidationDiagnostic(EcorePlugin.INSTANCE.getString("_UI_DiagnosticRoot_diagnostic",
		//			new Object[] { objectLabel }), new Object[] { pivotObject });
		return new ValidationDiagnostic("");
	}

	protected void issueFromDiagnostics(IAcceptor<Issue> acceptor, ValidationDiagnostic diagnostic) {
		for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
			//			System.out.println(" issueFromEValidatorDiagnostic " + childDiagnostic);
			issueFromEValidatorDiagnostic(childDiagnostic, acceptor);
		}
	}

	protected void performValidation(IAcceptor<Issue> acceptor, Resource asResource, CancelIndicator monitor) {
		//		System.out.println(Thread.currentThread().getName() + " performValidation " + NameUtil.debugSimpleName(asResource));
		Diagnostician diagnostician = getDiagnostician();
		Map<Object, Object> context = LabelUtil.createDefaultContext(diagnostician);
		//		List<Resource> resources = asResource.getResourceSet().getResources();
		//		for (int i = 0; i < resources.size(); i++) {
		Resource pResource = asResource; //resources.get(i);
		//			if (PivotConstants.ORPHANAGE_URI.equals(String.valueOf(pResource.getURI()))) {
		//				continue;		// GC may not have eliminated all the dangling references
		//			}
		//			System.out.println(" performValidation " + pResource.getURI() + " on " + Thread.currentThread().getName());
		removeValidationDiagnostics(pResource.getErrors());
		removeValidationDiagnostics(pResource.getWarnings());
		List<EObject> contents = pResource.getContents();
		for (int j = 0; j < contents.size(); j++) {		// Beware concurrent unload
			try {
				if (monitor.isCanceled())
					return;
				EObject pObject = contents.get(j);
				ValidationDiagnostic diagnostic = createDefaultDiagnostic(diagnostician, pObject);
				diagnostician.validate(pObject, diagnostic, context);
				if (!diagnostic.getChildren().isEmpty()) {
					if (diagnostic.getSeverity() == Diagnostic.ERROR) {
						pResource.getErrors().add(diagnostic);
					}
					else if (diagnostic.getSeverity() == Diagnostic.WARNING) {
						pResource.getWarnings().add(diagnostic);
					}
					issueFromDiagnostics(acceptor, diagnostic);
				}
			} catch (RuntimeException e) {
				if (!monitor.isCanceled()) {
					pResource.getErrors().add(new ValidationDiagnostic(e.getMessage()));
					//					log.error(e.getMessage(), e);
				}
			}
		}
		//		}
	}

	protected void removeValidationDiagnostics(List<Resource.Diagnostic> diagnostics) {
		//		System.out.println(Thread.currentThread().getName() + " removeValidationDiagnostics ");
		for (int i = diagnostics.size()-1; i >= 0; i--) {
			Resource.Diagnostic diagnostic = diagnostics.get(i);
			if (diagnostic instanceof ValidationDiagnostic) {
				diagnostics.remove(i);
			}
		}
	}

	/*	protected void reuseValidation(IAcceptor<Issue> acceptor, Resource asResource, CancelIndicator monitor) {
//		System.out.println(Thread.currentThread().getName() + " reuseValidation " + NameUtil.debugSimpleName(asResource));
		ResourceSet resourceSet = asResource.getResourceSet();
		if (resourceSet != null) {
			for (Resource pResource : resourceSet.getResources()) {
	//			System.out.println(" reuseValidation " + pResource.getURI() + " on " + Thread.currentThread().getName());
				for (Resource.Diagnostic diagnostic : pResource.getErrors()) {
					if (diagnostic instanceof ValidationDiagnostic) {
						issueFromDiagnostics(acceptor, (ValidationDiagnostic)diagnostic);
					}
				}
				for (Resource.Diagnostic diagnostic : pResource.getWarnings()) {
					if (diagnostic instanceof ValidationDiagnostic) {
						issueFromDiagnostics(acceptor, (ValidationDiagnostic)diagnostic);
					}
				}
			}
		}
	} */

	// FIXME BUG 389675 Remove duplication with respect to inherited method
	@Override
	public List<Issue> validate(Resource resource, final CheckMode mode, CancelIndicator mon) {
		//		System.out.println(Thread.currentThread().getName() + " validate start " + NameUtil.debugSimpleName(resource));
		//		System.out.println(new Date() + " Validate " + mode + " : " + csResource.getURI() + " on " + Thread.currentThread().getName());
	//	ThreadLocalExecutor.reset();
		assert ThreadLocalExecutor.basicGetEnvironmentFactory() != null;
		final CancelIndicator monitor = mon == null ? CancelIndicator.NullImpl : mon;
		resolveProxies(resource, monitor);
		if (monitor.isCanceled())
			return Collections.emptyList();

		final List<Issue> result = Lists.newArrayListWithExpectedSize(resource.getErrors().size()
			+ resource.getWarnings().size());
		try {
			IAcceptor<Issue> acceptor = createAcceptor(result);
			// Syntactical and linking errors
			// Collect EMF Resource Diagnostics
			if (mode.shouldCheck(CheckType.FAST)) {
				for (int i = 0; i < resource.getErrors().size(); i++) {
					if (monitor.isCanceled())
						return Collections.emptyList();
					issueFromXtextResourceDiagnostic(resource.getErrors().get(i), Severity.ERROR, acceptor);
				}

				for (int i = 0; i < resource.getWarnings().size(); i++) {
					if (monitor.isCanceled())
						return Collections.emptyList();
					issueFromXtextResourceDiagnostic(resource.getWarnings().get(i), Severity.WARNING, acceptor);
				}
			}

			if (monitor.isCanceled())
				return Collections.emptyList();
			boolean syntaxDiagFail = !result.isEmpty();
			logCheckStatus(resource, syntaxDiagFail, "Syntax");

			// Validation errors
			// Collect validator Diagnostics
			for (EObject ele : resource.getContents()) {
				try {
					if (monitor.isCanceled())
						return Collections.emptyList();
					Diagnostician diagnostician = getDiagnostician();
					Map<Object, Object> options = LabelUtil.createDefaultContext(diagnostician);
					options.put(CheckMode.KEY, mode);
					options.put(CancelableDiagnostician.CANCEL_INDICATOR, monitor);
					// disable concrete syntax validation, since a semantic model that has been parsed
					// from the concrete syntax always complies with it - otherwise there are parse errors.
					options.put(ConcreteSyntaxEValidator.DISABLE_CONCRETE_SYNTAX_EVALIDATOR, Boolean.TRUE);
					// see EObjectValidator.getRootEValidator(Map<Object, Object>)
					boolean hasSyntaxError = false;
					if (resource instanceof XtextResource) {
						options.put(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME, ((XtextResource) resource).getLanguageName());
						if (resource instanceof BaseCSResource) {
							BaseCSResource csResource = (BaseCSResource)resource;
							@NonNull List<Resource.Diagnostic> errors = csResource.getErrors();
							hasSyntaxError = ElementUtil.hasSyntaxError(errors);
							if (hasSyntaxError) {
								options.put(PivotResourceValidator.HAS_SYNTAX_ERRORS, Boolean.TRUE);
							}
						}
					}
					if (!hasSyntaxError) {
						Diagnostic diagnostic = getDiagnostician().validate(ele, options);
						if (!diagnostic.getChildren().isEmpty()) {
							for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
								issueFromEValidatorDiagnostic(childDiagnostic, acceptor);
							}
						} else {
							issueFromEValidatorDiagnostic(diagnostic, acceptor);
						}
					}
				} catch (RuntimeException e) {
					if (!monitor.isCanceled()) {		// Fix Bug 462544 working around Xtext Bug 461764
						log.error(e.getMessage(), e);
					}
				}
			}
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		if (monitor.isCanceled())
			return Collections.emptyList();
		if (resource instanceof BaseCSResource) {
			BaseCSResource csResource = (BaseCSResource)resource;
			CS2AS cs2as = csResource.findCS2AS();
			if (cs2as != null) {
				Resource asResource = cs2as.getASResource();
				IAcceptor<Issue> acceptor = createAcceptor(result);
				//				if (mode.shouldCheck(CheckType.EXPENSIVE)) {
				performValidation(acceptor, asResource, monitor);
				//				}
				//				else {
				//					reuseValidation(acceptor, asResource, monitor);
				//				}
			}
		}
		//		System.out.println(Thread.currentThread().getName() + " validate end " + NameUtil.debugSimpleName(resource));
		ThreadLocalExecutor.resetEnvironmentFactory();
		return result;
	}


	private void logCheckStatus(final Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled()) {
			log.debug(string + " check " + (parserDiagFail ? "FAIL" : "OK") + "! Resource: " + resource.getURI());
		}
	}


}
