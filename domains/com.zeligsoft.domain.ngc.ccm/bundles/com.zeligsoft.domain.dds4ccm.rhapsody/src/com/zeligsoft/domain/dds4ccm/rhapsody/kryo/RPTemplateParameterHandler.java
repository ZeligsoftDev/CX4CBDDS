package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPTemplateParameterHandler extends AbstractKryoHandler {

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setGetDeclaration(String value) {
		this.getterValues.put("getDeclaration", value);
	}

	private void setGetFullPathName(String value) {
		this.getterValues.put("getFullPathName", value);
	}

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetOwner(Object value) {
		this.getterValues.put("getOwner", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "TemplateParameter");
		setGetDeclaration(input.readString());
		setGetFullPathName(input.readString());
		setGetName(input.readString());
		setGetOwner(kryo.readClassAndObject(input));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));
		}
	}