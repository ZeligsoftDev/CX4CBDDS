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
package com.zeligsoft.domain.idl3plus.ui.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.connectorregistry.ConnectorRegistry;
import com.zeligsoft.domain.idl3plus.connectorregistry.ConnectorRegistry.PortIconConfiguration;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.utils.PortDecorationImages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class PortDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	private final String IDL3PLUS_PORT_DECORATOR = "IDL3Plus Port Decorator";//$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 */
	public void createDecorators(IDecoratorTarget target) {
		EditPart editPart = (EditPart) target.getAdapter(EditPart.class);
		if(editPart != null && editPart instanceof IPrimaryEditPart) {
			target.installDecorator(IDL3PLUS_PORT_DECORATOR, 
					new CCMPortDecorator(target));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if(!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if(editPart != null && editPart instanceof IPrimaryEditPart) {
			Object model = editPart.getModel();
			if(!(model instanceof View)) {
				return false;
			}
			EObject element = ViewUtil.resolveSemanticElement((View) model);
			return (element != null)
					&& (ZDLUtil.isZDLConcept(element, CCMNames.INTERFACE_PORT) || ZDLUtil
							.isZDLConcept(element, CCMNames.EVENT_PORT));
		}
		
		return false;
	}
	
	public static class CCMPortDecorator
		extends AbstractDecorator
		implements NotificationListener, LayoutListener {

		/**
		 * Offset for the decoration in a Part, an offset is necessary since it is
		 * located in the SOUTH WEST corner of the shape.
		 */
		private int partOffset = -4;

		/**
		 * Offset for the decoration in a Port, in this case an offset is not
		 * necessary since the decoration has a CENTRE location.
		 */
		private int portOffset = 0;
		
		private static ConnectorRegistry connectorRegistry = ConnectorRegistry.getInstance();

		/**
		 * @param decoratorTarget
		 */
		public CCMPortDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		public void notifyChanged(Notification notification) {
			if (notification.getFeature() == null || getElement() == null) {
				return;
			}
			if(notification.getNotifier() instanceof Port && !ZDLUtil.isZDLConcept((EObject)notification.getNotifier(), ZMLMMNames.CONJUGATED_PORT)){
				return;
			}
			if(notification.getFeature().equals(ZDLUtil.getPropertyMapping(ZMLMMNames.CONJUGATED_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED, getElement()))) {
				EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
						EditPart.class);
				if (editPart.isActive()) {
					editPart.refresh();
				}
			}else if (notification.getFeature().equals(
				UMLPackage.eINSTANCE.getPort_Required()) || 
				notification.getFeature().equals(
						UMLPackage.eINSTANCE.getPort_Provided()) || 
						(notification.getNotifier() instanceof Port && notification.getFeature().equals(UMLPackage.eINSTANCE.getTypedElement_Type()))) {

				if (notification.getEventType() == Notification.ADD ||
						notification.getEventType() == Notification.REMOVE ||
						notification.getEventType() == Notification.SET) {
					if (notification.getNewValue() != null
						&& notification.getOldValue() == null) {
						TransactionalEditingDomain txDomain = TransactionUtil
							.getEditingDomain(getElement());
						DiagramEventBroker.getInstance(txDomain)
							.addNotificationListener(
								((Property) getElement()).getUpperValue(), this);
					} else if (notification.getNewValue() == null
						&& notification.getOldValue() != null) {
						TransactionalEditingDomain txDomain = TransactionUtil
							.getEditingDomain(getElement());
						DiagramEventBroker.getInstance(txDomain)
							.removeNotificationListener(
								((Property) getElement()).getUpperValue(), this);
					}
				}
				EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
				if (editPart.isActive()) {
					editPart.refresh();
				}

			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#activate()
		 */
		public void activate() {
			addListener();
			refresh();
			
		}
		
		@Override
		public void deactivate() {

			removeListener();
			super.deactivate();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#refresh()
		 */
		public void refresh() {
			removeDecoration();
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if(!(editPart instanceof IPrimaryEditPart)) {
				return;
			}
			updateImage();
		}
		
		@SuppressWarnings("unchecked")
		private void hideAntena() {
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			
			final List<Node> nodesToHide = new ArrayList<Node>();
			Set<Object> viewChildren = new HashSet<Object>();
			viewChildren.addAll(view.getTransientChildren());
			if (viewChildren.isEmpty()) {
				viewChildren.addAll(view.getPersistedChildren());
			}
			for (final Object o : viewChildren) {
				if (o instanceof Node) {
					if (!((Node) o).isVisible()) {
						continue;
					}
					if (((Node) o).getType() == "InterfaceRequired" //$NON-NLS-1$
							|| ((Node) o).getType() == "InterfaceProvided") { //$NON-NLS-1$
						nodesToHide.add((Node) o);
					}
				}
			}
			if (nodesToHide.size() == 0) {
				return;
			}
			AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
					UMLModeler.getEditingDomain(),
					"HidePortInterfaceDecorator", Collections.EMPTY_MAP, null) { //$NON-NLS-1$

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {
					for (Node node : nodesToHide) {
						node.setVisible(false);
					}
					return CommandResult.newOKCommandResult();
				}

				@Override
				public boolean canUndo() {
					return false;
		}
			};

			try {
				OperationHistoryFactory.getOperationHistory().execute(editCommand, null,
						null);
			} catch (ExecutionException e) {
				Activator.getDefault().error("Error hiding port interface decoration", e); //$NON-NLS-1$
			}
		} 
		
		/**
		 * Returns the offset based on the type of the semantic element.
		 * 
		 * @return
		 */
		private int getOffset() {

			int offSet = partOffset;

			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view.getElement() instanceof Port) {
				offSet = portOffset;
			}

			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);

			return MapModeUtil.getMapMode(((ShapeEditPart) editPart).getFigure())
				.DPtoLP(offSet);

		}
		
		/**
		 * Adds this as listener to the DiagramEventBroker.
		 */
		private void addListener() {
			final EObject element = getElement();
			TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(element);
			DiagramEventBroker.getInstance(txDomain).addNotificationListener(
				element, this);
			if (((Property) element).isMultivalued()) {
				DiagramEventBroker.getInstance(txDomain).addNotificationListener(
					((Property) element).getUpperValue(), this);
			}
			
			if(ZDLUtil.isZDLConcept(element, ZMLMMNames.PORT)) {
				for(EObject s : ((Element) element).getStereotypeApplications()) {
					DiagramEventBroker.getInstance(txDomain).addNotificationListener(
							s, this);
				}
			}
			
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if(editPart instanceof IBorderItemEditPart) {
				final IBorderItemEditPart biep = (IBorderItemEditPart) editPart;
				BorderedNodeFigure figure = (BorderedNodeFigure) biep.getFigure();
				IFigure bicf = figure.getBorderItemContainer();
				bicf.addLayoutListener(this);
			}
		}
		
		/**
		 * Removes this as listener to the DiagramEventBroker.
		 */
		private void removeListener() {

			EObject element = getElement();

			if (element == null) {
				// Safe to return since the listener implementation
				// uses a weak reference to cache listeners.
				return;
			}

			TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(element);

			if (txDomain == null) {
				return;
			}
			DiagramEventBroker.getInstance(txDomain).removeNotificationListener(
				element, this);

			if (((Property) element).isMultivalued()) {
				DiagramEventBroker.getInstance(txDomain)
					.removeNotificationListener(
						((Property) element).getUpperValue(), this);
			}
			
			if(ZDLUtil.isZDLConcept(element, ZMLMMNames.PORT)) {
				for(EObject s : ((Element) element).getStereotypeApplications()) {
					DiagramEventBroker.getInstance(txDomain).removeNotificationListener(
							s, this);
				}
			}
			
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if(editPart instanceof IBorderItemEditPart) {
				final IBorderItemEditPart biep = (IBorderItemEditPart) editPart;
				BorderedNodeFigure figure = (BorderedNodeFigure) biep.getFigure();
				IFigure bicf = figure.getBorderItemContainer();
				bicf.removeLayoutListener(this);
			}

		}

		/**
		 * Returns the model element which is represented by the target.
		 * 
		 * @return
		 */
		private EObject getElement() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);
			Object model = editPart.getModel();
			if (!(model instanceof View)) {
				return null;
			}
			return ViewUtil.resolveSemanticElement((View) model);

		}

		/* (non-Javadoc)
		 * @see org.eclipse.draw2d.LayoutListener#invalidate(org.eclipse.draw2d.IFigure)
		 */
		@Override
		public void invalidate(IFigure container) {
			// nothing
			
		}

		/* (non-Javadoc)
		 * @see org.eclipse.draw2d.LayoutListener#layout(org.eclipse.draw2d.IFigure)
		 */
		@Override
		public boolean layout(IFigure container) {
			return false;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.draw2d.LayoutListener#postLayout(org.eclipse.draw2d.IFigure)
		 */
		@Override
		public void postLayout(IFigure container) {
			updateImage();
		}

		/**
		 * 
		 */
		private void updateImage() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if(!(editPart instanceof IPrimaryEditPart)) {
				return;
			}
			
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			EObject element = ViewUtil.resolveSemanticElement(view);
			int portSide = -1;
			Image image = null;
			boolean isConjugated = false;
			
			if(!(editPart instanceof IBorderItemEditPart)){
				return;
			}
				
			if(ZDLUtil.isZDLConcept(element, ZMLMMNames.PORT)) {
				IBorderItemEditPart borderItemEditPart = (IBorderItemEditPart) editPart;
				IBorderItemLocator portLocator = borderItemEditPart.getBorderItemLocator();

				if (System.getProperty("os.name").startsWith("Linux")) { //$NON-NLS-1$//$NON-NLS-2$
					IFigure figure = borderItemEditPart.getFigure();
					if (figure.getBorder() == null) {
						figure.setBorder(new LineBorder(ColorConstants.black, 1));
					}
				}
				
				if(portLocator == null){
					return;
				}
				portSide = portLocator.getCurrentSideOfParent();
			}
			
			if(ZDLUtil.isZDLConcept(element, ZMLMMNames.CONJUGATED_PORT)) {
				Object isConjugatedObj = 
					ZDLUtil.getValue(element, ZMLMMNames.CONJUGATED_PORT, 
							ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED);
				
				if(isConjugatedObj instanceof Boolean) {
					isConjugated = (Boolean) isConjugatedObj;
				}
			}
			
			Port port = (Port) element;
			Type portType = port.getType();
			if(portType == null){
				return;
			}
			
			String portTypeQName = portType.getQualifiedName();
			EObject moduleInstantiation = IDL3PlusUtil
					.getTemplateInstantiation(portType);
			if (moduleInstantiation != null) {
				String relativeQName = portType.getQualifiedName()
						.replace(
								EMFCoreUtil.getQualifiedName(
										moduleInstantiation, true),
								UML2Util.EMPTY_STRING);
				EObject templateModule = IDL3PlusUtil
						.getTypedTemplateModuleForInstantiation(moduleInstantiation);
				if (templateModule != null) {
					portTypeQName = EMFCoreUtil.getQualifiedName(
							templateModule, true) + relativeQName;
				}
			}
			PortIconConfiguration iconConfiguration = connectorRegistry
					.getPortIconConfiguration(portTypeQName);

			if (iconConfiguration != null) {
				// we have custom port type icon
				if (isConjugated) {
					image = PortDecorationImages
							.getPortIcon(
									iconConfiguration.getContributorName(),
									iconConfiguration.getConjugatedIconPath(),
									portSide);
				} else {
					image = PortDecorationImages.getPortIcon(
							iconConfiguration.getContributorName(),
							iconConfiguration.getDefaultIconPath(), portSide);
				}
			}
			
			if (image == null) {
				if (ZDLUtil.isZDLConcept(element, CCMNames.EVENT_PORT)) {
					if (isConjugated) {
						image = PortDecorationImages.getPublisherIcon(portSide);
					} else {
						image = PortDecorationImages.getConsumerIcon(portSide);
					}
				} else if (ZDLUtil.isZDLConcept(element,
						CCMNames.INTERFACE_PORT)
						&& ZDLUtil.isZDLConcept((EObject) portType,
								CORBADomainNames.CORBAINTERFACE)) {
					if (isConjugated) {
						image = PortDecorationImages
								.getReceptacleIcon(portSide);
					} else {
						image = PortDecorationImages.getFacetIcon(portSide);
					}
				}
			}
			
			if (image != null) {
				removeDecoration();
				setDecoration(getDecoratorTarget()
						.addShapeDecoration(
								image,
								element instanceof Port ? IDecoratorTarget.Direction.CENTER
										: IDecoratorTarget.Direction.SOUTH_WEST,
								getOffset(), false));
			}
			hideAntena();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.draw2d.LayoutListener#remove(org.eclipse.draw2d.IFigure)
		 */
		@Override
		public void remove(IFigure child) {
			// nothing todo
			
		}

		/* (non-Javadoc)
		 * @see org.eclipse.draw2d.LayoutListener#setConstraint(org.eclipse.draw2d.IFigure, java.lang.Object)
		 */
		@Override
		public void setConstraint(IFigure child, Object constraint) {
			// nothing todo
		}
	}
}
