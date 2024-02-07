/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.Unlimited;

import com.google.common.collect.Iterables;

/**
 * The LUSSIDs class maintains the element to LUSSID and LUSSID to element mapping for the elements
 * of an ASResource. It also privides the ability to return predictable xmi:id values.
 *
 * An xmi:id is provided for every explicitly referenced, and every potentially externally referenced element,
 * so that the fall-back the @x/@y.1 style id referemces is never required.
 *
 * The xmi:id typically comprises a 5 Base64-like letter encoding of the bottom 30 bits of the LUSSID of the element.
 * Additional Base64 letters are occasionally needed to avoid duplicates.
 *
 * The LUSSID (Locally Unique Semantically Sentsitive ID) is the hashcode of the hierarchical path of the element.
 * The resource location, model name and external URI are ignored avoiding dependence on location and URI.
 * Elements within ordered collections use the index, but elements within unordered collections use a further
 * local LUSSID that captures the name / template bindings / parameter names / collection bounds so that LUSSID
 * have substantial tolerance to insignaicant reordering of elements.

 * @since 1.4
 */
public class PivotLUSSIDs extends LUSSIDs
{
	private org.eclipse.ocl.pivot.Package typeOrphanage = null;
	private org.eclipse.ocl.pivot.Class featureOrphanage = null;

	public PivotLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		super(asResource, options);
		for (EObject eRoot : asResource.getContents()) {
			if (eRoot instanceof Model) {
				for (org.eclipse.ocl.pivot.Package asPackage : ((Model)eRoot).getOwnedPackages()) {
					if (Orphanage.isTypeOrphanage(asPackage)) {
						typeOrphanage = asPackage;
						featureOrphanage = NameUtil.getNameable(asPackage.getOwnedClasses(), PivotConstants.ORPHANAGE_NAME);
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * Return the hash of the aspects of element that distinguish it from its siblings.
	 * Return null if there are no distinguishing aspects.
	 */
	@Override
	protected @Nullable Integer computeLocalLUSSID(@NonNull AS2ID as2id, @NonNull EObject element, boolean normalizeTemplateParameters) {
		assert asResource == element.eResource();
		int localId = 0;
		if (!(element instanceof NamedElement)) {
			return null;
		}
		String name = ((NamedElement)element).getName();
		if (name == null) {
			return null;
		}
		localId += name.hashCode();
		if (element instanceof TemplateableElement) {
			int templateIndexMultiplier = TEMPLATE_BINDING_MULTIPLIER;
			for (@NonNull TemplateBinding templateBinding :  PivotUtil.getOwnedBindings((TemplateableElement)element)) {
				for (@NonNull TemplateParameterSubstitution templateParameterSubstitution :  PivotUtil.getOwnedSubstitutions(templateBinding)) {
					Element actual = templateParameterSubstitution.getActual();
					if (actual instanceof WildcardType) {
						localId += templateIndexMultiplier;
					}
					else if (actual instanceof Type) {
						localId += templateIndexMultiplier * computeReferenceLUSSID(as2id, (Type) actual, normalizeTemplateParameters);
					}
					else if (actual != null) {
						localId += templateIndexMultiplier * as2id.assignLUSSID(actual, false, normalizeTemplateParameters);
					}
					templateIndexMultiplier += 2 * TEMPLATE_BINDING_MULTIPLIER;
				}
			}
			if (element instanceof CollectionType) {
				CollectionType collectionType = (CollectionType)element;
				if (!collectionType.isIsNullFree()) {
					localId += COLLECTION_IS_NULL_FREE_MULTIPLIER;
				}
				int lowerValue = collectionType.getLower().intValue();
				if (lowerValue != 0) {
					localId += COLLECTION_LOWER_BOUND_MULTIPLIER * lowerValue;
				}
				Number upper = collectionType.getUpper();
				if (!(upper instanceof Unlimited)) {
					localId += COLLECTION_UPPER_BOUND_MULTIPLIER * upper.intValue();
				}
			}
			else if (element instanceof MapType) {
				MapType mapType = (MapType)element;
				if (!mapType.isKeysAreNullFree()) {
					localId += MAP_KEYS_ARE_NULL_FREE_MULTIPLIER;
				}
				if (!mapType.isValuesAreNullFree()) {
					localId += MAP_VALUES_ARE_NULL_FREE_MULTIPLIER;
				}
			}
			else if (element instanceof LambdaType) {
				LambdaType lambdaType = (LambdaType)element;
				localId += LAMBDA_TYPE_CONTEXT_MULTIPLIER * computeReferenceLUSSID(as2id, PivotUtil.getContextType(lambdaType), normalizeTemplateParameters);
				int lambdaTypeParameterTypeMultiplier = LAMBDA_TYPE_PARAMETER_TYPE_MULTIPLIER;
				for (@NonNull Type parameterType :  PivotUtil.getParameterType(lambdaType)) {
					localId += lambdaTypeParameterTypeMultiplier * computeReferenceLUSSID(as2id, parameterType, normalizeTemplateParameters);
					lambdaTypeParameterTypeMultiplier += SIBLING_INDEX_MULTIPLIER * LAMBDA_TYPE_PARAMETER_TYPE_MULTIPLIER;
				}
				localId += LAMBDA_TYPE_RETURN_TYPE_MULTIPLIER * computeReferenceLUSSID(as2id, PivotUtil.getResultType(lambdaType), normalizeTemplateParameters);
			}
			else if (element instanceof Iteration) {
				Iterable<@NonNull Parameter> parameters = Iterables.concat(PivotUtil.getOwnedIterators((Iteration)element), PivotUtil.getOwnedAccumulators((Iteration)element));
				localId += computeParametersLUSSID(as2id, parameters);
			}
			else if (element instanceof Operation) {
				localId += computeParametersLUSSID(as2id, PivotUtil.getOwnedParameters((Operation)element));
			}
		}
		else if (element instanceof Property) {
			Property property = (Property)element;
			if (property.isIsImplicit()) {
				Property oppositeProperty = property.getOpposite();
				if (oppositeProperty != null) {
					String oppositeName = oppositeProperty.getName();
					if (oppositeName != null) {
						localId += OPPOSITE_PROPERTY_NAME_MULTIPLIER * oppositeName.hashCode();
					}
				}
				else {				// Never happens
					System.out.println("No opposite for " + element);
				}
			}
		}
		return Integer.valueOf(localId);
	}

	protected int computeParametersLUSSID(@NonNull AS2ID as2id, @NonNull Iterable<@NonNull Parameter> parameters) {
		int parametersLUSSID = 0;
		int parameterIndex = 1;
		for (@NonNull Parameter parameter :  parameters) {
			int index = -1;
			Type parameterType = parameter.getType();
			if (parameterType instanceof TemplateParameter) {
				TemplateSignature templateSignature = ((TemplateParameter)parameterType).getOwningSignature();
				if (templateSignature != null) {
					List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
					index = templateParameters.indexOf(parameterType);
				}
			}
			if (index >= 0) {
				parametersLUSSID += parameterIndex * TEMPLATE_PARAMETER_INDEX_MULTIPLIER * (index + 1);
			}
			else if (parameterType != null) {
				parametersLUSSID += parameterIndex * OPERATION_PARAMETER_TYPE_MULTIPLIER * computeReferenceLUSSID(as2id, parameterType, true);
			}
			parameterIndex++;
		}
		return parametersLUSSID;
	}

	protected int computeReferenceLUSSID(@NonNull AS2ID as2id, @NonNull Type type, boolean normalizeTemplateParameters) {
		if (normalizeTemplateParameters && (type instanceof TemplateParameter)) {
			boolean gotIt = false;
			int index = 0;
			for (EObject eContainer = type.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
				if (eContainer instanceof TemplateableElement) {
					TemplateSignature templateSignature = ((TemplateableElement)eContainer).getOwnedSignature();
					if (templateSignature != null) {
						List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
						int localIndex = templateParameters.indexOf(type);
						if (localIndex >= 0) {
							index += localIndex;
							gotIt = true;
						}
						else {
							index += templateParameters.size();
						}
					}
				}
			}
			if (gotIt) {
				return TEMPLATE_PARAMETER_INDEX_MULTIPLIER * index;
			}
		}
		return as2id.assignLUSSID(type, false, true);
	}

	@Override
	protected boolean isExternallyReferenceable(@NonNull EObject eObject) {
		if (eObject instanceof Type) {				// Class, TemplateParameter
		//	if ((typeOrphanage == null) || (eObject.eContainer() != typeOrphanage)) {
				return true;
		//	}
		}
		else if (eObject instanceof org.eclipse.ocl.pivot.Package) {		// Profile
			if (eObject != typeOrphanage) {
				return true;
			}
		}
		else if (eObject instanceof Feature) {		// Iteration, Operation, Property
		//	if ((featureOrphanage == null) || (eObject.eContainer() != featureOrphanage)) {
				return true;
		//	}
		}
		else if (eObject instanceof CollectionLiteralPart) {
			return true;
		}
		else if (eObject instanceof Constraint) {
			return true;
		}
		else if (eObject instanceof EnumerationLiteral) {
			return true;
		}
		else if (eObject instanceof MapLiteralPart) {
			return true;
		}
		else if (eObject instanceof Model) {
			return true;
		}
		else if (eObject instanceof Parameter) {
			return true;
		}
		else if (eObject instanceof ShadowPart) {
			return true;
		}
		else if (eObject instanceof TupleLiteralPart) {
			return true;
		}
		return false;
	}
}