package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPClassHandler extends AbstractKryoHandler {

	private void setAllTags(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> allTags) {
		this.getterValues.put("getAllTags", allTags);
	}

	private void setAttributes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> attributes) {
		this.getterValues.put("getAttributes", attributes);
	}

	private void setDependencies(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> dependencies) {
		this.getterValues.put("getDependencies", dependencies);
	}

	private void setGeneralizations(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> generalizations) {
		this.getterValues.put("getGeneralizations", generalizations);
	}

	private void setNestedElements(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> nestedElements) {
		this.getterValues.put("getNestedElements", nestedElements);
	}

	private void setPorts(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> ports) {
		this.getterValues.put("getPorts", ports);
	}

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setTemplateParameters(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> templateParameters) {
		this.getterValues.put("getTemplateParameters", templateParameters);
	}

	private void setOperations(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> operations) {
		this.getterValues.put("getOperations", operations);
	}

	private void setGetFullPathName(String value) {
		this.getterValues.put("getFullPathName", value);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetOfTemplate(Object value) {
		this.getterValues.put("getOfTemplate", value);
	}

	private void setGetTi(Object value) {
		this.getterValues.put("getTi", value);
	}

	private void setGetTagData(java.util.Map<String, Object> getTagResults) {
		for (java.util.Map.Entry<String, Object> entry : getTagResults.entrySet()) {
			this.getterValues.put("getTag#" + entry.getKey(), entry.getValue());
		}		
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Class");
		setGetFullPathName(input.readString());
		setGetName(input.readString());
		setGetOfTemplate(kryo.readClassAndObject(input));
		setGetTi(kryo.readClassAndObject(input));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> allTags = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAllTags(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(allTags));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> attributes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setAttributes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(attributes));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> dependencies = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setDependencies(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(dependencies));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> generalizations = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setGeneralizations(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(generalizations));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> nestedElements = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setNestedElements(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(nestedElements));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> ports = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setPorts(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(ports));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> templateParameters = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setTemplateParameters(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(templateParameters));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> operations = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setOperations(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(operations));

		@SuppressWarnings("unchecked")
		final java.util.Map<String,Object> getTagResults = (java.util.Map<String,Object>)kryo.readClassAndObject(input);
		this.setGetTagData(getTagResults);
		}
	}