/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.rhapsody.datacollector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.DataCollector.ClassData;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.DataCollector.MethodData;

class RecordingInvocationHandler implements InvocationHandler {

	private class CollectionInvocationHandler implements InvocationHandler {

		private final IRPCollection collection;
		private final Method collectionGetMethod;

		public CollectionInvocationHandler(IRPCollection collection,
				Method method) {
			this.collection = collection;
			this.collectionGetMethod = method;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if (!"toList".equals(method.getName())) {
				throw new UnsupportedOperationException(
						"Proxyed collection only supports toList(): "
								+ method.getName());
			}
			final Object result = method.invoke(collection, args);
			if (result instanceof List<?>) {
				@SuppressWarnings("unchecked")
				final List<Object> list = (List<Object>) result;
				final List<Object> proxiedList = new LinkedList<Object>();
				final Set<String> listTypes = new HashSet<String>();
				for (Object object : list) {
					listTypes.add(object.getClass().getSimpleName());
					if (object instanceof IRPModelElement) {
						proxiedList.add(collector.proxy(
								(IRPModelElement) object));
					} else {
						proxiedList.add(object);
					}
				}

				final ClassData classData = collector.classDataMap.get(element
						.getClass().getSimpleName());
				final String collectionGetName = this.collectionGetMethod
						.getName();
				final MethodData methodData = classData.methodDataMap.get(collectionGetName);
				methodData.collectionTypes.addAll(listTypes);

				return proxiedList;
			}
			return result;
		}

	}

	private final IRPModelElement element;
	private DataCollector collector;

	
	RecordingInvocationHandler(IRPModelElement element,
			DataCollector collector) {
		this.element = element;
		this.collector = collector;

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		collector.record(element, method, args);
		final Object result = method.invoke(element, args);
		if (result instanceof IRPModelElement) {
			return collector.proxy((IRPModelElement) result);
		} else if (result instanceof IRPCollection) {
			return proxyCollection((IRPCollection) result, element, method,
					collector);
		}
		return result;
	}

	private Object proxyCollection(IRPCollection result,
			IRPModelElement element, Method method, DataCollector collector) {
		final Class<? extends IRPModelElement> elementClass = element
				.getClass();
		return Proxy.newProxyInstance(elementClass.getClassLoader(),
				new Class<?>[] { IRPCollection.class },
				new CollectionInvocationHandler(result, method));
	}

}
