/*
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.validation;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.AbstractConstraintEvaluator;
import org.eclipse.ocl.pivot.internal.delegate.InvocationBehavior;
import org.eclipse.ocl.pivot.internal.delegate.SettingBehavior;
import org.eclipse.ocl.pivot.internal.delegate.ValidationBehavior;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotDiagnostician;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

/**
 * EcoreOCLEValidator provides the validation support for Ecore elements that exploit OCL.
 * <p>
 * Typically used with a Diagnostician as:
 * <pre>
 *	EValidatorRegistryImpl registry = new EValidatorRegistryImpl();
 *	registry.put(EcorePackage.eINSTANCE, EcoreOCLEValidator.INSTANCE);
 *	Diagnostician diagnostician = new Diagnostician(registry);
 *	Diagnostic diagnostic = dignostician.validate(eObject, validationContext);
 * </pre>
 */
public class EcoreOCLEValidator implements EValidator
{
	private static final @NonNull String CONSTRAINTS_KEY = "constraints";
	public static final @NonNull String UNKNOWN_DETAIL = "Unknown ''{0}'' detail for ''{1}''";
	public static final @NonNull String MISSING_DELEGATE = "Missing ''{0}'' delegate for ''{1}''";
	public static final @NonNull String EXTRA_CONSTRAINTS_ANNOTATION_ENTRY = "Extra ''" + CONSTRAINTS_KEY + "'' annotation entry for {0} ''{1}::{2}''";
	public static final @NonNull String MISSING_CONSTRAINTS_ANNOTATION_ENTRY = "Missing ''" + CONSTRAINTS_KEY + "'' annotation entry for {0} ''{1}::{2}''";
	public static final @NonNull String MISSING_CONSTRAINTS = "Missing ''{0}::{1}'' annotation for ''{2}''";
	public static final @NonNull String PARSING_ERROR_2 = "Parsing error ''{0}'' for ''{1}'' ''{2}''";
	public static final @NonNull String PARSING_ERROR_1 = "Parsing error ''{0}'' for ''{1}''";
	public static final @NonNull String INCOMPATIBLE_TYPE_2 = "Incompatible type ''{0}'' for {1} ''{2}''";
	@Deprecated /* @deprecated not used */
	public static final @NonNull String INCOMPATIBLE_TYPE_1 = "Incompatible type ''{0}'' for ''{1}''";
	public static final @NonNull String NULL_EXPRESSION = "Null expression for ''{0}''";
	public static final @NonNull String NULL_PROPERTY_KEY = "Non-null ''" + SettingBehavior.DERIVATION_CONSTRAINT_KEY + "'' or ''" + SettingBehavior.INITIAL_CONSTRAINT_KEY + "'' detail allowed for ''{0}''";
	public static final @NonNull String EXTRA_PROPERTY_KEY = "Only ''" + SettingBehavior.DERIVATION_CONSTRAINT_KEY + "'' or ''" + SettingBehavior.INITIAL_CONSTRAINT_KEY + "'' detail allowed for ''{0}''";
	public static final @NonNull String DOUBLE_PROPERTY_KEY = "Both ''" + SettingBehavior.DERIVATION_CONSTRAINT_KEY + "'' and ''" + SettingBehavior.INITIAL_CONSTRAINT_KEY + "'' detail for ''{0}''";
	public static final @NonNull String MISSING_PROPERTY_KEY = "Missing ''" + SettingBehavior.DERIVATION_CONSTRAINT_KEY + "'' or ''" + SettingBehavior.INITIAL_CONSTRAINT_KEY + "'' detail for ''{0}''";

	/**
	 * ConstraintEvaluatorWithoutDiagnostics provides the minimal ConstraintEvaluator support for
	 * use when no diagnostics are required.
	 */
	public static class ConstraintEvaluatorWithoutDiagnostics extends AbstractConstraintEvaluator<Boolean>
	{
		public ConstraintEvaluatorWithoutDiagnostics(@NonNull ExpressionInOCL expression) {
			super(expression);
		}

		@Override
		protected String getObjectLabel() {
			throw new UnsupportedOperationException(); // Cannot happen;
		}

		@Override
		protected Boolean handleExceptionResult(@NonNull Throwable e) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleFailureResult(@Nullable Object result) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidExpression(@NonNull String message) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleSuccessResult() {
			return Boolean.TRUE;
		}
	}

	/**
	 * ConstraintEvaluatorWithoutDiagnostics provides the richer ConstraintEvaluator support for
	 * use when diagnostics are required.
	 */
	public static class ConstraintEvaluatorWithDiagnostics extends AbstractConstraintEvaluator<Boolean>
	{
		protected final @NonNull EObject eObject;
		protected final @NonNull DiagnosticChain diagnostics;
		protected final @NonNull EObject diagnosticEObject;
		protected final boolean mayUseNewLines;

		public ConstraintEvaluatorWithDiagnostics(@NonNull ExpressionInOCL expression, @NonNull EObject eObject,
				@NonNull DiagnosticChain diagnostics, @NonNull EObject diagnosticEObject, boolean mayUseNewLines) {
			super(expression);
			this.diagnosticEObject = diagnosticEObject;
			this.eObject = eObject;
			this.diagnostics = diagnostics;
			this.mayUseNewLines = mayUseNewLines;
		}

		@Override
		protected String getObjectLabel() {
			return NameUtil.qualifiedNameFor(eObject);
		}

		@Override
		protected Boolean handleExceptionResult(@NonNull Throwable e) {
			String message = StringUtil.bind(PivotMessagesInternal.ValidationResultIsInvalid_ERROR_, getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.toString());
			if (!mayUseNewLines) {
				message = message.replace("\n", "");
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreValidator.DIAGNOSTIC_SOURCE,
				0, message,  new Object[] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleFailureResult(@Nullable Object result) {
			int severity = getConstraintResultSeverity(result);
			String message = getConstraintResultMessage(result);
			diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
				0, message,  new Object[] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidExpression(@NonNull String message) {
			String message2 = message;
			if (!mayUseNewLines) {
				message2 = message.replace("\n", "");
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE,
				0, message2.replace("\n", " - "), new Object [] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
			String message = StringUtil.bind(PivotMessagesInternal.ValidationResultIsInvalid_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.getLocalizedMessage());
			if (!mayUseNewLines) {
				message = message.replace("\n", "");
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreValidator.DIAGNOSTIC_SOURCE,
				0, message,  new Object[] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleSuccessResult() {
			return Boolean.TRUE;
		}
	}

	/**
	 * WeakOCLReference maintains the reference to the OCL context within the Diagnostician context and
	 * disposes of it once the Diagnostician is done.
	 *
	 * @deprecated use PivotDiagnostician.getOCL
	 */
	@Deprecated
	protected static final class WeakOCLReference extends WeakReference<OCLInternal>	// FIXME Migrate to ThreadLocalExecutor.Terminator
	{
		private static int counter = 0;

		protected final @NonNull OCL ocl;
		private int count;

		protected WeakOCLReference(@NonNull OCLInternal ocl) {
			super(ocl);
			this.ocl = ocl;
			this.count = ++counter;
		//	System.out.println("[" + Thread.currentThread().getName() + "] EcoreOCLEValidator.WeakOCLReference-" + count + ".init()");
		}

		@Override
		public void finalize() {
			new Thread("OCL-Finalizer")		// New thread needed to avoid deadlock hazrad on ocl.dsipose()
			{
				@Override
				public void run() {
				//	System.out.println("[" + Thread.currentThread().getName() + "] EcoreOCLEValidator.WeakOCLReference-" + count + ".finalize()");
					ocl.dispose();
				}
			}.start();
		}
	}

	public static final @NonNull EcoreOCLEValidator INSTANCE = new EcoreOCLEValidator(true);
	public static final @NonNull EcoreOCLEValidator NO_NEW_LINES = new EcoreOCLEValidator(false);
	public static final @NonNull TracingOption VALIDATE_INSTANCE = new TracingOption(PivotPlugin.PLUGIN_ID, "validate/instance");
	public static final @NonNull TracingOption VALIDATE_OPAQUE_ELEMENT = new TracingOption(PivotPlugin.PLUGIN_ID, "validate/opaqueElement");

	protected static void gatherTypes(@NonNull Set<org.eclipse.ocl.pivot.Class> allTypes, @NonNull Set<Constraint> allConstraints, org.eclipse.ocl.pivot.@NonNull Class newType) {
		if (allTypes.add(newType)) {
			allConstraints.addAll(newType.getOwnedInvariants());
			for (org.eclipse.ocl.pivot.Class superType : newType.getSuperClasses()) {
				if (superType != null) {
					gatherTypes(allTypes, allConstraints, superType);
				}
			}
		}
	}

	protected final boolean mayUseNewLines;

	public EcoreOCLEValidator(boolean mayUseNewLines) {
		this.mayUseNewLines = mayUseNewLines;
	}

	private <T extends Element> @Nullable T getASOf(@NonNull EnvironmentFactoryInternalExtension environmentFactory,
			@NonNull Class<@NonNull T> javaClass, @NonNull ENamedElement eNamedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		@Nullable T asElement = null;
		try {
			asElement = environmentFactory.getASOf(javaClass, eNamedElement);
		} catch (ParserException e) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(eNamedElement, context);
				String message = StringUtil.bind(PARSING_ERROR_1, e, objectLabel);
				diagnostics.add(new BasicDiagnostic(PivotUtil.getSeverity(environmentFactory), EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { eNamedElement }));
			}
		}
		/*		if (asElement == null) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(eNamedElement, context);
				String message = StringUtil.bind(PARSING_ERROR_1, null, objectLabel);
				diagnostics.add(new BasicDiagnostic(getSeverity(environmentFactory), EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { eNamedElement }));
			}
		} */
		return asElement;
	}

	/**
	 * Return the Ecore Detail of eNamedElement that should be the data context for a diagnostic message for asExpression.
	 * If a detail cannot be located an EAnnotation of eNamedElement of eNamedElement is returned as a fall-back.
	 *
	 * FIXME This is a workaround for Bug 528355
	 */
	private @NonNull Object getDetailContext(@Nullable LanguageExpression asExpression, @NonNull ENamedElement eNamedElement) {
		if (asExpression == null) {
			return eNamedElement;
		}
		EObject esObject = asExpression.getESObject();
		if (esObject != null) {
			return esObject;
		}
		for (EObject asElement = asExpression; asElement instanceof Element; asElement = asElement.eContainer()) {
			esObject = ((Element)asElement).getESObject();
			if (esObject instanceof EModelElement) {
				break;
			}
		}
		if (esObject == null) {
			return eNamedElement;
		}
		EAnnotation pivotAnnotation = OCLCommon.getDelegateAnnotation(eNamedElement);
		if (pivotAnnotation == null) {
			return eNamedElement;
		}
		EMap<String, String> details = pivotAnnotation.getDetails();
		String detailKey =  null;
		Constraint asConstraint = asExpression.getOwningConstraint();
		if (asConstraint != null) {
			EReference eContainmentFeature = asConstraint.eContainmentFeature();
			String constraintName = asConstraint.getName();
			if (eContainmentFeature == PivotPackage.Literals.CLASS__OWNED_INVARIANTS) {
				detailKey = eNamedElement instanceof EOperation ? "body" : constraintName;
			}
			else if (eContainmentFeature == PivotPackage.Literals.NAMESPACE__OWNED_CONSTRAINTS) {
				detailKey = constraintName;
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
				detailKey = constraintName != null ? "pre_" + constraintName : "pre";
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
				detailKey = constraintName != null ? "post_" + constraintName : "post";
			}
			else {
				detailKey = "body";
			}
		}
		else {
			EReference eContainmentFeature = asExpression.eContainmentFeature();
			if (eContainmentFeature == PivotPackage.Literals.PROPERTY__OWNED_EXPRESSION) {
				detailKey = details.containsKey(SettingBehavior.DERIVATION_CONSTRAINT_KEY) ? SettingBehavior.DERIVATION_CONSTRAINT_KEY : SettingBehavior.INITIAL_CONSTRAINT_KEY;
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
				detailKey = "body";
			}
			else {
				detailKey = "body";
			}
		}
		int index = details.indexOfKey(detailKey);
		if (index >= 0) {
			Entry<String, String> entry = details.get(index);
			return entry != null ? entry : pivotAnnotation;
		}

		/*		EObject asContainer = asExpression.eContainer();
		if (asContainer instanceof Property) {

		}
		else if (asContainer instanceof Operation) {

		}
		else if (asContainer instanceof Constraint) {
			Constraint asConstraint = (Constraint)asContainer;
			EObject asContainerContainer = asConstraint.eContainer();
			EReference eContainmentFeature = asConstraint.eContainmentFeature();
			if (eContainmentFeature == PivotPackage.Literals.CLASS__OWNED_INVARIANTS) {

			}
			else if (asContainerContainer instanceof Operation) {

			}
		}
		else {
		}

		if ((asElement instanceof Operation) && (role != null)) {
			Operation asOperation = (Operation)asElement;	// FIXME workaround Bug 528355 that inhibits use of the detail entry
			if (role.equals("body")) {
				asSpecification = asOperation.getBodyExpression();
			}
			else if (role.equals("pre")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPreconditions(), "");
				if (asConstraint == null) {
					asConstraint = NameUtil.getNameable(asOperation.getOwnedPreconditions(), null);
				}
				requiredType = booleanType;
			}
			else if (role.startsWith("pre_")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPreconditions(), role.substring(4));
				requiredType = booleanType;
			}
			else if (role.equals("post")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPostconditions(), "");
				if (asConstraint == null) {
					asConstraint = NameUtil.getNameable(asOperation.getOwnedPostconditions(), null);
				}
				requiredType = booleanType;
			}
			else if (role.startsWith("post_")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPostconditions(), role.substring(5));
				requiredType = booleanType;
			}
		}
		else if (asElement instanceof Property) {
			Property asProperty = (Property)asElement;
			asSpecification = asProperty.getOwnedExpression();
		}
		else if ((asElement instanceof org.eclipse.ocl.pivot.Class) && (role != null) && (asConstraint == null)) {
			org.eclipse.ocl.pivot.Class asClass = (org.eclipse.ocl.pivot.Class)asElement;
			asConstraint = NameUtil.getNameable(asClass.getOwnedInvariants(), role);
			requiredType = booleanType;
		}
		else if ((asElement instanceof Namespace) && (role != null) && (asConstraint == null)) {
			Namespace asNamespace = (Namespace)asElement;
			asConstraint = NameUtil.getNameable(asNamespace.getOwnedConstraints(), role);
			requiredType = booleanType;
		}
		if ((asSpecification == null) && (asConstraint != null)) {
			asSpecification = asConstraint.getOwnedSpecification();
			requiredType = booleanType;
		}



		EModelElement eModelElement = (EModelElement)esObject;
		EAnnotation pivotAnnotation = OCLCommon.getDelegateAnnotation(eModelElement);
		if (pivotAnnotation == null) {
			return eObject;
		}
		EMap<String, String> details = pivotAnnotation.getDetails();
		int index = details.indexOfKey(asExpression.getName());
		if (index >= 0) {
			Entry<String, String> entry = details.get(index);
			return entry != null ? entry : pivotAnnotation;
		}
		EAnnotation ecoreAnnotation = eModelElement.getEAnnotation(EcorePackage.eNS_URI);
		if (ecoreAnnotation == null) {
			return eObject;
		}
		details = ecoreAnnotation.getDetails();
		index = details.indexOfKey(CONSTRAINTS_KEY);
		if (index >= 0) {
			Entry<String, String> entry = details.get(index);
			return entry != null ? entry : ecoreAnnotation;
		} */
		return eNamedElement;
	}

	/**
	 * Return the Ecore Object that should be the EObject context for a diagnostic message.
	 *
	 * FIXME This is a workaround for Bug 528355
	 */
	private @NonNull EObject getEObjectContext(@NonNull Element asElement, @NonNull EObject eObject) {
		for (EObject asObject = asElement; asObject instanceof Element; asObject = asObject.eContainer()) {
			EObject esObject = ((Element)asObject).getESObject();
			if (esObject != null) {
				return esObject;
			}
		}
		return eObject;
	}

	/**
	 * Return the OCL context for the validation, caching the created value in the validation context for re-use by
	 * further validations. The cached reference is weak to ensure that the OCL context is disposed once no longer in use.
	 *
	 * @deprecated not used - use PivotDiagnostician.getOCL
	 * @since 1.3
	 */
	@Deprecated
	protected @NonNull OCLInternal getOCL(@NonNull Map<Object, Object> context) {
		return (OCLInternal)PivotDiagnostician.getOCL(context, null);
	}

	protected boolean isOCL(List<String> someDelegates) {
		for (String aDelegate : someDelegates) {
			if (OCLCommon.isDelegateURI(aDelegate)) {
				return true;
			}
		}
		return false;
	}

	private boolean isStaleStereotypeContent(EObject eObject) {
		for (; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof EPackage) {
				EObject eContainer = eObject.eContainer();
				if (eContainer instanceof EAnnotation) {
					EAnnotation eAnnotation = (EAnnotation)eContainer;
					if (DerivedConstants.UML2_UML_PACKAGE_2_0_NS_URI.equals(eAnnotation.getSource())) {
						int index = eAnnotation.getContents().indexOf(eObject);
						return index != 0;		// Anything other than the first stereotype is ignored.
					}
				}
				break;
			}
		}
		return false;
	}

	private @Nullable ExpressionInOCL parseSpecification(@NonNull EnvironmentFactoryInternalExtension environmentFactory,
			@NonNull ENamedElement eContext, @NonNull LanguageExpression asSpecification,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		ExpressionInOCL expressionInOCL = null;
		try {
			boolean isParseable = true;
			if (asSpecification instanceof ExpressionInOCL) {
				ExpressionInOCL asExpressionInOCL = (ExpressionInOCL)asSpecification;
				if ((asExpressionInOCL.getOwnedBody() == null) && (asExpressionInOCL.getBody() == null)) {
					isParseable = false;
				}
			}
			if (isParseable) {			// Avoid duplicating the MISSING_CONSTRAINTS_ANNOTATION_ENTRY
				expressionInOCL = environmentFactory.parseSpecification(asSpecification);
			}
		} catch (ParserException e) {
			if (diagnostics != null) {
				//				EObject eObjectContext = getEObjectContext(asSpecification.getOwningConstraint(), eContext);
				Object objectContext = getDetailContext(asSpecification, eContext);
				Object[] data = new Object[] { objectContext };
				String fullMessage = e.getMessage();
				String[] messages = fullMessage.split("\n");//StringUtil.bind(PARSING_ERROR_1, e, objectLabel);
				BasicDiagnostic titleDiagnostic = null;
				for (String message : messages) {
					int severity = PivotUtil.getSeverity(environmentFactory);
					if (titleDiagnostic == null) {
						// ProblemsView needs a multiline to show per-line errors
						titleDiagnostic = new BasicDiagnostic(EcoreValidator.DIAGNOSTIC_SOURCE, 0, fullMessage, data);
						diagnostics.add(titleDiagnostic);
					}
					else {
						// ValidationDialog needs nested per-line errors
						titleDiagnostic.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE, 0, message, data));
					}
				}
			}
			return null;
		}
		/*		if (expressionInOCL == null) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(eObject, context);
				String message = StringUtil.bind(PARSING_ERROR_1, null, objectLabel);
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { eObject, object }));
			}
			return null;
		} */
		return expressionInOCL;
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
		//		return true;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (isStaleStereotypeContent(eObject)) {
			return true;
		}
		assert context != null;
		boolean allOk = true;
		if (eObject instanceof EPackage) {
			EPackage ePackage = (EPackage)eObject;
			allOk = validateEPackage(ePackage, diagnostics, context);
		}
		else if (eObject instanceof EClassifier) {
			EClassifier eClassifier = (EClassifier)eObject;
			allOk = validateEClassifier(eClassifier, diagnostics, context);
		}
		else if (eObject instanceof EOperation) {
			EOperation eOperation = (EOperation)eObject;
			allOk = validateEOperation(eOperation, diagnostics, context);
		}
		else if (eObject instanceof EStructuralFeature) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature)eObject;
			allOk = validateEStructuralFeature(eStructuralFeature, diagnostics, context);
		}
		return allOk;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	protected boolean validateEClassifier(@NonNull EClassifier eClassifier, DiagnosticChain diagnostics, @NonNull Map<Object, Object> context) {
		boolean allOk = true;
		EAnnotation eAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
		if (eAnnotation != null) {
			OCL ocl = PivotDiagnostician.getOCL(context, eClassifier);
			EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension)ocl.getEnvironmentFactory();
			org.eclipse.ocl.pivot.Class asClass = getASOf(environmentFactory, org.eclipse.ocl.pivot.Class.class, eClassifier, diagnostics, context);
			if (asClass == null) {
				return false;
			}
			Type booleanType = environmentFactory.getStandardLibrary().getBooleanType();
			for (@NonNull Constraint asConstraint : PivotUtil.getOwnedInvariants(asClass)) {
				if (!(asConstraint.getESObject() instanceof EOperation)) {					// Avoid validation as both Class.owndInvariant and EOperation
					LanguageExpression asSpecification = asConstraint.getOwnedSpecification();
					if (asSpecification != null) {
						if (!validateExpressionInOCL(environmentFactory, eClassifier, asConstraint, asSpecification, booleanType, diagnostics, context)) {
							allOk = false;
						}
					}
				}
			}
			if (!validateEClassifierConstraintsAnnotation(environmentFactory, eClassifier, diagnostics, context)) {
				allOk = false;
			}
		}
		return allOk;
	}

	private boolean validateEClassifierConstraintsAnnotation(@NonNull EnvironmentFactoryInternalExtension environmentFactory,
			@NonNull EClassifier eClassifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		Object eContext = eClassifier;
		String constraintsAnnotation = null;
		EAnnotation ecoreAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (ecoreAnnotation != null) {
			eContext = ecoreAnnotation;
			EMap<String, String> details = ecoreAnnotation.getDetails();
			int index = details.indexOfKey(CONSTRAINTS_KEY);
			if (index >= 0) {
				eContext = details.get(index);
				constraintsAnnotation = details.get(CONSTRAINTS_KEY);
			}
		}
		EAnnotation pivotAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
		int severity = PivotUtil.getSeverity(environmentFactory);
		if (constraintsAnnotation == null) {
			allOk = false;
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(eClassifier, context);
				String message = StringUtil.bind(MISSING_CONSTRAINTS, EcorePackage.eNS_URI, CONSTRAINTS_KEY, objectLabel);
				diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { eClassifier }));
			}
		}
		else if (pivotAnnotation != null) {
			EMap<String, String> details = pivotAnnotation.getDetails();
			Set<String> ecoreConstraintNames = new HashSet<>(EcoreUtil.getConstraints(eClassifier));
			Set<String> oclConstraintNames = new HashSet<>(details.keySet());
			oclConstraintNames.removeAll(ecoreConstraintNames);
			ecoreConstraintNames.removeAll(details.keySet());
			for (String oclConstraintName : oclConstraintNames) {
				allOk = false;
				if (diagnostics != null) {
					String objectLabel = NameUtil.qualifiedNameFor(eClassifier);
					String message = StringUtil.bind(MISSING_CONSTRAINTS_ANNOTATION_ENTRY, PivotConstantsInternal.INVARIANT_ROLE, objectLabel, oclConstraintName);
					diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { eContext }));
				}
			}
			for (String ecoreConstraintName : ecoreConstraintNames) {
				allOk = false;
				if (diagnostics != null) {
					String objectLabel = NameUtil.qualifiedNameFor(eClassifier);
					String message = StringUtil.bind(EXTRA_CONSTRAINTS_ANNOTATION_ENTRY, PivotConstantsInternal.INVARIANT_ROLE, objectLabel, ecoreConstraintName);
					diagnostics.add(new BasicDiagnostic(Math.min(severity, Diagnostic.WARNING), EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { eContext }));
				}
			}
		}
		return allOk;
	}

	protected boolean validateEPackage(@NonNull EPackage ePackage, DiagnosticChain diagnostics, @NonNull Map<Object, Object> context) {
		boolean allOk = true;
		boolean needsInvocationDelegates = false;
		boolean needsSettingDelegates = false;
		boolean needsValidationDelegates = false;
		OCL ocl = PivotDiagnostician.getOCL(context, ePackage);
		EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension)ocl.getEnvironmentFactory();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (OCLCommon.getDelegateAnnotation(eClassifier) != null) {
				needsValidationDelegates = true;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EOperation eOperation : eClass.getEOperations()) {
					if (!EcoreUtil.isInvariant(eOperation) && (OCLCommon.getDelegateAnnotation(eOperation) != null)) {
						needsInvocationDelegates = true;
					}
				}
				for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
					if (OCLCommon.getDelegateAnnotation(eStructuralFeature) != null) {
						needsSettingDelegates = true;
					}
				}
			}
		}
		boolean hasInvocationDelegates = isOCL(EcoreUtil.getInvocationDelegates(ePackage));
		boolean hasSettingDelegates = isOCL(EcoreUtil.getSettingDelegates(ePackage));
		boolean hasValidationDelegates = isOCL(EcoreUtil.getValidationDelegates(ePackage));
		int severity = PivotUtil.getSeverity(environmentFactory);
		if (needsInvocationDelegates && !hasInvocationDelegates) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(ePackage, context);
				String message = StringUtil.bind(MISSING_DELEGATE, InvocationBehavior.NAME, objectLabel);
				diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { ePackage }));
			}
			else {
				allOk = false;
			}
		}
		if (needsSettingDelegates && !hasSettingDelegates) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(ePackage, context);
				String message = StringUtil.bind(MISSING_DELEGATE, SettingBehavior.NAME, objectLabel);
				diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { ePackage }));
			}
			else {
				allOk = false;
			}
		}
		if (needsValidationDelegates && !hasValidationDelegates) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(ePackage, context);
				String message = StringUtil.bind(MISSING_DELEGATE, ValidationBehavior.NAME, objectLabel);
				diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { ePackage }));
			}
			else {
				allOk = false;
			}
		}
		return allOk;
	}

	protected boolean validateEOperation(@NonNull EOperation eOperation, DiagnosticChain diagnostics, @NonNull Map<Object, Object> context) {
		EAnnotation eAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
		if (eAnnotation == null) {
			return true;
		}
		OCL ocl = PivotDiagnostician.getOCL(context, eOperation);		// Shares a weak referen ce that garbage collects
		EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension)ocl.getEnvironmentFactory();
		NamedElement asElement = getASOf(environmentFactory, NamedElement.class, eOperation, diagnostics, context);
		if (asElement == null) {
			return false;
		}
		Type booleanType = environmentFactory.getStandardLibrary().getBooleanType();
		boolean allOk = true;
		if (asElement instanceof Constraint) {
			Constraint asConstraint = (Constraint)asElement;
			LanguageExpression asSpecification = asConstraint.getOwnedSpecification();
			if (asSpecification != null) {
				if (!validateExpressionInOCL(environmentFactory, eOperation, asConstraint, asSpecification, booleanType, diagnostics, context)) {
					allOk = false;
				}
			}
		}
		else if (asElement instanceof Operation) {
			Operation asOperation = (Operation)asElement;
			LanguageExpression bodyExpression = asOperation.getBodyExpression();
			if (bodyExpression != null) {
				if (!validateExpressionInOCL(environmentFactory, eOperation, asOperation, bodyExpression, asOperation.getType(), diagnostics, context)) {
					allOk = false;
				}
			}
			for (@NonNull Constraint asConstraint : PivotUtil.getOwnedPreconditions(asOperation)) {
				LanguageExpression asSpecification = asConstraint.getOwnedSpecification();
				if (asSpecification != null) {
					if (!validateExpressionInOCL(environmentFactory, eOperation, asConstraint, asSpecification, booleanType, diagnostics, context)) {
						allOk = false;
					}
				}
			}
			for (@NonNull Constraint asConstraint : PivotUtil.getOwnedPostconditions(asOperation)) {
				LanguageExpression asSpecification = asConstraint.getOwnedSpecification();
				if (asSpecification != null) {
					if (!validateExpressionInOCL(environmentFactory, eOperation, asConstraint, asSpecification, booleanType, diagnostics, context)) {
						allOk = false;
					}
				}
			}
		}
		return allOk;
	}

	protected boolean validateEStructuralFeature(@NonNull EStructuralFeature eStructuralFeature, DiagnosticChain diagnostics, @NonNull Map<Object, Object> context) {
		boolean allOk = true;
		EAnnotation eAnnotation = OCLCommon.getDelegateAnnotation(eStructuralFeature);
		if (eAnnotation != null) {
			OCL ocl = PivotDiagnostician.getOCL(context, eStructuralFeature);
			EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension)ocl.getEnvironmentFactory();
			EMap<String, String> details = eAnnotation.getDetails();
			int entries = 0;
			String value = null;
			if (details.containsKey(SettingBehavior.DERIVATION_CONSTRAINT_KEY)) {
				entries++;
				value = details.get(SettingBehavior.DERIVATION_CONSTRAINT_KEY);
			}
			if (details.containsKey(SettingBehavior.INITIAL_CONSTRAINT_KEY)) {
				entries++;
				value = details.get(SettingBehavior.INITIAL_CONSTRAINT_KEY);
			}
			int severity = PivotUtil.getSeverity(environmentFactory);
			if (entries == 0) {
				if (diagnostics != null) {
					String objectLabel = EObjectValidator.getObjectLabel(eStructuralFeature, context);
					String message = StringUtil.bind(MISSING_PROPERTY_KEY, objectLabel);
					diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { eStructuralFeature }));
				}
				else {
					allOk = false;
				}
			}
			else if (entries == 2) {
				if (diagnostics != null) {
					String objectLabel = EObjectValidator.getObjectLabel(eStructuralFeature, context);
					String message = StringUtil.bind(DOUBLE_PROPERTY_KEY, objectLabel);
					diagnostics.add(new BasicDiagnostic(severity, EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { eStructuralFeature }));
				}
				else {
					allOk = false;
				}
			}
			else if (details.size() != 1) {
				if (diagnostics != null) {
					String objectLabel = EObjectValidator.getObjectLabel(eStructuralFeature, context);
					String message = StringUtil.bind(EXTRA_PROPERTY_KEY, objectLabel);
					diagnostics.add(new BasicDiagnostic(Math.min(severity, Diagnostic.WARNING), EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { eStructuralFeature }));
				}
				else {
					allOk = false;
				}
			}
			else if (value == null) {
				if (diagnostics != null) {
					String objectLabel = EObjectValidator.getObjectLabel(eStructuralFeature, context);
					String message = StringUtil.bind(NULL_PROPERTY_KEY, objectLabel);
					diagnostics.add(new BasicDiagnostic(Math.min(severity, Diagnostic.WARNING), EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { eStructuralFeature }));
				}
				else {
					allOk = false;
				}
			}
			else {
				Property asProperty = getASOf(environmentFactory, Property.class, eStructuralFeature, diagnostics, context);
				if (asProperty == null) {
					return false;
				}
				LanguageExpression bodyExpression = asProperty.getOwnedExpression();
				if (bodyExpression != null) {
					if (!validateExpressionInOCL(environmentFactory, eStructuralFeature, asProperty, bodyExpression, asProperty.getType(), diagnostics, context)) {
						allOk = false;
					}
				}
			}
		}
		return allOk;
	}

	@Deprecated /* @deprecated not-used - use EnvironmentFactory argument */
	protected boolean validateExpression(@NonNull MetamodelManagerInternal metamodelManager, @NonNull ENamedElement eNamedElement, @Nullable String expression, @Nullable Type unusedRequiredType, @Nullable String role, DiagnosticChain diagnostics, @NonNull Map<Object, Object> context) {
		EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension)metamodelManager.getEnvironmentFactory();
		Element asElement = getASOf(environmentFactory, Element.class, eNamedElement, diagnostics, context);
		if (asElement == null) {
			return  false;
		}
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		org.eclipse.ocl.pivot.Class booleanType = standardLibrary.getBooleanType();
		Type requiredType = null;
		Constraint asConstraint = null;
		if (asElement instanceof Constraint) {
			asConstraint = (Constraint) asElement;
			asElement = (Element) asElement.eContainer();
		}
		LanguageExpression asSpecification = null;
		if ((asElement instanceof Operation) && (role != null)) {
			Operation asOperation = (Operation)asElement;	// FIXME workaround Bug 528355 that inhibits use of the detail entry
			if (role.equals("body")) {
				asSpecification = asOperation.getBodyExpression();
			}
			else if (role.equals("pre")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPreconditions(), "");
				if (asConstraint == null) {
					asConstraint = NameUtil.getNameable(asOperation.getOwnedPreconditions(), null);
				}
				requiredType = booleanType;
			}
			else if (role.startsWith("pre_")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPreconditions(), role.substring(4));
				requiredType = booleanType;
			}
			else if (role.equals("post")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPostconditions(), "");
				if (asConstraint == null) {
					asConstraint = NameUtil.getNameable(asOperation.getOwnedPostconditions(), null);
				}
				requiredType = booleanType;
			}
			else if (role.startsWith("post_")) {
				asConstraint = NameUtil.getNameable(asOperation.getOwnedPostconditions(), role.substring(5));
				requiredType = booleanType;
			}
		}
		else if (asElement instanceof Property) {
			Property asProperty = (Property)asElement;
			asSpecification = asProperty.getOwnedExpression();
		}
		else if ((asElement instanceof org.eclipse.ocl.pivot.Class) && (role != null) && (asConstraint == null)) {
			org.eclipse.ocl.pivot.Class asClass = (org.eclipse.ocl.pivot.Class)asElement;
			asConstraint = NameUtil.getNameable(asClass.getOwnedInvariants(), role);
			requiredType = booleanType;
		}
		else if ((asElement instanceof Namespace) && (role != null) && (asConstraint == null)) {
			Namespace asNamespace = (Namespace)asElement;
			asConstraint = NameUtil.getNameable(asNamespace.getOwnedConstraints(), role);
			requiredType = booleanType;
		}
		if ((asSpecification == null) && (asConstraint != null)) {
			asSpecification = asConstraint.getOwnedSpecification();
			requiredType = booleanType;
		}
		assert asSpecification != null;
		//			ExpressionInOCL expressionInOCL = environmentFactory.parseSpecification(asSpecification);
		ExpressionInOCL expressionInOCL = (ExpressionInOCL)asSpecification;
		assert expressionInOCL.getOwnedBody() != null;
		Type asExpressionType = expressionInOCL.getType();
		Type asType;
		if (requiredType != null) {
			asType = requiredType;
		}
		else if (asElement instanceof TypedElement) {
			asType = ((TypedElement)asElement).getType();
		}
		else {
			asType = null;
		}
		assert asType != null;
		assert asExpressionType != null;
		if (!environmentFactory.getMetamodelManager().conformsTo(asExpressionType, TemplateParameterSubstitutions.EMPTY, asType, TemplateParameterSubstitutions.EMPTY)) {
			if (diagnostics != null) {
				String objectLabel = EObjectValidator.getObjectLabel(eNamedElement, context);
				String message = StringUtil.bind(INCOMPATIBLE_TYPE_2, asExpressionType, role != null ? role : PivotConstantsInternal.UNKNOWN_ROLE, objectLabel);
				diagnostics.add(new BasicDiagnostic(PivotUtil.getSeverity(environmentFactory), EcoreValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { eNamedElement }));
			}
			else {
				return false;
			}
		}
		Diagnostician nestedDiagnostician = Diagnostician.INSTANCE;
		BasicDiagnostic nestedDiagnostic = nestedDiagnostician.createDefaultDiagnostic(eNamedElement);
		Map<Object,Object> nestedContext = new HashMap<>(context);
		nestedContext.remove(EObjectValidator.ROOT_OBJECT);
		if (!nestedDiagnostician.validate(expressionInOCL, nestedDiagnostic, nestedContext)) {
			if (diagnostics != null) {
				StringBuilder s = new StringBuilder();
				s.append("OCL Validation error for \"" + expressionInOCL.getBody() + "\"");
				for (Diagnostic childDiagnostic : nestedDiagnostic.getChildren()) {
					if (childDiagnostic != null) {
						s.append("\n\t");
						s.append(childDiagnostic.getMessage());
					}
				}
				diagnostics.add(new BasicDiagnostic(PivotUtil.getSeverity(environmentFactory), EcoreValidator.DIAGNOSTIC_SOURCE,
					0, s.toString(), new Object[] { eNamedElement }));
			}
			return false;
		}
		return true;
	}

	private boolean validateExpressionInOCL(@NonNull EnvironmentFactoryInternalExtension environmentFactory,
			@NonNull ENamedElement eNamedElement, @NonNull NamedElement asContext, @NonNull LanguageExpression asSpecification, @Nullable Type requiredType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		ExpressionInOCL expressionInOCL = parseSpecification(environmentFactory, eNamedElement, asSpecification, diagnostics, context);
		if ((expressionInOCL == null) || (expressionInOCL.getOwnedBody() == null)) {
			return true;
		}
		boolean allOk = true;
		if (requiredType != null) {
			Type asExpressionType = expressionInOCL.getType();
			assert asExpressionType != null;
			if (!environmentFactory.getMetamodelManager().conformsTo(asExpressionType, TemplateParameterSubstitutions.EMPTY, requiredType, TemplateParameterSubstitutions.EMPTY)) {
				allOk = false;
				if (diagnostics != null) {
					String role = PivotUtilInternal.getSpecificationRole(asSpecification);
					String message = StringUtil.bind(INCOMPATIBLE_TYPE_2, asExpressionType, role, NameUtil.qualifiedNameFor(eNamedElement));
					diagnostics.add(new BasicDiagnostic(PivotUtil.getSeverity(environmentFactory), EcoreValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { getDetailContext(asSpecification, eNamedElement) }));
				}
				else {
					return false;
				}
			}
		}
		Diagnostician nestedDiagnostician = PivotDiagnostician.INSTANCE;
		BasicDiagnostic nestedDiagnostic = nestedDiagnostician.createDefaultDiagnostic(getEObjectContext(asSpecification, eNamedElement));
		Map<Object,Object> nestedContext = new HashMap<>(context);
		nestedContext.remove(EObjectValidator.ROOT_OBJECT);
		if (!nestedDiagnostician.validate(expressionInOCL, nestedDiagnostic, nestedContext)) {
			allOk = false;
			if (diagnostics != null) {
				String role = PivotUtilInternal.getSpecificationRole(asSpecification);
				String contextName = NameUtil.qualifiedNameFor(eNamedElement);
				StringBuilder s = new StringBuilder();
				String body = expressionInOCL.getBody();
				String trimmedBody = body.replace("\\w*", " ").trim();
				s.append("\"" + StringUtil.convertToOCLString(trimmedBody) + "\"");
				for (Diagnostic childDiagnostic : nestedDiagnostic.getChildren()) {
					if (childDiagnostic != null) {
						// Problems View needs a multiline to show per-line errors
						s.append("\n\t");
						s.append(childDiagnostic.getMessage());
					}
				}
				String invalidMessage = StringUtil.bind(PivotMessagesInternal.ValidationConstraintIsInvalid_ERROR_, role, contextName, s.toString());
				BasicDiagnostic titleDiagnostic = new BasicDiagnostic(EcoreValidator.DIAGNOSTIC_SOURCE,
					0, invalidMessage, new Object[] { getDetailContext(asSpecification, eNamedElement) });
				// ValidationDialog needs nested per-line errors
				titleDiagnostic.addAll(nestedDiagnostic);
				diagnostics.add(titleDiagnostic);
			}
		}
		return allOk;
	}
}
