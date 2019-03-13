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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IModelConstraint;

import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * <p>
 * The specification of a constraint on general N-tuple of objects in a model.
 * The link constraint is a Boolean expression operating on an N-tuple of
 * objects that is <code>true</code> when a model that would link the objects
 * objects in their respective roles is valid and <code>false</code> when it
 * would be invalid. These constraints differ from validation rules primarily in
 * two respects:
 * </p>
 * <ul>
 * <li>they are a generalization of invariant constraints on a single object to
 * invariant constraints on tuples of N objects, or in UML terminology
 * <em>links</em> of N objects (an instance of an association)</li>
 * <li>they are intended, in a Zeligsoft application, to be evaluated
 * dynamically and <em>a priori</em>. Unlike {@linkplain IModelConstraint
 * validation rules} run on the current model state, link constraints determine
 * whether an action that would configure objects in some relationship should be
 * permitted</li>
 * </ul>
 * <p>
 * A specialized link constraint intended for directed associations or other
 * relationships is the {@link IBinaryLinkConstraint}.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see IBinaryLinkConstraint
 * @see IModelConstraint
 */
public interface ILinkConstraint {

	/**
	 * Obtains my string identifier.
	 * 
	 * @return my ID
	 */
	String getID();
	
	/**
	 * Queries the constraint's name, localized if available, in the ZDL model
	 * in which it is defined.
	 * 
	 * @return the constraint name
	 */
	String getName();
	
	/**
	 * Obtains the application context to which I apply.
	 * 
	 * @return my context
	 */
	LinkConstraintContext getContext();

	/**
	 * Queries whether the specified N-tuple object objects, in named roles, is
	 * a valid configuration according to my constraint.
	 * 
	 * @param nTuple
	 *            a set of <em>(role-name, element)</em> pairs
	 * 
	 * @return <code>true</code> in the <tt>nTuple</tt> is valid;
	 *         <code>false</code> otherwise
	 */
	boolean test(Map<String, ? extends EObject> nTuple);
}
