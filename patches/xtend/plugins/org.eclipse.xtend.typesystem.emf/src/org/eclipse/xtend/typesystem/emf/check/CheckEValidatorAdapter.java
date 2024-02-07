/*******************************************************************************
 * <copyright>
 * Copyright (c) 2009 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * committers of openArchitectureWare - initial API and implementation
 * </copyright>
 *******************************************************************************/
package org.eclipse.xtend.typesystem.emf.check;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.resources.ResourceLoader;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderImpl;
import org.eclipse.internal.xtend.xtend.ast.ExtensionFile;
import org.eclipse.xtend.check.CheckUtils;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

/**
 * An implementation of {@link org.eclipse.emf.ecore.EValidator} that executes
 * Xtend checks. Further EValidators can be nested.
 * 
 * Check files can be added with reparse option. If true, the check files are
 * reparse on each validation.
 * 
 * @author Jan K�hnlein
 */
public class CheckEValidatorAdapter implements EValidator {

	private final Logger log = LogManager.getLogger(CheckEValidatorAdapter.class);

	private final List<CheckFileWithContext> _checkFiles;

	private EValidator _nestedValidator;

	private final EPackage _ePackage;

	private ResourceManager _externalResourceManager;

	public CheckEValidatorAdapter(final EPackage ePackage) {
		_ePackage = ePackage;
		_checkFiles = new ArrayList<CheckFileWithContext>();
	}

	public CheckEValidatorAdapter(final EPackage ePackage,
			final EValidator existingValidator) {
		this(ePackage);
		if (existingValidator != null) {
			_nestedValidator = existingValidator;
		}
	}

	public void addCheckFile(final CheckFileWithContext checkFile) {
		_checkFiles.add(checkFile);
	}

	public boolean validate(final EObject eObject,
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	public boolean validate(final EClass eClass, final EObject eObject,
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final List<EObject> allElements = Collections.singletonList(eObject);
		boolean isValid = runExtXptCheck(diagnostics, allElements);
		if (_nestedValidator != null) {
			isValid &= _nestedValidator.validate(eClass, eObject, diagnostics,
					context);
		}
		return isValid;
	}

	public boolean validate(final EDataType dataType, final Object value,
			final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final List<?> allElements = Collections.singletonList(dataType);
		boolean isValid = runExtXptCheck(diagnostics, allElements);
		if (_nestedValidator != null) {
			isValid &= _nestedValidator.validate(dataType, value, diagnostics,
					context);
		}
		return isValid;
	}

	public void setExternalResourceManager(
			final ResourceManager externalResourceManager) {
		_externalResourceManager = externalResourceManager;
	}

	private ResourceManager getResourceManager() {
		if (_externalResourceManager != null)
			return _externalResourceManager;
		return new ResourceManagerDefaultImpl();
	}

	private ExecutionContext createExecutionContext(
			final CheckFileWithContext checkFile,
			final ResourceManager resourceManager) {
		final Set<EPackage> allEPackages = new HashSet<EPackage>();
		allEPackages.add(_ePackage);
		for (final String nsURI : checkFile.getImportedEPackageNsUris()) {
			try {
				final EPackage importedEPackage = EPackage.Registry.INSTANCE
						.getEPackage(nsURI);
				if (importedEPackage != null) {
					allEPackages.add(importedEPackage);
				}
			} catch (final Exception exc) {
				log.error(exc);
			}
		}
		final TypeSystemImpl typeSystem = new TypeSystemImpl();
		typeSystem.registerMetaModel(new EmfMetaModel() {
			private final EPackage[] _allEPackages = allEPackages
					.toArray(new EPackage[allEPackages.size()]);

			@Override
			protected EPackage[] allPackages() {
				return _allEPackages;
			}
		});
		final ExecutionContext executionContext = new ExecutionContextImpl(
				resourceManager, typeSystem, null);
		return executionContext;
	}

	private boolean runExtXptCheck(final DiagnosticChain diagnostics,
			final List<?> allElements) {
		boolean isValid = true;
		final ResourceLoader current = ResourceLoaderFactory
				.getCurrentThreadResourceLoader();
		try {
			ResourceLoaderFactory
					.setCurrentThreadResourceLoader(new ResourceLoaderImpl(
							getClass().getClassLoader()));
			for (final CheckFileWithContext checkFile : _checkFiles) {
				final Issues issues = new IssuesImpl();
				final ResourceManager resourceManager = getResourceManager();
				final ExtensionFile parsedCheckFile = (ExtensionFile) resourceManager
						.loadResource(checkFile.getFileName(),
								CheckUtils.FILE_EXTENSION);
				if (parsedCheckFile == null)
					throw new IllegalArgumentException(
							"Couldn't find file "
									+ checkFile.getFileName()
									+ "."
									+ CheckUtils.FILE_EXTENSION
									+ ". Maybe it has been misspelled or it's not on the classpath?");
				final ExecutionContext executionContext = createExecutionContext(
						checkFile, resourceManager);
				runOawCheck(parsedCheckFile, allElements, diagnostics,
						executionContext);
				isValid &= !issues.hasErrors();
			}
		} finally {
			ResourceLoaderFactory.setCurrentThreadResourceLoader(current);
		}
		return isValid;
	}

	private Issues runOawCheck(final ExtensionFile parsedCheckFile,
			final List<?> allElements, final DiagnosticChain diagnostics,
			final ExecutionContext executionContext) {
		final Issues issues = new IssuesImpl();
		if (parsedCheckFile != null) {
			parsedCheckFile.check(executionContext, allElements, issues, false);
			addDiagnosticFromIssues(diagnostics, issues);
		}
		return issues;
	}

	private void addDiagnosticFromIssues(final DiagnosticChain allDiagnostics,
			final Issues issues) {
		final MWEDiagnostic[] errors = issues.getErrors();
		addDiagnostics(allDiagnostics, errors);

		final MWEDiagnostic[] warnings = issues.getWarnings();
		addDiagnostics(allDiagnostics, warnings);
	}

	private void addDiagnostics(final DiagnosticChain allDiagnostics,
			final MWEDiagnostic[] issues) {
		for (final MWEDiagnostic issue : issues) {
			allDiagnostics.add(issue);
		}
	}

}
