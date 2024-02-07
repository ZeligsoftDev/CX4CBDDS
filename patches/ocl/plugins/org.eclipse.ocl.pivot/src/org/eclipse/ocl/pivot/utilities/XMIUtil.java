/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.DerivedConstants;

public class XMIUtil
{
	public static interface IdCreator
	{
		/**
		 * Create the id for eObject avoiding any ids in knownIds, which may be null for no exclusions.
		 *
		 * @param eObject
		 * @param knownIds
		 */
		public @Nullable String createId(@NonNull EObject eObject, @NonNull Set<@NonNull String> knownIds);
	}

	/**
	 * Create xmi:id's comprising a unique universal identifier
	 */
	public static class UUIDCreator implements IdCreator
	{
		@Override
		public @Nullable String createId(@NonNull EObject eObject, @NonNull Set<@NonNull String> knownIds) {
			while (true) {
				String uuid = EcoreUtil.generateUUID();
				if (!knownIds.contains(uuid))
					return uuid;
			}
		}
	}

	/**
	 * When registered as an XMLResource.OPTION_RESOURCE_ENTITY_HANDLER save option, an
	 * IdResourceEntityHandler instance allocates sequential numeric XML entities to each distinct
	 * referenced resource URI reducing the XMI file size by perhaps 10%.
	 *
	 * @since 1.12
	 */
	public static class IdResourceEntityHandler implements XMLResource.ResourceEntityHandler
	{
		/**
		 * FIXME Workaround for the missing reset in XMLResource.save.
		 */
		public static void reset(@Nullable Map<?, ?> options) {
			if (options != null) {
				Object resourceEntityHandler = options.get(XMLResource.OPTION_RESOURCE_ENTITY_HANDLER);
				if (resourceEntityHandler instanceof XMLResource.ResourceEntityHandler) {
					((XMLResource.ResourceEntityHandler)resourceEntityHandler).reset();
				}
			}
		}

		private Map<String, String> value2name = new HashMap<>();
		private Map<String, String> name2value = new HashMap<>();

		public IdResourceEntityHandler() {
			super();
		}

		@Override
		public String getEntityName(String entityValue) {
			String entityName = value2name.get(entityValue);
			if (entityName == null) {
				entityName = "_" + value2name.size();			// Entity name must start with an XML letter
				handleEntity(entityName, entityValue);
			}
			return entityName;
		}

		@Override
		public Map<String, String> getNameToValueMap() {
			return name2value;
		}

		@Override
		public void handleEntity(String entityName, String entityValue) {
			name2value.put(entityName, entityValue);
			value2name.put(entityValue, entityName);
		}

		@Override
		public void reset() {
			name2value.clear();
			value2name.clear();
		}
	};

	/**
	 * Create short xmi:id's comprising a prefix and a small random count
	 */
	public static class ShortPrefixedIdCreator implements IdCreator
	{
		protected final @NonNull String prefix;

		public ShortPrefixedIdCreator(@NonNull String prefix) {
			this.prefix = prefix;
		}

		@Override
		public @Nullable String createId(@NonNull EObject eObject, @NonNull Set<@NonNull String> knownIds) {
			int knownSize = knownIds.size();
			for (int multiplier = Math.max(10, 10 * knownSize); true; multiplier *= 10) {
				for (int tries = 0; tries < 10; tries++) {
					String id = prefix + (int)(Math.random() * multiplier);
					if (!knownIds.contains(id))
						return id;
				}
			}
		}
	}

	/**
	 * Create short xmi:id's comprising a prefix and a linearly increasing count
	 */
	public static class LinearPrefixedIdCreator implements IdCreator
	{
		protected final @NonNull String prefix;
		private int next;

		public LinearPrefixedIdCreator(@NonNull String prefix) {
			this.prefix = prefix;
		}

		@Override
		public @Nullable String createId(@NonNull EObject eObject, @NonNull Set<@NonNull String> knownIds) {
			while (true) {
				String id = prefix + ++next;
				if (!knownIds.contains(id))
					return id;
			}
		}
	}

	/**
	 * Create xmi:id's using the same hierarchical/URI fragment algorithm as EMOFResourceImpl
	 */
	public static class HierachicalENamedElementIdCreator implements IdCreator
	{
		public HierachicalENamedElementIdCreator() {}

		@Override
		public @Nullable String createId(@NonNull EObject eObject, @NonNull Set<@NonNull String> knownIds) {
			List<@NonNull String> uriFragmentPath = new ArrayList<>();
			for (EObject container = eObject.eContainer(); container != null; container = eObject.eContainer()) {
				String eURIFragmentSegment = ((InternalEObject)container).eURIFragmentSegment(eObject.eContainmentFeature(), eObject);
				uriFragmentPath.add(eURIFragmentSegment);
				eObject = container;
			}
			StringBuilder result;
			if (eObject instanceof ENamedElement)
				result = new StringBuilder(((ENamedElement)eObject).getName());
			else
				result = new StringBuilder("_" + Integer.toString(eObject.eResource().getContents().indexOf(eObject)));
			for (ListIterator<String> i = uriFragmentPath.listIterator(uriFragmentPath.size()); i.hasPrevious(); ) {
				result.append('.');
				result.append(i.previous());
			}
			return result.toString();
		}
	}

	/**
	 * Create xmi:id's for the structural (EPackage, EClassifier, EStructuralFeature, EEnumLiteral) elements of an Ecore model.
	 * NB. EOperation, EParameter, EGenericType, EAnnotation are deliberately omitted since a deterministic EOperation xmi:id
	 * could be very costly and often of zero utility.
	 *
	 * @since 1.3
	 */
	public static class StructuralENamedElementIdCreator implements IdCreator
	{
		protected static class StructuralENamedElementIdSwitch extends EcoreSwitch<Object>
		{
			private StringBuilder s = null;

			@Override
			public Object caseEClassifier(EClassifier object) {
				return hierarchicalCase(object, "T-");
			}

			@Override
			public Object caseEEnumLiteral(EEnumLiteral object) {
				return hierarchicalCase(object, "L-");
			}

			@Override
			public Object caseEPackage(EPackage object) {
				return hierarchicalCase(object, "P-");
			}

			@Override
			public Object caseEStructuralFeature(EStructuralFeature object) {
				return hierarchicalCase(object, "F-");
			}

			@Override
			public Object defaultCase(EObject object) {
				return null;
			}

			protected Object hierarchicalCase(ENamedElement object, String prefix) {
				if (s == null) {
					s = new StringBuilder();
					s.append(prefix);
				}
				EObject eContainer = object.eContainer();
				if (eContainer != null) {
					doSwitch(eContainer);
					s.append("-");
				}
				s.append(object.getName());
				return null;
			}

			@Override
			public @Nullable String toString() {
				return s != null ? s.toString() : null;
			}
		}

		public StructuralENamedElementIdCreator() {}

		@Override
		public @Nullable String createId(@NonNull EObject eObject, @NonNull Set<@NonNull String> knownIds) {
			StructuralENamedElementIdSwitch idSwitch = new StructuralENamedElementIdSwitch();
			idSwitch.doSwitch(eObject);
			return idSwitch.toString();
		}
	}

	public static interface IdFilter
	{
		public boolean createId(@NonNull EObject eObject);
	}

	public static class ExcludedEClassIdFilter implements IdFilter
	{
		protected final @NonNull Set<@NonNull EClass> excludedClasses;

		public ExcludedEClassIdFilter(@NonNull EClass[] excludedClasses) {
			this.excludedClasses = new HashSet<>();
			for (@NonNull EClass excludedClass : excludedClasses)
				this.excludedClasses.add(excludedClass);
		}

		public ExcludedEClassIdFilter(@NonNull Set<@NonNull EClass> excludedClasses) {
			this.excludedClasses = excludedClasses;
		}

		@Override
		public boolean createId(@NonNull EObject eObject) {
			EClass eClass = eObject.eClass();
			for (@NonNull EClass excludedClass : excludedClasses)
				if (excludedClass.isSuperTypeOf(eClass))
					return false;
			return true;
		}
	}

	public static final UUIDCreator uuidCreator = new UUIDCreator();

	/**
	 * Assign an xmi:id to all objects in resource. A non-null idFilter may choose whether an xmi:id
	 * is assigned. The idCreator is responsible for providing a candidate xmi:id, which, if not unique
	 * will be suffixed until it is.
	 *
	 * @param resource
	 * @param idCreator
	 * @param idFilter
	 */
	public static void assignIds(@NonNull Resource resource, @NonNull IdCreator idCreator, @Nullable IdFilter idFilter) {
		if (!(resource instanceof XMLResource))
			return;
		XMLResource xmlResource = (XMLResource) resource;
		final Set<@NonNull String> knownIds = new HashSet<>(256);  // The XMLResource.getEObjectToIDMap() method is deprecated
		// and the replacement slow since we need a total traversal
		final List<@NonNull EObject> idLess = new ArrayList<>(100);
		for (TreeIterator<EObject> iterator = resource.getAllContents(); iterator.hasNext(); ) {
			EObject eObject = iterator.next();
			assert eObject != null;
			String id = xmlResource.getID(eObject);
			if (id != null) {
				knownIds.add(id);
				//    	        if (eObject instanceof ENamedElement)
				//    	        	System.out.println(id + " ==> " + eObject.eClass().getName() + "." + ((ENamedElement) eObject).getName());
				//    	        else
				//    	        	System.out.println(id + " ==> " + eObject.eClass().getName());
			}
			else if ((idFilter == null) || idFilter.createId(eObject))
				idLess.add(eObject);
		}
		for (@NonNull EObject eObject : idLess) {
			String id = idCreator.createId(eObject, knownIds);
			if (id != null) {
				String uniqueId = id;
				for (int i = 1; knownIds.contains(uniqueId); i++)
					uniqueId = id + '_' + i;
				xmlResource.setID(eObject, uniqueId);
				knownIds.add(uniqueId);
				//    	        if (eObject instanceof ENamedElement)
				//    	        	System.out.println(uniqueId + " --> " + eObject.eClass().getName() + "." + ((ENamedElement) eObject).getName());
				//    	        else
				//    	        	System.out.println(uniqueId + " --> " + eObject.eClass().getName());
			}
		}
	}

	@SuppressWarnings("null")
	public static void assignIds(@NonNull Resource resource, @Nullable String xmiIdPrefix) {
		if (xmiIdPrefix == null)
			xmiIdPrefix = "_";
		assignIds(resource,
			new ShortPrefixedIdCreator(xmiIdPrefix),
			new ExcludedEClassIdFilter(new @NonNull EClass[]
					{
				XMLTypePackage.Literals.ANY_TYPE,
				EcorePackage.Literals.EGENERIC_TYPE/*,
	    				EcorePackage.Literals.EANNOTATION,
	    				EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY */
					}));
	}

	@SuppressWarnings("null")
	public static void assignLinearIds(@NonNull Resource resource, @Nullable String xmiIdPrefix) {
		if (xmiIdPrefix == null)
			xmiIdPrefix = "_";
		assignIds(resource,
			new LinearPrefixedIdCreator(xmiIdPrefix),
			new ExcludedEClassIdFilter(new @NonNull EClass[]
					{
				XMLTypePackage.Literals.ANY_TYPE,
				EcorePackage.Literals.EGENERIC_TYPE/*,
	    				EcorePackage.Literals.EANNOTATION,
	    				EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY */
					}));
	}

	/**
	 * Return the saveOptions for a pivot resource, supporting UTF-8 with 132 character Unix lines
	 * and using entities to compress URIs.
	 *
	 * @since 1.15
	 */
	public static @NonNull Map<Object, Object> createPivotSaveOptions() {
		Map<Object, Object> saveOptions =createSaveOptions();
		saveOptions.put(XMLResource.OPTION_RESOURCE_ENTITY_HANDLER, new IdResourceEntityHandler());
		return saveOptions;
	}

	/**
	 * Return a set of saveOptions supporting UTF-8 with 132 character Unix lines.
	 *
	 * NB These preferences must not be used when saving a standard resource such as a *.ecore
	 * to avoid incompatibilities between rival savers. See Bug 573923.
	 *
	 * @deprecated supply resurce argument so that custom resources use their cu
	 * +stom save options.
	 */
	@Deprecated
	public static @NonNull Map<Object, Object> createSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(DerivedConstants.RESOURCE_OPTION_LINE_DELIMITER, "\n");
		saveOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		return saveOptions;
	}

	/**
	 * Return a set of saveOptions for aResource. For generic XMLResourceImpl or XMIResourceImpl
	 * resources returns saveOptions supporting UTF-8 with 132 character Unix lines. Otherwise returns
	 * a copyof aResource's defaultSaveOptions.
	 *
	 * @since 1.15
	 */
	public static @NonNull Map<Object, Object> createSaveOptions(@NonNull XMLResource aResource) {
		Class<?> resourceClass = aResource.getClass();
		if ((resourceClass == XMIResourceImpl.class) || (resourceClass == XMLResourceImpl.class)) {
			return createSaveOptions();
		}
		else {
			return new HashMap<>(aResource.getDefaultSaveOptions());
		}
	}

	/**
	 * Return a mapping from all EObjects within xmlResource to their xmi:id or null if no xmi:ids assigned.
	 *
	 * @since 1.3
	 */
	public static @Nullable Map<@NonNull EObject, @NonNull String> getIds(@NonNull XMLResource xmlResource) {
		Map<@NonNull EObject, @NonNull String> eObject2xmiId = null;
		for (EObject eObject : new TreeIterable(xmlResource)) {
			assert eObject != null;
			String xmiId = xmlResource.getID(eObject);
			if (xmiId != null) {
				if (eObject2xmiId == null) {
					eObject2xmiId = new HashMap<>();
				}
				eObject2xmiId.put(eObject,  xmiId);
			}
		}
		return eObject2xmiId;
	}

	/**
	 * Adjust saveOptions to use the line width from xmlResource if there is one.
	 * @since 1.8
	 */
	public static void retainLineWidth(Map<Object, Object> saveOptions, Resource resource) {
	    if ((saveOptions != null) && (resource instanceof XMLResource)) {
	    	Object lineWidth = ((XMLResource)resource).getDefaultSaveOptions().get(XMLResource.OPTION_LINE_WIDTH);
			if (lineWidth != null) {
				saveOptions.put(XMLResource.OPTION_LINE_WIDTH, lineWidth);
			}
	    }
	}

	/**
	 * Assign the xmi:ids to the EObjects within xmlResource.
	 *
	 * @since 1.3
	 */
	public static void setIds(@NonNull XMLResource xmlResource, @NonNull Map<@NonNull EObject, @NonNull String> eObject2xmiId) {
		for (Map.Entry<@NonNull EObject, @NonNull String> entry : eObject2xmiId.entrySet()) {
			xmlResource.setID(entry.getKey(), entry.getValue());
		}
	}
}
