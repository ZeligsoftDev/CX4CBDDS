/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen.ui.wizards;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.ddk.zdl2zdlgen.l10n.ZDL2ZDLGenMessages;

/**
 * The "converter" wizard page in the ZDL model importer is responsible for
 * the selection of the source ZDL model and for the generation of the ZDLGen
 * from it and merging it into the existing ZDLGen instance.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLConverterPage
		extends WizardPage {
	
	private ZDLImporter importer;
	
	private Text fileText;

	private URI sourceModelURI;

	/**
	 * Initializes me.
	 * 
	 * @param importer the import importer for my wizard
	 */
	public ZDLConverterPage(ZDLImporter importer) {
		super("ZDLConverterPage", ZDL2ZDLGenMessages.ZDLConverterPage_pageTitle, null); //$NON-NLS-1$
		setDescription(ZDL2ZDLGenMessages.ZDLConverterPage_description);
		
		this.importer = importer;
	}

	@Override
	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, true);
		control.setLayout(layout);
		
		createZDLGroup(control);
		
		setControl(control);
	}
	
	/**
	 * Creates the ZDL source model selection group.
	 * 
	 * @param parent the parent composite
	 */
	private void createZDLGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(ZDL2ZDLGenMessages.ZDLConverterPage_zdlGroupLabel);

		GridLayout layout = new GridLayout(3, false);
		group.setLayout(layout);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessHorizontalSpace = true;
		group.setLayoutData(data);

		Label label = new Label(group, SWT.NONE);
		label.setText(ZDL2ZDLGenMessages.ZDLConverterPage_zdlFileLabel);

		fileText = new Text(group, SWT.SINGLE);
		if (getSourceModelURI() != null) {
			fileText.setText(getSourceModelURI().toPlatformString(true));
			load();
		}
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessHorizontalSpace = true;
		fileText.setLayoutData(data);
		fileText.setEditable(false);
		fileText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				fileTextChanged();
			}
		});

		Button browse = new Button(group, SWT.PUSH);
		browse.setText(ZDL2ZDLGenMessages.ZDLConverterPage_zdlBrowse);
		browse.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				browseWorkspace();
			}
		});
	}

	/**
	 * Sets the source model URI, in the case that we are reloading an existing
	 * ZDLGen instance or have pre-selected the ZDL model in the UI.
	 * 
	 * @param uri a default URI for the source ZDL model
	 * @throws IOException 
	 */
	void setSourceModelURI(URI uri) {
		// normalize the URI in case it is using a URI mapping
		// such as a pathmap, if not it will return the same
		// URI
		URI convertedURI = URIConverter.INSTANCE.normalize(uri);
		
		if (!convertedURI.isPlatformResource()) {
			throw new IllegalArgumentException("Not a platform:/resource URI: " + uri.toString()); //$NON-NLS-1$
		} else {
			sourceModelURI = convertedURI;
		}
	}

	/**
	 * Queries the value of the source ZDL model URI.
	 * 
	 * @return the current URI for the source ZDL model
	 */
	URI getSourceModelURI() {
		return sourceModelURI;
	}

	private void browseWorkspace() {
		ViewerFilter filter = new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				boolean result = true;
				if (element instanceof IFile) {
					result = isZDLModel((IFile) element);
				}

				return result;
			}
		};

		IFile[] result = WorkspaceResourceDialog.openFileSelection(getShell(),
			ZDL2ZDLGenMessages.ZDLConverterPage_browseDlgTitle, ZDL2ZDLGenMessages.ZDLConverterPage_browseDlgPrompt, false, null,
			Collections.singletonList(filter));
		if ((result != null) && (result.length > 0)) {
			fileText.setText(result[0].getFullPath().toPortableString());
		}
	}

	boolean isZDLModel(IFile file) {
		// TODO: Use content-type service.  EMF 2.4
		return UMLResource.FILE_EXTENSION.equalsIgnoreCase(file.getFileExtension());
	}

	private void fileTextChanged() {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
			new Path(fileText.getText()));

		if (file.exists() && isZDLModel(file)) {
			setSourceModelURI(URI.createPlatformResourceURI(fileText.getText(),
				true));
			setErrorMessage(null);
			load();
		} else {
			setErrorMessage(ZDL2ZDLGenMessages.ZDLConverterPage_notZDL);
			importer.reset();
			setPageComplete(false);
		}
	}
	
	/**
	 * Asynchronously loads the source model, via the import importer.
	 */
	private void load() {
		fileText.getDisplay().asyncExec(new Runnable() {
		
			@Override
			public void run() {
				try {
					importer.load(getSourceModelURI());
					setErrorMessage(null);
				} catch (IOException e) {
					setErrorMessage(NLS.bind(
						ZDL2ZDLGenMessages.ZDLConverterPage_sourceZDLFailed, e
							.getLocalizedMessage()));
				}
				setPageComplete(importer.isLoaded());
			}});
	}
}
