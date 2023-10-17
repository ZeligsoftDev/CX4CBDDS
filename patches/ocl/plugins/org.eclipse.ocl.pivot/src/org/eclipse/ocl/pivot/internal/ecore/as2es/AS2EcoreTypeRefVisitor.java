/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA List) - Bug 424057 - UML 2.5 CG
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.as2es;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.Unlimited;

public class AS2EcoreTypeRefVisitor extends AbstractExtendingVisitor<EObject, AS2Ecore>
{
	protected final @NonNull PivotMetamodelManager metamodelManager;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	/**
	 * @since 1.3
	 */
	protected final boolean isRequired;

	/* @deprecated provide isRequired argument */
	@Deprecated
	public AS2EcoreTypeRefVisitor(@NonNull AS2Ecore context) {
		this(context, true);
	}

	/**
	 * @since 1.3
	 */
	public AS2EcoreTypeRefVisitor(@NonNull AS2Ecore context, boolean isRequired) {
		super(context);
		this.metamodelManager = context.getMetamodelManager();
		this.standardLibrary = context.getStandardLibrary();
		this.isRequired = isRequired;
	}

	private <T extends EObject> @Nullable T getESObject(@NonNull Class<T> requiredClass, org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		Iterable<org.eclipse.ocl.pivot.Class> partialClasses = metamodelManager.getPartialClasses(pivotType);
		for (org.eclipse.ocl.pivot.Class type : partialClasses) {
			if (type instanceof PivotObjectImpl) {
				EObject esObject = ((PivotObjectImpl)type).getESObject();
				if ((esObject != null) && requiredClass.isAssignableFrom(esObject.getClass())) {
					return (T)esObject;
				}
			}
		}
		return null;
	}

	public EGenericType resolveEGenericType(org.eclipse.ocl.pivot.@NonNull Class type) {
		EObject eType = safeVisit(type);
		if (eType instanceof EGenericType) {
			return (EGenericType) eType;
		}
		else {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setEClassifier((EClassifier) eType);
			TemplateSignature templateSignature = type.getOwnedSignature();
			if (templateSignature != null) {
				for (@NonNull TemplateParameter templateParameter : PivotUtil.getOwnedParameters(templateSignature)) {
					EObject eTypeParameter = safeVisit(templateParameter);
					if (eTypeParameter instanceof EGenericType) {
						eGenericType.getETypeArguments().add((EGenericType) eTypeParameter);
					}
				}
			}
			return eGenericType;
		}
	}

	@Override
	public EObject safeVisit(@Nullable Visitable v) {
		if (v instanceof Type) {
			v = metamodelManager.getPrimaryType((Type)v);
		}
		return (v == null) ? null : v.accept(this);
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	@Override
	public EClassifier visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for AS2Ecore TypeRef pass");
	}

	@Override
	public EObject visitAnyType(@NonNull AnyType pivotType) {
		EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
		if (eClassifier != null) {
			return eClassifier;
		}
		else {
			return OCLstdlibPackage.Literals.OCL_ANY;
		}
	}

	@Override
	public EObject visitClass(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		if (pivotType.getOwnedBindings().size() == 0) {
			EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
			if (eClassifier != null) {
				return eClassifier;
			}
			if (metamodelManager.isTypeServeable(pivotType)) {
				eClassifier = getESObject(EClassifier.class, pivotType);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
			else {
				if (pivotType instanceof PivotObjectImpl) {
					EObject eTarget = ((PivotObjectImpl)pivotType).getESObject();
					if (eTarget != null) {
						return eTarget;
					}
				}
			}
			return null;	// FIXME may be null if not from Ecore
		}
		List<TemplateBinding> templateBindings = ((TemplateableElement)pivotType).getOwnedBindings();
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		EObject rawType = safeVisit(PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)pivotType));
		eGenericType.setEClassifier((EClassifier) rawType);
		// FIXME signature ordering, multiple bindings
		safeVisitAll(eGenericType.getETypeArguments(), templateBindings.get(0).getOwnedSubstitutions());
		return eGenericType;
	}

	@Override
	public EObject visitCollectionType(@NonNull CollectionType pivotType) {
		if (pivotType.getOwnedBindings().size() == 0) {
			EClassifier eClassifier1 = context.getCreated(EClassifier.class, pivotType);
			if (eClassifier1 != null) {
				return eClassifier1;
			}
			Iterable<org.eclipse.ocl.pivot.Class> partialClasses = metamodelManager.getPartialClasses(pivotType);
			for (org.eclipse.ocl.pivot.Class type : partialClasses) {
				if (type instanceof PivotObjectImpl) {
					EObject eTarget = ((PivotObjectImpl)type).getESObject();
					if (eTarget != null) {
						return eTarget;
					}
				}
			}
			return OCLstdlibPackage.eINSTANCE.getEClassifier(pivotType.getName());
		}
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		EObject eClassifier2 = safeVisit(PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)pivotType));
		eGenericType.setEClassifier((EClassifier) eClassifier2);
		safeVisitAll(eGenericType.getETypeArguments(), pivotType.getOwnedBindings().get(0).getOwnedSubstitutions());
		// FIXME supers
		Number lower = pivotType.getLower();
		Number upper = pivotType.getUpper();
		if ((lower != null) && (upper != null) && ((lower.longValue() != 0) || !(upper instanceof  Unlimited))) {
			// FIXME Ecore does not support nested multiplicities
			//			eGenericType.setLower(lower.longValue());
			//			eGenericType.setUpper(upper instanceof Unlimited) ? -1 : upper.longValue());
		}
		return eGenericType;
	}

	@Override
	public EObject visitInvalidType(@NonNull InvalidType pivotType) {
		EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
		if (eClassifier != null) {
			return eClassifier;
		}
		else {
			return OCLstdlibPackage.Literals.OCL_INVALID;
		}
	}

	@Override
	public EObject visitMapType(@NonNull MapType mapType) {
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		EClassifier eClassifier = OCLstdlibPackage.Literals.MAP;
		eGenericType.setEClassifier(eClassifier);
		safeVisitAll(eGenericType.getETypeArguments(), mapType.getOwnedBindings());
		// FIXME bounds, supers
		return eGenericType;
	}

	@Override
	public EObject visitPrimitiveType(@NonNull PrimitiveType pivotType) {
		EDataType eClassifier = context.getCreated(EDataType.class, pivotType);
		if (eClassifier != null) {
			return eClassifier;
		}
	//	EDataType eClassifier2 = getESObject(EDataType.class, pivotType);  -- too simple can give String rather than EString
	//	if (eClassifier2 != null) {
	//		if (!isRequired && (eClassifier2 == EcorePackage.Literals.EBOOLEAN)) {
	//			eClassifier2 = EcorePackage.Literals.EBOOLEAN_OBJECT;
	//		}
	//		context.putCreated(pivotType, eClassifier2);
	//		return eClassifier2;
	//	}
		String uri = context.getPrimitiveTypesUriPrefix();
		if (uri != null) {
			URI proxyURI = URI.createURI(uri + pivotType.getName());
			eClassifier = EcoreFactory.eINSTANCE.createEDataType();
			((InternalEObject) eClassifier).eSetProxyURI(proxyURI);
			context.putCreated(pivotType, eClassifier);
			return eClassifier;
		}
		CompleteClass completeClass = metamodelManager.getCompleteClass(pivotType);
		List<org.eclipse.ocl.pivot.Class> partialClasses = completeClass.getPartialClasses();
		for (org.eclipse.ocl.pivot.Class aType : partialClasses) {
			if (!(aType instanceof PrimitiveType)) {		// FIXME This loop appears to be unnecessary
				eClassifier = context.getCreated(EDataType.class, pivotType);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
		}
		for (org.eclipse.ocl.pivot.Class aType : partialClasses) {
			if (aType == standardLibrary.getStringType()) {
				return EcorePackage.Literals.ESTRING;
			}
			else if (aType == standardLibrary.getBooleanType()) {
				return isRequired ? EcorePackage.Literals.EBOOLEAN : EcorePackage.Literals.EBOOLEAN_OBJECT;
			}
			else if (aType == standardLibrary.getIntegerType()) {
				return EcorePackage.Literals.EBIG_INTEGER;
			}
			else if (aType == standardLibrary.getRealType()) {
				return EcorePackage.Literals.EBIG_DECIMAL;
			}
			else if (aType == standardLibrary.getUnlimitedNaturalType()) {
				return EcorePackage.Literals.EBIG_INTEGER;
			}
		}
		throw new IllegalArgumentException("Unsupported primitive type '" + pivotType + "' in AS2Ecore TypeRef pass");
	}

	@Override
	public EObject visitTemplateBinding(@NonNull TemplateBinding object) {
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		return eGenericType;
	}

	@Override
	public EObject visitTemplateParameter(@NonNull TemplateParameter pivotType) {
		ETypeParameter eTypeParameter = context.getCreated(ETypeParameter.class, pivotType);
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setETypeParameter(eTypeParameter);
		return eGenericType;
	}

	@Override
	public EObject visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution pivotTemplateParameterSubstitution) {
		EObject actualType = safeVisit(pivotTemplateParameterSubstitution.getActual());
		if (actualType instanceof EGenericType) {
			return actualType;
		}
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setEClassifier((EClassifier) actualType);
		return eGenericType;
	}

	/**
	 * @since 1.17
	 */
	@Override
	public EObject visitTupleType(@NonNull TupleType pivotType) {
		EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
		if (eClassifier != null) {
			return eClassifier;
		}
		else {
			return OCLstdlibPackage.Literals.OCL_TUPLE;
		}
	}

	@Override
	public EObject visitVoidType(@NonNull VoidType pivotType) {
		EClassifier eClassifier = context.getCreated(EClassifier.class, pivotType);
		if (eClassifier != null) {
			return eClassifier;
		}
		else {
			return OCLstdlibPackage.Literals.OCL_VOID;
		}
	}
}
