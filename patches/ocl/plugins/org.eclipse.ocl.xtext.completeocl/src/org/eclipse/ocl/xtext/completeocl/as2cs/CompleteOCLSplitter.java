/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.as2cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.PivotSwitch;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 *
 */
public class CompleteOCLSplitter
{
	public static @Nullable ASResource separate(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Resource asResource) {
		List<@NonNull Constraint> allConstraints = new ArrayList<@NonNull Constraint>();
		List<@NonNull LanguageExpression> allExpressionInOCLs = new ArrayList<@NonNull LanguageExpression>();
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Constraint) {
				allConstraints.add((Constraint) eObject);
			}
			else if (eObject instanceof Operation) {
				LanguageExpression bodyExpression = ((Operation)eObject).getBodyExpression();
				if (bodyExpression != null) {
					allExpressionInOCLs.add(bodyExpression);
				}
			}
			else if (eObject instanceof Property) {
				LanguageExpression bodyExpression = ((Property)eObject).getOwnedExpression();
				if (bodyExpression != null) {
					allExpressionInOCLs.add(bodyExpression);
				}
			}
			else if (eObject instanceof Annotation) {
				tit.prune();
			}
		}
		if (allConstraints.isEmpty() && allExpressionInOCLs.isEmpty()) {
			return null;
		}
		URI uri = ClassUtil.nonNullState(asResource.getURI());
		URI oclURI = PivotUtilInternal.getNonASURI(uri).appendFileExtension("ocl");
		URI oclASuri = PivotUtilInternal.getASURI(oclURI);	// xxx.ocl.ocl.oclas
		ASResource oclResource = (ASResource) asResource.getResourceSet().createResource(oclASuri, ASResource.COMPLETE_OCL_CONTENT_TYPE);
		if (oclResource != null) {
			PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
			Separator separator = new Separator(metamodelManager, oclResource);
			for (Constraint constraint : allConstraints) {
				separator.doSwitch(constraint);
			}
			for (LanguageExpression opaqueExpression : allExpressionInOCLs) {
				separator.doSwitch(opaqueExpression);
			}
			metamodelManager.installResource(oclResource);
		}
		return oclResource;
	}

	public static class Separator extends PivotSwitch<@Nullable EObject>
	{
		protected final @NonNull PivotMetamodelManager metamodelManager;
		protected final @NonNull Resource separateResource;
		private final @NonNull Map<@NonNull NamedElement, @NonNull NamedElement> map = new HashMap<@NonNull NamedElement, @NonNull NamedElement>();

		public Separator(@NonNull PivotMetamodelManager metamodelManager, @NonNull Resource separateResource) {
			this.metamodelManager = metamodelManager;
			this.separateResource = separateResource;
		}

		@Override
		public EObject caseClass(org.eclipse.ocl.pivot.Class object) {
			org.eclipse.ocl.pivot.Package parent = ClassUtil.nonNullState(object.getOwningPackage());
			org.eclipse.ocl.pivot.Package separateParent = getSeparate(parent);
			List<org.eclipse.ocl.pivot.@NonNull Class> separateSiblings = ClassUtil.nullFree(separateParent.getOwnedClasses());
			return cloneNamedElement(separateSiblings, object);
		}

		@Override
		public EObject caseConstraint(Constraint object) {
			NamedElement parent = (NamedElement) ClassUtil.nonNullState(object.eContainer());
			NamedElement separateParent = getSeparate(parent);
			EStructuralFeature eContainingFeature = object.eContainingFeature();
			PivotUtilInternal.resetContainer(object);		// Avoid a child-stealing detection
			if (!eContainingFeature.isMany()) {
				separateParent.eSet(eContainingFeature, object);
			}
			else {
				@SuppressWarnings("unchecked") List<Constraint> eGet = (List<Constraint>)separateParent.eGet(eContainingFeature);
				eGet.add(object);
			}
			return object;
		}

		@Override
		public EObject caseExpressionInOCL(ExpressionInOCL object) {
			NamedElement parent = (NamedElement) ClassUtil.nonNullState(object.eContainer());
			NamedElement separateParent = getSeparate(parent);
			if (separateParent instanceof Operation) {
				PivotUtilInternal.resetContainer(object);
				((Operation)separateParent).setBodyExpression(object);
			}
			if (separateParent instanceof Property) {
				PivotUtilInternal.resetContainer(object);
				((Property)separateParent).setOwnedExpression(object);
			}
			return object;
		}

		@Override
		public EObject caseModel(Model object) {
			String name = object.getName();
			EObject container = object.eContainer();
			assert container == null;
			List<EObject> separateSiblings = separateResource.getContents();
			Model separateObject = (Model) getElementByName(separateSiblings, name);
			if (separateObject == null) {
				separateObject = PivotFactory.eINSTANCE.createModel();
				separateObject.setExternalURI(separateResource.getURI().toString());
				separateSiblings.add(separateObject);
				//				metamodelManager.addRoot(separateObject);
			}
			return separateObject;
		}

		@Override
		public EObject caseOperation(Operation object) {
			org.eclipse.ocl.pivot.Class parent = ClassUtil.nonNullState(object.getOwningClass());
			org.eclipse.ocl.pivot.Class separateParent = getSeparate(parent);
			List<Operation> separateSiblings = separateParent.getOwnedOperations();
			@SuppressWarnings("serial")
			EcoreUtil.Copier copier = new EcoreUtil.Copier(false, true)
			{
				@Override
				protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
					if (eReference == PivotPackage.Literals.OPERATION__OWNED_PARAMETERS) {
						super.copyContainment(eReference, eObject, copyEObject);
					}
				}
			};
			Operation clone = (Operation) copier.copy(object);
			copier.copyReferences();
			separateSiblings.add(clone);
			return clone;
		}

		@Override
		public EObject casePackage(org.eclipse.ocl.pivot.Package object) {
			String name = object.getName();
			EObject container = object.eContainer();
			assert container instanceof Namespace;
			Namespace parent = (Namespace) container;
			Namespace separateParent = (Namespace) map.get(parent);
			if (separateParent == null) {
				separateParent = (Namespace) doSwitch(parent);
				map.put(parent, separateParent);
			}
			List<org.eclipse.ocl.pivot.Package> separateSiblings;
			if (separateParent instanceof Model) {
				separateSiblings = ((Model)separateParent).getOwnedPackages();
			}
			else {
				separateSiblings = ((org.eclipse.ocl.pivot.Package)separateParent).getOwnedPackages();
			}
			org.eclipse.ocl.pivot.Package separateObject = NameUtil.getNameable(ClassUtil.<org.eclipse.ocl.pivot.Package>nullFree(separateSiblings), name);
			if (separateObject == null) {
				separateObject = (org.eclipse.ocl.pivot.Package) object.eClass().getEPackage().getEFactoryInstance().create(object.eClass());
				separateObject.setName(name);
				separateObject.setURI(object.getURI());
				separateObject.setNsPrefix(object.getNsPrefix());
				separateSiblings.add(separateObject);
			}
			return separateObject;
		}

		@Override
		public EObject caseProperty(Property object) {
			org.eclipse.ocl.pivot.Class parent = ClassUtil.nonNullState(object.getOwningClass());
			org.eclipse.ocl.pivot.Class separateParent = getSeparate(parent);
			List<Property> separateSiblings = separateParent.getOwnedProperties();
			@SuppressWarnings("serial")
			EcoreUtil.Copier copier = new EcoreUtil.Copier(false, true)
			{
				@Override
				protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
				}
			};
			Property clone = (Property) copier.copy(object);
			copier.copyReferences();
			separateSiblings.add(clone);
			return clone;
		}

		//		@Override
		//		public EObject caseType(Type object) {
		//			org.eclipse.ocl.pivot.Package parent = object.getPackage();
		//			org.eclipse.ocl.pivot.Package separateParent = getSeparate(parent);
		//			List<org.eclipse.ocl.pivot.Class> separateSiblings = separateParent.getOwnedType();
		//			return cloneNamedElement(separateSiblings, object);
		//		}

		protected <@NonNull T extends NamedElement> T cloneNamedElement(List<T> separateSiblings, T object) {
			String name = object.getName();
			@Nullable T separateObject = NameUtil.getNameable(separateSiblings, name);
			if (separateObject == null) {
				@SuppressWarnings("unchecked")@NonNull T castObject = (T) object.eClass().getEPackage().getEFactoryInstance().create(object.eClass());
				separateObject = castObject;
				separateObject.setName(name);
				separateSiblings.add(separateObject);
			}
			return separateObject;
		}

		@Override
		public @NonNull EObject doSwitch(EObject eObject)
		{
			return ClassUtil.nonNullState(super.doSwitch(eObject));
		}

		public NamedElement getElementByName(Iterable<? extends EObject> elements, String name) {
			if (elements == null)
				return null;
			for (EObject element : elements)
				if ((element instanceof NamedElement) && ClassUtil.safeEquals(name, ((NamedElement)element).getName()))
					return (NamedElement)element;
			return null;
		}

		protected <@NonNull T extends NamedElement> T getSeparate(T element) {
			NamedElement separate = map.get(element);
			if (separate == null) {
				separate = (NamedElement) doSwitch(element);
				map.put(element, separate);
			}
			@SuppressWarnings("unchecked")
			T castSeparate = (T) separate;
			return castSeparate;
		}

		protected org.eclipse.ocl.pivot.Package getSeparatePackage(org.eclipse.ocl.pivot.@NonNull Package element) {
			org.eclipse.ocl.pivot.Package separate = (org.eclipse.ocl.pivot.Package) map.get(element);
			if (separate == null) {
				separate = (org.eclipse.ocl.pivot.Package) doSwitch(element);
				map.put(element, separate);
			}
			return separate;
		}
	}
}
