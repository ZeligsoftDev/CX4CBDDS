package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPPackageHandler extends AbstractKryoHandler {

	private void setNestedElements(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> nestedElements) {
		this.getterValues.put("getNestedElements", nestedElements);
	}

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setIsReferenceUnit(int value) {
		this.getterValues.put("isReferenceUnit", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Package");
		setGetName(input.readString());
		setIsReferenceUnit(input.readVarInt(true));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> nestedElements = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setNestedElements(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(nestedElements));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));
		}
	}