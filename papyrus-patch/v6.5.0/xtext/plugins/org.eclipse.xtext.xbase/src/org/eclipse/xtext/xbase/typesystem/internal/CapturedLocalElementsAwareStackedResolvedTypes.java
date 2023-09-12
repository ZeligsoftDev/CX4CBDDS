/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

/**
 * @author kosyakov - Initial contribution and API
 */
public class CapturedLocalElementsAwareStackedResolvedTypes extends StackedResolvedTypes {

	private final ResolvedTypes resolvedTypes;

	protected CapturedLocalElementsAwareStackedResolvedTypes(ResolvedTypes capturedResolvedTypes, ResolvedTypes resolvedTypes) {
		super(capturedResolvedTypes);
		this.resolvedTypes = resolvedTypes;
	}

	@Override
	protected StackedResolvedTypes pushTypes() {
		return new StackedResolvedTypes(this) {
			
			@Override
			protected void performMergeIntoParent() {
				mergeInto(resolvedTypes);
				clear();
			}

		};
	}

}
