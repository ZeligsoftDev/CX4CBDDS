package com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwConnector;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwCommunicationMediumImplementation;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwCommunicationEndPoint;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class HwConnectorImplementation extends
		HwCommunicationMediumImplementation implements HwConnector {
	protected java.util.List<HwCommunicationEndPoint> _end;

	public HwConnectorImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<HwCommunicationEndPoint> getEnd() {
		if (_end == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_HwPlatform::HwConnector",
							"end");
			_end = new java.util.ArrayList<HwCommunicationEndPoint>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					HwCommunicationEndPoint nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									HwCommunicationEndPoint.class);
					_end.add(nextWrapper);
				}
			}
		}
		return _end;
	}

	@Override
	public void addEnd(HwCommunicationEndPoint val) {
		// make sure the end list is created
		getEnd();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_HwPlatform::HwConnector", "end");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_end != null) {
			_end.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Connector asConnector() {
		return (org.eclipse.uml2.uml.Connector) eObject();
	}
}
