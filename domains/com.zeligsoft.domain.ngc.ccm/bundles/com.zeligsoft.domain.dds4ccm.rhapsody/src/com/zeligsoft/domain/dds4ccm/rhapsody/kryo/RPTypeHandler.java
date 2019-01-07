package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPTypeHandler extends AbstractKryoHandler {

	private void setAllTags(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> allTags) {
		this.getterValues.put("getAllTags", allTags);
	}

	private void setAttributes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> attributes) {
		this.getterValues.put("getAttributes", attributes);
	}

	private void setEnumerationLiterals(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> enumerationLiterals) {
		this.getterValues.put("getEnumerationLiterals", enumerationLiterals);
	}

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setGetFullPathName(String value) {
		this.getterValues.put("getFullPathName", value);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetTypedefBaseType(Object value) {
		this.getterValues.put("getTypedefBaseType", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Type");
		setGetFullPathName(input.readString());
		setGetName(input.readString());
		setGetTypedefBaseType(kryo.readClassAndObject(input));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> allTags = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAllTags(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(allTags));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> attributes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAttributes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(attributes));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> enumerationLiterals = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setEnumerationLiterals(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(enumerationLiterals));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));
		}
	}