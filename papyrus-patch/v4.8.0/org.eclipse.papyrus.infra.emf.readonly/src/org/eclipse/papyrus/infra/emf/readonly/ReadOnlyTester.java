/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
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
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;

public class ReadOnlyTester extends PropertyTester {

	public static final String IS_READ_ONLY = "isReadOnly"; //$NON-NLS-1$

	public static final String CAN_MAKE_WRITABLE = "canMakeWritable"; //$NON-NLS-1$

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		Iterator<?> objects;
		if (receiver instanceof Iterator<?>) {
			objects = (Iterator<?>) receiver;
		} else if (receiver instanceof Iterable<?>) {
			objects = ((Iterable<?>) receiver).iterator();
		} else {
			objects = Iterators.singletonIterator(receiver);
		}

		if (IS_READ_ONLY.equals(property)) {
			return testIsReadOnly(objects, asBoolean(expectedValue));
		} else if (CAN_MAKE_WRITABLE.equals(property)) {
			return canMakeWritable(objects, asBoolean(expectedValue));
		}

		return false;
	}

	protected Boolean asBoolean(Object expectedValue) {
		// true is the implied expected value for booleans
		return (expectedValue instanceof Boolean) ? (Boolean) expectedValue : true;
	}

	protected boolean testIsReadOnly(Iterator<?> objects, Boolean expectedValue) {
		while (objects.hasNext()) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(objects.next());

			if (businessObject instanceof EObject) {
				EObject eObject = (EObject) businessObject;
				EditingDomain domain = EMFHelper.resolveEditingDomain(eObject);
				if (domain != null) {
					return Objects.equal(ReadOnlyManager.getReadOnlyHandler(domain).isReadOnly(ReadOnlyAxis.anyAxis(), eObject).or(false), expectedValue);
				}
			}
		}

		return false;
	}

	protected boolean canMakeWritable(Iterator<?> objects, Boolean expectedValue) {
		while (objects.hasNext()) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(objects.next());

			if (businessObject instanceof EObject) {
				EObject eObject = (EObject) businessObject;
				EditingDomain domain = EMFHelper.resolveEditingDomain(eObject);
				if (domain != null) {
					IReadOnlyHandler2 handler = ReadOnlyManager.getReadOnlyHandler(domain);

					boolean isAlreadyOrCanMakeWritable = !handler.isReadOnly(ReadOnlyAxis.anyAxis(), eObject).or(false) //
							|| handler.canMakeWritable(ReadOnlyAxis.anyAxis(), eObject).or(false);

					return Objects.equal(isAlreadyOrCanMakeWritable, expectedValue);
				}
			}
		}

		return false;
	}
}
