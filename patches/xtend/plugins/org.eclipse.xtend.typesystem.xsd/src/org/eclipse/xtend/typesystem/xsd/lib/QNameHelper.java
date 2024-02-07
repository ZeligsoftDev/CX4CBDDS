/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.lib;

import javax.xml.namespace.QName;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class QNameHelper {
	public final static QName createQName(String localPart) {
		return new QName(localPart);
	}

	public final static QName createQName(String namespaceURI, String localPart) {
		return new QName(namespaceURI, localPart);
	}

	public final static QName createQName(String namespaceURI, String localPart,
			String prefix) {
		return new QName(namespaceURI, localPart, prefix);
	}

}
