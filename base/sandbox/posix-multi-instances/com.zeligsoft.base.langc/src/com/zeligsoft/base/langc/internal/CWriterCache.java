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
package com.zeligsoft.base.langc.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.m2t.CWriter;

public class CWriterCache {
	private final IProject project;
	private final Map<FileName, CWriter> writers = new HashMap<FileName, CWriter>();

	public CWriterCache( IProject project ) {
		this.project = project;
	}

	public CWriter writerFor( FileName filename ) {
		CWriter writer = writers.get( filename );
		if( writer == null ) {
			writer = CWriter.createProvisional( this.project, filename );
			writers.put( filename, writer );
		}
		return writer;
	}
}
