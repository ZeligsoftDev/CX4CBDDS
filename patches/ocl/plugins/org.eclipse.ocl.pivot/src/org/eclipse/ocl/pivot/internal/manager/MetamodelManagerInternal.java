/*******************************************************************************
 * Copyright (c) 2010, 20185 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public interface MetamodelManagerInternal extends MetamodelManager
{
	/**
	 * @since 1.1
	 */
	public interface MetamodelManagerInternalExtension extends MetamodelManagerInternal
	{
		@NonNull LibraryProperty getImplementation(@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property);
	}

	/**
	 * @since 1.3
	 */
	public interface MetamodelManagerInternalExtension2 extends MetamodelManagerInternalExtension
	{
		@NonNull FinalAnalysis getFinalAnalysis();
		@NonNull FlowAnalysis getFlowAnalysis(@NonNull OCLExpression oclExpression);
		void resetFinalAnalysis();
		void resetFlowAnalysis();
	}

	void addClassLoader(@NonNull ClassLoader classLoader);

	void addExternal2AS(@NonNull External2AS external2as);

	void addGenModel(@NonNull GenModel genModel);

	@Nullable Namespace addGlobalNamespace(@NonNull String name, @NonNull Namespace namespace);

	void addLockedElement(@NonNull Object lockedElement);

	boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions);

	@Deprecated /* @deprecated use EnvironmentFactory.createParserContext() */
	@Nullable ParserContext createParserContext(@NonNull Element element, Object... todoParameters) throws ParserException;

	org.eclipse.ocl.pivot.@Nullable Package getASmetamodel();

	@NonNull Iterable<Constraint> getAllInvariants(@NonNull Type pivotType);

	org.eclipse.ocl.pivot.@NonNull Class getCollectionType(@NonNull String collectionTypeName, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

	@NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType);

	@Override
	@NonNull CompleteModelInternal getCompleteModel();

	@NonNull CompletePackage getCompletePackage(org.eclipse.ocl.pivot.@NonNull Package asPackage);

	@Override
	@NonNull EnvironmentFactoryInternal getEnvironmentFactory();

	@Nullable GenPackage getGenPackage(@NonNull String nsURI);


	org.eclipse.ocl.pivot.@Nullable Class getPrimaryType(@NonNull String nsURI, @NonNull String path, String... extraPath);

	@Override
	@NonNull StandardLibraryInternal getStandardLibrary();

	void installRoot(@NonNull Model pivotModel);

	@Nullable Element loadResource(@NonNull URI uri, String alias, @Nullable ResourceSet resourceSet) throws ParserException;
}