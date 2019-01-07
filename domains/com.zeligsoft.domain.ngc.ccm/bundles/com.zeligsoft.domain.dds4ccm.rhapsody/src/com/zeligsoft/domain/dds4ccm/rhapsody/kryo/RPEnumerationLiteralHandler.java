package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;



import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPEnumerationLiteralHandler extends AbstractKryoHandler {

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "EnumerationLiteral");
		setGetName(input.readString());
		}
	}