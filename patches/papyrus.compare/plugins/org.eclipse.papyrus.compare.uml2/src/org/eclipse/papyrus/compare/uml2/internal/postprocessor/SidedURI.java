/*******************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.postprocessor;

import com.google.common.base.Preconditions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.DifferenceSource;

/**
 * A resource {@link URI} on some {@linkplain DifferenceSource side} of a comparison.
 *
 * @author Christian W. Damus
 */
final class SidedURI {

	private final URI uri;

	private final DifferenceSource side;

	/**
	 * Initializes me.
	 */
	private SidedURI(URI uri, DifferenceSource side) {
		super();

		this.uri = Preconditions.checkNotNull(uri);
		this.side = Preconditions.checkNotNull(side);
	}

	public URI uri() {
		return uri;
	}

	public DifferenceSource side() {
		return side;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SidedURI other = (SidedURI)obj;
		if (side != other.side) {
			return false;
		}
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}

	public static SidedURI left(URI uri) {
		return new SidedURI(uri, DifferenceSource.LEFT);
	}

	public static SidedURI right(URI uri) {
		return new SidedURI(uri, DifferenceSource.RIGHT);
	}

	public static SidedURI of(URI uri, DifferenceSource side) {
		return new SidedURI(uri, side);
	}
}
