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
package org.eclipse.ocl.pivot.internal.manager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractIdResolver;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;

public class PivotIdResolver extends AbstractIdResolver
{
	private static final Logger logger = LogManager.getLogger(PivotIdResolver.class);

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull PivotMetamodelManager metamodelManager;

	public PivotIdResolver(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory.getMetamodelManager().getCompleteEnvironment());
		this.environmentFactory = environmentFactory;
		this.metamodelManager = environmentFactory.getMetamodelManager();
	}

	@Override
	protected org.eclipse.ocl.pivot.@NonNull Package addEPackage(@NonNull EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		org.eclipse.ocl.pivot.Package asPackage = nsURI2package.get(nsURI);
		if (asPackage == null) {
			PackageId packageId = IdManager.getPackageId(ePackage);
			asPackage = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
			if (asPackage == null) {
				asPackage = getPivotlessEPackage(ePackage);
				if (asPackage == null) {
					throw new IllegalStateException("EPackage " + ePackage.getName() + " : " + ePackage.getNsURI() + " has no Pivot counterpart.");
				}
			}
			nsURI2package.put(nsURI, asPackage);
			if (packageId instanceof RootPackageId) {
				roots2package.put(((RootPackageId)packageId).getName(), asPackage);
			}
		}
		return asPackage;
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull EClassifier eClassifier) {
		return metamodelManager.getInheritance(getType(eClassifier));
	}

	protected org.eclipse.ocl.pivot.@Nullable Package getPivotlessEPackage(@NonNull EPackage ePackage) {
		return null;
	}

	/**
	 * @since 1.7
	 */
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOfValue(@Nullable Type staticType, @Nullable Object value) {
		if (value instanceof ElementExtension) {
			Stereotype asStereotype = ((ElementExtension)value).getStereotype();
			return asStereotype != null ? asStereotype : metamodelManager.getStandardLibrary().getOclInvalidType();
		}
		return super.getStaticTypeOfValue(staticType, value);
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		TupleTypeManager tupleManager = metamodelManager.getCompleteModel().getTupleManager();
		return tupleManager.getTupleType(this, typeId);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getType(@NonNull EClassifier eClassifier) {
		EObject eType = eClassifier;
		EPackage ePackage = eClassifier.getEPackage();
		if (ePackage == PivotPackage.eINSTANCE){
			String typeName = eClassifier.getName();
			if (typeName != null) {
				org.eclipse.ocl.pivot.Package asMetamodel = metamodelManager.getASmetamodel();
				if (asMetamodel != null) {
					CompletePackage completePackage = metamodelManager.getCompletePackage(asMetamodel);
					org.eclipse.ocl.pivot.Class pivotType = completePackage.getMemberType(typeName);
					if (pivotType != null) {
						return pivotType;
					}
				}
			}
		}
		org.eclipse.ocl.pivot.Class pivotType;
		try {
			pivotType = ((EnvironmentFactoryInternalExtension)environmentFactory).getASOf(org.eclipse.ocl.pivot.Class.class, eType);
			if (pivotType != null) {
				return metamodelManager.getPrimaryClass(pivotType);
			}
		} catch (ParserException e) {
			logger.error("Failed to convert '" + eType + "'", e);
		}
		//		return new DomainInvalidTypeImpl(standardLibrary, "No object created by Ecore2AS");
		return metamodelManager.getStandardLibrary().getOclInvalidType();
	}

	@Override
	public @Nullable Object unboxedValueOf(@Nullable Object boxedValue) {
		if (boxedValue instanceof EnumerationLiteralId) {
			EnumerationLiteral enumerationLiteral = visitEnumerationLiteralId((EnumerationLiteralId)boxedValue);
			if (enumerationLiteral instanceof PivotObjectImpl) {
				EObject eTarget = ((PivotObjectImpl)enumerationLiteral).getESObject();
				//				if (eTarget instanceof EEnumLiteral) {				// Ecore unboxes to the Enumerator
				//					return ((EEnumLiteral)eTarget).getInstance();
				//				}
				//				else {												// UML unboxes to UML's EnumerationLiteral
				return eTarget;
				//				}
			}
			else {
				return enumerationLiteral;
			}
		}
		else {
			return super.unboxedValueOf(boxedValue);
		}
	}

	@Override
	public synchronized org.eclipse.ocl.pivot.@NonNull Package visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		org.eclipse.ocl.pivot.Package nsURIPackage = standardLibrary.getNsURIPackage(nsURI);
		if (nsURIPackage != null) {
			return nsURIPackage;
		}
		metamodelManager.setAutoLoadASmetamodel(true);
		org.eclipse.ocl.pivot.Package asMetamodel = metamodelManager.getASmetamodel();
		if ((asMetamodel != null) && PivotPackage.eNS_URI.equals(nsURI)) {
			return asMetamodel;
		}
		nsURIPackage = standardLibrary.getNsURIPackage(nsURI);
		if (nsURIPackage != null) {
			return nsURIPackage;
		}
		return super.visitNsURIPackageId(id);
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Package visitRootPackageId(@NonNull RootPackageId id) {
		String completeURIorName = id.getName();
		org.eclipse.ocl.pivot.Package rootPackage = standardLibrary.getRootPackage(completeURIorName);
		if (rootPackage == null) {
			Orphanage orphanage = metamodelManager.getCompleteModel().getOrphanage();
			rootPackage = NameUtil.getNameable(orphanage.getOwnedPackages(), completeURIorName);
			if (rootPackage == null) {
				return null;
			}
		}
		return rootPackage;
	}
}
