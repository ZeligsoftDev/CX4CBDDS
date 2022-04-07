/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.ui.internal.emf.readonly;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;

import com.google.common.base.Optional;

/**
 * Overriding default EMFReadOnlyHandler
 * 
 * @author Young-Soo Roh
 *
 */
public class EMFReadOnlyHandler extends AbstractReadOnlyHandler {
	public EMFReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	@Override
	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if (axes.contains(ReadOnlyAxis.PERMISSION)) {
			for (URI uri : uris) {
				URI norm = URIConverter.INSTANCE.normalize(uri);
				if (!(norm.isPlatformResource() || norm.isFile())) {
					return Optional.of(Boolean.TRUE);
				}
			}
		}

		return Optional.absent();
	}

	@Override
	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		return Optional.absent(); // We cannot change the read-only status
	}
}
