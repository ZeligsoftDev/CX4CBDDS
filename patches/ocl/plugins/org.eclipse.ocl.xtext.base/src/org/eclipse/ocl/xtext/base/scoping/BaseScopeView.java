/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.Attribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.NullAttribution;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * ScopeViews support access to some or all of the elements in a scope.
 * Accesses are filtered on the fly since a cache of results does not remain valid
 * for long enough to merit it, with incremental reparsing regularly trashing
 * the CST.
 */
public class BaseScopeView extends AbstractScope implements IScopeView
{
	private static final Logger logger = LogManager.getLogger(BaseScopeView.class);

	/**
	 * The <code>NULLSCOPEVIEW</code> to be returned by the most outer scope
	 */
	public static final @NonNull IScopeView NULLSCOPEVIEW = new IScopeView()
	{
		@Override
		public Iterable<IEObjectDescription> getAllElements() {
			return Collections.emptyList();
		}

		@Override
		public @NonNull Attribution getAttribution() {
			return NullAttribution.INSTANCE;
		}

		@Override
		public ElementCS getChild() {
			return null;
		}

		@Override
		public EStructuralFeature getContainmentFeature() {
			return null;
		}

		@Override
		public Iterable<IEObjectDescription> getElements(EObject object) {
			return Collections.emptyList();
		}

		@Override
		public Iterable<IEObjectDescription> getElements(QualifiedName name) {
			return Collections.emptyList();
		}

		@Override
		public @NonNull IScopeView getParent() {
			return NULLSCOPEVIEW;
		}

		@Override
		public @NonNull IScopeView getRoot() {
			return NULLSCOPEVIEW;
		}

		@Override
		public IEObjectDescription getSingleElement(QualifiedName name) {
			return null;
		}

		@Override
		public IEObjectDescription getSingleElement(EObject object) {
			return null;
		}

		@Override
		public ElementCS getTarget() {
			return null;
		}

		@Override
		public boolean isQualified() {
			return false;
		}
	};

	public static @NonNull BaseScopeView getScopeView(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ElementCS target, @NonNull EReference targetReference) {
		return new BaseScopeView(environmentFactory, target, null, targetReference, false);
	}

	private static @NonNull IScopeView getParent(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ElementCS target, @NonNull EReference targetReference, boolean isQualified) {
		ElementCS csParent = target.getParent();
		if (csParent == null) {
			return NULLSCOPEVIEW;
		}
		return new BaseScopeView(environmentFactory, csParent, target, targetReference, isQualified);
	}

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull ElementCS target;							// CS node in which a lookup is to be performed
	protected final @Nullable ElementCS child;							// CS node from which a lookup is to be performed
	protected final @NonNull EReference targetReference;				// The AST reference to the location at which the lookup is to be stored
	protected final boolean isQualified;								// FIXME always false
	private Attribution attribution = null;								// Lazily computed Attributes helper for the target CS node

	private final @Nullable ParserContext parserContext;		// FIXME only non-null for API compatibility

	protected BaseScopeView(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ElementCS target, @Nullable ElementCS child, @NonNull EReference targetReference, boolean isQualified) {
		super(getParent(environmentFactory, target, targetReference, isQualified), false);
		this.environmentFactory = environmentFactory;
		this.target = target;
		this.child = child;
		this.targetReference = targetReference;
		this.isQualified = isQualified;
		this.parserContext = ElementUtil.basicGetParserContext(target);
		if (parserContext != null) {
			assert parserContext.getMetamodelManager().getEnvironmentFactory() == environmentFactory;
		}
	}

	@SuppressWarnings("deprecation")
	protected @NonNull EnvironmentView createEnvironmentView(@Nullable String name) {
		return parserContext != null ? new EnvironmentView(parserContext, targetReference, name) : new EnvironmentView(environmentFactory, targetReference, name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NonNull Attribution getAttribution() {
		Attribution attribution2 = attribution;
		if (attribution2 == null) {
			attribution2 = parserContext != null ? parserContext.getAttribution(target) : PivotUtilInternal.getAttribution(target);
			attribution = attribution2;
		}
		return attribution2;
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		EnvironmentView environmentView = createEnvironmentView(null);
		try {
			//			computeLookupWithParents(environmentView);
			Attribution attribution = getAttribution();
			ScopeView aScope = attribution.computeLookup(target, environmentView, this);
			if (aScope != null) {
				environmentView.computeLookups(aScope);
			}
		} catch (IllegalLibraryException e) {
		}
		return getDescriptions(environmentView);
	}

	@Override
	protected final Iterable<IEObjectDescription> getAllLocalElements() {
		EnvironmentView environmentView = createEnvironmentView(null);
		Attribution attribution = getAttribution();
		attribution.computeLookup(target, environmentView, this);
		return getDescriptions(environmentView);
	}

	@Override
	public @Nullable ElementCS getChild() {
		return child;
	}

	@Override
	public EStructuralFeature getContainmentFeature() {
		//		assert ((child == null) && (containmentFeature == null)) || ((child != null) && (child.eContainmentFeature() ==  containmentFeature));
		return child != null ? child.eContainmentFeature() : targetReference;
	}

	private @NonNull Element getContextRoot(@NonNull Element context) {
		while (!(context instanceof Namespace) && !(context instanceof Type)) {
			EObject container = context.eContainer();
			if (container instanceof Element) {
				context = (Element) container;
			}
			else {
				break;
			}
		}
		return context;
	}

	private @Nullable IEObjectDescription getDescription(EnvironmentView environmentView) {
		int contentsSize = environmentView.getSize();
		if (contentsSize == 0) {
			return null;
		}
		if (contentsSize != 1) {
			logger.warn("Unhandled ambiguous content for '" + environmentView.getName() + "'");
		}
		for (Map.Entry<String, Object> entry : environmentView.getEntries()) {
			Object value = entry.getValue();
			if (value instanceof List<?>) {
				List<?> values = (List<?>) value;
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				return EObjectDescription.create(entry.getKey(), (EObject) value);
			}
		}
		return null;
	}

	private @NonNull List<IEObjectDescription> getDescriptions(EnvironmentView environmentView) {
		List<IEObjectDescription> contents = new ArrayList<IEObjectDescription>();
		for (Map.Entry<String, Object> entry : environmentView.getEntries()) {
			Object values = entry.getValue();
			if (values instanceof EObject) {
				contents.add(EObjectDescription.create(entry.getKey(),
					(EObject) values));
			} else if (values instanceof List<?>) {
				for (Object value : (List<?>) values) {
					contents.add(EObjectDescription.create(entry.getKey(),
						(EObject) value));
				}
			}
		}
		return contents;
	}

	@Override
	public /*@NonNull*/ Iterable<IEObjectDescription> getElements(QualifiedName name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		EnvironmentView environmentView = createEnvironmentView(name.toString());
		int size = environmentView.computeLookups(this);
		if (size <= 0) {
			return Collections.emptyList();
		}
		else if (size == 1) {
			return Collections.singletonList(getDescription(environmentView));
		}
		else {
			List<IEObjectDescription> contents = getDescriptions(environmentView);
			return contents;
		}
	}

	@Override
	public /*@NonNull*/ Iterable<IEObjectDescription> getElements(EObject object) {
		String descriptiveName = null;
		if (targetReference == BaseCSPackage.Literals.IMPORT_CS__REFERRED_NAMESPACE) {
			descriptiveName = getNonASURI(object);
		}
		else if (targetReference == BaseCSPackage.Literals.MODEL_ELEMENT_REF_CS__REFERRED_ELEMENT) {
			descriptiveName = getNonASURI(object);
		}
		else if (targetReference == BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE) {
			descriptiveName = ((NamedElement)object).getName();
		}
		else if (targetReference == BaseCSPackage.Literals.REFERENCE_CS__REFERRED_KEYS) {
			descriptiveName = ((NamedElement)object).getName();
		}
		else if ((targetReference == BaseCSPackage.Literals.TYPED_TYPE_REF_CS__REFERRED_TYPE) && (object instanceof Type)) {
			if (object instanceof PrimitiveType) {		// FIXME Redundant if namespaces correct
				descriptiveName = ((PrimitiveType)object).getName();
			}
			else {
				EObject csRef = getTarget();
				while ((csRef.eContainer() instanceof TypeRefCS)
						|| (csRef.eContainer() instanceof TemplateParameterSubstitutionCS)
						|| (csRef.eContainer() instanceof TemplateBindingCS)) {
					csRef = csRef.eContainer();
				}
				ModelElementCS csContext = (ModelElementCS) csRef.eContainer();
				Resource eResource = EcoreUtil.getRootContainer(csContext).eResource();
				if (eResource == null) {
					return Collections.emptyList();
				}
				AliasAnalysis aliasAnalysis = AliasAnalysis.getAdapter(eResource, environmentFactory);
				Element context = csContext.getPivot();
				if (context == null) {
					return Collections.emptyList();
				}
				context = getContextRoot(context);
				QualifiedPath contextPath = new QualifiedPath(aliasAnalysis.getPath(context));
				QualifiedPath objectPath = new QualifiedPath(aliasAnalysis.getPath((Element) object));
				QualifiedPath qualifiedRelativeName = objectPath.deresolve(contextPath);
				IEObjectDescription objectDescription = EObjectDescription.create(qualifiedRelativeName, object);
				return Collections.singletonList(objectDescription);
			}
		}
		else if (object instanceof NamedElement) {
			EObject csRef = getTarget();
			while ((csRef.eContainer() instanceof ContextLessElementCS)
					|| (csRef.eContainer() instanceof TypeRefCS)
					|| (csRef.eContainer() instanceof TemplateParameterSubstitutionCS)
					|| (csRef.eContainer() instanceof TemplateBindingCS)) {
				csRef = csRef.eContainer();
			}
			Pivotable csContext = (Pivotable) csRef.eContainer();
			Resource eResource = csContext.eResource();
			if (eResource == null) {
				return Collections.emptyList();
			}
			AliasAnalysis aliasAnalysis = AliasAnalysis.getAdapter(eResource, environmentFactory);
			Element context = csContext.getPivot();
			if (context == null) {
				return Collections.emptyList();
			}
			context = getContextRoot(context);
			QualifiedPath contextPath = new QualifiedPath(aliasAnalysis.getPath(context));
			QualifiedPath objectPath = new QualifiedPath(aliasAnalysis.getPath((Element) object));
			QualifiedPath qualifiedRelativeName = objectPath.deresolve(contextPath);
			IEObjectDescription objectDescription = EObjectDescription.create(qualifiedRelativeName, object);
			return Collections.singletonList(objectDescription);
		}
		if (descriptiveName != null) {
			IEObjectDescription objectDescription = EObjectDescription.create(descriptiveName, object);
			return Collections.singletonList(objectDescription);
		}
		return super.getElements(object);		// FIXME Implement
	}

	//	public MetamodelManager getMetamodelManager() {
	//		return metamodelManager;
	//	}

	private @Nullable String getNonASURI(@Nullable EObject object) {
		URI uri = null;
		if (object == null) {
			return null;
		}
		if (object instanceof PivotObjectImpl) {
			EObject target = ((PivotObjectImpl)object).getESObject();
			if (target != null) {
				uri = EcoreUtil.getURI(target);
			}
		}
		if (uri == null) {
			uri = EcoreUtil.getURI(object);
		}
		if (PivotUtilInternal.isASURI(uri)) {
			uri = PivotUtilInternal.getNonASURI(uri);
		}
		return uri.toString();
	}

	@Override
	public @NonNull IScopeView getParent() {
		IScope parent = super.getParent();
		assert parent instanceof IScopeView;
		return (IScopeView) parent;
	}

	@Override
	public @NonNull IScopeView getRoot() {
		IScopeView parent = getParent();
		if (parent == NULLSCOPEVIEW) {
			return this;
		}
		else {
			return parent.getRoot();
		}
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		if (object instanceof NamedElement) {
			return EObjectDescription.create(((NamedElement)object).getName(), object);
		}
		else {
			return super.getSingleElement(object);		// FIXME Implement
		}
	}

	@Override
	public @Nullable IEObjectDescription getSingleElement(QualifiedName name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		EnvironmentView environmentView = createEnvironmentView(name.toString());
		int size = environmentView.computeLookups(this);
		if (size <= 0) {
			return null;
		}
		else if (size == 1) {
			return getDescription(environmentView);
		}
		else {
			return null;			// FIXME Return an 'ambiguous' description
			//			return environmentView.getDescriptions().get(0);
		}
	}

	@Override
	public final @NonNull ElementCS getTarget() {
		return target;
	}

	@Override
	public final boolean isQualified() {
		return isQualified;
	}

	@Override
	public String toString() {
		EObject target = getTarget();
		StringBuilder s = new StringBuilder();
		s.append("["); //$NON-NLS-1$
		s.append(target.eClass().getName());
		EStructuralFeature containmentFeature2 = getContainmentFeature();
		if (containmentFeature2 != null) {
			s.append("::"); //$NON-NLS-1$
			s.append(containmentFeature2.getName());
		}
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(target));
		return s.toString();
	}
}
