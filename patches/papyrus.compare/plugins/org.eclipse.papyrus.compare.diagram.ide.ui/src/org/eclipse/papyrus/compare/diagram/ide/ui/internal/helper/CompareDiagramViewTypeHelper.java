/*******************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal.helper;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.compare.diagram.ide.ui.internal.CompareDiagramIDEUIPapyrusPlugin;
import org.eclipse.papyrus.compare.uml2.internal.hook.migration.ModelSetWrapper;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.resource.BadStateException;
import org.eclipse.papyrus.infra.core.resource.ModelIdentifiers;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.GMFDiagramViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;

/**
 * View-type helper that can query the Architecture Context view type associations in {@link ResourceSet}s
 * that are not {@link ModelSet}s.
 *
 * @author Christian W. Damus
 */
public class CompareDiagramViewTypeHelper extends GMFDiagramViewTypeHelper {

	/**
	 * Initializes me.
	 */
	public CompareDiagramViewTypeHelper() {
		super();
	}

	@Override
	public boolean isSupported(EObject view) {
		if (!(view instanceof Diagram)) {
			return false;
		}

		Resource resource = view.eResource();
		if (resource != null) {
			// Don't need our implementation if the resource is in a native ModelSet
			ResourceSet rset = resource.getResourceSet();
			return rset != null && !(rset instanceof ModelSet);
		}

		return false;
	}

	/**
	 * Obtains the most appropriate policy checker for a given {@code view}.
	 * 
	 * @param diagram
	 *            a diagram
	 * @return its policy checker
	 */
	@Override
	protected PolicyChecker getPolicyChecker(EObject view) {
		ModelSet modelSet = getModelSet(view);
		Collection<MergedArchitectureViewpoint> viewpoints = new ArchitectureDescriptionUtils(modelSet)
				.getArchitectureViewpoints();
		return PolicyChecker.getFor(viewpoints);
	}

	protected ModelSet getModelSet(EObject view) {
		ModelSet result;

		// We already checked that it's in a resource
		Resource resource = view.eResource();
		ModelSetAdapter adapter = (ModelSetAdapter)EcoreUtil.getExistingAdapter(resource,
				ModelSetAdapter.class);
		if (adapter != null) {
			result = adapter.getModelSet();
		} else {
			result = createModelSet(resource);
			resource.eAdapters().add(new ModelSetAdapter(result));
		}

		return result;
	}

	protected ModelSet createModelSet(Resource resource) {
		// We already checked that it's in a resource set
		ResourceSet rset = resource.getResourceSet();
		ModelSetWrapper result = new ModelSetWrapper(rset);

		result.setURIWithoutExtension(resource.getURI().trimFileExtension());
		result.registerModel(new DiModel());
		result.registerModel(new SashModel());

		for (String next : getArchitectureModels()) {
			try {
				result.loadModel(next);
			} catch (BadStateException e) {
				CompareDiagramIDEUIPapyrusPlugin.getDefault().getLog()
						.log(new Status(IStatus.WARNING, CompareDiagramIDEUIPapyrusPlugin.PLUGIN_ID,
								"Failed to load Papyrus model " + next, e)); //$NON-NLS-1$
			}
		}

		return result;
	}

	protected ModelIdentifiers getArchitectureModels() {
		return new ModelIdentifiers(DiModel.DI_MODEL_ID, SashModel.MODEL_ID);
	}

	//
	// Nested types
	//

	/**
	 * Cache of fake model-sets for view-type helping on diagrams.
	 *
	 * @author Christian W. Damus
	 */
	private static class ModelSetAdapter extends AdapterImpl {
		private final ModelSet modelSet;

		ModelSetAdapter(ModelSet modelSet) {
			super();

			this.modelSet = modelSet;
		}

		ModelSet getModelSet() {
			return modelSet;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ModelSetAdapter.class;
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			super.unsetTarget(oldTarget);

			if (getTarget() == null) {
				if (modelSet instanceof ModelSetWrapper) {
					// First, detach for safe clean-up of shared resources
					// to avoid unloading them
					((ModelSetWrapper)modelSet).detach();
				}

				modelSet.unload();
			}
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) {
				return;
			}

			if (msg.getNotifier() instanceof Resource) {
				switch (msg.getFeatureID(Resource.class)) {
					case Resource.RESOURCE__IS_LOADED:
						if (!msg.getNewBooleanValue()) {
							// We have done with this resource
							((Resource)msg.getNotifier()).eAdapters().remove(this);
						}
						break;
					default:
						// Pass
						break;
				}
			}
		}
	}
}
