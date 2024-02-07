/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AnnotationElementCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.DocumentationCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LambdaTypeCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;

public class BaseCSPostOrderVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, @NonNull CS2ASConversion>
{
	public static class ListCompletion<CST extends ModelElementCS, P extends NamedElement> extends MultipleContinuation<CST>
	{
		protected final @NonNull Class<P> pivotClass;
		protected final List<P> pivotElements;

		protected ListCompletion(@NonNull CS2ASConversion context, NamedElement pivotParent, EStructuralFeature pivotFeature,
				@NonNull List<? extends CST> csElements, @NonNull Dependency @NonNull [] dependencies, @NonNull Class<P> pivotClass, List<P> pivotElements) {
			super(context, pivotParent, pivotFeature, csElements, dependencies);
			this.pivotClass = pivotClass;
			this.pivotElements = pivotElements;
		}

		@Override
		public BasicContinuation<?> execute() {
			context.refreshPivotList(pivotClass, pivotElements, csElement);
			return null;
		}
	}

	protected final @NonNull PivotMetamodelManager metamodelManager;

	/**
	 * Construction helper.
	 */
	protected final @NonNull PivotHelper helper;

	public BaseCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
		this.metamodelManager= context.getMetamodelManager();
		this.helper = context.getHelper();
	}

	protected @Nullable TemplateableElementCS getTemplateableElementContainer(@NonNull ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer())
			if (eObject instanceof TemplateableElementCS) {
				return (TemplateableElementCS) eObject;
			}
		return null;
	}

	protected <@NonNull CST extends ModelElementCS, P extends NamedElement> BasicContinuation<?> refreshList(@NonNull NamedElement pivotParent, @NonNull EStructuralFeature pivotFeature,
			final @NonNull Class<P> pivotClass, final @NonNull List<P> pivotElements, @NonNull List<CST> csElements) {
		if (csElements.isEmpty()) {
			context.refreshPivotList(pivotClass, pivotElements, csElements);
			return null;
		}
		else {
			return new ListCompletion<CST, P>(context, pivotParent, pivotFeature, csElements,
					new @NonNull Dependency[]{new PivotDependencies(csElements)}, pivotClass, pivotElements);
		}
	}

	@Override
	public Continuation<?> visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2AS PostOrder pass");
	}

	@Override
	public Continuation<?> visitAnnotationCS(@NonNull AnnotationCS csAnnotation) {
		Annotation pivotElement = PivotUtil.getPivot(Annotation.class, csAnnotation);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csAnnotation, pivotElement);
			context.refreshPivotList(Detail.class, pivotElement.getOwnedDetails(), csAnnotation.getOwnedDetails());
			context.refreshPivotList(Element.class, pivotElement.getOwnedContents(), csAnnotation.getOwnedContents());
			List<ModelElementRefCS> csReferences = csAnnotation.getOwnedReferences();
			if (csReferences.size() > 0) {
				List<Element> references = new ArrayList<Element>(csReferences.size());
				for (ModelElementRefCS csReference : csReferences) {
					Element element = csReference.getReferredElement();
					if (element != null) {
						references.add(element);
					}
				}
				helper.refreshList(pivotElement.getReferences(), references);
			}
			else {
				pivotElement.getReferences().clear();
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationElementCS(@NonNull AnnotationElementCS csAnnotationElement) {
		return null;
	}

	@Override
	public Continuation<?> visitClassCS(@NonNull ClassCS csClassifier) {
		org.eclipse.ocl.pivot.Class pivotElement = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csClassifier);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csClassifier, pivotElement);
			context.refreshPivotList(Constraint.class, pivotElement.getOwnedInvariants(), csClassifier.getOwnedConstraints());
		}
		return null;
	}

	@Override
	public Continuation<?> visitDetailCS(@NonNull DetailCS csDetail) {
		Detail pivotElement = PivotUtil.getPivot(Detail.class, csDetail);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csDetail, pivotElement);
			//			refreshPivotList(Detail.class, pivotElement.getOwnedDetail(), csDocumentation.getOwnedDetail());
			List<String> newValues = csDetail.getValues();
			List<String> pivotValues = pivotElement.getValues();
			pivotValues.clear();
			pivotValues.addAll(newValues);
		}
		return null;
	}

	@Override
	public Continuation<?> visitDocumentationCS(@NonNull DocumentationCS csDocumentation) {
		Annotation pivotElement = PivotUtil.getPivot(Annotation.class, csDocumentation);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csDocumentation, pivotElement);
			context.refreshPivotList(Detail.class, pivotElement.getOwnedDetails(), csDocumentation.getOwnedDetails());
		}
		return null;
	}

	@Override
	public Continuation<?> visitElementCS(@NonNull ElementCS csElement) {
		return visiting(csElement);
	}

	@Override
	public Continuation<?> visitImportCS(@NonNull ImportCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementCS(@NonNull ModelElementCS csModelElement) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS object) {
		Element element = object.getOwnedPathName().getReferredElement();
		if (element != null) {
			context.installPivotReference(object, element, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitNamedElementCS(@NonNull NamedElementCS csNamedElement) {
		NamedElement pivotElement = PivotUtil.getPivot(NamedElement.class, csNamedElement);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csNamedElement, pivotElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperationCS(@NonNull OperationCS csElement) {
		Operation pivotOperation = PivotUtil.getPivot(Operation.class, csElement);
		if (pivotOperation != null) {
			context.refreshList(Type.class, ClassUtil.<Type>nullFree(pivotOperation.getRaisedExceptions()), csElement.getOwnedExceptions());
			TypedRefCS ownedType = csElement.getOwnedType();
			boolean isTypeof = false;
			if (ownedType  instanceof TypedTypeRefCS) {
				isTypeof = ((TypedTypeRefCS)ownedType).isIsTypeof();
			}
			pivotOperation.setIsTypeof(isTypeof);
		}
		return super.visitOperationCS(csElement);
	}

	@Override
	public Continuation<?> visitPackageCS(@NonNull PackageCS csPackage) {
		org.eclipse.ocl.pivot.Package pivotElement = PivotUtil.getPivot(org.eclipse.ocl.pivot.Package.class, csPackage);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csPackage, pivotElement);
		}
		return null;
	}

	@Override
	public @Nullable
	Continuation<?> visitPackageOwnerCS(@NonNull PackageOwnerCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPathElementCS(@NonNull PathElementCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPathNameCS(@NonNull PathNameCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS csPrimitiveTypeRef) {
		return null;
	}

	@Override
	public Continuation<?> visitReferenceCS(@NonNull ReferenceCS csReference) {
		Continuation<?> continuation = super.visitReferenceCS(csReference);
		Property pivotElement = PivotUtil.getPivot(Property.class, csReference);
		if (pivotElement != null) {
			Property pivotOpposite = csReference.getReferredOpposite();
			if ((pivotOpposite != null) && pivotOpposite.eIsProxy()) {
				pivotOpposite = null;
			}
			pivotElement.setOpposite(pivotOpposite);
			helper.refreshList(pivotElement.getKeys(), csReference.getReferredKeys());
			//			BasicContinuation<?> continuation = visitTypedElementCS(csReference);
			//			assert continuation == null;
			List<ImplicitOppositeCS> csOwnedImplicitOpposites = csReference.getOwnedImplicitOpposites();
			if (pivotOpposite != null) {
				if ((csOwnedImplicitOpposites != null) && !csOwnedImplicitOpposites.isEmpty()) {
					context.addWarning(csReference, "Implicit opposites ignored");
				}
			}
			else {
				if ((csOwnedImplicitOpposites != null) && !csOwnedImplicitOpposites.isEmpty()) {
					if (csOwnedImplicitOpposites.size() > 1) {
						context.addWarning(csReference, "Extra implict opposites ignored");
					}
					ImplicitOppositeCS csOwnedImplicitOpposite = csOwnedImplicitOpposites.get(0);
					String oppositeName = csOwnedImplicitOpposite.getName();
					if (oppositeName != null) {
						List<String> qualifiers = csOwnedImplicitOpposite.getQualifiers();
						assert qualifiers !=null;
						boolean isOrdered = ElementUtil.getQualifier(qualifiers, "ordered", "!ordered", PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_ORDERED);		// The Ecore idiom
						boolean isUnique = ElementUtil.getQualifier(qualifiers, "unique", "!unique", PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE);
						Integer lowerValue = null; //ValueUtil.ZERO_VALUE;
						Integer upperValue = null; //ValueUtil.UNLIMITED_ONE_VALUE;
						TypedRefCS csType = csOwnedImplicitOpposite.getOwnedType();
						if (csType != null) {
							MultiplicityCS csMultiplicity = csType.getOwnedMultiplicity();
							if (csMultiplicity != null) {
								lowerValue = csMultiplicity.getLower();
								upperValue = csMultiplicity.getUpper();
							}
						}
						IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) :  PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						if (lower.isInvalid()) {
						//	logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
							lower = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
						}
						UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						if (upper.isInvalid()) {
						//	logger.error("Invalid " + PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
							upper = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
						}
						metamodelManager.createImplicitOppositeProperty(pivotElement, oppositeName,
							isOrdered, isUnique, lower, upper);
					}
				}
				else {
					metamodelManager.installPropertyDeclaration(pivotElement);
				}
			}
		}
		return continuation;
	}

	@Override
	public Continuation<?> visitRootPackageCS(@NonNull RootPackageCS csPackage) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS csTemplateBinding) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterCS(@NonNull TemplateParameterCS csTemplateParameter) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS csTemplateSignature) {
		return null;
	}

	@Override
	public Continuation<?> visitTuplePartCS(@NonNull TuplePartCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS object) {
		return null;
	}

	@Override
	public BasicContinuation<?> visitTypedElementCS(@NonNull TypedElementCS csTypedElement) {
		TypedElement pivotElement = PivotUtil.getPivot(TypedElement.class, csTypedElement);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csTypedElement, pivotElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS object) {
		return null;
	}
}