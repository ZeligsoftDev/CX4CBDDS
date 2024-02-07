/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.TupleTypeImpl;
import org.eclipse.ocl.pivot.internal.TypedElementImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

/**
 * TupleTypeManager encapsulates the knowledge about known tuple types.
 */
public class TupleTypeManager
{
	protected static class TupleIdResolver extends PivotIdResolver
	{
		private final TemplateParameterReferencesVisitor referencesVisitor;

		private TupleIdResolver(@NonNull EnvironmentFactoryInternal environmentFactory,
				TemplateParameterReferencesVisitor referencesVisitor) {
			super(environmentFactory);
			this.referencesVisitor = referencesVisitor;
		}

		@Override
		public @NonNull Element visitTemplateParameterId(@NonNull TemplateParameterId id) {
			int index = id.getIndex();
			TemplateParameter templateParameter = referencesVisitor.templateParameters.get(index);
			if (templateParameter != null) {
				return templateParameter;
			}
			return super.visitTemplateParameterId(id);
		}
	}

	/**
	 * TuplePart provides a convenient descriptor for a tuple part complying with the full EMF model protocols.
	 */
	public static class TuplePart extends TypedElementImpl
	{
		protected final @NonNull TuplePartId partId;

		public TuplePart(@NonNull TuplePartId partId) {
			this.partId = partId;
			setName(partId.getName());
		}

		@Override
		public @NonNull TypeId getTypeId() {
			return partId.getTypeId();
		}

		@Override
		public String toString() {
			return String.valueOf(name) + " : " + String.valueOf(type);
		}
	}

	/**
	 * The TemplateParameterReferencesVisitor remembers the formal TemplateParameter for re-uyse during Tuple instantiation.
	 */
	protected static class TemplateParameterReferencesVisitor extends TemplateParameterSubstitutionVisitor
	{
		protected final @NonNull Map<@NonNull Integer, @NonNull TemplateParameter> templateParameters = new HashMap<>();

		public TemplateParameterReferencesVisitor(@NonNull EnvironmentFactoryInternal environmentFactory, Collection<? extends Type> partValues) {
			super(environmentFactory, null, null);
			for (Type partValue : partValues) {
				analyzeType(partValue, partValue);
			}
		}

		@Override
		public @NonNull Type put(@NonNull TemplateParameter formalTemplateParameter, @NonNull Type actualType) {
			templateParameters.put(formalTemplateParameter.getTemplateParameterId().getIndex(), formalTemplateParameter);
			return super.put(formalTemplateParameter, actualType);
		}
	}

	protected final @NonNull CompleteEnvironmentInternal completeEnvironment;
	protected final @NonNull PivotMetamodelManager metamodelManager;
	protected final org.eclipse.ocl.pivot.@NonNull Class oclTupleType;

	/**
	 * Map from the tuple typeId to the tuple type.
	 */
	private @Nullable Map<@NonNull TupleTypeId, @NonNull TupleType> tupleid2tuple = null;

	public TupleTypeManager(@NonNull CompleteEnvironmentInternal allCompleteClasses) {
		this.completeEnvironment = allCompleteClasses;
		this.metamodelManager = allCompleteClasses.getEnvironmentFactory().getMetamodelManager();
		this.oclTupleType = metamodelManager.getStandardLibrary().getOclTupleType();
	}

	public void dispose() {
		tupleid2tuple = null;
	}

	public @Nullable Type getCommonType(@NonNull TupleType leftType, @NonNull TemplateParameterSubstitutions leftSubstitutions,
			@NonNull TupleType rightType, @NonNull TemplateParameterSubstitutions rightSubstitutions) {
		List<Property> leftProperties = leftType.getOwnedProperties();
		List<Property> rightProperties = rightType.getOwnedProperties();
		int iSize = leftProperties.size();
		if (iSize != rightProperties.size()) {
			return null;
		}
		List<@NonNull TuplePartId> commonPartIds = new ArrayList<>(iSize);
		for (int i = 0; i < iSize; i++) {
			Property leftProperty = leftProperties.get(i);
			if (leftProperty == null) {
				return null;				// Never happens
			}
			String name = leftProperty.getName();
			if (name == null) {
				return null;				// Never happens
			}
			Property rightProperty = NameUtil.getNameable(rightProperties, name);
			if (rightProperty == null) {
				return null;				// Happens for inconsistent tuples
			}
			Type leftPropertyType = leftProperty.getType();
			if (leftPropertyType == null) {
				return null;				// Never happens
			}
			Type rightPropertyType = rightProperty.getType();
			if (rightPropertyType == null) {
				return null;				// Never happens
			}
			Type commonType = metamodelManager.getCommonType(leftPropertyType, leftSubstitutions, rightPropertyType, rightSubstitutions);
			TuplePartId commonPartId = IdManager.getTuplePartId(i, name, commonType.getTypeId());
			commonPartIds.add(commonPartId);
		}
		TupleTypeId commonTupleTypeId = IdManager.getTupleTypeId(TypeId.TUPLE_NAME, commonPartIds);
		return getTupleType(metamodelManager.getEnvironmentFactory().getIdResolver(), commonTupleTypeId);
	}

	public @NonNull TupleType getTupleType(@NonNull IdResolver idResolver, @NonNull TupleTypeId tupleTypeId) {
		Map<@NonNull TupleTypeId, @NonNull TupleType> tupleid2tuple2 = tupleid2tuple;
		if (tupleid2tuple2 == null) {
			synchronized (this) {
				tupleid2tuple2 = tupleid2tuple;
				if (tupleid2tuple2 == null) {
					tupleid2tuple2 = tupleid2tuple = new HashMap<>();
				}
			}
		}
		TupleType tupleType = tupleid2tuple2.get(tupleTypeId);
		if (tupleType == null) {
			synchronized (tupleid2tuple2) {
				tupleType = tupleid2tuple2.get(tupleTypeId);
				if (tupleType == null) {
					tupleType = new TupleTypeImpl(tupleTypeId);
					@NonNull TuplePartId[] partIds = tupleTypeId.getPartIds();
					List<Property> ownedAttributes = tupleType.getOwnedProperties();
					for (@NonNull TuplePartId partId : partIds) {
						Type partType = idResolver.getType(partId.getTypeId());
						Type partType2 = metamodelManager.getPrimaryType(partType);
						Property property = PivotUtil.createProperty(NameUtil.getSafeName(partId), partType2);
						ownedAttributes.add(property);
					}
					tupleType.getSuperClasses().add(oclTupleType);
					tupleid2tuple2.put(tupleTypeId, tupleType);
					completeEnvironment.addOrphanClass(tupleType);
				}
			}
		}
		return tupleType;
	}

	public @NonNull TupleType getTupleType(@NonNull String tupleName, @NonNull Collection<@NonNull? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions usageBindings) {
		Map<@NonNull String, @NonNull Type> partMap = new HashMap<>();
		for (@NonNull TypedElement part : parts) {
			Type type1 = part.getType();
			if (type1 != null) {
				Type type2 = metamodelManager.getPrimaryType(type1);
				Type type3 = completeEnvironment.getSpecializedType(type2, usageBindings);
				partMap.put(PivotUtil.getName(part), type3);
			}
		}
		return getTupleType(tupleName, partMap);
	}

	/**
	 * Return the named tuple typeId with the defined parts (which need not be alphabetically ordered).
	 */
	public @NonNull TupleType getTupleType(@NonNull String tupleName, @NonNull Map<@NonNull String, @NonNull ? extends Type> parts) {
		//
		//	Find the outgoing template parameter references
		// FIXME this should be more readily and reliably computed in the caller
		@NonNull Collection<? extends Type> partValues = parts.values();
		final TemplateParameterReferencesVisitor referencesVisitor = new TemplateParameterReferencesVisitor(metamodelManager.getEnvironmentFactory(), partValues);	// FIXME this isn't realistically extensible
		//
		//	Create the tuple part ids
		//
		int partsCount = parts.size();
		@NonNull TuplePartId[] newPartIds = new @NonNull TuplePartId[partsCount];
		List<@NonNull String> sortedPartNames = new ArrayList<>(parts.keySet());
		Collections.sort(sortedPartNames);
		for (int i = 0; i < partsCount; i++) {
			@NonNull String partName = sortedPartNames.get(i);
			Type partType = parts.get(partName);
			if (partType != null) {
				TypeId partTypeId = partType.getTypeId();
				TuplePartId tuplePartId = IdManager.getTuplePartId(i, partName, partTypeId);
				newPartIds[i] = tuplePartId;
			}
		}
		//
		//	Create the tuple type id (and then specialize it)
		//
		TupleTypeId tupleTypeId = IdManager.getOrderedTupleTypeId(tupleName, newPartIds);
		PivotIdResolver pivotIdResolver = new TupleIdResolver(metamodelManager.getEnvironmentFactory(), referencesVisitor);
		//
		//	Finally create the (specialize) tuple type
		//
		TupleType tupleType = getTupleType(pivotIdResolver /*metamodelManager.getIdResolver()*/, tupleTypeId);
		return tupleType;
	}

	public @NonNull TupleType getTupleType(@NonNull TupleType type, @Nullable TemplateParameterSubstitutions usageBindings) {	// FIXME Remove duplication, unify type/multiplicity
		//		return getTupleType(type.getName(), type.getOwnedAttribute(), usageBindings);
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		List<Property> parts = specializedTupleType.getOwnedProperties();
		for (Property part : parts) {
			if (part != null) {
				Type propertyType = PivotUtilInternal.getType(part);
				Type resolvedPropertyType = completeEnvironment.getSpecializedType(propertyType, usageBindings);
				if (resolvedPropertyType != propertyType) {
					if (resolutions == null) {
						resolutions = new HashMap<>();
					}
					resolutions.put(NameUtil.getSafeName(part), resolvedPropertyType);
				}
			}
		}
		if (resolutions != null) {
			List<@NonNull TuplePartId> partIds = new ArrayList<>(parts.size());
			for (int i = 0; i < parts.size(); i++) {
				@SuppressWarnings("null") @NonNull Property part = parts.get(i);
				String partName = NameUtil.getSafeName(part);
				Type resolvedPropertyType = resolutions.get(partName);
				TypeId partTypeId = resolvedPropertyType != null ? resolvedPropertyType.getTypeId() : part.getTypeId();
				TuplePartId tuplePartId = IdManager.getTuplePartId(i, partName, partTypeId);
				partIds.add(tuplePartId);
			}
			TupleTypeId tupleTypeId = IdManager.getTupleTypeId(ClassUtil.nonNullModel(type.getName()), partIds);
			specializedTupleType = getTupleType(metamodelManager.getEnvironmentFactory().getIdResolver(), tupleTypeId);
			return specializedTupleType;
		}
		else {
			return getTupleType(NameUtil.getSafeName(type), ClassUtil.nullFree(type.getOwnedProperties()), usageBindings);
		}
	}
}