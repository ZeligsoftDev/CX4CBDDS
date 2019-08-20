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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;

/**
 * A specialized link constraint for the very common case of directed
 * associations and other kinds of directed relationships. These allow an
 * application to test whether linking (in some abstract sense) a
 * <em>source</em> element to a <em>target</em> element should be permitted.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface IBinaryLinkConstraint
		extends ILinkConstraint {

	/**
	 * Queries the name of my source role, when treating me as a special case of
	 * an {@linkplain ILinkConstraint N-tuple constraint}. The default source
	 * role, when none is specified, is <code>"source"</code>.
	 * 
	 * @return my source role
	 */
	String getSourceRole();

	/**
	 * Sets my source role name, for treating me as a special case of an
	 * {@linkplain ILinkConstraint N-tuple constraint}.
	 * 
	 * @param name
	 *            my source role name
	 */
	void setSourceRole(String name);

	/**
	 * Queries the name of my target role, when treating me as a special case of
	 * an {@linkplain ILinkConstraint N-tuple constraint}. The default target
	 * role, when none is specified, is <code>"target"</code>.
	 * 
	 * @return my target role
	 */
	String getTargetRole();

	/**
	 * Sets my target role name, for treating me as a special case of an
	 * {@linkplain ILinkConstraint N-tuple constraint}.
	 * 
	 * @param name
	 *            my target role name
	 */
	void setTargetRole(String name);

	/**
	 * Queries whether I constrain links to the specified target domain concept.
	 * 
	 * @param concept
	 *            a domain concept
	 * @return whether I constrain links between my source and the specified
	 *         concept
	 */
	boolean targets(Class concept);

	/**
	 * Tests whether a configuration that links, in some abstract sense, the
	 * specified <tt>source</tt> element to the <tt>target</tt> would be valid.
	 * 
	 * @param source
	 *            a proposed source element of a link
	 * @param target
	 *            a proposed target element of the link
	 * 
	 * @return <code>true</code> if a model that links the source to the target
	 *         would be valid according to my constraint; <code>false</code>,
	 *         otherwise
	 */
	boolean test(EObject source, EObject target);
	
	/**
	 * In some cases it may be desirable to attach semantic meaning on top of the
	 * determination of whether a <tt>source</tt> element can be linked to a 
	 * <tt>target</tt> element. If such information exists, this method retrieves it. 
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	String getLinkContext(EObject source, EObject target);
}
