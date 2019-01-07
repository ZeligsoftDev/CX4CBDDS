package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPProjectHandler extends AbstractKryoHandler {

	private void setPackages(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> packages) {
		this.getterValues.put("getPackages", packages);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Project");

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> packages = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setPackages(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(packages));
		}
	}