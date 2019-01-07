
package com.zeligsoft.ce.deployment.rsm.profile.tooling.edithelpers;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.ibm.xtools.uml.type.UMLElementTypes;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.l10n.ZDLDeploymentMessages;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.types.ZDLDeploymentElementTypes;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentUtil;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;

import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

import org.eclipse.gmf.runtime.notation.Diagram;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

/**
 * @generated
 */
public abstract class ZDLDeploymentBaseEditHelperAdvice
        extends AbstractEditHelperAdvice {
    
    /**
     * @generated
     */
    protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
        Element element = (Element)request.getElementToConfigure();
        Model model = element.getModel();
        
        // apply the profile to the model if it is not already applied
        if (model.getAppliedProfile(ZDLDeploymentUtil.PROFILE_NAME) == null) {
            ICommand cmd = UMLElementFactory
                .getCreateRelationshipCommand(model,
                    UMLElementTypes.PROFILE_APPLICATION, model, ZDLDeploymentUtil.getProfile());
            return cmd != null ? cmd : UnexecutableCommand.INSTANCE;
        }
        return null;
    }
    
    /**
     * @generated
     */
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

        final EObject eObject = request.getElementToConfigure();
        final EObject container = eObject.eContainer();
        final EReference reference = eObject.eContainmentFeature();
        
        return new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(eObject),
            ZDLDeploymentMessages.CommandLabel_autoName, null) {

            protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
                    IAdaptable info)
                    throws ExecutionException {

                autoName(container, reference, eObject);
                return CommandResult.newOKCommandResult();
            }
        
        };
    }
    
    /**
     * @generated
     */
    protected ICommand getBeforeEditContextCommand(GetEditContextRequest request) {
        IEditCommandRequest editRequest = request.getEditCommandRequest();
        if (editRequest instanceof CreateRelationshipRequest) {
            CreateRelationshipRequest crr = (CreateRelationshipRequest)editRequest;
            EObject source = crr.getSource();
            EObject target = crr.getTarget();
            
            IElementType type = crr.getElementType();
            
            if (source != null) {
                if (!ZDLDeploymentElementTypes.matchesSource(type, source)) {
                    return UnexecutableCommand.INSTANCE;
                }
            }
            if (target != null) {
                if (!ZDLDeploymentElementTypes.matchesTarget(type, target)) {
                    return UnexecutableCommand.INSTANCE;
                }
            }
        }
        
        return super.getBeforeEditContextCommand(request);
    }
    
    /**
     * Return the localized name of the given EObject.
     * 
     * @param eObject
     * @return the localized name
     * @generated
     */
    protected String getLocalizedName(EObject eObject) {
        return PackageUtil.getLocalizedName(eObject.eClass());
    }
    
    /**
     * Set the auto name for the given EObject.
     * 
     * @param eObject
     * @param name
     * @generated
     */
    protected void setAutoName(EObject eObject, String name) {
        if (eObject instanceof NamedElement)
            ((NamedElement) eObject).setName(name);
        else if (eObject instanceof Diagram)
            ((Diagram) eObject).setName(name);
    }
    
    /**
     * Get the name for the given EObject.
     * 
     * @param eObject
     * @return String name
     * @generated
     */
    protected String getName(EObject eObject) {
        if (eObject instanceof NamedElement)
            return ((NamedElement) eObject).getName();
        else if (eObject instanceof Diagram)
            return ((Diagram) eObject).getName();
        else
        	return null;
    }
    
    /**
     * Auto name the given EObject.
     * 
     * @param container
     * @param reference
     * @param eObject
     * @generated
     */
    protected void autoName(EObject container, EReference reference,
            EObject eObject) {

        String originalName = getLocalizedName(eObject);
    
        if (originalName != null) {
            if (reference.isMany()) {
                String name = originalName;
                Set set = new HashSet();
                Iterator i = ((Collection) container.eGet(reference))
                    .iterator();
                while (i.hasNext()) {
                    Object sibling = i.next();
                    if (sibling != null) {
                        String n = null;
                        
                        // add extra conditions for other model elements
                        if (sibling instanceof NamedElement)
                            n = ((NamedElement) sibling).getName();
                        else if (sibling instanceof Diagram)
                            n = ((Diagram) sibling).getName();
    
                        if (n != null)
                            set.add(n);
                    }
                }
    
                for (int j = 1; j <= Integer.MAX_VALUE; j++) {
                    String n = (j == 1) ? name : name + j;
                    if (!set.contains(n)) {
                        name = n;
                        break;
                    }
                }
                if (!name.equals(getName(eObject)))
                    setAutoName(eObject, name);
            }
        }
    }
}