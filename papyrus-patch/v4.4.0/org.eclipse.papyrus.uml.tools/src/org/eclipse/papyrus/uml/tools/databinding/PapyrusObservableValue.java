/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *  Christian W. Damus (CEA) - bug 440108, 417409
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - bug 447698
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableValue;
import org.eclipse.papyrus.uml.tools.Activator;

/**
 * An ObservableValue used to edit EObject properties through
 * Papyrus commands
 *
 * @author Camille Letavernier
 * @deprecated since 1.2.0
 *             Use the {@link org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableValue} API, instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 */
@Deprecated
public class PapyrusObservableValue extends EMFObservableValue implements AggregatedObservable, CommandBasedObservableValue, ReferenceCountedObservable {

	private final ReferenceCountedObservable.Support refCount = new ReferenceCountedObservable.Support(this);

	/**
	 *
	 * Constructor.
	 *
	 * @param eObject
	 *            The EObject to edit
	 * @param eStructuralFeature
	 *            The structural feature to edit
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 */
	public PapyrusObservableValue(EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		this(Realm.getDefault(), eObject, eStructuralFeature, domain);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param realm
	 * @param eObject
	 *            The EObject to edit
	 * @param eStructuralFeature
	 *            The structural feature to edit
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 */
	public PapyrusObservableValue(Realm realm, EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(eObject, eStructuralFeature, domain);
	}

	@Override
	protected void doSetValue(Object value) {

		try {
			Command emfCommand = getCommand(value);
			domain.getCommandStack().execute(emfCommand);
		} catch (Exception ex) {
			//
		}
		// throw new IllegalArgumentException("an error occured");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Object value) {
		EObject eObjectValue = EMFHelper.getEObject(value);
		if (eObjectValue != null) {
			value = eObjectValue;
		}

		Object oldValue = getValue();

		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider((EObject) getObserved());

			if (provider != null) {
				CompositeCommand cc = new CompositeCommand("Edit value"); //$NON-NLS-1$

				if (oldValue instanceof EObject && eStructuralFeature instanceof EReference && ((EReference) eStructuralFeature).isContainment()) {
					cc.add(provider.getEditCommand(new DestroyElementRequest((TransactionalEditingDomain) domain, (EObject) oldValue, false)));
				}

				IEditCommandRequest createSetRequest = createSetRequest((TransactionalEditingDomain) domain, eObject, eStructuralFeature, value);

				if (createSetRequest == null) {
					return UnexecutableCommand.INSTANCE;
				}

				cc.add(provider.getEditCommand(createSetRequest));

				return new GMFtoEMFCommandWrapper(cc);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return UnexecutableCommand.INSTANCE;
	}

	protected IEditCommandRequest createSetRequest(TransactionalEditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {
		return new SetRequest(domain, owner, feature, value);
	}

	/**
	 *
	 * @return the {@link EStructuralFeature} observed by this object
	 */
	public EStructuralFeature getEStructuralFeature() {
		return eStructuralFeature;
	}

	/**
	 *
	 * @return the {@link EObject} observed by this object
	 */
	public EObject getEObject() {
		return eObject;
	}

	@Override
	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; // The observable cannot be aggregated
		}
	}

	@Override
	public boolean hasDifferentValues() {
		return false; // The value is not aggregated yet
	}

	@Override
	public void retain() {
		refCount.retain();
	}

	@Override
	public void release() {
		refCount.release();
	}

	@Override
	public void autorelease() {
		refCount.autorelease();
	}
}
