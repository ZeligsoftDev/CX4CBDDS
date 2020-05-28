/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.providers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.zeligsoft.base.Activator;

/**
 * @author eposse
 */
public class ResolvingUMLFilteredLabelProvider extends UMLFilteredLabelProvider {
	
	@Override
	public boolean accept(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject)element;
			eObject = resolveProxy(eObject);
			return super.accept(eObject);
		}
		return super.accept(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject)element;
			eObject = resolveProxy(eObject);
			return super.getImage(eObject);
		}
		return super.getImage(element);
	}

	/**
	 * @param eObject - An {@link EObject}
	 * @return The resolved {@link EObject} is the given one is a proxy, or the given eObject itself otherwise.
	 */
	protected EObject resolveProxy(EObject eObject) {
		if (eObject.eIsProxy()) {
			Resource eClassResource = eObject.eClass().eResource();
//			if (eClassResource != null) {
//				ResourceSet eClassResourceSet = eClassResource.getResourceSet();
//				if (eClassResourceSet != null) {
//					URI proxyURI = ((InternalEObject)eObject).eProxyURI();
//					URI normalizedURI = eClassResourceSet.getURIConverter().normalize(proxyURI);
//					Resource eObjectResource = eClassResourceSet.getResource(normalizedURI, true);
//					ResourceSet eObjectResourceSet = eObjectResource.getResourceSet();
//					if (eObjectResourceSet != eClassResourceSet) {
//						Activator.getDefault().warning("Proxy resource set is not the same as it's eClass'");
//					}
//				}
//			}
			eObject = EcoreUtil.resolve(eObject, eClassResource);
		}
		return eObject;
	}

}
