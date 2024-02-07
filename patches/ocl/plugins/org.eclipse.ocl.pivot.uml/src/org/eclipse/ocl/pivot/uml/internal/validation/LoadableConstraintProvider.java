/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.internal.util.XmlConstraintDescriptor;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.ConstraintExistsException;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.xml.XmlConstraintProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Stereotype;

/**
 * LoadableConstraintProvider supports loading of algorithmically derived
 * constraints before a traversal of a particular nsURI starts.
 * <p>
 * Pending improvement of the EMFv API:
 * <p>
 * Two ConstraintProviders should be specified for the one Category for the
 * org.eclipse.emf.validation.constraintProviders extension point.
 * <p>
 * The first ConstraintProvider default-classed XmlConstraintProvider may have a
 * single placeholder constraint that provides the initial content of the
 * Model Validation Constraints Preference page.
 * <p>
 * The second ConstraintProvider deriving from LoadableConstraintProvider
 * should have a Path-languaged constraint with an XML path parameter locating the
 * model source of the loadable constraints. These will be loaded by the first validation
 * run and repopulate the Preference page with their content.
 * <p>
 * See org.eclipse.ocl.examples.xtext.tests/plugin.xml for an example.
 * <p>
 * Derived implementations such as UMLProfileConstraintProvider should implement load
 * to load the modeled constraints.
 */
@SuppressWarnings("restriction")
public abstract class LoadableConstraintProvider extends XmlConstraintProvider
{
	private static final Logger logger = LogManager.getLogger(LoadableConstraintProvider.class);

	private static OCL ocl = null;		// FIXME use CG'd constraints to allow this to be weak

	public static @NonNull OCL getOCL() {
		OCL ocl2 = ocl;
		if (ocl2 == null) {
			synchronized (LoadableConstraintProvider.class) {
				ocl2 = ocl;
				if (ocl2 == null) {
					ocl = ocl2 = OCL.newInstance();
				}
			}
		}
		return ocl2;
	}

	protected LoadableConstraintProvider() {
	}

	protected void installConstraint(@NonNull Constraint constraint, @NonNull Set<Category> categories) {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		for (/*@NonNull*/ Element constrainedElement : constraint.getConstrainedElements()) {
			if (constrainedElement != null) {
				EModelElement targetElement = metamodelManager.getEcoreOfPivot(EModelElement.class, constrainedElement);
				if (targetElement != null) {
					int code = 99;
					LoadableConstraintDescriptor<?> desc = null;
					if (targetElement instanceof EClassifier) {
						desc = new LoadableConstraintDescriptor.Ecore((EClassifier)targetElement, constraint, code);
					}
					else if (targetElement instanceof Stereotype) {
						desc = new LoadableConstraintDescriptor.UML((Stereotype)targetElement, constraint, code);
					}
					else {
						logger.error("Unknown constrainedElement type : " + targetElement);
					}
					if (desc != null) {
						for (Category category : categories) {
							category.addConstraint(desc);
						}
						Collection<IModelConstraint> constraints = getConstraints();
						constraints.add(desc);
					}
				}
			}
		}
	}

	protected void installContents(Iterable<@NonNull ? extends EObject> eContents, @NonNull Set<@NonNull Category> categories) {
		for (EObject eObject : eContents) {
			if (eObject instanceof Constraint) {
				installConstraint((Constraint)eObject, categories);
			}
			if (!(eObject instanceof EAnnotation) && !(eObject instanceof Annotation)) {
				installContents(ClassUtil.nullFree(eObject.eContents()), categories);
			}
		}
	}

	protected void installDescriptor(@NonNull XmlConstraintDescriptor descriptor, String namespaceIdentifier, @NonNull Set<@NonNull Category> categories) {
		String path = descriptor.getParameterValue("path");
		URI uri = URI.createPlatformPluginURI("/" + namespaceIdentifier + "/" + path, true);
		load(getOCL().getEnvironmentFactory(), uri, categories);
	}

	protected boolean installResource(@NonNull Resource asResource, @NonNull Set<@NonNull Category> categories) {
		List<Resource.Diagnostic> errors = asResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load Pivot from '" + this + "': " + message);
			return false;
		}
		installContents(asResource.getContents(), categories);
		try {
			registerConstraints(getConstraints());
		} catch (ConstraintExistsException e) {
			logger.error("Duplicate constraint for '" + this + "'", e);
		}
		return true;
	}

	protected abstract boolean load(@NonNull EnvironmentFactory environmentFactory, @NonNull URI uri, @NonNull Set<@NonNull Category> categories);

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		super.setInitializationData(config, propertyName, data);
		Object cfg = config;
		while (cfg instanceof IConfigurationElement) {
			cfg = ((IConfigurationElement)cfg).getParent();
		}
		if (!(cfg instanceof IExtension)) {
			logger.error("The ConstraintDescriptor for '" + config.getName() + "' has no IExtension parent");
			return;
		}
		String namespaceIdentifier = ((IExtension)cfg).getNamespaceIdentifier();
		List<IModelConstraint> oldConstraints = new ArrayList<IModelConstraint>(getConstraints());
		Set<Category> categories = new HashSet<Category>();
		for (IModelConstraint constraint : oldConstraints) {
			IConstraintDescriptor descriptor = constraint.getDescriptor();
			if (descriptor != null) {
				Set<Category> descriptorCategories = descriptor.getCategories();
				if (descriptorCategories != null) {
					categories.addAll(descriptorCategories);
				}
			}
		}
		Set<IConstraintDescriptor> allDescriptors = new HashSet<IConstraintDescriptor>();
		for (Category category : categories) {
			Set<IConstraintDescriptor> constraints = category.getConstraints();
			if (constraints != null) {
				allDescriptors.addAll(constraints);
			}
		}
		for (IConstraintDescriptor descriptor : allDescriptors) {
			if (!(descriptor instanceof LoadableConstraintDescriptor)) {
				for (Category category : categories) {
					category.removeConstraint(descriptor);
				}
			}
		}
		for (IModelConstraint constraint : oldConstraints) {
			IConstraintDescriptor descriptor = constraint.getDescriptor();
			if (descriptor != null) {
				installDescriptor((XmlConstraintDescriptor) descriptor, namespaceIdentifier, categories);
			}
		}
	}

	@Override
	public String toString() {
		return "LoadableConstraintProvider";
	}
}
