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
package com.zeligsoft.base.zdl.staticapi.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Profile;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.zeligsoft.base.zdl.staticapi.Activator;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ZDLFactoryRegistryImpl implements ZDLFactoryRegistry {
    private static final String E_FACTORY = "factory";
    private static final String A_FACTORY_CLASS = "factoryClass";
    private static final String A_DOMAIN = "domain";

    private final Map<String, ZDLFactory> registry = Maps.newHashMap();

    public ZDLFactoryRegistryImpl() {
        new ZDLFactoryRegistryReader().readRegistry();
    }

    void addFactory(String domain, ZDLFactory factory) {
        synchronized (ZDLFactoryRegistryImpl.this) {
            registry.put(domain, factory);
        }
    }

    protected void removeFactory(String domain) {
        synchronized (ZDLFactoryRegistryImpl.this) {
            registry.remove(domain);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry#create(java.
     * lang.Object, java.lang.Class)
     */
    @Override
    public <T> T create(EObject src, Class<T> type) {
        T createdWrapper = null;
        final org.eclipse.uml2.uml.Class concept = ZDLUtil.getZDLConcept(src);
        if(concept != null){
	        final Profile zdlProfile = ZDLUtil.getZDLProfile(src, concept);
	        if ((zdlProfile != null) && (concept != null)) {
	            final String profileName = zdlProfile.getName();
	            final String conceptQN = concept.getQualifiedName();
	
	            createdWrapper = create(profileName, conceptQN, src, type);
	        }
        }
        return createdWrapper;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T> T create(String domain, String zdlConcept, EObject src,
            Class<T> type) {
    	
		CacheAdapter cache = CacheAdapter.getCacheAdapter(src);
		if (cache == null) {
			cache = CacheAdapter.INSTANCE;
			cache.adapt(src);
		}
		
		Object result = cache.get(src, ZDLFactoryRegistry.class);
		if (result != null) {
			return (T) result;
		}
		
        T createdWrapper = null;
        final ZDLFactory factory = registry.get(domain);
        if (factory != null) {
            try {
                createdWrapper = factory.create(zdlConcept, src, type);
            } catch (final SecurityException e) {
            	Activator.error(Activator.getDefault(), 
                		String.format("Exception creating ZDLConcept; %s.", zdlConcept), 
                		e);
            } catch (final IllegalArgumentException e) {
            	Activator.error(Activator.getDefault(), 
                		String.format("Exception creating ZDLConcept; %s.", zdlConcept), 
                		e);
            } catch (final NoSuchMethodException e) {
            	Activator.error(Activator.getDefault(), 
                		String.format("Exception creating ZDLConcept; %s.", zdlConcept), 
                		e);
            } catch (final InstantiationException e) {
            	Activator.error(Activator.getDefault(), 
                		String.format("Exception creating ZDLConcept; %s.", zdlConcept), 
                		e);
            } catch (final IllegalAccessException e) {
            	Activator.error(Activator.getDefault(), 
                		String.format("Exception creating ZDLConcept; %s.", zdlConcept), 
                		e);
            } catch (final InvocationTargetException e) {
                Activator.error(Activator.getDefault(), 
                		String.format("Exception creating ZDLConcept; %s.", zdlConcept), 
                		e);
            }
        }

		if (createdWrapper != null) {
			cache.put(src, ZDLFactoryRegistry.class, createdWrapper);
		}
        return createdWrapper;
    }

    private class ZDLFactoryRegistryReader extends RegistryReader {
        public ZDLFactoryRegistryReader() {
            super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID,
                    Activator.ZDL_FACTORY_EXTPT);
        }

        @Override
        protected boolean readElement(IConfigurationElement element, boolean add) {
            if (E_FACTORY.equals(element.getName())) {
                final String domain = element.getAttribute(A_DOMAIN);
                if (Strings.isNullOrEmpty(domain)) {
                    logMissingAttribute(element, A_DOMAIN);
                    return false;
                }

                if (element.getAttribute(A_FACTORY_CLASS) == null) {
                    logMissingAttribute(element, A_FACTORY_CLASS);
                    return false;
                }

                if (add) {
                    Object rawFactoryClass = null;
                    try {
                        rawFactoryClass = element
                        .createExecutableExtension(A_FACTORY_CLASS);
                    } catch (final CoreException e) {
                        Activator
                        .getDefault()
                        .error("ZDLFactoryRegistry.ZDLFactoryRegistryReader: Invalid class",
                                e);
                        return false;
                    }

                    if ((rawFactoryClass != null)
                            && (rawFactoryClass instanceof ZDLFactory)) {
                        synchronized (ZDLFactoryRegistryImpl.this) {
                            registry.put(domain, (ZDLFactory) rawFactoryClass);
                        }
                    }
                } else {
                    synchronized (ZDLFactoryRegistryImpl.this) {
                        registry.remove(domain);
                    }
                }

                return true;
            }

            return false;
        }
    }
}
