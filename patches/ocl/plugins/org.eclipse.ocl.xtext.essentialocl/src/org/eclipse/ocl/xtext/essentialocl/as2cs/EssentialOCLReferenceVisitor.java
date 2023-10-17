/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.as2cs;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.BaseReferenceVisitor;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;

public class EssentialOCLReferenceVisitor extends BaseReferenceVisitor
{
	public static final Logger logger = LogManager.getLogger(EssentialOCLReferenceVisitor.class);

	protected final @Nullable Namespace scope;

	public EssentialOCLReferenceVisitor(@NonNull AS2CSConversion context, @Nullable Namespace scope) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
		this.scope = scope;
	}

	@Override
	public ElementCS visitAnyType(@NonNull AnyType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		return csRef;
	}

	@Override
	public ElementCS visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		return visitType(object);
	}

	@Override
	public ElementCS visitCollectionType(@NonNull CollectionType object) {
		CollectionTypeCS csRef = EssentialOCLCSFactory.eINSTANCE.createCollectionTypeCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		Type elementType = object.getElementType();
		if (elementType != null) {
			TypedRefCS csElementType = (TypedRefCS) elementType.accept(this);
			csRef.setOwnedType(csElementType);
			if (elementType instanceof org.eclipse.ocl.pivot.Class) {
				org.eclipse.ocl.pivot.Package typePackage = ((org.eclipse.ocl.pivot.Class)elementType).getOwningPackage();
				if (typePackage != null) {
					context.importNamespace(typePackage, null);
				}
			}
		}
		IntegerValue lowerValue = object.getLowerValue();
		Number upper2 = object.getUpper();
		UnlimitedNaturalValue upperValue = object.getUpperValue();
		int upper = upper2 == null ? -1 : upper2 instanceof Unlimited ? -1 : upperValue.intValue();
		boolean isNullFree = object.isIsNullFree();
		int lower = lowerValue.intValue();
		MultiplicityCS csMultiplicity = context.createMultiplicityCS(lower, upper, isNullFree);
		csRef.setOwnedCollectionMultiplicity(csMultiplicity);
		return csRef;
	}

	@Override
	public ElementCS visitInvalidType(@NonNull InvalidType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		return csRef;
	}

	@Override
	public ElementCS visitMapType(@NonNull MapType object) {
		MapTypeCS csRef = EssentialOCLCSFactory.eINSTANCE.createMapTypeCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		Type keyType = PivotUtil.getKeyType(object);
		Type valueType = PivotUtil.getValueType(object);
		TypedRefCS csKeyType = (TypedRefCS) keyType.accept(this);
		TypedRefCS csValueType = (TypedRefCS) valueType.accept(this);
		if (!object.isKeysAreNullFree()) {
			MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
			csMultiplicity.setStringBounds("?");
			csKeyType.setOwnedMultiplicity(csMultiplicity);
		}
		if (!object.isValuesAreNullFree()) {
			MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
			csMultiplicity.setStringBounds("?");
			csValueType.setOwnedMultiplicity(csMultiplicity);
		}
		csRef.setOwnedKeyType(csKeyType);
		csRef.setOwnedValueType(csValueType);
		if (keyType instanceof org.eclipse.ocl.pivot.Class) {
			org.eclipse.ocl.pivot.Package typePackage = ((org.eclipse.ocl.pivot.Class)keyType).getOwningPackage();
			if (typePackage != null) {
				context.importNamespace(typePackage, null);
			}
		}
		if (valueType instanceof org.eclipse.ocl.pivot.Class) {
			org.eclipse.ocl.pivot.Package typePackage = ((org.eclipse.ocl.pivot.Class)valueType).getOwningPackage();
			if (typePackage != null) {
				context.importNamespace(typePackage, null);
			}
		}
		return csRef;
	}

	@Override
	public ElementCS visitPrimitiveType(@NonNull PrimitiveType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		return csRef;
	}

	@Override
	public ElementCS visitTupleType(@NonNull TupleType object) {
		TupleTypeCS csRef = BaseCSFactory.eINSTANCE.createTupleTypeCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		for (@NonNull Property asTuplePart : PivotUtil.getOwnedProperties(object)) {
			TuplePartCS csPart = BaseCSFactory.eINSTANCE.createTuplePartCS();
			csPart.setPivot(asTuplePart);
			csPart.setName(asTuplePart.getName());
			csPart.setOwnedType((TypedRefCS) asTuplePart.getType().accept(this));
			csRef.getOwnedParts().add(csPart);
		}
		return csRef;
	}

	@Override
	public ElementCS visitType(@NonNull Type object) {
		TypeNameExpCS csRef = EssentialOCLCSFactory.eINSTANCE.createTypeNameExpCS();
		csRef.setPivot(object);
		//		csRef.setElement(object);
		PathNameCS csPathName = csRef.getOwnedPathName();
		if (csPathName == null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csRef.setOwnedPathName(csPathName);
		}
		context.refreshPathName(csPathName, object, scope);
		if (object instanceof org.eclipse.ocl.pivot.Class) {
			org.eclipse.ocl.pivot.Package typePackage = ((org.eclipse.ocl.pivot.Class)object).getOwningPackage();
			if (typePackage != null) {
				context.importNamespace(typePackage, null);
			}
		}
		return csRef;
	}

	@Override
	public ElementCS visitVoidType(@NonNull VoidType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
		csRef.setPivot(object);
		csRef.setName(object.getName());
		return csRef;
	}
}