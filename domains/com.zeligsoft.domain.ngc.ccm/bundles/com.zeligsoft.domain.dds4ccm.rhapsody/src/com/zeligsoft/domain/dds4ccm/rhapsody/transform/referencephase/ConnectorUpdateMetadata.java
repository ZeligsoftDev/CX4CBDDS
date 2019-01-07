/**
 * Copyright 2018 ADLINK Technology Limited.
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
package com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase;

import org.eclipse.uml2.uml.ConnectorEnd;

public final class ConnectorUpdateMetadata {
	private final ConnectorEnd sourceEnd;
	private final String sourceRole;
	private final String sourcePartWithPort;
	private final ConnectorEnd targetEnd;
	private final String targetRole;
	private final String targetPartWithPort;

	public ConnectorUpdateMetadata(ConnectorEnd sourceEnd, String sourceRole,
			String sourcePartWithPort, ConnectorEnd targetEnd,
			String targetRole, String targetPartWithPort) {
		this.sourceEnd = sourceEnd;
		this.sourceRole = sourceRole;
		this.sourcePartWithPort = sourcePartWithPort;
		this.targetEnd = targetEnd;
		this.targetRole = targetRole;
		this.targetPartWithPort = targetPartWithPort;		
	}

	public ConnectorEnd getSourceEnd() {
		return sourceEnd;
	}

	public String getSourceRole() {
		return sourceRole;
	}

	public String getSourcePartWithPort() {
		return sourcePartWithPort;
	}

	public ConnectorEnd getTargetEnd() {
		return targetEnd;
	}

	public String getTargetRole() {
		return targetRole;
	}

	public String getTargetPartWithPort() {
		return targetPartWithPort;
	}
}
