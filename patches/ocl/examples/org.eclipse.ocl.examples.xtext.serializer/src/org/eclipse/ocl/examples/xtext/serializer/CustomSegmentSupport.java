/**
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.xtext.serializer;

import org.eclipse.jdt.annotation.NonNull;

/**
 * CustomSegmentSupport defines the interface that a user-defined class must implement
 * to contribute custom strings to the overall output.
 */
public interface CustomSegmentSupport
{
	void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder);

	void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder);
}
