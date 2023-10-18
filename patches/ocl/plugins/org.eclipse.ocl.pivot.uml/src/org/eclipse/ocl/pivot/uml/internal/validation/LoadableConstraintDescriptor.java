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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A LoadableConstraintDescriptor realizes both an IConstraintDescriptor and IModelConstraint
 * to support a Constraint derived from loading some model source. The resulting desciptor
 * is suitable for use with the EMF.Valitation framework.
 */
public abstract class LoadableConstraintDescriptor<T> extends AbstractConstraintDescriptor implements IModelConstraint
{
	public static class Ecore extends LoadableConstraintDescriptor<EClassifier>
	{
		public Ecore(@NonNull EClassifier targetType, @NonNull Constraint constraint, int code) {
			super(targetType, constraint, targetType.getEPackage().getNsURI(), targetType.getName(), code);
		}

		@Override
		public boolean targetsTypeOf(EObject eObject) {
			return targetType.isInstance(eObject);
		}
	}

	public static class UML extends LoadableConstraintDescriptor<Stereotype>
	{
		public UML(@NonNull Stereotype targetType, @NonNull Constraint constraint, int code) {
			super(targetType, constraint, targetType.getNearestPackage().getURI(), targetType.getName(), code);
		}

		protected boolean isKindOf(@NonNull String nsURI, @NonNull String name, EClass eClass) {
			if (name.equals(eClass.getName())) {
				EPackage ePackage = eClass.getEPackage();
				if (nsURI.equals(ePackage.getNsURI())) {
					return true;
				}
			}
			for (EClass eSuperClass : eClass.getESuperTypes()) {
				if (isKindOf(nsURI, name, eSuperClass)) {
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean targetsTypeOf(EObject eObject) {
			EClass eClass = eObject.eClass();
			String nsURI = targetType.getProfile().getURI();
			if (nsURI == null) {
				return false;
			}
			String name = targetType.getName();
			if (name == null) {
				return false;
			}
			return isKindOf(nsURI, name, eClass);
		}
	}

	private static final Logger logger = LogManager.getLogger(LoadableConstraintDescriptor.class);

	private final @NonNull Constraint constraint;
	protected final @NonNull T targetType;
	private final @NonNull String id;
	private final @NonNull String name;
	private final int code;
	private ExpressionInOCL query = null;

	public LoadableConstraintDescriptor(@NonNull T targetType, @NonNull Constraint constraint,
			String targetNamespace, String targetName, int code) {
		this.constraint = constraint;
		this.targetType = targetType;
		String name = constraint.getName();
		if (name == null) {
			name = Long.toHexString(System.identityHashCode(constraint));
		}

		id = "'" + targetNamespace + "'::" + targetName + "::" + name;
		this.name = targetName + "::" + name;
		this.code = code;
	}

	final Constraint getConstraint() {
		return constraint;
	}

	@Override
	public String getBody() {
		return PrettyPrinter.print(constraint);
	}

	@Override
	public String getDescription() {
		return getBody();
	}

	@Override
	public EvaluationMode<?> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getMessagePattern() {
		return String.format("Constraint %s violated on {0}", getName()); //$NON-NLS-1$
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPluginId() {
		return PivotPlugin.PLUGIN_ID;
	}

	@Override
	public ConstraintSeverity getSeverity() {
		return ConstraintSeverity.WARNING;
	}

	@Override
	public int getStatusCode() {
		return code;
	}

	@Override
	public boolean targetsEvent(Notification notification) {
		return false;
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if (target == null) {
			return ctx.createFailureStatus(target);
		}
		OCL ocl = LoadableConstraintProvider.getOCL();
		ExpressionInOCL query2 = query;
		if (query2 == null) {
			EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension) ocl.getEnvironmentFactory();
			EClass eClass = target.eClass();
			NamedElement contextElement = null;
			try {
				contextElement = environmentFactory.getASOf(NamedElement.class, eClass);
			} catch (ParserException e) {
				logger.error("Failed to convert " + eClass, e);
			}
			if (contextElement == null) {
				return ctx.createFailureStatus(target);
			}
			LanguageExpression specification = constraint.getOwnedSpecification();
			if (specification == null) {
				return ctx.createFailureStatus(target);
			}
			try {
				query = query2 = environmentFactory.parseSpecification(specification);
			} catch (ParserException e) {
				return ctx.createFailureStatus(e.getLocalizedMessage());
			}
		}
		Object result = ocl.evaluate(target, query2);
		if (result != Boolean.TRUE) {
			return ctx.createFailureStatus(target);
		}
		return ctx.createSuccessStatus();
	}
}
