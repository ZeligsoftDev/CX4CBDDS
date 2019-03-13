/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.validation.provider;

import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.validation.util.ValidationUtil;

/**
 * An introspector of the constraint stereotype application providing the
 * meta-data required by the EMF Validation Framework.
 * 
 * @author Christian W. Damus (cdamus)
 */
class ConstraintMetadata
		extends UMLUtil {

	/**
	 * Cache of constraint meta-data per distinct Ecore implementation of the
	 * <tt>DomainConstraint</tt> concept. Different resource sets will have
	 * different instances of these stereotype EClasses.
	 */
	private static Map<EClass, ConstraintMetadata> instances = new java.util.HashMap<EClass, ConstraintMetadata>();

	private Stereotype stereotype;

	private EAttribute id;

	private EAttribute evaluationMode;

	private Enumerator evaluationMode_batch;

	private Enumerator evaluationMode_live;

	private EAttribute message;

	private EAttribute severity;

	private Enumerator severity_info;

	private Enumerator severity_warn;

	private Enumerator severity_error;

	private Enumerator severity_fatal;

	private EAttribute kind;

	@SuppressWarnings("unused")
	private Enumerator kind_wellFormedness;

	private Enumerator kind_reminder;

	private EAttribute statusCode;

	/**
	 * Initializes me for introspection of the specified stereotype.
	 * 
	 * @param stereotype
	 *            the Ecore definition of a stereotype
	 */
	private ConstraintMetadata(EClass stereotype) {
		this.stereotype = (Stereotype) UMLUtil.getNamedElement(stereotype);

		id = (EAttribute) stereotype.getEStructuralFeature("id"); //$NON-NLS-1$
		evaluationMode = (EAttribute) stereotype
			.getEStructuralFeature("evaluationMode"); //$NON-NLS-1$
		message = (EAttribute) stereotype.getEStructuralFeature("message"); //$NON-NLS-1$
		severity = (EAttribute) stereotype.getEStructuralFeature("severity"); //$NON-NLS-1$
		kind = (EAttribute) stereotype.getEStructuralFeature("kind"); //$NON-NLS-1$
		statusCode = (EAttribute) stereotype
			.getEStructuralFeature("statusCode"); //$NON-NLS-1$

		EEnum enumType = (EEnum) evaluationMode.getEType();
		evaluationMode_batch = enumType.getEEnumLiteral("batch").getInstance(); //$NON-NLS-1$
		evaluationMode_live = enumType.getEEnumLiteral("live").getInstance(); //$NON-NLS-1$

		enumType = (EEnum) severity.getEType();
		severity_info = enumType.getEEnumLiteral("info").getInstance(); //$NON-NLS-1$
		severity_warn = enumType.getEEnumLiteral("warn").getInstance(); //$NON-NLS-1$
		severity_error = enumType.getEEnumLiteral("error").getInstance(); //$NON-NLS-1$
		severity_fatal = enumType.getEEnumLiteral("fatal").getInstance(); //$NON-NLS-1$

		enumType = (EEnum) kind.getEType();
		kind_wellFormedness = enumType
			.getEEnumLiteral("wellFormedness").getInstance(); //$NON-NLS-1$
		kind_reminder = enumType.getEEnumLiteral("reminder").getInstance(); //$NON-NLS-1$
	}
	
	/**
	 * Obtains the instance of the constraint metadata introspector that is
	 * appropriate for the specified UML constraint specification.
	 * 
	 * @param umlConstraint
	 *            a UML constraint in a ZDL model
	 * 
	 * @return the constraint metadata introspector
	 */
	static ConstraintMetadata getInstance(Constraint umlConstraint) {
		Stereotype stereotype = ValidationUtil.getConstraintStereotype(umlConstraint);
		
		EClass eclass = umlConstraint.getStereotypeApplication(stereotype)
			.eClass();
		ConstraintMetadata result = instances.get(eclass);

		if (result == null) {
			result = new ConstraintMetadata(eclass);
			instances.put(eclass, result);
		}

		return result;
	}

	/**
	 * Obtains the object that holds the validation metadata for the specified
	 * UML constraint.
	 * 
	 * @param umlConstraint
	 *            a UML constraint
	 * @return its validation metadata holder object
	 */
	public EObject getMetadataHolder(Constraint umlConstraint) {
		return umlConstraint.getStereotypeApplication(stereotype);
	}

	/**
	 * Obtains the constraint ID specified by the given metadata object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return its ID
	 */
	public String getID(EObject metadata) {
		return (String) metadata.eGet(id);
	}

	/**
	 * Obtains the constraint message specified by the given metadata object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return its message
	 */
	public String getMessage(EObject metadata) {
		return (String) metadata.eGet(message);
	}

	/**
	 * Obtains the constraint evaluation mode specified by the given metadata
	 * object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return its evaluation mode
	 */
	public EvaluationMode<?> getEvaluationMode(EObject metadata) {
		Enumerator value = (Enumerator) metadata.eGet(evaluationMode);

		if (value == evaluationMode_batch) {
			return EvaluationMode.BATCH;
		} else if (value == evaluationMode_live) {
			return EvaluationMode.LIVE;
		} else {
			return EvaluationMode.NULL;
		}
	}

	/**
	 * Obtains the constraint severity specified by the given metadata object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return its severity
	 */
	public ConstraintSeverity getSeverity(EObject metadata) {
		Enumerator value = (Enumerator) metadata.eGet(severity);

		if (value == severity_warn) {
			return ConstraintSeverity.WARNING;
		} else if (value == severity_error) {
			return ConstraintSeverity.ERROR;
		} else if (value == severity_info) {
			return ConstraintSeverity.INFO;
		} else if (value == severity_fatal) {
			return ConstraintSeverity.CANCEL;
		} else {
			return ConstraintSeverity.NULL;
		}
	}

	/**
	 * Queries whether the constraint is a reminder rule, according to the given
	 * metadata object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return whether it is a reminder
	 */
	public boolean isReminder(EObject metadata) {
		return metadata.eGet(kind) == kind_reminder;
	}

	/**
	 * Obtains the constraint code specified by the given metadata object.
	 * 
	 * @param metadata
	 *            the constraint status code
	 * 
	 * @return its status code, or the default (1) if none is specified
	 */
	public int getStatusCode(EObject metadata) {
		int result = (Integer) metadata.eGet(statusCode);

		if (result < 1) {
			result = 1; // the default value
		}

		return result;
	}

	/**
	 * Obtains the constraint display name specified by the given metadata
	 * object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return its display name
	 */
	public String getDisplayName(EObject metadata) {
		return getUMLConstraint(metadata).getLabel(true);
	}

	/**
	 * Obtains the constraint description specified by the given metadata
	 * object.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return its description text
	 */
	public String getDescription(EObject metadata) {
		String result = null;

		Constraint uml = getUMLConstraint(metadata);
		if (!uml.getOwnedComments().isEmpty()) {
			result = uml.getOwnedComments().get(0).getBody();
		} 
		
		// if there was no description or it was empty then try and create one
		if(result == null){
			// if we got this far, then there is an expression with a language
			OpaqueExpression expr = (OpaqueExpression) uml.getSpecification();
			String language = expr.getLanguages().isEmpty()
				? null
				: expr.getLanguages().get(0);
			result = NLS.bind(
				Messages.ConstraintMetadata_defaultDesc,
				ValidationUtil.getQualifiedName(uml), language);
		}

		return result;
	}

	/**
	 * Obtains the UML Constraint to which the specified metadata holder is
	 * applied.
	 * 
	 * @param metadata
	 *            the constraint metadata
	 * 
	 * @return the UML constraint element
	 */
	private Constraint getUMLConstraint(EObject metadata) {
		return (Constraint) UMLUtil.getBaseElement(metadata);
	}
}
