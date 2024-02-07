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
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.context.AbstractBase2ASConversion;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.options.PivotValidationOptions;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MorePivotable;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.xtext.base.cs2as.BaseCSPreOrderVisitor.OperatorExpContinuation;
import org.eclipse.ocl.xtext.base.cs2as.BaseCSPreOrderVisitor.TemplateSignatureContinuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.AnnotationElementCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.common.collect.Iterables;

public class CS2ASConversion extends AbstractBase2ASConversion
{
	private static final Logger logger = LogManager.getLogger(CS2ASConversion.class);
	public static final @NonNull TracingOption CONTINUATION = new TracingOption("org.eclipse.ocl.xtext.base", "continuation");  //$NON-NLS-1$//$NON-NLS-2$

	public static class CacheKey<T>
	{
		protected final @NonNull String name;

		public CacheKey(@NonNull String name) {
			this.name = name;
		}

		@Override
		public String toString() { return name; }
	}

	protected final @NonNull CS2AS converter;

	/**
	 * The Visitors
	 */
	private final @NonNull BaseCSVisitor<Continuation<?>> containmentVisitor;
	private final @NonNull BaseCSVisitor<Element> left2RightVisitor;
	private final @NonNull BaseCSVisitor<Continuation<?>> postOrderVisitor;
	private final @NonNull BaseCSVisitor<Continuation<?>> preOrderVisitor;

	private @NonNull InterDependency<@NonNull TemplateSignatureContinuation> typesHaveSignatures = new InterDependency<>("All unspecialized signatures defined", null);

	private @NonNull InterDependency<@NonNull OperatorExpContinuation<?>> operatorsHavePrecedence = new InterDependency<>("All operator precedences defined", null);

	/**
	 * A typed cache for use by derived conversions.
	 */
	private final @NonNull Map<CacheKey<?>, Object> intermediateCache = new HashMap<CacheKey<?>, Object>();

	private Map<String, org.eclipse.ocl.pivot.Package> oldPackagesByName = null;
	private Map<String, org.eclipse.ocl.pivot.Package> oldPackagesByQualifiedName = null;	// WIP lose this since using nsURIs

	/**
	 * The handler for any generated diagnostics. If null (which is deprecated) diagnostics are inserted
	 * directly into the resource errors list.
	 */
	@SuppressWarnings("unused")
	private final IDiagnosticConsumer diagnosticsConsumer;

	private boolean hasFailed = false;
	private boolean optionalDefaultMultiplicity;

	public CS2ASConversion(@NonNull CS2AS converter, @NonNull IDiagnosticConsumer diagnosticsConsumer) {
		super(converter.getEnvironmentFactory());
		this.converter = converter;
		this.diagnosticsConsumer = diagnosticsConsumer;
		this.containmentVisitor = converter.createContainmentVisitor(this);
		this.left2RightVisitor = converter.createLeft2RightVisitor(this);
		this.postOrderVisitor = converter.createPostOrderVisitor(this);
		this.preOrderVisitor = converter.createPreOrderVisitor(this);
		this.optionalDefaultMultiplicity = environmentFactory.getValue(PivotValidationOptions.OptionalDefaultMultiplicity) == Boolean.TRUE;

	}

	public @NonNull OCLExpression addBadExpressionError(@NonNull ModelElementCS csElement, /*@NonNull*/ String message, Object... bindings) {
		String boundMessage = NLS.bind(message, bindings);
		INode node = NodeModelUtils.getNode(csElement);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, boundMessage);
		csElement.eResource().getErrors().add(resourceDiagnostic);
		InvalidLiteralExp invalidLiteralExp = metamodelManager.createInvalidExpression();
		csElement.setPivot(invalidLiteralExp);
		return invalidLiteralExp;
	}

	@Deprecated /* @deprecated use addError */
	public void addDiagnostic(@NonNull ModelElementCS csElement, @NonNull Diagnostic diagnostic) {
		addError(csElement, diagnostic.getMessage());
	}

	@Deprecated /* @deprecated use addError */
	public void addDiagnostic(@NonNull ElementCS csElement, @NonNull String boundMessage) {
		addError(csElement, boundMessage);
	}

	public void addError(@NonNull ElementCS csElement, /*@NonNull*/ String message, Object... bindings) {
		INode node = NodeModelUtils.getNode(csElement);
		addError(csElement, node, message, bindings);
	}

	public void addError(@NonNull ElementCS csElement, /*@NonNull*/ INode node, /*@NonNull*/ String message, Object... bindings) {
		String boundMessage = NLS.bind(message, bindings);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, boundMessage);
		csElement.eResource().getErrors().add(resourceDiagnostic);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ocl.xtext.base.cs2as.DiagnosticHandler#addWarning(org.eclipse.ocl.xtext.basecs.ModelElementCS, java.lang.String, java.lang.Object)
	 */
	public void addWarning(@NonNull ModelElementCS csElement, /*@NonNull*/ String message, Object... bindings) {
		INode node = NodeModelUtils.getNode(csElement);
		addWarning(csElement, node, message, bindings);
	}

	public void addWarning(@NonNull ModelElementCS csElement, /*@NonNull*/ INode node, /*@NonNull*/ String message, Object... bindings) {
		String boundMessage = NLS.bind(message, bindings);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, boundMessage);
		csElement.eResource().getWarnings().add(resourceDiagnostic);
	}

	public @NonNull String bind(@NonNull EObject csContext, /*@NonNull*/ String messageTemplate, Object... bindings) {
		return converter.bind(csContext, messageTemplate, bindings);
	}

	public boolean checkForNoErrors(@NonNull BaseCSResource csResource) {
		@NonNull List<Resource.Diagnostic> errors = csResource.getErrors();
		if (ElementUtil.hasSyntaxError(errors)) {
			return false;
		}
		return true;
	}

	/** @deprecated no longer used - code null test in caller */
	@Deprecated
	public Dependency createTypeIsReferenceableDependency(@NonNull TypeRefCS csTemplateParameter) {
		if (csTemplateParameter instanceof WildcardTypeRefCS) {
			return null;
		}
		else {
			return new PivotDependency(csTemplateParameter);
		}
	}

	protected void diagnoseContinuationFailure(@NonNull List<BasicContinuation<?>> continuations) {
		if (CONTINUATION.isActive()) {
			for (BasicContinuation<?> continuation : continuations) {
				CONTINUATION.println(ClassUtil.nonNullState(continuation.toString()));
				for (Dependency dependency : continuation.getDependencies()) {
					boolean canExecute = dependency.canExecute();
					CONTINUATION.println((canExecute ? "+ " : "- ") + dependency.toString());
				}
			}
		}
		StringBuilder s = new StringBuilder();
		int i = 0;
		for (BasicContinuation<?> continuation : continuations) {
			s.append("\n  ");
			s.append(continuation);
			for (Dependency dependency : continuation.getDependencies()) {
				s.append("\n    ");
				if (!dependency.canExecute()) {
					s.append("BLOCKED ");
					dependency.canExecute();			// FIXME debugging
				}
				s.append(dependency);
			}
			continuation.canExecute();			// FIXME debugging
			if (++i >= 10) {
				s.append("\n  ...");
				break;
			}
		}
		logger.error("Failed to complete continuations" + s.toString());		// FIXME
	}

	/*	private void enforceConformance(AnyType oclAny) {
		Collection<? extends Resource> pivotResources = converter.getPivotResources();
		Collection<Notifier> allPivotResources = new ArrayList<Notifier>(pivotResources);
		allPivotResources.add(metamodelManager.getOrphanPackage());
		for (TreeIterator<Object> tit = EcoreUtil.getAllContents(allPivotResources); tit.hasNext(); ) {
			Object object = tit.next();
			if (object instanceof org.eclipse.ocl.pivot.Package) {
				for (Type type : ((org.eclipse.ocl.pivot.Package)object).getOwnedType()) {
					if (type instanceof org.eclipse.ocl.pivot.Class) {
						List<org.eclipse.ocl.pivot.Class> superClasses = ((org.eclipse.ocl.pivot.Class)type).getSuperClass();
						if (superClasses.isEmpty()) {
							if (type != oclAny) {
								if (type instanceof org.eclipse.ocl.pivot.Enumeration) {
									superClasses.add(metamodelManager.getEnumerationType());
								}
								else {
									superClasses.add(oclAny);
								}
							}
						}
					}
				}
			}
			else {
				tit.prune();
			}
		}
	} */

	/*	protected List<String> getDocumentationStrings1(CompositeNode node) {
		List<LeafNode> documentationNodes = CS2AS.getDocumentationNodes(node);
		if (documentationNodes == null) {
			return null;
		}
		List<String> documentationStrings = new ArrayList<String>();
		for (LeafNode documentationNode : documentationNodes) {
			String text = documentationNode.getText();
			documentationStrings.add(text.substring(3, text.length()-3).trim());
		}
		return documentationStrings;
	} */

	/**
	 * Prune the pivots to eliminate:
	 * - redundant orphans - e.g. obsolete specializations
	 * - redundant elements - e.g. pivots that are not needed as a result of a CS update
	 * - dependent caches that reference any of the above
	 *
	 * Wanted pivot elements are
	 * - all elements in all libraries
	 * - all elements locked via MetamodelManager.addLockedElement()
	 * - all elements transitively in/referenced from the above
	 * - all elements referenced by incoming CS resources
	 * - all elements in all incoming pivot resources
	 * - except pivot resources mapped to incoming CS resources
	 *     this is what we're cleaning up
	 */
	public void garbageCollect(@NonNull Map<? extends Resource, ? extends ASResource> cs2asResourceMap) {
		//		org.eclipse.ocl.pivot.Class orphanClass = metamodelManager.getOrphanClass();
		//		org.eclipse.ocl.pivot.Package orphanPackage = metamodelManager.getOrphanPackage();
		//		Resource orphanResource = orphanPackage.eResource();
		final Collection<Notifier> prunableResources = new ArrayList<Notifier>(cs2asResourceMap.values());
		//		prunableResources.add(orphanResource);
		Collection<Notifier> allPivotResources = new ArrayList<Notifier>(metamodelManager.getASResourceSet().getResources());
		//		allPivotResources.removeAll(prunableResources);					// Dead elements in orphanage or pivot of CS can be pruned
		EObject lockingObject = metamodelManager.getLockingObject();
		if (lockingObject != null) {
			allPivotResources.add(lockingObject);						// Locked elements are not dead
		}
		allPivotResources.addAll(metamodelManager.getLibraries());			// Library elements are not dead
		allPivotResources.addAll(cs2asResourceMap.keySet());				// Incoming elements are not dead
		allPivotResources.remove(metamodelManager.getCompleteModel().getOrphanage().eResource());			// FIXME redundant ??
		@SuppressWarnings("serial")
		Map<EObject, Collection<Setting>> referencesToOrphans = new EcoreUtil.CrossReferencer(allPivotResources)
		{
			{ crossReference(); }
			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				Resource eResource = crossReferencedEObject.eResource();
				boolean isPrunable = prunableResources.contains(eResource);
				//				if (isPrunable && prunableResources.contains(eObject.eResource())) {
				//					PivotUtil.debugObjectUsage("prunable xref ", crossReferencedEObject);
				//					PivotUtil.debugObjectUsage(" from " + eReference.getName() + " ", eObject);
				//				}
				//				else {
				//					PivotUtil.debugObjectUsage("unprunable xref ", crossReferencedEObject);
				//					PivotUtil.debugObjectUsage(" from " + eReference.getName() + " ", eObject);
				//				}
				return isPrunable;
			}

			@Override
			protected void handleCrossReference(EObject eObject) {
				try {
					super.handleCrossReference(eObject);
					InternalEObject internalEObject = (InternalEObject)eObject;
					for (EObject eContent : eObject.eContents()) {
						EReference eReference = (EReference) eContent.eContainingFeature();
						add(internalEObject, eReference, eContent);
					}
				}
				catch (Exception e) {}
			}

			@Override
			protected boolean resolve() {
				return false;		// Don't start creating specializations to resolve proxies
			}
		};
		Set<EObject> wantedOrphans = new HashSet<EObject>();
		List<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> suspects = new ArrayList<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>();
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : referencesToOrphans.entrySet()) {
			EObject referencedOrphan = entry.getKey();
			Collection<EStructuralFeature.Setting> referencesToOrphan = entry.getValue();
			boolean wantIt = false;
			for (EStructuralFeature.Setting setting : referencesToOrphan) {
				EObject eObject = setting.getEObject();
				Resource eResource = eObject.eResource();
				if (!prunableResources.contains(eResource)) {
					//					PivotUtil.debugObjectUsage("externally refd ", referencedOrphan);
					wantedOrphans.add(referencedOrphan);
					wantIt = true;
					break;
				}
			}
			if (!wantIt) {
				//				if ((referencedOrphan != orphanPackage) && (referencedOrphan != orphanClass)) {
				//					PivotUtil.debugObjectUsage("externally unrefd ", referencedOrphan);
				suspects.add(entry);
				//				}
				//				else {
				//					PivotUtil.debugObjectUsage("unkillable ", referencedOrphan);
				//				}
			}
		}
		while (!suspects.isEmpty()) {
			List<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> oldSuspects = suspects;
			suspects = new ArrayList<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>();
			for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : oldSuspects) {
				EObject referencedOrphan = entry.getKey();
				Collection<EStructuralFeature.Setting> referencesToOrphan = entry.getValue();
				boolean wantIt = false;
				for (EStructuralFeature.Setting setting : referencesToOrphan) {
					EObject eObject = setting.getEObject();
					if (wantedOrphans.contains(eObject)) {
						//						PivotUtil.debugObjectUsage(pass + " internally refd ", referencedOrphan);
						//						PivotUtil.debugObjectUsage("     by ", eObject);
						wantedOrphans.add(referencedOrphan);
						wantIt = true;
						break;
					}
				}
				if (!wantIt) {
					//					PivotUtil.debugObjectUsage(pass + " internally unrefd ", referencedOrphan);
					suspects.add(entry);
				}
			}
			if (oldSuspects.size() <= suspects.size()) {
				break;
			}
		}
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : suspects) {
			EObject referencedOrphan = entry.getKey();
			boolean wantIt = false;
			for (EObject eChild : referencedOrphan.eContents()) {		// FIXME this avoids a loss of the Ecore part of a Complete OCL resource
				if (wantedOrphans.contains(eChild)) {					//  surely an earlier containment want search should have found this
					wantIt = true;
					break;
				}
			}
			if (!wantIt) {
				//				PivotUtil.debugObjectUsage("kill ", referencedOrphan);
				Collection<EStructuralFeature.Setting> referencesToOrphan = entry.getValue();
				if (referencesToOrphan != null) {
					for (EStructuralFeature.Setting setting : referencesToOrphan) {
						EObject eObject = setting.getEObject();
						EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
						if (!eStructuralFeature.isDerived()) {
							//							PivotUtil.debugObjectUsage(" non-derived " + eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName() + " : ", eObject);
							if (eStructuralFeature.isMany()) {
								@SuppressWarnings("unchecked")
								Collection<Object> list = (Collection<Object>) eObject.eGet(eStructuralFeature);
								list.remove(referencedOrphan);
							}
							else {
								eObject.eSet(eStructuralFeature, null);
							}
						}
						else {
							//							PivotUtil.debugObjectUsage(" derived " + eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName() + " : ", eObject);
							//							System.out.println("  derived " + eObject.getClass().getName() + "@" + eObject.hashCode() + " " + eStructuralFeature.getName());
						}
					}
				}
				EObject eContainer = referencedOrphan.eContainer();
				if (eContainer != null) {
					PivotUtil.debugObjectUsage("  container ", eContainer);
					referencedOrphan.eSet(referencedOrphan.eContainingFeature(), null);
				}
				//WIP			metamodelManager.kill(referencedOrphan);
			}
		}
		//		for (MonikeredElement element : oldMoniker2asMap.values()) {
		//			if (element.eResource() == null) {
		//				PivotUtil.debugObjectUsage("Final Old residue ", element);
		// This is a bit late: a notification of non-containment would be sharper.
		//				metamodelManager.kill(element);
		//			}
		//		}
		//		for (MonikeredElement element : newMoniker2asMap.values()) {
		//			if (element.eResource() == null) {
		//				PivotUtil.debugObjectUsage("Final New residue ", element);
		//			}
		//		}
		//		for (Type orphanType : orphanPackage.getOwnedType()) {
		//			if (!PivotUtil.debugWellContainedness(orphanType)) {
		//				for (Setting setting : referencesToOrphans.get(orphanType)) {
		//					PivotUtil.debugObjectUsage("Dangling reference " + setting.getEStructuralFeature().getName() + " ", setting.getEObject());
		//				}
		//			}
		//		}
	}

	protected void gatherNewPackage(@NonNull Set<org.eclipse.ocl.pivot.Package> newPackages, @NonNull EObject pivot) {
		if (pivot instanceof org.eclipse.ocl.pivot.Package) {
			newPackages.add((org.eclipse.ocl.pivot.Package)pivot);
		}
		EObject eContainer = pivot.eContainer();
		if (eContainer != null) {
			gatherNewPackage(newPackages, eContainer);
		}
	}

	/**
	 * Add any packages and nested packages pivoted by csResource to newPackages. This
	 * is invoked at the end of an update to identify redundant packages.
	 */
	protected void gatherNewPackages(@NonNull Set<org.eclipse.ocl.pivot.Package> newPackages, @NonNull Resource csResource) {
		for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Pivotable) {
				Element pObject = ((Pivotable)eObject).getPivot();
				if (pObject instanceof org.eclipse.ocl.pivot.Package) {
					gatherNewPackage(newPackages, pObject);
				}
				else if (pObject instanceof Model) {
					gatherNewPackage(newPackages, pObject);
				}
				else {		// CompleteOCL has package references from non-package contexts
					if (pObject instanceof Type) {
						gatherNewPackage(newPackages, pObject);
					}
					else if (pObject instanceof Operation) {
						gatherNewPackage(newPackages, pObject);
					}
					else if (pObject instanceof Property) {
						gatherNewPackage(newPackages, pObject);
					}
					tit.prune();
				}
				if (eObject instanceof MorePivotable) {  // CompleteOCL has package references from non-package contexts
					for (Element pivot : ((MorePivotable)eObject).getMorePivots()) {
						if (pivot != null) {
							gatherNewPackage(newPackages, pivot);
						}
					}
				}
			}
		}
	}

	/**
	 * Add any packages and nested packages in eObjects to oldPackages. This
	 * is invoked at the start of an update to cache the packages for re-use.
	 */
	protected void gatherOldPackages(@NonNull List<? extends org.eclipse.ocl.pivot.@NonNull Package> pkgs) {
		for (org.eclipse.ocl.pivot.@NonNull Package pkg : pkgs) {
			String name = pkg.getName();
			if (name == null) {
				name = PivotConstantsInternal.NULL_ROOT;
			}
			String qualifiedName = getQualifiedName(new StringBuilder(), pkg);
			org.eclipse.ocl.pivot.Package oldPkg = oldPackagesByQualifiedName.put(qualifiedName, pkg);
			if (oldPkg != null) {
				logger.warn("Duplicate qualified package name: " + qualifiedName);
			}
			if (name.equals(qualifiedName)) {
				oldPkg = oldPackagesByName.put(name, pkg);
				if ((oldPkg != null) && name.equals(getQualifiedName(new StringBuilder(), oldPkg))) {
					logger.warn("Duplicate unqualified package name: " + qualifiedName);
				}
			}
			else {
				oldPkg = oldPackagesByName.get(name);
				if (oldPkg == null) {
					oldPackagesByName.put(name, pkg);
				}
			}
			@NonNull List<org.eclipse.ocl.pivot.Package> nestedPackage = pkg.getOwnedPackages();
			gatherOldPackages(nestedPackage);
		}
	}

	public final @NonNull CS2AS getConverter() {
		return converter;
	}

	@Override
	public final @NonNull PivotHelper getHelper() {
		return converter.getHelper();
	}

	@SuppressWarnings("unchecked")
	public <T> T getIntermediate(@NonNull CacheKey<T> key) {
		return (T) intermediateCache.get(key);
	}

	public <T extends Element> List<T> getNewPivotElements(@NonNull Class<T> pivotClass, /*@NonNull*/ Iterable<? extends ModelElementCS> csElements) {
		assert csElements != null;
		List<T> newPivotElements = new ArrayList<T>();
		for (ModelElementCS csElement : csElements) {
			@Nullable T pivotElement = PivotUtil.getPivot(pivotClass, csElement);
			if (pivotElement != null) {
				newPivotElements.add(pivotElement);
			}
		}
		return newPivotElements;
	}

	public org.eclipse.ocl.pivot.@Nullable Package getOldPackageByQualifiedName(@NonNull PackageCS csElement) {
		String qualifiedName = getQualifiedName(new StringBuilder(), csElement);
		return oldPackagesByQualifiedName.get(qualifiedName);
	}

	public org.eclipse.ocl.pivot.@Nullable Package getOldPackageBySimpleName(@NonNull String name) {
		return oldPackagesByName.get(name);
	}

	public @NonNull InterDependency<@NonNull OperatorExpContinuation<?>> getOperatorsHavePrecedenceInterDependency() {
		return operatorsHavePrecedence;
	}

	protected @NonNull String getQualifiedName(@NonNull StringBuilder s, org.eclipse.ocl.pivot.@NonNull Package pkg) {
		org.eclipse.ocl.pivot.Package nestingPackage = pkg.getOwningPackage();
		if (nestingPackage != null) {
			getQualifiedName(s, nestingPackage);
			s.append("$$");
		}
		String name = pkg.getName();
		if (name == null) {
			name = PivotConstantsInternal.NULL_ROOT;
		}
		s.append(name);
		return s.toString();
	}

	protected @NonNull String getQualifiedName(@NonNull StringBuilder s, @NonNull PackageCS csPackage) {
		EObject eContainer = csPackage.eContainer();
		if (eContainer instanceof PackageCS) {
			getQualifiedName(s, (PackageCS) eContainer);
			s.append("$$");
		}
		String name = csPackage.getName();
		if (name == null) {
			name = PivotConstantsInternal.NULL_ROOT;
			if (eContainer == null) {
				Resource csResource = csPackage.eResource();
				if (csResource != null) {
					URI csURI = csResource.getURI();
					if (csURI != null) {
						name = csURI.lastSegment();
					}
				}
			}
		}
		s.append(name);
		return s.toString();
	}

	protected @NonNull List<TemplateBindingCS> getTemplateBindings(@NonNull ElementCS csElement) {
		List<TemplateBindingCS> csTemplateBindings;
		//		EObject container = csElement.eContainer();
		//		if (container instanceof ElementCS) {
		//			csTemplateBindings = getTemplateBindings((ElementCS) container);
		//		}
		//		else {
		csTemplateBindings = new ArrayList<TemplateBindingCS>();
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

	protected @NonNull List<TemplateSignature> getTemplateSignatures(@NonNull Element pivotElement) {
		List<TemplateSignature> pivotTemplateSignatures;
		EObject container = pivotElement.eContainer();
		if (container instanceof Element) {
			pivotTemplateSignatures = getTemplateSignatures((Element) container);
		}
		else {
			pivotTemplateSignatures = new ArrayList<TemplateSignature>();
		}
		if (pivotElement instanceof TemplateableElement) {
			TemplateableElement templateableElement = (TemplateableElement)pivotElement;
			TemplateSignature templateSignature = templateableElement.getOwnedSignature();
			if (templateSignature != null) {
				pivotTemplateSignatures.add(templateSignature);
			}
		}
		return pivotTemplateSignatures;
	}

	public @NonNull InterDependency<@NonNull TemplateSignatureContinuation> getTypesHaveSignaturesInterDependency() {
		return typesHaveSignatures;
	}

	public void handleVisitNamedElement(@NonNull NamedElementCS csNamedElement, @NonNull NamedElement pivotElement) {
		List<Element> pivotAnnotations = pivotElement.getOwnedAnnotations();
		List<AnnotationElementCS> csAnnotations = csNamedElement.getOwnedAnnotations();
		//		if ((csAnnotations.size() <= 1) && (pivotAnnotations.size() <= 1)) {
		refreshPivotList(Annotation.class, pivotAnnotations, csAnnotations);
		/*		}
		else {
			HashSet<String> names = new HashSet<String>();
			HashMap<String, List<Annotation>> pivotMap = new HashMap<String, List<Annotation>>();
			HashMap<String, List<AnnotationElementCS>> csMap = new HashMap<String, List<AnnotationElementCS>>();
			for (Annotation pivotAnnotation : pivotAnnotations) {
				String name = pivotAnnotation.getName();
				names.add(name);
				List<Annotation> pivotList = pivotMap.get(name);
				if (pivotList == null) {
					pivotList = new ArrayList<Annotation>();
					pivotMap.put(name, pivotList);
				}
				pivotList.add(pivotAnnotation);
			}
			for (AnnotationElementCS csAnnotation : csAnnotations) {
				String name = csAnnotation.getName();
				names.add(name);
				List<AnnotationElementCS> csList = csMap.get(name);
				if (csList == null) {
					csList = new ArrayList<AnnotationElementCS>();
					csMap.put(name, csList);
				}
				csList.add(csAnnotation);
			}
			for (String name : names) {
				List<Annotation> pivotList = pivotMap.get(name);
				List<AnnotationElementCS> csList = csMap.get(name);
//				refreshPivotList(Annotation.class, pivotAnnotations, csAnnotations);
				List<Annotation> newPivotAnnotations = new ArrayList<Annotation>();
				for (ModelElementCS csElement : csList) {
					Annotation pivotAnnotation = getPivotElement(Annotation.class, csElement);
					assert pivotAnnotation != null;
					if (pivotElement != null) {
						newPivotAnnotations.add(pivotAnnotation);
					}
				}
				refreshList(pivotAnnotations, newPivotAnnotations);
			}
		} */
	}

	public void installPivotReference(@NonNull ElementRefCS csElement, @NonNull Element newPivotElement, /*@NonNull*/ EReference eReference) {
		assert eReference != null;
		converter.installPivotReference(csElement, newPivotElement, eReference);
	}

	public void installPivotUsage(@NonNull PivotableElementCS csElement, @NonNull Element newPivotElement) {
		converter.installPivotUsage(csElement, newPivotElement);
	}

	protected void installRootContents(@NonNull BaseCSResource csResource) {	// FIXME This code is no longer needed; delete once QVTd checked
		for (EObject eObject : csResource.getContents()) {
			if (eObject instanceof Pivotable) {
				Element pivotElement = ((Pivotable)eObject).getPivot();
				if (pivotElement != null) {
					Resource asResource = pivotElement.eResource();
					if (asResource == null) {
						installRootElement(csResource, pivotElement);
					}
				}
			}
		}
	}

	public void installPivotTypeWithMultiplicity(@Nullable Type pivotType, @NonNull TypedRefCS csElement) {
		if ((pivotType == null) || pivotType.eIsProxy()) {
			pivotType = getStandardLibrary().getOclInvalidType();
		}
		boolean isNullFree = false;
		int lower = pivotType instanceof MapType ? 1 : 0;			// Optional EMaps are impossible and so optional Maps are not supported.
		int upper = 1;
		MultiplicityCS multiplicity = csElement.getOwnedMultiplicity();
		if (multiplicity != null) {
			isNullFree = multiplicity.isIsNullFree();
			lower = multiplicity.getLower();
			upper = multiplicity.getUpper();
		}
		if (upper == 1) {
			installPivotReference(csElement, pivotType, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
		}
		else {
			boolean isOrdered = false;
			boolean isUnique = false;
			EObject eContainer = csElement.eContainer();
			if (eContainer instanceof TypedElementCS) {
				isOrdered = ElementUtil.isOrdered((TypedElementCS) eContainer);
				isUnique = ElementUtil.isUnique((TypedElementCS) eContainer);
			}
			IntegerValue lowerValue = ValueUtil.integerValueOf(lower);
			UnlimitedNaturalValue upperValue = upper != -1 ? ValueUtil.unlimitedNaturalValueOf(upper) : ValueUtil.UNLIMITED_VALUE;
			CollectionType pivotCollectionType = metamodelManager.getCollectionType(isOrdered, isUnique, pivotType, isNullFree, lowerValue, upperValue);
			installPivotReference(csElement, pivotCollectionType, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
		}
	}

	public void installRootElement(@NonNull BaseCSResource csResource, @NonNull Element pivotElement) {
		Resource asResource = converter.getASResource();
		asResource.getContents().add(pivotElement);
		metamodelManager.installResource(asResource);
	}

	public boolean isInReturnTypeWithUnresolvedParameters(@NonNull ElementCS csElement) {
		OperationCS csOperation = null;
		for (EObject eObject = csElement, eContainer = csElement.eContainer();; eObject = eContainer, eContainer = eContainer.eContainer()) {
			if (eContainer == null) {
				return false;
			}
			if (eContainer instanceof OperationCS) {
				csOperation = (OperationCS) eContainer;
				if (eObject != csOperation.getOwnedType()) {
					return false;
				}
				break;
			}
		}
		if (csOperation == null) {
			return false;
		}
		for (ParameterCS csParameter : csOperation.getOwnedParameters()) {
			Parameter pivot = PivotUtil.getPivot(Parameter.class, csParameter);
			if (pivot == null) {
				return true;
			}
			if (pivot.getType() == null) {
				return true;
			}
		}
		return false;
	}

	public @Nullable Boolean isRequired(@NonNull TypedRefCS csTypeRef) {
		return converter.isRequired(csTypeRef);
	}

	public @Nullable Iteration lookupIteration(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		return converter.lookupIteration(csElement, csPathName, scopeFilter);
	}

	public @Nullable Operation lookupOperation(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		return converter.lookupOperation(csElement, csPathName, scopeFilter);
	}

	public @Nullable Property lookupProperty(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		return converter.lookupProperty(csElement, csPathName, scopeFilter);
	}

	public @Nullable Type lookupType(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		return converter.lookupType(csElement, csPathName);
	}

	public @Nullable Type lookupTypeValue(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		return converter.lookupTypeValue(csElement, csPathName);
	}

	public @Nullable Element lookupUndecoratedName(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		return converter.lookupUndecoratedName(csElement, csPathName);
	}

	/**
	 * Invoke all of the continuations that can execute, returning the list of
	 * continuations till to perform, some of which may be ones that were
	 * blocked by unsatisfied dependencies, others of which may be further
	 * continuations resulting from only partial progress. Returns null if
	 * none of the continuations could execute.
	 *
	 * @param continuations
	 * @return continuations still to perform, null if stuck.
	 */
	protected @Nullable List<BasicContinuation<?>> progressContinuations(@NonNull List<BasicContinuation<?>> continuations) {
		List<BasicContinuation<?>> moreContinuations = new ArrayList<BasicContinuation<?>>();
		boolean madeProgress = false;
		boolean tracingOn = CONTINUATION.isActive();
		if (tracingOn) {
			CONTINUATION.println("------------------------------------------------ " + continuations.size());
			CONTINUATION.println(ClassUtil.nonNullState(typesHaveSignatures.toString()));
		}
		for (BasicContinuation<?> continuation : continuations) {
			boolean canExecute = continuation.canExecute();
			if (tracingOn) {
				CONTINUATION.println((canExecute ? "+ " : "- ") + continuation);
			}
			if (canExecute) {
				madeProgress = true;
				BasicContinuation<?> nextContinuation = continuation.execute();
				if (nextContinuation != null) {
					nextContinuation.addTo(moreContinuations);
				}
			}
			else {
				moreContinuations.add(continuation);
			}
		}
		return madeProgress ? moreContinuations : null;
	}

	@SuppressWarnings("unchecked")
	public <T> T putIntermediate(CacheKey<T> key, T object) {
		return (T) intermediateCache.put(key, object);
	}

	public void refreshComments(Element pivotElement, ElementCS csElement) {
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		if ((node != null) && !(node instanceof RootNode)) {
			List<ILeafNode> documentationNodes = CS2AS.getDocumentationNodes(node);
			List<Comment> ownedComments = pivotElement.getOwnedComments();
			if (documentationNodes != null) {
				int i = 0;
				if ((documentationNodes.size() == 1) && "/**/".equals(documentationNodes.get(0).getText())) {
					Comment comment = PivotFactory.eINSTANCE.createComment();
					comment.setBody(null);
					ownedComments.add(comment);
					i = 1;
				}
				else {
					List<String> documentationStrings = new ArrayList<String>();
					for (ILeafNode documentationNode : documentationNodes) {
						String text = documentationNode.getText().replace("\r", "");
						if (text.startsWith("/*") && text.endsWith("*/")) {
							StringBuilder s = new StringBuilder();
							String contentString = text.substring(2, text.length()-2).trim();
							for (String string : contentString.split("\n")) {
								String trimmedString = string.trim();
								if (s.length() > 0) {
									s.append("\n");
								}
								s.append(trimmedString.startsWith("*") ? trimmedString.substring(1).trim() : trimmedString);
							}
							documentationStrings.add(s.toString());
						}
						else {
							documentationStrings.add(text.trim());
						}
					}
					int iMax = Math.min(documentationStrings.size(), ownedComments.size());
					for (; i < iMax; i++) {
						String string = documentationStrings.get(i);
						if (string != null) {
							String trimmedString = string; //trimComments(string);
							Comment comment = ownedComments.get(i);
							if (!trimmedString.equals(comment.getBody())) {
								comment.setBody(trimmedString);
							}
						}
					}
					for ( ; i < documentationStrings.size(); i++) {
						String string = documentationStrings.get(i);
						if (string != null) {
							String trimmedString = string; //trimComments(string);
							Comment comment = PivotFactory.eINSTANCE.createComment();
							comment.setBody(trimmedString);
							ownedComments.add(comment);
						}
					}
				}
				while (i < ownedComments.size()) {
					ownedComments.remove(ownedComments.size()-1);
				}
			}
			else {
				if (ownedComments.size() > 0) {
					ownedComments.clear();
				}
			}
		}
	}

	public void refreshContextVariable(@NonNull ElementCS csElement, @NonNull ExpressionInOCL pivotSpecification) {
		//		System.out.println(ClassUtil.debugSimpleName(pivotSpecification) + " " + pivotSpecification);
		EObject eContainer = pivotSpecification.eContainer();
		EStructuralFeature eContainingFeature = pivotSpecification.eContainingFeature();
		if ((eContainer == null) || (eContainingFeature == null)) {
			addError(csElement, "No context container for: " + pivotSpecification);
		}
		else if (eContainingFeature == PivotPackage.Literals.CONSTRAINT__OWNED_SPECIFICATION) {
			Constraint contextConstraint = (Constraint)eContainer;
			eContainer = contextConstraint.eContainer();
			eContainingFeature = contextConstraint.eContainingFeature();
			if (eContainingFeature == PivotPackage.Literals.CLASS__OWNED_INVARIANTS) {
				Type contextType = (Type)eContainer;
				if (contextType != null) {
					setClassifierContext(pivotSpecification, contextType);
				}
				getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, contextType, null);
			}
			else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
				Operation contextOperation = (Operation)eContainer;
				if (contextOperation != null) {
					getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, contextOperation.getOwningClass(), null);
					setOperationContext(pivotSpecification, contextOperation, null);
				}
				else {
					getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, null, null);
				}
			}
			else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
				Operation contextOperation = (Operation)eContainer;
				if (contextOperation != null) {
					getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, contextOperation.getOwningClass(), null);
					setOperationContext(pivotSpecification, contextOperation, PivotConstants.RESULT_NAME);
				}
				else {
					getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, null, null);
				}
			}
			else {
				addError(csElement, "Unsupported refreshContextVariable for a constraint: " + eContainingFeature);
			}
		}
		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__OWNED_EXPRESSION) {
			Property contextProperty = (Property)eContainer;
			setPropertyContext(pivotSpecification, contextProperty);
			getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, contextProperty.getOwningClass(), null);
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			Operation contextOperation = (Operation)eContainer;
			getHelper().setContextVariable(pivotSpecification, PivotConstants.SELF_NAME, contextOperation.getOwningClass(), null);
			setOperationContext(pivotSpecification, contextOperation, null);
		}
		else {
			addError(csElement, "Unsupported refreshContextVariable for a specification: " + eContainingFeature);
		}
	}

	public <T extends Element> void refreshList(@NonNull Class<T> pivotClass, List<T> pivotElements, /*@NonNull*/ List<? extends PivotableElementCS> csElements) {
		assert csElements != null;
		if (!pivotElements.isEmpty() ||!csElements.isEmpty()) {
			List<T> newPivotElements = new ArrayList<T>();
			for (PivotableElementCS csElement : csElements) {
				@Nullable T pivotElement = PivotUtil.getPivot(pivotClass, csElement);
				if ((pivotElement == null) && (csElement instanceof ModelElementCS)) {
					pivotElement = converter.getPivotElement(pivotClass, (ModelElementCS)csElement);
				}
				if ((pivotElement != null) && !newPivotElements.contains(pivotElement)) {		// OclInvalid can be prolific
					newPivotElements.add(pivotElement);
				}
			}
			PivotUtilInternal.refreshList(pivotElements, newPivotElements);
		}
	}

	/**
	 * Return a pivotEClass instance cast to pivotClass registered for csElement.getCSI().
	 * <p>An existing element is re-used else an new instance is created.
	 * <p>The pivot element is installed as the original object of csElement.
	 */
	public @NonNull <T extends Element> T refreshModelElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @Nullable ModelElementCS csElement) {
		assert pivotEClass != null;
		return converter.refreshModelElement(pivotClass, pivotEClass, csElement);
	}

	/* @deprecated no longer used / use PivotHelper.refreshName() */
	@Deprecated
	@Override
	public void refreshName(@NonNull NamedElement pivotNamedElement, @Nullable String newName) {
		getHelper().refreshName(pivotNamedElement, newName);
	}

	/* @deprecated no longer used / use PivotHelper.refreshNsURI() */
	@Deprecated
	@Override
	public void refreshNsURI(org.eclipse.ocl.pivot.@NonNull Package pivotPackage, String newNsURI) {
		getHelper().refreshNsURI(pivotPackage, newNsURI);
	}

	public <T extends Element> void refreshPivotList(@NonNull Class<T> pivotClass, /*@NonNull*/ List<? super T> pivotElements,
			/*@NonNull*/ Iterable<? extends ModelElementCS> csElements) {
		assert pivotElements != null;
		assert csElements != null;
		if (pivotElements.isEmpty() && Iterables.isEmpty(csElements)) {
			return;
		}
		List<T> newPivotElements = getNewPivotElements(pivotClass, csElements);
		PivotUtilInternal.refreshList(pivotElements, newPivotElements);
	}

	public Type refreshRequiredType(@NonNull TypedElement pivotElement, @NonNull TypedElementCS csTypedElement) {
		TypedRefCS ownedType = csTypedElement.getOwnedType();
		Type pivotType = null;
		boolean isRequired = false;
		if (ownedType != null) {
			boolean optionalDefaultMultiplicity2 = optionalDefaultMultiplicity;
			pivotType = PivotUtil.getPivot(Type.class, ownedType);
			int lower;
			int upper;
			if (pivotType instanceof LambdaType) {			// The lambda exprssion is mandatory, for compatibility we propagate the return nullity
				optionalDefaultMultiplicity2 = true;		// BUG
			}
			if (pivotType instanceof MapType) {		// Ecore does not support collections of or null EMaps, so pivot Maps must also be 1..1
				lower = 1;
				upper = 1;
				isRequired = true;
			}
			else {
				MultiplicityCS csMultiplicity = ownedType.getOwnedMultiplicity();
				if ((csMultiplicity == null) && !optionalDefaultMultiplicity2){
					lower = 1;
					upper = 1;
					isRequired = true;
				}
				else {
					lower = ElementUtil.getLower(csTypedElement);
					upper = ElementUtil.getUpper(csTypedElement);
					if (upper == 1) {
						isRequired = lower == 1;
					}
					else {
						isRequired = true;
						//				if (pivotType != null) {
						//					pivotType = metamodelManager.getCollectionType(ElementUtil.isOrdered(csTypedElement), ElementUtil.isUnique(csTypedElement), pivotType, ValueUtil.integerValueOf(lower), ValueUtil.unlimitedNaturalValueOf(upper));
						//				}
					}
				}
			}
		}
		if (pivotType == null) {
			pivotType = metamodelManager.getStandardLibrary().getOclVoidType();
			isRequired = false;
		}
		getHelper().setType(pivotElement, pivotType, isRequired);
		return pivotType;
	}

	public void refreshRequiredType(@NonNull TypedElement pivotElement, @NonNull TypedRefCS csTypeRef) {
		org.eclipse.ocl.pivot.Class type = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csTypeRef);
		Boolean isRequired = converter.isRequired(csTypeRef);
		if (isRequired == null) {
			boolean defaultIsOptional = getEnvironmentFactory().getValue(PivotValidationOptions.OptionalDefaultMultiplicity) == Boolean.TRUE;
			isRequired = !defaultIsOptional;
		}
		getHelper().setType(pivotElement, type, isRequired.booleanValue());
	}

	public void refreshTemplateSignature(@NonNull TemplateableElementCS csTemplateableElement, @NonNull TemplateableElement pivotTemplateableElement) {
		TemplateSignatureCS csTemplateSignature = csTemplateableElement.getOwnedSignature();
		if (csTemplateSignature == null) {
			if (pivotTemplateableElement.getOwnedSignature() != null) {
				pivotTemplateableElement.setOwnedSignature(null);
			}
			return;
		}
		TemplateSignature pivotTemplateSignature = PivotUtil.getPivot(TemplateSignature.class, csTemplateSignature);
		if (pivotTemplateableElement.getOwnedSignature() != pivotTemplateSignature) {
			pivotTemplateableElement.setOwnedSignature(pivotTemplateSignature);
		}
	}

	protected void resetPivotMappings(@NonNull BaseCSResource csResource) {
		for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Pivotable) {
				Pivotable pivotable = (Pivotable)eObject;
				//				Element pivot = pivotable.getPivot();
				pivotable.resetPivot();
			}
		}
	}

	/* @deprecated no longer used / use PivotHelper.setBehavioralType() */
	@Deprecated
	@Override
	public void setBehavioralType(@NonNull TypedElement targetElement, @NonNull TypedElement sourceElement) {
		getHelper().setBehavioralType(targetElement, sourceElement);
	}

	/* @deprecated use PivotHelper.setContextVariable() */
	@Override
	@Deprecated
	public void setContextVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull String selfVariableName, @Nullable Type contextType, @Nullable Type contextInstance) {
		getHelper().setContextVariable(pivotSpecification, selfVariableName, contextType, contextInstance);
	}

	public void setReferredIteration(@NonNull LoopExp expression, @Nullable Iteration iteration) {
		expression.setReferredIteration(iteration);
		expression.setName(iteration != null ? iteration.getName() : null);
	}

	public void setReferredOperation(@NonNull OperationCallExp expression, @Nullable Operation operation) {
		expression.setReferredOperation(operation);
		expression.setName(operation != null ? operation.getName() : null);
	}

	/* @deprecated no longer used / use PivotHelper.setType() */
	@Deprecated
	@Override
	public void setType(@NonNull OCLExpression pivotElement, Type type, boolean isRequired, @Nullable Type typeValue) {
		getHelper().setType(pivotElement, type, isRequired, typeValue);
	}

	/* @deprecated no longer used / use PivotHelper.setType() */
	@Deprecated
	@Override
	public void setType(@NonNull VariableDeclaration pivotElement, Type type, boolean isRequired, @Nullable Type typeValue) {
		getHelper().setType(pivotElement, type, isRequired, typeValue);
	}

	/* @deprecated no longer used / use PivotHelper.setType() */
	@Deprecated
	@Override
	public void setType(@NonNull TypedElement pivotElement, Type type, boolean isRequired) {
		getHelper().setType(pivotElement, type, isRequired);
	}

	/**
	 * Update a list of TemplateBinding to match a list of TemplateSignature
	 * by moving/adding/removing existing entries. Once matched each TemplateBinding.signature
	 * references the corresponding TemplateSignature, and each TemplateBinding.parameterSubstitution.formal
	 * references the corresponding TemplateSignature.ownedParameter.
	 *
	 * @param templateBindings
	 * @param templateSignatures
	 */
	protected void specializeTemplateBindings(@NonNull List<TemplateBinding> templateBindings, @NonNull List<TemplateSignature> templateSignatures, @NonNull List<TemplateBindingCS> csTemplateBindings) {
		int csIMax = csTemplateBindings.size();
		int pivotIMax = templateSignatures.size();
		if (csIMax != pivotIMax) {
			TypedTypeRefCS owningTemplateBindableElement = csTemplateBindings.get(0).getOwningElement();
			String string = owningTemplateBindableElement != null ? owningTemplateBindableElement.toString() : "<null>";
			logger.warn("Inconsistent template bindings size for " + string); //$NON-NLS-1$
		}
		int newMax = Math.min(csIMax, pivotIMax);
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			TemplateBindingCS csTemplateBinding = csTemplateBindings.get(i);
			if (csTemplateBinding != null) {
				TemplateSignature templateSignature = templateSignatures.get(i);
				int oldMax = templateBindings.size();
				TemplateBinding templateBinding = null;;
				for (int j = i; j < oldMax; j++) {
					TemplateBinding oldTemplateBinding = templateBindings.get(j);
					if (oldTemplateBinding.getTemplateSignature() == templateSignature) {
						if (j != i) {
							templateBindings.add(i, templateBindings.remove(j));
						}
						templateBinding = oldTemplateBinding;
						//					registerPivotElement(csTemplateBinding, templateBinding);
						//					installPivotElement(csTemplateBinding, templateBinding);
						break;
					}
				}
				if (templateBinding == null) {
					//				templateBinding = refreshElement(TemplateBinding.class, PivotPackage.Literals.TEMPLATE_BINDING, csTemplateBinding);
					templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
					assert templateBinding != null;
					if (i < oldMax) {
						templateBindings.add(i, templateBinding);
					}
					else {
						templateBindings.add(templateBinding);
					}
				}
				installPivotReference(csTemplateBinding, templateBinding, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
				@SuppressWarnings("null") @NonNull List<TemplateParameterSubstitution> parameterSubstitutions = templateBinding.getOwnedSubstitutions();
				@NonNull List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
				@SuppressWarnings("null") @NonNull List<TemplateParameterSubstitutionCS> csParameterSubstitutions = csTemplateBinding.getOwnedSubstitutions();
				specializeTemplateParameterSubstitutions(parameterSubstitutions, templateParameters, csParameterSubstitutions);
				assert templateSignatures.get(i) == templateBindings.get(i).getTemplateSignature();
			}
		}
		for (int k = templateBindings.size(); k > newMax; ) {
			templateBindings.remove(--k);
		}
		assert templateSignatures.size() == templateBindings.size();
	}

	/**
	 * Update a list of TemplateParameterSubstitution to match a list of TemplateParameter
	 * by moving/adding/removing existing entries. Once matched each TemplateParameterSubstitution.formal
	 * references the corresponding TemplateParameter.
	 */
	protected void specializeTemplateParameterSubstitutions(@NonNull List<TemplateParameterSubstitution> templateParameterSubstitutions,
			@NonNull List<TemplateParameter> templateParameters, @NonNull List<TemplateParameterSubstitutionCS> csTemplateParameterSubstitutions) {
		int csIMax = csTemplateParameterSubstitutions.size();
		int pivotIMax = templateParameters.size();
		if (csIMax != pivotIMax) {
			logger.warn("Inconsistent template parameter substitutions size"); // FIXME //$NON-NLS-1$
		}
		int newMax = Math.min(csIMax, pivotIMax);
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			@SuppressWarnings("null")@NonNull TemplateParameterSubstitutionCS csTemplateParameterSubstitution = csTemplateParameterSubstitutions.get(i);
			TemplateParameter templateParameter = templateParameters.get(i);
			int oldMax = templateParameterSubstitutions.size();
			TemplateParameterSubstitution templateParameterSubstitution = null;
			for (int j = i; j < oldMax; j++) {
				TemplateParameterSubstitution oldTemplateParameterSubstitution = templateParameterSubstitutions.get(j);
				if (oldTemplateParameterSubstitution.getFormal() == templateParameter) {
					if (j != i) {
						templateParameterSubstitutions.add(i, templateParameterSubstitutions.remove(j));
					}
					templateParameterSubstitution = oldTemplateParameterSubstitution;
					converter.installPivotDefinition(csTemplateParameterSubstitution, templateParameterSubstitution);
					break;
				}
			}
			if (templateParameterSubstitution == null) {
				//				templateParameterSubstitution = refreshElement(TemplateParameterSubstitution.class, PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION, csTemplateParameterSubstitution);
				templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				templateParameterSubstitution.setFormal(templateParameter);
				if (i < oldMax) {
					templateParameterSubstitutions.add(i, templateParameterSubstitution);
				}
				else {
					templateParameterSubstitutions.add(templateParameterSubstitution);
				}
			}
			TypeRefCS csActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
			if (csActualParameter instanceof WildcardTypeRefCS) {
				Orphanage orphanage = environmentFactory.getCompleteModel().getOrphanage();
				templateParameterSubstitution.setActual(Orphanage.getOrphanWildcardType(orphanage));
			}
			else {
				Type pivotActualParameter = PivotUtil.getPivot(Type.class, csActualParameter);
				templateParameterSubstitution.setActual(pivotActualParameter);
			}
			converter.installPivotDefinition(csTemplateParameterSubstitution, templateParameterSubstitution);
			assert templateParameters.get(i) == templateParameterSubstitutions.get(i).getFormal();
		}
		for (int k = templateParameterSubstitutions.size(); k > newMax; ) {
			templateParameterSubstitutions.remove(--k);
		}
		assert templateParameters.size() == templateParameterSubstitutions.size();
	}

	protected @Nullable TemplateableElement specializeTemplates(@NonNull TypedTypeRefCS csElement) {
		TemplateBindingCS ownedTemplateBinding = csElement.getOwnedBinding();
		assert ownedTemplateBinding != null;
		org.eclipse.ocl.pivot.Class unspecializedPivotElement = (org.eclipse.ocl.pivot.Class)csElement.getReferredType();	// FIXME cast
		//		logger.trace("Specializing " + moniker); //$NON-NLS-1$
		if ((unspecializedPivotElement == null) || unspecializedPivotElement.eIsProxy()) {
			String moniker = csElement.toString();
			addError(csElement, "Nothing to specialize as " + moniker); //$NON-NLS-1$
			return null;
		}
		//
		//	Refresh the pivot specialization root
		//
		org.eclipse.ocl.pivot.Class specializedPivotElement = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csElement);
		if (specializedPivotElement == null) {
			if (unspecializedPivotElement instanceof CollectionType) {
				TemplateParameterSubstitutionCS csTemplateParameterSubstitution = ownedTemplateBinding.getOwnedSubstitutions().get(0);
				Type templateArgument = PivotUtil.getPivot(Type.class, csTemplateParameterSubstitution.getOwnedActualParameter());
				boolean isNullFree = true;
				MultiplicityCS csMultiplicity = ownedTemplateBinding.getOwnedMultiplicity();
				if (csMultiplicity != null) {
					isNullFree = csMultiplicity.isIsNullFree();
				}
				specializedPivotElement = templateArgument != null ? completeEnvironment.getCollectionType((CollectionType) unspecializedPivotElement, templateArgument, isNullFree, null, null) : unspecializedPivotElement;
			}
			else {
				List<@NonNull Type> templateArguments = new ArrayList<@NonNull Type>();
				for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : ownedTemplateBinding.getOwnedSubstitutions()) {
					Type templateArgument = PivotUtil.getPivot(Type.class, csTemplateParameterSubstitution.getOwnedActualParameter());
					if (templateArgument != null) {
						templateArguments.add(templateArgument);
					}
				}
				specializedPivotElement = metamodelManager.getLibraryType(unspecializedPivotElement, templateArguments);
			}
		}
		installPivotReference(csElement, specializedPivotElement, BaseCSPackage.Literals.TYPED_TYPE_REF_CS__REFERRED_TYPE);
		if (specializedPivotElement != unspecializedPivotElement) {
			//
			//	Refresh the pivot specialization bindings and parameter substitutions
			//
			@SuppressWarnings("null") @NonNull List<TemplateBinding> templateBindings = specializedPivotElement.getOwnedBindings();
			List<TemplateSignature> templateSignatures = getTemplateSignatures(unspecializedPivotElement);
			List<TemplateBindingCS> csTemplateBindings = getTemplateBindings(csElement);
			specializeTemplateBindings(templateBindings, templateSignatures, csTemplateBindings);
		}
		return specializedPivotElement;
	}

	/**
	 * Sequence the update passes to make the pivot match the CS.
	 */
	public boolean update(@NonNull BaseCSResource csResource) {
		resetPivotMappings(csResource);
		oldPackagesByName = new HashMap<String, org.eclipse.ocl.pivot.Package>();
		oldPackagesByQualifiedName = new HashMap<String, org.eclipse.ocl.pivot.Package>();
		ASResource asResource = converter.csi2asMapping.getASResource(csResource);
		boolean wasUpdating = false;
		if (asResource != null) {
			asResource.resetLUSSIDs();			// Hopefully reset already, not wanted till save. See Bug 579052.
			for (EObject eObject : asResource.getContents()) {
				if (eObject instanceof Model) {
					List<org.eclipse.ocl.pivot.Package> nestedPackage = ((Model)eObject).getOwnedPackages();
					gatherOldPackages(nestedPackage);
				}
			}
		}
		List<BasicContinuation<?>> continuations = new ArrayList<BasicContinuation<?>>();
		//
		//	Perform the post-order containment traversal to:
		//
		//	Create the Piviotable.pivot elements for all 1:1 CS to pivot relationships.
		//	Create the parent-child containment hierarchy.
		//	Configure derived CS properties such as PathNameCS.elementType
		//	Queue continuations to compute simple references
		//
		//	The containment pass may only access the pivot elements of immediate children.
		//
		for (EObject eObject : csResource.getContents()) {
			if (eObject instanceof ElementCS) {
				visitContainment((ElementCS)eObject, continuations);
			}
		}
		//
		//	Put all orphan root pivot elements in their resources.
		//
		installRootContents(csResource);
		//
		//
		//
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				boolean hasNoErrors = checkForNoErrors(csResource);
				if (!hasNoErrors) {
					return false;
				}
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Perform the pre-order traversal to resolve specializations and references.
		//
		for (EObject eObject : csResource.getContents()) {
			if (eObject instanceof ElementCS) {
				visitInPreOrder((ElementCS)eObject, continuations);
			}
		}
		//
		//	Perform pre-order continuations to establish package, class containment and classifier template signatures.
		//
		//		Collections.reverse(continuations);
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				boolean hasNoErrors = checkForNoErrors(csResource);
				if (!hasNoErrors) {
					return false;
				}
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Load the library.
		//
		@SuppressWarnings("unused")
		AnyType oclAnyType = metamodelManager.getStandardLibrary().getOclAnyType();
		//
		//	Perform the post-order traversal to create and install the bulk of non-package/class
		//	elements.
		//
		for (EObject eObject : csResource.getContents()) {
			if (eObject instanceof ElementCS) {
				visitInPostOrder((ElementCS)eObject, continuations);
			}
		}
		boolean hasNoErrors = checkForNoErrors(csResource);
		if (!hasNoErrors) {
			return false;
		}
		//
		//	Perform post-order continuations to establish complex dependencies.
		//
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Put all orphan root pivot elements in their resources.
		//
		installRootContents(csResource);		// FIXME ExpressionInOCL very late
		converter.installRootContents(csResource);		// FIXME Bug 548500 workaround
		//
		boolean hasNoMoreErrors = checkForNoErrors(csResource);
		if (!hasNoMoreErrors) {
			return false;
		}
		//
		//	Prune obsolete packages
		//
		Set<org.eclipse.ocl.pivot.Package> newPackages = new HashSet<org.eclipse.ocl.pivot.Package>();
		gatherNewPackages(newPackages, csResource);
		Set<org.eclipse.ocl.pivot.Package> obsoletePackages = new HashSet<org.eclipse.ocl.pivot.Package>(oldPackagesByQualifiedName.values());
		//		for (org.eclipse.ocl.pivot.Package oldPackage : obsoletePackages) {
		//			System.out.println("Old package @" + Integer.toHexString(oldPackage.hashCode()) + " " + oldPackage.eResource().getURI() + " " + oldPackage.getName());
		//		}
		//		for (org.eclipse.ocl.pivot.Package newPackage : newPackages) {
		//			System.out.println("New package @" + Integer.toHexString(newPackage.hashCode()) + " " + newPackage.eResource().getURI() + " " + newPackage.getName());
		//		}
		obsoletePackages.removeAll(newPackages);
		for (org.eclipse.ocl.pivot.Package obsoletePackage : obsoletePackages) {
			EObject eContainer = obsoletePackage.eContainer();
			if (eContainer != null) {
				EReference eContainmentFeature = obsoletePackage.eContainmentFeature();
				if (eContainmentFeature.isMany()) {
					List<?> siblings = (List<?>) eContainer.eGet(eContainmentFeature);
					//					System.out.println("Kill package @" + Integer.toHexString(obsoletePackage.hashCode()) + " " + obsoletePackage.eResource().getURI() + " " + obsoletePackage.getName());
					siblings.remove(obsoletePackage);
				}
				else {
					eContainer.eSet(eContainmentFeature, null);
				}
			}
		}
		if (asResource == null) {
			asResource = converter.csi2asMapping.getASResource(csResource);
			assert asResource != null;
		}
		asResource.setUpdating(wasUpdating);
		return true;
	}

	protected void visitContainment(@NonNull ElementCS csElement, @NonNull List<BasicContinuation<?>> continuations) {
		for (EObject eContent : csElement.eContents()) {
			if (eContent instanceof ElementCS) {
				visitContainment((ElementCS) eContent, continuations);
			}
		}
		try {
			Continuation<?> continuation = csElement.accept(containmentVisitor);
			if (continuation != null) {
				continuation.addTo(continuations);
			}
		} catch (IllegalLibraryException e) {
			@SuppressWarnings("null")@NonNull String message = e.getMessage();
			addError(csElement, message);
		} catch (Throwable e) {
			if (!hasFailed) {
				hasFailed = true;
				e.fillInStackTrace();
				logger.error("Conversion failed for '" + csElement.eClass().getName() + "'\n" + csElement, e);
				@NonNull String message = String.valueOf(e) + " - see error log for details";
				addError(csElement, message);
			}
			else {
				@NonNull String message = String.valueOf(e);
				addError(csElement, message);
			}
		}
	}

	protected void visitInPostOrder(@NonNull ElementCS csElement, @NonNull List<BasicContinuation<?>> continuations) {
		for (EObject eContent : csElement.eContents()) {
			if (eContent instanceof ElementCS) {
				visitInPostOrder((ElementCS) eContent, continuations);
			}
		}
		try {
			Continuation<?> continuation = csElement.accept(postOrderVisitor);
			if (continuation != null) {
				continuation.addTo(continuations);
			}
		} catch (Throwable e) {
			@NonNull String message = String.valueOf(e);
			addError(csElement, message);
		}
	}

	protected void visitInPreOrder(@NonNull ElementCS csElement, @NonNull List<BasicContinuation<?>> continuations) {
		try {
			Continuation<?> continuation = csElement.accept(preOrderVisitor);
			if (continuation != null) {
				continuation.addTo(continuations);
			}
		} catch (Throwable e) {
			@NonNull String message = String.valueOf(e);
			addError(csElement, message);
		}
		for (EObject eContent : csElement.eContents()) {
			if (eContent instanceof ElementCS) {
				visitInPreOrder((ElementCS) eContent, continuations);
			}
		}
	}

	public <T extends Element> @Nullable T visitLeft2Right(@NonNull Class<T> pivotClass, @NonNull ElementCS csElement) {
		Element element = null;
		try {
			element = csElement.accept(left2RightVisitor);
		} catch (Throwable e) {
			@NonNull String message = String.valueOf(e);
			addError(csElement, message);
		}
		if (element == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(element.getClass())) {
			throw new ClassCastException(element.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}
}
