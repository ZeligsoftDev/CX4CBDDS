package com.prismtech.domain.sca.ppls.commands;

import java.util.Collections;
import java.util.UUID;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public abstract class AbstractAddVariationPointCommand extends AbstractTransactionalCommand
{
    private final EObject eobject;
    private final String profileQualifiedName;

    public AbstractAddVariationPointCommand( String commandLabel, String profileQualifiedName, EObject eobject )
    {
        super( TransactionUtil.getEditingDomain( eobject ), commandLabel, Collections.EMPTY_MAP, null );
        this.eobject = eobject;
        this.profileQualifiedName = profileQualifiedName;
    }

    protected abstract boolean canElementBeConstrained( EObject eobject );

    @Override
    protected CommandResult doExecuteWithResult( IProgressMonitor arg0, IAdaptable arg1 ) throws ExecutionException
    {
        if( canElementBeConstrained( eobject ) ) {
            Constraint newConstraint = UMLFactory.eINSTANCE.createConstraint();
            for( ProfileApplication p : ((Element)eobject).getModel().getAllProfileApplications()) {
                if( PLMNames.VARIATION_POINT_PROFILE.equals( p.getAppliedProfile().getName() )) {
                    for( Stereotype s : p.getAppliedProfile().getOwnedStereotypes()) {
                        if( profileQualifiedName.equals( s.getQualifiedName() )) {
                            ((Namespace)eobject.eContainer()).getOwnedRules().add(newConstraint);
                            newConstraint.applyStereotype(s);
                            newConstraint.getConstrainedElements().add((Element)eobject);
                            String elementName = (String) ZDLUtil.getValue(eobject, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME);                            
                            if(UMLUtil.isEmpty(elementName)){
                            	elementName = "";
                            }
                            newConstraint.setName(elementName);
                            OpaqueExpression value = UMLFactory.eINSTANCE.createOpaqueExpression();
                            newConstraint.setSpecification(value);

                            String uuid = UUID.randomUUID().toString();
                            newConstraint.setValue(s, PLMNames.VARIATION_POINT__VP_ID, "VP-" + uuid); //$NON-NLS-1$

                            break;
                        }
                    }
                    break;
                }
            }
        }

        return CommandResult.newOKCommandResult();
    }
}
