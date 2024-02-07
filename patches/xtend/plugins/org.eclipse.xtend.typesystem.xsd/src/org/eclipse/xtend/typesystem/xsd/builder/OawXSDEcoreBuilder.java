/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.builder;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OawXSDEcoreBuilder extends XSDEcoreBuilder {
	protected Logger log = XSDLog.getLog(getClass());

	public OawXSDEcoreBuilder(ExtendedMetaData extendedMetaData) {
		super(extendedMetaData);
	}

	private String checkAttribute(XSDConcreteComponent comp, String attr,
			String val) {
		if ("package".equals(attr)) {
			if (val.contains("."))
				return val.substring(val.lastIndexOf(".") + 1);
		}
		return val;
	}

	public void copy(OawXSDEcoreBuilder b) {
		xsdSchemas.addAll(b.xsdSchemas);
		xsdComponentToEModelElementMap.putAll(b.xsdComponentToEModelElementMap);
		targetNamespaceToEPackageMap.putAll(b.targetNamespaceToEPackageMap);
		eReferenceToKeyNamesMap.putAll(b.eReferenceToKeyNamesMap);
		eReferenceToOppositeNameMap.putAll(b.eReferenceToOppositeNameMap);
		typeToTypeObjectMap.putAll(b.typeToTypeObjectMap);
	}

	@Override
	public void generate(XSDSchema xsdSchema) {
		super.generate(xsdSchema);
	}

	private String getCustomAttribute(XSDConcreteComponent comp, String attr) {
		if ("documentRoot".equals(attr)) {
			String pkg = getPkgName(comp);
			if (pkg != null && !"".equals(pkg)) {
				pkg = pkg.substring(0, 1).toUpperCase() + pkg.substring(1);
				return pkg + "DocumentRoot";
			}
		}
		return null;
	}

	@Override
	protected String getEcoreAttribute(
			XSDConcreteComponent xsdConcreteComponent, String attribute) {
		String r = super.getEcoreAttribute(xsdConcreteComponent, attribute);
		if (r != null && !"".equals(r))
			return checkAttribute(xsdConcreteComponent, attribute, r);
		return getCustomAttribute(xsdConcreteComponent, attribute);
	}

	@Override
	public EPackage getEPackage(XSDNamedComponent xsdNamedComponent) {
		XSDSchema containingXSDSchema = xsdNamedComponent.getSchema();
		String targetNamespace = containingXSDSchema == null ? xsdNamedComponent
				.getTargetNamespace()
				: containingXSDSchema.getTargetNamespace();
		boolean isNew = targetNamespaceToEPackageMap.get(targetNamespace) == null;
		EPackage ePackage;
		ePackage = super.getEPackage(xsdNamedComponent);
		if (isNew)
			initEPackage(containingXSDSchema, ePackage);
		return ePackage;

	}

	protected boolean isUppercase(String str) {
		for (int i = 0; i < str.length(); i++)
			if (Character.isLowerCase(str.charAt(i)))
				return false;
		return true;
	}

	@Override
	protected String validName(String name, int casing, String prefix) {
		List<String> parsedName = parseName(name, '_');
		StringBuffer result = new StringBuffer();
		for (String nameComponent : parsedName) {
			if (nameComponent.length() > 0) {
				if (casing != UNCHANGED_CASE && isUppercase(nameComponent))
					nameComponent = nameComponent.toLowerCase();
				if (result.length() > 0 || casing == UPPER_CASE) {
					result.append(Character
							.toUpperCase(nameComponent.charAt(0)));
					result.append(nameComponent.substring(1));
				} else {
					result.append(nameComponent);
				}
			}
		}
		return result.length() == 0 ? prefix
				: Character.isJavaIdentifierStart(result.charAt(0)) ? casing == LOWER_CASE ? uncapName(result
						.toString())
						: result.toString()
						: prefix + result;
	}

	private String getPkgName(EObject obj) {
		if (obj.eResource() == null || obj.eResource().getURI() == null)
			return null;
		return validName(obj.eResource().getURI().trimFileExtension()
				.lastSegment(), false);
	}

	protected void initEPackage(XSDSchema schema, EPackage pkg) {
		if (schema.getTargetNamespace() != null
				&& !schema.getTargetNamespace().equals("")
				&& !schema.getTargetNamespace().equals(
						rootSchema.getTargetNamespace()))
			throw new RuntimeException(
					Msg
							.create(
									"The OawXSDEcoreBuilder has to be called for every EPackage explicitly. Schema:")
							.schema(schema).txt(" Root:").schema(rootSchema)
							.txt(" ").schemas(xsdSchemas).toString());
		String name = getPkgName(rootSchema);
		if (name != null)
			pkg.setName(name);

		OawXSDResource res = (OawXSDResource) rootSchema.eResource();
		res.setEcorePackage(pkg);

		log.info(Msg.create("Creating EPackage ").pkg(pkg.getName()).txt(
				" from ").schemaDeep(rootSchema));
	}

	@Override
	protected void resolveNameConflict(
			Map<String, ? extends ENamedElement> map,
			ENamedElement namedElement, String suffix) {

		String name = namedElement.getName();
		if (!name.endsWith(suffix)) {
			name += suffix;
		}
		ENamedElement confl = map.get(name.toLowerCase());
		if (confl != null) {
			int index = 0;
			while (map.containsKey(name.toLowerCase() + ++index)) {
				// just incrementing index
			}
			namedElement.setName(name + index);
			Msg m = Msg.create("Name Conflict: Created ")
					.sclsname(namedElement).txt(", ").sclsname(confl).txt(
							" is in the way.");
			if (confl.eContainer() == namedElement.eContainer())
				m = m.txt(" Container:").path(confl.eContainer());
			else
				m = m.txt(" Container1:").path(confl.eContainer()).txt(
						", Container2:").path(namedElement.eContainer());
			log.warn(m);
		} else {
			namedElement.setName(name);
		}
	}
}