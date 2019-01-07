package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;

import java.lang.reflect.Proxy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.telelogic.rhapsody.core.IRPModelElement;

public class RPDefaultDeserializer extends Serializer<IRPModelElement> {
	
	public static final class UnknownRPModelElement implements KryoSerializable {
		private String metaClassname;
		private String fullPathName;
		
		public UnknownRPModelElement() {
		}

		protected synchronized String getMetaClassName() {
			return metaClassname;
		}

		protected synchronized String getFullPathName() {
			return fullPathName;
		}

		@Override
		public void write(Kryo paramKryo, Output paramOutput) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void read(Kryo kryo, Input input) {
			metaClassname = input.readString();
			fullPathName = input.readString();
		}
	}
	
	static final class UnknownRPModelElementHandler extends AbstractKryoHandler {

		public UnknownRPModelElementHandler(UnknownRPModelElement unknownModelElement) {
			this.getterValues.put("getFullPathName", unknownModelElement.getFullPathName());
			this.getterValues.put("getMetaClassName", unknownModelElement.getMetaClassName());
		}
		
		@Override
		public void read(Kryo kryo, Input input) {
			throw new UnsupportedOperationException("Not implemented, should not have been called.");
		}
		
	}
	
	@Override
	public void write(Kryo paramKryo, Output paramOutput, IRPModelElement paramT) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IRPModelElement read(Kryo kryo, Input input,
			Class<IRPModelElement> type) {
		
		final UnknownRPModelElement unknownRPModelElement = (UnknownRPModelElement) kryo.readClassAndObject(input);
		
		final Class<?> rpInterfaceClass = computeRPInterfaceClass(unknownRPModelElement);
		final IRPModelElement object = (IRPModelElement)Proxy.newProxyInstance(rpInterfaceClass.getClassLoader(),
                new Class[] { rpInterfaceClass },
                new UnknownRPModelElementHandler(unknownRPModelElement));
		return object;
	}

	private Class<?> computeRPInterfaceClass(
			UnknownRPModelElement unknownRPModelElement) {
		final String metaClassName = unknownRPModelElement.getMetaClassName();
		final String unqualifiedName = metaClassName.substring(metaClassName.lastIndexOf('.') + 1);
		final String fqn = IRPModelElement.class.getPackage().getName() + ".IRP" + unqualifiedName;
		try {
			return Class.forName(fqn);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Expected Rhapsody class " + fqn, e);
		}
	}

}
