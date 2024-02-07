/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend;

import java.io.StringReader;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.ast.ExtensionFile;
import org.eclipse.internal.xtend.xtend.parser.ParseFacade;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Type;

public class XtendFacade {

	private final ExecutionContext ctx;

	private XtendFacade(final ExecutionContext ctx) {
		this.ctx = ctx;
	}

	public final XtendFacade cloneWithExtensions(final String extensionCode) {
		return new XtendFacade(ctx.cloneWithResource(parse(extensionCode)));
	}

	public final void registerMetaModel(final MetaModel mm) {
		if (ctx instanceof ExecutionContextImpl) {
			((ExecutionContextImpl) ctx).registerMetaModel(mm);
		} else {
			throw new IllegalStateException("Couldn't register Metamodel - ExecutionContextImpl expected.");
		}
	}

	private ExtensionFile parse(final String extFile) {
		return ParseFacade.file(new StringReader(extFile), "nofile");
	}

	public final static XtendFacade create(final String... extFile) {
		return create(new ExecutionContextImpl(new TypeSystemImpl()), extFile);
	}

	public final static XtendFacade create(final ExecutionContext ctx, final String... extFile) {
		ExecutionContext _ctx = ctx;
		if (extFile.length > 0) {
			_ctx = _ctx.cloneWithResource(new Resource() {

				public String getFullyQualifiedName() {
					return null;
				}

				public void setFullyQualifiedName(final String fqn) {
					// ignore
				}

				public String[] getImportedNamespaces() {
					return null;
				}

				public String[] getImportedExtensions() {
					return extFile;
				}
			});
		}
		return new XtendFacade(_ctx);
	}

	public Object call(final String ext, final Object... params) {
		Object[] _params = params != null ? params : new Object[] { null };
		final Extension extension = ctx.getExtension(ext, _params);
		if (extension == null) {
			throw new IllegalArgumentException("Couldn't find extension " + ext);
		}
		return extension.evaluate(_params, ctx);
	}

	public Object call(final String ext, final List<?> params) {
		Object[] paramsArray = new Object[params.size()];
		paramsArray = params.toArray(paramsArray);
		final Extension extension = ctx.getExtension(ext, paramsArray);
		if (extension == null) {
			throw new IllegalArgumentException("Couldn't find extension " + ext);
		}
		return extension.evaluate(paramsArray, ctx);
	}

	public boolean hasExtension(final String ext, final Object[] paramsArray) {
		final Extension extension = ctx.getExtension(ext, paramsArray);
		return extension != null;
	}

	public boolean hasExtension(final String ext, final List<?> params) {
		Object[] paramsArray = new Object[params.size()];
		paramsArray = params.toArray(paramsArray);
		return hasExtension(ext, paramsArray);
	}

	public Type analyze(final String string, final Object[] objects, final Set<AnalysationIssue> issues) {
		Object[] _objects = objects != null ? objects : new Object[0];

		final Extension extension = ctx.getExtension(string, _objects);
		final Type[] params = new Type[_objects.length];
		for (int i = 0; i < params.length; i++) {
			params[i] = ctx.getType(_objects[i]);
		}
		return ctx.getReturnType(extension, params, issues);
	}
}
