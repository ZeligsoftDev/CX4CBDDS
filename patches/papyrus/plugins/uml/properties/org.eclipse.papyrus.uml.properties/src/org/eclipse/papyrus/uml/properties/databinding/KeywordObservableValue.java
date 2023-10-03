/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @since 3.0
 *
 */
public class KeywordObservableValue extends AbstractObservableValue implements IObserving, ReferenceCountedObservable {
	
	private final ReferenceCountedObservable.Support refCount = new ReferenceCountedObservable.Support(this);
	
	/**
	 * The object instance.
	 */
	protected Stereotype stereotype;
	
	/**
	 * The editing domain on which the commands will be executed.
	 */
	protected EditingDomain domain;
	
	/**
	 * Constructor.
	 *
	 * @param eObject The object.
	 * @param domain The editing domain.
	 */
	public KeywordObservableValue(final Stereotype stereotype, final EditingDomain domain) {
		this(Realm.getDefault(), stereotype, domain);
	}
	
	/**
	 * Constructor.
	 *
	 * @param realm The current Realm.
	 * @param eObject The object.
	 * @param domain The editing domain.
	 */
	public KeywordObservableValue(final Realm realm, final Stereotype stereotype, final EditingDomain domain) {
		super(realm);
		this.stereotype = stereotype;
		this.domain = domain;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 */
	@Override
	public synchronized void dispose() {
		stereotype = null;
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.IObserving#getObserved()
	 */
	public Object getObserved(){
		return stereotype;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 */
	@Override
	protected Object doGetValue(){
		return UMLLabelInternationalization.getInstance().getKeywordWithoutUML(stereotype);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 */
	@Override
	protected void doSetValue(Object value) {
		try {
			Command emfCommand = UMLLabelInternationalization.getInstance().getSetKeywordCommand(domain, stereotype, (String) value, null);
			domain.getCommandStack().execute(emfCommand);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 */
	public Object getValueType() {
		return UMLPackage.eINSTANCE.getNamedElement__GetLabel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable#retain()
	 */
	public void retain() {
		refCount.retain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable#release()
	 */
	public void release() {
		refCount.release();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable#autorelease()
	 */
	public void autorelease() {
		refCount.autorelease();
	}

}
