/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.EcoreBuilder;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLOptions;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLOptionsImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.xtend.typesystem.xsd.builder.OawEcoreBuilder;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;
import org.eclipse.xtend.typesystem.xsd.util.XSDUtil;
import org.xml.sax.helpers.DefaultHandler;

/*
 * inspired by: org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceImpl
 * org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl
 */
/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OawXMLResource extends XMLResourceImpl {

	public final static String OPTION_DEFAULT_NAMESPACE = "DEFAULT_NAMESPACE";
	public final static String OPTION_NAMESPACE_MAP = "NAMESPACE_MAP";

	protected class OawSAXXMLHandler extends SAXXMLHandler {

		protected OawSAXXMLHandler(XMLResource xmlResource, XMLHelper helper,
				Map<?, ?> options) {
			super(xmlResource, helper, options);
			prepareOptions(options);
		}

		private String defaultNamespace;
		private Map<String, String> namespaceMap;

		@Override
		public void reset() {
			defaultNamespace = null;
			namespaceMap = null;
			super.reset();
		}

		@Override
		public void prepare(XMLResource resource, XMLHelper helper,
				Map<?, ?> options) {
			super.prepare(resource, helper, options);
			prepareOptions(options);
		}

		protected void prepareOptions(Map<?, ?> options) {
			String dns = (String) options.get(OPTION_DEFAULT_NAMESPACE);
			defaultNamespace = (dns != null && !dns.equals("")) ? dns : null;
			@SuppressWarnings("unchecked")
			Map<String, String> nsm = (Map<String,String>) options.get(OPTION_NAMESPACE_MAP);
			namespaceMap = nsm;
		}

		@Override
		public void startDocument() {
			super.startDocument();
			if (defaultNamespace != null)
				super.handleXMLNSAttribute("xmlns", defaultNamespace);
		}

		@Override
		protected void handleXMLNSAttribute(String attrib, String value) {
			String resolved = value;
			if (namespaceMap != null) {
				String ns = namespaceMap.get(value);
				while (ns != null) {
					resolved = ns;
					ns = namespaceMap.get(ns);
				}
			}
			if (!resolved.equals(value))
				log.info(Msg.create("Namespace Mapping: Using ").txt(attrib)
						.txt("=").ns(resolved).txt(" instead of ").ns(value)
						.txt(" for file ").uri(xmlResource.getURI()));
			super.handleXMLNSAttribute(attrib, resolved);
		}

		@Override
		protected EcoreBuilder createEcoreBuilder(Map<?, ?> options,
				ExtendedMetaData extendedMetaData) {
			return new OawEcoreBuilder(metaModel.getXsdManager());
			// metaModel.getBuilder().setExtendedMetaData(extendedMetaData);
			// return metaModel.getBuilder();
		}

		// protected EPackage handleMissingPackage(String uriString) {
		// EPackage p = super.handleMissingPackage(uriString);
		// log.warn("XSD file '" + uriString
		// + "' not found. Instantiated package " + p + " instead.");
		// return p;
		// }
	}

	public class OawUriHandler extends URIHandlerImpl {

//		private URI baseURI;

		@Override
		public URI resolve(URI uri) {
			return XSDUtil.resolve(OawXMLResource.this.getURIConverter(), baseURI, uri.toString());
			// URI u = super.resolve(uri);
			//
			// if (u != null && u.toFileString() != null) {
			// File f = new File(u.toFileString());
			// if (!f.exists())
			// u = EcoreUtil2.getURI(uri.toString());
			// }
			//
			// return u;
		}

		@Override
		public void setBaseURI(URI uri) {
//			baseURI = uri;
			super.setBaseURI(uri);

			// make sure that resolving is done for existing files, even it the
			// url claims to be relative.
			// if (!resolve) {
			// File f = new File(uri.toFileString());
			// if (f.exists())
			// super.setBaseURI(URI.createFileURI(f.getAbsolutePath()));
			// }
		}
	}

	protected class OawXMLLoadImpl extends XMLLoadImpl {
		protected OawXMLLoadImpl(XMLHelper helper) {
			super(helper);
		}

		@Override
		protected DefaultHandler makeDefaultHandler() {
			return new OawSAXXMLHandler(resource, helper, options);
		}
	}

	protected class OawXMLSaveImpl extends XMLSaveImpl {
		public OawXMLSaveImpl(XMLHelper helper) {
			super(helper);
		}

		private void tryCreateDocumentRoot(EObject obj) {
			EClass drClass = extendedMetaData.getDocumentRoot(obj.eClass()
					.getEPackage());

			// the object is already a DocumentRoot object
			if (drClass == obj.eClass())
				return;

			roots = Arrays.asList(obj);

			// this object's parent is a DocumentRoot object
			if (obj.eContainer() != null
					&& obj.eContainer().eClass() == drClass)
				return;

			// create a DocumentRoot object, look for an appropriate reference
			List<EReference> refs = new ArrayList<EReference>();
			for (EReference ref : drClass.getEReferences())
				if (ref.getEType() == obj.eClass())
					refs.add(ref);

			if (refs.size() < 1) {
				log.warn("The DocumentRoot class '" + drClass.getName()
						+ "' has no valid property (aka xsd "
						+ "element) to contain a '" + obj.eClass().getName()
						+ "' object. Therefore, no "
						+ "DocumentRoot object is created. "
						+ " You might want to add an element of type '"
						+ obj.eClass().getName()
						+ "' to your XML schema definition.");
				return;
			}

			EReference ref = refs.get(0);
			if (refs.size() > 1) {
				log.warn("The DocumentRoot class '" + drClass.getName()
						+ "' has more than one property (aka xsd "
						+ "element) to contain a '" + obj.eClass().getName()
						+ "' object. Therefore, the first property "
						+ "has been choosen ('" + ref.getName()
						+ "'). If this decision is not ok, you should "
						+ "supply the XMLWriter with an object of type '"
						+ drClass.getName() + "' rather than '"
						+ obj.eClass().getName() + "'.");
			}

			// create and set DocumentRoot

			log.info(Msg.create("Created ").scls(drClass).txt(" for ")
					.scls(obj));
			EObject docroot = EcoreUtil.create(drClass);
			docroot.eSet(ref, obj);
		}

		@Override
		protected Object writeTopObject(EObject top) {
			tryCreateDocumentRoot(top);
			return super.writeTopObject(top);
		}
	}

	protected Logger log = XSDLog.getLog(getClass());

	private XSDMetaModel metaModel;

	public OawXMLResource(URI uri, XSDMetaModel metaModel) {
		super(uri);
		this.metaModel = metaModel;
		setOptions();
	}

	@Override
	protected XMLLoad createXMLLoad() {
		return new OawXMLLoadImpl(createXMLHelper());
	}

	@Override
	protected XMLSave createXMLSave() {
		return new OawXMLSaveImpl(createXMLHelper());
	}

	public XSDMetaModel getMetaModel() {
		return metaModel;
	}

	protected void setOptions() {
		setEncoding("UTF-8");
		Map<Object, Object> load = getDefaultLoadOptions();
		Map<Object, Object> save = getDefaultSaveOptions();

		save.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		load.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		load.put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
		save.put(XMLResource.OPTION_LINE_WIDTH, new Integer(80));
		save.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		load.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		save.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		load.put(XMLResource.OPTION_URI_HANDLER, new OawUriHandler());
		XMLOptions xml = new XMLOptionsImpl();
		xml.setProcessAnyXML(true);
		xml.setProcessSchemaLocations(true);
		load.put(XMLResource.OPTION_XML_OPTIONS, xml);
	}
}
