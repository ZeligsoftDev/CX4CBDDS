/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.attributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.manager.OperationArguments;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor.Invocations;

public abstract class AbstractOperationMatcher implements OperationArguments
{
	private static Comparator<@NonNull Operation> operationComparator = new Comparator<@NonNull Operation>()
	{
		@Override
		public int compare(@NonNull Operation o1, @NonNull Operation o2) {
			String n1 = o1.getName();
			String n2 = o2.getName();
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			int diff = n1.compareTo(n2);
			if (diff != 0) {
				return diff;
			}
			List<Parameter> ownedParameters1 = o1.getOwnedParameters();
			List<Parameter> ownedParameters2 = o2.getOwnedParameters();
			int s1 = ownedParameters1.size();
			int s2 = ownedParameters2.size();
			diff = s1 - s2;
			if (diff != 0) {
				return diff;
			}
			for (int i = 0; i < s1; i++) {
				Parameter p1 = ownedParameters1.get(i);
				Parameter p2 = ownedParameters2.get(i);
				n1 = p1.getName();
				n2 = p2.getName();
				if (n1 == null) n1 = "";
				if (n2 == null) n2 = "";
				diff = n1.compareTo(n2);
				if (diff != 0) {
					return diff;
				}
			}
			for (EObject e1 = o1.eContainer(), e2 = o2.eContainer(); (e1 instanceof NamedElement) && (e2 instanceof NamedElement); e1 = e1.eContainer(), e2 = e2.eContainer()) {
				n1 = ((NamedElement)e1).getName();
				n2 = ((NamedElement)e2).getName();
				if (n1 == null) n1 = "";
				if (n2 == null) n2 = "";
				diff = n1.compareTo(n2);
				if (diff != 0) {
					return diff;
				}
			}
			return 0;
		}
	};

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull PivotMetamodelManager metamodelManager;
	protected final @Nullable Type sourceType;
	private @Nullable List<@NonNull Operation> ambiguities = null;

	protected AbstractOperationMatcher(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type sourceType, @Nullable Type sourceTypeValue) {
		this.environmentFactory = environmentFactory;
		this.metamodelManager = environmentFactory.getMetamodelManager();
		this.sourceType = sourceType;// != null ? PivotUtil.getBehavioralType(sourceType) : null;		// FIXME redundant
		// assert sourceTypeValue == null;			// Bug 580791 Enforcing redundant argument
	}

	protected int compareMatches(@NonNull Object match1, @NonNull TemplateParameterSubstitutions referenceBindings,
			@NonNull Object match2, @NonNull TemplateParameterSubstitutions candidateBindings, boolean useCoercions) {
		CompleteModelInternal completeModel = environmentFactory.getCompleteModel();
		@NonNull Operation reference = (Operation) match1;
		@NonNull Operation candidate = (Operation) match2;
		org.eclipse.ocl.pivot.Class referenceClass = reference.getOwningClass();
		org.eclipse.ocl.pivot.Class candidateClass = candidate.getOwningClass();
		Type referenceType = referenceClass;// != null ? PivotUtil.getBehavioralType(referenceClass) : null;
		Type candidateType = candidateClass;// != null ? PivotUtil.getBehavioralType(candidateClass) : null;
		Type specializedReferenceType = referenceType != null ? completeModel.getSpecializedType(referenceType, referenceBindings) : null;
		Type specializedCandidateType = candidateType != null ? completeModel.getSpecializedType(candidateType, candidateBindings) : null;
		if ((reference instanceof Iteration) && (candidate instanceof Iteration) && (specializedReferenceType != null) && (specializedCandidateType != null)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterators().size() - ((Iteration)reference).getOwnedIterators().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			if (referenceType != candidateType) {
				if (metamodelManager.conformsTo(specializedReferenceType, TemplateParameterSubstitutions.EMPTY, specializedCandidateType, TemplateParameterSubstitutions.EMPTY)) {
					return 1;
				}
				else if (metamodelManager.conformsTo(specializedCandidateType, TemplateParameterSubstitutions.EMPTY, specializedReferenceType, TemplateParameterSubstitutions.EMPTY)) {
					return -1;
				}
			}
		}
		int referenceConversions = 0;
		int candidateConversions = 0;
		Type comparedSourceType = sourceType;
		//		if (comparedSourceType instanceof DomainMetaclass) {
		//			comparedSourceType = ((DomainMetaclass)comparedSourceType).getInstanceType();
		//		}
		if (comparedSourceType != specializedReferenceType) {
			referenceConversions++;
		}
		if (comparedSourceType != specializedCandidateType) {
			candidateConversions++;
		}
		List<@NonNull Parameter> candidateParameters = PivotUtilInternal.getOwnedParametersList(candidate);
		List<@NonNull Parameter> referenceParameters = PivotUtilInternal.getOwnedParametersList(reference);
		for (int i = 0; i < candidateParameters.size(); i++) {
			OCLExpression pivotArgument = getArgument(i);
			Type argumentType = pivotArgument.getType();
			Parameter referenceParameter = referenceParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			referenceType = PivotUtilInternal.getType(referenceParameter);//.behavioralType();
			candidateType = PivotUtilInternal.getType(candidateParameter);//.behavioralType();
			specializedReferenceType = completeModel.getSpecializedType(referenceType, referenceBindings);
			specializedCandidateType = completeModel.getSpecializedType(candidateType, candidateBindings);
			if (argumentType != specializedReferenceType) {
				referenceConversions++;
			}
			if (argumentType != specializedCandidateType) {
				candidateConversions++;
			}
		}
		if (candidateConversions != referenceConversions) {
			return candidateConversions - referenceConversions;
		}
		int verdict = metamodelManager.compareOperationMatches(reference, referenceBindings, candidate, candidateBindings);
		if (verdict != 0) {
			return verdict;
		}
		if (isRedefinitionOf(reference, candidate)) {
			return 1;				// match2 inferior
		}
		if (isRedefinitionOf(candidate, reference)) {
			return -1;				// match1 inferior
		}
		org.eclipse.ocl.pivot.Package p1 = PivotUtil.getContainingPackage(reference);
		org.eclipse.ocl.pivot.Package p2 = PivotUtil.getContainingPackage(candidate);
		if (p1 == null) {
			return 0;
		}
		if (p2 == null) {
			return 0;
		}
		CompletePackage s1 = completeModel.getCompletePackage(p1);
		CompletePackage s2 = completeModel.getCompletePackage(p2);
		if (s1 != s2) {
			return 0;
		}
		int i1 = s1.getIndex(p1);
		int i2 = s2.getIndex(p2);
		int indexDiff = i2 - i1;
		if (indexDiff != 0) {
			return indexDiff;
		}
		if ((specializedReferenceType != null) && (specializedCandidateType != null)) {
			if (metamodelManager.conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
				return 1;
			}
			else if (metamodelManager.conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
				return -1;
			}
		}
		return 0;
	}

	public @Nullable List<@NonNull Operation> getAmbiguities() {
		return ambiguities;
	}

	public @Nullable Operation getBestOperation(@NonNull Invocations invocations, boolean useCoercions) {
		ambiguities = null;
		Operation bestOperation = null;
		TemplateParameterSubstitutions bestBindings = TemplateParameterSubstitutions.EMPTY;
		List<@NonNull Operation> ambiguities2 = ambiguities;
		for (NamedElement namedElement : invocations) {
			if (namedElement instanceof Operation) {
				Operation candidateOperation = (Operation)namedElement;
				TemplateParameterSubstitutions candidateBindings = matches(candidateOperation, useCoercions);
				if (candidateBindings != null) {
					if (bestOperation == null) {
						bestOperation = candidateOperation;
						bestBindings = candidateBindings;
					}
					else {
						int comparison = compareMatches(bestOperation, bestBindings, candidateOperation, candidateBindings, useCoercions);
						if (comparison < 0) {
							bestOperation = candidateOperation;
							bestBindings = candidateBindings;
							ambiguities = null;
						}
						else if (comparison == 0) {
							if (ambiguities2 == null) {
								ambiguities = ambiguities2 = new ArrayList<>();
								ambiguities2.add(bestOperation);
							}
							ambiguities2.add(candidateOperation);
						}
					}
				}
			}
		}
		if (ambiguities2 != null) {
			Collections.sort(ambiguities2, operationComparator);
		}
		return bestOperation;
	}

	protected boolean isRedefinitionOf(@NonNull Operation operation1, @NonNull Operation operation2) {
		Iterable<@NonNull Operation> redefinedOperations = PivotUtil.getRedefinedOperations(operation1);
		for (@NonNull Operation redefinedOperation : redefinedOperations) {
			if (redefinedOperation == operation2) {
				return true;
			}
			if (isRedefinitionOf(redefinedOperation, operation2)) {
				return true;
			}
		}
		return false;
	}

	protected @Nullable TemplateParameterSubstitutions matches(@NonNull Operation candidateOperation, boolean useCoercions) {
		List<@NonNull Parameter> candidateParameters = PivotUtilInternal.getOwnedParametersList(candidateOperation);
		int iSize = getArgumentCount();
		if (iSize != candidateParameters.size()) {
			return null;
		}
		TemplateParameterSubstitutions bindings = TemplateParameterSubstitutionVisitor.createBindings(environmentFactory, sourceType, null, candidateOperation);
		for (int i = 0; i < iSize; i++) {
			Parameter candidateParameter = candidateParameters.get(i);
			OCLExpression expression = getArgument(i);
			Type candidateType = PivotUtilInternal.getType(candidateParameter);
			Type expressionType = PivotUtilInternal.getType(expression);
			if (!metamodelManager.conformsTo(expressionType, TemplateParameterSubstitutions.EMPTY, candidateType, bindings)) {
				boolean coerceable = false;
				if (useCoercions) {
					CompleteClass completeClass = metamodelManager.getCompleteClass(expressionType);
					for (org.eclipse.ocl.pivot.Class partialClass : completeClass.getPartialClasses()) {
						if (partialClass instanceof PrimitiveType) {
							for (Operation coercion : ((PrimitiveType)partialClass).getCoercions()) {
								Type corcedSourceType = coercion.getType();
							//	if ((corcedSourceType != null) && metamodelManager.conformsTo(corcedSourceType, TemplateParameterSubstitutions.EMPTY, candidateType, TemplateParameterSubstitutions.EMPTY)) {
								if ((corcedSourceType != null) && corcedSourceType.conformsTo(metamodelManager.getStandardLibrary(), candidateType)) {
									coerceable = true;
									break;
								}
							}
							if (coerceable) {
								break;
							}
						}
					}
				}
				if (!coerceable) {
					return null;
				}
			}
		}
		return bindings;
	}
}