package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;



import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPTemplateInstantiationParameterHandler extends AbstractKryoHandler {

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetOwner(Object value) {
		this.getterValues.put("getOwner", value);
	}

	private void setGetType(Object value) {
		this.getterValues.put("getType", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "TemplateInstantiationParameter");
		setGetName(input.readString());
		setGetOwner(kryo.readClassAndObject(input));
		setGetType(kryo.readClassAndObject(input));
		}
	}