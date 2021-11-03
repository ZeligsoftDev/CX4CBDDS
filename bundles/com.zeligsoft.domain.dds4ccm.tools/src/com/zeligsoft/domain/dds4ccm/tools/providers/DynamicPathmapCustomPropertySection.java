/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.providers;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.internal.emf.DDS4CCMDynamicURIMapHandler;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Custom property section for Dynamic URI mapping
 * 
 * @author Young-Soo Roh
 * 
 */
public class DynamicPathmapCustomPropertySection implements ICXCustomPropertySection {

	private static final String PATHMAP_KEY = "pathmap"; //$NON-NLS-1$

	@Override
	public Map<String, Control> createSection(Composite parent, CXPropertyDescriptor descriptor, Property property) {

		Map<String, Control> result = new HashMap<String, Control>();
		createSectionForDynamicPathmap(parent, descriptor);
		return result;
	}

	/**
	 * Create section for Dynamic Pathamp
	 * 
	 * @param parent
	 * @param descriptor
	 */
	public void createSectionForDynamicPathmap(final Composite parent, final CXPropertyDescriptor descriptor) {

		CXWidgetFactory.createLabel(parent, Messages.DynamicPathmapCustomPropertySection_FieldLabel,
				parent.getBackground());

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent, 2, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		String value = getDynamicPathmap(descriptor.getContext());

		int style = SWT.BORDER;
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		final Text text = new Text(composite, style);
		text.setLayoutData(data);
		text.setText(value);
		text.setEnabled(false);

		EObject root = null;
		try {
			ServicesRegistry registry = ServiceUtilsForResource.getInstance()
					.getServiceRegistry(descriptor.getContext().eResource());
			ModelSet modelSet = registry.getService(ModelSet.class);

			UmlModel openedModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
			if (openedModel != null) {
				root = openedModel.lookupRoot();
			}
		} catch (ServiceException e1) {
		} catch (NotFoundException e1) {
		}

		Button button = new Button(composite, SWT.PUSH);
		button.setImage(CXWidgetFactory.EDIT_OBJECT_IMAGE);
		button.setEnabled(descriptor.getContext().equals(root));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String oldValue = getDynamicPathmap(descriptor.getContext());
				InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), "Pathmap", //$NON-NLS-1$
						Messages.DynamicPathmapCustomPropertySection_PathmapWarning, oldValue, new IInputValidator() {

							@Override
							public String isValid(String newText) {
								if (!UML2Util.isEmpty(newText)) {
									URI uri = URI.createURI(PATHMAP_KEY + "://" + newText + "/", true); //$NON-NLS-1$ //$NON-NLS-2$
									if (!newText.equals(oldValue) && CXDynamicURIConverter.PATHMAPS.get(uri) != null) {
										return newText + Messages.DynamicPathmapCustomPropertySection_PathmapErrorMsg;
									}
								}
								return null;
							}
						});
				if (Window.OK == inputDialog.open()) {
					text.setText(inputDialog.getValue());
					setDynamicPathmap(descriptor.getContext(), inputDialog.getValue());
				}
			}
		});
	}

	/**
	 * Get current pathmap
	 * 
	 * @param model
	 * @return
	 */
	private String getDynamicPathmap(EObject model) {
		if (model instanceof Element) {
			return CCMUtil.getZCXAnnotationDetail((Element) model, PATHMAP_KEY, UML2Util.EMPTY_STRING);
		}
		return null;
	}

	/**
	 * Set dynamic pathmap
	 * 
	 * @param model
	 * @param pathmap
	 */
	private void setDynamicPathmap(EObject model, String pathmap) {

		boolean shouldRefactor = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
				Messages.DynamicPathmapCustomPropertySection_RefactoringConfirmationDialogTitle,
				Messages.DynamicPathmapCustomPropertySection_RefactoringConfirmationMsg);

		IRunnableWithProgress runnable = new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

				monitor.beginTask(Messages.DynamicPathmapCustomPropertySection_RefactoringDialogTitle,
						IProgressMonitor.UNKNOWN);

				// Remove existing pathmap
				String originalPathmap = getDynamicPathmap(model);

				if (originalPathmap.equals(pathmap)) {
					// nothing to do if same
					return;
				}

				URI modelUri = model.eResource().getURI();
				final URI originalPathmapUri = CXDynamicURIConverter.getPathmapURI(modelUri);

				monitor.subTask(Messages.DynamicPathmapCustomPropertySection_RegisteringPathmapSubtask);

				// save new dynamic pathmap to annotation
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);

				// Annotate model with new dynamic pathmap
				Command command = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						CCMUtil.putZCXAnnotationDetail((Element) model, PATHMAP_KEY, pathmap);
					}
				};
				domain.getCommandStack().execute(command);

				// Unregister old pathmap
				if (!UML2Util.isEmpty(originalPathmap)) {
					CXDynamicURIConverter.removeMapping(modelUri);
				}

				// Register new pathmap
				URI pathmapURI = null;
				if (!UML2Util.isEmpty(pathmap)) {
					pathmapURI = URI.createURI(PATHMAP_KEY + "://" + pathmap + "/", true); //$NON-NLS-1$ //$NON-NLS-2$
					DDS4CCMDynamicURIMapHandler.addMapping(pathmapURI, modelUri);
				}

				if (shouldRefactor) {
					monitor.subTask(Messages.DynamicPathmapCustomPropertySection_ClosingEditorSubtask);

					// close all editors before refactoring starts
					IWorkbenchPage page = BaseUIUtil.getActivepage();
					if (page != null) {
						List<IEditorReference> editorsToClose = new ArrayList<IEditorReference>();
						IEditorPart activeEditor = page.getActiveEditor();
						for (IEditorReference ref : page.getEditorReferences()) {
							IEditorPart editor = ref.getEditor(false);
							if (!activeEditor.equals(ref.getEditor(false))
									&& editor instanceof PapyrusMultiDiagramEditor) {
								editorsToClose.add(ref);
							}
						}
						try {
							page.closeEditors(editorsToClose.toArray(new IEditorReference[0]), true);
						} catch (Exception e) {
							// do nothing
						}
					}

					// from URI
					URI sourceURI = originalPathmapUri;

					// to current URI
					URI targetURI = CXDynamicURIConverter.getPathmapURI(modelUri);

					// refactor all references
					List<URI> models = new ArrayList<URI>();
					DDS4CCMDynamicURIMapHandler.visitAllModels(ResourcesPlugin.getWorkspace().getRoot(),
							uri -> models.add(uri));
					for (URI uri : models) {
						if (!modelUri.equals(uri)) {
							monitor.subTask("Refactoring " + uri.toString()); //$NON-NLS-1$
							if (refactorURI(sourceURI, targetURI, uri)) {
							}
						}
					}
				}
				monitor.done();
			}

		};

		try {
			new ProgressMonitorDialog(null).run(false, false, runnable);
		} catch (InvocationTargetException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (InterruptedException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
	}

	/**
	 * Refactor URI using the file content.
	 * 
	 * @param sourceURI
	 * @param targetURI
	 * @param file
	 * @return
	 */
	@SuppressWarnings("nls")
	public static boolean refactorURI(URI sourceURI, URI targetURI, URI modelToRefactorURI) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(modelToRefactorURI.toPlatformString(true)));
		if (!file.exists()) {
			return false;
		}

		IPath containerPath = file.getParent().getFullPath();
		boolean found = false;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
			StringBuffer outBuffer = new StringBuffer();
			while (reader.ready()) {
				String line = reader.readLine();
				String outLine = line;
				int startIndex = line.indexOf("href=\"");
				int tokenLength = "href=\"".length();
				int endIndex = line.indexOf(".uml", startIndex);
				if (startIndex > 0 && endIndex > 0) {
					String beforeString = line.substring(0, startIndex + tokenLength);
					String afterString = line.substring(endIndex + ".uml".length());
					String href = line.substring(startIndex + tokenLength, endIndex + ".uml".length());
					URI modelUri = null;

					if (href.startsWith("pathmap:") || href.startsWith("platform:/resource")) {
						// handle platform resource reference
						modelUri = URI.createURI(href);
					} else if (!UML2Util.isEmpty(href)) {
						// handle relative reference
						IPath modelPath = containerPath.append(href);
						modelUri = URI.createPlatformResourceURI(modelPath.toString(), true);
					}
					if (modelUri != null) {
						if (modelUri.equals(sourceURI)) {
							found = true;
							outLine = beforeString + targetURI.toString() + afterString;
						}
					}
				}
				outBuffer.append(outLine).append(System.lineSeparator());
			}
			reader.close();

			if (found) {
				// produce output
				String outContents = outBuffer.toString();
				byte[] bytes = outContents.getBytes();
				InputStream source = new ByteArrayInputStream(bytes);
				file.setContents(source, IResource.FORCE, new NullProgressMonitor());

				// Import ICM model to refactored models
				if ("platform".equals(sourceURI.scheme()) && "pathmap".equals(targetURI.scheme())
						&& "uml".equals(modelToRefactorURI.fileExtension())) {
					ResourceSet rset = new ResourceSetImpl();
					Package refactoredModel = UML2Util.load(rset, modelToRefactorURI, UMLPackage.Literals.PACKAGE);
					boolean importFound = false;
					for (Package pk : refactoredModel.getImportedPackages()) {
						if (targetURI.equals(pk.eResource().getURI())) {
							importFound = true;
							break;
						}
					}
					if (!importFound) {
						Package targetModel = UML2Util.load(rset, targetURI, UMLPackage.Literals.PACKAGE);
						refactoredModel.createPackageImport(targetModel);
						try {
							refactoredModel.eResource().save(Collections.EMPTY_MAP);
						} catch (IOException e) {
							Activator.getDefault().error(e.getMessage(), e);
						}
					}
				}
			}
		} catch (Exception e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
		return found;
	}
}
