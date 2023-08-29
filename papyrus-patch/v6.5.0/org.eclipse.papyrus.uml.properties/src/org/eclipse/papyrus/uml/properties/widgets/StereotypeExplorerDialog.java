/*****************************************************************************
 * Copyright (c) 2016, 2022 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *  Vincent LORENZO (CEA-LIST) vincent.lorenzo@cea.fr - Bug 579917
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.editors.StringWithClearEditor;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.profile.index.ProfileWorkspaceModelIndex;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Selection dialog for icons in bundles.
 */
// TODO implement multiselection with multi return
public class StereotypeExplorerDialog extends SelectionStatusDialog {

	/**
	 * Content provider to get all available stereotype(plugin and workspace).
	 */
	public class StereotypeListContentProvider extends AbstractStaticContentProvider implements ITreeContentProvider {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		@Override
		public Object[] getChildren(final Object parentElement) {
			List<Object> children = new ArrayList<>();

			// Separator case
			if (parentElement instanceof String) {
				if (Messages.StereotypeExplorerDialog_PluginContributionSeparatorLabel.equals(parentElement)) {
					children.addAll(registeredProfiles);
				} else if (Messages.StereotypeExplorerDialog_WokspaceContributionSeparator.equals(parentElement)) {
					children.addAll(getWorkspaceProfiles());
				}
			} else {
				// Profile cases
				Profile profile = null;
				if (parentElement instanceof IRegisteredProfile) {
					profile = getProfile((IRegisteredProfile) parentElement);
				} else if (parentElement instanceof Profile) {
					profile = (Profile) parentElement;
				}
				if (null != profile) {
					children.addAll(getAllStereotypes(profile));
				}
			}

			return children.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
		 */
		@Override
		public Object[] getElements() {
			List<Object> element = getRoot();
			return element.toArray();
		}


		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		@Override
		public Object getParent(final Object element) {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		@Override
		public boolean hasChildren(final Object element) {
			return 0 != getChildren(element).length;
		}
	}


	/**
	 * A {@link DelegatingStyledCellLabelProvider} which implements {@link ILabelProvider} to be compatible with {@link PatternViewerFilter}.
	 */
	public class StereotypeStyledListLabelProvider extends DelegatingStyledCellLabelProvider implements ILabelProvider {

		/**
		 * Constructor.
		 *
		 * @param labelProvider
		 */
		public StereotypeStyledListLabelProvider() {
			super(new StereotypeListLabelProvider());
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			return getStyledStringProvider().getStyledText(element).getString();
		}

	}

	/**
	 * Label provider for Stereotype List.
	 */
	public class StereotypeListLabelProvider extends LabelProvider implements IStyledLabelProvider {
		/** The default profile icon path. */
		private static final String ICONS_PROFILE_GIF = "/icons/profile.gif";//$NON-NLS-1$

		/** The stereotype icon path. */
		private static final String ICONS_STEREOTYPE_GIF = "/icons/stereotype.gif";//$NON-NLS-1$

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(final Object element) {
			Image image = null;
			if (element instanceof IRegisteredProfile) {
				image = ((IRegisteredProfile) element).getImage();
				if (null == image) {
					image = Activator.getImage(ICONS_PROFILE_GIF);
				}
			} else if (element instanceof Stereotype) {
				image = Activator.getImage(ICONS_STEREOTYPE_GIF);
			} else if (element instanceof Profile) {
				image = Activator.getImage(ICONS_PROFILE_GIF);
			}
			return image;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(final Object element) {
			String label = null;
			if (element instanceof IRegisteredProfile) {
				label = new StringBuilder(((IRegisteredProfile) element).getName()).toString();
			} else if (element instanceof Stereotype) {
				label = ((Stereotype) element).getName();
			} else if (element instanceof Profile) {
				label = new StringBuilder(((Profile) element).getName()).toString();
			} else if (element instanceof String) {
				label = "------ " + element + " -----";//$NON-NLS-1$ //$NON-NLS-2$
			}

			return label;
		}

		/**
		 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
		 */
		@Override
		public StyledString getStyledText(final Object element) {
			// Get the original text
			String text = getText(element);

			// Add decorated text
			StyledString styledString = new StyledString(text);

			// Plugin and workspace separator style
			if (element instanceof String) {
				styledString.setStyle(0, text.length(),
						StyledString.COUNTER_STYLER);
			}else if (element instanceof Profile) {
				URI uri = EcoreUtil.getURI((EObject) element).trimFragment();
				String path = new StringBuilder(" - ")//$NON-NLS-1$
						.append(uri.toPlatformString(true).substring(1)).toString();
				styledString.append(path, StyledString.QUALIFIER_STYLER);
			} else if (element instanceof Stereotype) {
				String path = new StringBuilder(" - ")//$NON-NLS-1$
						.append(((Stereotype) element).getQualifiedName()).toString();
				styledString.append(path, StyledString.QUALIFIER_STYLER);
			}
			return styledString;
		}
	}

	/** indicates if several icons can be selected at the same time */
	protected final boolean allowMultiple;

	/** initial value */
	protected String initialValue;

	/** The resource set. */
	protected ResourceSet resourceSet = new ResourceSetImpl();

	/** The tree viewer. */
	protected TreeViewer stereotypeTreeViewer;

	/** The tree viewer filter. */
	protected PatternViewerFilterEx viewerFilter = new PatternViewerFilterEx();

	/** true if we only want to display applicable element on the set sourceUMLElement. */
	private boolean onlyApplicableStereotypes = true;

	/** The source uml element type in which we want to apply a stereotype. */
	private Element sourceUMLElement;

	/** The information text. */
	private StyledText informationText;

	/** The default profile icon path. */
	private static final String ICONS_EXPAND_ALL = "/icons/expandAll.png";//$NON-NLS-1$

	/** The default profile icon path. */
	private static final String ICONS_COLLAPSE_ALL = "/icons/collapseAll.png";//$NON-NLS-1$

	List<IRegisteredProfile> registeredProfiles = RegisteredProfile.getRegisteredProfiles();

	public StereotypeExplorerDialog(final Shell parentShell, final boolean allowMultiple, final String initialQualifyName) {
		super(parentShell);
		this.allowMultiple = allowMultiple;
		this.initialValue = initialQualifyName;
		setTitle(Messages.StereotypeExplorerDialog_Title);
		setMessage(Messages.StereotypeExplorerDialog_Message);
	}

	public StereotypeExplorerDialog(final Shell parentShell, final String initialValue) {
		this(parentShell, false, initialValue);
	}

	public StereotypeExplorerDialog(final Shell parentShell) {
		this(parentShell, false, "");//$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * Unloads resources.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	@Override
	public boolean close() {
		for (Resource resource : resourceSet.getResources()) {
			if (resource.isLoaded()) {
				resource.unload();
			}
		}
		return super.close();
	}

	/**
	 * Return the selected {@link Stereotype}.
	 * {@inheritDoc}
	 */
	@Override
	protected void computeResult() {
		Object selectedElements = getSelectedElements();
		if (selectedElements instanceof Stereotype) {
			setResult(Arrays.asList((Stereotype) selectedElements));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		initializeDialogUnits(composite);

		// creates the message area, as defined in the super class
		createMessageArea(composite);

		// Top composite containing filter and collapse/expand buttons
		Composite topComposite = new Composite(composite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(topComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(topComposite);

		// Create filter
		createFilterText(topComposite);

		// create separator
		Label separator = new Label(topComposite, SWT.VERTICAL | SWT.SEPARATOR);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 10).grab(false, false).applyTo(separator);

		// Create Expand button
		createExpandCollapseButtons(topComposite);
		createStereotypeFilteredList(composite);
		createInformationText(composite);
		createFilterOnSourceElementButton(composite);

		selectInitialValue();
		refreshOkButton();
		return composite;
	}

	/**
	 * Create buttons to collapse and expand treeViewer.
	 */
	protected void createExpandCollapseButtons(final Composite composite) {

		ToolBar container = new ToolBar(composite, SWT.NONE);

		ToolItem buttonExpand = new ToolItem(container, SWT.NONE);
		Image imageExpand = Activator.getPluginIconImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, ICONS_EXPAND_ALL);
		buttonExpand.setImage(imageExpand);
		buttonExpand.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = stereotypeTreeViewer.getSelection();
				// If there are selected element
				if (selection instanceof StructuredSelection && !selection.isEmpty()) {
					// For each element
					for (Object object : ((StructuredSelection) selection).toArray()) {
						((AbstractTreeViewer) stereotypeTreeViewer).expandToLevel(object, org.eclipse.papyrus.infra.widgets.Activator.getMaxLevelToExpandValue());
					}
				} else {
					// or expand all
					((AbstractTreeViewer) stereotypeTreeViewer).expandToLevel(org.eclipse.papyrus.infra.widgets.Activator.getMaxLevelToExpandValue());
				}
				stereotypeTreeViewer.refresh();
			}
		});

		ToolItem buttonCollapse = new ToolItem(container, SWT.NONE);
		Image imageCollapse = Activator.getPluginIconImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, ICONS_COLLAPSE_ALL);
		buttonCollapse.setImage(imageCollapse);
		buttonCollapse.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = ((AbstractTreeViewer) stereotypeTreeViewer).getSelection();
				// If there are selected element
				if (selection instanceof StructuredSelection && !selection.isEmpty()) {
					// expand each selected element
					for (Object object : ((StructuredSelection) selection).toArray()) {
						((AbstractTreeViewer) stereotypeTreeViewer).collapseToLevel(object, AbstractTreeViewer.ALL_LEVELS);
					}

				} else {
					// or collapse all
					((AbstractTreeViewer) stereotypeTreeViewer).collapseAll();
				}
			}
		});
	}

	/**
	 * Selected the initial value in treeViewer.
	 */
	protected void selectInitialValue() {
		// //Select initialValue Stereotype
		if (!initialValue.isEmpty()) {
			ITreeContentProvider contentProvider = (ITreeContentProvider) stereotypeTreeViewer.getContentProvider();
			Object[] roots = contentProvider.getElements(null);

			for (Object root : roots) {
				Object[] profiles = contentProvider.getChildren(root);
				for (Object profile : profiles) {
					Object[] stereotypes = contentProvider.getChildren(profile);
					for (Object stereotype : stereotypes) {
						if (stereotype instanceof Stereotype && initialValue.equals(((Stereotype) stereotype).getQualifiedName())) {
							stereotypeTreeViewer.expandToLevel(profile, 1);
							stereotypeTreeViewer.setSelection(new StructuredSelection(stereotype), true);
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Create information text field.
	 */
	protected void createInformationText(final Composite composite) {
		informationText = new StyledText(composite, SWT.BORDER | SWT.MULTI | SWT.READ_ONLY | SWT.H_SCROLL);
		informationText.setLayoutData(new GridData(SWT.FILL, SWT.WRAP, true, false));
		informationText.setAlwaysShowScrollBars(false);
	}

	/**
	 * Create the button to filter stereotype on selected element.
	 */
	protected void createFilterOnSourceElementButton(final Composite composite) {
		if (null != sourceUMLElement) {
			Button button = new Button(composite, SWT.CHECK);
			button.setText(Messages.StereotypeExplorerDialog_OnlyApplicableStereotypesLabel);
			button.setSelection(true);
			button.setEnabled(true);
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					onlyApplicableStereotypes = ((Button) event.getSource()).getSelection();
					viewerFilter.clearCache();
					stereotypeTreeViewer.refresh();
				}
			});
		}
	}

	/**
	 * Creates a filtered list.
	 *
	 * @param parent
	 *            the parent composite.
	 * @return returns the filtered list widget.
	 */
	protected TreeViewer createStereotypeFilteredList(final Composite parent) {

		Tree tree = new Tree(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		final GridLayout filterLayout = new GridLayout();
		filterLayout.marginHeight = 0;
		filterLayout.marginWidth = 0;
		tree.setLayout(filterLayout);
		{
			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			tree.setLayoutData(gridData);
		}

		TreeViewer treeViewer = new TreeViewer(tree);
		treeViewer.setContentProvider(new StereotypeListContentProvider());
		treeViewer.setLabelProvider(new StereotypeStyledListLabelProvider());

		treeViewer.setFilters(viewerFilter);
		treeViewer.setInput(new Object());// must set input once. Doesn't matter the object.
		treeViewer.expandToLevel(2);

		// Selection change listener to refresh button and information
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				refreshOkButton();
				refreshInformationText();
			}
		});

		// Double click listener to validate with double click
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(final DoubleClickEvent event) {
				if (getOkButton().isEnabled()) {
					okPressed();
				}
			}

		});

		treeViewer.refresh();
		stereotypeTreeViewer = treeViewer;

		return treeViewer;
	}

	/**
	 * Pattern viewer filter extension used to filter elements from stereotype tree viewer with the text field.
	 * Extended to filter only applicable {@link Stereotype} from source {@link Element}.
	 */
	private class PatternViewerFilterEx extends PatternViewerFilter {
		/**
		 * Only set it visible if we can load the profile.
		 * 
		 * @see org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter#isVisible(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public boolean isVisible(final Viewer viewer, final Object parentElement, final Object element) {

			boolean visible = super.isVisible(viewer, parentElement, element);
			visible &= StereotypeExplorerDialog.this.isVisible(element);
			return visible;
		}

		/**
		 * Override to pass method from protected to public.
		 * 
		 * @see org.eclipse.papyrus.infra.widgets.providers.AbstractTreeFilter#clearCache()
		 */
		public void clearCache() {
			super.clearCache();
		}
	}

	/**
	 * Creates an area where a filter can be entered.
	 *
	 * @param parent
	 *            the parent composite where to create the filter text
	 * @return the created text area
	 */
	protected void createFilterText(final Composite parent) {
		// Create the filter composite
		final StringWithClearEditor filterText = new StringWithClearEditor(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(filterText);
		filterText.setValue("");//$NON-NLS-1$

		filterText.getText().addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(final ModifyEvent e) {
				String value = filterText.getValue();
				viewerFilter.setPattern(value);
				stereotypeTreeViewer.refresh();
				stereotypeTreeViewer.collapseAll();
				// If some text in filter expands to the stereotype level else to the profile level
				stereotypeTreeViewer.expandToLevel(value.isEmpty() ? 2 : 3);
			}
		});

		// Key listener to focus in the treviewer when presser arrow down key
		filterText.getText().addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					stereotypeTreeViewer.getControl().setFocus();
				}
			}
		});
	}

	/**
	 * Gets the {@link Profile} model of an {@link IRegisteredProfile}.
	 */
	protected Profile getProfile(final IRegisteredProfile registeredProfile) {

		URI uri = registeredProfile.getUri();
		Resource resource = null;
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			Activator.log.error(e);
		}
		Profile profile = null;
		if (null != resource && !resource.getContents().isEmpty() && resource.getContents().get(0) instanceof Profile) {
			profile = (Profile) resource.getContents().get(0);
		}
		return profile;
	}

	/**
	 * Gets root profiles for the treeviewer.
	 */
	protected List<Object> getRoot() {
		List<Object> element = new ArrayList<>();
		element.add(new String(Messages.StereotypeExplorerDialog_PluginContributionSeparatorLabel));
		element.add(new String(Messages.StereotypeExplorerDialog_WokspaceContributionSeparator));
		return element;
	}

	/**
	 * Returns the currently selected element.
	 * To be called within or after open().
	 *
	 * @return returns the currently selected element.
	 */
	protected Object getSelectedElements() {
		Assert.isNotNull(stereotypeTreeViewer);
		return stereotypeTreeViewer.getStructuredSelection().getFirstElement();
	}

	/**
	 * Gets all workspace profiles.
	 */
	public Collection<Profile> getWorkspaceProfiles() {
		Collection<Profile> profiles = new ArrayList<>();
		Collection<URI> workspaceProfilesURIs = ProfileWorkspaceModelIndex.getInstance().getWorkspaceProfilesURIs();

		for (Iterator iterator = workspaceProfilesURIs.iterator(); iterator.hasNext();) {
			URI uri = (URI) iterator.next();
			Resource createResource = resourceSet.getResource(uri, true);
			if (!createResource.getContents().isEmpty() && createResource.getContents().get(0) instanceof Profile) {
				profiles.add((Profile) createResource.getContents().get(0));
			} else {
				createResource.unload();
			}
		}

		return profiles;
	}

	/**
	 * Refresh the Ok button according to the selection.
	 */
	protected void refreshOkButton() {
		Object selectedElements = getSelectedElements();
		if (selectedElements instanceof Stereotype) {
			updateStatus(new Status(IStatus.OK, Activator.ID, ""));//$NON-NLS-1$
		} else {
			updateStatus(new Status(IStatus.ERROR, Activator.ID, ""));//$NON-NLS-1$
		}
	}

	/**
	 * Refresh the Information text according to the selection.
	 */
	protected void refreshInformationText() {
		Object selectedElements = getSelectedElements();
		String label = "";//$NON-NLS-1$

		if (selectedElements instanceof Stereotype) {
			EList<Comment> comments = ((Element) ((Stereotype) selectedElements).getProfile()).getOwnedComments();
			// Carrier return used if many comments.
			String cr = "";//$NON-NLS-1$
			for (Comment comment : comments) {
				if (comment.getAnnotatedElements().contains(selectedElements)) {
					label += cr + comment.getBody();
					cr = "\n";//$NON-NLS-1$
				}
			}
		} else if (selectedElements instanceof Profile) {
			EList<Comment> comments = ((Element) selectedElements).getOwnedComments();
			// Carrier return used if many comments.
			String cr = "";//$NON-NLS-1$
			for (Comment comment : comments) {
				if (comment.getAnnotatedElements().contains(selectedElements)) {
					label += cr + comment.getBody();
					cr = " \n";//$NON-NLS-1$
				}
			}
		} else if (selectedElements instanceof IRegisteredProfile) {
			label = ((IRegisteredProfile) selectedElements).getDescription();
		}
		informationText.setText(label);
		informationText.pack();
		// Layout parent to refresh the multiline
		informationText.getParent().layout();
	}

	/**
	 * Set the source {@link Element} where to apply stereotype. Use to filter applicable stereotype.
	 */
	public void setElementToApplyStereotype(final Element sourceUMLElement) {
		this.sourceUMLElement = sourceUMLElement;
	}

	/**
	 * Gets all stereotypes from a {@link Profile}.
	 */
	protected List<Stereotype> getAllStereotypes(final Profile profile) {
		return StereotypeUtil.getAllStereotypes(profile);
	}

	/**
	 * Return true if element have to be visible.
	 */
	protected boolean isVisible(final Object element) {
		boolean visible = true;
		if (element instanceof IRegisteredProfile | element instanceof Profile | element instanceof String) {
			visible = false;
		} else if (element instanceof String) {
			visible = true;
		} else if (onlyApplicableStereotypes && element instanceof Stereotype && sourceUMLElement instanceof Element) {
			// Check if the source uml element is applicable to the stereotype.
			visible = isApplicableToSourceElement((Stereotype) element);
		}
		return visible;
	}


	/**
	 * Check if the source uml element is applicable to the stereotype.
	 */
	private boolean isApplicableToSourceElement(final Stereotype element) {
		boolean isApplicable = false;
		List<EClass> eClasses = ProfileUtil.getAllExtendedMetaclasses((Stereotype) element, true);
		for (EClass eClass : eClasses) {
			isApplicable |= eClass.getName().equals(sourceUMLElement.eClass().getName());
		}
		return isApplicable;
	}

}
