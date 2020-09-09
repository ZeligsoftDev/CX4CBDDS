package com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.IDL3File;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Artifacts.IDL3FileImport;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class IDL3FileImplementation extends NamedElementImplementation implements IDL3File {
	protected java.util.List<IDL3FileImport> _contents;

	public IDL3FileImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<IDL3FileImport> getContents() {
		if (_contents == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Artifacts::IDL3File", "contents");
			_contents = new java.util.ArrayList<IDL3FileImport>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					IDL3FileImport nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next, IDL3FileImport.class);
					_contents.add(nextWrapper);
				}
			}
		}
		return _contents;
	}

	@Override
	public void addContents(IDL3FileImport val) {
		// make sure the contents list is created
		getContents();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Artifacts::IDL3File", "contents");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_contents != null) {
			_contents.add(val);
		}
	}

	@Override
	public <T extends IDL3FileImport> T addContents(Class<T> typeToCreate, String concept) {
		// make sure the contents list is created
		getContents();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Artifacts::IDL3File",
				"contents", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_contents != null) {
			_contents.add(element);
		}
		return element;
	}

	@Override
	public IDL3FileImport addContents() {
		// make sure the contents list is created
		getContents();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Artifacts::IDL3File",
				"contents", "CCM::CCM_Artifacts::IDL3FileImport");
		IDL3FileImport element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				IDL3FileImport.class);
		if (_contents != null) {
			_contents.add(element);
		}
		return element;
	}

	@Override
	public String getLocation() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Artifacts::IDL3File",
				"location");
		return (String) rawValue;
	}

	@Override
	public void setLocation(String val) {
		ZDLUtil.setValue(element, "CCM::CCM_Artifacts::IDL3File", "location", val);
	}

	@Override
	public org.eclipse.uml2.uml.Artifact asArtifact() {
		return (org.eclipse.uml2.uml.Artifact) eObject();
	}
}
