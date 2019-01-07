package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;

import java.lang.reflect.Proxy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

class ProxyDrivenDeserializer<T> extends Serializer<T> {
	
	private final Class<? extends AbstractKryoHandler> handlerClass;

	public ProxyDrivenDeserializer(Class<? extends AbstractKryoHandler> handlerClass) {
		this.handlerClass = handlerClass;
		
	}

	@Override
	public T read(Kryo kryo, Input input, Class<T> paramClass) {
		final AbstractKryoHandler handler = newInstance();
		
		@SuppressWarnings("unchecked")
		final T object = (T)Proxy.newProxyInstance(paramClass.getClassLoader(),
                new Class[] { paramClass },
                handler);

		kryo.reference(object);
		handler.read(kryo, input);
		
		return object;
	}

	private AbstractKryoHandler newInstance()  {
		try {
			return handlerClass.newInstance();
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e);
		} catch (InstantiationException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void write(Kryo arg0, Output arg1, T arg2) {
		throw new UnsupportedOperationException();
	}

}
