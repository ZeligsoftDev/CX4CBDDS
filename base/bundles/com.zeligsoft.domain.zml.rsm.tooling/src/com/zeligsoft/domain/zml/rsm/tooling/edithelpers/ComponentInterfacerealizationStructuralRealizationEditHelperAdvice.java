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
package com.zeligsoft.domain.zml.rsm.tooling.edithelpers;

import com.ibm.xtools.modeler.ui.UMLModeler;

import com.ibm.xtools.uml.type.IStereotypedElementType;

import com.zeligsoft.domain.zml.rsm.tooling.types.ZMLElementTypes;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @generated
 */
public class ComponentInterfacerealizationStructuralRealizationEditHelperAdvice extends
        ZMLBaseEditHelperAdvice {

    /**
     * @generated
     */
    public ICommand getBeforeEditContextCommand(GetEditContextRequest request) {
        request.setEditContext(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION);
        IEditCommandRequest editRequest = request.getEditCommandRequest();
        if (editRequest instanceof CreateRelationshipRequest) {
            CreateRelationshipRequest crr = (CreateRelationshipRequest)editRequest;
            EObject source = crr.getSource();
            EObject target = crr.getTarget(); 
            
			if (source != null && target != null && UMLModeler.getLogicalResource(source) != UMLModeler.getLogicalResource(target)) { 
				return UnexecutableCommand.INSTANCE;
			} 
		}
        return super.getBeforeEditContextCommand(request);
    }
    
    /**
     * @generated
     */
    protected ICommand getAfterEditContextCommand(GetEditContextRequest request) {
        return new GetEditContextCommand(request);
    }
    
    /**
     * @generated
     */
    protected ICommand getBeforeCreateRelationshipCommand(
            final CreateRelationshipRequest request) {
        return new AbstractTransactionalCommand(request.getEditingDomain(),
                request.getLabel(), Collections.EMPTY_LIST) {

            /**
             * @generated
             */
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                Element source = (Element)request.getSource();
                IStereotypedElementType sourceType =(IStereotypedElementType)ZMLElementTypes
                        .getMatchingSource(request.getElementType(), request.getSource());
                Stereotype stereotype = source.getApplicableStereotype(sourceType.getStereotypeName());
                EObject sApp = source.getStereotypeApplication(stereotype);
                sApp.eSet(sApp.eClass().getEStructuralFeature("realization"), request.getTarget()); //$NON-NLS-1$
                return CommandResult.newOKCommandResult();
            }
            
        };
    }
}
