/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger

import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import java.util.Set
import org.eclipse.xtext.xbase.lib.Functions.Function0

/**
 * Encapsulation of "global" state of the merge algorithm.
 */
@Singleton
package final class MergeState {
	
	var MergePhase phase = MergePhase.NOT_STARTED
	val Set<ArchitectureDomain> domains = newLinkedHashSet
	
	/** Query the current phase of merging (especially whether inheritance or extensions processing). */
	def phase() { phase }
	/** Advance the state to the next phase of the merge algorithm. */
	package def advancePhase() {
		phase = switch (phase) {
			case NOT_STARTED: MergePhase.INHERITANCE
			case INHERITANCE: MergePhase.LEGACY
			case LEGACY: MergePhase.EXTENSIONS
			case EXTENSIONS: MergePhase.DONE
			default: throw new IllegalStateException("Merge is done.") //$NON-NLS-1$
		}
		
		ArchitectureExtensions.logf("=== Merge phase: %s ===", phase)
	}
	
	/** Query the current scope of domains being merged, whether for inheritance or for extension. */
	def Set<? extends ArchitectureDomain> currentDomains() { domains }
	/** Execute a {@code block} in a new scope of {@code domains} being merged. */
	def <T> T withDomains(Iterable<? extends ArchitectureDomain> domains, Function0<T> block) {
		val oldDomains = Set.copyOf(this.domains)
		
		try {
			setDomains(domains)
		
			ArchitectureExtensions.logf("Merging elements in scope of %s.", domains)
			
			block.apply
		} finally {
			setDomains(oldDomains)
		}
	}
	
	private def setDomains(Iterable<? extends ArchitectureDomain> domains) {
		this.domains.clear
		this.domains += domains
	}
	
}
