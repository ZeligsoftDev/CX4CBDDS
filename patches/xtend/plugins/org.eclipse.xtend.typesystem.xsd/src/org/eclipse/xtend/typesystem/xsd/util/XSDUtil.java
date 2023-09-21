/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XSDUtil {
	// private static boolean buildRefPath(List<XSDSchemaDirective> list,
	// XSDSchema root, XSDSchema child) {
	// for (XSDSchemaDirective s : child.getReferencingDirectives()) {
	// list.add(s);
	// if (s.getSchema() == root)
	// return true;
	// if (buildRefPath(list, root, s.getSchema()))
	// return true;
	// list.remove(list.size() - 1);
	// }
	// return false;
	// }

	public static URI strToURI(String str) {
		// absolute local path on unix
		if (str.length() > 0 && str.charAt(0) == '/')
			return URI.createFileURI(str);

		// absolute local path on windows
		if (str.length() > 1 && str.charAt(1) == ':')
			return URI.createFileURI(str);

		return URI.createURI(str);
	}

	public static URI deresolve(URI base, URI uri) {
		if (base.equals(uri))
			return uri;
		if (base.isRelative())
			base = EcoreUtil2.getURI(base.toString());
		if (base.isRelative())
			base = URI.createFileURI(base.toString());
		try {
			return uri.deresolve(base);
		} catch (IllegalStateException e) {
			return uri;
		}
	}

	public static boolean exists(URIConverter conv, URI uri) {
		try {
			InputStream s = conv.createInputStream(uri);
			s.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public static URI resolve(URIConverter conv, URI base, String uri) {
		URI r = null;
		base = conv.normalize(base);
		if (base.isHierarchical() && !base.isRelative()) {
			URI u = URI.createURI(uri).resolve(base);
			if (exists(conv, u)) {
				r = u;
				// log.info(Msg.create("Resolved by base: ").uri(uri).txt(" to
				// ")
				// .uri(r).txt(" base:").uri(base));

			}
		}
		if (r == null) {
			r = EcoreUtil2.getURI(uri);
			// log.info(Msg.create("Resolved by getURI: ").uri(uri).txt(" to ")
			// .uri(r).txt(" base:").uri(base));
		}
		return r;
	}

	// private static Logger log = XSDLog.getLog(XSDUtil.class);

	public static URI resolve(Resource res, String uri) {
		return resolve(res.getResourceSet().getURIConverter(), res.getURI(),
				uri);
	}

	// public static List<XSDSchema> findReferencingSchemas(
	// Collection<XSDSchema> xsdSchemas, XSDSchema schema) {
	// ArrayList<XSDSchema> r = new ArrayList<XSDSchema>();
	// for (XSDSchema s : xsdSchemas)
	// if (referencesSchema(s, schema))
	// r.add(s);
	// return r;
	// }
	//
	// public static XSDSchema findRootCompositingSchema(XSDSchema root,
	// XSDSchema schema) {
	// if (root == schema)
	// return root;
	// ArrayList<XSDSchemaDirective> path = new ArrayList<XSDSchemaDirective>();
	// if (!buildRefPath(path, root, schema))
	// throw new RuntimeException(Msg.create("Compositing Root for ")
	// .schema(schema).txt(" not found").toString());
	// for (XSDSchemaDirective s : path) {
	// if (s instanceof XSDSchemaCompositor)
	// schema = s.getSchema();
	// else
	// return schema;
	// }
	// return schema;
	// }
	//
	// public static boolean referencesSchema(XSDSchema parent, XSDSchema child)
	// {
	// if (parent == null)
	// return false;
	// for (XSDSchemaContent c : parent.getContents())
	// if (c instanceof XSDSchemaCompositor) {
	// XSDSchema r = ((XSDSchemaCompositor) c).getResolvedSchema();
	// if (child == r || referencesSchema(r, child))
	// return true;
	// }
	// return false;
	// }

}
