/*******************************************************************************
 * Copyright (c) 2016, 2019 Ericsson and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Simon Delisle - initial API and implementation
 *     Christian W. Damus - bug 527638
 *     Philip Langer - performance improvement
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.emf.edit.domain.PapyrusTransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.gmf.util.GMFUnsafe;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconcilersReader;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramVersioningUtils;

/**
 * Hook in the EMF Compare {@link ResourceSet} in order to make it able to handle papyrus diagram migration
 * features.
 * 
 * @author <a href="mailto:simon.delisle@ericsson.com">Simon Delisle</a>
 */
public class DiagramMigrationHook extends AbstractPapyrusResourceSetHook {

	@Override
	public void preLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		// Pass
	}

	@Override
	public void postLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		List<Diagram> diagramsNeedingMigration = getDiagramsNeedingMigration(resourceSet);
		if (diagramsNeedingMigration.isEmpty()) {
			return;
		}

		TransactionalEditingDomain domain = getEditingDomain(resourceSet);
		try {
			for (Diagram diagram : diagramsNeedingMigration) {
				IDGenerator idgen = new IDGenerator(diagram);
				try {
					migrateDiagram(domain, diagram);
				} finally {
					idgen.dispose();
				}
			}
		} finally {
			domain.dispose();
		}
	}

	private List<Diagram> getDiagramsNeedingMigration(ResourceSet resourceSet) {
		List<Diagram> diagramsNeedingMigration = new ArrayList<>();
		for (Resource resource : new ArrayList<Resource>(resourceSet.getResources())) {
			if (NotationModel.NOTATION_FILE_EXTENSION.equals(resource.getURI().fileExtension())) {
				for (EObject object : resource.getContents()) {
					if (object instanceof Diagram
							&& !DiagramVersioningUtils.isOfCurrentPapyrusVersion((Diagram)object)) {
						diagramsNeedingMigration.add((Diagram)object);
					}
				}
			}
		}
		return diagramsNeedingMigration;
	}

	/**
	 * Get the editing domain for this resourceSet or create it.
	 * 
	 * @param resourceSet
	 *            The resource set
	 * @return TransactionalEditingDomain
	 */
	private TransactionalEditingDomain getEditingDomain(ResourceSet resourceSet) {
		TransactionalEditingDomain existingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(resourceSet);
		if (existingDomain == null) {
			return PapyrusTransactionalEditingDomain.FACTORY.createEditingDomain(resourceSet);
		} else {
			return existingDomain;
		}
	}

	/**
	 * Build the migration command.
	 * 
	 * @param diagram
	 *            Diagram you want to migrate
	 * @return CompositeCommand
	 */
	private CompositeCommand buildCommand(Diagram diagram) {
		CompositeCommand reconcileCommand = null;

		reconcileCommand = new CompositeCommand("Reconciling"); //$NON-NLS-1$

		String sourceVersion = DiagramVersioningUtils.getCompatibilityVersion(diagram);
		Map<String, Collection<DiagramReconciler>> diagramReconcilers = DiagramReconcilersReader.getInstance()
				.load();
		String diagramType = diagram.getType();
		Collection<DiagramReconciler> reconcilers = new LinkedList<DiagramReconciler>();
		if (diagramReconcilers.containsKey(diagramType)) {
			reconcilers.addAll(diagramReconcilers.get(diagramType));
		}

		boolean someFailed = false;
		Iterator<DiagramReconciler> reconciler = reconcilers.iterator();
		while (reconciler.hasNext() && !someFailed) {
			DiagramReconciler next = reconciler.next();

			if (!next.canReconcileFrom(diagram, sourceVersion)) {
				// asked for ignore it for this instance, all fine
				continue;
			}
			ICommand nextCommand = next.getReconcileCommand(diagram);
			if (nextCommand == null) {
				// legitimate no-op response, all fine
				continue;
			}

			if (nextCommand.canExecute()) {
				reconcileCommand.add(nextCommand);
			} else {
				CompareDiagramIDEUIPapyrusPlugin.getDefault().getLog()
						.log(new Status(IStatus.ERROR, CompareDiagramIDEUIPapyrusPlugin.PLUGIN_ID,
								"Diagram reconciler " + next + " failed to reconcile diagram: " + diagram)); //$NON-NLS-1$ //$NON-NLS-2$
				someFailed = true;
			}
		}
		if (someFailed) {
			reconcileCommand = null;
		}
		return reconcileCommand;
	}

	/**
	 * Migrate the diagram to the current version of Papyrus.
	 * 
	 * @param domain
	 *            The editing domain for this diagram.
	 * @param diagram
	 *            The diagram.
	 */
	private void migrateDiagram(TransactionalEditingDomain domain, Diagram diagram) {
		CompositeCommand migrationCommand = buildCommand(diagram);
		if (migrationCommand == null) {
			return;
		}

		migrationCommand.add(DiagramVersioningUtils.createStampCurrentVersionCommand(diagram));
		// TODO: Handle reconcile exception
		try {
			// The migration command requires a transactional editing domain, but we don't
			// want to record anything for undo/redo etc.
			GMFUnsafe.write(domain, migrationCommand);
		} catch (Exception e) {
			logException(e);
		}
	}

	/**
	 * Logs the specified exception.
	 * 
	 * @param t
	 *            The exception to be logged.
	 */
	private static void logException(Throwable t) {
		CompareDiagramIDEUIPapyrusPlugin.getDefault().getLog()
				.log(new Status(IStatus.WARNING, CompareDiagramIDEUIPapyrusPlugin.PLUGIN_ID,
						"Could not migrate the diagram before comparison", t)); //$NON-NLS-1$
	}

	//
	// Nested types
	//

	/**
	 * An adapter that generates new unique IDs, using a stable algorithm, for all new objects created by
	 * diagram migration. This helps to ensure that when the same diagram on multiple sides of a comparison is
	 * migrated on each side, that new elements created by migration are matched to avoid spurious add-add
	 * conflicts.
	 *
	 * @author Christian W. Damus
	 */
	protected static class IDGenerator extends EContentAdapter {
		private static final Pattern NOT_NCNAME = Pattern.compile("[^-a-zA-Z0-9_.]"); //$NON-NLS-1$

		private static final String CHILDREN_PAT = "%s.%d"; //$NON-NLS-1$

		private static final String STYLES_PAT = "%s._%s"; //$NON-NLS-1$

		private static final String OTHER_PAT = "%s.%s%d"; //$NON-NLS-1$

		private final Matcher notNCName = NOT_NCNAME.matcher(""); //$NON-NLS-1$

		private final EObject root;

		// Papyrus diagrams do not support cross-resource containment
		private XMLResource resource;

		private boolean enabled;

		/**
		 * Initializes me for generation of predictable, matchable unique identifiers in the tree under the
		 * given {@code root}.
		 * 
		 * @param root
		 *            the root of a tree in which to generate unique identifiers
		 */
		public IDGenerator(EObject root) {
			super();

			this.root = root;
			this.resource = (XMLResource)root.eResource();

			root.eAdapters().add(this);
			this.enabled = true;
		}

		public void dispose() {
			this.enabled = false;
			root.eAdapters().remove(this);
		}

		@Override
		protected void setTarget(EObject target) {
			if (enabled) {
				generateID(target);
			}

			super.setTarget(target);
		}

		/**
		 * Generate a new unique ID for an {@code object} based on its containment in its parent object.
		 * 
		 * @param object
		 *            a new object for which to generate a predictable, matchable ID
		 */
		protected void generateID(EObject object) {
			// Everything has a container because we can never attempt to generate
			// the ID of the diagram, itself
			EObject parent = object.eContainer();
			String parentID = resource.getID(parent);
			String newID;

			EReference containment = object.eContainmentFeature();
			int index = indexOf(parent, containment, object);
			if (containment == NotationPackage.Literals.VIEW__PERSISTED_CHILDREN) {
				// For the most common case, the most compact scheme
				newID = format(CHILDREN_PAT, parentID, Integer.valueOf(index));
			} else if (containment == NotationPackage.Literals.VIEW__STYLES) {
				// Identify styles by EClass to avoid ordering issues
				newID = format(STYLES_PAT, parentID, asID(object.eClass().getName()));
			} else {
				newID = format(OTHER_PAT, parentID, asID(containment.getName()), Integer.valueOf(index));
			}

			resource.setID(object, unique(newID));
		}

		/**
		 * Compures the index of an object {@code contained} in some {@code containment} reference of a
		 * {@code container}.
		 * 
		 * @param container
		 *            the containing object
		 * @param containment
		 *            the reference in which the {@code contained} object is stored
		 * @param contained
		 *            the contained object
		 * @return its index
		 */
		protected int indexOf(EObject container, EReference containment, EObject contained) {
			if (containment.isMany()) {
				return ((InternalEList<?>)container.eGet(containment, false)).basicIndexOf(contained);
			} else {
				return 0;
			}
		}

		/**
		 * Transforms a {@link name} from the Ecore model by removing characters that are not valid in an XMI
		 * ID.
		 * 
		 * @param name
		 *            an Ecore name
		 * @return a munged variant that is suitable for concatenation in an XMI ID (usually unchanged)
		 */
		protected String asID(String name) {
			notNCName.reset(name);
			return notNCName.replaceAll(""); //$NON-NLS-1$
		}

		/**
		 * Munge an object identifier, if necessary, to make it unique in the resource.
		 * 
		 * @param id
		 *            an object identifier
		 * @return an unique variant of the identifier (usually unchanged)
		 */
		protected String unique(String id) {
			String base = id;
			String result = base;
			int suffix = -1;

			while (resource.getEObject(result) != null) {
				if (suffix < 0) {
					base = base + '_';
				}
				suffix++;
				result = base + suffix;
			}

			return result;
		}
	}
}
