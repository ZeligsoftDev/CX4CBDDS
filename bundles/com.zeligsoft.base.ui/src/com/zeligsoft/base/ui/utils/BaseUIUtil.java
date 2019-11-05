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
package com.zeligsoft.base.ui.utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.context.TypeContext;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.RevealResultCommand;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.commands.EditResultCommand;
import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Utility class for common UI
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("rawtypes")
public class BaseUIUtil {

	public static IElementType PACKAGE_ELEMENT_TYPE = ZDLElementTypeManager.INSTANCE
			.getElementTypeFromHint("package");//$NON-NLS-1$;
	
	public static String BUILD_CONFIG_PROPERTY_NAME = "build_config"; //$NON-NLS-1$

	public static Command buildCommand(TransactionalEditingDomain editingDomain, IClientContext context,
			CreateElementRequest req, EObject target) {

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(target, context);
		if (provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		ICommand createGMFCommand = provider.getEditCommand(req);

		if (createGMFCommand != null) {
			return GMFtoEMFCommandWrapper.wrap(createGMFCommand);
		}
		return UnexecutableCommand.INSTANCE;
	}

	public static Command getRevealCommand(Command command, EObject container) {
		IViewPart viewPart = getModelExplorerViewPart();
		if (viewPart != null) {
			return RevealResultCommand.wrap(command, viewPart, container);
		}
		return null;
	}
	
	public static void revealTarget(EObject target) {
		revealTarget(Arrays.asList(target));
	}
	
	/**
	 * Reveal target elements in the model explorer
	 * @param target
	 */
	public static void revealTarget(final List<?> target) {
		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {
				IViewPart viewPart = getModelExplorerViewPart();
				if (viewPart instanceof ModelExplorerView) {
					((IRevealSemanticElement) viewPart).revealSemanticElement(target);
					((ModelExplorerView) viewPart).setFocus();
				}
			}
		});
	}

	public static Command getDirectEditCommand(Command command) {
		IViewPart viewPart = getModelExplorerViewPart();
		if (viewPart != null) {
			return EditResultCommand.wrap(command, viewPart);
		}
		return null;

	}
	
	public static Command getCreatePackageCommand(EObject selectedEObject) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedEObject);
		IClientContext context = null;
		try {
			context = TypeContext.getContext(selectedEObject);
		} catch (ServiceException e) {
			com.zeligsoft.base.ui.Activator.getDefault().error(e.getMessage(), e);
			return UnexecutableCommand.INSTANCE;
		}
		final CreateElementRequest req = new CreateElementRequest(editingDomain, selectedEObject, PACKAGE_ELEMENT_TYPE);
		final EObject target = ElementEditServiceUtils.getTargetFromContext(editingDomain, selectedEObject, req);
		if (target == null) {
			return UnexecutableCommand.INSTANCE;
		}

		return BaseUIUtil.buildCommand(editingDomain, context, req, target);

	}

	/**
	 * Gets the active view part.
	 *
	 * @return the active view part
	 */
	public static IViewPart getModelExplorerViewPart() {
		IViewPart activeView = null;
		// Get Model Explorer view part
		IViewPart modelExplorerView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.findView(ModelExplorerPageBookView.VIEW_ID);

		if (modelExplorerView instanceof MultiViewPageBookView) {
			MultiViewPageBookView pageBook = (MultiViewPageBookView) modelExplorerView;
			activeView = pageBook.getActiveView();
		}

		return activeView;
	}

	/**
	 * Get the first selected EObject from the given selection object
	 * 
	 * @param selection
	 * @return EObject or <code>null</code>
	 */
	public static EObject getEObjectFromSelection(ISelection selection) {
		if (selection == null) {
			return null;
		}
		if (selection.isEmpty()) {
			return null;
		}
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structSelection = (IStructuredSelection) selection;

			Object tempObject = structSelection.getFirstElement();

			if (tempObject instanceof IAdaptable) {
				IAdaptable tempAdaptableObject = (IAdaptable) tempObject;
				return (tempAdaptableObject.getAdapter(EObject.class));
			} else if (tempObject instanceof EObject) {
				return (EObject) tempObject;
			}
		}
		return null;
	}

	/**
	 * Get the selected EObjects from the given selection object
	 * 
	 * @param ISelection selection
	 * @return List<EObject>
	 */
	public static List<EObject> getEObjectsFromSelection(ISelection selection) {

		ArrayList<EObject> eObjects = new ArrayList<EObject>();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structSelection = (IStructuredSelection) selection;

			List selections = structSelection.toList();

			for (int i = 0; i < selections.size(); i++) {
				Object tempObject = selections.get(i);
				if (tempObject instanceof IAdaptable) {
					IAdaptable tempAdaptableObject = (IAdaptable) tempObject;
					EObject eo = (tempAdaptableObject.getAdapter(EObject.class));
					if (eo != null) {
						eObjects.add(eo);
					}
				} else if (tempObject instanceof EObject) {
					eObjects.add((EObject) tempObject);
				}

			}
		}
		return eObjects;
	}

	/**
	 * Returns corresponding IResource object from the given selection
	 * 
	 * @param selection IStructuredSelection
	 * @return IResource or null if it is of unknown type
	 */
	public static IResource getIResourceFromSelection(IStructuredSelection selection) {
		if (selection == null || selection.isEmpty()) {
			return null;
		}
		Object tempObject = selection.getFirstElement();
		IResource resource = null;
		if (tempObject != null) {
			if (tempObject instanceof IAdaptable) {
				// check for EObject
				EObject eObject = (((IAdaptable) tempObject).getAdapter(EObject.class));

				if (eObject != null && eObject.eResource().getURI().toPlatformString(true) != null) {
					resource = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new Path(eObject.eResource().getURI().toPlatformString(true)));
				}
			}
		}
		return resource;
	}

	/**
	 * Create a model element from the CreateElementRequest
	 * 
	 * @param request CreateElementRequest
	 * @return CommandResult
	 * @throws ExecutionException
	 */
	public static CommandResult createModelElement(CreateElementRequest request) throws ExecutionException {

		CommandResult result = null;
		ICommand command = getCommand(request);
		if (command != null) {

			OperationHistoryFactory.getOperationHistory().execute(command, null, null);

			result = command.getCommandResult();
		}
		return result;
	}

	/**
	 * Get command from the createElementRequest
	 * 
	 * @param request
	 * @return
	 */
	public static ICommand getCommand(CreateElementRequest request) {
		if (request != null) {
			IElementType contextType = ElementTypeRegistry.getInstance().getElementType(request.getEditHelperContext());

			if (contextType != null) {
				ICommand createCommand = contextType.getEditCommand(request);

				if (createCommand != null && createCommand.canExecute()) {
					return createCommand;
				}
			}
		}

		return null;
	}

	/**
	 * Queries the element type of the given element type ID.
	 * 
	 * @param elementTypeId
	 * @return
	 */
	public static IElementType getElementType(String elementTypeId) {
		return ElementTypeRegistry.getInstance().getType(elementTypeId);
	}

	/**
	 * Creates map for the slots from the given build configuration
	 * 
	 * @return
	 */
	public static Map<String, Slot> getSlotMap(InstanceSpecification instance) {

		Map<String, Slot> map = new HashMap<String, Slot>();
		if (instance != null) {
			Iterator<Slot> itor = instance.getSlots().iterator();
			while (itor.hasNext()) {
				Slot slot = itor.next();
				if (slot.getDefiningFeature() != null) {
					map.put(slot.getDefiningFeature().getName(), slot);
				}
			}
		}
		return map;
	}

	/**
	 * Queries the slot value.
	 * 
	 * @param slot
	 * @return slot value.
	 */
	public static Object getSlotValue(Slot slot) {

		String finalString = ""; //$NON-NLS-1$
		String newLiner = System.getProperty("line.separator"); //$NON-NLS-1$
		if (slot != null) {
			Iterator values = slot.getValues().iterator();
			while (values.hasNext()) {
				Object value = values.next();
				if (value instanceof LiteralString) {
					finalString = finalString + ((LiteralString) value).getValue();
					if (values.hasNext()) {
						finalString = finalString + newLiner;
					}
				}
				if (value instanceof InstanceValue) {
					return ((InstanceValue) value).getInstance();
				}
				if (value instanceof LiteralBoolean) {
					return Boolean.valueOf(((LiteralBoolean) value).booleanValue());
				}
			}
		}

		if (finalString.equals("null") || finalString.equals("")) { //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
		return finalString;
	}

	/**
	 * Creates map where key is the defining feature of the slot and value is the
	 * slot itself
	 * 
	 * @return
	 */
	public static Map<NamedElement, Slot> getFeatureSlotMap(InstanceSpecification instance) {

		Map<NamedElement, Slot> map = new HashMap<NamedElement, Slot>();
		if (instance != null) {
			Iterator<Slot> itor = instance.getSlots().iterator();
			while (itor.hasNext()) {
				Slot slot = itor.next();
				if (slot.getDefiningFeature() != null) {
					map.put(slot.getDefiningFeature(), slot);
				}
			}
		}
		return map;
	}

	/**
	 * Queries the icon of the given eObject
	 * 
	 * @param element
	 * @return
	 */
	public static Image getIcon(EObject element) {
		Class concept = ZDLUtil.getZDLConcept(element);
		Image icon = null;
		if (concept != null) {
			icon = ZDLImageRegistry.getInstance().getIcon(concept);
		}
		if (icon == null) {
			IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
			icon = IconService.getInstance().getIcon(type);
		}
		return icon;
	}

	/**
	 * Deprecated. Use ZDLUtil.isZDLProfile instead.
	 * 
	 * @param container
	 * @return boolean isProfileApplied
	 */
	@Deprecated
	public static boolean isDomainProfileApplied(Element container, String profileName) {
		if (container == null || profileName == null) {
			return false;
		}

		Collection<Profile> profiles = ZDLUtil.getZDLProfiles(container);
		boolean isProfileApplied = false;
		for (Profile thisProfile : profiles) {
			if (thisProfile.getName().equals(profileName)) {
				isProfileApplied = true;
				break;
			}
		}
		return isProfileApplied;
	}

	/**
	 * Queries the build configuration instance of the given implementation.
	 * 
	 * @param implementation
	 * @return
	 */
	public static InstanceSpecification getBuildConfiguration(NamedElement implementation) {

		Resource resource = EcoreUtil.getRootContainer(implementation).eResource();
		Collection<NamedElement> elements = UMLUtil.findNamedElements(resource,
				implementation.getQualifiedName() + NamedElement.SEPARATOR + BaseUIUtil.BUILD_CONFIG_PROPERTY_NAME);
		if (elements.iterator().hasNext()) {
			NamedElement e = elements.iterator().next();
			if (e instanceof Property) {
				Property property = (Property) e;
				return ((InstanceValue) property.getDefaultValue()).getInstance();
			}
		}

		return null;
	}

	/**
	 * Retrieve the currently selected element.
	 * 
	 * @return The current selection
	 */
	public static ISelection getSelection() {
		ISelection selection = StructuredSelection.EMPTY;
		IWorkbenchPage page = getActivepage();
		if (page == null) {
			return selection;
		}

		IWorkbenchPart activePart = page.getActivePart();
		if (activePart == null)
			return selection;

		ISelectionProvider selectionProvider = activePart.getSite().getSelectionProvider();
		if (selectionProvider != null && selectionProvider.getSelection() instanceof IStructuredSelection)
			selection = selectionProvider.getSelection();

		return selection;
	}

	/**
	 * Return active page
	 * 
	 * @return
	 */
	public static IWorkbenchPage getActivepage() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}

	/**
	 * Return the first file with the given extension form the selected objects
	 * 
	 * @param extension
	 * @return
	 */
	public static IFile getFirstSelectedFile(IStructuredSelection selection, String extension) {

		if (selection != null) {
			Iterator i = selection.iterator();
			while (i.hasNext()) {
				Object o = i.next();
				if (o instanceof IFile && extension.equals(((IFile) o).getFileExtension())) {
					return (IFile) o;
				}
			}
		}
		return null;
	}

	/**
	 * Get icon image descriptor from the product plugin.
	 * 
	 * @param iconPath
	 * @return
	 */
	public static ImageDescriptor getIconImageDescriptorFromProductBundle(String iconPath) {
		// get product specific icon if available
		IProduct product = Platform.getProduct();
		if (product == null) {
			return null;
		}
		Bundle productBundle = product.getDefiningBundle();

		ImageDescriptor imageDescriptor = null;
		if (productBundle != null) {
			URL url = productBundle.getEntry(iconPath);
			if (url != null) {
				imageDescriptor = ImageDescriptor.createFromURL(url);
			}
		}
		return imageDescriptor;
	}

	/**
	 * Create a ZDL element with given context and concept
	 * 
	 * @param context
	 * @param conceptToCreate
	 * @return
	 */
	public static EObject createZDLModelElement(EObject context, String conceptToCreate) {

		IElementType type = null;
		try {
			type = ZDLElementTypeUtil.getElementType(context, conceptToCreate);
			CreateElementRequest request = new CreateElementRequest(context, type);
			CommandResult result = BaseUIUtil.createModelElement(request);

			return (EObject) result.getReturnValue();
		} catch (Exception e) {
			// do nothing
		}
		return null;
	}

	/**
	 * Queries if the type1 is same or subtype of type2
	 * 
	 * @param type1
	 * @param type2
	 * @return
	 */
	public static boolean isSubtype(IElementType type1, IElementType type2) {
		if (type1 == type2) {
			return true;
		}

		if (type1 instanceof ISpecializationType) {
			ISpecializationType specializationType = (ISpecializationType) type1;

			if (specializationType.isSpecializationOf(type2)) {
				return true;
			}

			for (IElementType type : specializationType.getAllSuperTypes()) {
				if (!(type instanceof ISpecializationType))
					continue;
				if (((ISpecializationType) type).isSpecializationOf(type2)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return sorted list of give EObjects
	 * 
	 * @param elements
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static List sortEObjectsByName(Collection elements) throws IllegalArgumentException {
		return BaseUtil.sortEObjectsByName(elements);
	}
	
	public static String getProfileApplyingConcept(URI modelURI, String conceptHint,
			TransactionalEditingDomain editingDomain) {
		Resource res = editingDomain.getResourceSet().getResource(modelURI, true);
		if (!res.isLoaded() || res.getContents().isEmpty()) {
			return null;
		}

		org.eclipse.uml2.uml.Package p = (org.eclipse.uml2.uml.Package) res.getContents().get(0);

		for (Profile profile : p.getAllAppliedProfiles()) {

			if (profile.getPackagedElement(conceptHint) != null) {
				return profile.eResource().getURI().toString();
			}
		}

		return null;
	}

}