/*******************************************************************************
 * Copyright (c) 2014, 2020 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ocl.pivot.internal.utilities.PivotDiagnostician;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;

public class ValidateCommand extends ValidateAction
{
	@Override
	protected Diagnostician createDiagnostician(AdapterFactory adapterFactory, @Nullable IProgressMonitor progressMonitor) {
		ResourceSet resourceSet = ClassUtil.nonNullEMF(domain.getResourceSet());
		return PivotDiagnostician.createDiagnostician(resourceSet, adapterFactory, progressMonitor);
	}

	/**
	 * Fires an event to all registered listeners describing changes to this
	 * instance.
	 * <p>
	 * Subclasses may extend the definition of this method (i.e., if a different
	 * type of listener can be attached to a subclass). This is used primarily
	 * for support of <code>AbstractHandler</code> in
	 * <code>org.eclipse.ui.workbench</code>, and clients should be wary of
	 * overriding this behaviour. If this method is overridden, then the first
	 * line of the method should be "<code>super.fireHandlerChanged(handlerEvent);</code>".
	 * </p>
	 *
	 * @param handlerEvent
	 *            the event describing changes to this instance. Must not be
	 *            <code>null</code>.
	 */
	protected void fireHandlerChanged(final HandlerEvent handlerEvent) {
		if (handlerEvent == null) {
			throw new NullPointerException();
		}
		final Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			final IHandlerListener listener = (IHandlerListener) listeners[i];
			listener.handlerChanged(handlerEvent);
		}
	}

	@Override	// FIXME BUG 435735 Overridden to select resource more intelligently for Papyrus
	protected void handleDiagnostic(Diagnostic diagnostic) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			return;
		}
		int severity = diagnostic.getSeverity();
		String title = null;
		String message = null;

		if (severity == Diagnostic.ERROR || severity == Diagnostic.WARNING) {
			title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_title");
			message = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_message");
		} else {
			title = EMFEditUIPlugin.INSTANCE
				.getString("_UI_ValidationResults_title");
			message = EMFEditUIPlugin.INSTANCE .getString(severity == Diagnostic.OK
					? "_UI_ValidationOK_message"
					: "_UI_ValidationResults_message");
		}

		int result = 0;
		if (diagnostic.getSeverity() == Diagnostic.OK) {
			MessageDialog.openInformation(activeWorkbenchWindow.getShell(), title, message);
			result = Window.CANCEL;
		} else {
			result = DiagnosticDialog.open(activeWorkbenchWindow.getShell(), title, message, diagnostic);
		}

		ResourceSet resourceSet = domain.getResourceSet();
		// The following lines replace the simple inherited assumption of resourceSet.getResources().get(0)
		Resource resource = null;
		if (eclipseResourcesUtil != null) {
			List<?> data = diagnostic.getData();
			if ((data != null) && (data.size() >= 1)) {
				Object object = data.get(0);
				if (object instanceof EObject) {
					resource = ((EObject)object).eResource();
				}
			}
			if (resource == null) {
				resource = resourceSet.getResources().get(0);
			}
		}
		if (resource != null) {
			eclipseResourcesUtil.deleteMarkers(resource);
		}

		if (result == Window.OK) {
			if (!diagnostic.getChildren().isEmpty()) {
				List<?> data = (diagnostic.getChildren().get(0)).getData();
				if (!data.isEmpty() && data.get(0) instanceof EObject) {
					Object part = activeWorkbenchWindow.getActivePage().getActivePart();
					if (part instanceof ISetSelectionTarget) {
						((ISetSelectionTarget) part).selectReveal(new StructuredSelection(data.get(0)));
					} else if (part instanceof IViewerProvider) {
						Viewer viewer = ((IViewerProvider) part).getViewer();
						if (viewer != null) {
							viewer.setSelection(new StructuredSelection(data.get(0)), true);
						}
					}
				}
			}

			if (resource != null) {
				for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
					eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
				}
			}
		} else {
			// Trigger direct updating of decorations, if there are adapters.
			//
			resource = null;
		}

		if (resource == null) {
			// If no markers are produced the decorator won't be able to respond
			// to marker resource deltas, so inform it directly.
			//

			// Create a diagnostic for the resource set as a whole.
			//
			BasicDiagnostic resourceSetDiagnostic = new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, null, new Object[]{resourceSet});

			// Create a diagnostic for each resource.
			//
			Map<Resource, BasicDiagnostic> resourceDiagnostics = new LinkedHashMap<Resource, BasicDiagnostic>();
			for (Resource r : resourceSet.getResources()) {
				BasicDiagnostic resourceDiagnostic = new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, null, new Object[]{r});
				resourceDiagnostics.put(r, resourceDiagnostic);
			}

			// Just clean up decorations if the dialog was cancelled.
			//
			if (result == Dialog.OK) {
				// Partition the children among the resource diagnostics.
				//
				for (Diagnostic child : diagnostic.getChildren()) {
					List<?> data = child.getData();
					if (!data.isEmpty()) {
						Object object = data.get(0);
						if (object instanceof EObject) {
							BasicDiagnostic resourceDiagnostic = resourceDiagnostics.get(((EObject) object).eResource());
							if (resourceDiagnostic != null) {
								resourceDiagnostic.add(child);
							}
						}
					}
				}
			}

			// Add the resource diagnostics to the resource set diagnostic.
			//
			for (Diagnostic resourceDiagnostic : resourceDiagnostics.values()) {
				resourceSetDiagnostic.add(resourceDiagnostic);
			}

			// Inform any decorators.
			//
			try {
				DiagnosticDecorator.DiagnosticAdapter.update(resourceSet, resourceSetDiagnostic);
			}
			catch (Throwable e) {}		// Expect class load failure on EMF 2.8
		}
	}

	/**
	 * <p>
	 * Returns true iff there is one or more IHandlerListeners attached to this
	 * AbstractHandler.
	 * </p>
	 * <p>
	 * Subclasses may extend the definition of this method (i.e., if a different
	 * type of listener can be attached to a subclass). This is used primarily
	 * for support of <code>AbstractHandler</code> in
	 * <code>org.eclipse.ui.workbench</code>, and clients should be wary of
	 * overriding this behaviour. If this method is overridden, then the return
	 * value should include "<code>super.hasListeners() ||</code>".
	 * </p>
	 *
	 * @return true iff there is one or more IHandlerListeners attached to this
	 *         AbstractHandler
	 */
	protected boolean hasListeners() {
		return isListenerAttached();
	}

	@Override
	public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
		Object object = workbenchPart.getAdapter(EditingDomain.class);
		if (object instanceof EditingDomain) {
			domain = (EditingDomain)object;
			return;
		}
		object = workbenchPart.getAdapter(IEditingDomainProvider.class);
		if (object instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider)object).getEditingDomain();
			return;
		}
		if (workbenchPart instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) workbenchPart).getEditingDomain();
		}
	}

	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		selectedObjects = new ArrayList<EObject>();
		for (Iterator<?> objects = selection.iterator(); objects.hasNext();) {
			Object object = AdapterFactoryEditingDomain.unwrap(objects.next());
			if (object instanceof IAdaptable) {
				object = ((IAdaptable) object).getAdapter(EObject.class);
			}
			if (object instanceof EObject) {
				selectedObjects.add((EObject) object);
			} else if (object instanceof Resource) {
				selectedObjects.addAll(((Resource) object).getContents());
			} else {
				return false;
			}
		}
		selectedObjects = EcoreUtil.filterDescendants(selectedObjects);
		return !selectedObjects.isEmpty();
	}
}
