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
package com.zeligsoft.cx.ui.dialogs;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.pages.AbstractBuildConfigurationPage;
import com.zeligsoft.cx.ui.pages.BuildConfigurationRootPage;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Abstract class for build configuration dialog page. Any page that will be
 * inserted to the build configuration dialog wizard must extend this class.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public abstract class AbstractLocalBuildConfigurationDialog
		extends PreferenceDialog {

	private String dialogTitle;

	// Domain specific build environment
	protected Class buildConfigurationClassifier;

	// User selected implementation
	protected EObject selectedObject;

	// User selected build configuration
	protected InstanceSpecification localBuildConfiguration;

	// Base build configuration
	protected InstanceSpecification baseBuildConfiguration;

	// Preference manager for Preference dialog
	protected PreferenceManager manager;

	/**
	 * Constructor
	 * 
	 * @param parentShell
	 * @param dialogTitle
	 *            dialog title
	 * @param selectedObject
	 *            user selected implementation
	 * @param buildConfiguration
	 *            user selected build configuration
	 * @param operation
	 *            to specify modify or create new build configuration
	 */
	public AbstractLocalBuildConfigurationDialog(Shell parentShell,
			String dialogTitle, EObject selectedObject) {
		super(parentShell, new PreferenceManager());
		manager = getPreferenceManager();
		this.dialogTitle = dialogTitle;
		this.selectedObject = selectedObject;
		this.localBuildConfiguration = BaseUIUtil
			.getBuildConfiguration((NamedElement) selectedObject);
		this.buildConfigurationClassifier = getBuildConfigurationClassier();
		addConfigurationPages();
	}

	/**
	 * Add tree viewer listener. This will ensure that the other pages will be
	 * updated according to the latest build configuration selection.
	 */
	private void addPageChangedListener() {
		final TreeViewer viewer = getTreeViewer();
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				TreeSelection selection = (TreeSelection) viewer.getSelection();

				IPreferenceNode rootNode = findNodeMatching(BuildConfigurationRootPage.ID);
				AbstractBuildConfigurationPage rootPage = (AbstractBuildConfigurationPage) rootNode
					.getPage();
				if (rootPage.getControl() == null) {
					rootPage.createControl(getPageContainer());
				}
				InstanceSpecification selectedBuild = ((AbstractBuildConfigurationPage) rootNode
					.getPage()).getSelectedBaseBuildConfiguration();

				PreferenceNode node = (PreferenceNode) selection
					.getFirstElement();
				AbstractBuildConfigurationPage selectedPage = (AbstractBuildConfigurationPage) node
					.getPage();
				if (selectedPage.getControl() == null) {
					selectedPage.createControl(getPageContainer());
				}
				// Notify base build configuration change and reset all local values
				selectedPage.setSelectedBaseBuildConfiguration(selectedBuild, true);
			}
		});

	}

	/**
	 * Adds common build configuration pages
	 */
	protected void addConfigurationPages() {

		addPageTo(null, new BuildConfigurationRootPage());

		configureDomainSpecificContent();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.preference.PreferenceDialog#createDialogArea(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control control = super.createDialogArea(parent);

		// Set dialog title
		getShell().setText(dialogTitle);
		addPageChangedListener();

		return control;
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected void okPressed() {

		final Iterator itor = manager.getElements(PreferenceManager.PRE_ORDER)
			.iterator();
		try {
			OperationHistoryFactory
				.getOperationHistory()
				.execute(
					new AbstractTransactionalCommand(
						TransactionUtil
							.getEditingDomain(buildConfigurationClassifier),
						Messages.AbstractLocalBuildConfigurationDialog_CreateInstanceTransactionLabel,
						Collections.EMPTY_MAP, null) {

						@Override
						protected CommandResult doExecuteWithResult(
								IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {

							final InstanceSpecification instance = getTargetBuildConfiguration();

							while (itor.hasNext()) {
								IPreferenceNode node = (IPreferenceNode) itor
									.next();
								AbstractBuildConfigurationPage page = ((AbstractBuildConfigurationPage) (node
									.getPage()));
								if (page.getControl() == null) {
									page.createControl(getPageContainer());
								}

								if (page.getControl() != null) {
									page.performOk(instance);
								}

							}

							if( selectedObject instanceof Classifier ) {
								Property buildProperty = ((Classifier) selectedObject)
								.getAttribute(
									BaseUIUtil.BUILD_CONFIG_PROPERTY_NAME, null);

								InstanceValue value;
								if (buildProperty == null) {
									Property newProperty = null;
									if(selectedObject instanceof Artifact) {
										newProperty = ((Artifact) selectedObject)
											.createOwnedAttribute(
												BaseUIUtil.BUILD_CONFIG_PROPERTY_NAME,
												buildConfigurationClassifier);
									} else if(selectedObject instanceof Class) {
										newProperty = ((Class) selectedObject)
										.createOwnedAttribute(
											BaseUIUtil.BUILD_CONFIG_PROPERTY_NAME,
											buildConfigurationClassifier);
									}
									value = (InstanceValue) newProperty
										.createDefaultValue(null, null,
											UMLPackage.Literals.INSTANCE_VALUE);
								} else {
	
									value = (InstanceValue) buildProperty
										.createDefaultValue(null, null,
											UMLPackage.Literals.INSTANCE_VALUE);
	
								}
								value.setInstance(instance);
	
							} else if( selectedObject instanceof Component ) {
								Property buildProperty = ((Component) selectedObject)
								.getAttribute(
									BaseUIUtil.BUILD_CONFIG_PROPERTY_NAME, null);

								InstanceValue value;
								if (buildProperty == null) {
									Property newProperty = ((Component) selectedObject)
										.createOwnedAttribute(
											BaseUIUtil.BUILD_CONFIG_PROPERTY_NAME,
											buildConfigurationClassifier);
									value = (InstanceValue) newProperty
										.createDefaultValue(null, null,
											UMLPackage.Literals.INSTANCE_VALUE);
								} else {
	
									value = (InstanceValue) buildProperty
										.createDefaultValue(null, null,
											UMLPackage.Literals.INSTANCE_VALUE);
	
								}
								value.setInstance(instance);
							}
							
							return CommandResult.newOKCommandResult();
						}

					}, null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin
				.getDefault()
				.error(
					Messages.AbstractLocalBuildConfigurationDialog_BuildConfigurationFailedLog,
					e);
			close();
		}

		close();
	}

	/**
	 * Return buildConfiguration that will be saved. Create new one if this is
	 * NEW operation.
	 * 
	 * @return build configuration
	 */
	protected InstanceSpecification getTargetBuildConfiguration() {

		if (localBuildConfiguration != null) {
			return localBuildConfiguration;
		}
		final Class classifier = getBuildConfigurationClassier();
		final Package container = (Package) selectedObject.eContainer();
		String instanceName = ((NamedElement) selectedObject).getName()
			+ "_BuildConfig"; //$NON-NLS-1$
		final String uniqueName;
		uniqueName = NamingUtil.generateUniqueName(instanceName,
				container.getPackagedElements());

		InstanceSpecification instance = (InstanceSpecification) container
			.createPackagedElement(uniqueName,
				UMLPackage.Literals.INSTANCE_SPECIFICATION);

		instance.getClassifiers().add(classifier);
		ZDLUtil.addZDLConcept(instance, ZMLMMNames.BUILD_CONFIGURATION);

		return (InstanceSpecification) container.getPackagedElement(uniqueName);

	}

	/**
	 * Add page under specific page
	 * 
	 * @param pageId
	 *            Id of the page. If the Id is null, then the page will be added
	 *            under root.
	 * @param page
	 *            page to add
	 */
	protected void addPageTo(String pageId, AbstractBuildConfigurationPage page) {
		page.setBuildConfigurationInstance(localBuildConfiguration);
		page.setBuildConfigurationClassifier(buildConfigurationClassifier);
		PreferenceNode node = new PreferenceNode(page.getId());
		node.setPage(page);
		if (pageId != null) {
			PreferenceNode targetNode = (PreferenceNode) findNodeMatching(pageId);
			targetNode.add(node);
		} else {
			manager.addToRoot(node);
		}
	}

	/**
	 * Subclass must override this method to provide domain specific build
	 * environment.
	 * 
	 * @return build environment class (e.g., SCABuildEnvironment class)
	 */
	protected abstract Class getBuildConfigurationClassier();

	/**
	 * Subclass must override this method to add domain specific pages.
	 */
	protected abstract void configureDomainSpecificContent();

}
