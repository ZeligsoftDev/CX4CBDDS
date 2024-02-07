/**
 * Copyright (c) 2005-2009 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 */
package org.eclipse.xtend.typesystem.emf;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.internal.xtend.type.baseimpl.FeatureImpl;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class EClassType extends AbstractTypeImpl {

	private final static Logger log = LogManager.getLogger(EClassType.class);

	private final EmfRegistryMetaModel emfMetaModel;

	private final EClass eClass;

	public EClassType(final EmfRegistryMetaModel model, final String name, final EClass class1) {
		super(model.getTypeSystem(), name);
		emfMetaModel = model;
		eClass = class1;
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Set<FeatureImpl> result = new HashSet<FeatureImpl>();
		// Attributes
		for (final EStructuralFeature feature : eClass.getEStructuralFeatures()) {
			final Type t = emfMetaModel.getTypeForETypedElement(feature);
			if (t == null) {
				if (feature.getEType().eIsProxy()) {
					log.warn(String.format("Unresolved proxy for type of feature %s::%s, eProxyURI: %s", eClass.getName(), feature.getName(), EcoreUtil.getURI(feature.getEType())));
				}
				else
					log.warn("Couldn't resolve type for " + getTypeName(feature.getEType()));
			}
			else {
				result.add(new PropertyImpl(this, feature.getName(), t) {

					public Object get(final Object target) {
						return ((EObject) target).eGet(feature);
					}

					@Override
					public void set(final Object target, Object newValue) {
						if (feature.isChangeable() && !feature.isDerived()) {
							if (feature.getEType() instanceof EDataType && !(feature.getEType() instanceof EEnum)) {
								final EDataType dt = (EDataType) feature.getEType();
								newValue = getReturnType().convert(newValue, dt.getInstanceClass());
							}
							((EObject) target).eSet(feature, newValue);
						}
						else
							throw new UnsupportedOperationException("setting property '" + feature.getName()
									+ "' is not allowed!");
					}
				});
				// setter
				if (feature.isChangeable() && !feature.isMany()){ //  && !feature.isDerived()
					// &&
					result.add(new OperationImpl(this, "set" + StringHelper.firstUpper(feature.getName()), this,
							new Type[] { t }) {

						@Override
						protected Object evaluateInternal(final Object target, final Object[] params) {
							Object newValue = params[0];
							if (newValue != null && feature.getEType() instanceof EDataType
									&& !(feature.getEType() instanceof EEnum)) {
								final EDataType dt = (EDataType) feature.getEType();
								newValue = getParameterTypes().get(0).convert(newValue, dt.getInstanceClass());
							}
							((EObject) target).eSet(feature, newValue);
							return target;
						}

					});
				}
				else if (feature.isMany()) {
					result.add(new OperationImpl(this, "set" + StringHelper.firstUpper(feature.getName()), this, new Type[] { t }) {
						@SuppressWarnings("unchecked")
						@Override
						protected Object evaluateInternal(Object target, Object[] params) {
							if (params != null) {
								Object newValue = params[0];

								if (newValue != null && feature.getEType() instanceof EDataType
										&& !(feature.getEType() instanceof EEnum)) {
									final EDataType dt = (EDataType) feature.getEType();
									newValue = getParameterTypes().get(0).convert(newValue, dt.getInstanceClass());
								}

								EList<Object> newColl = new BasicEList<Object>((List<?>)newValue);

								EObject targetObject = ((EObject) target);
								EClass targetClass = targetObject.eClass();
								EStructuralFeature eStructuralFeature = targetClass.getEStructuralFeature(feature.getName());

								EList<Object> coll = (EList<Object>) targetObject.eGet(eStructuralFeature);

								ECollections.setEList(coll, newColl);
								return target;
							}
							return null;
						}
					});
				}
				// isSetXXX and unsetXXX operation if feature is unsettable
				if (feature.isUnsettable()) {
					result.add(new OperationImpl(this, "isSet" + StringHelper.firstUpper(feature.getName()), getTypeSystem().getBooleanType()) {
						@Override
						protected Object evaluateInternal(final Object target, final Object[] params) {
							return ((EObject) target).eIsSet(feature);
						}
					});
					result.add(new OperationImpl(this, "unset" + StringHelper.firstUpper(feature.getName()), getTypeSystem().getVoidType()) {
						@Override
						protected Object evaluateInternal(final Object target, final Object[] params) {
							((EObject) target).eUnset(feature);
							return null;
						}
					});
				}
			}
		}
		// Operations
		final EList<EOperation> eOperations = eClass.getEOperations();
		for (EOperation op : eOperations) {
			final EList<EParameter> emfParams = op.getEParameters();
			final Type[] paramTypes = new Type[emfParams.size()];
			boolean errors = false;
			for (int i = 0, x = emfParams.size(); i < x; i++) {
				final EParameter param = emfParams.get(i);
				paramTypes[i] = emfMetaModel.getTypeForETypedElement(param);
				if (paramTypes[i] == null) {
					log.warn("Couldn't resolve type for " + getTypeName(param.getEType()));
					errors = true;
				}
			}
			final Type t = emfMetaModel.getTypeForETypedElement(op);
			if (t == null) {
				log.warn("Couldn't resolve type for " + getTypeName(op.getEType()));
				errors = true;
			}
			if (!errors) {

				result.add(new OperationImpl(this, op.getName(), t, paramTypes) {

					@Override
					protected Object evaluateInternal(final Object target, final Object[] params) {
						final Class<?>[] paramClasses = new Class<?>[emfParams.size()];
						for (int i = 0, x = emfParams.size(); i < x; i++) {
							final EParameter param = emfParams.get(i);
							if (param.isMany()) {
								paramClasses[i] = EList.class;
							}
							else {
								paramClasses[i] = param.getEType().getInstanceClass();
							}
							params[i] = getParameterTypes().get(i).convert(params[i], paramClasses[i]);
						}
						try {
							final Method m = target.getClass().getMethod(getName(), paramClasses);
							return m.invoke(target, params);
						}
						catch (final Exception e) {
							throw new RuntimeException(e);
						}
					}
				});
			}
		}
		return result.toArray(new Feature[result.size()]);
	}

	private String getTypeName(final EClassifier type) {
		if (type == null)
			return "null";

		return type.getName();
	}

	public boolean isInstance(final Object o) {
		return eClass.isInstance(o);
	}

	public Object newInstance() {
		return eClass.getEPackage().getEFactoryInstance().create(eClass);
	}

	@Override
	protected Set<Type> internalGetSuperTypes() {
		final EList<EClass> superTypes = eClass.getESuperTypes();
		final Set<Type> result = new HashSet<Type>();
		for (EClass element : superTypes) {
			result.add(emfMetaModel.getTypeForEClassifier(element));
		}
		result.add(emfMetaModel.getEobjectType());
		return result;
	}

	@Override
	public boolean isAbstract() {
		return eClass.isAbstract();
	}

	@Override
	protected boolean internalIsAssignableFrom(Type t) {
		if (super.internalIsAssignableFrom(t))
			return true;
		// 
		if (getName().equals("ecore::EObject")) {
			if (t instanceof EClassType) 
				return true;
	        final Set<? extends Type> superTypes = t.getSuperTypes();
	        for (Type type : superTypes) {
	            if (type instanceof EClassType)
	                return true;
	        }
		}
		return false;
	}
	
	/**
	 * @since 1.4
	 */
	public EClass eClass () {
		return eClass;
	}
}
