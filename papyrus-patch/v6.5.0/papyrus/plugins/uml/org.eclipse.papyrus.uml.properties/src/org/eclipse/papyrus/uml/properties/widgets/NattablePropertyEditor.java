/*****************************************************************************
 * Copyright (c) 2015, 2016, 2017, 2021 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation, Bug 502160, 494531
 *  Christian W. Damus - bugs 493858, 493853, 516310, 517313
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - bugs 494537, 504745
 *  Asma SMAOUI (CEA LIST) - bug 573840, 573841 
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.core.resource.EditingDomainServiceFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor.ServiceTypeKind;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceStartKind;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe;
import org.eclipse.papyrus.infra.emf.nattable.selection.EObjectSelectionExtractor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.BooleanValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NattablestyleFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NattablestylePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.Style;
import org.eclipse.papyrus.infra.nattable.resource.TableResourceHelper;
import org.eclipse.papyrus.infra.nattable.utils.NamedStyleConstants;
import org.eclipse.papyrus.infra.nattable.utils.NattableModelManagerFactory;
import org.eclipse.papyrus.infra.nattable.utils.TableResourceConstants;
import org.eclipse.papyrus.infra.properties.contexts.Property;
import org.eclipse.papyrus.infra.properties.ui.modelelement.CompositeModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSourceChangedEvent;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.IDataSourceListener;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.modelelement.UMLNotationModelElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyComposite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * The property editor for the nattable widget.
 */
@SuppressWarnings("restriction")
public class NattablePropertyEditor extends AbstractPropertyEditor {

	/**
	 * The save options to use.
	 * 
	 * @deprecated since 3.0. Use TableResourceFactory.
	 */
	@Deprecated
	private static final Map<Object, Object> saveOptions = new HashMap<Object, Object>();

	static {
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);
		saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
	}

	/**
	 * The folders in which we will save the table configured by the user.
	 */
	private static final String TABLES_PREFERENCES_FOLDER_NAME = "tables";//$NON-NLS-1$

	/**
	 * The file in which the table will be saved.
	 * 
	 * It doesn't work using .notation as extension file. In this case, the commands are not executed, because it is read-only, but why ?
	 * 
	 * @deprecated since 3.0. Use TableResourceConstants.TABLE_FILE_EXTENSION.
	 */
	@Deprecated
	@SuppressWarnings("unused")
	private static final String FILE_EXTENSION = "table";//$NON-NLS-1$

	/**
	 * The composite.
	 */
	protected Group self = null;;

	/**
	 * The table configuration URI.
	 */
	private URI tableConfigURI = null;

	/**
	 * The nattable widget.
	 */
	protected NatTable natTableWidget = null;

	/**
	 * The nattable manager.
	 */
	protected INattableModelManager nattableManager = null;

	/**
	 * The dispose listener.
	 */
	private DisposeListener nattableDisposeListener = null;

	/**
	 * The data source listener.
	 */
	private IDataSourceListener dataSourceListener;

	/**
	 * The service registry used to manipulate the table
	 */
	private ServicesRegistry serviceRegistry = null;

	/**
	 * the resource where the table will be saved
	 */
	private Resource resource = null;

	/**
	 * the edited Papyrus table
	 */
	private Table table = null;

	/**
	 * the table configuration
	 */
	private TableConfiguration tableConfiguration = null;

	/**
	 * if <code>true</code> we register table configuration by eClass and not only by table type
	 */
	private boolean registerTableConfigurationByEClass = false;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param style
	 *            The style of the composite.
	 */
	public NattablePropertyEditor(final Composite parent, final int style) {
		self = new Group(parent, SWT.NONE);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 10;
		self.setLayout(fillLayout);
	}

	/**
	 * 
	 * @param newValue
	 *            if <code>true</code> we register the table configuration by type AND by the ECLass of the selected element
	 * @since 2.0
	 */
	public final void setRegisterTableConfigurationByEClass(final boolean newValue) {
		this.registerTableConfigurationByEClass = newValue;
	}

	/**
	 * Set the table URI.
	 * 
	 * @param uri
	 *            The URI of the table (as String).
	 * @since 2.0
	 */
	public void setTableConfigurationURI(final String uri) {
		tableConfigURI = URI.createURI(uri);
		checkInput();
	}

	/**
	 * Get the table configuration URI.
	 * 
	 * @return The table configuration URI.
	 * @since 2.0
	 * 
	 */
	public String getTableConfigurationURI() {
		return tableConfigURI == null ? null : tableConfigURI.toString();
	}

	/**
	 * Set the table URI.
	 * 
	 * @param uri
	 *            The URI of the table (as String).
	 * 
	 * @deprecated since 2.0, use setTableConfigurationURI instead
	 */
	@Deprecated
	public void setTableURI(final String uri) {
		setTableConfigurationURI(uri);
	}

	/**
	 * Get the table configuration URI.
	 * 
	 * @return The table configuration URI.
	 * @deprecated since 2.0, use getTableConfigurationUri instead
	 */
	@Deprecated
	public String getTableURI() {
		return getTableConfigurationURI();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#checkInput()
	 */
	@Override
	protected void checkInput() {
		if (tableConfigURI != null) {
			super.checkInput();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#doBinding()
	 */
	@Override
	protected void doBinding() {
		super.doBinding();

		final ModelElement modelElement = input.getModelElement(propertyPath);

		// The data needed to create the table
		final List<Object> rows = new ArrayList<Object>();
		EObject sourceElement = null;
		EStructuralFeature feature = null;

		// Manage the data needed for the table creation
		if (modelElement instanceof CompositeModelElement) {
			if (!((CompositeModelElement) modelElement).getSubElements().isEmpty()) {
				if (((CompositeModelElement) modelElement).getSubElements().get(0) instanceof UMLNotationModelElement) {
					final EModelElement eModelElement = ((UMLNotationModelElement) ((CompositeModelElement) modelElement).getSubElements().get(0)).getEModelElement();
					// Fill the list of views to determinate the axis to display (cannot be created without the table editing domain)
					for (ModelElement subModelElement : ((CompositeModelElement) modelElement).getSubElements()) {
						if (subModelElement instanceof UMLNotationModelElement) {
							rows.add(((UMLNotationModelElement) subModelElement).getEModelElement());
						}
					}
					sourceElement = eModelElement;
				} else if (((CompositeModelElement) modelElement).getSubElements().get(0) instanceof EMFModelElement) {
					final EMFModelElement emfModelElement = (EMFModelElement) ((CompositeModelElement) modelElement).getSubElements().get(0);
					sourceElement = emfModelElement.getSource();
					feature = emfModelElement.getFeature(getLocalPropertyPath());
				}
			}
		} else if (modelElement instanceof UMLNotationModelElement) {
			final EModelElement eModelElement = ((UMLNotationModelElement) modelElement).getEModelElement();
			// Fill the list of views to determinate the axis to display (cannot be created without the table editing domain)
			rows.add(eModelElement);
			sourceElement = eModelElement;
		} else if (modelElement instanceof EMFModelElement) {
			final EMFModelElement emfModelElement = (EMFModelElement) modelElement;
			EObject source = emfModelElement.getSource();
			if (!(source instanceof Element)) {
				final Element baseElement = UMLUtil.getBaseElement(source);
				if (baseElement != null) {// in other case we will get an exeption somewhere
					source = baseElement;
				}
			}
			sourceElement = source;
			feature = emfModelElement.getFeature(getLocalPropertyPath());
		} else {
			displayError("Invalid table context"); //$NON-NLS-1$
			return;
		}

		// Create the widgets
		createWidgets(sourceElement, feature, rows);
	}

	/**
	 * This allow to create the widgets.
	 * 
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @param rows
	 *            The rows of the table.
	 * @since 2.0
	 */
	protected void createWidgets(final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {
		createPreviousWidgets(sourceElement, feature);
		createTableWidget(sourceElement, feature, rows);
		createFollowingWidgets(sourceElement, feature);

		// Configure the layout and the layout data
		configureLayout(sourceElement);
		self.layout();
	}

	/**
	 * This allow to create the widgets displayed before the table widget.
	 * 
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @since 2.0
	 */
	protected void createPreviousWidgets(final EObject sourceElement, final EStructuralFeature feature) {
		// To implement if some widgets are needed before the table widget
	}

	/**
	 * This allow to create the table widget or to reuse a table previously used in the property view
	 * 
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The parent structural feature.
	 * @param rows
	 *            The rows of the table.
	 * 
	 * @since 2.0
	 */
	protected void createTableWidget(final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {
		// 1. we initialize a service registry
		if (this.serviceRegistry == null) {
			try {
				this.serviceRegistry = createServiceRegistry(sourceElement);
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}

		if (this.serviceRegistry == null) {
			displayError("Cannot initialize the service registry"); //$NON-NLS-1$
			return;
		}

		// 2. get the editing domain
		TransactionalEditingDomain domain = getTableEditingDomain();
		if (domain == null) {
			displayError("Cannot found the editing domain"); //$NON-NLS-1$
			return;
		}

		// 3. Create the table or get an existing one
		this.table = getOrCreateTable(sourceElement, feature, rows);

		if (this.table == null) {
			displayError("Cannot initialize the table"); //$NON-NLS-1$
			return;
		}

		// 4. we configure the table
		final CompoundCommand cc = new CompoundCommand("Configure table command");//$NON-NLS-1$

		// 4.1 we register it into a resource if required
		if (this.table.eResource() == null) {
			cc.append(addTableToResource(domain, this.resource, this.table));
		}

		// 4.2 we configure the table
		configureTable(domain, this.table, sourceElement, feature, rows, cc);

		if (!cc.canExecute()) {
			displayError("The table can't be initialized");//$NON-NLS-1$
			return;
		}

		final ResourceSet resourceSet = getResourceSet();
		// Bug 502160: Remove the resource from the resource set to execute the command without using the editing command stack
		resourceSet.getResources().remove(this.resource);
		try {
			GMFUnsafe.write(domain, cc);
		} catch (InterruptedException e) {
			Activator.log.error(e);
		} catch (RollbackException e) {
			Activator.log.error(e);
		} finally {
			// Bug 502160: Re-add the removed resource before the command execute
			resourceSet.getResources().add(this.resource);
		}

		if (this.table.getContext() == null) {
			displayError("The context of the table hasn't be set");//$NON-NLS-1$
			return;
		}
		// 5. Create the widget
		this.nattableManager = NattableModelManagerFactory.INSTANCE.createNatTableModelManager(this.table, new EObjectSelectionExtractor());
		this.natTableWidget = createNatTableWidget(this.nattableManager, self, SWT.NONE, rows);

		self.addDisposeListener(getDisposeListener());
		// Configure the layout and the layout data
		configureLayout();

		((NattableModelManager) nattableManager).refreshNatTable();
	}

	/**
	 * This allow to create the widgets displayed after the table widget.
	 * 
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @since 2.0
	 */
	protected void createFollowingWidgets(final EObject sourceElement, final EStructuralFeature feature) {
		// To implement if some widgets are needed after the table widget
	}

	/**
	 * 
	 * @param parent
	 *            the composite parent
	 * @param style
	 *            the style to use to create the nattable widget
	 * @param rows
	 *            the initial rows
	 * @return
	 * 		the created nattable widget
	 * @since 2.0
	 */
	protected NatTable createNatTableWidget(final INattableModelManager manager, final Composite parent, final int style, Collection<?> rows) {
		NatTable natTable = manager.createNattable(self, style, null);
		natTable.setBackground(self.getBackground());
		return natTable;
	}

	/**
	 * 
	 * @param sourceElement
	 *            the source element used to initiatiaze the table
	 * @return
	 * 		the service registry to use for the table displayed in property view
	 * @throws Exception
	 * 
	 *             Duplicated code from org.eclipse.papyrus.junit.utils.rules.ModelSetFixture
	 * @since 2.0
	 */
	protected ServicesRegistry createServiceRegistry(EObject sourceElement) throws Exception {
		ServicesRegistry result = new ServicesRegistry();

		result.add(ModelSet.class, 10, new ModelSet());

		ServiceDescriptor desc = new ServiceDescriptor(TransactionalEditingDomain.class, EditingDomainServiceFactory.class.getName(), ServiceStartKind.STARTUP, 10);// , Collections.singletonList(ResourceSet.class.getName()));
		desc.setServiceTypeKind(ServiceTypeKind.serviceFactory);
		desc.setClassBundleID(Activator.PLUGIN_ID);
		result.add(desc);

		result.startRegistry();
		return result;
	}

	/**
	 * 
	 * @param domain
	 *            the editing domain to use
	 * @param table
	 *            the edited table
	 * @param sourceElement
	 *            the source element (id the context of the table
	 * @param synchronizedFeature
	 *            the feature on which the table is synchronized
	 * @param rows
	 *            the initial rows for the table
	 * @param command
	 *            the compound command used to do additional stuff
	 * 
	 * @since 2.0
	 */
	protected void configureTable(final TransactionalEditingDomain domain, final Table table, final EObject sourceElement, final EStructuralFeature synchronizedFeature, Collection<?> rows, CompoundCommand command) {
		Assert.isNotNull(domain);
		// 1. we register the context of the table
		Command setContextCommand = SetCommand.create(domain, table, NattablePackage.eINSTANCE.getTable_Context(), sourceElement);
		command.append(setContextCommand);
	}

	/**
	 * This allows to configure the tree table.
	 * 
	 * @param nattableManager
	 *            The nattable model manager.
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @param rows
	 *            The rows of the table.
	 * @deprecated since 2.0, moved into {@link TreeNattablePropertyEditor}
	 */
	@Deprecated
	protected void configureTreeTable(final TreeNattableModelManager nattableManager, final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {
		// Do nothing
	}

	/**
	 * This allows to configure the layout and the layout data.
	 * 
	 * @deprecated since 2.0.0
	 */
	@Deprecated
	protected void configureLayout() {
		// Adapt the group to the table preferred size
		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);

		// The preferred height of the nattable calculate it for each row (even if some are hidden)
		// So to calculate the correct height for the composite :
		// - Calculate the header height
		// - Calculate the body height
		// Add these values and add some extra to have correct displays
		final int headerHeight = natTableWidget.getPreferredHeight() - nattableManager.getBodyLayerStack().getRowHideShowLayer().getPreferredHeight();
		final int bodyHeight = nattableManager.getBodyLayerStack().getRowHideShowLayer().getHeight();
		// 16px must be added because of the left area slider
		final int extra = 20 + 16;
		data.minimumHeight = headerHeight + bodyHeight + extra;
		self.setLayoutData(data);

		self.layout();
		natTableWidget.layout();
	}

	/**
	 * This allows to configure the layout and the layout data.
	 * 
	 * @param sourceElement
	 *            The source element.
	 * @since 2.0
	 */
	protected void configureLayout(final EObject sourceElement) {
		// must be done first!
		((NattableModelManager) nattableManager).refreshNatTable();

		// Configure the size of the parent container
		configureSize(sourceElement);

		natTableWidget.layout();
	}

	/**
	 * This allows to configure the size of the parent container.
	 * 
	 * @param sourceElement
	 *            The source element.
	 * @since 2.0
	 */
	protected void configureSize(final EObject sourceElement) {
		// Adapt the group to the table preferred size
		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);

		// The preferred height of the nattable calculate it for each row (even if some are hidden)
		// So to calculate the correct height for the composite :
		// - Calculate the header height
		// - Calculate the body height
		// Add these values and add some extra to have correct displays
		final int headerHeight = natTableWidget.getPreferredHeight() - nattableManager.getBodyLayerStack().getRowHideShowLayer().getPreferredHeight();
		final int bodyHeight = nattableManager.getBodyLayerStack().getRowHideShowLayer().getHeight();
		// 16px must be added because of the left area slider
		final int extra = 20 + 16;
		data.minimumHeight = headerHeight + bodyHeight + extra;
		self.setLayoutData(data);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#updateDescription(java.lang.String)
	 */
	@Override
	protected void updateDescription(String description) {
		self.setToolTipText(description);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#updateLabel(java.lang.String)
	 */
	@Override
	public void updateLabel(final String label) {
		if (showLabel) {
			self.setText(getLabel());
		}
	}

	/**
	 * This allow to display the error.
	 * 
	 * @param message
	 *            The error message to display.
	 */
	protected void displayError(final String message) {
		final CLabel label = new CLabel(self, SWT.NONE);
		label.setText(message);
		label.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/error.gif")); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param sourceElement
	 *            the source Element
	 * @param synchronizedFeature
	 *            the synchronized feature
	 * @param rows
	 * @return
	 * 		the existing table or the new created one
	 * @since 2.0
	 */
	protected Table getOrCreateTable(final EObject sourceElement, final EStructuralFeature synchronizedFeature, final Collection<?> rows) {
		Table returnedTable = null;
		final TableConfiguration tableConfiguration = getTableConfiguration();
		if (tableConfiguration == null) {
			return null;
		}

		if (this.serviceRegistry != null) {
			URI tableURI = createTableURI(sourceElement, tableConfiguration);
			final ResourceSet resourceSet = getResourceSet();
			// Install the table support to manage the table as a correct Resource
			TableResourceHelper.installTableSupport(resourceSet);
			((ModelSet) resourceSet).createModels(tableURI);
			boolean exists = resourceSet.getURIConverter().exists(tableURI, Collections.emptyMap());
			if (exists) {
				this.resource = resourceSet.getResource(tableURI, true);
			} else {
				this.resource = resourceSet.createResource(tableURI);
			}

			Iterator<EObject> iter = this.resource.getContents().iterator();
			while (iter.hasNext() && returnedTable == null) {// the resource should contains only 1 table and this one will get the good type
				EObject object = iter.next();
				if (object instanceof Table) {
					TableConfiguration configuration = ((Table) object).getTableConfiguration();
					if (configuration != null && configuration.getType().equals(getTableConfiguration().getType())) {
						returnedTable = (Table) object;
					}
				}
			}

			if (null == returnedTable) {
				returnedTable = createTable(sourceElement, synchronizedFeature);
			}

		}

		return returnedTable;
	}

	/**
	 * 
	 * @return
	 * 		the resource set to use to load/store emf files
	 * @since 2.0
	 */
	protected ResourceSet getResourceSet() {
		ResourceSet set = null;
		if (this.serviceRegistry != null) {
			try {
				set = this.serviceRegistry.getService(ModelSet.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}
		return set;
	}

	/**
	 * Create URI for the table configuration.
	 * 
	 * @param sourceElement
	 *            The source Element
	 * @param tableConfiguration
	 *            The tableConfiguration
	 * @return The URI to use to save and load the table
	 * @since 2.0
	 */
	protected URI createTableURI(final EObject sourceElement, final TableConfiguration tableConfiguration) {
		// If the source element has an EClass, the table configuration file name
		// will be suffixed by the name of its eClass
		setRegisterTableConfigurationByEClass((sourceElement != null) && (sourceElement.eClass() != null));

		IPath preferencePath = Activator.getDefault().getStateLocation();
		// we create a folder to save the tables used by the property view and we start to create the name of the model owning the table
		preferencePath = preferencePath.append(TABLES_PREFERENCES_FOLDER_NAME).append(tableConfiguration.getType());

		// we continue to build the path, adding the good suffix to the name of the model
		final StringBuilder b = new StringBuilder().append(preferencePath.toPortableString());
		if (this.registerTableConfigurationByEClass) {
			ModelElement modelElement = input.getModelElement(propertyPath);
			EClass eClass = null;
			if (modelElement instanceof CompositeModelElement) {
				CompositeModelElement compoModelElement = (CompositeModelElement) modelElement;
				for (ModelElement next : compoModelElement.getSubElements()) {
					if ((next instanceof UMLNotationModelElement)
							|| (next instanceof EMFModelElement)) {
						modelElement = next;
						break;
					}
				}
			}

			if (modelElement instanceof UMLNotationModelElement) {
				EditPart part = ((UMLNotationModelElement) modelElement).getEditPart();
				eClass = EMFHelper.getEObject(part).eClass();
			} else if (modelElement instanceof EMFModelElement) {
				EObject source = ((EMFModelElement) modelElement).getSource();
				if (source != null) {
					eClass = source.eClass();
				}
			}

			if (eClass != null) {
				b.append("_"); //$NON-NLS-1$
				b.append(eClass.getName());
			}
		}

		URI newURI = URI.createFileURI(b.toString()).appendFileExtension(TableResourceConstants.TABLE_FILE_EXTENSION);
		return newURI;
	}


	/**
	 * This allow to create the nattable.
	 * 
	 * @param sourceElement
	 *            The context element.
	 * @param synchronizedFeature
	 *            The synchronized feature.
	 * @param rows
	 *            The rows of the table.
	 * @return The created table.
	 * 
	 * @since 2.0
	 */
	protected Table createTable(final EObject sourceElement, final EStructuralFeature synchronizedFeature) {
		final TableConfiguration tableConfiguration = getTableConfiguration();
		if (tableConfiguration == null) {
			return null;
		}
		final Table table = NattableFactory.eINSTANCE.createTable();
		table.setTableConfiguration(tableConfiguration);
		final Property property = getModelProperty();
		if (property != null) {
			String description = property.getDescription();
			if (description != null) {
				table.setDescription(description);
			}
		}

		table.setName(getLabel());
		// for table used in property view, the kindId was null, because it is given by the AF. So we propose to use the type for kindId
		table.setTableKindId(table.getTableConfiguration().getType());
		AbstractAxisProvider rowProvider = tableConfiguration.getDefaultRowAxisProvider();
		if (rowProvider == null) {
			rowProvider = NattableaxisproviderFactory.eINSTANCE.createMasterObjectAxisProvider();
		} else {
			rowProvider = EcoreUtil.copy(rowProvider);
		}

		AbstractAxisProvider columnProvider = tableConfiguration.getDefaultColumnAxisProvider();
		if (columnProvider == null) {
			columnProvider = NattableaxisproviderFactory.eINSTANCE.createSlaveObjectAxisProvider();
		} else {
			columnProvider = EcoreUtil.copy(columnProvider);
		}

		table.getColumnAxisProvidersHistory().add(columnProvider);
		table.setCurrentColumnAxisProvider(columnProvider);
		table.getRowAxisProvidersHistory().add(rowProvider);
		table.setCurrentRowAxisProvider(rowProvider);
		for (final Style style : tableConfiguration.getStyles()) {
			table.getStyles().add(EcoreUtil.copy(style));
		}

		// for the table displayed in property view, we want to use all the available place, so we add a specific named style each time
		// We manage it with percentage named style
		BooleanValueStyle columnsWidthAsPercentage = (BooleanValueStyle) table.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.COLUMNS_WIDTH_AS_PERCENTAGE);
		// if the name style already exists we do nothing
		if (null == columnsWidthAsPercentage) {
			// for the table displayed in property view, we want to use all the available place, so we add a specific named style each time
			BooleanValueStyle fillStyle = (BooleanValueStyle) table.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.FILL_COLUMNS_SIZE);
			// if the name style already exists we do nothing
			if (null == fillStyle) {
				columnsWidthAsPercentage = NattablestyleFactory.eINSTANCE.createBooleanValueStyle();
				columnsWidthAsPercentage.setName(NamedStyleConstants.COLUMNS_WIDTH_AS_PERCENTAGE);
				columnsWidthAsPercentage.setBooleanValue(true);
				table.getStyles().add(columnsWidthAsPercentage);
			}
		}

		// for the table displayed in property view, we expand all directly
		BooleanValueStyle expandStyle = (BooleanValueStyle) table.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.EXPAND_ALL);
		// if the name style already exists we do nothing
		if (null == expandStyle) {
			expandStyle = NattablestyleFactory.eINSTANCE.createBooleanValueStyle();
			expandStyle.setName(NamedStyleConstants.EXPAND_ALL);
			expandStyle.setBooleanValue(true);
			table.getStyles().add(expandStyle);
		}
		return table;
	}

	/**
	 * This allow to create the nattable.
	 * 
	 * @param sourceElement
	 *            The context element.
	 * @param synchronizedFeature
	 *            The synchronized feature.
	 * @param rows
	 *            The rows of the table.
	 * @return The created table.
	 * 
	 * @deprecated since 2.0, use the same method without the collections of rows as arguments. Rows are set later in the new implementation
	 */
	@Deprecated
	protected Table createTable(final EObject sourceElement, final EStructuralFeature synchronizedFeature, final Collection<?> rows) {
		final TableConfiguration tableConfiguration = getTableConfiguration();
		if (tableConfiguration == null) {
			return null;
		}
		final Table table = NattableFactory.eINSTANCE.createTable();
		table.setTableConfiguration(tableConfiguration);
		final Property property = getModelProperty();
		if (property != null) {
			String description = property.getDescription();
			if (description != null) {
				table.setDescription(description);
			}
		}

		table.setName(getLabel());

		AbstractAxisProvider rowProvider = tableConfiguration.getDefaultRowAxisProvider();
		if (rowProvider == null) {
			rowProvider = NattableaxisproviderFactory.eINSTANCE.createMasterObjectAxisProvider();
		} else {
			rowProvider = EcoreUtil.copy(rowProvider);
		}

		AbstractAxisProvider columnProvider = tableConfiguration.getDefaultColumnAxisProvider();
		if (columnProvider == null) {
			columnProvider = NattableaxisproviderFactory.eINSTANCE.createSlaveObjectAxisProvider();
		} else {
			columnProvider = EcoreUtil.copy(columnProvider);
		}

		if (null != synchronizedFeature) {
			TableHeaderAxisConfiguration rowHeaderAxisconfig = tableConfiguration.getRowHeaderAxisConfiguration();
			for (IAxisConfiguration axisConfig : rowHeaderAxisconfig.getOwnedAxisConfigurations()) {
				if (axisConfig instanceof EStructuralFeatureValueFillingConfiguration) {
					((EStructuralFeatureValueFillingConfiguration) axisConfig).setListenFeature(synchronizedFeature);
				}
			}
		}
		table.getColumnAxisProvidersHistory().add(columnProvider);
		table.setCurrentColumnAxisProvider(columnProvider);
		table.getRowAxisProvidersHistory().add(rowProvider);
		table.setCurrentRowAxisProvider(rowProvider);
		for (final Style style : tableConfiguration.getStyles()) {
			table.getStyles().add(EcoreUtil.copy(style));
		}

		return table;
	}

	/**
	 * 
	 * @return
	 * 		the editing domain to use
	 * 
	 * @since 2.0
	 */
	protected TransactionalEditingDomain getTableEditingDomain() {
		try {
			return this.serviceRegistry.getService(TransactionalEditingDomain.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Get the table configuration (from the table configuration URI).
	 * 
	 * @return The table configuration.
	 */
	protected TableConfiguration getTableConfiguration() {
		if (this.tableConfiguration == null) {
			ResourceSet resourceSet = getResourceSet();
			if (resourceSet != null) {
				try {
					this.tableConfiguration = (TableConfiguration) EMFHelper.loadEMFModel(resourceSet, this.tableConfigURI);
				} catch (Exception ex) {
					Activator.log.error("Invalid table configuration", ex); //$NON-NLS-1$
				}
			}
		}
		return this.tableConfiguration;
	}

	/**
	 * This allow to create the dispose listener for the nattable table manager.
	 * 
	 * @return The dispose nattable manager listener.
	 */
	protected DisposeListener getDisposeListener() {
		if (null == this.nattableDisposeListener) {
			this.nattableDisposeListener = new DisposeListener() {

				@Override
				public void widgetDisposed(DisposeEvent e) {
					disposeListener();
				}
			};
		}
		return nattableDisposeListener;
	}

	/**
	 * This allows to dispose the listeners.
	 * 
	 * @since 2.0
	 */
	protected void disposeListener() {
		if (NattablePropertyEditor.this.serviceRegistry != null) {
			// we dispose it to avoid unecessary refresh
			if (null != this.nattableManager) {
				this.nattableManager.dispose();
			}
			if (null != this.natTableWidget) {
				this.natTableWidget.dispose();
			}
			if (NattablePropertyEditor.this.resource != null) {
				try {
					NattablePropertyEditor.this.resource.save(null);
				} catch (IOException e1) {
					Activator.log.error(e1);
				}
			}
			try {
				NattablePropertyEditor.this.serviceRegistry.disposeRegistry();
			} catch (ServiceMultiException e1) {
				Activator.log.error(e1);
			}
			NattablePropertyEditor.this.serviceRegistry = null;
			NattablePropertyEditor.this.table = null;

		}
	}

	/**
	 * 
	 * @param domain
	 *            the editing domain
	 * @param table
	 *            the table to clean before dispose
	 * @return
	 * 		the command to use to clean the table before disposing it
	 * @since 2.0
	 * @deprecated since 3.0
	 */
	@Deprecated
	protected CompoundCommand getDisposeTableCommand(final TransactionalEditingDomain domain, final Table table) {
		CompoundCommand disposeCommand = new CompoundCommand("Command used to clean the table before disposing it"); //$NON-NLS-1$
		disposeCommand.append(SetCommand.create(domain, table, NattablePackage.eINSTANCE.getTable_Context(), null));
		disposeCommand.append(SetCommand.create(domain, table, NattablePackage.eINSTANCE.getTable_Owner(), null));
		// assuming the table is synchronized and not inverted :
		disposeCommand.append(SetCommand.create(domain, table.getCurrentRowAxisProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), Collections.emptyList()));

		return disposeCommand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#unhookDataSourceListener(org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource)
	 */
	@Override
	protected void unhookDataSourceListener(DataSource oldInput) {
		oldInput.removeDataSourceListener(getDataSourceListener());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#hookDataSourceListener(org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource)
	 */
	@Override
	protected void hookDataSourceListener(DataSource newInput) {
		newInput.addDataSourceListener(getDataSourceListener());
	}

	/**
	 * This allow to create the data source listener.
	 * 
	 * @return The created data source listener.
	 */
	private IDataSourceListener getDataSourceListener() {
		if (dataSourceListener == null) {
			dataSourceListener = new IDataSourceListener() {

				@Override
				public void dataSourceChanged(final DataSourceChangedEvent event) {
					// bug 494537 - The diagram selection changed, but the property view has not been disposed
					disposeListener();
					// Bug 492560: The self children control was not all disposed correclty
					if (null != self) {
						if (self.getChildren().length > 0) {
							for (Control control : self.getChildren()) {
								control.dispose();
							}
						}
						self.removeDisposeListener(getDisposeListener());
						nattableDisposeListener = null;
						self.layout();
					}
					// Get the datasource
					final DataSource dataSource = event.getDataSource();
					final StructuredSelection selection = (StructuredSelection) dataSource.getSelection();

					// Manage the context selection
					final List<Object> contexts = new ArrayList<Object>(selection.size());
					EObject sourceElement = null;
					final Iterator<?> selectionIterator = selection.iterator();
					while (selectionIterator.hasNext()) {
						Object selectedObject = selectionIterator.next();
						if (selectedObject instanceof AbstractEditPart) {
							contexts.add(((AbstractEditPart) selectedObject).getModel());
						} else {
							contexts.add(selectedObject);
						}

						if (sourceElement == null) {
							// An edit-part in GMF can resolve its semantic element
							// to something different to the element referenced by
							// its notation view, so don't rely on the notation
							sourceElement = EMFHelper.getEObject(selectedObject);
						}
					}

					// Get the model element
					if (sourceElement != null) {
						final ModelElement modelElement = dataSource.getModelElement(propertyPath);
						sourceElement = getEObjectAsTableContext(sourceElement); // Convert to table context
						EStructuralFeature feature = null;
						if (modelElement instanceof CompositeModelElement) {
							if (!((CompositeModelElement) modelElement).getSubElements().isEmpty()) {
								if (((CompositeModelElement) modelElement).getSubElements().get(0) instanceof EMFModelElement) {
									final EMFModelElement emfModelElement = (EMFModelElement) ((CompositeModelElement) modelElement).getSubElements().get(0);
									feature = emfModelElement.getFeature(getLocalPropertyPath());
								}
							}
						} else if (modelElement instanceof EMFModelElement) {
							final EMFModelElement emfModelElement = (EMFModelElement) modelElement;
							feature = emfModelElement.getFeature(getLocalPropertyPath());
						}

						// Recreate the table widget, its adjuncts, and their layout
						createWidgets(sourceElement, feature, contexts);

						// We need to refresh the parent composite to get the needed space
						Composite parent = self.getParent();
						boolean found = false;
						while (null != parent && !found) {
							if (parent instanceof TabbedPropertyComposite) {
								found = true;
							} else {
								parent.layout(true, true);
								parent.redraw();
								parent.update();
							}
							parent = parent.getParent();
						}
					}
				}
			};
		}

		return dataSourceListener;
	}

	/**
	 * This allows to get the table context as EObject (and avoid View).
	 * 
	 * @param element
	 *            The initial source element.
	 * @return The source element defining Table context.
	 * @since 2.1
	 */
	protected EObject getEObjectAsTableContext(final EObject element) {
		EObject result = element;
		if (result instanceof View) {
			result = ((View) result).getElement();
		}
		return result;
	}

	/**
	 * 
	 * @param domain
	 *            the editing domain to use
	 * @param resource
	 *            the resource where the table must be saved
	 * @param table
	 *            the table to add to the resource
	 * @return
	 * 		the command to add the table to the resource
	 */
	private static final Command addTableToResource(final TransactionalEditingDomain domain, final Resource resource, final Table table) {
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				resource.getContents().add(table);
			}
		};
	}
}
