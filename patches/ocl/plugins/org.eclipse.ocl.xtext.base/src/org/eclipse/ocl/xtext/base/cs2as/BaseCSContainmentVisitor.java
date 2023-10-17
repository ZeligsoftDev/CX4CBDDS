/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AnnotationElementCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.DocumentationCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LambdaTypeCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;

public class BaseCSContainmentVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, @NonNull CS2ASConversion>
{
	private static final class NotOperationFilter implements ScopeFilter
	{		// FIXME BUG 388627 workaround for BUG 529771 requirement for arbitrary Element literals
		public static NotOperationFilter INSTANCE = new NotOperationFilter();

		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return !(object instanceof Operation);
		}
	}

	protected final @NonNull PivotMetamodelManager metamodelManager;
	protected final @NonNull StandardLibraryInternal standardLibrary;

	/**
	 * Construction helper.
	 */
	protected final @NonNull PivotHelper helper;

	public BaseCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
		this.metamodelManager = context.getMetamodelManager();
		this.standardLibrary = metamodelManager.getStandardLibrary();
		this.helper = context.getHelper();
	}

	protected PackageId getPackageId(@NonNull PackageCS csElement) {
		return null;
	}

	protected void importPackages(@NonNull RootPackageCS csElement) { // FIXME: CS2AS.computeRootContainmentFeatures may make this redundant
		for (ImportCS csImport : csElement.getOwnedImports()) {
			csImport.getReferredNamespace();					// Resolve the proxy to perform the import.
		}
	}


	protected Continuation<?> refreshClass(org.eclipse.ocl.pivot.@NonNull Class pivotElement, @NonNull StructuredClassCS csElement) {
		pivotElement.setIsAbstract(csElement.isIsAbstract());
		pivotElement.setIsInterface(csElement.isIsInterface());
		//		pivotElement.setIsStatic(qualifiers.contains("static"));
		context.refreshPivotList(Property.class, pivotElement.getOwnedProperties(), csElement.getOwnedProperties());
		context.refreshPivotList(Operation.class, pivotElement.getOwnedOperations(), csElement.getOwnedOperations());
		refreshClassifier(pivotElement, csElement);
		return null;
	}

	protected Type refreshClassifier(org.eclipse.ocl.pivot.@NonNull Class pivotElement, @NonNull ClassCS csElement) {
		if (csElement.eIsSet(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME)) {
			pivotElement.setInstanceClassName(csElement.getInstanceClassName());
		}
		else {
			pivotElement.eUnset(PivotPackage.Literals.CLASS__INSTANCE_CLASS_NAME);
		}
		String newInstanceClassName = csElement.getInstanceClassName();
		String oldInstanceClassName = pivotElement.getInstanceClassName();
		if ((newInstanceClassName != oldInstanceClassName) && ((newInstanceClassName == null) || !newInstanceClassName.equals(oldInstanceClassName))) {
			pivotElement.setInstanceClassName(newInstanceClassName);
		}
		context.refreshTemplateSignature(csElement, pivotElement);
		context.refreshPivotList(Constraint.class, pivotElement.getOwnedInvariants(), csElement.getOwnedConstraints());
		return pivotElement;
	}

	protected @NonNull <T extends NamedElement> T refreshNamedElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull NamedElementCS csElement) {
		T pivotElement = context.refreshModelElement(pivotClass, pivotEClass, csElement);
		String name = csElement.getName();
		if (name != null) {
			helper.refreshName(pivotElement, name);
			context.refreshComments(pivotElement, csElement);
		}
		return pivotElement;
	}

	protected <T extends org.eclipse.ocl.pivot.Package> T refreshPackage(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull PackageCS csElement) {
		assert pivotEClass != null;
		Object pivotObject = context.getConverter().getPivotElement(csElement);
		if (pivotObject == null) {
			pivotObject = context.getOldPackageByQualifiedName(csElement);
		}
		String name = csElement.getName();
		if (name == null) {
			throw new IllegalStateException("Null name");
		}
		/*		if ((name == null) && (csElement.eContainer() == null)) {
			Resource csResource = csElement.eResource();
			if (csResource != null) {
				URI csURI = csResource.getURI();
				if (csURI != null) {
					name = csURI.lastSegment();
				}
			}
		} */
		if (pivotObject == null) {
			pivotObject = context.getOldPackageBySimpleName(name);
		}
		T pivotElement;
		if (pivotObject == null) {
			pivotElement = PivotUtil.createPackage(pivotClass, pivotEClass, name, csElement.getNsURI(), getPackageId(csElement));
		}
		else {
			if (!pivotClass.isAssignableFrom(pivotObject.getClass())) {
				throw new ClassCastException();
			}
			@SuppressWarnings("unchecked")
			T pivotElement2 = (T) pivotObject;
			pivotElement = pivotElement2;
			helper.refreshName(pivotElement, name);
		}
		context.getConverter().installPivotDefinition(csElement, pivotElement);
		context.refreshComments(pivotElement, csElement);
		String newNsPrefix = csElement.getNsPrefix();
		String oldNsPrefix = pivotElement.getNsPrefix();
		if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
			pivotElement.setNsPrefix(newNsPrefix);
		}
		String newNsURI = csElement.getNsURI();
		String oldNsURI = pivotElement.getURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotElement.setURI(newNsURI);
		}
		context.refreshPivotList(org.eclipse.ocl.pivot.Package.class, pivotElement.getOwnedPackages(), csElement.getOwnedPackages());
		context.refreshPivotList(org.eclipse.ocl.pivot.Class.class, pivotElement.getOwnedClasses(), csElement.getOwnedClasses());
		return pivotElement;
	}

	/**
	 * Method used to refresh every {@link RootCS} element.
	 */
	protected <T extends Model> T refreshRoot(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull RootCS csElement) {
		assert pivotEClass != null;
		Resource csResource = csElement.eResource();
		if (csResource == null) {
			throw new IllegalStateException("Null resource for root package");
		}
		Object pivotObject = context.getConverter().getPivotElement(csElement);
		//		Object pivotObject = csElement.getPivot();
		if (pivotObject == null) {
			Resource asResource = context.getConverter().getASResource();
			for (EObject oldRoot : asResource.getContents()) {
				if (oldRoot instanceof Model) {
					pivotObject = oldRoot;
					break;
				}
			}
		}
		URI csURI = csResource.getURI();
		String newExternalURI = csURI != null ? csURI.toString() : null;
		T pivotElement;
		if (pivotObject == null) {
			pivotElement = PivotUtil.createModel(pivotClass, pivotEClass, newExternalURI);
		}
		else {
			if (!pivotClass.isAssignableFrom(pivotObject.getClass())) {
				throw new ClassCastException();
			}
			@SuppressWarnings("unchecked")
			T pivotElement2 = (T) pivotObject;
			pivotElement = pivotElement2;
			String oldExternalURI = pivotElement.getExternalURI();
			if ((newExternalURI != oldExternalURI) && ((newExternalURI == null) || !newExternalURI.equals(oldExternalURI))) {
				pivotElement.setExternalURI(newExternalURI);
			}
		}
		context.getConverter().installPivotDefinition(csElement, pivotElement);
		context.refreshComments(pivotElement, csElement);
		return pivotElement;
	}
	public @NonNull <T extends Model> T createModel(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, String newExternalURI) {
		assert pivotEClass != null;
		@SuppressWarnings("unchecked")
		T pivotElement = (T) pivotEClass.getEPackage().getEFactoryInstance().create(pivotEClass);
		pivotElement.setExternalURI(newExternalURI);
		return pivotElement;
	}


	/**
	 * Method used to refresh every {@link RootPackageCS} element.
	 *
	 * There are some Roots which may own packages like those created in OCLinEcore or StdLin documents
	 */
	protected @NonNull <@NonNull T extends Model> T refreshRootPackage(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull RootPackageCS csElement) {
		@NonNull T pivotElement = refreshRoot(pivotClass, pivotEClass, csElement);
		context.refreshPivotList(org.eclipse.ocl.pivot.Package.class, pivotElement.getOwnedPackages(), csElement.getOwnedPackages());
		return pivotElement;
	}

	@Override
	public Continuation<?> visitAnnotationCS(@NonNull AnnotationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ANNOTATION;
		refreshNamedElement(Annotation.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationElementCS(@NonNull AnnotationElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CONSTRAINT;
		Constraint pivotElement = refreshNamedElement(Constraint.class, eClass, csElement);
		SpecificationCS ownedSpecification = csElement.getOwnedSpecification();
		LanguageExpression pivot;
		if (ownedSpecification != null) {
			pivot = PivotUtil.getPivot(ExpressionInOCL.class, ownedSpecification);
		}
		else {
			pivot = PivotFactory.eINSTANCE.createExpressionInOCL();
		}
		pivotElement.setOwnedSpecification(pivot);
		return null;
	}

	@Override
	public Continuation<?> visitDataTypeCS(@NonNull DataTypeCS csElement) {
		DataType pivotElement;
		if (csElement.isIsPrimitive()) {
			pivotElement = refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, csElement);
		}
		else {
			pivotElement = refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, csElement);
		}
		pivotElement.setIsSerializable(csElement.isIsSerializable());
		refreshClassifier(pivotElement, csElement);
		Class<?> instanceClass = null;
		String instanceClassName = pivotElement.getInstanceClassName();
		if (instanceClassName != null) {
			try {
				instanceClass = Class.forName(instanceClassName);
			}
			catch (Throwable e) {}
		}
		PrimitiveType behavioralClass = null;
		if (instanceClass != null) {
			behavioralClass = standardLibrary.getBehavioralClass(instanceClass);
			if (behavioralClass != null) {
				String behavioralName = PivotUtil.getName(behavioralClass);
				if (behavioralName.equals(pivotElement.getName())) {
					behavioralClass = null;
				}
			}
		}
		pivotElement.setBehavioralClass(behavioralClass);
		org.eclipse.ocl.pivot.Class asSuperClass = behavioralClass != null ? behavioralClass : context.getStandardLibrary().getOclElementType();
		helper.refreshList(pivotElement.getSuperClasses(), Collections.singletonList(asSuperClass));
		return null;
	}

	@Override
	public Continuation<?> visitDetailCS(@NonNull DetailCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.DETAIL;
		refreshNamedElement(Detail.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDocumentationCS(@NonNull DocumentationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ANNOTATION;
		refreshNamedElement(Annotation.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitElementCS(@NonNull ElementCS csElement) {
		// FIXME		return visiting(csElement);
		System.out.println("Unsupported " + csElement.eClass().getName() + " for CS2AS Containment pass");
		return null;
	}

	@Override
	public Continuation<?> visitElementRefCS(@NonNull ElementRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationCS(@NonNull EnumerationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ENUMERATION;
		org.eclipse.ocl.pivot.Enumeration pivotElement = refreshNamedElement(org.eclipse.ocl.pivot.Enumeration.class, eClass, csElement);
		context.refreshPivotList(EnumerationLiteral.class, pivotElement.getOwnedLiterals(), csElement.getOwnedLiterals());
		pivotElement.setIsSerializable(csElement.isIsSerializable());
		refreshClassifier(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationLiteralCS(@NonNull EnumerationLiteralCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ENUMERATION_LITERAL;
		EnumerationLiteral pivotElement = refreshNamedElement(EnumerationLiteral.class, eClass, csElement);
		pivotElement.setLiteral(csElement.getLiteral());
		pivotElement.setValue(BigInteger.valueOf(csElement.getValue()));
		return null;
	}

	@Override
	public Continuation<?> visitImplicitOppositeCS(@NonNull ImplicitOppositeCS object) {
		return null;		// Handled by the parent ReferenceCS
	}

	@Override
	public Continuation<?> visitImportCS(@NonNull ImportCS csElement) {
		Import pivotElement = refreshNamedElement(Import.class, PivotPackage.Literals.IMPORT, csElement);
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		if (csElement.isIsAll() && (csElement.getName() != null)) {
			context.addError(csElement, "An all-package import cannot have an associated alias name");
		}
		Namespace namespace = csElement.getReferredNamespace();
		if ((namespace != null) && !namespace.eIsProxy()) {
			Namespace oldNamespace = pivotElement.getImportedNamespace();
			if (namespace != oldNamespace) {
				pivotElement.setImportedNamespace(namespace);
			}
		}
		pivotElement.setXmiidVersion(PivotConstants.XMIIDS_CURRENT);
		return null;								// FIXME: CS2AS.computeRootContainmentFeatures may allow the above now
	}

	@Override
	public Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.ELEMENT, csElement, NotOperationFilter.INSTANCE);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationCS(@NonNull OperationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.OPERATION;
		Operation pivotElement = refreshNamedElement(Operation.class, eClass, csElement);
		context.refreshTemplateSignature(csElement, pivotElement);
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		context.refreshPivotList(Constraint.class, pivotElement.getOwnedPreconditions(), csElement.getOwnedPreconditions());
		context.refreshPivotList(Constraint.class, pivotElement.getOwnedPostconditions(), csElement.getOwnedPostconditions());
		List<SpecificationCS> csBodyExpressions = csElement.getOwnedBodyExpressions();
		SpecificationCS csBodyExpression = csBodyExpressions.size() > 0 ? csBodyExpressions.get(0) : null;
		pivotElement.setBodyExpression(PivotUtil.getPivot(ExpressionInOCL.class, csBodyExpression));
		List<String> qualifiers = csElement.getQualifiers();
		assert qualifiers != null;
		pivotElement.setIsTransient(ElementUtil.getQualifier(qualifiers, "transient", "!transient", false));
		return null;
	}

	@Override
	public Continuation<?> visitPackageCS(@NonNull PackageCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.PACKAGE;
		refreshPackage(org.eclipse.ocl.pivot.Package.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitParameterCS(@NonNull ParameterCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.PARAMETER;
		refreshNamedElement(Parameter.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPathElementCS(@NonNull PathElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPathNameCS(@NonNull PathNameCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitRootPackageCS(@NonNull RootPackageCS csElement) {
		importPackages(csElement);
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.MODEL;
		Model root = refreshRootPackage(Model.class, eClass, csElement);
		EList<ImportCS> csImports = csElement.getOwnedImports();
		if (csImports.size() > 0) {
			List<Import> newImports = new ArrayList<Import>(csImports.size());
			for (ImportCS csImport : csImports) {
				Import pivotElement = PivotUtil.getPivot(Import.class, csImport);
				if (pivotElement != null) {
					pivotElement.setImportedNamespace(csImport.getReferredNamespace());
				}
				newImports.add(pivotElement);
			}
			helper.refreshList(root.getOwnedImports(), newImports);
		}
		else {
			root.getOwnedImports().clear();
		}
		return null;
	}

	@Override
	public Continuation<?> visitSpecificationCS(@NonNull SpecificationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.EXPRESSION_IN_OCL;
		ExpressionInOCL pivotElement = context.refreshModelElement(ExpressionInOCL.class, eClass, csElement);
		pivotElement.setBody(csElement.getExprString());
		return null;
	}

	@Override
	public Continuation<?> visitStructuredClassCS(@NonNull StructuredClassCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CLASS;
		org.eclipse.ocl.pivot.Class pivotElement = refreshNamedElement(org.eclipse.ocl.pivot.Class.class, eClass, csElement);
		refreshClass(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitStructuralFeatureCS(@NonNull StructuralFeatureCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.PROPERTY;
		Property pivotElement = refreshNamedElement(Property.class, eClass, csElement);
		List<String> qualifiers = csElement.getQualifiers();
		pivotElement.setIsComposite(qualifiers.contains("composes"));
		pivotElement.setIsDerived(qualifiers.contains("derived"));
		pivotElement.setIsID(qualifiers.contains("id"));
		pivotElement.setIsReadOnly(qualifiers.contains("readonly"));
		pivotElement.setIsResolveProxies(ElementUtil.getQualifier(qualifiers, "resolve", "!resolve", true));
		pivotElement.setIsStatic(qualifiers.contains("static"));
		pivotElement.setIsTransient(qualifiers.contains("transient"));
		pivotElement.setIsUnsettable(qualifiers.contains("unsettable"));
		pivotElement.setIsVolatile(qualifiers.contains("volatile"));
		pivotElement.setDefaultValueString(csElement.getDefault());
		List<SpecificationCS> csDefaultExpressions = csElement.getOwnedDefaultExpressions();
		SpecificationCS csDefaultExpression = csDefaultExpressions.size() > 0 ? csDefaultExpressions.get(0) : null;
		pivotElement.setOwnedExpression(PivotUtil.getPivot(ExpressionInOCL.class, csDefaultExpression));
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterCS(@NonNull TemplateParameterCS csElement) {
		@SuppressWarnings("unused")
		TemplateParameter pivotElement = refreshNamedElement(TemplateParameter.class, PivotPackage.Literals.TEMPLATE_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.TEMPLATE_SIGNATURE;
		TemplateSignature pivotElement = context.refreshModelElement(TemplateSignature.class, eClass, csElement);
		List<TemplateParameter> newPivotTemplateParameters = new ArrayList<TemplateParameter>();
		List<TemplateParameterCS> csTemplateParameters = csElement.getOwnedParameters();
		for (TemplateParameterCS csTemplateParameter : csTemplateParameters) {
			TemplateParameter pivotTemplateParameter = PivotUtil.getPivot(TemplateParameter.class, csTemplateParameter);
			if (pivotTemplateParameter != null) {
				newPivotTemplateParameters.add(pivotTemplateParameter);
			}
		}
		PivotUtilInternal.refreshList(pivotElement.getOwnedParameters(), newPivotTemplateParameters);
		return null;
	}

	@Override
	public Continuation<?> visitTuplePartCS(@NonNull TuplePartCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS csElement) {
		return null;
	}


	@Override
	public Continuation<?> visitTypeRefCS(@NonNull TypeRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypedRefCS(@NonNull TypedRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		}
		return null;
	}

	@Override
	public Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CLASS;
		org.eclipse.ocl.pivot.Class pivotElement = context.refreshModelElement(org.eclipse.ocl.pivot.Class.class, eClass, null);
		context.installPivotReference(csElement, pivotElement, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
		return null;
	}

	@Override
	public Continuation<?> visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2AS Containment pass");
	}
}
