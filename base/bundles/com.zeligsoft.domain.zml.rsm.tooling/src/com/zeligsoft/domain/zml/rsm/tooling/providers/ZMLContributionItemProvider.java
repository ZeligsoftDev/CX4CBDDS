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
package com.zeligsoft.domain.zml.rsm.tooling.providers;

import com.zeligsoft.domain.zml.rsm.tooling.utils.ZMLUtil;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.requests.CreateRequest;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;

import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.widgets.Display;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import org.eclipse.uml2.uml.Element;

import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * @generated
 */
public class ZMLContributionItemProvider
        extends AbstractContributionItemProvider {
    
    /**
     * @generated
     */
    private static class MenuAction extends Action {
        public MenuAction(String text) {
            setText(text);
        }
    }
    
    /**
     * @generated
     */
    protected IMenuManager createMenuManager(
            String menuId,
            IWorkbenchPartDescriptor partDescriptor) {
        return super.createMenuManager(menuId, partDescriptor);
    }   

    /**
     * @generated
     */
    protected IAction createAction(
            String actionId,
            IWorkbenchPartDescriptor partDescriptor) {

        IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
        IEditorPart editorPart = workbenchPage.getActiveEditor();
        if (editorPart instanceof IDiagramWorkbenchPart) {
            ResourceSet resourceSet =
                TransactionUtil.getEditingDomain(
                        ((IDiagramWorkbenchPart)editorPart).getDiagram()).getResourceSet();
        }

        return super.createAction(actionId, partDescriptor);
    }

    /**
     * @generated
     */
    private class CreateElementAction
            extends DiagramAction {
    
        /**
         * @generated
         */
        private Element umlElement;
        
        /**
         * @generated
         */
        private IElementType elementType;
        
        /**
         * @generated
         */
        public CreateElementAction(
                IWorkbenchPage workbenchPage,
                String qualifiedName,
                String id,
                String label,
                ImageDescriptor imageDescriptor) {
                super(workbenchPage);
    
           setId(id);
           setText(label);
           setToolTipText(label);
                
           assert workbenchPage.getActiveEditor() instanceof DiagramEditor;
           DiagramEditor editor = (DiagramEditor) workbenchPage.getActiveEditor();
                
           Collection elements = UMLUtil.findNamedElements(editor.getDiagram().eResource().getResourceSet(), qualifiedName);
           if (elements.size() > 0) {
               this.umlElement = (Element) elements.iterator().next();
           }
                
           if (imageDescriptor == null) {
               setImageDescriptor(new ElementTypeImageDescriptor(ElementTypeRegistry.getInstance().getElementType(umlElement)));
           }
	       else {
	           setImageDescriptor(imageDescriptor);
	       }
        }
        
        /**
         * @generated
         */
        public CreateElementAction(
                IWorkbenchPage workbenchPage,
                IElementType elementType,
                String id,
                String label,
                ImageDescriptor imageDescriptor) {
           super(workbenchPage);
    
           this.elementType = elementType;
    
           setId(id);
           setText(label);
           setToolTipText(label);
                
           if (imageDescriptor == null) {
	           setImageDescriptor(new ElementTypeImageDescriptor(elementType));
	       }
	       else {
	           setImageDescriptor(imageDescriptor);
	       }
        }    
        
        /**
         * @generated
         */
        protected void doRun(IProgressMonitor progressMonitor) {
            Command command = getCommand();
    
            if (command != null) {
                getDiagramGraphicalViewer()
                    .getEditDomain()
                    .getCommandStack()
                    .execute(
                    command);
                selectNewObject();
            }
        }
        
        /**
         * @generated
         */
        protected Request createTargetRequest() {
            if (umlElement != null) {
                return new CreateViewRequest(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(umlElement), PreferencesHint.USE_DEFAULTS));
            }
            if (elementType != null) {
                return new CreateViewAndElementRequest(elementType, getPreferencesHint());
            }
            return null;
        }
        
        /**
         * Selects the newly added shape view.
         *
         * @generated
         */
        private void selectNewObject() {
    
            final IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();
            if (viewer != null) {
            
                final Object newObject =
                    ((CreateRequest) getTargetRequest()).getNewObject();
            
                
                assert newObject instanceof Collection;
                assert ((Collection) newObject).size() == 1;
                
                IAdaptable viewAdapter = (IAdaptable) ((Collection) newObject).iterator().next();
                
                final EditPart editPart =
                    (EditPart) viewer.getEditPartRegistry().get(
                        viewAdapter.getAdapter(View.class));
                
                if (editPart != null) {
                    viewer.setSelection(new StructuredSelection(editPart));
                    Display.getCurrent().asyncExec(new Runnable() {
                        public void run() {
                            editPart.performRequest(
                                new Request(RequestConstants.REQ_DIRECT_EDIT));
                        }
                    });
                    
                }
            }
            
        }
        
        /**
         * @generated
         */
        protected boolean isSelectionListener() {
            return true;
        }        
    }
}