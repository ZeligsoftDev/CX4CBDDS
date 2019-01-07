package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;



import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

class RPStereotypeHandler extends AbstractKryoHandler {

	private void setGetName(String value) {
		this.getterValues.put("getName", value);
	}

	private void setGetPropertyValueExplicitData(java.util.Map<String, Object> getPropertyValueExplicitResults) {
		for (java.util.Map.Entry<String, Object> entry : getPropertyValueExplicitResults.entrySet()) {
			this.getterValues.put("getPropertyValueExplicit#" + entry.getKey(), entry.getValue());
		}		
	}

	public void read(Kryo kryo, Input input) {
	
		this.getterValues.put("getMetaClass", "Stereotype");
		setGetName(input.readString());

		@SuppressWarnings("unchecked")
		final java.util.Map<String,Object> getPropertyValueExplicitResults = (java.util.Map<String,Object>)kryo.readClassAndObject(input);
		this.setGetPropertyValueExplicitData(getPropertyValueExplicitResults);
		}
	}