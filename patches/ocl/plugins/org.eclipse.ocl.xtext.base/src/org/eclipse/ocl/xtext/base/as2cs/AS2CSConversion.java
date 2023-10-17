/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.as2cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.pivot.internal.utilities.AbstractConversion;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS.Factory;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;

import com.google.common.collect.Iterables;

public class AS2CSConversion extends AbstractConversion implements PivotConstantsInternal
{
	private static final Logger logger = LogManager.getLogger(AS2CSConversion.class);

	protected final @NonNull AS2CS converter;
	protected final @NonNull BaseDeclarationVisitor defaultDeclarationVisitor;
	protected final @NonNull BaseReferenceVisitor defaultExpressionVisitor;
	protected final @NonNull BaseReferenceVisitor defaultReferenceVisitor;

	private org.eclipse.ocl.pivot.Class scope = null;

	private final @NonNull Map<@NonNull EClass, @NonNull BaseDeclarationVisitor> declarationVisitorMap = new HashMap<>();
	private final @NonNull Map<EClass, BaseReferenceVisitor> expressionVisitorMap = new HashMap<>();
	private final @NonNull Map<@NonNull EClass, @NonNull BaseReferenceVisitor> referenceVisitorMap = new HashMap<>();
	private Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces = null;

	/**
	 * The CS Resource currently being converted.
	 */
	private @Nullable BaseCSResource csResource = null;;

	public AS2CSConversion(@NonNull AS2CS converter) {
		super(converter.getEnvironmentFactory());
		this.converter = converter;
		this.defaultDeclarationVisitor = converter.createDefaultDeclarationVisitor(this);
		this.defaultExpressionVisitor = converter.createDefaultExpressionVisitor(this);
		this.defaultReferenceVisitor = converter.createDefaultReferenceVisitor(this);
	}

	protected void addBooleanQualifier(@NonNull List<@NonNull String> qualifiers, @NonNull DetailCS csDetail, @NonNull String csString) {
		EList<String> values = csDetail.getValues();
		if ((values.size() == 1) && Boolean.valueOf(values.get(0))) {
			qualifiers.add(csString);
		}
		else {
			qualifiers.add("!" + csString);
		}
	}

	public void createImports(@NonNull RootCS documentCS, @NonNull Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces) {
		BaseCSResource csResource = (BaseCSResource) ClassUtil.nonNullState(documentCS.eResource());
		AliasAnalysis.dispose(csResource);			// Force reanalysis
		EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
		if (environmentFactory == null) {
			throw new IllegalStateException("No EnvironmentFactory");
		}
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		AliasAnalysis aliasAnalysis = null;
		URI csURI = csResource.getURI();
		List<@NonNull ImportCS> imports = new ArrayList<>();
		List<@NonNull Namespace> sortedImportedNamespaces = new ArrayList<>(importedNamespaces.keySet());
		Collections.sort(sortedImportedNamespaces, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Namespace importedNamespace : sortedImportedNamespaces) {
			if (importedNamespace instanceof org.eclipse.ocl.pivot.Package){
				Package pivotPackage = metamodelManager.getCompletePackage((org.eclipse.ocl.pivot.Package)importedNamespace).getPrimaryPackage();
				//			ModelElementCS csElement = createMap.get(importedPackage);
				//			if ((csElement != null) && (csElement.eResource() == xtextResource)) {
				//				continue;		// Don't import defined packages
				//			}
				if (metamodelManager.getLibraries().contains(pivotPackage)) {
					continue;
				}
			}
			List<@NonNull String> aliases = importedNamespaces.get(importedNamespace);
			if ((aliases == null) || aliases.isEmpty()) {
				if (aliasAnalysis == null) {
					aliasAnalysis = AliasAnalysis.getAdapter(csResource, environmentFactory);
				}
				String alias = aliasAnalysis.getAlias(importedNamespace, null);
				aliases = alias != null ? Collections.singletonList(alias) : Collections.emptyList();
			}
			EObject eObject = importedNamespace.getESObject();
			String importURI = null;
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage)eObject;
				Resource resource = ePackage.eResource();
				if (ClassUtil.isRegistered(resource)) {
					importURI = ePackage.getNsURI();
				}
			}
			if (importURI == null) {
				URI fullURI = EcoreUtil.getURI(eObject != null ? eObject : importedNamespace);
				URI deresolvedURI = URIUtil.deresolve(fullURI, csURI, true, true, false);
				importURI = deresolvedURI.toString();
			}
			for (@NonNull String alias : aliases) {
				ImportCS importCS = BaseCSFactory.eINSTANCE.createImportCS();
				importCS.setName(alias);
				PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
				importCS.setOwnedPathName(csPathName);
				List<PathElementCS> csPath = csPathName.getOwnedPathElements();
				PathElementWithURICS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementWithURICS();
				csPath.add(csSimpleRef);
				csSimpleRef.setReferredElement(importedNamespace);
				csSimpleRef.setUri(importURI);
				importCS.setPivot(importedNamespace);
				imports.add(importCS);
			}
		}
		if (aliasAnalysis != null) {
			aliasAnalysis.dispose();
		}
		aliasAnalysis = AliasAnalysis.getAdapter(csResource, metamodelManager.getEnvironmentFactory());
		for (@NonNull ImportCS csImport : imports) {
			Namespace namespace = csImport.getReferredNamespace();
			String alias = csImport.getName();
			if ((namespace != null) && (alias == null)) {
				alias = aliasAnalysis.getAlias(namespace, null);
				if (alias == null) {
					String hint = null;
					if (namespace instanceof org.eclipse.ocl.pivot.Package) {
						hint = ((org.eclipse.ocl.pivot.Package)namespace).getNsPrefix();
					}
					if (hint == null) {
						String name = namespace.getName();
						if (name.length() > 0) {
							hint = name.substring(0, 1).toLowerCase() + name.substring(1);
						}
					}
					if (hint != null) {
						alias = aliasAnalysis.getAlias(namespace, hint);
					}
				}
				if (alias != null) {
					csImport.setName(alias);
				}
			}
		}
		Collections.sort(imports, new Comparator<@NonNull ImportCS>()
		{
			@Override
			public int compare(@NonNull ImportCS o1, @NonNull ImportCS o2) {
				Namespace ns1 = o1.getReferredNamespace();
				Namespace ns2 = o2.getReferredNamespace();
				int d1 = PivotUtil.getContainmentDepth(ns1);
				int d2 = PivotUtil.getContainmentDepth(ns2);
				if (d1 != d2) {
					return d1 - d2;
				}
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		for (@NonNull ImportCS csImport : imports) {
			String alias = csImport.getName();
			if (alias.length() == 0) {
				csImport.setName(null);
			}
		}
		documentCS.getOwnedImports().addAll(imports);
	}

	public @NonNull MultiplicityCS createMultiplicityCS(int lower, int upper, boolean isNullFree) {
		String stringValue = null;
		if (lower == 0) {
			if (upper == 1) {
				stringValue = "?";
			}
			else if (upper == -1) {
				stringValue = "*";
			}
			//			else if (upper == -2) {
			//				stringValue = "0..?";
			//			}
		}
		else if (lower == 1) {
			if (upper == -1) {
				stringValue = "+";
			}
		}
		MultiplicityCS csMultiplicity;
		if (stringValue != null) {
			MultiplicityStringCS csMultiplicityString = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
			csMultiplicityString.setStringBounds(stringValue);
			csMultiplicity = csMultiplicityString;
		}
		else {
			MultiplicityBoundsCS csMultiplicityBounds = BaseCSFactory.eINSTANCE.createMultiplicityBoundsCS();
			if (lower != 1) {
				csMultiplicityBounds.setLowerBound(lower);
			}
			if (upper != lower) {
				csMultiplicityBounds.setUpperBound(upper);
			}
			csMultiplicity = csMultiplicityBounds;
		}
		csMultiplicity.setIsNullFree(isNullFree);
		return csMultiplicity;
	}

	public @Nullable BaseCSResource getCSResource() {
		return csResource;
	}

	public @NonNull AS2CS getConverter() {
		return converter;
	}

	public @Nullable BaseDeclarationVisitor getDeclarationVisitor(@NonNull EClass eClass) {
		BaseDeclarationVisitor declarationVisitor = declarationVisitorMap.get(eClass);
		if ((declarationVisitor == null) && !declarationVisitorMap.containsKey(eClass)) {
			Factory factory = converter.getFactory(eClass);
			if (factory != null) {
				declarationVisitor = factory.createDeclarationVisitor(this);
			}
			else {
				declarationVisitor = defaultDeclarationVisitor;
			}
			declarationVisitorMap.put(eClass, declarationVisitor);
		}
		return declarationVisitor;
	}

	public @Nullable BaseReferenceVisitor getExpressionVisitor(@NonNull EClass eClass, @Nullable Namespace scope) {
		if (scope == null) {
			BaseReferenceVisitor expressionVisitor = expressionVisitorMap.get(eClass);
			if ((expressionVisitor == null) && !expressionVisitorMap.containsKey(eClass)) {
				Factory factory = converter.getFactory(eClass);
				if (factory != null) {
					expressionVisitor = factory.createExpressionVisitor(this, null);
				}
				else {
					expressionVisitor = defaultExpressionVisitor;
				}
				expressionVisitorMap.put(eClass, expressionVisitor);
			}
			return expressionVisitor;
		}
		else {
			Factory factory = converter.getFactory(eClass);
			if (factory != null) {
				return factory.createExpressionVisitor(this, scope);
			}
			else {
				return defaultExpressionVisitor;
			}
		}
	}

	/**
	 * Return the qualifying NamedElement path from global to element (inclusive if a NamedElement).
	 */
	private @NonNull List<@NonNull NamedElement> getPath(@NonNull Element element) {
		List<@NonNull NamedElement> path = new ArrayList<>();
		for (EObject eContainer = element/*.eContainer()*/; eContainer instanceof Element; eContainer = eContainer.eContainer()) {
			eContainer = metamodelManager.getPrimaryElement(eContainer);
			if (eContainer instanceof Model) {
				break;				// Skip root Model
			}
			if ((eContainer instanceof org.eclipse.ocl.pivot.Package) && Orphanage.isTypeOrphanage((org.eclipse.ocl.pivot.Package)eContainer)) {
				break;				// Skip orphan package
			}
			if (eContainer instanceof TemplateSignature) {
				continue;			// Skip signature
			}
			if (eContainer instanceof NamedElement) {
				path.add(0, (NamedElement)eContainer);
			}
		}
		return path;
	}

	public @NonNull PrecedenceManager getPrecedenceManager() {
		return metamodelManager.getPrecedenceManager();
	}

	public @Nullable BaseReferenceVisitor getReferenceVisitor(@NonNull EClass eClass, @Nullable Namespace scope) {
		if (scope == null) {
			BaseReferenceVisitor referenceVisitor = referenceVisitorMap.get(eClass);
			if ((referenceVisitor == null) && !referenceVisitorMap.containsKey(eClass)) {
				Factory factory = converter.getFactory(eClass);
				if (factory != null) {
					referenceVisitor = factory.createReferenceVisitor(this, null);
				}
				else {
					referenceVisitor = defaultReferenceVisitor;
				}
				referenceVisitorMap.put(eClass, referenceVisitor);
			}
			return referenceVisitor;
		}
		else {
			Factory factory = converter.getFactory(eClass);
			if (factory != null) {
				return factory.createReferenceVisitor(this, scope);
			}
			else {
				return defaultReferenceVisitor;
			}
		}
	}

	public org.eclipse.ocl.pivot.Class getScope() {
		return scope;
	}

	protected @NonNull List<@NonNull TemplateBindingCS> getTemplateBindings(ElementCS csElement) {
		List<@NonNull TemplateBindingCS> csTemplateBindings;
		//		EObject container = csElement.eContainer();
		//		if (container instanceof ElementCS) {
		//			csTemplateBindings = getTemplateBindings((ElementCS) container);
		//		}
		//		else {
		csTemplateBindings = new ArrayList<>();
		//		}
		if (csElement instanceof TypedTypeRefCS) {
			TypedTypeRefCS csTemplateableElement = (TypedTypeRefCS)csElement;
			TemplateBindingCS csTemplateBinding = csTemplateableElement.getOwnedBinding();
			if (csTemplateBinding != null) {
				csTemplateBindings.add(csTemplateBinding);
			}
		}
		return csTemplateBindings;
	}

	public void importNamespace(@NonNull Namespace importNamespace, @Nullable String alias) {
		Namespace primaryNamespace = metamodelManager.getPrimaryElement(importNamespace);
		List<@NonNull String> aliases = importedNamespaces.get(primaryNamespace);
		if (aliases == null) {
			aliases = new ArrayList<>();
			importedNamespaces.put(primaryNamespace, aliases);
		}
		if ((alias != null) && !aliases.contains(alias)) {
			aliases.add(alias);
		}
	}

	protected <@NonNull T extends ClassCS> T refreshClassifier(@NonNull Class<T> csClass, /*@NonNull*/ EClass csEClass, org.eclipse.ocl.pivot.@NonNull Class object) {
		T csElement = refreshNamedElement(csClass, csEClass, object);
		List<@NonNull ConstraintCS> csInvariants = visitDeclarations(ConstraintCS.class, object.getOwnedInvariants(), null);
		for (@NonNull ConstraintCS csInvariant : csInvariants) {
			csInvariant.setStereotype(PivotConstants.INVARIANT_NAME);
		}
		refreshList(csElement.getOwnedConstraints(), csInvariants);
		TemplateSignature ownedTemplateSignature = object.getOwnedSignature();
		if (ownedTemplateSignature != null) {
			csElement.setOwnedSignature(visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		}
		if (object.eIsSet(PivotPackage.Literals.CLASS__INSTANCE_CLASS_NAME)) {
			csElement.setInstanceClassName(object.getInstanceClassName());
		}
		else {
			csElement.eUnset(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME);
		}
		return csElement;
	}

	public <@NonNull T extends ModelElementCS> T refreshElement(@NonNull Class<T> csClass, /*@NonNull*/ EClass csEClass, @NonNull Element object) {
		assert csClass == csEClass.getInstanceClass();
		EFactory eFactoryInstance = csEClass.getEPackage().getEFactoryInstance();
		ModelElementCS csElement = (ModelElementCS) eFactoryInstance.create(csEClass);
		if (!csClass.isAssignableFrom(csElement.getClass())) {
			throw new ClassCastException();
		}
		csElement.setPivot(object);
		@SuppressWarnings("unchecked")
		T castElement = (T) csElement;
		return castElement;
	}

	public <@NonNull T extends NamedElementCS> T refreshNamedElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull NamedElement object) {
		return refreshNamedElement(csClass, csEClass, object, "«null»");
	}

	public <@NonNull T extends NamedElementCS> T refreshNamedElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull NamedElement object, @Nullable String replacementNameForNull) {
		T csElement = refreshElement(csClass, csEClass, object);
		String name = object.getName();
		if (name == null) {
			name = replacementNameForNull;
		}
		csElement.setName(name);
		refreshList(csElement.getOwnedAnnotations(), visitDeclarations(AnnotationCS.class, object.getOwnedAnnotations(), null));
		return csElement;
	}

	/**
	 * Assign a sequence of one or more path elements to csPathName that identify element with respect
	 * to scope.
	 * <br>
	 * For example A::B::C::D::E with respect to A::B::C::X::Y is D::E.
	 * <br>
	 * Validation is performed to check that the shortened name resolves to the same
	 * element.
	 * <br>
	 * For example if there is also an A::B::C::X::D::E, the scope is shortened to A::B so
	 * that the result is C::D::E.
	 */
	public void refreshPathName(@NonNull PathNameCS csPathName, @NonNull Element element, @Nullable Namespace scope) {//, @Nullable Resource csResource) {
		boolean hasFinalTarget = false;
		List<PathElementCS> csPath = csPathName.getOwnedPathElements();
		csPath.clear();		// FIXME re-use
		Element primaryElement = metamodelManager.getPrimaryElement(element);
		BaseCSResource csResource2 = this.csResource;
		if ((csResource2 != null) && (csResource2.isPathable(primaryElement) != null)) {
			List<@NonNull NamedElement> targetPath = getPath(element);
			int iTargetStart = 0;
			int iTargetSize = targetPath.size();
			if ((scope != null) && (0 < iTargetSize)) {
				List<@NonNull NamedElement> scopePath = getPath(scope);
				int iScopeSize = scopePath.size();
				int iMax = Math.min(iTargetSize, iScopeSize);
				//
				//	Necessary outer qualification, keep the common element of target and scope Path
				//
				for ( ; iTargetStart < iMax; iTargetStart++) {
					NamedElement targetChildElement = targetPath.get(iTargetStart);
					NamedElement scopeChildElement = scopePath.get(iTargetStart);
					if (targetChildElement != scopeChildElement) {
						break;
					}
				}
				//
				//	Redundant inner qualification no alternative resolutions for first qualifier.
				//
				if ((0 < iTargetStart) && (iTargetStart < iTargetSize)) {
					String targetName = targetPath.get(iTargetStart).getName(); //((NamedElement)primaryElement).getName();
					boolean noAlternatives = true;
					for (int i = iTargetStart; i < iScopeSize-1; i++) {
						NamedElement intermediateScopeElement = scopePath.get(i);
						if (intermediateScopeElement instanceof org.eclipse.ocl.pivot.Package) {
							CompletePackage completePackage = metamodelManager.getCompletePackage((org.eclipse.ocl.pivot.Package)intermediateScopeElement);
							CompletePackage memberPackage = completePackage.getOwnedCompletePackage(targetName);
							if (memberPackage != null) {
								noAlternatives = false;
								break;
							}
							org.eclipse.ocl.pivot.Class memberClass = completePackage.getMemberType(targetName);
							if (memberClass  != null) {
								noAlternatives = false;
								break;
							}
						}
						else if (intermediateScopeElement instanceof org.eclipse.ocl.pivot.Class) {
							CompleteClass completeClass = metamodelManager.getCompleteClass((org.eclipse.ocl.pivot.Class)intermediateScopeElement);
							Iterable<@NonNull Property> memberProperties = completeClass.getProperties((Property)primaryElement);
							if ((memberProperties != null) && !Iterables.isEmpty(memberProperties)) {
								noAlternatives = false;
								break;
							}
							Iterable<@NonNull Operation> memberOperations = completeClass.getOperations(null, targetName);
							assert memberOperations != null;
							if (!Iterables.isEmpty(memberOperations)) {
								noAlternatives = false;
								break;
							}
						}
					}
					if (!noAlternatives) {
						iTargetStart = iTargetStart-1;
					}
				}
			}
			//
			//	Refresh with targetPath[iTargetStart...iTargetSize]
			//
			for (int i = iTargetStart; i < iTargetSize; i++) {
				PathElementCS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementCS();
				NamedElement pathElement = targetPath.get(i);
				csSimpleRef.setReferredElement(pathElement);
				csPath.add(csSimpleRef);
				if (pathElement == primaryElement) {
					hasFinalTarget = true;
					assert (i+1) == iTargetSize;
					break;
				}
			}
		}
		if (!hasFinalTarget) {
			PathElementCS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementCS();
			csSimpleRef.setReferredElement(primaryElement);
			csPath.add(csSimpleRef);
		}
	}

	public void refreshQualifiers(List<String> qualifiers, String string, boolean polarity) {
		for (String qualifier : qualifiers) {
			if (qualifier.equals(string)) {
				if (!polarity) {
					qualifiers.remove(qualifier);
				}
				return;
			}
		}
		if (polarity) {
			qualifiers.add(string);
		}
	}

	public void refreshQualifiers(@NonNull List<@NonNull String> qualifiers, @NonNull String trueString, @NonNull String falseString, @Nullable Boolean polarity) {
		boolean isFalse = false;
		boolean isTrue = false;
		for (String qualifier : qualifiers) {
			if (qualifier.equals(trueString)) {
				if (isTrue || (polarity != Boolean.TRUE)) {
					qualifiers.remove(qualifier);
				}
				isTrue = true;
			}
			if (qualifier.equals(falseString)) {
				if (isTrue || (polarity != Boolean.FALSE)) {
					qualifiers.remove(qualifier);
				}
				isFalse = true;
			}
		}
		if (polarity == Boolean.TRUE) {
			if (!isTrue) {
				qualifiers.add(trueString);
			}
		}
		else if (polarity == Boolean.FALSE) {
			if (!isFalse) {
				qualifiers.add(falseString);
			}
		}
	}

	// FIXME BUG 496148 this is biased to use of e.g. {ordered} for OCLinEcore
	public <@NonNull T extends StructuralFeatureCS> T refreshStructuralFeature(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull Property object) {
		T csElement = refreshTypedElement(csClass, csEClass, object);
		refreshQualifiers(csElement.getQualifiers(), "derived", object.isIsDerived());
		refreshQualifiers(csElement.getQualifiers(), "readonly", object.isIsReadOnly());
		refreshQualifiers(csElement.getQualifiers(), "static", object.isIsStatic());
		refreshQualifiers(csElement.getQualifiers(), "transient", object.isIsTransient());
		refreshQualifiers(csElement.getQualifiers(), "unsettable", object.isIsUnsettable());
		refreshQualifiers(csElement.getQualifiers(), "volatile", object.isIsVolatile());
		csElement.setDefault(object.getDefaultValueString());
		return csElement;
	}

	// FIXME BUG 496148 this is biased to use of e.g. {ordered} for OCLinEcore
	public <@NonNull T extends TypedElementCS> T refreshTypedElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull TypedElement object) {
		T csElement = refreshNamedElement(csClass, csEClass, object);
		final Type type = object.getType();
		final Type elementType;
		boolean isEMap = (type instanceof MapType) && (((MapType)type).getEntryClass() != null);
		if (isEMap) {
			elementType = ((MapType)type).getEntryClass();
		}
		else if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != standardLibrary.getCollectionType())) {
			PivotUtil.debugWellContainedness(type);
			elementType = ((CollectionType)type).getElementType();
		}
		else if (type instanceof VoidType) {
			elementType = null;
		}
		else {
			elementType = type;
		}
		if (elementType != null) {
			PivotUtil.debugWellContainedness(elementType);
			TypedRefCS typeRef = visitReference(TypedRefCS.class, elementType, null);
			csElement.setOwnedType(typeRef);
		}
		else {
			csElement.setOwnedType(null);
		}
		TypedRefCS csTypeRef = csElement.getOwnedType();
		if (csTypeRef != null) {
			boolean isNullFree ;
			int lower;
			int upper;
			if (isEMap) {
				isNullFree = true;
				lower = object.isIsRequired() ? 1 : 0;
				upper = -1;
				List<@NonNull String> qualifiers = ClassUtil.nullFree(csElement.getQualifiers());
				//	refreshQualifiers(qualifiers, "composes", object.isIsComposite());
				refreshQualifiers(qualifiers, "ordered", "!ordered", Boolean.TRUE);		// sic; Ecore idiom
				refreshQualifiers(qualifiers, "unique", "!unique", Boolean.TRUE);
			}
			else if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != standardLibrary.getCollectionType())) {
				CollectionType collectionType = (CollectionType)type;
				isNullFree = collectionType.isIsNullFree();
				lower = collectionType.getLower().intValue();
				Number upper2 = collectionType.getUpper();
				upper = upper2 instanceof Unlimited ? -1 : upper2.intValue();
				List<@NonNull String> qualifiers = ClassUtil.nullFree(csElement.getQualifiers());
				refreshQualifiers(qualifiers, "ordered", "!ordered", collectionType.isOrdered() ? Boolean.TRUE : null);
				refreshQualifiers(qualifiers, "unique", "!unique", collectionType.isUnique() ? null : Boolean.FALSE);
			}
			else {
				isNullFree = false;
				lower = object.isIsRequired() ? 1 : 0;
				upper = 1;
			}
			MultiplicityCS csMultiplicity = createMultiplicityCS(lower, upper, isNullFree);
			csTypeRef.setOwnedMultiplicity(csMultiplicity);
		}
		return csElement;
	}

	public org.eclipse.ocl.pivot.Class setScope(org.eclipse.ocl.pivot.Class object) {
		org.eclipse.ocl.pivot.Class savedScope = scope;
		this.scope = object;
		return savedScope;
	}

	/**
	 * Sequence the update passes to make the pivot match the CS.
	 */
	public void update(@NonNull BaseCSResource csResource) {
		this.csResource = csResource;
		//		Map<Resource, Map<Namespace, List<String>>> imports = new HashMap<Resource, Map<Namespace, List<String>>>();
		//
		//	Perform the pre-order traversal to create the CS for each declaration. A
		//	separate reference pass is not needed since references are to the pivot model.
		//
		importedNamespaces = new HashMap<>();
		Resource asResource = converter.getASResource(csResource);
		if (asResource != null) {
			List<@NonNull PackageCS> list = visitDeclarations(PackageCS.class, asResource.getContents(), null);
			refreshList(csResource.getContents(), list);
			if (importedNamespaces != null) {
				defaultDeclarationVisitor.postProcess(csResource, importedNamespaces);
			}
			//			imports.put(csResource, importedNamespaces);
		}
	}

	public <T extends ElementCS> @Nullable T visitDeclaration(@NonNull Class<T> csClass, @Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		@SuppressWarnings("null") @NonNull EClass eClass = eObject.eClass();
		BaseDeclarationVisitor declarationVisitor = getDeclarationVisitor(eClass);
		if ((declarationVisitor == null) || !(eObject instanceof Visitable)) {
			logger.warn("Unsupported declaration " + eClass.getName());
			return null;
		}
		ElementCS csElement = ((Visitable)eObject).accept(declarationVisitor);
		@SuppressWarnings("unchecked")
		T castElement = (T) csElement;
		return castElement;
	}

	public <T extends ElementCS, @Nullable  V extends EObject> @Nullable List<@NonNull T> visitDeclarationAsList(@NonNull Class<T> csClass, V eObject) {
		if (eObject == null) {
			return null;
		}
		@Nullable T csElement = visitDeclaration(csClass, eObject);
		if (csElement == null) {
			return null;
		}
		return Collections.singletonList(csElement);
	}

	public @NonNull <T extends ElementCS, V extends EObject> List<T> visitDeclarations(@NonNull Class<T> csClass, /*@NonNull*/ Iterable<V> eObjects, AS2CS.@Nullable Predicate<V> predicate) {
		assert eObjects != null;
		List<T> csElements = new ArrayList<>();
		for (V eObject : eObjects) {
			if ((eObject != null) && ((predicate == null) || predicate.filter(eObject))) {
				@Nullable T csElement = visitDeclaration(csClass, eObject);
				if (csElement != null) {
					csElements.add(csElement);
				}
			}
		}
		return csElements;
	}

	public @Nullable <T extends ElementCS> T visitReference(@NonNull Class<T> csClass, @NonNull EObject eObject, @Nullable Namespace scope) {
		@SuppressWarnings("null") @NonNull EClass eClass = eObject.eClass();
		BaseReferenceVisitor referenceVisitor = getReferenceVisitor(eClass, scope);
		if ((referenceVisitor == null) || !(eObject instanceof Visitable)) {
			logger.warn("Unsupported reference " + eObject.eClass().getName());
			return null;
		}
		if (eObject.eIsProxy()) {
			logger.warn("Unresolved reference " + ((BasicEObjectImpl)eObject).eProxyURI());
			return null;
		}
		ElementCS csElement = ((Visitable)eObject).accept(referenceVisitor);
		if (csElement == null) {
			return null;
		}
		if (!csClass.isAssignableFrom(csElement.getClass())) {
			logger.error("CS " + csElement.getClass().getName() + "' element is not a '" + csClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) csElement;
		return castElement;
	}

	public @NonNull <T extends ElementCS, V extends EObject> List<T> visitReferences(@NonNull Class<T> csClass, /*@NonNull*/ Iterable<? extends V> eObjects, AS2CS.@Nullable Predicate<V> predicate) {
		assert eObjects != null;
		List<T> csElements = new ArrayList<>();
		for (V eObject : eObjects) {
			if ((eObject != null) && ((predicate == null) || predicate.filter(eObject))) {
				@Nullable T csElement = visitReference(csClass, eObject, null);
				if (csElement != null) {
					csElements.add(csElement);
				}
			}
		}
		return csElements;
	}
}
