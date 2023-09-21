/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.util;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaCompositor;
import org.eclipse.xsd.XSDSchemaContent;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Msg {

	public static Msg create(String msg) {
		Msg log = new Msg();
		log.txt(msg);
		return log;
	}

	private URI base = URI.createFileURI(new File(".").getAbsolutePath());

	private StringBuffer msg = new StringBuffer();

	private Msg() {
	}

	protected Msg collectIncludedSchemas(Set<XSDSchema> recursion,
			XSDSchema schema, URI uri) {
		if (recursion.contains(schema))
			return txt("<recursion!:").schema(schema).txt(">");
		recursion.add(schema);
		int i = 0;
		for (XSDSchemaContent c : schema.getContents())
			if (c instanceof XSDSchemaCompositor) {
				XSDSchema r = ((XSDSchemaCompositor) c).getResolvedSchema();
				if (r != null) {
					if (i == 0)
						txt("[");
					if (i == 1)
						txt(",");
					i++;
					if (r.eResource() != null && r.eResource().getURI() != null) {
						URI u = r.eResource().getURI();
						txt(XSDUtil.deresolve(uri, u).toString());
						collectIncludedSchemas(
								new HashSet<XSDSchema>(recursion), r, u);
					} else {
						txt("(unknown uri)");
						collectIncludedSchemas(
								new HashSet<XSDSchema>(recursion), r, uri);
					}
				}
			}
		if (i > 0)
			txt("]");
		return this;
	}

	public Msg diag(Resource.Diagnostic diag) {
		if (diag == null)
			return txt("(diagnostic is null)");
		Msg u;
		try {
			u = Msg.create("").uri(URI.createURI(diag.getLocation()));
		} catch (Exception e) {
			u = Msg.create(diag.getLocation());
		}
		return txt(diag.getMessage()).txt(" ").txt(u).txt("[")
				.i(diag.getLine()).txt(",").i(diag.getColumn()).txt("]");
	}

	public Msg diag(XSDDiagnostic diag) {
		return diag((Resource.Diagnostic) diag).txt(" primaryComponent:").path(
				diag.getPrimaryComponent());
	}

	public Msg err(Throwable err) {
		if (err == null)
			return txt("(throwable is null)");
		return txt(err.getMessage());
	}

	public Msg i(int m) {
		msg.append(m);
		return this;
	}

	public Msg ns(String ns) {
		return txt(ns);
	}

	public Msg ns(URI ns) {
		return ns(ns.toString());
	}

	public Msg path(EObject o) {
		if (o instanceof XSDParticle && ((XSDParticle) o).getContent() != null)
			o = ((XSDParticle) o).getContent();
		path2(o);
		return this;
	}

	private Msg path2(EObject o) {
		if (o == null)
			return txt("(o is null)");
		if (o.eContainer() != null)
			return path2(o.eContainer()).txt("/").pathItem(o);
		else
			return txt("/").pathItem(o);
	}

	private Msg pathItem(EObject ele) {
		if (ele instanceof XSDSchema && ele.eResource() != null
				&& ele.eResource().getURI() != null)
			return txt(ele.eResource().getURI().lastSegment());
		if (ele instanceof ENamedElement)
			return scls(ele).txt("'").txt(((ENamedElement) ele).getName()).txt(
					"'");
		if (ele instanceof XSDNamedComponent)
			return scls(ele).txt("'").txt(((XSDNamedComponent) ele).getName())
					.txt("'");
		return scls(ele);
	}

	public Msg pkg(EPackage p) {
		return txt("EPackage ").pkg(p.getName()).txt(" (" + p.getNsURI() + ")");
	}

	public Msg pkg(String name) {
		return txt("'" + name + "'");
	}

	public Msg schema(XSDSchema s) {
		return txt("XSDSchema ").uri(s)
				.txt(" (" + s.getTargetNamespace() + ")");
	}

	public Msg schemaDeep(XSDSchema s) {
		if (s == null)
			return txt("(schema is null)");
		return txt("XSDSchema ").uri(s).collectIncludedSchemas(
				new HashSet<XSDSchema>(), s, s.eResource().getURI()).txt(
				" (" + s.getTargetNamespace() + ")");

	}

	public Msg schemas(Collection<XSDSchema> s) {
		if (s == null)
			return txt("(schemas are null)");
		if (s.size() == 0)
			return txt("(none)");
		txt("XSDSchemas: ");
		boolean first = true;
		for (XSDSchema o : s) {
			if (first)
				first = false;
			else
				txt(", ");
			uri(o).txt(" (" + o.getTargetNamespace() + ")");
		}
		return this;
	}

	public Msg scls(EClass cls) {
		if (cls == null)
			return scls("(class is null)");
		return scls(cls.getName());
	}

	public Msg scls(EObject obj) {
		if (obj == null)
			return scls("(obj is null)");
		return scls(obj.eClass());
	}

	public Msg scls(Object obj) {
		if (obj == null)
			return scls("(obj is null)");
		return scls(obj.getClass().getSimpleName());
	}

	public Msg scls(String txt) {
		return txt(txt);
	}

	public Msg sclsname(EObject ele) {
		if (ele == null)
			return txt("(ele is null)");
		if (ele instanceof ENamedElement)
			return scls(ele).txt(" '").txt(((ENamedElement) ele).getName())
					.txt("'");
		return scls(ele);
	}

	@Override
	public String toString() {
		return msg.toString();
	}

	public Msg txt(Msg m) {
		msg.append(m.msg);
		return this;
	}

	public Msg txt(String msg) {
		this.msg.append(msg);
		return this;
	}

	public Msg uri(EObject obj) {
		if (obj == null)
			return txt("(obj is null)");
		return uri(obj.eResource());
	}

	public Msg uri(Resource res) {
		if (res == null)
			return uri("(resource is null)");
		if (res.getURI() == null)
			return uri("(resource uri is null)");
		return uri(res.getURI());
	}

	public Msg uri(String uri) {
		return txt("'" + uri + "'");
	}

	public Msg uri(URI uri) {
		if (uri == null)
			return uri("(uri is null)");
		if (uri.scheme() == null || uri.scheme().equals(""))
			uri = URI.createFileURI(uri.toString());
		if (uri.isRelative())
			return uri(uri.toString());
		URI res = uri.deresolve(base);
		if (res == uri)
			return uri(uri.toString());
		return uri("file:/.../" + res.toString());
	}

	public Msg uris(Collection<?> uris) {
		if (uris == null)
			return txt("(uris are null)");
		if (uris.size() == 0)
			return txt("(none)");
		boolean first = true;
		for (Object o : uris) {
			if (first)
				first = false;
			else
				txt(", ");
			if (o instanceof URI)
				uri((URI) o);
			else if (o instanceof EObject)
				uri((EObject) o);
			else
				uri(o.toString());
		}
		return this;
	}
}
