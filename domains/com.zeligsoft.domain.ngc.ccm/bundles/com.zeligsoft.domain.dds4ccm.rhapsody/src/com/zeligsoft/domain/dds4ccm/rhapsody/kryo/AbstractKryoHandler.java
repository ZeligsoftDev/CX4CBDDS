package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.telelogic.rhapsody.core.IRPCollection;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.IMissingFunctionCollector;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.MissingFunctionCollector;

abstract class AbstractKryoHandler implements InvocationHandler {

	private static final IRPCollection EMPTY_RP_COLLECTION = new RhCollection<Object>(Collections.emptySet());
	
	protected final java.util.Map<String, Object> getterValues = new java.util.HashMap<String, Object>();
	
	protected AbstractKryoHandler() {
		getterValues.put("equals", Boolean.FALSE);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		final String methodName = method.getName();
		if(getterValues.containsKey(methodName)) {
			return getterValues.get(methodName);
		} else if(args != null && args.length == 1 && args[0] instanceof String) {
			return getterValues.get(methodName + "#" + args[0]);
		} else {
			final IMissingFunctionCollector collector = MissingFunctionCollector.getInstance();
			if(!Void.class.equals(method.getReturnType())) {
				if(args == null) {
					// it's getter/collection-getter...
					collector.recordMissingGetter(getRPMetaClass(proxy), getFullPathName(proxy), methodName);
					final Object returnValue = defaultValueFor(method.getReturnType());
					getterValues.put(methodName, returnValue);
					return returnValue;
				} else if(args.length == 1 && String.class.equals(method.getParameterTypes()[0])) {
					// it's a single-argument method
					collector.recordMissing1ArgMethod(getRPMetaClass(proxy), getFullPathName(proxy), methodName, (String)args[0]);
					final Object returnValue = defaultValueFor(method.getReturnType());
					getterValues.put(methodName + "#" + args[0], returnValue);
					return returnValue;
				}
			}
			throw new UnsupportedOperationException(proxy.getClass().getInterfaces()[0].getCanonicalName() + " does not supported method: " + method.toString());
		}
	}

	private Object defaultValueFor(Class<?> returnType) {
		if(String.class.equals(returnType)) {
			return "";
		} else if(Integer.class.equals(returnType)) {
			return Integer.valueOf(0);
		} else if(IRPCollection.class.equals(returnType)) {
			return EMPTY_RP_COLLECTION;
		}
		return null;
	}

	private String getFullPathName(Object proxy) {
		return (String) getterValues.get("getFullPathName");
	}

	private String getRPMetaClass(Object proxy) {
		final Class<?> rpInterface = proxy.getClass().getInterfaces()[0];
		final String fqn = rpInterface.getName();
		final int lastDot = fqn.lastIndexOf('.');
		final String metaClass = fqn.substring(lastDot + 1 + 3 /* "IRP".length() */);
		return metaClass;
	}

	public abstract void read(Kryo kryo, Input input);

}
