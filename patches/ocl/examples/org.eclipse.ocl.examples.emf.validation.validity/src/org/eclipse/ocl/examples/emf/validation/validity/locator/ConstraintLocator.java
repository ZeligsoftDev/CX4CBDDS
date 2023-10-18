/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.locator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ConstrainingURI;
import org.eclipse.ocl.examples.emf.validation.validity.manager.TypeURI;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;

/**
 * A ConstraintLocator supports location of a particular category of Constraint and dispatch of those constraints for validation.
 * <p>
 * The org.eclipse.ocl.examples.emf.validation.validity.constraint_locator extension point is used to register ConstraintLocators.
 */
public interface ConstraintLocator
{
	public static interface Descriptor
	{
		/**
		 * Return the ConstraintLocator described by this.
		 */
		@NonNull ConstraintLocator getConstraintLocator();
	}

	/**
	 * Return all typeURIs for a given type; typically this returns the supertype closure.
	 */
	@NonNull Set<@NonNull TypeURI> getAllTypes(@NonNull ValidityManager validityManager, @NonNull EObject constrainingObject);

	/**
	 * Return the RH constraining type that supplies the constrainingObject to the constrainedType.
	 * <p>
	 * This just return constrainedType unless the RH pane has additional type information.
	 */
	@NonNull EObject getConstrainingType(@NonNull EObject constrainedType, @NonNull Object constrainingObject);

	/**
	 * Return the URI that provides a distinct identity for a constraining element in the constraining elements view. 
	 */
	@Nullable ConstrainingURI getConstrainingURI(@NonNull EObject eObject);

	/**
	 * Return a constrainedType-to-constraint map for all types in the given resources that have an ePackage whose URI complies with
	 * the registration of this ConstraintLocator. The validityModel is used to create the LeafConstrainingNodes for each constraint.
	 */
	@Nullable Map<@NonNull EObject, @NonNull List<@NonNull LeafConstrainingNode>> getConstraints(@NonNull ValidityModel validityModel, @NonNull EPackage ePackage,
			@NonNull Set<@NonNull Resource> resources, @NonNull Monitor monitor);

	/**
	 * Return an icon to identify this kind of ConstraintLocator.
	 */
	@Nullable Object getImage();

	/**
	 * Return any resources imported from within resource.
	 */
	@Nullable Collection<@NonNull Resource> getImports(@NonNull EPackage ePackage, @NonNull Resource resource);

	/**
	 * Return the singleton instance of this ConstraintLocator to avoid duplicate registrations.
	 */
	@NonNull ConstraintLocator getInstance();

	/**
	 * Return a diagnostic label for eObject.
	 */
	@NonNull String getLabel(@NonNull EModelElement eObject);

	/**
	 * Return a descriptive name for this kind of constraint.
	 */
	@NonNull String getName();

	/**
	 * Return the source representation of the Constraint. Returns null if none available.
	 */
	@Nullable String getSourceExpression(@NonNull LeafConstrainingNode node);

	/**
	 * Return the Resource from which the Constraint was obtained. Returns null if none available.
	 */
	@Nullable Resource getSourceResource(@NonNull LeafConstrainingNode node);

	/**
	 * Return the URI that provides a distinct identity for a constraining element when applied to a validatable element.
	 * This is not necessarily unique in the constraining elements view since multiple constraining models may contribute
	 * constraints to the same type.
	 */
	@Nullable TypeURI getTypeURI(@NonNull EObject eObject);

	/**
	 * Return the type URIs of all 'types' that provide constraints for validatableObject.
	 */
	@Nullable Set<@NonNull TypeURI> getTypeURIs(@NonNull ValidityManager validityManager, @NonNull EObject validatableObject);
	
	/**
	 * Update the validation result to include the verdict of the validation using validityManager to provide shared services.
	 * @param monitor 
	 */
	void validate(@NonNull Result result, @NonNull ValidityManager validityManager, @Nullable Monitor monitor);
}