package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPPortHandler extends AbstractKryoHandler {

	private void setAllTags(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> allTags) {
		this.getterValues.put("getAllTags", allTags);
	}

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setGetContract(Object value) {
		this.getterValues.put("getContract", value);
	}

	private void setGetFullPathName(String value) {
		this.getterValues.put("getFullPathName", value);
	}

	private void setGetIsReversed(int value) {
		this.getterValues.put("getIsReversed", value);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Port");
		setGetContract(kryo.readClassAndObject(input));
		setGetFullPathName(input.readString());
		setGetIsReversed(input.readVarInt(true));
		setGetName(input.readString());

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> allTags = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAllTags(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(allTags));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));
		}
	}