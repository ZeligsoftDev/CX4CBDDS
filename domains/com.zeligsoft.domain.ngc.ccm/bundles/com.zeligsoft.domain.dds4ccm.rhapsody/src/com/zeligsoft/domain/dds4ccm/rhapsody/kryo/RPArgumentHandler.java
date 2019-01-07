package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPArgumentHandler extends AbstractKryoHandler {

	private void setAllTags(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> allTags) {
		this.getterValues.put("getAllTags", allTags);
	}

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetType(Object value) {
		this.getterValues.put("getType", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Argument");
		setGetName(input.readString());
		setGetType(kryo.readClassAndObject(input));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> allTags = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAllTags(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(allTags));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));
		}
	}