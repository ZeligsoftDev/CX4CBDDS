/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.options.OCLinEcoreOptions;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.UniqueList;

public class DelegateInstaller
{
	/**
	 * True to apply result = () wrapper to invariant body.
	 */
	public static final @NonNull String OPTION_BOOLEAN_INVARIANTS = "booleanInvariants";

	/**
	 * True to omit the setting delegates declaration. Useful for matching UML2Ecore behaviour.
	 */
	public static final @NonNull String OPTION_OMIT_SETTING_DELEGATES = "omitSettingDelegates";

	public static @NonNull String getAnnotationKey(@NonNull Constraint pivotConstraint) {
		String name = pivotConstraint.getName();
		EStructuralFeature eContainingFeature = pivotConstraint.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.CLASS__OWNED_INVARIANTS) {
			if (pivotConstraint.isIsCallable()) {
				return "body";
			}
			else {
				return name != null ? name : "null";
			}
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
			return name != null ? "pre_" + name : "pre";
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
			return name != null ? "post_" + name : "post";
		}
		else {
			//			error("Unsupported " + pivotConstraint);
		}
		return "null";
	}

	public static @Nullable String getDelegateURI(@NonNull List<EObject> contents) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				String exportURI = getDelegateURI((EPackage)eObject);
				if (exportURI != null) {
					return exportURI;
				}
			}
		}
		return null;
	}

	public static @Nullable String getDelegateURI(@NonNull EPackage ePackage) {
		Set<String> allURIs = new HashSet<String>();
		//		allURIs.addAll(EcoreUtil.getConversionDelegates(ePackage));
		allURIs.addAll(ClassUtil.nonNull(EcoreUtil.getInvocationDelegates(ePackage)));
		//		allURIs.addAll(EcoreUtil.getQueryDelegates(ePackage));
		allURIs.addAll(ClassUtil.nonNull(EcoreUtil.getSettingDelegates(ePackage)));
		allURIs.addAll(ClassUtil.nonNull(EcoreUtil.getValidationDelegates(ePackage)));
		String theURI = null;
		for (String uri : allURIs) {
			if (uri.startsWith(OCLConstants.OCL_DELEGATE_URI)) {
				if (theURI != null) {
					return OCLConstants.OCL_DELEGATE_URI;
				}
				theURI = uri;
			}
		}
		if (theURI != null) {
			return theURI;
		}
		for (@SuppressWarnings("null")@NonNull EPackage eSubpackage : ePackage.getESubpackages()) {
			String exportURI = getDelegateURI(eSubpackage);
			if (exportURI != null) {
				return exportURI;
			}
		}
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				return classifierAnnotation.getSource();
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = OCLCommon.getDelegateAnnotation(eFeature);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						return featureAnnotation.getSource();
					}
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						return operationAnnotation.getSource();
					}
				}
			}
		}
		return null;
	}

	public static @Nullable String getExportDelegateURI(@NonNull Map<String, Object> options) {
		String exportDelegateURI = (String)options.get(OCLConstants.OCL_DELEGATE_URI);
		return exportDelegateURI != null ? exportDelegateURI : OCLinEcoreOptions.EXPORT_DELEGATION_URI.getPreferredValue();
	}

	public static boolean isBooleanInvariants(@NonNull Map<String,Object> options) {
		return Boolean.valueOf(String.valueOf(options.get(OPTION_BOOLEAN_INVARIANTS)));
	}

	public static boolean needsDelegates(@NonNull EPackage ePackage) {
		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = OCLCommon.getDelegateAnnotation(eFeature);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		return needsDelegates;
	}

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull Map<String, Object> options;
	protected final @Nullable String exportDelegateURI;

	public DelegateInstaller(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Map<String, Object> options) {
		this.environmentFactory = environmentFactory;
		//		this.metamodelManager = metamodelManager;
		this.options = options != null ? options : new HashMap<String,Object>();
		this.exportDelegateURI = getExportDelegateURI(this.options);
	}

	protected @NonNull EAnnotation createAnnotation(@NonNull EModelElement eModelElement) {
		EAnnotation oclAnnotation = removeDelegateAnnotations(eModelElement, exportDelegateURI);
		if (oclAnnotation == null) {
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(exportDelegateURI);
			eModelElement.getEAnnotations().add(oclAnnotation);
		}
		return oclAnnotation;
	}

	public @Nullable EAnnotation createConstraintDelegate(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint, @Nullable URI ecoreURI) {
		LanguageExpression specification = pivotConstraint.getOwnedSpecification();
		if (specification == null) {
			return null;
		}
		String exprString = createExpression(specification, ecoreURI);
		if (exprString == null) {
			return null;
		}
		EAnnotation oclAnnotation = createAnnotation(eModelElement);
		String key = getAnnotationKey(pivotConstraint);
		oclAnnotation.getDetails().put(key, exprString);
		return oclAnnotation;
	}

	protected @Nullable String createExpression(@NonNull LanguageExpression specification, @Nullable URI ecoreURI) {
		String exprString = specification.getBody();
		if ((exprString == null) && (specification instanceof ExpressionInOCL)) {
			OCLExpression bodyExpression2 = ((ExpressionInOCL)specification).getOwnedBody();
			if (bodyExpression2 != null) {
				exprString = createExpression(bodyExpression2, ecoreURI);
			}
		}
		return exprString;
	}

	protected @Nullable String createExpression(@NonNull OCLExpression bodyExpression, @Nullable URI ecoreURI) {
		Namespace namespace = PivotUtil.getNamespace(bodyExpression);
		PrettyPrintOptions.Global options = PrettyPrinter.createOptions(namespace);
		options.setBaseURI(ecoreURI);
		return PrettyPrinter.print(bodyExpression, options);
	}

	public @Nullable EAnnotation createOperationDelegate(@NonNull EOperation eOperation, @NonNull LanguageExpression bodyExpression, @Nullable URI ecoreURI) {
		String exprString = createExpression(bodyExpression, ecoreURI);
		if (exprString == null) {
			return null;
		}
		if (isBooleanInvariants(options)) {
			exprString = "result = (" + exprString + ")";
		}
		EAnnotation oclAnnotation = createAnnotation(eOperation);
		oclAnnotation.getDetails().put(InvocationBehavior.BODY_CONSTRAINT_KEY, exprString);
		return oclAnnotation;
	}

	public @Nullable EAnnotation createPropertyDelegate(@NonNull EStructuralFeature eStructuralFeature, @NonNull LanguageExpression defaultExpression, @Nullable URI ecoreURI) {
		String exprString = createExpression(defaultExpression, ecoreURI);
		if (exprString == null) {
			return null;
		}
		EAnnotation oclAnnotation = createAnnotation(eStructuralFeature);
		oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		return oclAnnotation;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public @Nullable String getExportDelegateURI() {
		return exportDelegateURI;
	}

	//	public @NonNull MetamodelManager getMetamodelManager() {
	//		return metamodelManager;
	//	}

	/**
	 * Install all Constraints from pivotPackage and its nestedPackages as OCL Delegates.
	 */
	public void installDelegates(@NonNull CompletePackage completePackage) {
		boolean hasDelegates = false;
		//		for (Type aType : metamodelManager.getLocalClasses(pivotPackage)) {
		for (CompleteClass completeClass : completePackage.getOwnedCompleteClasses()) {
			if (installDelegates(completeClass.getPrimaryClass())) {
				hasDelegates = true;
			}
		}
		//		PackageServer packageServer = metamodelManager.getPackageServer(pivotPackage);
		EPackage ePackage = completePackage.getEPackage();
		if ((ePackage != null) && hasDelegates) {
			installDelegates(ePackage);
		}
		for (CompletePackage nestedPackage : completePackage.getOwnedCompletePackages()) {
			if (nestedPackage != null) {
				installDelegates(nestedPackage);
			}
		}
	}

	/**
	 * Install all Constraints from pivotType and its operations as OCL Delegates. Returning true if any OCL Delegate installed.
	 *
	 * @param metamodelManager
	 * @param pivotPackage
	 */
	private boolean installDelegates(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		boolean hasDelegates = false;
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		Type primaryType = metamodelManager.getPrimaryType(pivotType);
		EObject eTarget = primaryType.getESObject();
		if (eTarget instanceof EClassifier) {
			@NonNull EClassifier eClassifier = (EClassifier)eTarget;
			removeDelegateAnnotations(eClassifier, null);
			for (Constraint constraint : metamodelManager.getLocalInvariants(pivotType)) {
				if (constraint.isIsCallable()) {
					EOperation eContext = null;
					@NonNull String name = PivotUtil.getName(constraint);
					for (EOperation candidate : ((EClass) eClassifier).getEOperations()) {
						if (name.equals(candidate.getName()) && EcoreUtil.isInvariant(candidate)) {
							eContext = candidate;
							break;
						}
					}
					if (eContext == null) {
						@NonNull EOperation eOperation = AS2Ecore.createConstraintEOperation(constraint, name, null);
						((EClass) eClassifier).getEOperations().add(eOperation);
						eContext = eOperation;
					}
					EAnnotation oclAnnotation = createConstraintDelegate(eContext, constraint, null);
					if (oclAnnotation == null) {
						return false;
					}
					eContext.getEAnnotations().add(oclAnnotation);
					hasDelegates = true;
				}
				else {
					EAnnotation oclAnnotation = createConstraintDelegate(eClassifier, constraint, null);
					if (oclAnnotation == null) {
						return false;
					}
					eClassifier.getEAnnotations().add(oclAnnotation);
					hasDelegates = true;
				}
			}
			for (Operation anOperation : metamodelManager.getMemberOperations(pivotType, false)) {
				EOperation eOperation = (EOperation)anOperation.getESObject();
				if (eOperation != null) {
					installDelegate(eOperation);
				}
			}
			for (Operation anOperation : metamodelManager.getMemberOperations(pivotType, true)) {
				EOperation eOperation = (EOperation)anOperation.getESObject();
				if (eOperation != null) {
					installDelegate(eOperation);
				}
			}
			for (Property aProperty : metamodelManager.getMemberProperties(pivotType, false)) {
				EStructuralFeature eFeature = (EStructuralFeature)aProperty.getESObject();
				if (eFeature != null) {
					installDelegate(eFeature);
				}
			}
			for (Property aProperty : metamodelManager.getMemberProperties(pivotType, true)) {
				EStructuralFeature eFeature = (EStructuralFeature)aProperty.getESObject();
				if (eFeature != null) {
					installDelegate(eFeature);
				}
			}
			for (EAnnotation eAnnotation : eClassifier.getEAnnotations()) {		// Fix redefines/duplicates
				for (TreeIterator<EObject> tit = eAnnotation.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					if (eObject instanceof EAnnotation) {
						EAnnotation nestedAnnotation = (EAnnotation) eObject;
						if (DerivedConstants.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI.equals(nestedAnnotation.getSource())) {
							nestedAnnotation.setSource(PivotConstants.OCL_DELEGATE_URI_PIVOT);
						}
					}
				}
			}
			if (hasDelegates) {
				installDelegates(eClassifier, pivotType);
			}
		}
		return hasDelegates;
	}

	public void installDelegate(@NonNull EOperation eOperation) {
		List<EAnnotation> eAnnotations = eOperation.getEAnnotations();
		EAnnotation oclAnnotation = eOperation.getEAnnotation(DerivedConstants.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
			oclAnnotation.setSource(exportDelegateURI);
			eAnnotations.add(oclAnnotation);
		}
	}

	public void installDelegate(@NonNull EStructuralFeature eFeature) {
		List<EAnnotation> eAnnotations = eFeature.getEAnnotations();
		EAnnotation oclAnnotation = eFeature.getEAnnotation(DerivedConstants.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
			oclAnnotation.setSource(exportDelegateURI);
			eAnnotations.add(oclAnnotation);
		}
	}

	public void installDelegates(@NonNull EClassifier eClassifier, org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		Set<@NonNull String> constraintNameSet = null;
		StringBuilder s = null;
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		for (Constraint pivotConstraint : metamodelManager.getLocalInvariants(pivotType)) {
			assert pivotConstraint != null;
			String constraintName = getAnnotationKey(pivotConstraint);
			if (!pivotConstraint.isIsCallable()) {
				if (constraintNameSet == null) {
					constraintNameSet = new UniqueList<>();
				}
				if (constraintNameSet.add(constraintName)) {	// Avoid duplicates that Bug 571760 fix facilitates
					if (s == null) {
						s = new StringBuilder();
					}
					else {
						s.append(" ");
					}
					s.append(constraintName);					// Preserve order for RoundTripTests
				}
			}
		}
		EAnnotation eAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(EcorePackage.eNS_URI);
				eClassifier.getEAnnotations().add(/*0,*/ eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			eClassifier.getEAnnotations().remove(eAnnotation);
		}
	}

	public void installDelegates(@NonNull EPackage ePackage) {
		EAnnotation packageAnnotation = ClassUtil.getEAnnotation(ePackage, EcorePackage.eNS_URI);
		EMap<String, String> details = packageAnnotation.getDetails();
		details.put(InvocationBehavior.NAME, exportDelegateURI);
		if (!Boolean.valueOf(String.valueOf(options.get(OPTION_OMIT_SETTING_DELEGATES)))) {
			details.put(SettingBehavior.NAME, exportDelegateURI);
		}
		details.put(ValidationBehavior.NAME, exportDelegateURI);
	}

	/**
	 * Remove all OCL Delegate annotations except that corresponding to exportDelegateURI which is returned.
	 */
	protected @Nullable EAnnotation removeDelegateAnnotations(@NonNull EModelElement eModelElement, @Nullable String exportDelegateURI) {
		List<EAnnotation> eAnnotations = eModelElement.getEAnnotations();
		EAnnotation oclAnnotation = null;
		EAnnotation annotation1 = eModelElement.getEAnnotation(OCLConstants.OCL_DELEGATE_URI);
		if (annotation1 != null) {
			if (OCLConstants.OCL_DELEGATE_URI.equals(exportDelegateURI)) {
				oclAnnotation = annotation1;
			}
			else {
				eAnnotations.remove(annotation1);
			}
		}
		EAnnotation annotation2 = eModelElement.getEAnnotation(OCLConstants.OCL_DELEGATE_URI_LPG);
		if (annotation2 != null) {
			if (OCLConstants.OCL_DELEGATE_URI_LPG.equals(exportDelegateURI)) {
				oclAnnotation = annotation2;
			}
			else {
				eAnnotations.remove(annotation2);
			}
		}
		EAnnotation annotation3 = eModelElement.getEAnnotation(PivotConstants.OCL_DELEGATE_URI_PIVOT);
		if (annotation3 != null) {
			if (PivotConstants.OCL_DELEGATE_URI_PIVOT.equals(exportDelegateURI)) {
				oclAnnotation = annotation3;
			}
			else {
				eAnnotations.remove(annotation3);
			}
		}
		EAnnotation annotation4 = eModelElement.getEAnnotation(DerivedConstants.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (annotation4 != null) {
			eAnnotations.remove(annotation4);
		}
		return oclAnnotation;
	}
}
