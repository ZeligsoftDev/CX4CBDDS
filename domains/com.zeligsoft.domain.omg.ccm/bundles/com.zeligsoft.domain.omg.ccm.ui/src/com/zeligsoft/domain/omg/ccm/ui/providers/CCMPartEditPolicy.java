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
package com.zeligsoft.domain.omg.ccm.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

/**
 * EditPolicyProvider which removes the EditPolicy registered against the
 * <code>EditPolicyRoles.OPEN_ROLE</code> for all components which are not a
 * ZMLMM::ZML_Component::StructuralRealization.
 * 
 * @author mtate
 * 
 */
public class CCMPartEditPolicy extends OpenEditPolicy {

	protected Command getOpenCommand(Request request) {
		// Only want to handle Requests of type SelectionRequest
		// otherwise we'll be running through this for regular
		// Requests as well
		if (!(request instanceof SelectionRequest)) {
			return null;
		}

		EditPart part = getTargetEditPart(request);
		Node node = (Node) part.getAdapter(Node.class);
		Property property = (Property) node.getElement();
		EObject type = property.getType();

		List<EObject> assemblyImplementations = new ArrayList<EObject>();
		for (EStructuralFeature.Setting setting : UMLUtil
				.getInverseReferences((Component) type)) {
			EObject obj = setting.getEObject();
			if (obj instanceof Generalization) {
				EObject eo = ((Generalization) obj).eContainer();
				if (ZDLUtil.isZDLConcept(eo, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
					assemblyImplementations.add(eo);
				}
			}
		}

		if (!assemblyImplementations.isEmpty()) {
			Component result = null;

			if (assemblyImplementations.size() == 1) {
				result = (Component) assemblyImplementations.get(0);
			} else {
				// ask the user to see which assembly implementation they'd like
				// to view
				PopupDialog pud = new PopupDialog(null, assemblyImplementations,
						new LabelProvider() {

							public String getText(Object element) {
								return ((Component) element).getName();
							}
						});
				pud.setTitle(Messages.PartEditPolicy_ViewStructureDiagramTitle);
				pud.setMessage(Messages.PartEditPolicy_PopupMessage);
				pud.open();

				result = (Component) pud.getResult()[0];
			}

			Diagram diagram = null;
			EAnnotation anno = result.getEAnnotation("uml2.diagrams"); //$NON-NLS-1$
			if(anno != null){
				for(EObject ref: anno.getContents()){
					if("Structure".equals(((Diagram)ref).getType())){ //$NON-NLS-1$
						diagram = (Diagram)ref;
						break;
					}
				}
			}
			if (diagram == null) {
				// could not find a structure diagram,
				// ask user if should create one
				boolean create = MessageDialog
						.openQuestion(null,
								Messages.PartEditPolicy_CreateStructureDiagramTitle, NLS
										.bind(Messages.PartEditPolicy_CreateQuestion,
												result.getName()));
				if (create) {
					ICommand command = UMLElementFactory.getCreateElementCommand(result,
							ElementTypeRegistry.getInstance().getType(
									"org.eclipse.gmf.runtime.notation.structureDiagram")); //$NON-NLS-1$
					try {
						command.execute(null, null);
						CommandResult commandResult = command.getCommandResult();
						Diagram diagramResult = (Diagram) commandResult.getReturnValue();
						if (diagramResult != null) {
							BaseUIUtil.showInProjectExplorer(diagramResult);
							DiagramUtil.openDiagramEditor(diagramResult);
						}
					} catch (ExecutionException e) {
						ZeligsoftCXUIPlugin.getDefault().error(
								"Failed to create a structure diagram", e); //$NON-NLS-1$
					}
				}
			} else {
				BaseUIUtil.showInProjectExplorer(diagram);
				DiagramUtil.openDiagramEditor(diagram);
			}
		} else {
			// if this is not an assembly then open component diagram if it
			// exists
			Diagram diagram = null;
			EAnnotation anno = ((Component) type)
					.getEAnnotation("uml2.diagrams"); //$NON-NLS-1$
			if (anno != null) {
				for (EObject ref : anno.getContents()) {
					if ("Component".equals(((Diagram) ref).getType())) { //$NON-NLS-1$
						diagram = (Diagram) ref;
						break;
					}
				}
			}
			if (diagram != null) {
				BaseUIUtil.showInProjectExplorer(diagram);
				DiagramUtil.openDiagramEditor(diagram);
			}
		}
		return null;
	}

}