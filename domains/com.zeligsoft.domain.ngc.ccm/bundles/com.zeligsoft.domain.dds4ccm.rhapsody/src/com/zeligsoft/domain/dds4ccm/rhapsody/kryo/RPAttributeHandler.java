package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPAttributeHandler extends AbstractKryoHandler {

	private void setAllTags(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> allTags) {
		this.getterValues.put("getAllTags", allTags);
	}

	private void setDependencies(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> dependencies) {
		this.getterValues.put("getDependencies", dependencies);
	}

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setValueSpecifications(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> valueSpecifications) {
		this.getterValues.put("getValueSpecifications", valueSpecifications);
	}

	private void setGetFullPathName(String value) {
		this.getterValues.put("getFullPathName", value);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetType(Object value) {
		this.getterValues.put("getType", value);
	}

	private void setGetTagData(java.util.Map<String, Object> getTagResults) {
		for (java.util.Map.Entry<String, Object> entry : getTagResults.entrySet()) {
			this.getterValues.put("getTag#" + entry.getKey(), entry.getValue());
		}		
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Attribute");
		setGetFullPathName(input.readString());
		setGetName(input.readString());
		setGetType(kryo.readClassAndObject(input));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> allTags = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAllTags(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(allTags));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> dependencies = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setDependencies(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(dependencies));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> valueSpecifications = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setValueSpecifications(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(valueSpecifications));

		@SuppressWarnings("unchecked")
		final java.util.Map<String,Object> getTagResults = (java.util.Map<String,Object>)kryo.readClassAndObject(input);
		this.setGetTagData(getTagResults);
		}
	}