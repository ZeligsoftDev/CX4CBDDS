/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.cs2as;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.xtext.oclstdlibcs.util.AbstractOCLstdlibCSContainmentVisitor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class OCLstdlibCSContainmentVisitor extends AbstractOCLstdlibCSContainmentVisitor
{
	public OCLstdlibCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	protected PackageId getPackageId(@NonNull PackageCS csElement) {
		if ((csElement instanceof LibPackageCS) && (OCLstdlib.STDLIB_URI.equals(csElement.getNsURI()) || PivotPackage.eNS_URI.equals(csElement.getNsURI()))){
			return IdManager.METAMODEL;
		}
		return super.getPackageId(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitJavaClassCS(@NonNull JavaClassCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitLibClassCS(@NonNull LibClassCS csClass) {
		//
		//	Resolve explicit insstanceClass
		//
		String instanceClassName = null;
		JavaClassCS implementation = csClass.getImplementation();
		if ((implementation != null) && !implementation.eIsProxy()) {
			instanceClassName = implementation.getName();
		}
		Class<?> instanceClass = null;
		if (instanceClassName != null) {
			try {
				instanceClass = metamodelManager.getImplementationManager().loadImplementation(csClass, instanceClassName);
			} catch (ClassNotFoundException e) {
				context.addError(csClass, e.toString(), e);
			}
		}
		//
		//	Resolve explicit metaType name object
		//
		MetaclassNameCS csMetaclassName = null;
		List<INode> featureNodes = NodeModelUtils.findNodesForFeature(csClass, OCLstdlibCSPackage.Literals.LIB_CLASS_CS__METACLASS_NAME);
		if ((featureNodes != null) && (featureNodes.size() > 0)) {
			INode metaclassNameNode = featureNodes.get(0);
			String metaTypeNameText = NodeModelUtils.getTokenText(metaclassNameNode);
			if (metaTypeNameText != null) {
				csMetaclassName = ((OCLstdlibCS2AS)context.getConverter()).getMetaclassName(metaTypeNameText);
			}
			if (csMetaclassName == null) {
				context.addError(csClass, metaclassNameNode, "Unresolved metatype for ''{0}''", csClass);
			}
		}
		csClass.setMetaclassName(csMetaclassName);
		//
		//	Resolve metaType EClass and provide a default implicit instanceClass
		//
		EClass eClass = null;
		if ((csMetaclassName != null) && !csMetaclassName.eIsProxy()) {
			String metaTypeName = csMetaclassName.getName();
			eClass = (EClass) NameUtil.getENamedElement(PivotPackage.eINSTANCE.getEClassifiers(), metaTypeName);
			if (eClass != null) {
				instanceClass = eClass.getInstanceClass();
			}
		}
		//
		//	Provide a default metaType EClass
		//
		if (eClass == null) {
			if (instanceClass == null) {
				eClass = PivotPackage.Literals.CLASS;
			}
			else if (Boolean.class == instanceClass) {
				eClass = PivotPackage.Literals.BOOLEAN_TYPE;
			}
			else if (String.class == instanceClass) {
				eClass = PivotPackage.Literals.PRIMITIVE_TYPE;
			}
			else if (Collection.class.isAssignableFrom(instanceClass)) {
				eClass = PivotPackage.Literals.COLLECTION_TYPE;
			}
			else if (Map.class.isAssignableFrom(instanceClass)) {
				eClass = PivotPackage.Literals.MAP_TYPE;
			}
			else if (NumberValue.class.isAssignableFrom(instanceClass)) {
				eClass = PivotPackage.Literals.PRIMITIVE_TYPE;
			}
			else if (Number.class.isAssignableFrom(instanceClass)) {
				eClass = PivotPackage.Literals.PRIMITIVE_TYPE;
			}
			else {
				eClass = PivotPackage.Literals.CLASS;
			}
		}
		//
		//	Provide a default instanceClass
		//
	//	if (instanceClass == null) {
	//		instanceClass = EObject.class;
	//	}
		if ((instanceClass != null) && (instanceClassName == null)) {
			instanceClassName = instanceClass.getName();
		}
		//
		//	Finally refresh the class.
		//
		@SuppressWarnings("unchecked")
		Class<org.eclipse.ocl.pivot.Class> eInstanceClass = (Class<org.eclipse.ocl.pivot.Class>)eClass.getInstanceClass();
		if (eInstanceClass != null) {
			org.eclipse.ocl.pivot.Class pivotElement = refreshNamedElement(eInstanceClass, eClass, csClass);
			refreshClass(pivotElement, csClass);
			pivotElement.setInstanceClassName(instanceClassName);
			List<Operation> coercions = null;
			for (OperationCS csOperation : csClass.getOwnedOperations()) {
				if (csOperation instanceof LibCoercionCS) {
					if (pivotElement instanceof PrimitiveType) {
						if (coercions == null) {
							coercions = new ArrayList<Operation>();
						}
						coercions.add(PivotUtil.getPivot(Operation.class, csOperation));
					}
					else {
						context.addError(csOperation, "Only PrimitiveTypes may have coercions");
					}
				}
			}
			if (pivotElement instanceof PrimitiveType) {
				PivotUtilInternal.refreshList(((PrimitiveType)pivotElement).getCoercions(), coercions);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csElement) {
		@NonNull Iteration pivotElement = refreshNamedElement(Iteration.class, PivotPackage.Literals.ITERATION, csElement);
		pivotElement.setIsInvalidating(csElement.isIsInvalidating());
		pivotElement.setIsValidating(csElement.isIsValidating());
		context.refreshTemplateSignature(csElement, pivotElement);
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedIterators(), csElement.getOwnedIterators());
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedAccumulators(), csElement.getOwnedAccumulators());
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		return null;
	}

	@Override
	public Continuation<?> visitLibOperationCS(@NonNull LibOperationCS csElement) {
		Continuation<?> cont = super.visitLibOperationCS(csElement);
		Operation pivotElement = PivotUtil.getPivot(Operation.class, csElement);
		if (pivotElement != null) {
			pivotElement.setIsInvalidating(csElement.isIsInvalidating());
			pivotElement.setIsValidating(csElement.isIsValidating());
		}
		return cont;
	}

	@Override
	public @Nullable Continuation<?> visitLibOppositeCS(@NonNull LibOppositeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitLibPackageCS(@NonNull LibPackageCS csElement) {
		Library pivotElement = refreshPackage(Library.class, PivotPackage.Literals.LIBRARY, csElement);
		context.refreshPivotList(Precedence.class, pivotElement.getOwnedPrecedences(), csElement.getOwnedPrecedences());
		return null;
	}

	@Override
	public Continuation<?> visitLibRootPackageCS(@NonNull LibRootPackageCS csElement) {
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			@NonNull Model pivotElement = refreshRootPackage(Model.class, PivotPackage.Literals.MODEL, csElement);
			context.refreshPivotList(Import.class, pivotElement.getOwnedImports(), csElement.getOwnedImports());
			context.installRootElement((BaseCSResource) eResource, pivotElement);		// Ensure containment viable for imported library type references
			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		return null;
	}

	@Override /* FIXME Bug 548500 workaround */
	public @Nullable Continuation<?> visitMetaclassNameCS(@NonNull MetaclassNameCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csElement) {
		@NonNull Precedence pivotElement = refreshNamedElement(Precedence.class, PivotPackage.Literals.PRECEDENCE, csElement);
		pivotElement.setAssociativity(csElement.isIsRightAssociative() ? AssociativityKind.RIGHT : AssociativityKind.LEFT);
		return null;
	}
}
