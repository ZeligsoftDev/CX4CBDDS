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
package com.zeligsoft.base.validation.util;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.validation.links.IBinaryLinkConstraint;
import com.zeligsoft.base.validation.links.LinkConstraintManager;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Miscellaneous utility operations in support of the constraint provider.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ValidationUtil
		extends UMLUtil {

	/**
	 * The qualified name of the steoreotype for the external domain
	 * constraint.
	 */
	private static final String EXTERNAL_DOMAIN_CONSTRAINT_STEREOTYPE = 
		"ZDL::ExternalDomainConstraint"; //$NON-NLS-1$

	/**
	 * The qualified name of the stereotype for domain constraints.
	 */
	private static final String DOMAIN_CONSTRAINT_STEREOTYPE = 
		"ZDL::DomainConstraint"; //$NON-NLS-1$
	
	/**
	 * The prefix on a localizable string indicating that it is a reference to a
	 * key in the <tt>*.properties</tt> file of the model.
	 */
	private static final String LOCALIZATION_KEY_PREFIX = "%"; //$NON-NLS-1$

	/**
	 * Not instantiable by clients.
	 */
	private ValidationUtil() {
		super();
	}

	/**
	 * Obtains a best-effort qualified name for the specified constraint. This
	 * will be the constrain'ts actual qualified name, if the constraint has a
	 * name, other wise an indication of which constraint it is in its context
	 * element.
	 * 
	 * @param constraint
	 *            a constraint in a ZDL model
	 * 
	 * @return its qualified name, or a best effort
	 */
	public static String getQualifiedName(Constraint constraint) {
		String result = constraint.getQualifiedName();

		if (result == null) {
			Namespace context = constraint.getContext();

			if (context == null) {
				result = "<constraint>"; //$NON-NLS-1$
			} else {
				result = String.format("%s::<ownedRule>[%d]", context //$NON-NLS-1$
					.getQualifiedName(), context.getOwnedRules().indexOf(
					constraint));
			}
		}

		return result;
	}

	/**
	 * Determines the ID of the plug-in that deploys the resource containing an
	 * object. If it cannot be determined, some suitable string is returned,
	 * instead.
	 * 
	 * @param eobject
	 *            an object
	 * 
	 * @return the providing plug-in ID
	 */
	public static String getPluginID(EObject eobject) {
		String result = Messages.ValidationUtil_unknownProvider;

		Resource res = eobject.eResource();
		if (res != null) {
			URI uri = res.getURI();

			ResourceSet rset = res.getResourceSet();
			if (rset != null) {
				uri = rset.getURIConverter().normalize(uri);
			}

			if (uri.isPlatformPlugin()) {
				result = uri.segment(1);
			}
		}

		return result;
	}

	/**
	 * Obtains the localized form of the specified text, or the original text if
	 * it is not localized. The specified constraint provides the context in
	 * which we are localizing the string, which would be usually be some
	 * particle of validation metadata for this constraint.
	 * 
	 * @param constraint
	 *            the context constraint element of localization
	 * @param text
	 *            the text to localize. If it starts with <tt>%</tt> then it is
	 *            assumed to be a reference to a string in the model's
	 *            <tt>*.properties</tt> file
	 * 
	 * @return the localized text, or the original if <tt>text</tt> does not
	 *         denote a localization key
	 */
	public static String localize(Constraint constraint, String text) {
		String result = text;
		String trim = text.trim();

		if (trim.startsWith(LOCALIZATION_KEY_PREFIX)) {
			String key = trim.substring(LOCALIZATION_KEY_PREFIX.length());
			result = getString(constraint, key, text, true);
		}

		return result;
	}

	/**
	 * Queries whether it is permitted, according to the link constraints
	 * defined in the specified context, to link the given source element to the
	 * target element.
	 * 
	 * @param ctx
	 *            the application context in which to test the link
	 * @param source
	 *            the proposed source of a binary link
	 * @param target
	 *            the proposed target of a binary link
	 * 
	 * @return whether the link will be valid according to the available link
	 *         constraints
	 */
	public static boolean canLink(LinkConstraintContext ctx, EObject source,
			EObject target) {

		boolean result;
		
		Collection<IBinaryLinkConstraint> constraints = LinkConstraintManager
			.getInstance().getConstraints(ctx, source, target);

		if (constraints.isEmpty()) {
			result = !ctx.isExplicit();
		} else {
			result = true;
	
			for (Iterator<IBinaryLinkConstraint> iter = constraints.iterator(); 
				result == true && iter.hasNext();) {
				result = iter.next().test(source, target);
			}
		}
		
		return result;
	}
	
	public static String getLinkContext(LinkConstraintContext ctx, EObject source, EObject target ) {
		
		Collection<IBinaryLinkConstraint> constraints = LinkConstraintManager
			.getInstance().getConstraints(ctx, source, target);

		if (constraints.isEmpty()) {
			return null;
		} else {			
	
			for (Iterator<IBinaryLinkConstraint> iter = constraints.iterator(); 
				iter.hasNext();) {
				
				String result = iter.next().getLinkContext(source, target);
				if( result != null ) {
					return result;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Find the domain constraint stereotype that is applied to the constraint.
	 * 
	 * @param constraint
	 * 			The constraint to find the stereotype on.
	 * @return
	 * 			The domain constraint stereotype, it will be null if not
	 * 			domain constraint stereotype can be found.
	 */
	public static Stereotype getConstraintStereotype(Constraint constraint) {
		org.eclipse.uml2.uml.Stereotype stereotype;
		if(ZDLUtil.isZDLConcept(constraint, ZDLNames.EXTERNAL_DOMAIN_CONSTRAINT)) {
			stereotype 
				= constraint.getAppliedStereotype(EXTERNAL_DOMAIN_CONSTRAINT_STEREOTYPE);
		} else {
			stereotype
				= constraint.getAppliedStereotype(DOMAIN_CONSTRAINT_STEREOTYPE);
		}
		
		return stereotype;
	}
	
	/**
	 * Returns the context of a constraint in a domain, it considers the type
	 * of contraint.
	 * 
	 * @param constraint
	 * 			The constraint from the domain.
	 * @return
	 * 			The qualified name of the domain concept that is the
	 * 			context of the constraint
	 */
	public static String getConstraintContext(Constraint constraint) {
		String context = ""; //$NON-NLS-1$
		
		if(ZDLUtil.isZDLConcept(constraint, ZDLNames.EXTERNAL_DOMAIN_CONSTRAINT)) {
			if(!constraint.getConstrainedElements().isEmpty()) {
				Element constrainedElement =
					constraint.getConstrainedElements().get(0);
				if(ZDLUtil.isZDLConcept(constrainedElement, ZDLNames.DOMAIN_CONCEPT)) {
					context =
						((Class) constrainedElement).getQualifiedName();
				} else {
					new IllegalArgumentException("the context is not a domain concept"); //$NON-NLS-1$
				}
			} else {
				new IllegalArgumentException("the constraint does not contain a constrained element"); //$NON-NLS-1$
			}
			
		} else {
			context = constraint.getContext().getQualifiedName();
		}
		
		return context;
	}
}
