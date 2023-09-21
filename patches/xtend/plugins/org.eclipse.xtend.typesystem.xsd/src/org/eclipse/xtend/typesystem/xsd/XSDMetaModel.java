/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.internal.xtend.util.Cache;
import org.eclipse.xtend.type.impl.java.JavaTypeImpl;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EClassType;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtend.typesystem.xsd.builder.OawXSDResourceSet;
import org.eclipse.xtend.typesystem.xsd.builder.XSDManager;
import org.eclipse.xtend.typesystem.xsd.type.EFeatureMapEntryTypeImpl;
import org.eclipse.xtend.typesystem.xsd.type.EFeatureMapTypeImpl;
import org.eclipse.xtend.typesystem.xsd.type.EFeatureType;
import org.eclipse.xtend.typesystem.xsd.type.EMapEntryType;
import org.eclipse.xtend.typesystem.xsd.type.EMapType;
import org.eclipse.xtend.typesystem.xsd.type.QNameType;
import org.eclipse.xtend.typesystem.xsd.type.XMLEClassType;
import org.eclipse.xtend.typesystem.xsd.type.XMLFeatureMapTypeImpl;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XSDMetaModel extends EmfRegistryMetaModel {

	public final static String EFEATURE = "EFeature";
	private final static String EFEATURE_MAP = "XMLFeatureMap";
	public static final String EFEATURE_MAP_ENTRY = "EFeatureMapEntry";
	private final static String EMAP = "EMap";
	private final static String EMAP_ENTRY = "EMapEntry";

	private Cache<EClassifier, EMapType> eMapCache = new Cache<EClassifier, EMapType>() {
		@Override
		protected EMapType createNew(EClassifier c) {
			return new EMapType(XSDMetaModel.this, EMAP, c);
		}
	};

	private Cache<EClass, XMLFeatureMapTypeImpl> featueMapCache = new Cache<EClass, XMLFeatureMapTypeImpl>() {
		@Override
		protected XMLFeatureMapTypeImpl createNew(EClass c) {
			return new XMLFeatureMapTypeImpl(XSDMetaModel.this, EFEATURE_MAP, c);
		}
	};

	private EFeatureMapEntryTypeImpl featureMapEntry;

	private EFeatureType featureType;

	private boolean registerPackagesGlobally = false;

	protected Logger log = XSDLog.getLog(getClass());
	
	protected String id;

	private Cache<EClassifier, EMapEntryType> mapEntryCache = new Cache<EClassifier, EMapEntryType>() {
		@Override
		protected EMapEntryType createNew(EClassifier arg0) {
			return new EMapEntryType(getTypeSystem(), EMAP_ENTRY, arg0);
		}
	};

	private QNameType qnameType;

	private Cache<EClassType, XMLEClassType> xmlClassCache = new Cache<EClassType, XMLEClassType>() {
		@Override
		protected XMLEClassType createNew(EClassType arg0) {
			try {
				// this is due to a lack of accessibility of the
				// EmfRegistryMetaModel
				Field f = arg0.getClass().getDeclaredField("eClass");
				f.setAccessible(true);
				EClass cls = (EClass) f.get(arg0);
				return new XMLEClassType(XSDMetaModel.this, arg0.getName(), cls);
			} catch (Exception e) {
				throw new RuntimeException(e);
				// e.printStackTrace();
			}
		}
	};

	private XSDManager xsdManager;

	protected Set<EPackage> savedPackages = new HashSet<EPackage>();

	protected String savePackagesPath = null;

	public XSDMetaModel() {
		super();
		xsdManager = new OawXSDResourceSet();
	}

	// this clones an XSDMetaModel and thereby empties all type-caches.
	public XSDMetaModel(XSDManager manager) {
		super();
		xsdManager = manager;
	}

	public void addSchemaFile(String uri) {
		log.info(Msg.create("Loading XSDSchema from ").uri(uri));
		xsdManager.loadAndGenerate(EcoreUtil2.getURI(uri));
		registerNewPackages();
		saveNewPackages();
	}

	@Override
	public EPackage[] allPackages() {
		Collection<EPackage> pkgs = new ArrayList<EPackage>(xsdManager
				.getPackages());
		for (Object o : EPackage.Registry.INSTANCE.values())
			if (o instanceof EPackage)
				pkgs.add((EPackage) o);
		return pkgs.toArray(new EPackage[pkgs.size()]);
	}

	public EFeatureMapEntryTypeImpl getEFeatureMapEntryType() {
		if (featureMapEntry == null)
			featureMapEntry = new EFeatureMapEntryTypeImpl(this,
					EFEATURE_MAP_ENTRY);
		return featureMapEntry;
	}

	public XMLFeatureMapTypeImpl getEFeatureMapType(EClass aClass) {
		return featueMapCache.get(aClass);
	}

	public EFeatureType getEFeatureType() {
		if (featureType == null)
			featureType = new EFeatureType(getTypeSystem(), EFEATURE);
		return featureType;
	}

	public EMapEntryType getEMapEntryType(EClassifier innerType) {
		return mapEntryCache.get(innerType);
	}

	public EMapType getEMapType(EClassifier innerType) {
		return eMapCache.get(innerType);
	}

	@Override
	public Set<Type> getKnownTypes() {
		Set<Type> r = super.getKnownTypes();
		// log.info("getKnownTypes() -> " + r);
		return r;
	}

	public QNameType getQNameType() {
		// TODO: resolve the package name dynamically
		if (qnameType == null)
			qnameType = new QNameType(getTypeSystem(), "type::QName");
		return qnameType;
	}

	@Override
	public Type getType(Object obj) {
		Type r = null;
		if (obj instanceof FeatureMap) {
			FeatureMap m = (FeatureMap) obj;
			EClass c = ((Setting) m).getEObject().eClass();
			r = getEFeatureMapType(c);
		} else if (obj instanceof FeatureMap.Entry) {
			r = getEFeatureMapEntryType();
		} else if (obj instanceof EStructuralFeature) {
			r = getEFeatureType();
		} else if (EMapType.isEMapObject(obj)) {
			EClassifier c = ((Setting) obj).getEStructuralFeature().getEType();
			r = getEMapType(c);
		} else if (EMapEntryType.isEMapEntryObject(obj)) {
			EClassifier i = (obj instanceof EObject) ? ((EObject) obj).eClass()
					: null;
			r = getEMapEntryType(i);
		} else if (obj instanceof QName) {
			r = getQNameType();
		} else
			r = super.getType(obj);
		// log.info("getType(" + obj.getClass() + ") -> " + r);
		return r;
	}

	@Override
	public Type getTypeForEClassifier(EClassifier element) {
		Type r = super.getTypeForEClassifier(element);
		if (r == null || r instanceof JavaTypeImpl)
			r = XMLTypeMapper.instance().get(this, element, getTypeSystem());
		else if (r instanceof EClassType)
			r = xmlClassCache.get((EClassType) r);
		// log.info("getTypeForEClassifier(" + element.getName() + ") -> " + r);
		return r;
	}

	@Override
	public Type getTypeForETypedElement(final ETypedElement typedElement) {
		EClassifier c = typedElement.getEType();
		if (c == null)
			return getTypeSystem().getVoidType();

		if (EFeatureMapTypeImpl.isFeatureMap(typedElement))
			return getEFeatureMapType((EClass) typedElement.eContainer());

		if (EMapType.isEMap(typedElement))
			return getEMapType(typedElement.getEType());

		if (EMapEntryType.isEMapEntry(typedElement))
			return getEMapEntryType(typedElement.getEType());

		// TODO: Handle EGenericTypes, like EmfRegistryMetaModel does.
		Type t = getTypeForEClassifier(typedElement.getEType());
		if (typedElement.isMany()) {
			// TODO: use EmfListType
			return getTypeSystem().getListType(t);
		} else {
			return t;
		}
	}

	@Override
	public Type getTypeForName(String typeName) {
		// TODO: make sure type-package is loaded instead of checking manually
		Type r;
		if (getQNameType().getName().equals(typeName)
		/* || "QName".equals(typeName) */)
			r = getQNameType();
		else if (EMAP_ENTRY.equals(typeName))
			r = getEMapEntryType(null);
		else if (EFEATURE_MAP.equals(typeName))
			r = getEFeatureMapType(null);
		else if (EFEATURE_MAP_ENTRY.equals(typeName))
			r = getEFeatureMapEntryType();
		else if (EFEATURE.equals(typeName))
			r = getEFeatureType();
		else {
			r = super.getTypeForName(typeName);
			if (r instanceof EClassType)
				r = xmlClassCache.get((EClassType) r);
		}
		// log.info("getTypeForName(" + typeName + ") -> " + r);
		return r;
	}

	public XSDManager getXsdManager() {
		return xsdManager;
	}
	public boolean isRegisterPackagesGlobally() {
		return registerPackagesGlobally;
	}

	public boolean isSaveEPackages() {
		return savePackagesPath != null;
	}

	protected void registerNewPackages() {
		if (!isRegisterPackagesGlobally())
			return;
		EPackage.Registry reg = EPackage.Registry.INSTANCE;
		for (EPackage pkg : xsdManager.getPackages())
			if (!reg.containsKey(pkg.getNsURI())) {
				log.info(Msg.create("Registering ").pkg(pkg).txt(" globally."));
				reg.put(pkg.getNsURI(), pkg);
			}
	}

	protected void saveNewPackages() {
		if (!isSaveEPackages())
			return;
		for (EPackage pkg : xsdManager.getPackages())
			if (!savedPackages.contains(pkg)) {
				savedPackages.add(pkg);
				URI u = URI.createURI(savePackagesPath + "/" + pkg.getName()
						+ ".ecore");
				log.info(Msg.create("Saving ").pkg(pkg).txt(" to ").uri(u));
				XMIResource r = new XMIResourceImpl(u);
				r.getContents().add(EcoreUtil.copy(pkg));
				try {
					r.save(new HashMap<String, String>());
				} catch (IOException e) {
					log.error(Msg.create("Error saving ").uri(u), e);
				}
			}
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}

	// public void loadFromStream(InputStream stream, URI uri) throws
	// IOException {
	// if (uri == null)
	// log.info("URI is null");
	// OawXSDResource res = xsdResources.getXsdResource(uri, false);
	// if (res == null)
	// res = xsdResources.createXsdResource(uri);
	// // if (res.isLoaded()
	// // && (tsMap.get(res) == null || tsMap.get(res) <
	// // modificationTimestamp)) {
	// // log.info("unloading: " + uri);
	// // res.unload();
	// // }
	// if (!res.isLoaded()) {
	// res.load(stream, Collections.EMPTY_MAP);
	// // tsMap.put(res, modificationTimestamp);
	// }
	// // for (EObject obj : res.getContents())
	// // if (obj instanceof XSDSchema)
	// // builder.generate((XSDSchema) obj);
	// res.generateECore();
	// }

	// private void logUnresolvedSchemaReferences(XSDSchema schema) {
	// for (XSDSchemaContent content : schema.getContents()) {
	// if (content instanceof XSDSchemaDirective) {
	// XSDSchemaDirective directive = (XSDSchemaDirective) content;
	// if (directive.getResolvedSchema() == null) {
	// String loc = directive.getSchemaLocation();
	// if (directive instanceof XSDImport) {
	// XSDImport imp = (XSDImport) directive;
	// log.warn(Msg
	// .create("Unresolved import-schemaLocation ")
	// .uri(loc).txt(" (").ns(imp.getNamespace()).txt(
	// ") in ").schema(schema));
	// } else if (directive instanceof XSDInclude) {
	// log.warn(Msg.create(
	// "Unresolved include-schemaLocation ").uri(loc)
	// .txt(" in ").schema(schema));
	// } else if (directive instanceof XSDRedefine) {
	// log.warn(Msg.create(
	// "Unresolved redefine-schemaLocation ").uri(loc)
	// .txt(" in ").schema(schema));
	// }
	// }
	// }
	// }
	// }

	public void setRegisterPackagesGlobally(boolean registerPackagesGlobally) {
		this.registerPackagesGlobally = registerPackagesGlobally;
		registerNewPackages();
	}

	public void setSavePackagesPath(String path) {
		savePackagesPath = path;
		saveNewPackages();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + xsdManager;
	}

}