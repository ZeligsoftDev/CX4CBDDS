package com.zeligsoft.domain.omg.corba.api.IDLFileSupport.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLFile;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamespaceImplementation;

import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLImport;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class IDLFileImplementation extends NamespaceImplementation implements
		IDLFile {
	protected java.util.List<CORBAModuleContained> _contents;
	protected java.util.List<IDLImport> _importee;

	public IDLFileImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getLocation() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDLFileSupport::IDLFile", "location");
		return (String) rawValue;
	}

	@Override
	public void setLocation(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDLFileSupport::IDLFile",
				"location", val);
	}

	@Override
	public java.util.List<CORBAModuleContained> getContents() {
		if (_contents == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CORBADomain::IDLFileSupport::IDLFile", "contents");
			_contents = new java.util.ArrayList<CORBAModuleContained>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBAModuleContained nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBAModuleContained.class);
					_contents.add(nextWrapper);
				}
			}
		}
		return _contents;
	}

	@Override
	public void addContents(CORBAModuleContained val) {
		// make sure the contents list is created
		getContents();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDLFileSupport::IDLFile", "contents");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_contents != null) {
			_contents.add(val);
		}
	}

	@Override
	public java.util.List<IDLImport> getImportee() {
		if (_importee == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CORBADomain::IDLFileSupport::IDLFile", "importee");
			_importee = new java.util.ArrayList<IDLImport>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					IDLImport nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next,
							IDLImport.class);
					_importee.add(nextWrapper);
				}
			}
		}
		return _importee;
	}

	@Override
	public void addImportee(IDLImport val) {
		// make sure the importee list is created
		getImportee();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDLFileSupport::IDLFile", "importee");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_importee != null) {
			_importee.add(val);
		}
	}

	@Override
	public String getPrefix() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDLFileSupport::IDLFile", "prefix");
		return (String) rawValue;
	}

	@Override
	public void setPrefix(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDLFileSupport::IDLFile",
				"prefix", val);
	}

	@Override
	public org.eclipse.uml2.uml.Package asPackage() {
		return (org.eclipse.uml2.uml.Package) eObject();
	}
}
