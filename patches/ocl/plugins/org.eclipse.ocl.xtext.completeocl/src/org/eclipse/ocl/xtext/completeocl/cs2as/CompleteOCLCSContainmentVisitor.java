/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.cs2as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.DefCS;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.util.AbstractCompleteOCLCSContainmentVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;

public class CompleteOCLCSContainmentVisitor extends AbstractCompleteOCLCSContainmentVisitor
{
	public class OperationDeclScopeFilter implements ScopeFilter
	{
		protected final @NonNull OperationContextDeclCS csElement;

		public OperationDeclScopeFilter(@NonNull OperationContextDeclCS csElement) {
			this.csElement = csElement;
		}

		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			if (object instanceof Iteration) {
				return false;
			}
			if (object instanceof Operation) {
				Element owningElement = null;
				EObject csContainer = csElement.eContainer();
				List<PathElementCS> csPathElements = csElement.getOwnedPathName().getOwnedPathElements();
				if (csPathElements.size() > 1) {
					owningElement = csPathElements.get(csPathElements.size()-2).basicGetReferredElement();
				} else if (csContainer instanceof ClassifierContextDeclCS) {
					owningElement = ((ClassifierContextDeclCS)csContainer).getReferredClass();
				}
				if (!(owningElement instanceof Type)) {
					return false;
				}
				CompleteModel completeModel = environmentView.getEnvironmentFactory().getCompleteModel();
				CompleteClass owningCompleteClass = completeModel.getCompleteClass((Type) owningElement);
				Operation candidateOperation = (Operation)object;
				Type candidateClass = candidateOperation.getOwningClass();
				if (candidateClass == null) {
					return false;
				}
				CompleteClass candidateCompleteClass = completeModel.getCompleteClass(candidateClass);
				if (candidateCompleteClass != owningCompleteClass) {
					return false;
				}
				List<Parameter> candidateParameters = candidateOperation.getOwnedParameters();
				List<ParameterCS> csParameters = csElement.getOwnedParameters();
				assert csParameters != null;
				int iMax = csParameters.size();
				if (iMax != candidateParameters.size()) {
					return false;
				}
				return true;
			}
			else {
				return false;
			}
		}
	}

	public CompleteOCLCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	private org.eclipse.ocl.pivot.@NonNull Class contextClass(org.eclipse.ocl.pivot.@NonNull Class modelClass,
			@NonNull List<@NonNull ContextDeclCS> contextDecls) {
		List<@NonNull ConstraintCS> allInvariants = new ArrayList<>();
		List<@NonNull ClassifierContextDeclCS> classifierContextDecls = new ArrayList<>();
		List<@NonNull OperationContextDeclCS> operationContextDecls = new ArrayList<>();
		List<@NonNull PropertyContextDeclCS> propertyContextDecls = new ArrayList<>();
		List<@NonNull DefOperationCS> defOperations = new ArrayList<>();
		List<@NonNull DefPropertyCS> defProperties = new ArrayList<>();
		for (@NonNull ContextDeclCS contextDecl : contextDecls) {
			if (contextDecl instanceof ClassifierContextDeclCS) {
				ClassifierContextDeclCS classifierContextDecl = (ClassifierContextDeclCS)contextDecl;
				classifierContextDecls.add(classifierContextDecl);
				allInvariants.addAll(ClassUtil.nullFree(classifierContextDecl.getOwnedInvariants()));
				for (@NonNull DefCS csDef : ClassUtil.nullFree(classifierContextDecl.getOwnedDefinitions())) {
					if (csDef instanceof DefOperationCS) {
						defOperations.add((DefOperationCS) csDef);
					}
					else if (csDef instanceof DefPropertyCS) {
						defProperties.add((DefPropertyCS) csDef);
					}
				}
			}
			else if (contextDecl instanceof OperationContextDeclCS) {
				operationContextDecls.add((OperationContextDeclCS) contextDecl);
			}
			else if (contextDecl instanceof PropertyContextDeclCS) {
				PropertyContextDeclCS propertyContextDecl = (PropertyContextDeclCS) contextDecl;
				propertyContextDecls.add(propertyContextDecl);
				//	allInvariants.addAll(ClassUtil.nullFree(propertyContextDecl.getOwnedDerivedInvariants()));
			}
		}
		List<@NonNull Operation> contextOperations = new ArrayList<>();
		for (@NonNull OperationContextDeclCS operationContextDecl : operationContextDecls) {
			Operation contextOperation = contextOperation(operationContextDecl);
			contextOperations.add(contextOperation);
		}
		for (@NonNull DefOperationCS defOperation : defOperations) {
			Operation contextOperation = PivotUtil.getPivot(Operation.class, defOperation);
			if (contextOperation != null) {
				contextOperations.add(contextOperation);
			}
		}
		Collections.sort(contextOperations, NameUtil.NAMEABLE_COMPARATOR);
		List<@NonNull Property> contextProperties = new ArrayList<>();
		for (@NonNull PropertyContextDeclCS propertyContextDecl : propertyContextDecls) {
			Property contextProperty = contextProperty(propertyContextDecl);
			contextProperties.add(contextProperty);
		}
		for (@NonNull DefPropertyCS defProperty : defProperties) {
			Property contextProperty = PivotUtil.getPivot(Property.class, defProperty);
			if (contextProperty != null) {
				contextProperties.add(contextProperty);
			}
		}
		Collections.sort(contextProperties, NameUtil.NAMEABLE_COMPARATOR);
		ClassifierContextDeclCS csElement = classifierContextDecls.size() > 0 ? classifierContextDecls.get(0) : null;
		org.eclipse.ocl.pivot.Class contextClass = context.refreshModelElement(org.eclipse.ocl.pivot.Class.class, PivotPackage.Literals.CLASS, csElement);
		contextClass.setName(modelClass.getName());
		context.refreshPivotList(Constraint.class, contextClass.getOwnedInvariants(), allInvariants);
		helper.refreshList(contextClass.getOwnedOperations(), contextOperations);
		helper.refreshList(contextClass.getOwnedProperties(), contextProperties);
		context.refreshComments(contextClass, csElement);
		for (@NonNull ContextDeclCS contextDecl : contextDecls) {
			if (contextDecl instanceof ClassifierContextDeclCS) {
				context.installPivotUsage(contextDecl, contextClass);
			}
		}
		return contextClass;
	}

	private @NonNull Operation contextOperation(@NonNull OperationContextDeclCS operationContextDecl) {
		Operation contextOperation = context.refreshModelElement(Operation.class, PivotPackage.Literals.OPERATION, operationContextDecl);
		Operation modelOperation = operationContextDecl.getReferredOperation();
		if (modelOperation != null) {
			helper.refreshName(contextOperation, ClassUtil.nonNullModel(modelOperation.getName()));
			helper.setType(contextOperation, modelOperation.getType(), modelOperation.isIsRequired());
			List<ExpSpecificationCS> ownedBodies = operationContextDecl.getOwnedBodies();
			ExpSpecificationCS ownedBody = ownedBodies.size() > 0 ? ownedBodies.get(0) : null;
			LanguageExpression languageExpression = ownedBody != null ? PivotUtil.getPivot(LanguageExpression.class,  ownedBody) : null;
			contextOperation.setBodyExpression(languageExpression);
			context.refreshPivotList(Parameter.class, contextOperation.getOwnedParameters(), operationContextDecl.getOwnedParameters());
			context.refreshPivotList(Constraint.class, contextOperation.getOwnedPreconditions(), operationContextDecl.getOwnedPreconditions());
			context.refreshPivotList(Constraint.class, contextOperation.getOwnedPostconditions(), operationContextDecl.getOwnedPostconditions());
		}
		context.refreshComments(contextOperation, operationContextDecl);
		return contextOperation;
	}

	private org.eclipse.ocl.pivot.@NonNull Package contextPackage(org.eclipse.ocl.pivot.@NonNull Package modelPackage,
			@NonNull List<@NonNull PackageDeclarationCS> packageDecls, @NonNull List<@NonNull ContextDeclCS> contextDecls) {
		List<@NonNull ConstraintCS> packageInvariants = new ArrayList<>();
		List<@NonNull ContextDeclCS> allContextDecls = new ArrayList<>(contextDecls);
		for (@NonNull PackageDeclarationCS packageDecl : packageDecls) {
			packageInvariants.addAll(ClassUtil.nullFree(packageDecl.getOwnedInvariants()));
			allContextDecls.addAll(ClassUtil.nullFree(packageDecl.getOwnedContexts()));
		}
		Set<org.eclipse.ocl.pivot.@NonNull Class> modelClasses = new HashSet<>();
		for (@NonNull ContextDeclCS contextDecl : allContextDecls) {
			org.eclipse.ocl.pivot.Class modelClass = getReferredClass(contextDecl);
			if (modelClass != null) {
				modelClasses.add(modelClass);
			}
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> sortedModelClasses = new ArrayList<>(modelClasses);
		Collections.sort(sortedModelClasses, NameUtil.NAMEABLE_COMPARATOR);
		List<org.eclipse.ocl.pivot.@NonNull Class> contextClasses = new ArrayList<>();
		for (org.eclipse.ocl.pivot.@NonNull Class modelClass : sortedModelClasses) {
			List<@NonNull ContextDeclCS> selectedContexts = new ArrayList<>();
			for (@NonNull ContextDeclCS csContext : allContextDecls) {
				org.eclipse.ocl.pivot.Class asClass = getReferredClass(csContext);
				if (modelClass == asClass) {
					selectedContexts.add(csContext);
				}
			}
			org.eclipse.ocl.pivot.Class contextClass = contextClass(modelClass, selectedContexts);
			contextClasses.add(contextClass);
		}
		PackageDeclarationCS csElement = packageDecls.size() > 0 ? packageDecls.get(0) : null;
		org.eclipse.ocl.pivot.Package contextPackage = context.refreshModelElement(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, csElement);
		contextPackage.setName(modelPackage.getName());
		contextPackage.setURI(modelPackage.getURI());
		helper.refreshList(contextPackage.getOwnedClasses(), contextClasses);
		context.refreshComments(contextPackage, csElement);
		for (int i = 1; i < packageDecls.size(); i++) {
			csElement = packageDecls.get(i);
			context.installPivotUsage(csElement, contextPackage);
		}
		return contextPackage;
	}

	private org.eclipse.ocl.pivot.@Nullable Package contextPackageParent(@NonNull Map<org.eclipse.ocl.pivot.@NonNull Package, org.eclipse.ocl.pivot.@NonNull Package> modelPackage2contextPackage,
			org.eclipse.ocl.pivot.@NonNull Package modelPackage, Map<org.eclipse.ocl.pivot.@Nullable Package, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package>> contextPackage2childContextPackages) {
		org.eclipse.ocl.pivot.Package contextPackage = modelPackage2contextPackage.get(modelPackage);
		assert contextPackage != null;
		org.eclipse.ocl.pivot.Package parentContextPackage = null;
		org.eclipse.ocl.pivot.Package parentModelPackage = modelPackage.getOwningPackage();
		if (parentModelPackage != null) {
			parentContextPackage = modelPackage2contextPackage.get(parentModelPackage);
			if (parentContextPackage == null) {
				parentContextPackage = context.refreshModelElement(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, null);
				parentContextPackage.setName(modelPackage.getName());
				parentContextPackage.setURI(modelPackage.getURI());
				modelPackage2contextPackage.put(parentModelPackage, parentContextPackage);
			}
			contextPackageParent(modelPackage2contextPackage, parentModelPackage, contextPackage2childContextPackages);
		}
		List<org.eclipse.ocl.pivot.@NonNull Package> childContextPackages = contextPackage2childContextPackages.get(parentContextPackage);			// null key for Model root
		if (childContextPackages == null) {
			childContextPackages = new ArrayList<>();
			contextPackage2childContextPackages.put(parentContextPackage, childContextPackages);
		}
		if (!childContextPackages.contains(contextPackage)) {
			childContextPackages.add(contextPackage);
		}
		return parentContextPackage;
	}

	private @NonNull Property contextProperty(@NonNull PropertyContextDeclCS propertyContextDecl) {
		Property contextProperty = context.refreshModelElement(Property.class, PivotPackage.Literals.PROPERTY, propertyContextDecl);
		Property modelProperty = propertyContextDecl.getReferredProperty();
		if (modelProperty != null) {
			helper.refreshName(contextProperty, ClassUtil.nonNullModel(modelProperty.getName()));
			helper.setType(contextProperty, modelProperty.getType(), modelProperty.isIsRequired());
			List<ExpSpecificationCS> ownedDefaultExpressions = propertyContextDecl.getOwnedDefaultExpressions();
			int size = ownedDefaultExpressions.size();
			if (size > 1) {
				context.addError(propertyContextDecl, "Only one init/derive value allowed");
			}
			ExpSpecificationCS ownedDefaultExpression = size > 0 ? ownedDefaultExpressions.get(0) : null;
			LanguageExpression languageExpression = ownedDefaultExpression != null ? PivotUtil.getPivot(LanguageExpression.class,  ownedDefaultExpression) : null;
			contextProperty.setOwnedExpression(languageExpression);
		}
		context.refreshComments(contextProperty, propertyContextDecl);
		return contextProperty;
	}

	private org.eclipse.ocl.pivot.@Nullable Class getReferredClass(ContextDeclCS csContext) {
		if (csContext instanceof ClassifierContextDeclCS) {
			return ((ClassifierContextDeclCS)csContext).getReferredClass();
		}
		else if (csContext instanceof OperationContextDeclCS) {
			Operation modelOperation = ((OperationContextDeclCS)csContext).getReferredOperation();
			return modelOperation != null ? modelOperation.getOwningClass() : null;
		}
		else if (csContext instanceof PropertyContextDeclCS) {
			Property modelProperty = ((PropertyContextDeclCS)csContext).getReferredProperty();
			return modelProperty != null ? modelProperty.getOwningClass() : null;
		}
		return null;
	}

	private org.eclipse.ocl.pivot.@Nullable Package getReferredPackage(@NonNull ContextDeclCS csContext) {
		org.eclipse.ocl.pivot.Class modelClass = getReferredClass(csContext);
		return modelClass != null ? modelClass.getOwningPackage() : null;
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS csElement) {
		//
		//	Locate the model packages that need context packages
		//
		Set<org.eclipse.ocl.pivot.@NonNull Package> modelPackages = new HashSet<>();
		List<@NonNull PackageDeclarationCS> ownedPackages = ClassUtil.nullFree(csElement.getOwnedPackages());
		for (@NonNull PackageDeclarationCS csPackage : ownedPackages) {
			org.eclipse.ocl.pivot.Package modelPackage = csPackage.getReferredPackage();
			if (modelPackage != null) {
				modelPackages.add(modelPackage);
				for (org.eclipse.ocl.pivot.Package parentModelPackage = modelPackage; (parentModelPackage = parentModelPackage.getOwningPackage()) != null; ) {
					modelPackages.add(parentModelPackage);
				}
			}
		}
		List<@NonNull ContextDeclCS> ownedContexts = ClassUtil.nullFree(csElement.getOwnedContexts());
		for (@NonNull ContextDeclCS csContext : ownedContexts) {
			org.eclipse.ocl.pivot.Package modelPackage = getReferredPackage(csContext);
			if (modelPackage != null) {
				modelPackages.add(modelPackage);
				for (org.eclipse.ocl.pivot.Package parentModelPackage = modelPackage; (parentModelPackage = parentModelPackage.getOwningPackage()) != null; ) {
					modelPackages.add(parentModelPackage);
				}
			}
		}
		//
		//	Refresh the context packages
		//
		Map<org.eclipse.ocl.pivot.@NonNull Package, org.eclipse.ocl.pivot.@NonNull Package> modelPackage2contextPackage = new HashMap<>();
		for (org.eclipse.ocl.pivot.@NonNull Package modelPackage : modelPackages) {
			List<@NonNull PackageDeclarationCS> selectedPackageDecls = new ArrayList<>();
			for (@NonNull PackageDeclarationCS csPackage : ownedPackages) {
				org.eclipse.ocl.pivot.Package asPackage = csPackage.getReferredPackage();
				if (modelPackage == asPackage) {
					selectedPackageDecls.add(csPackage);
				}
			}
			List<@NonNull ContextDeclCS> selectedContexts = new ArrayList<>();
			for (@NonNull ContextDeclCS csContext : ownedContexts) {
				org.eclipse.ocl.pivot.Package asPackage = getReferredPackage(csContext);
				if (modelPackage == asPackage) {
					selectedContexts.add(csContext);
				}
			}
			org.eclipse.ocl.pivot.Package contextPackage = contextPackage(modelPackage, selectedPackageDecls, selectedContexts);
			org.eclipse.ocl.pivot.Package oldPackage = modelPackage2contextPackage.put(modelPackage, contextPackage);
			assert oldPackage == null;
		}
		//
		//	Identify the context package ancestry corresponding to the model package ancestry.
		//	(Use null as the root Package).
		//
		Map<org.eclipse.ocl.pivot.@Nullable Package, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package>> contextPackage2childContextPackages = new HashMap<>();
		for (org.eclipse.ocl.pivot.@NonNull Package modelPackage : modelPackages) {
			contextPackageParent(modelPackage2contextPackage, modelPackage, contextPackage2childContextPackages);
		}
		//
		//	Refresh the context package ancestry.
		//
		Model contextRoot = refreshRoot(Model.class, PivotPackage.Literals.MODEL, csElement);
		for (org.eclipse.ocl.pivot.@Nullable Package contextPackage : contextPackage2childContextPackages.keySet()) {
			List<org.eclipse.ocl.pivot.@NonNull Package> childContextPackages = contextPackage2childContextPackages.get(contextPackage);
			assert childContextPackages != null;
			Collections.sort(childContextPackages, NameUtil.NAMEABLE_COMPARATOR);
			if (contextPackage != null) {
				helper.refreshList(contextPackage.getOwnedPackages(), childContextPackages);
			}
			else {
				helper.refreshList(contextRoot.getOwnedPackages(), childContextPackages);
			}
		}
		context.refreshPivotList(Import.class, contextRoot.getOwnedImports(), csElement.getOwnedImports());
		return null;
	}

	@Override
	public Continuation<?> visitDefOperationCS(@NonNull DefOperationCS csElement) {
		@NonNull Operation contextOperation = refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		context.refreshPivotList(Parameter.class, contextOperation.getOwnedParameters(), csElement.getOwnedParameters());
		ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement.getOwnedSpecification());
		contextOperation.setBodyExpression(pivotSpecification);
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS csElement) {
		@NonNull Property contextProperty = refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, csElement);
		contextProperty.setIsDerived(true);
		contextProperty.setIsReadOnly(true);
		contextProperty.setIsTransient(true);
		contextProperty.setIsVolatile(true);
		contextProperty.setIsResolveProxies(false);
		ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement.getOwnedSpecification());
		contextProperty.setOwnedExpression(pivotSpecification);
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		assert pathName != null;
		CS2AS.setElementType(pathName, PivotPackage.Literals.OPERATION, csElement, new OperationDeclScopeFilter(csElement));
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		assert pathName != null;
		CS2AS.setElementType(pathName, PivotPackage.Literals.PROPERTY, csElement, null);
		return null;
	}
}
