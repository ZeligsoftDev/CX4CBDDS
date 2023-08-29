/*****************************************************************************
 * Copyright (c) 2008, 2014 CEA LIST, Atos Origin, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Emilien Perico (Atos Origin) - fix bug on refresh
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ElementImportTreeSelectionDialog.ImportSpec;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ProfileTreeSelectionDialog;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.FileSelectionFilter;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.Message;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.RegisteredProfileSelectionDialog;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedProfilePanel;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;

/**
 * The Class ProfileComposite.
 */
public class AppliedProfileCompositeOnModel extends Composite {

	public static final String TAG_PROFILE_CHANGED = " (has changed, consider re-applying profile)";

	/**
	 * The add registered button.
	 */
	private Button addButton, removeButton, addRegisteredButton;

	/**
	 * Listeners *.
	 */
	private MouseListener addButtonListener, removeButtonListener, addRegisteredButtonListener;

	/**
	 * The applied label.
	 */
	private CLabel appliedLabel;

	/**
	 * the factory to create elements
	 */
	protected TabbedPropertySheetWidgetFactory factory;

	/**
	 * The profiles.
	 */
	private List profiles;

	/**
	 * profile listener
	 */
	private SelectionListener profilesListener;

	public Profile profiletoApply;

	/**
	 * The selected element of the edior : an edit part or element in the outline for example.
	 */
	protected ISelection selectedElement;

	/**
	 * The default constructor.
	 *
	 * @param style
	 *            the style of this panel
	 * @param parent
	 *            the parent Composite for this panel
	 */
	public AppliedProfileCompositeOnModel(AppliedProfilePanel parent) {
		super(parent, SWT.NONE);
		this.setLayout(new FormLayout());

	}

	/**
	 *
	 *
	 * @param factory
	 * @param parent
	 */
	public AppliedProfileCompositeOnModel(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super(parent, SWT.NONE);
		this.setLayout(new FormLayout());

		this.factory = factory;
	}

	/**
	 * apply profile done in asynchronous thread
	 *
	 * @param thepackage
	 *            the package where the profile will be applied
	 * @param profile
	 *            to apply
	 * @param withSubProfiles
	 *            yes if we want to apply all contained subprofiles
	 */
	protected void applyProfile(final Package thepackage, final Profile profile, final boolean withSubProfiles) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(thepackage);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {

							domain.getCommandStack().execute(new RecordingCommand(domain) {

								@Override
								protected void doExecute() {
									PackageUtil.applyProfile(thepackage, profile, withSubProfiles);
									refresh();
								}
							});
						}
					});
				}
			});
		} catch (Exception e) {
			Activator.logException(e, "Unable to apply selected profile.");
		}

	}

	/**
	 * Button action : open a selection dialog box that allow the user to choose profiles to apply.
	 */
	protected void applyProfileButtonPressed() {

		// Create and open the dialog box
		// ResourceSelectionDialog dialog =
		// new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), "Apply Profiles");

		ILabelProvider lp = new WorkbenchLabelProvider();
		ITreeContentProvider cp = new WorkbenchContentProvider();

		ArrayList<String> filetypes = new ArrayList<String>();
		filetypes.add("uml");

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), lp, cp);
		dialog.setTitle("Apply Profiles...");
		dialog.setMessage("Choose profiles to apply");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.addFilter(new FileSelectionFilter(filetypes));
		dialog.setValidator(new org.eclipse.papyrus.uml.properties.profile.ui.dialogs.FileSelectionValidator());
		dialog.setDoubleClickSelects(true);
		dialog.setHelpAvailable(false);
		dialog.setAllowMultiple(true);

		if (dialog.open() != Window.OK) {
			return;
		}

		// If nothing is selected : abort
		if ((dialog.getResult() == null) || (dialog.getResult().length < 1)) {
			return;
		}

		ArrayList<Package> importedModels = new ArrayList<Package>();
		Package package_ = getSelectedPackage();

		for (int i = 0; i < dialog.getResult().length; i++) {
			IFile selectedFile = (IFile) dialog.getResult()[i];
			URI profileUri = URI.createURI("platform:/resource" + selectedFile.getFullPath().toString());

			ResourceSet resourceSet = package_.eResource().getResourceSet();

			Resource profileResource = resourceSet.getResource(profileUri, true);

			if (profileResource.getContents().get(0) instanceof Package) {
				Package importedModel = (Package) profileResource.getContents().get(0);
				importedModels.add(importedModel);
			}

		}

		if (importedModels.size() > 0) {
			ProfileTreeSelectionDialog profileDialog = new ProfileTreeSelectionDialog(getShell(), importedModels);

			if (profileDialog.open() != Window.OK) {
				return;
			}
			Collection<ImportSpec<Profile>> profilestoApply = profileDialog.getResult();

			Message message = new Message("Profile application", "Applying profile...");
			message.open();
			Iterator<ImportSpec<Profile>> iterator = profilestoApply.iterator();
			while (iterator.hasNext()) {
				applyProfile(package_, iterator.next().getElement(), false);
			}
			message.close();
		}

	}

	/**
	 * Creates the button that applies new profiles on selected package.
	 */
	private void createApplyProfileButton() {
		FormData data = new FormData();

		// Button creation
		addButton = factory.createButton(this, "", SWT.PUSH);
		addButton.setImage(ImageManager.IMG_ADD);
		addButton.setToolTipText("Apply profile...");
		addButton.setVisible(true);

		// Button placement
		data.right = new FormAttachment(addRegisteredButton, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		addButton.setLayoutData(data);

		// Button listeners
		addButton.addMouseListener(addButtonListener = new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				applyProfileButtonPressed();
			}

		});
	}

	/**
	 *
	 */
	public void createContent() {

		createLabel();
		createUnapplyProfileButton();
		createRegiteredProfileButton();
		createApplyProfileButton();

		profiles = createProfilesList();
		profiles.setVisible(true);

		updateEnablement();
	}

	/**
	 * Create a label.
	 */
	private void createLabel() {
		FormData data = new FormData();

		// Label creation
		appliedLabel = factory.createCLabel(this, "Applied profiles:", SWT.NONE);

		// Label placement
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		appliedLabel.setLayoutData(data);
	}

	/**
	 * Creates the profiles list.
	 *
	 * @return the list of applied profiles
	 */
	private List createProfilesList() {
		FormData data = new FormData();

		// List of applied profiles
		List profiles = new List(this, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);

		// List placement
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(addButton, ITabbedPropertyConstants.VSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);
		profiles.setLayoutData(data);

		// List listeners
		profiles.addSelectionListener(profilesListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
			}
		});

		return profiles;
	}

	/**
	 * Creates the button used to apply a registered (= plugin enclosed) profile to the selected package.
	 */
	private void createRegiteredProfileButton() {
		FormData data = new FormData();

		// Button creation
		addRegisteredButton = factory.createButton(this, "", SWT.PUSH);
		addRegisteredButton.setImage(ImageManager.IMG_ADDREG);
		addRegisteredButton.setToolTipText("Apply registered profile...");
		addRegisteredButton.setVisible(true);

		// Button placement
		data.right = new FormAttachment(removeButton, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		addRegisteredButton.setLayoutData(data);

		// Button listeners
		addRegisteredButton.addMouseListener(addRegisteredButtonListener = new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				registeredProfileButtonPressed();
			}
		});
	}

	/**
	 * Creates a button used to unapply a profile from the selected package.
	 */
	private void createUnapplyProfileButton() {
		FormData data = new FormData();

		// Button creation
		removeButton = factory.createButton(this, "", SWT.PUSH);
		removeButton.setImage(ImageManager.IMG_DELETE);
		removeButton.setToolTipText("Unapply profiles...");
		removeButton.setVisible(true);

		// Button placement
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		removeButton.setLayoutData(data);

		// Button listeners
		removeButton.addMouseListener(removeButtonListener = new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				unapplyProfileButtonPressed();
			}
		});
	}

	/**
	 * Dispose listeners.
	 */
	public void disposeListeners() {
		if (addButton != null && !addButton.isDisposed()) {
			addButton.removeMouseListener(addButtonListener);
		}
		if (removeButton != null && !removeButton.isDisposed()) {
			removeButton.removeMouseListener(removeButtonListener);
		}
		if (addRegisteredButton != null && !addRegisteredButton.isDisposed()) {
			addRegisteredButton.removeMouseListener(addRegisteredButtonListener);
		}
		if (profiles != null && !profiles.isDisposed()) {
			profiles.removeSelectionListener(profilesListener);
		}
	}

	public TransactionalEditingDomain getEditingDomain(Element context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 *
	 *
	 * @return
	 */
	protected List getProfiles() {
		return profiles;
	}

	/**
	 * Gets the selected package.
	 *
	 * @return the selected package or null
	 */
	public Package getSelectedPackage() {
		Package selectedPackage = null;
		Object input = ((IStructuredSelection) selectedElement).getFirstElement();
		Element element = UMLUtil.resolveUMLElement(input);
		if (element != null && element instanceof Package) {
			selectedPackage = (Package) element;
		}

		return selectedPackage;
	}

	/**
	 * Checks if the profile applied has been changed since last application (definition does not match).
	 *
	 * @param _package
	 *            on which the profile is applied
	 * @param _profile
	 *            the applied profile
	 * @return true if the profile has changed
	 */
	private boolean isDirty(Package _package, Profile _profile) {
		return ProfileUtil.isDirty(_package, _profile);
	}

	/**
	 * refresh the composite
	 */
	public void refresh() {
		Package currentPackage = getSelectedPackage();
		if (currentPackage != null && !profiles.isDisposed()) {
			profiles.removeAll();
			EList<Profile> appliedProfiles = currentPackage.getAllAppliedProfiles();
			for (int i = 0; i < appliedProfiles.size(); i++) {
				Profile currentProfile = appliedProfiles.get(i);
				String currentName = currentProfile.getQualifiedName();

				if (currentName == null) {
					Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Warning a profile applied on " + currentPackage.getName() + " could not be found : \n\t" + currentProfile.toString()));
				} else if (isDirty(currentPackage, currentProfile)) {
					profiles.add(currentName + TAG_PROFILE_CHANGED);
					profiles.setData(currentName, currentProfile);
				} else {
					profiles.add(currentName);
					profiles.setData(currentName, currentProfile);
				}
			}
		}

		updateEnablement();
	}

	protected boolean isEditable() {
		Package currentPackage = getSelectedPackage();
		return (currentPackage != null) && !EMFHelper.isReadOnly(currentPackage);
	}

	protected void updateEnablement() {
		boolean isEditable = isEditable();

		if ((addButton != null) && !addButton.isDisposed()) {
			addButton.setEnabled(isEditable);
			removeButton.setEnabled(isEditable);
			addRegisteredButton.setEnabled(isEditable);
		}
	}

	/**
	 * Button action : open the dialog box for registered profile selection.
	 */
	protected void registeredProfileButtonPressed() {
		RegisteredProfileSelectionDialog profileSelectionDialog = new RegisteredProfileSelectionDialog(getShell(), getSelectedPackage());
		java.util.List<Profile> profilestoApply = profileSelectionDialog.run();
		Iterator<Profile> iterator = profilestoApply.iterator();
		while (iterator.hasNext()) {
			if (getSelectedPackage() != null) {
				this.applyProfile(getSelectedPackage(), iterator.next(), false);
			}
		}
	}

	/**
	 * Sets the selection.
	 *
	 * @param selection
	 *            the selection
	 */
	public void setSelection(ISelection selection) {
		this.selectedElement = selection;

		updateEnablement();
	}

	/**
	 * unApply profile done in asynchronous thread
	 *
	 * @param thepackage
	 *            the package where the profile will be unapplied
	 * @param profile
	 *            to unapply
	 */
	protected void unApplyProfile(final Package thepackage, final Profile profile) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(thepackage);
			domain.runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {

							domain.getCommandStack().execute(new RecordingCommand(domain) {

								@Override
								protected void doExecute() {
									thepackage.unapplyProfile(profile);
									refresh();
								}
							});
						}
					});
				}
			});
		} catch (Exception e) {
			Activator.logException(e);
		}

	}

	/**
	 * Button action : unaply the profiles selected by the user.
	 */
	protected void unapplyProfileButtonPressed() {

		// Retrieve indices of selected profiles to unapply
		int[] selectionIndices = profiles.getSelectionIndices();
		if ((selectionIndices == null) || (selectionIndices.length == 0)) {
			return;
		}

		// Parse selection
		for (int i = 0; i < selectionIndices.length; i++) {

			int currentIndex = selectionIndices[i];
			// Remove TAG_PROFILE_CHANGED when it exists
			String itemName = profiles.getItem(currentIndex).replace(TAG_PROFILE_CHANGED, "");
			Profile profileToUnapply = (Profile) profiles.getData(itemName);

			if (profileToUnapply == null) {
				return;
			}

			// Allow removal if profile is applied on current package
			// Not if it is applied from owner package
			EList appliedProfiles = getSelectedPackage().getAppliedProfiles();
			if (appliedProfiles.contains(profileToUnapply)) {

				/**********************************************************************/
				/** delete imported model libraries and types related to that profile */

				// model libraries handling
				EList importedPackages = getSelectedPackage().getPackageImports();
				Iterator<PackageImport> iterPI = importedPackages.iterator();
				ArrayList importedPackagesToRemove = new ArrayList();
				while (iterPI.hasNext()) {
					PackageImport pi = iterPI.next();
					if (pi.getImportedPackage().getOwner() != null) {
						if (pi.getImportedPackage().getOwner().equals(profileToUnapply)) {
							importedPackagesToRemove.add(pi);
						}
					}
				}

				// remove model librairies
				// this has been done here to avoid concurrent modification of importedPackages
				for (int j = 0; j < importedPackagesToRemove.size(); j++) {
					importedPackages.remove(importedPackagesToRemove.get(j));
				}
			}
			unApplyProfile(getSelectedPackage(), profileToUnapply);
		}

	}

	/**
	 * Resolve semantic element
	 *
	 * @param object
	 *            the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	private EObject resolveSemanticObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		} else if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			if (EMFHelper.getEObject(adaptable) != null) {
				return EMFHelper.getEObject(adaptable);
			}
		}
		return null;
	}
}
