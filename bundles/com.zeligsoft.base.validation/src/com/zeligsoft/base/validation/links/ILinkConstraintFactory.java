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
package com.zeligsoft.base.validation.links;

import org.eclipse.uml2.uml.Constraint;

import com.zeligsoft.base.validation.util.InvalidConstraintException;

/**
 * A factory for creating link constraints. Factories are differentiated by
 * constraint {@link #getLanguage() language} and {@link #getKind() kind}.
 * 
 * @param <T>
 *            the kind of link constraint that I create
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface ILinkConstraintFactory<T extends ILinkConstraint> {

	/**
	 * Queries the constraint specification language for which I create link
	 * constraints.
	 * 
	 * @return my language
	 */
	String getLanguage();

	/**
	 * Queries the ZDL link constraint kind that I instantiate.
	 * 
	 * @return my kind
	 */
	String getKind();

	/**
	 * Creates a link constraint from the given ZDL specification.
	 * 
	 * @param specification
	 *            a ZDL model specification of a link constraint
	 * 
	 * @return a link constraint implementing the specification
	 * 
	 * @throws InvalidConstraintException
	 *             if any required constraint metadata be missing or malformed
	 */
	T createLinkConstraint(Constraint specification)
			throws InvalidConstraintException;

	/**
	 * Obtains the type of link constraint that I create. This needs not be a
	 * concrete class type, but one of the link constraint interfaces will
	 * suffice.
	 * 
	 * @return the type of link constraint that I create
	 */
	Class<T> getType();
}
