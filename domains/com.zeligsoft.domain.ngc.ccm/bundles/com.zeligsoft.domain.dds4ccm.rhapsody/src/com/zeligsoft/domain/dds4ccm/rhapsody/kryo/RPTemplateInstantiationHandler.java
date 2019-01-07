package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;


import java.util.Collection;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPTemplateInstantiationHandler extends AbstractKryoHandler {

	private void setStereotypes(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes) {
		this.getterValues.put("getStereotypes", stereotypes);
	}

	private void setTemplateInstantiationParameters(RhCollection<com.telelogic.rhapsody.core.IRPModelElement> templateInstantiationParameters) {
		this.getterValues.put("getTemplateInstantiationParameters", templateInstantiationParameters);
	}

	private void setGetOfTemplate(Object value) {
		this.getterValues.put("getOfTemplate", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "TemplateInstantiation");
		setGetOfTemplate(kryo.readClassAndObject(input));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> stereotypes = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setStereotypes(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(stereotypes));

		@SuppressWarnings("unchecked")
		final Collection<com.telelogic.rhapsody.core.IRPModelElement> templateInstantiationParameters = (Collection<com.telelogic.rhapsody.core.IRPModelElement>) kryo.readClassAndObject(input);
		this.setTemplateInstantiationParameters(new RhCollection<com.telelogic.rhapsody.core.IRPModelElement>(templateInstantiationParameters));
		}
	}