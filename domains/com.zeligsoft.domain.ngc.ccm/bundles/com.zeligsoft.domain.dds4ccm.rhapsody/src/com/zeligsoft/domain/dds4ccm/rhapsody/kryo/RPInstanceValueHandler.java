package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;



import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPInstanceValueHandler extends AbstractKryoHandler {

	private void setGetValue(Object value) {
		this.getterValues.put("getValue", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "InstanceValue");
		setGetValue(kryo.readClassAndObject(input));
		}
	}