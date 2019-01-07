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

import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;

import com.zeligsoft.base.validation.util.InvalidConstraintException;

/**
 * A factory for implementations of constraints defined in ZDL models. A factory
 * is registered for a particular {@linkplain #getLanguage() language}.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface IZDLConstraintFactory {

	/**
	 * Queries the language that I support. This is the language specified in
	 * the {@link OpaqueExpression} of the UML {@link Constraint}.
	 * 
	 * @return my constraint language
	 */
	String getLanguage();

	/**
	 * Creates a new implementation of the specified UML constraint.
	 * 
	 * @param umlConstraint
	 *            the UML specification of a constraint in my language
	 * @param body
	 *            the body text of the constraint's
	 *            {@link Constraint#getSpecification() specification} if it is
	 *            an {@link OpaqueExpression}
	 * @param descriptor
	 *            the constraint descriptor
	 * @return the new constraint implementation
	 * @throws InvalidConstraintException
	 *             if the constraint cannot be created because of invalid
	 *             descriptor metadata or problems in the UML constraint
	 */
	IModelConstraint createConstraint(Constraint umlConstraint, String body,
			IConstraintDescriptor descriptor)
			throws InvalidConstraintException;
}
