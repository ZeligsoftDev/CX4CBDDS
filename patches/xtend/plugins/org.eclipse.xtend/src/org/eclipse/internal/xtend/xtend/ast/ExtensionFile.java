/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;

public class ExtensionFile extends SyntaxElement implements XtendFile {
	private static final List<NamespaceImportStatement> EMPTY_NAMESPACEIMPORTSTATEMENTS = Collections.<NamespaceImportStatement> emptyList();
	private static final List<ExtensionImportStatement> EMPTY_EXTENSION_IMPORT_STATEMENTS = Collections.<ExtensionImportStatement> emptyList();
	private static final List<Extension> EMPTY_EXTENSIONS = Collections.<Extension> emptyList();
	private static final List<Around> EMPTY_AROUNDS = Collections.<Around> emptyList();
	private static final List<Check> EMPTY_CHECKS = Collections.<Check> emptyList();

	private final List<NamespaceImportStatement> nsImports;

	private final List<ExtensionImportStatement> extImports;

	private final List<Extension> extensions;

	private final List<Around> arounds;

	private final List<Check> checks;

	public List<Check> getChecks() {
		return checks;
	}

	public ExtensionFile(final List<NamespaceImportStatement> nsImports, final List<ExtensionImportStatement> extImports,
			final List<Extension> extensions, final List<Around> arounds, final List<Check> checks) {
		this.nsImports = ((nsImports != null) && !nsImports.isEmpty()) ? nsImports : EMPTY_NAMESPACEIMPORTSTATEMENTS;
		this.extImports = ((extImports != null) && !extImports.isEmpty()) ? extImports : EMPTY_EXTENSION_IMPORT_STATEMENTS;
		this.extensions = ((extensions != null) && !extensions.isEmpty()) ? extensions : EMPTY_EXTENSIONS;
		this.arounds = ((arounds != null) && !arounds.isEmpty()) ? arounds : EMPTY_AROUNDS;
		this.checks = ((checks != null) && !checks.isEmpty()) ? checks : EMPTY_CHECKS;
		for (Extension extension : this.extensions) {
			extension.setExtensionFile(this);
		}
		for (Around around : this.arounds) {
			around.setParent(this);
		}
	}

	public List<Around> getArounds() {
		return arounds;
	}

	public List<Extension> getExtensions() {
		return extensions;
	}

	public List<ExtensionImportStatement> getExtImports() {
		return extImports;
	}

	public List<NamespaceImportStatement> getNsImports() {
		return nsImports;
	}

	public String[] getImportedNamespaces() {
		final List<String> namespaces = new ArrayList<String>();
		for (NamespaceImportStatement nsImport : nsImports) {
			namespaces.add(nsImport.getImportedId().toString());
		}
		return namespaces.toArray(new String[namespaces.size()]);
	}

	public List<String> getImportedNamespacesAsList() {
		return Arrays.asList(getImportedNamespaces());
	}

	public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx;
		try {
			_ctx = _ctx.cloneWithResource(this);
			if (_ctx.getCallback() != null) {
				if (!_ctx.getCallback().pre(this, _ctx)) {
					return;
				}
			}

			// try to load all declared imported extensions. Add error issues if
			// the resource cannot be located
			// by the ResourceManager
			for (ExtensionImportStatement imp : extImports) {
				imp.analyze(_ctx, issues);
			}

			// add error marker for duplicate extension imports
			Set<Identifier> uniqueNames = new HashSet<Identifier>();
			for (ExtensionImportStatement imp : extImports) {
				if (uniqueNames.contains(imp.getImportedId())) {
					final String msg = "Duplicate extension importing: " + imp.getImportedId().toString();
					issues.add(new AnalysationIssue(AnalysationIssue.SYNTAX_ERROR, msg, imp));
				}
				uniqueNames.add(imp.getImportedId());
			}

			for (Extension ext : extensions) {
				try {
					ext.analyze(_ctx, issues);
				} catch (RuntimeException ex) {
					Map<String, Object> info = new HashMap<String, Object>();
					info.put("extension", ext);
					_ctx.handleRuntimeException(ex, this, info);
				}
			}

			for (Around around : arounds) {
				try {
					around.analyze(_ctx, issues);
				} catch (RuntimeException ex) {
					Map<String, Object> info = new HashMap<String, Object>();
					info.put("around", around);
					_ctx.handleRuntimeException(ex, this, info);
				}
			}

			for (final Check check : checks) {
				try {
					check.analyze(_ctx, issues);
				} catch (RuntimeException ex) {
					_ctx.handleRuntimeException(ex, this, null);
				}
			}

			// Namespaces can only be checked at last, since all used types
			// must be accessed first
			for (NamespaceImportStatement imp : nsImports) {
				imp.analyze(_ctx, issues);
			}

			// Bug#401505
			checkAmbiguous(_ctx, issues);

		} finally {
			if (_ctx.getCallback() != null) {
				_ctx.getCallback().post(this, _ctx, null);
			}
		}

	}

	/**
	 * Check for ambiguous extensions per resource and not per extension
	 */
	private void checkAmbiguous(final ExecutionContext ctx, final Set<AnalysationIssue> issuesFromThisResource) {
		Map<Extension, Extension> allExtensions = new HashMap<Extension, Extension>();
		for (Extension extension : getExtensions()) {
			extension.init(ctx);
			Extension old = allExtensions.put(extension, extension);
			if (old != null) {
				issuesFromThisResource.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Duplicate extension definition: "
						+ extension.toOutlineString() + " also defined in Line " + old.getLine(), (AbstractExtension) extension, false, extension
						.getLine()));

				issuesFromThisResource
						.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Duplicate extension definition: " + extension.toOutlineString()
								+ " also defined in Line " + extension.getLine(), (AbstractExtension) old, false, old.getLine()));

			}
		}
		allExtensions.clear();
		allExtensions = null;
	}

	private String fullyQualifiedName;

	public void setFullyQualifiedName(final String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	public String[] getImportedExtensions() {
		final List<String> namespaces = new ArrayList<String>();
		for (ExtensionImportStatement extImport : extImports) {
			namespaces.add(extImport.getImportedId().toString());
		}
		return getImportedExtensionsAsList().toArray(new String[namespaces.size()]);
	}

	public List<String> getImportedExtensionsAsList() {
		final List<String> namespaces = new ArrayList<String>();
		for (ExtensionImportStatement extImport : extImports) {
			namespaces.add(extImport.getImportedId().toString());
		}
		return namespaces;
	}

	public List<Extension> getPublicExtensions(final ResourceManager rm, final ExecutionContext ctx) {
		return getPublicExtensions(rm, ctx, new HashSet<String>());
	}

	public List<Extension> getPublicExtensions(final ResourceManager rm, final ExecutionContext ctx, final Set<String> flowoverCache) {
		if (flowoverCache.contains(getFullyQualifiedName())) {
			return new ArrayList<Extension>();
		}
		flowoverCache.add(getFullyQualifiedName());

		final List<Extension> result = new ArrayList<Extension>();

		for (Extension ext : extensions) {
			if (!ext.isPrivate()) {
				result.add(ext);
			}
		}
		for (ExtensionImportStatement imp : extImports) {
			if (imp.isExported()) {
				final XtendFile xf = (XtendFile) rm.loadResource(imp.getImportedId().toString(), XtendFile.FILE_EXTENSION);
				if (xf == null) {
					throw new RuntimeException("Unable to reexport extension file " + imp.getImportedId().toString() + " from "
							+ getFullyQualifiedName());
				}

				ExecutionContext context = ctx.cloneWithResource(xf);
				List<Extension> publicExtensions = xf.getPublicExtensions(rm, context, flowoverCache);
				for (Extension extension : publicExtensions) {
					extension.init(context);
					if (!result.contains(extension)) {
						result.add(extension);
					}
				}
			}
		}
		return result;
	}

	public void check(final ExecutionContext ctx, final Collection<?> objects, final Issues issues, final boolean warnIfNothingChecked) {
		ExecutionContext _ctx = ctx.cloneWithResource(this);
		for (final Check check : checks) {
			check.validate(_ctx, objects, issues, warnIfNothingChecked);
		}
	}

	@Override
	public String toString() {
		return getFileName();
	}
}
