/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 399252
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.PackageImpl;
import org.eclipse.ocl.pivot.internal.compatibility.EMF_2_9;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.library.ConstrainedOperation;
import org.eclipse.ocl.pivot.internal.library.EInvokeOperation;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.CompleteElementIterable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.internal.utilities.OppositePropertyDetails;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.library.UnsupportedOperation;
import org.eclipse.ocl.pivot.model.OCLmetamodel;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

import com.google.common.collect.Iterables;

public class PivotMetamodelManager implements MetamodelManagerInternal.MetamodelManagerInternalExtension2, Adapter.Internal
{
	public class CompleteTypeOperationsIterable extends CompleteElementIterable<org.eclipse.ocl.pivot.Class, @NonNull Operation>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static

		public CompleteTypeOperationsIterable(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> types, boolean selectStatic) {
			super(types);
			this.selectStatic = selectStatic;
		}

		@Override
		protected @NonNull Iterable<@NonNull Operation> getInnerIterable(org.eclipse.ocl.pivot.@NonNull Class model) {
			return ClassUtil.nullFree(ClassUtil.nonNullEMF(model.getOwnedOperations()));
		}

		@Override
		protected @Nullable Operation getInnerValue(@NonNull Operation element) {
			if (selectStatic != null) {
				if (element.isIsStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}

	public class CompleteClassPropertiesIterable extends CompleteElementIterable<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Property>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static

		public CompleteClassPropertiesIterable(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> types, boolean selectStatic) {
			super(types);
			this.selectStatic = selectStatic;
		}

		@Override
		protected @NonNull Iterable<@NonNull Property> getInnerIterable(org.eclipse.ocl.pivot.@NonNull Class model) {
			return ClassUtil.nullFree(model.getOwnedProperties());
		}

		@Override
		protected @Nullable Property getInnerValue(@NonNull Property element) {
			if (selectStatic != null) {
				if (element.isIsStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}

	public class CompleteElementInvariantsIterable
	extends CompleteElementIterable<org.eclipse.ocl.pivot.Class, Constraint> {

		public CompleteElementInvariantsIterable(@NonNull Iterable<? extends org.eclipse.ocl.pivot.Class> models) {
			super(models);
		}

		@Override
		protected @NonNull Iterable<Constraint> getInnerIterable(org.eclipse.ocl.pivot.@NonNull Class model) {
			return ClassUtil.nonNullEMF(model.getOwnedInvariants());
		}
	}

	private static final Logger logger = LogManager.getLogger(PivotMetamodelManager.class);

	/**
	 * @since 1.3
	 */
	public static final @NonNull TracingOption INSTALL_MODEL = new TracingOption(PivotPlugin.PLUGIN_ID, "install/model");

	//	public static final @NonNull TracingOption CREATE_MUTABLE_CLONE = new TracingOption(PivotPlugin.PLUGIN_ID, "mm/createMutableClone");

	public static final @NonNull List<@NonNull Constraint> EMPTY_CONSTRAINT_LIST = Collections.<@NonNull Constraint>emptyList();
	public static final @NonNull List<@NonNull Element> EMPTY_ELEMENT_LIST = Collections.<@NonNull Element>emptyList();
	public static final @NonNull List<@NonNull Operation> EMPTY_OPERATION_LIST = Collections.<@NonNull Operation>emptyList();
	public static final @NonNull List<@NonNull Property> EMPTY_PROPERTY_LIST = Collections.<@NonNull Property>emptyList();
	public static final @NonNull List<@NonNull State> EMPTY_STATE_LIST = Collections.<@NonNull State>emptyList();
	public static final @NonNull List<@NonNull TemplateParameter> EMPTY_TEMPLATE_PARAMETER_LIST = Collections.emptyList();
	private static final @NonNull List<TemplateParameter> EMPTY_TEMPLATE_PARAMETER_LIST2 = Collections.emptyList();
	public static final @NonNull List<@NonNull Type> EMPTY_TYPE_LIST = Collections.<@NonNull Type>emptyList();

	/**
	 * Leak debugging aid. Set non-null to diagnose MetamodelManager construction and finalization.
	 */
	public static WeakHashMap<@NonNull PivotMetamodelManager, @Nullable Object> liveMetamodelManagers = null;

	/**
	 * Return the non-null MetamodelManager for which resourceSet is an AS ResourceSet, or null if not an AS ResourceSet.
	 */
	public static @Nullable PivotMetamodelManager findAdapter(@NonNull ResourceSet asResourceSet) {
		@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = asResourceSet.eAdapters();
		return ClassUtil.getAdapter(PivotMetamodelManager.class, eAdapters);
	}

	/**
	 * Return the non-null MetamodelManager for the asResourceSet.
	 */
	public static @NonNull PivotMetamodelManager getAdapter(@NonNull ResourceSet asResourceSet) {
		@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = asResourceSet.eAdapters();
		PivotMetamodelManager adapter = ClassUtil.getAdapter(PivotMetamodelManager.class, eAdapters);
		return ClassUtil.nonNullState(adapter);
	}

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	private final @NonNull StandardLibraryInternal standardLibrary;
	private final @NonNull CompleteEnvironmentInternal completeEnvironment;

	/**
	 * The known packages.
	 */
	private final @NonNull CompleteModelInternal completeModel;

	/**
	 * The known precedences.
	 */
	private PrecedenceManager precedenceManager = null;			// Lazily created

	/**
	 * The known implementation load capabilities.
	 */
	private ImplementationManager implementationManager = null;			// Lazily created

	protected org.eclipse.ocl.pivot.Package asMetamodel = null;

	private boolean libraryLoadInProgress = false;

	protected final @NonNull ResourceSet asResourceSet;

	/**
	 * All Library packages imported into the current type managed domain.
	 */
	protected final @NonNull List<@NonNull Library> asLibraries = new ArrayList<>();

	/**
	 * The resource of the Standard Library defined by loadDefaultLibrary. If the URI corresponds to a
	 * registered library, the registered library is loaded, else the first library in asLibraries with a matching
	 * URI is installed. Once asLibraryResource is determined all types libraries in asLibraries and all future
	 * asLibraries are automatically merged into the Standard Library.
	 */
	protected @Nullable Resource asLibraryResource = null;

	private final @NonNull Map<String, Namespace> globalNamespaces = new HashMap<>();
	private final @NonNull Set<Type> globalTypes = new HashSet<>();

	/**
	 * Map of URI to external resource converter.
	 */
	private final @NonNull Map<URI, External2AS> external2asMap = new HashMap<>();

	/**
	 * Elements protected from garbage collection
	 */
	private @Nullable EAnnotation lockingAnnotation = null;

	private boolean autoLoadASmetamodel = true;

	private @Nullable Map<String, GenPackage> genPackageMap = null;

	/**
	 * Lazily computed, eagerly invalidated analysis of final classes and operations.
	 */
	private @Nullable FinalAnalysis finalAnalysis = null;

	/**
	 * Lazily computed, eagerly invalidated static analysis of the control flow within invariants and bodies.
	 */
	private @Nullable Map<@NonNull OCLExpression, @NonNull FlowAnalysis> oclExpression2flowAnalysis = null;

	private @Nullable Map<Resource,External2AS> es2ases = null;

	/**
	 * Construct a MetamodelManager that will use environmentFactory to create its artefacts
	 * such as an asResourceSet to contain pivot copies of meta-models.
	 */
	public PivotMetamodelManager(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ResourceSet asResourceSet) {
		this.environmentFactory = environmentFactory;
		this.asResourceSet = asResourceSet;
		List<Adapter> asResourceSetAdapters = asResourceSet.eAdapters();
		assert !asResourceSetAdapters.contains(this);
		asResourceSetAdapters.add(this);
		assert asResourceSetAdapters.contains(environmentFactory.getProjectManager());
		completeEnvironment = environmentFactory.getCompleteEnvironment();
		standardLibrary = environmentFactory.getStandardLibrary();
		completeModel = environmentFactory.getCompleteModel();
		//		System.out.println("ctor " + this);
		//		initializePivotResourceSet(asResourceSet);
		if (liveMetamodelManagers != null) {
			liveMetamodelManagers.put(this, null);
			PivotUtilInternal.debugPrintln("Create " + NameUtil.debugSimpleName(this)
			+ " " + NameUtil.debugSimpleName(asResourceSet));
		}
	}

	@Override
	public void addClassLoader(@NonNull ClassLoader classLoader) {
		ImplementationManager implementationManager = getImplementationManager();
		implementationManager.addClassLoader(classLoader);
	}

	@Override
	public void addExternal2AS(@NonNull External2AS es2as) {
		Map<Resource, External2AS> es2ases2 = es2ases;
		if (es2ases2 == null){
			es2ases = es2ases2 = new HashMap<>();
		}
		Resource resource = es2as.getResource();
		URI uri = es2as.getURI();
		External2AS oldES2AS = es2ases2.put(resource, es2as);
		assert oldES2AS == null;
		oldES2AS = external2asMap.put(uri, es2as);
		//		assert (oldES2AS == null) || (es2as instanceof AS2Ecore.InverseConversion); -- FIXME DelegatesTests thrashes this in the global EnvironmentFactory
	}

	@Override
	public void addGenModel(@NonNull GenModel genModel) {
		for (@SuppressWarnings("null")@NonNull GenPackage genPackage : genModel.getAllGenUsedAndStaticGenPackagesWithClassifiers()) {
			addGenPackage(genPackage);
		}
	}

	public void addGenPackage(@NonNull GenPackage genPackage) {
		Map<String, GenPackage> genPackageMap2 = genPackageMap;
		if (genPackageMap2 == null) {
			genPackageMap = genPackageMap2 = new HashMap<>();
		}
		genPackageMap2.put(genPackage.getNSURI(), genPackage);
	}

	@Override
	public @Nullable Namespace addGlobalNamespace(@NonNull String name, @NonNull Namespace namespace) {
		return globalNamespaces.put(name, namespace);
	}

	public boolean addGlobalTypes(@NonNull Collection<Type> types) {
		return globalTypes.addAll(types);
	}

	@Override
	public void addLockedElement(@NonNull Object lockedElement) {
		if (lockedElement instanceof EObject) {
			EAnnotation lockingAnnotation2 = lockingAnnotation;
			if (lockingAnnotation2 == null) {
				lockingAnnotation = lockingAnnotation2 = EcoreFactory.eINSTANCE.createEAnnotation();
			}
			List<EObject> lockingReferences = lockingAnnotation2.getReferences();
			if (!lockingReferences.contains(lockedElement)) {
				lockingReferences.add((EObject) lockedElement);
			}
		}
	}

	/**
	 * Assign xmi:id values to referenceable elements in the libraries.
	 */
	@Deprecated /* @deprecated only used when AS2XMIID generates legacy Model.xmiidVersion 0 xmiids */
	public void assignLibraryIds(org.eclipse.ocl.pivot.internal.utilities.@NonNull AS2XMIid as2xmIid, @Nullable Map<@NonNull String, @Nullable Object> options) {
		for (@NonNull Library asLibrary : asLibraries) {
			Resource eResource = asLibrary.eResource();
			if (eResource instanceof ASResource) {
				as2xmIid.assignIds((ASResource) eResource, options);
			}
		}
	}

	/**
	 * Return -ve if match1 is inferior to match2, +ve if match2 is inferior to match1, or
	 * zero if both matches are of equal validity.
	 */
	public int compareOperationMatches(@NonNull Operation reference, @NonNull TemplateParameterSubstitutions referenceBindings,
			@NonNull Operation candidate, @NonNull TemplateParameterSubstitutions candidateBindings) {
		if ((reference instanceof Iteration) && (candidate instanceof Iteration)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterators().size() - ((Iteration)reference).getOwnedIterators().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			org.eclipse.ocl.pivot.Class referenceClass = reference.getOwningClass();
			org.eclipse.ocl.pivot.Class candidateClass = candidate.getOwningClass();
			Type referenceType = referenceClass != null ? PivotUtil.getBehavioralType(referenceClass) : null;
			Type candidateType = candidateClass != null ? PivotUtil.getBehavioralType(candidateClass) : null;
			Type specializedReferenceType = referenceType != null ? completeModel.getSpecializedType(referenceType, referenceBindings) : null;
			Type specializedCandidateType = candidateType != null ? completeModel.getSpecializedType(candidateType, candidateBindings) : null;
			if ((referenceType != candidateType) && (specializedReferenceType != null) && (specializedCandidateType != null)) {
				if (conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
					return 1;
				}
				else if (conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
					return -1;
				}
			}
		}
		List<Parameter> candidateParameters = candidate.getOwnedParameters();
		List<Parameter> referenceParameters = reference.getOwnedParameters();
		int parameterCountDelta = candidateParameters.size() - referenceParameters.size();
		if (parameterCountDelta != 0) {
			return parameterCountDelta;
		}
		boolean referenceConformsToCandidate = true;
		boolean candidateConformsToReference = true;
		for (int i = 0; i < candidateParameters.size(); i++) {
			Parameter referenceParameter = referenceParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			if ((referenceParameter == null) || (candidateParameter == null)) {					// Doesn't happen (just a spurious NPE guard)
				referenceConformsToCandidate = false;
				candidateConformsToReference = false;
			}
			else {
				Type referenceType = ClassUtil.nonNullState(PivotUtil.getType(referenceParameter));
				Type candidateType = ClassUtil.nonNullState(PivotUtil.getType(candidateParameter));
				Type specializedReferenceType = completeModel.getSpecializedType(referenceType, referenceBindings);
				Type specializedCandidateType = completeModel.getSpecializedType(candidateType, candidateBindings);
				if (referenceType != candidateType) {
					if (!conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
						referenceConformsToCandidate = false;
					}
					if (!conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
						candidateConformsToReference = false;
					}
				}
			}
		}
		if (referenceConformsToCandidate != candidateConformsToReference) {
			return referenceConformsToCandidate ? 1 : -1;
		}
		Type referenceType = ClassUtil.nonNullModel(reference.getOwningClass());
		Type candidateType = ClassUtil.nonNullModel(candidate.getOwningClass());
		Type specializedReferenceType = completeModel.getSpecializedType(referenceType, referenceBindings);
		Type specializedCandidateType = completeModel.getSpecializedType(candidateType, candidateBindings);
		if (referenceType != candidateType) {
			if (conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
				return 1;
			}
			else if (conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		return completeModel.conformsTo(firstType, firstSubstitutions, secondType, secondSubstitutions);
	}

	public @NonNull BooleanLiteralExp createBooleanLiteralExp(boolean booleanSymbol) {		// FIXME move to PivotHelper
		BooleanLiteralExp asBoolean = PivotFactory.eINSTANCE.createBooleanLiteralExp();
		asBoolean.setBooleanSymbol(booleanSymbol);
		asBoolean.setType(standardLibrary.getBooleanType());
		asBoolean.setIsRequired(true);
		return asBoolean;
	}

	// @Deprecated but retained for API compatibility.
	public @NonNull IfExp createIfExp(@NonNull OperationCallExp asCondition, @NonNull OCLExpression asThen, @NonNull OCLExpression asElse) {
		return createIfExp((OCLExpression)asCondition, asThen, asElse);
	}

	/**
	 * @since 1.1
	 */
	public @NonNull IfExp createIfExp(@NonNull OCLExpression asCondition, @NonNull OCLExpression asThen, @NonNull OCLExpression asElse) {		// FIXME move to PivotHelper
		Type commonType = getCommonType(ClassUtil.nonNullState(asThen.getType()), TemplateParameterSubstitutions.EMPTY,
			ClassUtil.nonNullState(asElse.getType()), TemplateParameterSubstitutions.EMPTY);
		IfExp asIf = PivotFactory.eINSTANCE.createIfExp();
		asIf.setOwnedCondition(asCondition);
		asIf.setOwnedThen(asThen);
		asIf.setOwnedElse(asElse);
		asIf.setType(commonType);
		asIf.setIsRequired(asThen.isIsRequired() && asElse.isIsRequired());
		return asIf;
	}

	/**
	 * @since 1.8
	 */
	public void createImplicitOppositeProperty(@NonNull Property asProperty, @NonNull String oppositeName,
			boolean isOrdered, boolean isUnique, @NonNull IntegerValue lower, @NonNull UnlimitedNaturalValue upper) {
		org.eclipse.ocl.pivot.Class localType = asProperty.getOwningClass();
		if (localType == null) {
			asProperty.setOpposite(null);
			return;
//			localType = standardLibrary.getOclInvalidType();
		}
		Model thisModel = PivotUtil.getContainingModel(localType);
		assert thisModel != null;
		org.eclipse.ocl.pivot.Class remoteType = (org.eclipse.ocl.pivot.Class)asProperty.getType();	// FIXME cast
		while (remoteType instanceof CollectionType) {
			remoteType = (org.eclipse.ocl.pivot.Class)((CollectionType)remoteType).getElementType();	// FIXME cast
		}
		if (remoteType == null) {
			asProperty.setOpposite(null);
			return;
		}
		org.eclipse.ocl.pivot.Class thisRemoteType = getEquivalentClass(thisModel, remoteType);
		Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
		oppositeProperty.setName(oppositeName);
		oppositeProperty.setIsImplicit(true);
		if (!((NumberValue)upper).equals(ValueUtil.ONE_VALUE)) {
			oppositeProperty.setType(getCollectionType(isOrdered, isUnique, localType, false, lower, upper));
			oppositeProperty.setIsRequired(true);
		}
		else {
			oppositeProperty.setType(localType);
			oppositeProperty.setIsRequired(lower.equals(ValueUtil.ONE_VALUE));
		}
		thisRemoteType.getOwnedProperties().add(oppositeProperty);
		oppositeProperty.setOpposite(asProperty);
		asProperty.setOpposite(oppositeProperty);
	}

	public @NonNull IntegerLiteralExp createIntegerLiteralExp(@NonNull Number integerSymbol) {		// FIXME move to PivotHelper
		IntegerLiteralExp asInteger = PivotFactory.eINSTANCE.createIntegerLiteralExp();
		asInteger.setIntegerSymbol(integerSymbol);
		asInteger.setType(standardLibrary.getIntegerType());
		asInteger.setIsRequired(true);
		return asInteger;
	}

	public @NonNull InvalidLiteralExp createInvalidExpression(/*Object object, String boundMessage, Throwable e*/) {		// FIXME move to PivotHelper
		InvalidLiteralExp invalidLiteralExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		invalidLiteralExp.setType(standardLibrary.getOclInvalidType());
		//		invalidLiteralExp.setObject(object);
		//		invalidLiteralExp.setReason(boundMessage);
		//		invalidLiteralExp.setThrowable(e);
		return invalidLiteralExp;
	}

	public @NonNull NullLiteralExp createNullLiteralExp() {		// FIXME move to PivotHelper
		NullLiteralExp asNull = PivotFactory.eINSTANCE.createNullLiteralExp();
		asNull.setType(standardLibrary.getOclVoidType());
		asNull.setIsRequired(false);
		return asNull;
	}

	/**
	 * @since 1.8
	 */
	@Deprecated /* @deprected use PropertyDetails.createOppositeEAnnotationDetails */
	public @Nullable Map<@NonNull String, @NonNull String> createOppositeEAnnotationDetails(@NonNull Property property) {
		OppositePropertyDetails oppositePropertyDetails = OppositePropertyDetails.createFromProperty(property);
		if (oppositePropertyDetails != null) {
			Map<@NonNull String, @NonNull String> details = new HashMap<>();
			oppositePropertyDetails.addDetails(details);
			return details;
		}
		else {
			return null;
		}
	}

	public @NonNull Orphanage createOrphanage() {
		return Orphanage.getOrphanage(asResourceSet);
	}

	/**
	 * Return a parserContext suitable for parsing OCL expressions in the context of a pivot element.
	 *
	 * @deprecated not used - use AbstractEnvironmentFactory.createParserContext()
	 */
	@Deprecated
	@Override
	public @Nullable ParserContext createParserContext(@NonNull Element element, Object... todoParameters) {
		return ((EnvironmentFactoryInternalExtension)environmentFactory).createParserContext(element);
	}

	protected @NonNull PrecedenceManager createPrecedenceManager() {
		PrecedenceManager precedenceManager = new PrecedenceManager();
		List<@NonNull String> errors = precedenceManager.compilePrecedences(asLibraries);
		for (@NonNull String error : errors) {
			logger.error(error);
		}
		return precedenceManager;
	}

	public @NonNull RealLiteralExp createRealLiteralExp(@NonNull Number realSymbol) {		// FIXME move to PivotHelper
		RealLiteralExp asReal = PivotFactory.eINSTANCE.createRealLiteralExp();
		asReal.setRealSymbol(realSymbol);
		asReal.setType(standardLibrary.getRealType());
		asReal.setIsRequired(true);
		return asReal;
	}

	public @NonNull StringLiteralExp createStringLiteralExp(@NonNull String stringSymbol) {		// FIXME move to PivotHelper
		StringLiteralExp asString = PivotFactory.eINSTANCE.createStringLiteralExp();
		asString.setStringSymbol(stringSymbol);
		asString.setType(standardLibrary.getStringType());
		asString.setIsRequired(true);
		return asString;
	}

	public @NonNull UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp(@NonNull Number unlimitedNaturalSymbol) {		// FIXME move to PivotHelper
		UnlimitedNaturalLiteralExp asUnlimitedNatural = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
		asUnlimitedNatural.setUnlimitedNaturalSymbol(unlimitedNaturalSymbol);
		asUnlimitedNatural.setType(standardLibrary.getUnlimitedNaturalType());
		asUnlimitedNatural.setIsRequired(true);
		return asUnlimitedNatural;
	}

	public @NonNull WildcardType createWildcardType(org.eclipse.ocl.pivot.@Nullable Class lowerBound, org.eclipse.ocl.pivot.@Nullable Class upperBound) {		// FIXME move to PivotHelper
		WildcardType wildcardType = Orphanage.getOrphanWildcardType(environmentFactory.getCompleteModel().getOrphanage());// PivotFactory.eINSTANCE.createWildcardType();
	//	wildcardType.setName("?");			// Name is not significant
	//	wildcardType.setLowerBound(lowerBound != null ? lowerBound : standardLibrary.getOclAnyType());
	//	wildcardType.setUpperBound(upperBound != null ? upperBound : standardLibrary.getOclVoidType());
		return wildcardType;
	}

	public void dispose() {
		//		System.out.println("[" + Thread.currentThread().getName() + "] dispose AS " + NameUtil.debugSimpleName(asResourceSet));
		asResourceSet.eAdapters().remove(this);
		List<@NonNull Resource> asResources = asResourceSet.getResources();
		for (@NonNull Resource asResource : new ArrayList<>(asResources)) {
			asResource.unload();
			asResource.eAdapters().clear();
		}
		asResources.clear();
		asResourceSet.setPackageRegistry(null);
		asResourceSet.setResourceFactoryRegistry(null);
		asResourceSet.setURIConverter(null);
		//		asResourceSet.setURIResourceMap(null);
		asLibraries.clear();
		asLibraryResource = null;
		StandaloneProjectMap projectMap = StandaloneProjectMap.findAdapter(asResourceSet);
		if (projectMap != null) {
			projectMap.unload(asResourceSet);
		}
		asResourceSet.eAdapters().clear();
		//		StandaloneProjectMap.dispose(asResourceSet);
		/*		ResourceSet externalResourceSet2 = externalResourceSet;
		if (externalResourceSet2 != null) {
//			System.out.println("dispose CS " + ClassUtil.debugSimpleName(externalResourceSet));
			StandaloneProjectMap projectMap2 = StandaloneProjectMap.findAdapter(externalResourceSet2);
			if (projectMap2 != null) {
				projectMap2.unload(externalResourceSet2);
				externalResourceSet2.eAdapters().remove(projectMap2);
			}
//			StandaloneProjectMap.dispose(externalResourceSet2);
			externalResourceSet2.setPackageRegistry(null);
			externalResourceSet2.setResourceFactoryRegistry(null);
			externalResourceSet2.setURIConverter(null);
			if (externalResourceSet2 instanceof ResourceSetImpl) {
				((ResourceSetImpl)externalResourceSet2).setURIResourceMap(null);
			}
			for (Resource resource : new ArrayList<Resource>(externalResourceSet2.getResources())) {
				resource.unload();
			}
			externalResourceSet = null;
		} */
		globalNamespaces.clear();
		globalTypes.clear();
		external2asMap.clear();
		Map<Resource, External2AS> es2ases2 = es2ases;
		if (es2ases2 != null) {
			for (External2AS es2as : es2ases2.values()) {
				es2as.dispose();
			}
			es2ases = null;
		}
		lockingAnnotation = null;
		completeModel.dispose();
		if (precedenceManager != null) {
			precedenceManager.dispose();
			precedenceManager = null;
		}
		if (implementationManager != null) {
			implementationManager.dispose();
			implementationManager = null;
		}
		asMetamodel = null;
		standardLibrary.dispose();
	}

	@Override
	protected void finalize() throws Throwable {
		if (liveMetamodelManagers != null) {
			PivotUtilInternal.debugPrintln("Finalize " + NameUtil.debugSimpleName(this));
			List<@NonNull PivotMetamodelManager> keySet = new ArrayList<>(liveMetamodelManagers.keySet());
			if (!keySet.isEmpty()) {
				StringBuilder s = new StringBuilder();
				s.append(" live");
				for (@NonNull PivotMetamodelManager metamodelManager : keySet) {
					s.append(" @" + Integer.toHexString(metamodelManager.hashCode()));
				}
				System.out.println(s.toString());
			}
		}
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getASClass(@NonNull String className) {
		if (asMetamodel == null) {
			getASmetamodel();
			if (asMetamodel == null) {
				return null;
			}
		}
		return NameUtil.getNameable(asMetamodel.getOwnedClasses(), className);
	}

	public @Nullable Element getASElement(@NonNull URI uri) {
		if (uri.fragment() == null) {
			ASResource resource = (ASResource)asResourceSet.getResource(uri, true);
			return resource.getModel();
		}
		else {
			Element element = (Element)asResourceSet.getEObject(uri, true);
			return element;
		}
	}

	/*
	 * @deprecated use EnvironmentFactoryInternalExtension.getASOf()
	 */
	@Deprecated
	@Override
	public @Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException {
		return ((EnvironmentFactoryInternalExtension)environmentFactory).getASOf(pivotClass, eObject);
	}

	@Override
	public @Nullable <T extends Element> T getASOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		Resource metamodel = eObject.eResource();
		if (metamodel == null) {
			return null;
		}
		External2AS es2as = Ecore2AS.findAdapter(metamodel, environmentFactory);
		if (es2as == null) {
			es2as = Ecore2AS.getAdapter(metamodel, environmentFactory);
		}
		return es2as.getCreated(pivotClass, eObject);
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Package getASmetamodel() {
		if ((asMetamodel == null) && autoLoadASmetamodel) {
			org.eclipse.ocl.pivot.Package stdlibPackage = null;
			AnyType oclAnyType = standardLibrary.getOclAnyType();				// Load a default library if necessary.
		//	if (!asLibraries.isEmpty()) {
		//		stdlibPackage = asLibraries.get(0);
		//	}
		//	if (stdlibPackage == null) {
				stdlibPackage = oclAnyType.getOwningPackage();
		//	}
			if (stdlibPackage != null) {
				loadASmetamodel(stdlibPackage);
			}
		}
		return asMetamodel;
	}

	@Override
	public @NonNull ResourceSet getASResourceSet() {
		return asResourceSet;
	}

	public @NonNull Iterable<@NonNull CompletePackageInternal> getAllCompletePackages() {
		if (!libraryLoadInProgress && (asMetamodel == null))  {
			getASmetamodel();
		}
		return completeModel.getAllCompletePackages();
	}

	/**
	 * Return all constraints applicable to a type and its superclasses.
	 */
	@Override
	public @NonNull Iterable<Constraint> getAllInvariants(@NonNull Type pivotType) {
		Set<Constraint> knownInvariants = new HashSet<>();
		for (CompleteClass superType : getAllSuperCompleteClasses(pivotType)) {
			for (org.eclipse.ocl.pivot.@NonNull Class partialSuperType : ClassUtil.nullFree(superType.getPartialClasses())) {
				org.eclipse.ocl.pivot.Package partialPackage = partialSuperType.getOwningPackage();
				if (!(partialPackage instanceof PackageImpl) || !((PackageImpl)partialPackage).isIgnoreInvariants()) {
					knownInvariants.addAll(partialSuperType.getOwnedInvariants());
				}
			}
		}
		return knownInvariants;
	}

	public @NonNull Iterable<@NonNull Operation> getAllOperations(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getOperations(featureFilter);
	}

	public @NonNull Iterable<@NonNull Operation> getAllOperations(@NonNull Type type, @Nullable FeatureFilter featureFilter, @NonNull String name) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getOperations(featureFilter, name);
	}

	/*	@Override
	public @NonNull Iterable<org.eclipse.ocl.pivot.Package> getAllPackages() {
		if (!libraryLoadInProgress && (asMetamodel == null))  {
			getASmetamodel();
		}
		return packageManager.getAllPackages();
	} */

	public @NonNull Iterable<? extends Property> getAllProperties(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getProperties(featureFilter);
	}

	public @NonNull Iterable<? extends Property> getAllProperties(@NonNull Type type, @Nullable FeatureFilter featureFilter, @NonNull String name) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getProperties(featureFilter, name);
	}

	public @NonNull Iterable<? extends Property> getAllProperties(@NonNull Property pivotProperty) {
		CompleteInheritance pivotClass = pivotProperty.getInheritance(standardLibrary);
		if (pivotClass == null) {
			throw new IllegalStateException("Missing owning type");
		}
		CompleteClass completeClass = completeModel.getCompleteClass(pivotClass.getPivotClass());
		Iterable<? extends Property> memberProperties = completeClass.getProperties(pivotProperty);
		if (memberProperties != null) {
			return memberProperties;
		}
		return Collections.singletonList(pivotProperty);
	}

	public @NonNull Iterable<@NonNull CompleteClass> getAllSuperCompleteClasses(@NonNull Type type) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getSuperCompleteClasses();
	}

	@Deprecated
	public @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getAllTypes(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		//		if (pivotType == null) {
		//			return EMPTY_TYPE_LIST;
		//		}
		//		return getTypeTracker(pivotType).getTypeServer().getTypes();
		CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> filter = Iterables.filter(completeClass.getPartialClasses(), org.eclipse.ocl.pivot.Class.class);
		return filter;
	}

	@Deprecated
	public @NonNull Iterable<@NonNull Type> getAllTypes(@NonNull Type pivotType) {
		//		if (pivotType == null) {
		//			return EMPTY_TYPE_LIST;
		//		}
		//		return getTypeTracker(pivotType).getTypeServer().getTypes();
		CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		@NonNull Iterable<@NonNull Type> filter = Iterables.filter(completeClass.getPartialClasses(), Type.class);
		return filter;
	}

	public @Nullable ExpressionInOCL getBodyExpression(@NonNull Operation operation) {
		ExpressionInOCL bodyExpression = null;
		for (@SuppressWarnings("null")@NonNull Operation domainOperation : getOperationOverloads(operation)) {
			LanguageExpression anExpression = domainOperation.getBodyExpression();
			if (anExpression != null) {
				if (bodyExpression != null) {
					throw new IllegalStateException("Multiple bodies for " + operation);
				}
				try {
					bodyExpression = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(anExpression);
				} catch (ParserException e) {
					String message = e.getMessage();
					if (message == null) {
						message = "";
					}
					logger.error(message);
					bodyExpression = PivotUtil.createExpressionInOCLError(message);
				}
			}
		}
		return bodyExpression;
	}

	public @NonNull CollectionType getCollectionType(boolean isOrdered, boolean isUnique) {
		if (isOrdered) {
			if (isUnique) {
				return standardLibrary.getOrderedSetType();
			}
			else {
				return standardLibrary.getSequenceType();
			}
		}
		else {
			if (isUnique) {
				return standardLibrary.getSetType();
			}
			else {
				return standardLibrary.getBagType();
			}
		}
	}

	public @NonNull CollectionType getCollectionType(boolean isOrdered, boolean isUnique, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return completeEnvironment.getCollectionType(getCollectionType(isOrdered, isUnique), elementType, isNullFree, lower, upper);
	}

	/**
	 * @deprecated add isNullFree argument
	 */
	@Deprecated
	public org.eclipse.ocl.pivot.@NonNull Class getCollectionType(@NonNull String collectionTypeName, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(collectionTypeName, elementType, false, lower, upper);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getCollectionType(@NonNull String collectionTypeName, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		if (elementType.eIsProxy()) {
			return standardLibrary.getOclInvalidType();
		}
		return completeEnvironment.getCollectionType(standardLibrary.getRequiredLibraryType(collectionTypeName), elementType, isNullFree, lower, upper);
	}

	public @NonNull Type getCommonType(@NonNull Type leftType, @NonNull TemplateParameterSubstitutions leftSubstitutions,
			@NonNull Type rightType, @NonNull TemplateParameterSubstitutions rightSubstitutions) {
		if ((leftType instanceof TupleType) && (rightType instanceof TupleType)) {
			TupleTypeManager tupleManager = completeModel.getTupleManager();
			Type commonType = tupleManager.getCommonType((TupleType)leftType, leftSubstitutions, (TupleType)rightType, rightSubstitutions);
			if (commonType == null) {
				commonType = standardLibrary.getOclAnyType();
			}
			return commonType;
		}
		if ((leftType instanceof CollectionType) && (rightType instanceof CollectionType)) {
			CompleteInheritance leftInheritance = leftType.getInheritance(standardLibrary);
			CompleteInheritance rightInheritance = rightType.getInheritance(standardLibrary);
			CompleteInheritance commonInheritance = leftInheritance.getCommonInheritance(rightInheritance);
			org.eclipse.ocl.pivot.Class commonCollectionType = getPrimaryClass(commonInheritance.getPivotClass());
			CollectionType leftCollectionType = (CollectionType)leftType;
			CollectionType rightCollectionType = (CollectionType)rightType;
			Type leftElementType = ClassUtil.nonNullModel(leftCollectionType.getElementType());
			Type rightElementType = ClassUtil.nonNullModel(rightCollectionType.getElementType());
			Type commonElementType = getCommonType(leftElementType, leftSubstitutions, rightElementType, rightSubstitutions);
			boolean commonIsNullFree = leftCollectionType.isIsNullFree() && rightCollectionType.isIsNullFree();
			return completeEnvironment.getCollectionType(commonCollectionType, commonElementType, commonIsNullFree, null, null);
		}
		if (conformsTo(leftType, leftSubstitutions, rightType, rightSubstitutions)) {
			return rightType;
		}
		if (conformsTo(rightType, rightSubstitutions, leftType, leftSubstitutions)) {
			return leftType;
		}
		CompleteInheritance leftInheritance = leftType.getInheritance(standardLibrary);
		CompleteInheritance rightInheritance = rightType.getInheritance(standardLibrary);
		CompleteInheritance commonInheritance = leftInheritance.getCommonInheritance(rightInheritance);
		return getPrimaryClass(commonInheritance.getPivotClass());
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType) {
		if (!libraryLoadInProgress && (asMetamodel == null) && !(pivotType instanceof CollectionType) && !(pivotType instanceof VoidType) && !(pivotType instanceof InvalidType)) {
			getASmetamodel();
		}
		return completeModel.getCompleteClass(pivotType);
	}

	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		return completeEnvironment;
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return completeModel;
	}

	@Override
	public @NonNull CompletePackage getCompletePackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (!libraryLoadInProgress && asMetamodel == null) {
			getASmetamodel();
		}
		return completeModel.getCompletePackage(asPackage);
	}

	public @Nullable ExpressionInOCL getDefaultExpression(@NonNull Property property) {
		ExpressionInOCL defaultExpression = null;
		for (@SuppressWarnings("null")@NonNull Property domainProperty : getAllProperties(property)) {
			LanguageExpression anExpression = domainProperty.getOwnedExpression();
			if (anExpression != null) {
				if (defaultExpression != null) {
					throw new IllegalStateException("Multiple derivations for " + property);
				}
				try {
					defaultExpression = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(anExpression);
				} catch (ParserException e) {
					String message = e.getMessage();
					if (message == null) {
						message = "";
					}
					logger.error(message);
					defaultExpression = PivotUtil.createExpressionInOCLError(message);
				}
			}
		}
		return defaultExpression;
	}

	@Override
	public @Nullable <T extends EObject> T getEcoreOfPivot(@NonNull Class<T> ecoreClass, @NonNull Element element) {
		EObject eTarget = element.getESObject();
		if (eTarget != null) {
			if (!ecoreClass.isAssignableFrom(eTarget.getClass())) {
				logger.error("Ecore " + eTarget.getClass().getName() + "' element is not a '" + ecoreClass.getName() + "'"); //$NON-NLS-1$
				return null;
			}
			@SuppressWarnings("unchecked")
			T castTarget = (T) eTarget;
			return castTarget;
		}
		Model root = (Model)EcoreUtil.getRootContainer(element);
		Resource asResource = element.eResource();
		if (asResource == null) {
			return null;
		}
		if (asResource instanceof OCLstdlib) {		// Not really a model so no Ecore
			return null;
		}
		URI ecoreURI;
		String externalUri = root.getExternalURI();
		URI externalURI = URI.createURI(externalUri);
		if (PivotUtilInternal.isASURI(externalUri)) {
			ecoreURI = ClassUtil.nonNullEMF(externalURI.trimFileExtension());
		}
		else {
			ecoreURI = ClassUtil.nonNullEMF(externalURI.appendFileExtension("ecore"));
		}
		AS2Ecore converter = new AS2Ecore(environmentFactory, ecoreURI, null);
		converter.convertResource(asResource, ecoreURI);
		return converter.getCreated(ecoreClass, element);
	}

	/**
	 * Return an ElementExtension for asStereotype reusing any that already exist in asElementExtensions.
	 */
	public @NonNull ElementExtension getElementExtension(@NonNull Element asStereotypedElement, @NonNull Stereotype asStereotype) {
		List<ElementExtension> extensions = asStereotypedElement.getOwnedExtensions();
		for (ElementExtension asElementExtension : extensions) {
			if (asElementExtension.getStereotype() == asStereotype) {
				return asElementExtension;
			}
		}
		@NonNull ElementExtension asElementExtension = PivotFactory.eINSTANCE.createElementExtension();
		asElementExtension.setStereotype(asStereotype);
		String name = environmentFactory.getTechnology().getExtensionName(asStereotypedElement);
		asElementExtension.setName(name + "$" + asStereotype.getName());
		//		asElementExtension.getSuperClass().add(getOclAnyType());
		extensions.add(asElementExtension);
		return asElementExtension;
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	/**
	 * Return the equivalent class to thatClass in thisModel, where equivalent is the same
	 * class/package name hierarchy. This is typically used to create a merge contribution
	 * for thatClass in thisModel avoiding the need to modify thatClass.
	 */
	public org.eclipse.ocl.pivot.@NonNull Class getEquivalentClass(@NonNull Model thisModel, org.eclipse.ocl.pivot.@NonNull Class thatClass) {
		completeModel.getCompleteClass(thatClass);					// Ensure thatPackage has a complete representation -- BUG 477342 once gave intermittent dispose() ISEs
		Model thatModel = PivotUtil.getContainingModel(thatClass);
		if (thisModel == thatModel) {
			return thatClass;
		}
		org.eclipse.ocl.pivot.Package thatPackage = PivotUtil.getOwningPackage(thatClass);
		org.eclipse.ocl.pivot.Package thisPackage = getEquivalentPackage(thisModel, thatPackage);
		List<org.eclipse.ocl.pivot.Class> theseClasses = thisPackage.getOwnedClasses();
		String className = PivotUtil.getName(thatClass);
		org.eclipse.ocl.pivot.Class thisClass = NameUtil.getNameable(theseClasses, className);
		if (thisClass == null) {
			thisClass = PivotUtil.createClass(className);
			theseClasses.add(thisClass);
		}
		return thisClass;
	}

	/**
	 * Return the equivalent package to thatPackage in thisModel, where equivalent is the same
	 * package name hierarchy. This is typically used to create a merge contribution
	 * for thatClass in thisModel avoiding the need to modify thatClass.
	 */
	private org.eclipse.ocl.pivot.@NonNull Package getEquivalentPackage(@NonNull Model thisModel, org.eclipse.ocl.pivot.@NonNull Package thatPackage) {
		completeModel.getCompletePackage(thatPackage);					// Ensure thatPackage has a complete representation
		Model thatModel = PivotUtil.getContainingModel(thatPackage);
		if (thisModel == thatModel) {
			return thatPackage;
		}
		List<org.eclipse.ocl.pivot.Package> thesePackages;
		org.eclipse.ocl.pivot.Package thatParentPackage = thatPackage.getOwningPackage();
		if (thatParentPackage == null) {
			thesePackages = thisModel.getOwnedPackages();
		}
		else {
			org.eclipse.ocl.pivot.Package thisParentPackage = getEquivalentPackage(thisModel, thatParentPackage);
			thesePackages = thisParentPackage.getOwnedPackages();
		}
		String packageName = PivotUtil.getName(thatPackage);
		org.eclipse.ocl.pivot.Package thisPackage = NameUtil.getNameable(thesePackages, packageName);
		if (thisPackage == null) {
			String pkgURI = ClassUtil.nonNullModel(thatPackage.getURI());
			thisPackage = PivotUtil.createPackage(packageName, thatPackage.getNsPrefix(), pkgURI, thatPackage.getPackageId());
			thesePackages.add(thisPackage);
		}
		return thisPackage;
	}

	public @Nullable External2AS getES2AS(@NonNull Resource esResource) {
		return es2ases != null ? es2ases.get(esResource) : null;
	}

	@Override
	public @NonNull FinalAnalysis getFinalAnalysis() {
		FinalAnalysis finalAnalysis2 = finalAnalysis;
		if (finalAnalysis2 == null) {
			finalAnalysis = finalAnalysis2 = new FinalAnalysis(completeModel);
		}
		return finalAnalysis2;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @NonNull FlowAnalysis getFlowAnalysis(@NonNull OCLExpression oclExpression) {
		OCLExpression contextExpression = FlowAnalysis.getControlExpression(oclExpression);
		Map<@NonNull OCLExpression, @NonNull FlowAnalysis> oclExpression2flowAnalysis2 = oclExpression2flowAnalysis;
		if (oclExpression2flowAnalysis2 == null) {
			oclExpression2flowAnalysis2 = oclExpression2flowAnalysis = new HashMap<>();
		}
		FlowAnalysis flowAnalysis = oclExpression2flowAnalysis2.get(contextExpression);
		if (flowAnalysis == null) {
			flowAnalysis = environmentFactory.createFlowAnalysis(contextExpression);
			oclExpression2flowAnalysis2.put(contextExpression, flowAnalysis);
		}
		return flowAnalysis;
	}

	@Override
	public @Nullable GenPackage getGenPackage(@NonNull String nsURI) {
		if (genPackageMap != null) {
			GenPackage genPackage = genPackageMap.get(nsURI);
			if (genPackage != null) {
				return genPackage;
			}
		}
		ResourceSet externalResourceSet = environmentFactory.getResourceSet();
		URI uri = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(true).get(nsURI);
		if (uri != null) {
			Resource resource = externalResourceSet.getResource(uri, true);
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					for (GenPackage genPackage : genModel.getGenPackages()) {
						if (genPackage != null) {
							addGenPackage(genPackage);
							return genPackage;
						}
					}
				}
			}
		}
		return null;
	}

	public @NonNull Set<Map.@NonNull Entry<String, Namespace>> getGlobalNamespaces() {
		return globalNamespaces.entrySet();
	}

	public @NonNull Iterable<Type> getGlobalTypes() {
		return globalTypes;
	}

	public @NonNull LibraryFeature getImplementation(@NonNull Feature feature) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = feature.getImplementation();
		if (implementation == null) {
			ImplementationManager implementationManager = getImplementationManager();
			implementation = implementationManager.loadImplementation(feature);
			if (implementation == null) {
				implementation = UnsupportedOperation.INSTANCE;
			}
		}
		return implementation;
	}

	public @NonNull LibraryFeature getImplementation(@NonNull Operation operation) {
		LibraryFeature implementation = operation.getImplementation();
		if (implementation == null) {
			boolean isCodeGeneration = getCompleteEnvironment().isCodeGeneration();
			if (isCodeGeneration) {
				LanguageExpression specification = operation.getBodyExpression();
				if (specification != null) {
					org.eclipse.ocl.pivot.Class owningType = operation.getOwningClass();
					if (owningType != null) {
						try {
							ExpressionInOCL query = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
							implementation = new ConstrainedOperation(query);
						} catch (ParserException e) {
							// TODO Auto-generated catch block
							//							e.printStackTrace();
							implementation = UnsupportedOperation.INSTANCE;
						}
					}
				}
			}
			if (implementation == null) {
				EObject eTarget = operation.getESObject();
				if (eTarget != null) {
					EOperation eOperation = null;
					if (eTarget instanceof EOperation) {
						eOperation = (EOperation) eTarget;
						while (eOperation.eContainer() instanceof EAnnotation) {
							EAnnotation redefines = eOperation.getEAnnotation(PivotConstantsInternal.REDEFINES_ANNOTATION_SOURCE);
							if (redefines != null) {
								List<EObject> references = redefines.getReferences();
								if (references.size() > 0) {
									EObject eReference = references.get(0);
									if (eReference instanceof EOperation) {
										eOperation = (EOperation)eReference;
									}
								}
							}
						}
					}
					else {
						Resource resource = operation.eResource();
						if (resource instanceof ASResource) {
							ASResource asResource = (ASResource)resource;
							eOperation = asResource.getASResourceFactory().getEOperation(asResource, eTarget);
						}
					}
					if ((eOperation != null) && (eOperation.getEType() != null)) {
						implementation = new EInvokeOperation(eOperation);
					}
				}
			}
			if (!isCodeGeneration && (implementation == null)) {
				LanguageExpression specification = operation.getBodyExpression();
				if (specification != null) {
					org.eclipse.ocl.pivot.Class owningType = operation.getOwningClass();
					if (owningType != null) {
						try {
							ExpressionInOCL query = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
							implementation = new ConstrainedOperation(query);
						} catch (ParserException e) {
							// TODO Auto-generated catch block
							//							e.printStackTrace();
							implementation = UnsupportedOperation.INSTANCE;
						}
					}
				}
			}
			if (implementation == null) {
				try {
					implementation = getImplementation((Feature) operation);
				} catch (ClassNotFoundException | SecurityException
						| NoSuchFieldException | IllegalArgumentException
						| IllegalAccessException e) {}
			}
			if (implementation == null) {
				implementation = UnsupportedOperation.INSTANCE;
			}
			operation.setImplementation(implementation);
		}
		return implementation;
	}

	@Deprecated //in use by QVTiAS2CGVisitor
	public @NonNull LibraryProperty getImplementation(@Nullable Object sourceValue, @NonNull Property property) {
		return getImplementation(null, sourceValue, property);	// Change dead argument to @NonNull once removed
	}
	@Override
	public @NonNull LibraryProperty getImplementation(@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property) {
		LibraryProperty implementation = (LibraryProperty) property.getImplementation();
		if (implementation == null) {
			ImplementationManager implementationManager = getImplementationManager();
			implementation = implementationManager.getPropertyImplementation(asNavigationExp, sourceValue, property);
			property.setImplementation(implementation);
		}
		return implementation;
	}

	public @NonNull ImplementationManager getImplementationManager() {
		ImplementationManager implementationManager2 = implementationManager;
		if (implementationManager2 == null) {
			implementationManager2 = implementationManager = environmentFactory.createImplementationManager();
		}
		return implementationManager2;
	}

	public @Nullable Precedence getInfixPrecedence(@NonNull String operatorName) {
		getStandardLibrary();
		PrecedenceManager precedenceManager = getPrecedenceManager();
		return precedenceManager.getInfixPrecedence(operatorName);
	}

	public @NonNull CompleteInheritance getInheritance(org.eclipse.ocl.pivot.@NonNull Class type) {
		org.eclipse.ocl.pivot.Class type1 = getPrimaryClass(type);
		org.eclipse.ocl.pivot.Class unspecializedType = (org.eclipse.ocl.pivot.Class) type1.getUnspecializedElement();
		org.eclipse.ocl.pivot.Class theType = unspecializedType != null ? unspecializedType : type1;
		CompleteInheritanceImpl completeInheritance = getCompleteClass(theType).getCompleteInheritance();
		return completeInheritance;
	}

	public @NonNull List<@NonNull Library> getLibraries() { return asLibraries; }
	public @Nullable Resource getLibraryResource() { return asLibraryResource; }

	public org.eclipse.ocl.pivot.@Nullable Class getLibraryType(@NonNull String string, @NonNull List<@NonNull ? extends Type> templateArguments) {
		org.eclipse.ocl.pivot.Class libraryType = standardLibrary.getRequiredLibraryType(string);
		return getLibraryType(libraryType, templateArguments);
	}

	public @NonNull <T extends org.eclipse.ocl.pivot.Class> T getLibraryType(@NonNull T libraryType, @NonNull List<@NonNull ? extends Type> templateArguments) {
		//		assert !(libraryType instanceof CollectionType);
		assert libraryType == PivotUtil.getUnspecializedTemplateableElement(libraryType);
		TemplateSignature templateSignature = libraryType.getOwnedSignature();
		List<TemplateParameter> templateParameters = templateSignature != null ? templateSignature.getOwnedParameters() : EMPTY_TEMPLATE_PARAMETER_LIST2;
		if (templateParameters.isEmpty()) {
			return libraryType;
		}
		if (templateArguments.size() != templateParameters.size()) {
			throw new IllegalArgumentException("Incorrect template bindings for template type " + libraryType.getName());
		}
		boolean isUnspecialized = isUnspecialized(templateParameters, templateArguments);
		if (isUnspecialized) {
			return libraryType;
		}
		CompleteClassInternal libraryCompleteClass = getCompleteClass(libraryType);
		org.eclipse.ocl.pivot.Class pivotClass = libraryCompleteClass.getPrimaryClass();
		if (pivotClass instanceof CollectionType) {
			assert pivotClass instanceof CollectionType;
			assert templateArguments.size() == 1;
			@NonNull Type templateArgument = templateArguments.get(0);
			@SuppressWarnings("unchecked") T specializedType = (T) completeModel.getCollectionType(libraryCompleteClass, TypeUtil.createCollectionTypeParameters(templateArgument, true, null, null));
			return specializedType;
		}
		else if (pivotClass instanceof MapType) {
			assert pivotClass instanceof MapType;
			assert templateArguments.size() == 2;
			@NonNull Type keyTemplateArgument = templateArguments.get(0);
			@NonNull Type valueTemplateArgument = templateArguments.get(1);
			@SuppressWarnings("unchecked") T specializedType = (T) completeModel.getMapType(libraryCompleteClass, TypeUtil.createMapTypeParameters(keyTemplateArgument, true, valueTemplateArgument, true));
			return specializedType;
		}
		else {
			@SuppressWarnings("unchecked")
			T specializedType = (T) libraryCompleteClass.getPartialClasses().getSpecializedType(templateArguments);
			return specializedType;
		}
	}

	public @NonNull Iterable<Constraint> getLocalInvariants(org.eclipse.ocl.pivot.@NonNull Class type) {
		type = PivotUtil.getUnspecializedTemplateableElement(type);
		return new CompleteElementInvariantsIterable(getAllTypes(type));
	}

	public @Nullable EObject getLockingObject() {
		return lockingAnnotation;
	}

	/**
	 * @since 1.6
	 */
	public org.eclipse.ocl.pivot.@NonNull Class getMapType(@NonNull String mapTypeName, @NonNull Type keyType, boolean keysAreNullFree, @NonNull Type valueType, boolean valuesAreNullFree) {
		if (keyType.eIsProxy() || valueType.eIsProxy()) {
			return standardLibrary.getOclInvalidType();
		}
		return completeEnvironment.getMapType(standardLibrary.getRequiredLibraryType(mapTypeName), keyType, keysAreNullFree, valueType, valuesAreNullFree);
	}

	@Deprecated /* @deprected provide null-free arguments */
	public org.eclipse.ocl.pivot.@NonNull Class getMapType(@NonNull String mapTypeName, @NonNull Type keyType, @NonNull Type valueType) {
		return getMapType(mapTypeName, keyType, true, valueType, true);
	}

	/**
	 * @since 1.7
	 */
	public org.eclipse.ocl.pivot.@NonNull Class getMapType(org.eclipse.ocl.pivot.@NonNull Class entryClass) {
		if (entryClass.eIsProxy()) {
			return standardLibrary.getOclInvalidType();
		}
		return completeEnvironment.getMapType(standardLibrary.getMapType(), entryClass);
	}

	public @NonNull Iterable<@NonNull Operation> getMemberOperations(org.eclipse.ocl.pivot.@NonNull Class type, boolean selectStatic) {
		type = PivotUtil.getUnspecializedTemplateableElement(type);
		return new CompleteTypeOperationsIterable(getAllTypes(type), selectStatic);
	}

	public @NonNull Iterable<? extends CompletePackage> getMemberPackages(org.eclipse.ocl.pivot.@NonNull Package pkg) {
		return getCompletePackage(pkg).getOwnedCompletePackages();
	}

	public @NonNull Iterable<@NonNull Property> getMemberProperties(org.eclipse.ocl.pivot.@NonNull Class type, boolean selectStatic) {
		type = PivotUtil.getUnspecializedTemplateableElement(type);
		return new CompleteClassPropertiesIterable(getAllTypes(type), selectStatic);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getMetaclass(@NonNull Type asInstanceType) {
		String metaclassName = TypeUtil.getMetaclassName(asInstanceType);
		return ClassUtil.nonNullState(getASClass(metaclassName));
	}

	public @Nullable Type getOclType(@NonNull String typeName) {
		org.eclipse.ocl.pivot.Class pivotType = getASClass(typeName);
		return pivotType != null ? getInheritance(pivotType).getPivotClass() : null;
	}

	public @NonNull Iterable<? extends Operation> getOperationOverloads(@NonNull Operation pivotOperation) {
		CompleteInheritance pivotClass = pivotOperation.getInheritance(standardLibrary);
		if (pivotClass == null) {
			throw new IllegalStateException("Missing owning type");
		}
		CompleteClass completeClass = completeModel.getCompleteClass(pivotClass.getPivotClass());
		Iterable<? extends Operation> operationOverloads = completeClass.getOperationOverloads(pivotOperation);
		if (operationOverloads != null) {
			return operationOverloads;
		}
		return Collections.singletonList(pivotOperation);
	}

	public @NonNull Iterable<? extends org.eclipse.ocl.pivot.@NonNull Package> getPartialPackages(org.eclipse.ocl.pivot.@NonNull Package pkg, boolean loadASmetamodelFirst) {
		if (!libraryLoadInProgress && loadASmetamodelFirst && (asMetamodel == null)) {
			getASmetamodel();
		}
		CompletePackage completePackage = completeModel.getCompletePackage(pkg);
		return ClassUtil.nullFree(completePackage.getPartialPackages());
	}

	public @NonNull Iterable<org.eclipse.ocl.pivot.Class> getPartialClasses(@NonNull Type pivotType) {
		CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		return completeClass.getPartialClasses();
	}

	/**
	 * @since 1.5
	 */
	@SuppressWarnings("null")
	public @NonNull PrecedenceManager getPrecedenceManager() {
		if (precedenceManager == null) {
			standardLibrary.getOclAnyType();		// Make sure OCL Standard Library has defined operations to be compiled with precedence
			synchronized (this) {
				if (precedenceManager == null) {
					synchronized (this) {
						precedenceManager = createPrecedenceManager();
					}
				}
			}
		}
		return precedenceManager;
	}

	//	public Iterable<? extends Nameable> getPrecedences(org.eclipse.ocl.pivot.Package asPackage) {
	//		return asPackage.getOwnedPrecedence(); // FIXME make package independent
	//	}

	public @Nullable Precedence getPrefixPrecedence(@NonNull String operatorName) {
		PrecedenceManager precedenceManager = getPrecedenceManager();
		return precedenceManager.getPrefixPrecedence(operatorName);
	}

	@SuppressWarnings("unchecked")
	public @NonNull <T extends EObject> T getPrimaryElement(@NonNull T element) {
		if (element instanceof Operation) {
			return (T) getPrimaryOperation((Operation)element);
		}
		else if (element instanceof org.eclipse.ocl.pivot.Package) {
			return (T) getPrimaryPackage((org.eclipse.ocl.pivot.Package)element);
		}
		else if (element instanceof Property) {
			return (T) getPrimaryProperty((Property)element);
		}
		else if (element instanceof Type) {
			return (T) getPrimaryType((Type)element);
		}
		return element;
	}

	@Override
	public @NonNull Operation getPrimaryOperation(@NonNull Operation pivotOperation) {
		CompleteInheritance pivotClass = pivotOperation.getInheritance(standardLibrary);
		if (pivotClass != null) {					// Null for an EAnnotation element
			CompleteClass completeClass = completeModel.getCompleteClass(pivotClass.getPivotClass());
			Operation operation = completeClass.getOperation(pivotOperation);
			if (operation != null) {
				return operation;
			}
		}
		return pivotOperation;
	}

	/**
	 * Lookup a primary package by its URI and optionally a sub-package path.
	 */
	public org.eclipse.ocl.pivot.@Nullable Package getPrimaryPackage(@NonNull String nsURI, String... subPackagePath) {
		CompletePackage completePackage = completeModel.getCompletePackageByURI(nsURI);
		if (completePackage == null) {
			return null;
		}
		if (subPackagePath != null) {
			for (String subPackageName : subPackagePath) {
				if (subPackageName == null) {
					return null;
				}
				completePackage = completePackage.getOwnedCompletePackage(subPackageName);
				if (completePackage == null) {
					return null;
				}
			}
		}
		return completePackage.getPrimaryPackage();
	}

	/**
	 * Lookup a primary sub-package.
	 *
	public @Nullable PackageServer getPrimaryPackage(org.eclipse.ocl.pivot.@NonNull Package parentPackage, @NonNull String subPackageName) {
		PackageTracker packageTracker = packageManager.findPackageTracker(parentPackage);
		if (packageTracker != null) {
			return packageTracker.getPackageServer().getMemberPackage(subPackageName);
		}
		else {
			return PivotUtil.getNamedElement(parentPackage.getNestedPackage(), subPackageName);
		}
	} */

	@Override
	public org.eclipse.ocl.pivot.@NonNull Package getPrimaryPackage(org.eclipse.ocl.pivot.@NonNull Package aPackage) {
		return ClassUtil.nonNullState(getCompletePackage(aPackage).getPrimaryPackage());
	}

	@Override
	public @NonNull Property getPrimaryProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.eContainer() instanceof TupleType) {		// FIXME Find a better way
			return pivotProperty;
		}
		if (pivotProperty.isIsImplicit()) {
			Property opposite = pivotProperty.getOpposite();
			if ((opposite != null) && !opposite.isIsImplicit()) {
				return PivotUtil.getOpposite(getPrimaryProperty(opposite));
			}
		}
		CompleteInheritance owningInheritance = pivotProperty.getInheritance(standardLibrary);
		if (owningInheritance == null) {
			return pivotProperty;
		}
		String name = PivotUtil.getName(pivotProperty);
		CompleteClass completeClass = completeModel.getCompleteClass(owningInheritance.getPivotClass());
		Iterable<@NonNull Property> memberProperties = completeClass.getProperties(pivotProperty.isIsStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC, name);
		if (Iterables.size(memberProperties) <= 1) {					// No ambiguity
			return memberProperties.iterator().next();					// use merged unambiguous result (not necessarily pivotProperty)
		}
		Property opposite = pivotProperty.getOpposite();
		if (opposite == null) {											// No opposite, first one must be ok
			return memberProperties.iterator().next();
		}
		String oppositeName = PivotUtil.getName(opposite);
		CompleteClass oppositeCompleteClass = completeModel.getCompleteClass(PivotUtil.getOwningClass(opposite));
		for (@NonNull Property memberProperty : memberProperties) {
			Property memberOpposite = memberProperty.getOpposite();
			if (memberOpposite != null) {
				if (oppositeName.equals(memberOpposite.getName())) {
					CompleteClass memberOppositeCompleteClass = completeModel.getCompleteClass(PivotUtil.getOwningClass(memberOpposite));
					if (oppositeCompleteClass == memberOppositeCompleteClass) {
						return memberProperty;							// First exact opposite is the primary
					}
				}
			}
		}
		return memberProperties.iterator().next();						// Fallback, first one must be ok
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getPrimaryClass(org.eclipse.ocl.pivot.@NonNull Class type) {
		if (/*(type instanceof Type) &&*/ !isTypeServeable(type)) {
			return type;
		}
		String instanceClassName = type.getInstanceClassName();
		if ((instanceClassName != null) && instanceClassName.equals(java.util.Map.Entry.class.getName())) {		// FIXME a fudge to avoid UML's profile for EStringToStringMapEntry being used
			return type;
		}
		return getCompleteClass(type).getPrimaryClass();
		//		TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
		//		if (typeTracker != null) {
		//			return typeTracker.getPrimaryType();
		//		}
		//		else {
		//			return pivotType;
		//		}
	}

	// FIXME ASBH This should probably disappear
	public @NonNull Type getPrimaryType(@NonNull Type type) {
		if (/*(type instanceof Type) &&*/ !isTypeServeable(type)) {
			return type;			// FIXME bad cast
		}
		return getCompleteClass(type).getPrimaryClass();
		//		TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
		//		if (typeTracker != null) {
		//			return typeTracker.getPrimaryType();
		//		}
		//		else {
		//			return pivotType;
		//		}
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getPrimaryType(@NonNull String nsURI, @NonNull String path, String... extraPath) {
		CompletePackage completePackage = completeModel.getCompletePackageByURI(nsURI);
		if (completePackage == null) {
			return null;
		}
		if ((extraPath == null) || (extraPath.length == 0)) {
			return completePackage.getMemberType(path);
		}
		else {
			completePackage = completePackage.getOwnedCompletePackage(path);
			if (completePackage == null) {
				return null;
			}
			int iMax = extraPath.length-1;
			for (int i = 0; i < iMax; i++) {
				String subPackageName = extraPath[i];
				if (subPackageName == null) {
					return null;
				}
				completePackage = completePackage.getOwnedCompletePackage(subPackageName);
				if (completePackage == null) {
					return null;
				}
			}
			String subPackageName = extraPath[iMax];
			if (subPackageName == null) {
				return null;
			}
			return completePackage.getMemberType(subPackageName);
		}
	}

	public @NonNull ASResource getResource(@NonNull URI uri, @Nullable String contentType) {
		Resource asResource = asResourceSet.getResource(uri, false);
		if (asResource == null) {
			Object asResourceFactory = asResourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().get(contentType);
			if (asResourceFactory == null) {
				throw new IllegalStateException("No registration for content type '" + contentType + "'");
			} else if (!(asResourceFactory instanceof ASResourceFactory)) {
				throw new IllegalStateException("Non ASResourceFactory registration for content type '" + contentType + "'");
			}
			asResource = ((ASResourceFactory)asResourceFactory).createResource(uri);
			assert asResource != null;
			asResourceSet.getResources().add(asResource);
		}
		return (ASResource)asResource;
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull Iterable<@NonNull CompleteClass> getSuperCompleteClasses(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		if (!libraryLoadInProgress && (asMetamodel == null) && (pivotType == standardLibrary.getClassType()))  {
			getASmetamodel();
		}
		CompleteClass completeClass = getCompleteClass(pivotType);
		return getSuperCompleteClasses(completeClass);
	}
	public @NonNull Iterable<@NonNull CompleteClass> getSuperCompleteClasses(@NonNull CompleteClass completeClass) {
		return completeClass.getProperSuperCompleteClasses();
	}

	@Override
	public ResourceSet getTarget() {
		return asResourceSet;
	}

	/**
	 * @since 1.4
	 */
	protected void installLibrary(@NonNull Library asLibrary) {
		if (!asLibraries.contains(asLibrary)) {
			String uri = asLibrary.getURI();
			if (asLibraries.isEmpty()) {
				if (uri == null) {
					throw new IllegalLibraryException(PivotMessagesInternal.MissingLibraryURI_ERROR_);
				}
				if (!standardLibrary.isExplicitDefaultStandardLibraryURI()) {
					for (org.eclipse.ocl.pivot.Class asClass : asLibrary.getOwnedClasses()) {
						if (TypeId.OCL_ANY_NAME.equals(asClass.getName())) {
							standardLibrary.setDefaultStandardLibraryURI(uri);
							break;
						}
					}
				}
			}
			asLibraries.add(asLibrary);
			if (asLibraryResource != null) {
				installLibraryContents(asLibrary);
			}
		}
	}

	/**
	 * Merge all types in asLibrary into the overall Standard Library.
	 */
	protected void installLibraryContents(@NonNull Library asLibrary) {
		List<org.eclipse.ocl.pivot.@NonNull Class> asClasses = null;
		for (org.eclipse.ocl.pivot.Class type : asLibrary.getOwnedClasses()) {
			if (type != null) {
				org.eclipse.ocl.pivot.Class primaryType = getPrimaryClass(type);
				if ((type == primaryType) && !PivotUtilInternal.isOrphanType(type)) {
					if (asClasses == null) {
						asClasses = new ArrayList<>();
					}
					asClasses.add(primaryType);
				}
			}
		}
		if (asClasses != null) {
			standardLibrary.defineLibraryTypes(asClasses);
		}
	}

	/**
	 * Create an implicit opposite property if there is no explicit opposite.
	 */
	public void installPropertyDeclaration(@NonNull Property thisProperty) {
		// We cannot detect ambiguous opposites reliably since a later Property might invalidate previously ok derived opposites
		//		if ((thisProperty.isIsTransient() || thisProperty.isIsVolatile()) && !thisProperty.isIsDerived()) {		// FIXME Are any exclusions justified?
		//			return;
		//		}
		Property opposite = thisProperty.getOpposite();
		if (opposite != null) {
			return;
		}
		Type thatType = thisProperty.getType();
		if (thatType instanceof CollectionType) {
			thatType = ((CollectionType)thatType).getElementType();
		}
		if (thatType == null) {
			return;
		}
		org.eclipse.ocl.pivot.Class thatClass = thatType.isClass();
		if (thatClass == null) {
			TemplateParameter thatTemplateParameter = thatType.isTemplateParameter();
			if (thatTemplateParameter != null) {
				org.eclipse.ocl.pivot.Class lowerBound = PivotUtil.basicGetLowerBound(thatTemplateParameter);
				if (lowerBound != null) {
					thatClass = lowerBound;
				}
			}
		}
		if ((thatClass == null) || (thatClass instanceof DataType)) {
			return;
		}
		org.eclipse.ocl.pivot.Class thisClass = thisProperty.getOwningClass();
		if (thisClass == null) {								// e.g. an EAnnotation
			return;
		}
		String name = thisClass.getName();
		if (name == null) {
			return;
		}
		// If there is no implicit property with the implicit name, create one
		//   result a pair of mutual opposites
		Property newOpposite = PivotFactory.eINSTANCE.createProperty();
		newOpposite.setIsImplicit(true);
		newOpposite.setName(name);
		if (thisProperty.isIsComposite()) {
			newOpposite.setType(thisClass);
			newOpposite.setIsRequired(false);
		}
		else {
			newOpposite.setType(getCollectionType(
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE,
				thisClass, false,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE));
			newOpposite.setIsRequired(true);
		}
		Model thisModel = PivotUtil.getContainingModel(thisClass);
		assert thisModel != null;
		org.eclipse.ocl.pivot.Class thisOppositeClass = getEquivalentClass(thisModel, thatClass);
		thisOppositeClass.getOwnedProperties().add(newOpposite);
		newOpposite.setOpposite(thisProperty);
		thisProperty.setOpposite(newOpposite);
	}

	public void installResource(@NonNull Resource asResource) {
		for (EObject eObject : asResource.getContents()) {
			if (eObject instanceof Model) {
				installRoot((Model)eObject);
			}
		}
		if (!libraryLoadInProgress && (asLibraryResource == null) && (asResource instanceof OCLstdlib) && (asLibraries.size() > 0)) {
			standardLibrary.getOclAnyType();
		}
	}

	@Override
	public void installRoot(@NonNull Model pivotModel) {
		if (completeModel.getPartialModels().contains(pivotModel)) {
			return;
		}
		if (INSTALL_MODEL.isActive()) {
			INSTALL_MODEL.println(NameUtil.debugSimpleName(this) + " " + pivotModel);
		}
		List<org.eclipse.ocl.pivot.Package> ownedPackages = pivotModel.getOwnedPackages();
		List<Import> ownedImports = pivotModel.getOwnedImports();
		if (ownedPackages.isEmpty() && ownedImports.isEmpty()) {
			return;				// Don't install "/* Please wait */" in case we're editing a pivot MM
		}
		completeModel.getPartialModels().add(pivotModel);
		for (org.eclipse.ocl.pivot.Package asPackage : ownedPackages) {
			if (asPackage instanceof Library) {
				installLibrary((Library)asPackage);
			}
		}
		for (Import asImport : ownedImports) {
			Namespace asNamespace = asImport.getImportedNamespace();
			if (asNamespace != null) {
				Model asModel = PivotUtil.getContainingModel(asNamespace);
				if ((asModel != null) && !completeModel.getPartialModels().contains(asModel)) {
					installRoot(asModel);
				}
			}
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == PivotMetamodelManager.class;
	}

	public boolean isLibraryLoadInProgress() {
		return libraryLoadInProgress;
	}

	public boolean isSuperClassOf(org.eclipse.ocl.pivot.@NonNull Class unspecializedFirstType, org.eclipse.ocl.pivot.@NonNull Class secondType) {
		CompleteClass firstCompleteClass = getCompleteClass(unspecializedFirstType);
		CompleteClass secondCompleteClass = getCompleteClass(secondType);
		return isSuperCompleteClassOf(firstCompleteClass, secondCompleteClass);
	}

	public boolean isSuperCompleteClassOf(@NonNull CompleteClass unspecializedFirstType, @NonNull CompleteClass secondType) {
		CompleteClass unspecializedSecondType = getCompleteClass(PivotUtil.getUnspecializedTemplateableElement(secondType.getPrimaryClass()));	// FIXME cast
		//		org.eclipse.ocl.pivot.Class unspecializedSecondType = PivotUtil.getUnspecializedTemplateableElement(secondType);	// FIXME cast
		if (unspecializedFirstType == unspecializedSecondType) {
			return true;
		}
		for (CompleteClass superCompleteClass : getSuperCompleteClasses(unspecializedSecondType)) {
			if (isSuperCompleteClassOf(unspecializedFirstType, superCompleteClass)) {
				return true;
			}
		}
		return false;
	}

	public boolean isTypeServeable(@NonNull Type type) {
		//		if (pivotType .getUnspecializedElement() != null) {
		//			return false;
		//		}
		if (type.isTemplateParameter() != null) {
			return false;
		}
		//		if (pivotType instanceof UnspecifiedType) {
		//			return false;
		//		}
		if (type instanceof LambdaType) {
			return false;
		}
		//		if (pivotType instanceof TupleType) {
		//			return false;
		//		}
		if (type.eContainer() instanceof TemplateParameterSubstitution) {
			return false;
		}
		return true;
	}

	protected boolean isUnspecialized(@NonNull List<TemplateParameter> templateParameters, @NonNull List<? extends Type> templateArguments) {
		int iMax = templateParameters.size();
		assert templateArguments.size() == iMax;
		for (int i = 0; i < iMax; i++) {
			if (templateArguments.get(i) != templateParameters.get(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Load the Pivot Metamodel of the Pivot Model to accompany a given asLibrary.
	 *
	 * If this asLibrary has an Element type it is assumed to be a complete custom meta-model and it is used as such.
	 *
	 * Otherwise the built-in Pivot Metamodel is created with name, nsPrefix and nsURI determined by the given library.
	 *
	 * @param asLibrary
	 */
	protected void loadASmetamodel(org.eclipse.ocl.pivot.@NonNull Package asLibrary) {
		for (org.eclipse.ocl.pivot.@NonNull Package libPackage : getPartialPackages(asLibrary, false)) {
			if (NameUtil.getNameable(libPackage.getOwnedClasses(), PivotPackage.Literals.ELEMENT.getName()) != null) {
				setASmetamodel(libPackage);	// Custom meta-model
				return;
			}
		}
		Model asModel;
		org.eclipse.ocl.pivot.Package asPackage = null;
		if ((asLibraryResource instanceof ASResourceImpl.ImmutableResource) && ((ASResourceImpl.ImmutableResource)asLibraryResource).isCompatibleWith(OCLmetamodel.PIVOT_URI)) {
			asModel = OCLmetamodel.getDefaultModel();
			for (org.eclipse.ocl.pivot.Package asPartialPackage : PivotUtil.getOwnedPackages(asModel))	// Workaround the spurious implicit ecore package (fixed on a wip branch)
			{
				if (!PivotUtilInternal.isImplicitPackage(asPartialPackage)) {
					asPackage = asPartialPackage;
					break;
				}
			}
			if (asPackage == null) {
				asPackage = asModel.getOwnedPackages().get(0);
			}
		}
		else {
			String name = ClassUtil.nonNullState(asLibrary.getName());
			asPackage = OCLmetamodel.create(standardLibrary, name, asLibrary.getNsPrefix(), OCLmetamodel.PIVOT_URI);
			asModel = (Model)asPackage.eContainer();
		}
		Resource asResource = asModel.eResource();
		assert asResource != null;
		asResourceSet.getResources().add(asResource);
		setASmetamodel(asPackage);		// Standard meta-model
		//		asResourceSet.getResources().add(asResource);
		installResource(asResource);
	}

	/**
	 * Load the Standard Library for a given uri. If the uri corresponds to a registered library, that library
	 * is installed, otherwise the already loaded asLibraries are examined and the first library with a matching
	 * URI is used. Return the resource of the library, and merges all types of all libraries into the overall
	 * standard library.
	 */
	public @Nullable Resource loadDefaultLibrary(@Nullable String uri) {
		if (uri == null) {
			return null;
		}
		Resource asLibraryResource2 = asLibraryResource;
		if (asLibraryResource2 != null) {
			return asLibraryResource2;
		}
		boolean savedLibraryLoadInProgress = libraryLoadInProgress;
		libraryLoadInProgress = true;
		try {
			StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(uri);
			if (contribution != null) {
				asLibraryResource = asLibraryResource2 = contribution.getResource();
			}
			else {
				for (@NonNull Library asLibrary : asLibraries) {
					if (uri.equals(asLibrary.getURI())) {
						asLibraryResource = asLibraryResource2 = asLibrary.eResource();
						break;
					}
				}
				if (asLibraryResource2 == null) {
					return null;
				}
			}
			installResource(asLibraryResource2);
			if (!asLibraries.isEmpty()) {
				for (@NonNull Library asLibrary : asLibraries) {
					installLibraryContents(asLibrary);
				}
			}
			return asLibraryResource2;
		}
		finally {
			libraryLoadInProgress = savedLibraryLoadInProgress;
		}
	}

	@Override
	public @Nullable Element loadResource(@NonNull URI uri, String zzalias, @Nullable ResourceSet resourceSet) throws ParserException {
		// FIXME alias not used
		URI resourceURI = uri.trimFragment();
		if (PivotUtilInternal.isASURI(resourceURI)) {
			Element asElement = getASElement(uri);
			if (asElement instanceof Model) {
				for (EObject eObject : ((Model)asElement).getOwnedPackages()) {
					if (eObject instanceof Library) {
						if (asLibraries.isEmpty() && (asLibraryResource == null)) {
							asLibraryResource = asElement.eResource();
							installLibrary((Library)eObject);
						}
					}
				}
			}
			return asElement;
		}
		// if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
		// return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		ResourceSet externalResourceSet = resourceSet != null ? resourceSet : environmentFactory.getResourceSet();
		EPackage.Registry packageRegistry = externalResourceSet.getPackageRegistry();
		String uriString = resourceURI.toString();
		Resource resource = null;
		String fragment = uri.fragment();
		if (fragment == null) {
			//
			//	fragment-less URI may be explicit namespace URI
			//
			EPackage ePackage = packageRegistry.getEPackage(uriString);
			if (ePackage != null) {
				return ((EnvironmentFactoryInternalExtension)environmentFactory).getASOf(Element.class, ePackage);
			}
			//
			//	fragment-less URI may be an OCL Standard Library
			//
			if (uriString.equals(standardLibrary.getDefaultStandardLibraryURI())) {
				if (asLibraryResource != null) {
					resource = asLibraryResource;
				}
				else {
					resource = standardLibrary.loadDefaultLibrary(uriString);
				}
			}
			else {
				StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(uriString);
				if (contribution != null) {
					resource = contribution.getResource();
				}
			}
		}
		else {
			//
			//	fragment-full URI may have a registered package to mark the unfragmented name
			//
			EPackage ePackage = packageRegistry.getEPackage(uriString);
			if (ePackage != null) {
				Resource eResource = ePackage.eResource();
				if (eResource instanceof XMLResource) {
					EObject eObject = ((XMLResource)eResource).getEObject(fragment);
					if (eObject != null) {
						Element asElement = ((EnvironmentFactoryInternalExtension)environmentFactory).getASOf(Element.class, eObject);
						if (asElement != null) {
							return asElement;
						}
					}
				}
			}
		}
		if (resource == null) {
			External2AS external2as = external2asMap.get(resourceURI);
			if (external2as != null) {
				resource = external2as.getResource();
			}
			else {
				//				try {
				resource = externalResourceSet.getResource(resourceURI, true);
				//				}
				//				catch (RuntimeException e) {
				//					resource = externalResourceSet.getResource(resourceURI, false);
				//					if (resource != null) {
				////						externalResourceSet.getResources().remove(resource);
				//						resource = null;
				//					}
				//					throw e;
				//				}
				if (resource != null) {
					for (Resource.Diagnostic diagnostic : resource.getErrors()) {
						if (diagnostic instanceof WrappedException) {
							throw (WrappedException)diagnostic;
						}
					}
				}
				//				if (resource != null) {
				//					if (externalResources == null) {
				//						externalResources = new HashMap<URI, Resource>();
				//					}
				//					externalResources.put(uri, resource);
				//				}
				//
				//	If this resource already loaded under its internal URI reuse old one
				//
				if (resource != null) {
					if (resource instanceof StandaloneProjectMap.DelegatedSinglePackageResource) {
						resource = ((StandaloneProjectMap.DelegatedSinglePackageResource)resource).getResource();
					}
					List<@NonNull EObject> contents = resource.getContents();
					if (contents.size() > 0) {
						EObject firstContent = contents.get(0);
						for (ASResourceFactory resourceFactory : ASResourceFactoryRegistry.INSTANCE.getLoadedResourceFactories()) {
							URI packageURI = resourceFactory.getPackageURI(firstContent);
							if (packageURI != null) {
								External2AS external2as2 = external2asMap.get(packageURI);
								if (external2as2 != null) {
									Resource knownResource = external2as2.getResource();
									if ((knownResource != null) && (knownResource != resource)) {
										for (EObject eContent : resource.getContents()) {
											if (eContent instanceof Pivotable) {
												Element pivot = ((Pivotable)firstContent).getPivot();
												if (pivot instanceof Model) {
													Model root = (Model)pivot;
													completeModel.getPartialModels().remove(root);
													ASResource asResource = (ASResource) root.eResource();
													if (asResource != null) {
														boolean wasUpdating = asResource.setUpdating(true);
														asResourceSet.getResources().remove(asResource);
														asResource.unload();
														asResource.setUpdating(wasUpdating);
													}
												}
											}
										}
										if (!resourceFactory.getASResourceFactory().isCompatibleResource(resource, knownResource)) {
											logger.error("Resource '" + resource.getURI() + "' already loaded as '" + knownResource.getURI() + "'");
										}
										//											resource.unload();
										resource.getResourceSet().getResources().remove(resource);
										resource = knownResource;
									}
								}
								break;
							}
						}
					}
				}
			}
		}
		if (resource != null) {
			return environmentFactory.loadResource(resource, uri);
		}
		logger.warn("Cannot load package with URI '" + uri + "'");
		return null;
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull Operation dynamicOperation) throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		return getImplementation(dynamicOperation);
	}

	@Override
	public void notifyChanged(Notification notification) {}

	/**
	 * Return the compiled query for a specification resolving a String body into a non-null bodyExpression.
	 * Throws a ParserException if conversion fails.
	 *
	 * @deprecated use EnvironmentFactoryInternalExtension.parseSpecification()
	 */
	@Deprecated
	@Override
	public @NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException {
		return ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
	}

	public void removeExternalResource(@NonNull External2AS external2as) {
		external2asMap.remove(external2as.getURI());
	}

	public void removeExternalResource(@NonNull Resource esResource) {
		if (es2ases != null) {
			External2AS es2as = es2ases.remove(esResource);
			if (es2as != null) {
				es2as.dispose();
			}
		}
	}

	/**
	 * @since 1.3
	 */
	@Override
	public void resetFinalAnalysis() {
		finalAnalysis = null;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public void resetFlowAnalysis() {
		oclExpression2flowAnalysis = null;
	}

	public void setASmetamodel(org.eclipse.ocl.pivot.Package asPackage) {
		asMetamodel = asPackage;
		String uri = asMetamodel.getURI();
		if (uri != null) {
			completeModel.addPackageURI2completeURI(uri, PivotConstants.METAMODEL_NAME);
		}
	}

	public void setAutoLoadASmetamodel(boolean autoLoadASmetamodel) {
		this.autoLoadASmetamodel  = autoLoadASmetamodel;
	}

	public void setLibraryLoadInProgress(boolean libraryLoadInProgress) {
		this.libraryLoadInProgress = libraryLoadInProgress;
	}

	public void setMetamodelNsURI(@NonNull String metaNsURI) {
		if (asMetamodel == null) {
			//			if (StandardLibraryContribution.REGISTRY.get(metaNsURI) == null) {
			//				StandardLibraryContribution.REGISTRY.put(metaNsURI, new OCLstdlib.Loader());
			//			}
			//			setDefaultStandardLibraryURI(metaNsURI);
			getASmetamodel();
		}
		else if (!metaNsURI.equals(asMetamodel.getURI())) {
			completeModel.addPackageURI2completeURI(metaNsURI, PivotConstants.METAMODEL_NAME);
			//			throw new IllegalMetamodelException(asMetamodel.getNsURI(), metaNsURI);
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		//		assert newTarget == asResourceSet;
	}

	/**
	 * Return the specialized form of type analyzing expr to determine the formal to actual parameter mappings
	 * using selfType as the value of OclSelf.
	 */
	public @NonNull Type specializeType(@NonNull Type type, @NonNull CallExp callExp, @NonNull Type selfType, @Nullable Type selfTypeValue) {
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
		return TemplateParameterSubstitutionVisitor.specializeType(type, callExp, environmentFactory, selfType, null);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		//		assert oldTarget == asResourceSet;
	}
}
