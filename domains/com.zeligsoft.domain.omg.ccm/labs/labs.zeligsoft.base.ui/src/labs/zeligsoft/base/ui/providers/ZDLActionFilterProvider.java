/**
 * 
 */
package labs.zeligsoft.base.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderPolicy;
import org.eclipse.gmf.runtime.emf.ui.services.action.AbstractModelActionFilterProvider;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class ZDLActionFilterProvider
	extends AbstractModelActionFilterProvider
	implements IProviderPolicy{

	private final String IS_NOT_ZDL_CONCEPT = "isNotZDLConcept"; //$NON-NLS-1$ 
	
	@Override
	protected boolean doProvides(IOperation operation) {
		return true;
	}

	@Override
	protected boolean doTestAttribute(Object target, String name, String value) {
		if(IS_NOT_ZDL_CONCEPT.equals(name)) {
			if(target instanceof IAdaptable) {
				Element element = (Element) ((IAdaptable) target)
					.getAdapter(Element.class);
				if(element != null){
					return !ZDLUtil.isZDLConcept(element, value);
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
