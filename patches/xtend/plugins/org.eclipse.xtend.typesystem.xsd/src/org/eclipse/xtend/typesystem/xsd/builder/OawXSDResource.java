/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaCompositor;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.XSDSchemaDirective;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;
import org.xml.sax.InputSource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OawXSDResource extends XSDResourceImpl {

	public static class OawXSDResourceFactory extends ResourceFactoryImpl {
		@Override
		public Resource createResource(URI uri) {
			return new OawXSDResource(uri);
		}
	}

	protected OawXSDEcoreBuilder builder;

	private EPackage ePackage = null;

	private boolean fileDirty = true;

	private boolean generatePackage = false;

	protected Logger log = XSDLog.getLog(getClass());

	private boolean schemaDirty = true;

	public OawXSDResource(URI uri) {
		super(uri);
	}

	private void collectImportedSchemas(Set<OawXSDResource> visited,
			List<OawXSDResource> list) {
		if (visited.contains(this) || getSchema() == null)
			return;
		visited.add(this);
		for (XSDSchemaContent c : getSchema().getContents())
			if (c instanceof XSDSchemaDirective) {
				XSDSchema s = ((XSDSchemaDirective) c).getResolvedSchema();
				if (s != null) {
					OawXSDResource res = (OawXSDResource) s.eResource();
					if (c instanceof XSDImport)
						list.add(res);
					else if (c instanceof XSDSchemaCompositor)
						res.collectImportedSchemas(visited, list);
				} else
					log.warn(Msg.create("Include ").path(c).txt(" ").uri(
							((XSDSchemaDirective) c).getSchemaLocation()).txt(
							" has not been " + "resolved. ")
							.schema(getSchema()));
			}
	}

	public void collectPackages(Set<EPackage> pkgs, Set<OawXSDResource> res) {
		if (res.contains(this))
			return;
		res.add(this);
		if (ePackage != null)
			pkgs.add(ePackage);
		for (OawXSDResource r : findImportedSchemas())
			r.collectPackages(pkgs,res);
	}

	@Override
	protected void doLoad(InputSource inputSource, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputSource, options);
		// log.info(Msg.create("Loading ").uri(this));
		fileDirty = false;
		resolveImports();
		markSchemaDirty();
		logDiagnostics(getSchema());
		logResDiagnostics();
	}

	@Override
	protected void doUnload() {
		log.info(Msg.create("Unloading ").schema(getSchema()));
		unloadReferrencingDirectives();
		// getResourceSet().builder.unload(getSchema());
		super.doUnload();
		unloadPackage();
	}

	protected List<OawXSDResource> findImportedSchemas() {
		ArrayList<OawXSDResource> list = new ArrayList<OawXSDResource>();
		collectImportedSchemas(new HashSet<OawXSDResource>(), list);
		return list;
	}

	protected List<OawXSDResource> findReferencingSchemas() {
		if (getSchema() == null)
			return Collections.emptyList();
		ArrayList<OawXSDResource> r = new ArrayList<OawXSDResource>();
		for (XSDSchemaDirective s : getSchema().getReferencingDirectives())
			r.add((OawXSDResource) s.eResource());
		return r;
	}

	public OawXSDEcoreBuilder generateECore() {
		if (builder != null)
			return builder;
		// log.info(Msg.create("Generating ").schemaDeep(getSchema()));
		builder = new OawXSDEcoreBuilder(getResourceSet().extendedMetadata);
		for (OawXSDResource r : findImportedSchemas())
			builder.copy(r.generateECore());
		if (getSchema() == null) {
			log.error(Msg.create("Schema of file ").uri(this).txt(
					" has not yet been loaded, "
							+ "but the generating of EPackage "
							+ "has been requested."));
		} else {
			builder.generate(getSchema());
			logDiagnostics(getSchema());
		}
		return builder;
	}

	public EPackage getEPackage() {
		return ePackage;
	}

	@Override
	public OawXSDResourceSet getResourceSet() {
		return (OawXSDResourceSet) super.getResourceSet();
	}

	public boolean isEcorePackageGenerated() {
		return ePackage != null;
	}

	public boolean isFileDirty() {
		return fileDirty;
	}

	public boolean isGeneratePackage() {
		return generatePackage;
	}

	public boolean isSchemaDirty() {
		return schemaDirty;
	}

	private void logDiagnostics(XSDSchema schema) {
		if (schema.getAllDiagnostics().isEmpty())
			schema.validate();
		for (XSDDiagnostic d : schema.getAllDiagnostics()) {
			switch (d.getSeverity()) {
			case ERROR_LITERAL:
				log.error(Msg.create("XSDDiagnostic: ").diag(d));
				break;
			case FATAL_LITERAL:
				log.equals(Msg.create("FATAL: XSDDiagnostic: ").diag(d));
				break;
			case INFORMATION_LITERAL:
				log.info(Msg.create("XSDDiagnostic: ").diag(d));
				break;
			case WARNING_LITERAL:
				log.warn(Msg.create("XSDDiagnostic: ").diag(d));
				break;
			}
		}
		schema.clearDiagnostics();
	}

	private void logResDiagnostics() {
		for (Diagnostic d : getErrors())
			log.error(Msg.create("Diagnostic: ").diag(d));
		for (Diagnostic d : getWarnings())
			log.warn(Msg.create("Diagnostic: ").diag(d));
	}

	public void markFileDirty() {
		if (fileDirty)
			return;
		fileDirty = true;

		// mark all referencing schemas dirty, too
		for (OawXSDResource r : findReferencingSchemas())
			r.markFileDirty();
	}

	public void markSchemaDirty() {
		if (schemaDirty)
			return;
		schemaDirty = true;

		// mark all referencing schemas dirty, too
		for (OawXSDResource r : findReferencingSchemas())
			r.markSchemaDirty();
	}

	protected void resolveImports() {
		// make sure all imports are loaded
		for (Object content : getSchema().getContents())
			if (content instanceof XSDImport) {
				XSDImport imp = (XSDImport) content;
				imp.resolveTypeDefinition(imp.getNamespace(), "");
			}
	}

	public void setEcorePackage(EPackage pkg) {
		if (ePackage == pkg)
			return;
		if (ePackage != null)
			log.warn(Msg.create("Overwriting ").pkg(ePackage).txt(" with ")
					.pkg(pkg));
		ePackage = pkg;
		schemaDirty = false;
		String ns = (getSchema().getTargetNamespace() == null || getSchema()
				.getTargetNamespace().equals("")) ? null : pkg.getNsURI();
		getResourceSet().getPackageRegistry().put(ns, pkg);
	}

	public void setGeneratePackage(boolean generatePackage) {
		this.generatePackage = generatePackage;
	}

	public void unloadPackage() {
		getResourceSet().getPackageRegistry().remove(ePackage);
		ePackage = null;
		builder = null;
	}

	protected void unloadReferrencingDirectives() {
		XSDSchema s = getSchema();
		if (s == null)
			return;
		for (XSDSchemaContent c : s.getContents())
			if (c instanceof XSDSchemaDirective) {
				XSDSchemaDirective sd = (XSDSchemaDirective) c;
				if (sd.getResolvedSchema() != null)
					sd.getResolvedSchema().getReferencingDirectives()
							.remove(sd);
			}
	}
}