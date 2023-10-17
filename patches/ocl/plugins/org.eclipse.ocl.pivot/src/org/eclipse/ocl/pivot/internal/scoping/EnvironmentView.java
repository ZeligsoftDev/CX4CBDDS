/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.scoping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * An EnvironmentView provides a selective view of the environment visible at
 * some CS node.
 *
 * The selection corresponds to an Environment lookup method as defined by the
 * OCL specification computed in accordance with the the Inherited Attributes.
 *
 * The selective view is normally for just the single name required by the
 * lookUp, but may be for all names when a Completion Assist is required.
 *
 * The EnvironmentView is computed on demand, rather than cached, since only
 * small parts of the overall environment are needed and caches may not remain
 * valid for long given the rapid recreation of CS nodes that occurs while
 * editing.
 */
public class EnvironmentView
{
	/**
	 * @since 1.7
	 */
	public static class DiagnosticWrappedException extends WrappedException implements Resource.Diagnostic
	{
		private static final long serialVersionUID = 1L;

		public DiagnosticWrappedException(String message, Exception exception)
		{
			super(message, exception);
		}

		public DiagnosticWrappedException(Exception exception)
		{
			super(exception);
		}

		@Override
		public String getLocation()
		{
			return "unknown";			// FIXME
		}

		@Override
		public int getColumn()
		{
			return 0;
		}

		@Override
		public int getLine()
		{
			return 0;
		}
	}

	public static abstract class Disambiguator</*@NonNull*/ T> implements Comparator<T>
	{
		@Override
		public int compare(/*@NonNull*/ T o1, /*@NonNull*/ T o2) {
			throw new UnsupportedOperationException();
		}

		public abstract int compare(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull T o1, @NonNull T o2);
	}

	private static final class ImplicitDisambiguator extends Disambiguator<@NonNull Object>
	{
		@Override
		public int compare(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Object match1, @NonNull Object match2) {
			boolean match1IsImplicit = (match1 instanceof Property) && ((Property)match1).isIsImplicit();
			boolean match2IsImplicit = (match2 instanceof Property) && ((Property)match2).isIsImplicit();
			if (!match1IsImplicit) {
				return match2IsImplicit ? 1 : 0;				// match2 inferior
			}
			else {
				return match2IsImplicit ? 0 : -1;				// match1 inferior
			}
		}
	}

	private static final class MetamodelMergeDisambiguator extends Disambiguator<@NonNull Feature>
	{
		@Override
		public int compare(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Feature match1, @NonNull Feature match2) {
			org.eclipse.ocl.pivot.Package p1 = PivotUtil.getContainingPackage(match1);
			org.eclipse.ocl.pivot.Package p2 = PivotUtil.getContainingPackage(match2);
			if (p1 == null) {
				return 0;
			}
			if (p2 == null) {
				return 0;
			}
			CompleteModel completeModel = environmentFactory.getCompleteModel();
			CompletePackage s1 = completeModel.getCompletePackage(p1);
			CompletePackage s2 = completeModel.getCompletePackage(p2);
			if (s1 != s2) {
				return 0;
			}
			int i1 = s1.getIndex(p1);
			int i2 = s2.getIndex(p2);
			return i2 - i1;
		}
	}

	private static final class OperationDisambiguator extends Disambiguator<@NonNull Operation>
	{
		@Override
		public int compare(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Operation match1, @NonNull Operation match2) {
			if (isRedefinitionOf(match1, match2)) {
				return 1;				// match2 inferior
			}
			if (isRedefinitionOf(match2, match1)) {
				return -1;				// match1 inferior
			}
			return 0;
		}

		protected boolean isRedefinitionOf(@NonNull Operation operation1, @NonNull Operation operation2) {
			List<Operation> redefinedOperations = operation1.getRedefinedOperations();
			for (Operation redefinedOperation : redefinedOperations) {
				if (redefinedOperation != null) {
					if (redefinedOperation == operation2) {
						return true;
					}
					if (isRedefinitionOf(redefinedOperation, operation2)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	private static final class MergedPackageDisambiguator extends Disambiguator<org.eclipse.ocl.pivot.@NonNull Package>
	{
		@Override
		public int compare(@NonNull EnvironmentFactoryInternal environmentFactory, org.eclipse.ocl.pivot.@NonNull Package match1, org.eclipse.ocl.pivot.@NonNull Package match2) {
			CompleteModelInternal completeModel = environmentFactory.getCompleteModel();
			CompletePackageInternal completePackage1 = completeModel.getCompletePackage(match1);
			CompletePackageInternal completePackage2 = completeModel.getCompletePackage(match2);
			if (completePackage1 == completePackage2) {
				return 1;				// match2 inferior
			}
			return 0;
		}
	}

	private static final class PropertyDisambiguator extends Disambiguator<@NonNull Property>
	{
		@Override
		public int compare(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property match1, @NonNull Property match2) {
			if (isRedefinitionOf(match1, match2)) {
				return 1;				// match2 inferior
			}
			if (isRedefinitionOf(match2, match1)) {
				return -1;				// match1 inferior
			}
			//
			//	FIXME There should not be multiple properties, but as a consequence of Bug 510503 we need a fudge.
			//
			Property opposite1 = match1.getOpposite();
			if ((opposite1 != null) && "base_Class".equals(opposite1.getName())) {
				return -1;				// match1 inferior
			}
			Property opposite2 = match2.getOpposite();
			if ((opposite2 != null) && "base_Class".equals(opposite2.getName())) {
				return 1;				// match2 inferior
			}
			/*			org.eclipse.ocl.pivot.Class owningClass1 = match1.getOwningClass();
			org.eclipse.ocl.pivot.Class owningClass2 = match2.getOwningClass();
			if ((owningClass1 != null) && (owningClass2 != null) && (owningClass1 != owningClass2)) {
				StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
				if (owningClass1.conformsTo(standardLibrary, owningClass2)) {
					return 1;				// match2 inferior
				}
				if (owningClass2.conformsTo(standardLibrary, owningClass1)) {
					return -1;				// match1 inferior
				}
			} */
			return 0;
		}

		protected boolean isRedefinitionOf(@NonNull Property property1, @NonNull Property property2) {
			List<Property> redefinedProperties = property1.getRedefinedProperties();
			for (Property redefinedProperty : redefinedProperties) {
				if (redefinedProperty != null) {
					if (redefinedProperty == property2) {
						return true;
					}
					if (isRedefinitionOf(redefinedProperty, property2)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	@SuppressWarnings("serial")
	private static final class MyList extends ArrayList<Object> {}

	private static final Logger logger = LogManager.getLogger(EnvironmentView.class);

	private static @NonNull LinkedHashMap<@NonNull Class<?>, @NonNull List<@NonNull Comparator<@NonNull Object>>> disambiguatorMap =	// FIXME narrow API to Disambiguator
			new LinkedHashMap<>();

	static {
		addDisambiguator(Object.class, new ImplicitDisambiguator());
		addDisambiguator(Feature.class, new MetamodelMergeDisambiguator());
		addDisambiguator(Operation.class, new OperationDisambiguator());
		addDisambiguator(org.eclipse.ocl.pivot.Package.class, new MergedPackageDisambiguator());
		addDisambiguator(Property.class, new PropertyDisambiguator());
	}

	public static synchronized <T> void addDisambiguator(/*@NonNull*/ Class<T> targetClass, @NonNull Comparator<T> disambiguator) {
		assert targetClass != null;
		List<@NonNull Comparator<@NonNull Object>> disambiguators = disambiguatorMap.get(targetClass);
		if (disambiguators == null) {
			disambiguators = new ArrayList<>();
			disambiguatorMap.put(targetClass, disambiguators);
		}
		@SuppressWarnings("unchecked")
		Comparator<@NonNull Object> castDisambiguator = (Comparator<@NonNull Object>) disambiguator;
		disambiguators.add(castDisambiguator);
	}

	public static @NonNull Iterable<@NonNull Class<?>> getDisambiguatorKeys() {
		return disambiguatorMap.keySet();
	}

	public static @Nullable List<@NonNull Comparator<@NonNull Object>> getDisambiguators(@NonNull Class<?> key) {
		return disambiguatorMap.get(key);
	}

	private final @Nullable ParserContext parserContext;		// FIXME only non-null for API compatibility
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull EStructuralFeature reference;
	private EClassifier requiredType;

	/**
	 * True if the required name is qualified. e.g ...::RequiredName
	 */
	private boolean isQualified = false;

	/**
	 * True if the required name qualifies something. e.g ...RequiredName::...
	 */
	private boolean isQualifier = false;
	protected final @Nullable String name;

	private final @NonNull Map<@NonNull String, Object> contentsByName = new HashMap<>(); // Single Object or MyList

	private int contentsSize = 0; // Deep size of contentsByName;

	private List<@NonNull ScopeFilter> matchers = null;	// Prevailing filters for matching

	/**
	 * @since 1.3
	 */
	public EnvironmentView(@NonNull ParserContext parserContext, @NonNull EStructuralFeature reference, @Nullable String name) {
		this.parserContext = parserContext;
		this.environmentFactory = (EnvironmentFactoryInternal)parserContext.getEnvironmentFactory();
		this.reference = reference;
		this.requiredType = reference.getEType();
		this.name = name;
	}

	/**
	 * @deprecated Use ParserContext constructor
	 */
	@Deprecated
	public EnvironmentView(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EStructuralFeature reference, @Nullable String name) {
		this.parserContext = null;
		this.environmentFactory = environmentFactory;
		this.reference = reference;
		this.requiredType = reference.getEType();
		this.name = name;
	}

	public boolean accepts(/*@NonNull*/ EClass eClass) {
		assert eClass != null;
		// If eClass conformsTo requiredType every candidate will be type-compatible
		// If requiredType conformsTo eClass some candidates may be type-compatible
		// else no candidates can be type-compatible
		return (name == null) || PivotUtil.conformsTo(requiredType, eClass) || ((requiredType != null) && PivotUtil.conformsTo(eClass, requiredType));
	}

	public void addAllElements(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull ScopeView scopeView) {
		Attribution attribution = getAttribution(asClass);
		attribution.computeLookup(asClass, this, scopeView);
		org.eclipse.ocl.pivot.Class asUnspecializedClass = PivotUtil.getUnspecializedTemplateableElement(asClass);
		org.eclipse.ocl.pivot.Package asPackage = asUnspecializedClass.getOwningPackage();
		if (asPackage != null) {
			attribution = getAttribution(asPackage);
			attribution.computeLookup(asPackage, this, scopeView);
		}
		{	// FIXME redundant
			asPackage = asUnspecializedClass.getOwningPackage();
			if (asPackage != null) {
				attribution = getAttribution(asPackage);
				attribution.computeLookup(asPackage, this, scopeView);
			}
		}
	}

	public void addAllEnumerationLiterals(org.eclipse.ocl.pivot.Enumeration pivot) {
		if (accepts(PivotPackage.Literals.ENUMERATION_LITERAL)) {
			String name2 = name;
			if (name2 != null) {
				for (EnumerationLiteral literal : pivot.getOwnedLiterals()) {
					if ((literal != null) && name2.equals(literal.getName())) {
						addElement(name2, literal);
					}
				}
			}
			else {
				for (EnumerationLiteral literal : pivot.getOwnedLiterals()) {
					if (literal != null) {
						addNamedElement(literal);
					}
				}
			}
		}
	}

	public void addAllOperations(org.eclipse.ocl.pivot.@NonNull Class type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.ITERATION)		// If ITERATION is acceptable then so too is OPERATION
				&& (requiredType != PivotPackage.Literals.NAMESPACE)) {			// Don't really want operations when looking for NAMESPACE
			assert environmentFactory.getMetamodelManager().isTypeServeable(type);
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			CompleteClass completeClass = environmentFactory.getMetamodelManager().getCompleteClass(type);
			String name2 = name;
			if (name2 != null) {
				for (@NonNull Operation operation : completeClass.getOperations(featureFilter, name2)) {
					//					if ((operation != null) /*&& (operation.isStatic() == selectStatic)*/) {
					addElement(name2, operation);
					//					}
				}
			}
			else {
				for (@NonNull Operation operation : completeClass.getOperations(featureFilter)) {
					//					if ((operation != null) /*&& (operation.isStatic() == selectStatic)*/) {
					addNamedElement(operation);
					//					}
				}
			}
		}
	}

	/**
	 * @since 1.10
	 */
	public void addAllPackages(org.eclipse.ocl.pivot.@NonNull CompletePackage parentCompletePackage) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			String name2 = name;
			if (name2 != null) {
				CompletePackage completePackage = parentCompletePackage.getOwnedCompletePackage(name2);
				if (completePackage != null) {
					addElement(name2, completePackage);
				}
			}
			else {
				for (CompletePackage completePackage : parentCompletePackage.getOwnedCompletePackages()) {
					if (completePackage != null) {
						addNamedElement(completePackage);
					}
				}
			}
		}
	}

	public void addAllPackages(org.eclipse.ocl.pivot.@NonNull Package pkge) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			CompletePackage parentCompletePackage = environmentFactory.getMetamodelManager().getCompletePackage(pkge);
			String name2 = name;
			if (name2 != null) {
				CompletePackage completePackage = parentCompletePackage.getOwnedCompletePackage(name2);
				if (completePackage != null) {
					addElement(name2, completePackage);
				}
			}
			else {
				for (CompletePackage completePackage : parentCompletePackage.getOwnedCompletePackages()) {
					if (completePackage != null) {
						addNamedElement(completePackage);
					}
				}
			}
		}
	}

	public void addAllPackages(@NonNull Model root) {
		if (accepts(PivotPackage.Literals.PACKAGE)) {
			String name2 = name;
			if (name2 != null) {
				for (org.eclipse.ocl.pivot.Package pkge : root.getOwnedPackages()) {
					if ((pkge != null) && name2.equals(pkge.getName())) {
						addElement(name2, pkge);
					}
				}
			}
			else {
				for (org.eclipse.ocl.pivot.Package pkge : root.getOwnedPackages()) {
					if (pkge != null) {
						addNamedElement(environmentFactory.getMetamodelManager().getPrimaryPackage(pkge));
					}
				}
			}
		}
	}

	public void addAllParameters(@NonNull Operation pivot) {
		if (accepts(PivotPackage.Literals.PARAMETER)) {
			String name2 = name;
			if (name2 != null) {
				for (Parameter parameter : pivot.getOwnedParameters()) {
					if (name2.equals(parameter.getName())) {
						addElement(name2, parameter);
					}
				}
			}
			else {
				for (Parameter parameter : pivot.getOwnedParameters()) {
					if (parameter != null) {
						addNamedElement(parameter);
					}
				}
			}
		}
	}

	public void addAllPrecedences(@NonNull Library pivot) {
		if (accepts(PivotPackage.Literals.PRECEDENCE)) {
			String name2 = name;
			if (name2 != null) {
				for (Precedence precedence : pivot.getOwnedPrecedences()) {
					if (name2.equals(precedence.getName())) {
						addElement(name2, precedence);
					}
				}
			}
			else {
				for (Precedence precedence : pivot.getOwnedPrecedences()) {
					if (precedence != null) {
						addNamedElement(precedence);
					}
				}
			}
		}
	}

	public void addAllProperties(org.eclipse.ocl.pivot.@NonNull Class type, @Nullable FeatureFilter featureFilter) {
		if (accepts(PivotPackage.Literals.PROPERTY)
				&& (requiredType != PivotPackage.Literals.NAMESPACE)) {			// Don't really want properties when looking for NAMESPACE
			assert environmentFactory.getMetamodelManager().isTypeServeable(type);
			CompleteClass completeClass = environmentFactory.getMetamodelManager().getCompleteClass(type);
			String name2 = name;
			if (name2 != null) {
				for (@NonNull Property property : completeClass.getProperties(featureFilter, name2)) {
					addNamedElement(property);
				}
			}
			else {
				for (@NonNull Property property : completeClass.getProperties(featureFilter)) {
					addNamedElement(property);
				}
			}
		}
	}

	public void addAllStates(@NonNull Type type) {
		if (accepts(PivotPackage.Literals.STATE)) {
			assert environmentFactory.getMetamodelManager().isTypeServeable(type);
			CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(type);
			String name2 = name;
			if (name2 != null) {
				for (@NonNull State state : completeClass.getStates(name2)) {
					addNamedElement(state);
				}
			}
			else {
				for (@NonNull State state : completeClass.getStates()) {
					addNamedElement(state);
				}
			}
		}
	}

	public void addAllTemplateParameters(@NonNull TemplateableElement pivot) {
		if (accepts(PivotPackage.Literals.TYPE)) {
			TemplateSignature templateSignature = pivot.getOwnedSignature();
			if (templateSignature != null) {
				String name2 = name;
				List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
				if (name2 != null) {
					for (TemplateParameter templateParameter : templateParameters) {
						if ((templateParameter != null) && name2.equals(templateParameter.getName())) {
							addElement(name2, templateParameter);
						}
					}
				}
				else {
					for (TemplateParameter templateParameter : templateParameters) {
						if (templateParameter != null) {
							addNamedElement(templateParameter);
						}
					}
				}
			}
		}
	}

	/**
	 * @since 1.10
	 */
	public void addAllTypes(@NonNull CompletePackage completePackage) {
		if (accepts(PivotPackage.Literals.CLASS)) {
			String name2 = name;
			if (name2 != null) {
				org.eclipse.ocl.pivot.Class type = completePackage.getMemberType(name2);
				if (type != null) {
					addNamedElement(type);
				}
				else {
					completePackage = environmentFactory.getCompleteModel().getPrimitiveCompletePackage();
					type = completePackage.getMemberType(name2);
					if (type != null) {
						addNamedElement(type);
					}
				}
			}
			else {
				for (CompleteClass completeClass : completePackage.getOwnedCompleteClasses()) {
					addNamedElement(completeClass.getPrimaryClass());
				}
				PrimitiveCompletePackage primitiveCompletePackage = environmentFactory.getCompleteModel().getPrimitiveCompletePackage();
				for (CompleteClass completeClass : primitiveCompletePackage.getOwnedCompleteClasses()) {
					addNamedElement(completeClass.getPrimaryClass());
				}
			}
		}
	}

	public void addAllTypes(org.eclipse.ocl.pivot.@NonNull Package pkge) {
		if (accepts(PivotPackage.Literals.CLASS)) {
			CompletePackage completePackage = environmentFactory.getMetamodelManager().getCompletePackage(pkge);
			String name2 = name;
			if (name2 != null) {
				org.eclipse.ocl.pivot.Class type = completePackage.getMemberType(name2);
				if (type != null) {
					addNamedElement(type);
				}
				else {
					completePackage = environmentFactory.getCompleteModel().getPrimitiveCompletePackage();
					type = completePackage.getMemberType(name2);
					if (type != null) {
						addNamedElement(type);
					}
				}
			}
			else {
				for (CompleteClass completeClass : completePackage.getOwnedCompleteClasses()) {
					addNamedElement(completeClass.getPrimaryClass());
				}
				PrimitiveCompletePackage primitiveCompletePackage = environmentFactory.getCompleteModel().getPrimitiveCompletePackage();
				for (CompleteClass completeClass : primitiveCompletePackage.getOwnedCompleteClasses()) {
					addNamedElement(completeClass.getPrimaryClass());
				}
			}
		}
	}

	/**
	 * Add an element with an elementName to the view
	 *
	 * @param elementName
	 *            name of element
	 * @param element
	 *            the element
	 */
	public void addElement(@Nullable String elementName, @Nullable Object element) {
		if ((elementName == null) || (element == null)) {
			return;
		}
		if ((element instanceof EObject) && !(element instanceof Variable) && (((EObject)element).eResource() == null)) {
			// Orphans are bad but LetExp/LoopExp/ExpressionInOCL Variables are created left-to-right
			EObject eObject = (EObject)element;
			while (true) {
				EObject eContainer = eObject.eContainer();
				if (eContainer == null) {
					if (eObject instanceof CompleteEnvironment) {
						break;
					}
					if (eObject.eResource() != null) {
						break;
					}
					logger.error("Orphan '" + element + "'");
					return;
				}
				else {
					eObject = eContainer;
				}
			}
		}
		if ((name != null) && !name.equals(elementName)) {
			assert !(element instanceof Property) &&  !(element instanceof Operation);
			return;
		}
		if (element instanceof CompletePackage) {
			element = ((CompletePackage)element).getPrimaryPackage();
		}
		else if (element instanceof org.eclipse.ocl.pivot.Package) {
			//			element = metamodelManager.getCompletePackage((org.eclipse.ocl.pivot.Package) element).getPivotPackage();
		}
		//		else if (element instanceof org.eclipse.ocl.pivot.Package) {
		//			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
		//		}
		//		else if (element instanceof TypeServer) {
		//			element = ((TypeServer) element).getPrimaryType();		// FIXME lose casts
		//		}
		else if (element instanceof EObject) {
			element = environmentFactory.getMetamodelManager().getPrimaryElement((EObject) element);		// FIXME lose casts
		}
		if (element == null) {
			return;
		}
		if ((name != null) && (matchers != null)) {
			for (@NonNull ScopeFilter filter : matchers) {
				if (!filter.matches(this, element)) {
					return;
				}
			}
		}
		/*if (element instanceof PackageServer) {
			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
		}
		else*/ if (element instanceof CompleteInheritanceImpl) {
			assert false;
			element = ((CompleteInheritanceImpl) element).getCompleteClass().getPrimaryClass();		// FIXME lose casts
		}
		if ((requiredType != null) && (name != null)) {
			if (!requiredType.isInstance(element)) {
				return;
			}
		}
		Object value = contentsByName.get(elementName);
		if (value == element) {
			;	// Already present
		} else if (value == null) {
			contentsByName.put(elementName, element);
			contentsSize++;
		} else {
			MyList values;
			if (value instanceof MyList) {
				values = (MyList)value;
			} else {
				values = new MyList();
				values.add(value);
				contentsByName.put(elementName, values);
			}
			if (!values.contains(element)) {
				values.add(element);
				contentsSize++;
			}
		}
	}
	// This copy here to preserve API until failure of clients to update understood.
	public void addElement(@Nullable String elementName, @Nullable Element element) {
		addElement(elementName, (Object)element);
	}

	public void addElements(@NonNull Map<String, ?> elements) {
		String name2 = name;
		if (name2 != null) {
			Object element = elements.get(name2);
			if (element != null) {
				addElement(name2, element);
			}
		}
		else {
			for (String key : elements.keySet()) {
				if (key != null) {
					Object element = elements.get(key);
					if (element != null) {
						addElement(key, element);
					}
				}
			}
		}
	}

	public void addElements(@Nullable Iterable<? extends Object> elements) {
		if (elements != null) {
			for (Object element : elements) {
				if (element instanceof Nameable) {
					Nameable namedElement = (Nameable) element;
					String elementName = namedElement.getName();
					if (elementName != null) {
						addElement(elementName, namedElement);
					}
				}
			}
		}
	}

	public void addElementsOfScope(@Nullable Element asElement, @NonNull ScopeView scopeView) {
		if (asElement != null) {
			Attribution attribution = getAttribution(asElement);
			attribution.computeLookup(asElement, this, scopeView);
		}
	}

	public void addFilter(@NonNull ScopeFilter filter) {
		if (matchers == null) {
			matchers = new ArrayList<>();
		}
		matchers.add(filter);
	}

	public void addImportedElement(@NonNull URI baseURI) {
		if (PivotUtilInternal.isASURI(baseURI)) {
			baseURI = PivotUtilInternal.getNonASURI(baseURI);
		}
		String name = getName();
		if (name != null) {
			@NonNull URI uri = URI.createURI(name).resolve(baseURI);
			try {
				Element importedElement = environmentFactory.getMetamodelManager().loadResource(uri, null, null);
				if (importedElement != null) {
					addElement(name, importedElement);
				}
			} catch (Exception e) {
				// if it doesn't load just treat it as unresolved
			}
		}
	}

	public void addLibContents(org.eclipse.ocl.pivot.@NonNull Class libType, @NonNull ScopeView scopeView) {
		addElementsOfScope(libType, scopeView);
		for (org.eclipse.ocl.pivot.Class superClass : libType.getSuperClasses()) {
			if (superClass != null) {
				addLibContents(superClass, scopeView);
			}
		}
	}

	public void addNamedElement(/*@NonNull*/ Nameable namedElement) {
		if (namedElement == null) {
			return;
		}
		String elementName = namedElement.getName();
		if (elementName != null) {
			addElement(elementName, namedElement);
		}
	}
	// This copy here to preserve API until failure of clients to update understood.
	public void addNamedElement(/*@NonNull*/ NamedElement namedElement) {
		addNamedElement((Nameable)namedElement);
	}

	public void addNamedElements(/*@NonNull*/ Iterable<? extends Nameable> namedElements) {
		for (Nameable namedElement : namedElements) {
			if (namedElement != null) {
				addNamedElement(namedElement);
			}
		}
	}

	public void addRootPackages() {
		CompleteModelInternal completeModel = environmentFactory.getCompleteModel();
		String name2 = name;
		if (name2 != null) {
			CompletePackage rootCompletePackage = completeModel.getOwnedCompletePackage(name2);
			if (rootCompletePackage != null) {
				addNamedElement(rootCompletePackage);
			}
			CompletePackage completePackage = completeModel.getCompletePackageByURI(name2);
			if (completePackage != null) {
				addElement(name2, completePackage);
			}
		}
		else {
			for (CompletePackage rootCompletePackage : completeModel.getOwnedCompletePackages()) {
				if (rootCompletePackage != null) {
					addNamedElement(rootCompletePackage);
				}
			}
			for (@NonNull CompletePackage completePackage : completeModel.getAllCompletePackagesWithUris()) {
				String nsURI = completePackage.getURI();
				if (nsURI != null) {
					addElement(nsURI, completePackage);
				}
			}
		}
	}

	public int computeLookups(@NonNull Element target, @Nullable Element child) {
		@SuppressWarnings("deprecation")
		ScopeView pivotScopeView = parserContext != null ? new PivotScopeView(parserContext, target, child, false) : new PivotScopeView(environmentFactory, target, child, false);
		return computeLookups(pivotScopeView);
	}

	public int computeLookups(@NonNull ScopeView scopeView) {
		ScopeView aScope = scopeView;
		try {
			while ((aScope != null) && !hasFinalResult()) {
				EObject aTarget = aScope.getTarget();
				if (aTarget == null) {
					break;					// The NULLSCOPEVIEW
				}
				Attribution attribution = aScope.getAttribution();
				aScope = attribution.computeLookup(aTarget, this, aScope);
			}
		}
		catch (IllegalLibraryException e) {
			throw e;
		}
		catch (Exception e) {
			EObject target = scopeView.getTarget();
			assert target != null;
			target.eResource().getErrors().add(new DiagnosticWrappedException("Lookup of '" + name + "' failed", e));
			//			logger.warn("Lookup of '" + name + "' failed", e);
		}
		return resolveDuplicates();
	}

	public void computeQualifiedLookups(@NonNull Element target) {
		@SuppressWarnings("deprecation")
		ScopeView parentScopeView = parserContext != null ? new PivotScopeView(parserContext, target, null, true) : new PivotScopeView(environmentFactory, target, null, true);
		addElementsOfScope(target, parentScopeView);
	}

	/**
	 * @since 1.3
	 */
	public @NonNull Attribution getAttribution(@NonNull EObject eObject) {
		if (parserContext != null) {
			return parserContext.getAttribution(eObject);
		}
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getAttribution for proxy " + eObject);
			return NullAttribution.INSTANCE;
		}
		else {
			EClass eClass = eObject.eClass();
			assert eClass != null;
			Attribution attribution = Attribution.REGISTRY.get(eClass);
			if (attribution == null) {
				for (EClass superClass = eClass; superClass.getESuperTypes().size() > 0;) {
					superClass = superClass.getESuperTypes().get(0);
					attribution = Attribution.REGISTRY.get(superClass);
					if (attribution != null) {
						break;
					}
				}
				if (attribution == null) {
					attribution = NullAttribution.INSTANCE;
				}
				Attribution.REGISTRY.put(eClass, attribution);
			}
			return attribution;
		}
	}

	public @Nullable EObject getContent() {
		if (contentsSize == 0) {
			return null;
		}
		if (contentsSize != 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		for (Map.Entry<@NonNull String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof MyList) {
				MyList values = (MyList) value;
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				return (EObject) value;
			}
		}
		return null;
	}

	public @NonNull Set<Map.Entry<@NonNull String, Object>> getEntries() {
		return contentsByName.entrySet();
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	//	public @NonNull MetamodelManager getMetamodelManager() {
	//		return metamodelManager;
	//	}

	public @Nullable String getName() {
		return name;
	}

	public @NonNull EStructuralFeature getReference() {
		return reference;
	}

	public @Nullable EClassifier getRequiredType() {
		return requiredType;
	}

	public int getSize() {
		return contentsSize;
	}

	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	/**
	 * Return true once the EnvironmentView has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	public boolean hasFinalResult() {
		if (contentsSize == 0) {
			return false; // Nothing found is not a final result
		}
		if (getName() == null) {
			return false; // No name means search full hierarchy
		}
		for (Object object : contentsByName.values()) {
			if (!(object instanceof Property) || !((Property)object).isIsImplicit()) { // See Bug 580139 - generalize to isExplicit
				return true;
			}
		}
		return false;
	}

	/**
	 * @since 1.18
	 */
	public boolean isQualified() {
		return isQualified;
	}

	public boolean isQualifier() {
		return isQualifier;
	}

	public void removeFilter(@NonNull ScopeFilter filter) {
		if (matchers != null) {
			matchers.remove(filter);
		}
	}

	/**
	 * @since 1.18
	 */
	public int resolveDuplicates() {
		if ((contentsSize > 1) && (getName() != null)) {
			int newSize = 0;
			for (Map.Entry<@NonNull String, Object> entry : contentsByName.entrySet()) {
				Object listOrValue = entry.getValue();
				if (listOrValue instanceof MyList) {
					MyList values = (MyList) listOrValue;
					for (int i = 0; i < values.size()-1;) {
						boolean iRemoved = false;
						@SuppressWarnings("null") @NonNull Object iValue = values.get(i);
						for (int j = i + 1; j < values.size();) {
							Class<?> iClass = iValue.getClass();
							@SuppressWarnings("null") @NonNull Object jValue = values.get(j);
							Class<?> jClass = jValue.getClass();
							int verdict = 0;
							for (Class<?> key : disambiguatorMap.keySet()) {
								if (key.isAssignableFrom(iClass) && key.isAssignableFrom(jClass)) {
									List<Comparator<Object>> comparators = disambiguatorMap.get(key);
									assert comparators != null;
									for (Comparator<Object> comparator : comparators) {
										if (comparator instanceof Disambiguator<?>) {
											verdict = ((Disambiguator<@NonNull Object>)comparator).compare(environmentFactory, iValue, jValue);
										}
										else {
											verdict = comparator.compare(iValue, jValue);
										}
										if (verdict != 0) {
											break;
										}
									}
									if (verdict != 0) {
										break;
									}
								}
							}
							if (verdict == 0) {
								j++;
							} else if (verdict < 0) {
								values.remove(i);
								iRemoved = true;
								break;
							} else {
								values.remove(j);
							}
						}
						if (!iRemoved) {
							i++;
						}
					}
					newSize += values.size();
				} else {
					newSize++;
				}
			}
			contentsSize = newSize;
		}
		return getSize();
	}

	/**
	 * @since 1.18
	 */
	public void setIsQualified(boolean isQualified) {
		this.isQualified = isQualified;
	}

	public void setIsQualifier(boolean isQualifier) {
		this.isQualifier = isQualifier;
	}

	public void setRequiredType(@Nullable EClassifier requiredType) {
		assert (requiredType == null) || PivotUtil.conformsTo(reference.getEType(), requiredType);
		this.requiredType = requiredType;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(reference.getName());
		s.append(" : "); //$NON-NLS-1$
		//		s.append(reference.getEType().getName());
		if (requiredType != null) {
			s.append(requiredType.getName());
		}
		if (isQualifier) {
			s.append(" (qualifier)");
		}
		s.append(" \""); //$NON-NLS-1$
		if (name != null) {
			s.append(name);
		}
		s.append("\" {"); //$NON-NLS-1$
		String prefix = ""; //$NON-NLS-1$
		for (@NonNull String contentName : contentsByName.keySet()) {
			s.append(prefix);
			s.append(contentName);
			Object content = contentsByName.get(contentName);
			if (content instanceof List<?>) {
				s.append("*");
				s.append(((List<?>) content).size());
			}
			prefix = ","; //$NON-NLS-1$
		}
		s.append("}"); //$NON-NLS-1$
		return s.toString();
	}
}
