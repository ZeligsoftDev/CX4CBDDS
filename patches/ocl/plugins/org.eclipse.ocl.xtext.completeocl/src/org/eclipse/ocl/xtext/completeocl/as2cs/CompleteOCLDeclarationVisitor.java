/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.as2cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;

import com.google.common.collect.Lists;

public class CompleteOCLDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	public CompleteOCLDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	protected TypedRefCS convertTypeRef(@NonNull TypedElement object) {
		Type type = object.getType();
		if (type == null) {
			return null;
		}
		TypedRefCS typeRef = context.visitReference(TypedRefCS.class, type, null);
		//		int upper = object.getUpper().intValue();
		//		if (upper == 1) {
		return typeRef;
		//		}
		//		int lower = object.getLower().intValue();
		//		CollectionTypeCS collectionTypeCS = EssentialOCLCSFactory.eINSTANCE.createCollectionTypeCS();
		//		collectionTypeCS.setOwnedType(typeRef);
		//		collectionTypeCS.setName(ElementUtil.getCollectionName(object.isOrdered(), object.isUnique()));
		//		return collectionTypeCS;
	}

	protected void gatherPackages(@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> allPackages, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> nestedPackages) {
		allPackages.addAll(nestedPackages);
		for (org.eclipse.ocl.pivot.@NonNull Package nestedPackage : nestedPackages) {
			List<org.eclipse.ocl.pivot.@NonNull Package> nestedNestedPackages = ClassUtil.nullFree(nestedPackage.getOwnedPackages());
			assert nestedNestedPackages != null;
			gatherPackages(allPackages, nestedNestedPackages);
		}
	}

	protected void importPackage(org.eclipse.ocl.pivot.@NonNull Package aPackage) {
		context.importNamespace(aPackage, null);
		org.eclipse.ocl.pivot.Package nestingPackage = null;
		while ((nestingPackage = aPackage.getOwningPackage()) != null) {
			aPackage = nestingPackage;
			context.importNamespace(aPackage, null);
		}
	}

	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces) {
		EObject eObject = csResource.getContents().get(0);
		if (eObject instanceof CompleteOCLDocumentCS) {
			context.createImports((CompleteOCLDocumentCS) eObject, importedNamespaces);
		}
	}

	protected void refreshPathNamedElement(@NonNull PathNameDeclCS csDecl, @NonNull NamedElement namedElement, Namespace scope) {
		PathNameCS csPathName = csDecl.getOwnedPathName();
		if (csPathName == null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csDecl.setOwnedPathName(csPathName);
		}
		context.refreshPathName(csPathName, namedElement, scope);
	}

	@Override
	public ElementCS visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		List<Constraint> ownedInvariant = object.getOwnedInvariants();
		if (ownedInvariant.size() <= 0) {
			return null;
		}
		org.eclipse.ocl.pivot.Package objectPackage = object.getOwningPackage();
		ClassifierContextDeclCS csContext = context.refreshElement(ClassifierContextDeclCS.class, CompleteOCLCSPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS, object);
		if (objectPackage != null) {
			refreshPathNamedElement(csContext, object, objectPackage);
			importPackage(objectPackage);
			context.refreshList(csContext.getOwnedInvariants(), context.visitDeclarations(ConstraintCS.class, ownedInvariant, null));
		}
		return csContext;
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSPackage.Literals.CONSTRAINT_CS, object);
		Namespace namespace = PivotUtil.getNamespace(object);
		LanguageExpression specification = object.getOwnedSpecification();
		if ((specification != null) && (namespace != null)) {
			specification.accept(this);					// Deep search for references
			ExpSpecificationCS csSpec = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
			csElement.setOwnedSpecification(csSpec);
			//
			PivotMetamodelManager metamodelManager = context.getMetamodelManager();
			PrettyPrintOptions.Global prettyPrintOptions = PrettyPrinter.createOptions(null); //metamodelManager.getPrimaryElement(namespace));
			@NonNull List<@NonNull String> newArrayList = Lists.newArrayList("body", "context", "def", "endpackage", "inv", "package", "post", "inv");
			prettyPrintOptions.addReservedNames(newArrayList);	// FIXME use grammar
			prettyPrintOptions.setEnvironmentFactory(metamodelManager.getEnvironmentFactory());
			prettyPrintOptions.setLinelength(80);
			Resource resource = object.eResource();
			AliasAnalysis adapter = resource != null ? AliasAnalysis.getAdapter(resource) : null;
			if (adapter != null) {
				for (@NonNull CompletePackage aliased : adapter.getAliases()) {
					org.eclipse.ocl.pivot.Package primary = aliased.getPrimaryPackage();
					if (primary != null) {
						String alias = adapter.getAlias(primary, null);
						if (alias != null) {
							prettyPrintOptions.addAliases(primary, alias);
						}
					}
				}
			}
			// FIXME BUG 419132 Need to do this in a deferred pass
			String expr = PrettyPrinter.print(specification, prettyPrintOptions);
			csSpec.setExprString("\t" + expr.trim().replaceAll("\\r", "").replaceAll("\\n", "\n\t\t"));
		}
		else {
			ExpSpecificationCS csSpec = EssentialOCLCSFactory.eINSTANCE.createExpSpecificationCS();
			csElement.setOwnedSpecification(csSpec);
			csSpec.setExprString("\tnull");
		}
		return csElement;
	}

	@Override
	public ElementCS visitDataType(@NonNull DataType object) {
		return visitClass(object);
	}

	@Override
	public ElementCS visitEnumeration(org.eclipse.ocl.pivot.@NonNull Enumeration object) {
		return visitClass(object);
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		safeVisit(object.getOwnedBody());
		return super.visitExpressionInOCL(object);
	}

	@Override
	public ElementCS visitOperation(@NonNull Operation object) {
		if ((object.getOwnedPreconditions().size() <= 0) && (object.getBodyExpression() == null) && (object.getOwnedPostconditions().size() <= 0)) {
			return null;
		}
		org.eclipse.ocl.pivot.Class modelType = object.getOwningClass();
		org.eclipse.ocl.pivot.Package modelPackage = modelType.getOwningPackage();
		org.eclipse.ocl.pivot.Class savedScope = context.setScope(modelType);
		OperationContextDeclCS csContext = context.refreshElement(OperationContextDeclCS.class, CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS, object);
		refreshPathNamedElement(csContext, object, modelPackage);
		//		csContext.getNamespace().add(owningType);
		csContext.setOwnedType(convertTypeRef(object));
		org.eclipse.ocl.pivot.Package owningPackage = object.getOwningClass().getOwningPackage();
		if (owningPackage != null) {
			importPackage(owningPackage);
		}
		context.refreshList(csContext.getOwnedParameters(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameters(), null));
		context.refreshList(csContext.getOwnedPreconditions(), context.visitDeclarations(ConstraintCS.class, object.getOwnedPreconditions(), null));
		context.refreshList(csContext.getOwnedPostconditions(), context.visitDeclarations(ConstraintCS.class, object.getOwnedPostconditions(), null));
		context.refreshList(csContext.getOwnedBodies(), context.visitDeclarationAsList(ExpSpecificationCS.class, object.getBodyExpression()));
		context.setScope(savedScope);
		return csContext;
	}

	@Override
	public ElementCS visitPackage(org.eclipse.ocl.pivot.@NonNull Package object) {
		ElementCS csElement = null;
		assert object.eContainer() != null;
		List<@NonNull ContextDeclCS> contexts = new ArrayList<>();
		for (org.eclipse.ocl.pivot.@NonNull Class type : ClassUtil.nullFree(object.getOwnedClasses())) {
			ClassifierContextDeclCS classifierContext = context.visitDeclaration(ClassifierContextDeclCS.class, type);
			if (classifierContext !=  null) {
				contexts.add(classifierContext);
			}
			for (@NonNull Operation operation : ClassUtil.nullFree(type.getOwnedOperations())) {
				OperationContextDeclCS operationContext = context.visitDeclaration(OperationContextDeclCS.class, operation);
				if (operationContext !=  null) {
					contexts.add(operationContext);
				}
			}
			for (@NonNull Property property : ClassUtil.nullFree(type.getOwnedProperties())) {
				PropertyContextDeclCS propertyContext = context.visitDeclaration(PropertyContextDeclCS.class, property);
				if (propertyContext !=  null) {
					contexts.add(propertyContext);
				}
			}
		}
		if (contexts.size() > 0) {
			PackageDeclarationCS csPackage = context.refreshElement(PackageDeclarationCS.class, CompleteOCLCSPackage.Literals.PACKAGE_DECLARATION_CS, object);
			//			context.refreshList(csPackage.getOwnedType(), context.visitDeclarations(ClassifierCS.class, object.getOwnedType(), null));
			refreshPathNamedElement(csPackage, object, PivotUtil.getContainingNamespace(object));
			importPackage(object);
			context.refreshList(csPackage.getOwnedContexts(), contexts);
			csElement = csPackage;
		}
		return csElement;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) {
		//		VariableCS csElement = context.refreshNamedElement(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, object);
		ParameterCS csElement = context.refreshNamedElement(ParameterCS.class, BaseCSPackage.Literals.PARAMETER_CS, object);
		csElement.setOwnedType(convertTypeRef(object));
		return csElement;
	}

	@Override
	public @Nullable ElementCS visitPrimitiveType(@NonNull PrimitiveType object) {
		return visitClass(object);
	}

	@Override
	public ElementCS visitProperty(@NonNull Property object) {
		if (object.getOwnedExpression() == null) {
			return null;
		}
		org.eclipse.ocl.pivot.Class modelType = object.getOwningClass();
		org.eclipse.ocl.pivot.Package modelPackage = modelType.getOwningPackage();
		org.eclipse.ocl.pivot.Class savedScope = context.setScope(modelType);
		PropertyContextDeclCS csContext = context.refreshElement(PropertyContextDeclCS.class, CompleteOCLCSPackage.Literals.PROPERTY_CONTEXT_DECL_CS, object);
		if (modelPackage != null) {
			refreshPathNamedElement(csContext, object, modelPackage);
			//		csContext.getNamespace().add(owningType);
			csContext.setOwnedType(convertTypeRef(object));
			importPackage(modelPackage);
			// FIXME derivationInvariants here rather than in Classifier
			//			context.refreshList(csContext.getRules(), context.visitDeclarations(ContextConstraintCS.class, ownedRule, null));
			context.refreshList(csContext.getOwnedDefaultExpressions(), context.visitDeclarationAsList(ExpSpecificationCS.class, object.getOwnedExpression()));
			context.setScope(savedScope);
		}
		return csContext;
	}

	protected <T extends ConstraintCS> void refreshPropertyConstraints(@NonNull Class<T> csConstraintClass, @NonNull List<@NonNull ? super T> csPropertyConstraints, Property object) {
		@Nullable T csConstraint = null;
		LanguageExpression defaultExpression = object.getOwnedExpression();
		if (defaultExpression != null) {
			csConstraint = context.visitDeclaration(csConstraintClass, defaultExpression);
		}
		if (csConstraint != null) {
			csConstraint.setStereotype(PivotConstants.DERIVATION_NAME);
			context.refreshList(csPropertyConstraints, Collections.singletonList(csConstraint));
		}
		else {
			csPropertyConstraints.clear();
		}
	}

	@Override
	public ElementCS visitModel(@NonNull Model object) {
		ElementCS csElement;
		assert object.eContainer() == null;
		CompleteOCLDocumentCS csDocument = context.refreshElement(CompleteOCLDocumentCS.class, CompleteOCLCSPackage.Literals.COMPLETE_OCL_DOCUMENT_CS, object);
		List<org.eclipse.ocl.pivot.@NonNull Package> allPackages = new ArrayList<>();
		List<org.eclipse.ocl.pivot.@NonNull Package> nestedPackages = ClassUtil.nullFree(object.getOwnedPackages());
		assert nestedPackages != null;
		gatherPackages(allPackages, nestedPackages);
		context.refreshList(csDocument.getOwnedPackages(), context.visitDeclarations(PackageDeclarationCS.class, allPackages, null));
		csElement = csDocument;
		return csElement;
	}

	@Override
	public ElementCS visitType(@NonNull Type object) {
		return null;
	}
}
