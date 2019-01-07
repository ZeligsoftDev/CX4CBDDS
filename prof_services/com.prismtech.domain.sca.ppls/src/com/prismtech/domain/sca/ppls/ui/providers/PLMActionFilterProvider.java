/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderPolicy;
import org.eclipse.gmf.runtime.emf.ui.services.action.AbstractModelActionFilterProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.prismtech.domain.sca.ppls.utils.PLMNames;

/**
 * Action filter which provides action clients with access to determining if an
 * element is a particular PLM Concept.
 * 
 * 
 * @author mciobanu
 * 
 */
public class PLMActionFilterProvider extends AbstractModelActionFilterProvider
		implements IProviderPolicy {

	/**
	 * The tag used to test that the element is a PLM Concept.
	 */
	final private String IS_PLM_PROFILE = "isPLMProfile"; //$NON-NLS-1$

	@Override
	protected boolean doProvides(IOperation operation) {
		return true;
	}

	@Override
	protected boolean doTestAttribute(Object target, String name, String value) {
		if (IS_PLM_PROFILE.equals(name) && PLMNames.VARIATION_POINT_PROFILE.equals(value)) {
			if (target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
						.getAdapter(Element.class);
				if (element != null) {
					Package context = (Package) element;
					if(context instanceof Model){
						for (Profile p : context.getAllAppliedProfiles()) {
							if(!UMLUtil.isEmpty(p.getName())){
								if (p.getName().equals(PLMNames.VARIATION_POINT_PROFILE)) {
									return true;
								}
							}
						}
					}
					return false;
				}
			}
		}
		return false;
	}

	@Override
	protected TransactionalEditingDomain getEditingDomain(Object target) {
		if (target instanceof IAdaptable) {
			EObject eObject = (EObject) ((IAdaptable) target)
					.getAdapter(EObject.class);
			if (eObject != null)
				return TransactionUtil.getEditingDomain(eObject);
		}
		return null;
	}
}
