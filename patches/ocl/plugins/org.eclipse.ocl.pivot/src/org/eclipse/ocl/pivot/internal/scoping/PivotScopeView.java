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
package org.eclipse.ocl.pivot.internal.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ParserContext;

/**
 * ScopeViews support access to some or all of the elements in a scope.
 * Accesses are filtered on the fly since a cache of results does not remain valid
 * for long enough to merit it, with incremental reparsing regularly trashing
 * the CST.
 */
public class PivotScopeView implements ScopeView
{
	/**
	 * The <code>NULLSCOPEVIEW</code> to be returned by the most outer scope
	 */
	public static final @NonNull ScopeView NULLSCOPEVIEW = new ScopeView()
	{
		@Override
		public @NonNull Attribution getAttribution() {
			return NullAttribution.INSTANCE;
		}

		@Override
		public @Nullable Element getChild() {
			return null;
		}

		@Override
		public @Nullable EStructuralFeature getContainmentFeature() {
			return null;
		}

		@Override
		public @NonNull ScopeView getParent() {
			return NULLSCOPEVIEW;
		}

		@Override
		public @NonNull ScopeView getRoot() {
			return NULLSCOPEVIEW;
		}

		@Override
		public Element getTarget() {
			return null;
		}

		@Override
		public boolean isQualified() {
			return false;
		}
	};

	private final @Nullable ParserContext parserContext;		// FIXME only non-null for API compatibility
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull Element target;							// AST node in which a lookup is to be performed
	protected final @Nullable Element child;							// AST node from which a lookup is to be performed
	protected final boolean isQualified;								// True of the lookup has an explicit namespace qualification
	private ScopeView parent = null;									// Lazily computed scope view for target's parent
	private Attribution attribution = null;								// Lazily computed attributes helper for the target CS node

	/**
	 * @since 1.3
	 */
	protected PivotScopeView(@NonNull ParserContext parserContext, @NonNull Element target, @Nullable Element child, boolean isQualified) {
		this.parserContext = parserContext;
		this.environmentFactory = (EnvironmentFactoryInternal) parserContext.getEnvironmentFactory();
		this.target = target;
		this.child = child;
		this.isQualified = isQualified;
	}

	/**
	 * @deprecated Provide a ParserContext
	 */
	@Deprecated
	protected PivotScopeView(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Element target, @Nullable Element child, boolean isQualified) {
		this.parserContext = null;
		this.environmentFactory = environmentFactory;
		this.target = target;
		this.child = child;
		this.isQualified = isQualified;
	}

	public @Nullable ScopeView computeLookup(@NonNull EnvironmentView environmentView, @NonNull EObject aTarget) {
		assert aTarget instanceof Element;
		if (attribution == null) {
			attribution = environmentView.getAttribution(target);
		}
		return attribution.computeLookup(aTarget, environmentView, this);
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
	public @Nullable Element getChild() {
		return child;
	}

	@Override
	public @Nullable EStructuralFeature getContainmentFeature() {
		//		assert ((child == null) && (containmentFeature == null)) || ((child != null) && (child.eContainmentFeature() ==  containmentFeature));
		return (child != null) ? child.eContainmentFeature() : null;
	}

	//	public @NonNull MetamodelManager getMetamodelManager() {
	//		return metamodelManager;
	//	}

	@Override
	public @NonNull ScopeView getParent() {
		ScopeView parent2 = parent;
		if (parent2 == null) {
			EObject pParent = target.eContainer();
			if (pParent instanceof Element) {
				parent2 = parserContext != null ? new PivotScopeView(parserContext, (Element)pParent, target, isQualified) : new PivotScopeView(environmentFactory, (Element)pParent, target, isQualified);
			}
			else {
				parent2 = NULLSCOPEVIEW;
			}
			parent = parent2;
		}
		return parent2;
	}

	@Override
	public @NonNull ScopeView getRoot() {
		ScopeView parent = getParent();
		if (parent == NULLSCOPEVIEW) {
			return this;
		}
		else {
			return parent.getRoot();
		}
	}

	@Override
	public final @NonNull Element getTarget() {
		return target;
	}

	@Override
	public boolean isQualified() {
		return isQualified;
	}

	@Override
	public String toString() {
		Element target = getTarget();
		StringBuilder s = new StringBuilder();
		s.append("["); //$NON-NLS-1$
		s.append(target.eClass().getName());
		EStructuralFeature containmentFeature = getContainmentFeature();
		if (containmentFeature != null) {
			s.append("::"); //$NON-NLS-1$
			s.append(containmentFeature.getName());
		}
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(target));
		return s.toString();
	}
}
