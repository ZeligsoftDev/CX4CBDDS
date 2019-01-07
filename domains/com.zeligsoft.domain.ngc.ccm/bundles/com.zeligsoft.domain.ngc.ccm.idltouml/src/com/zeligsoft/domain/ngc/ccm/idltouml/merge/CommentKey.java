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
package com.zeligsoft.domain.ngc.ccm.idltouml.merge;

import org.eclipse.uml2.uml.Comment;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * A key implementaiton appropriate to {@link Comment}s.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
class CommentKey extends AbstractHierarchicalKey<CommentKey> {

	private String body;

	/**
	 * Initializes me with my comment element.
	 * 
	 * @param element
	 *            the comment
	 */
	public CommentKey(Comment element) {
		super(element);

		String body = element.getBody();

		this.body = (body == null) ? "<comment>" : Integer.toString(body.hashCode(), 64); //$NON-NLS-1$
	}

	@Override
	protected boolean keyEquals(CommentKey other) {
		return body.equals(other.body);
	}

	@Override
	protected int keyHash() {
		return body.hashCode();
	}

}
