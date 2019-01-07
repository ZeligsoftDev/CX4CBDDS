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

package com.zeligsoft.base.zml.codegeneration.xtend.utils;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.openarchitectureware.xpand2.output.FileHandle;
import org.openarchitectureware.xpand2.output.PostProcessor;

public class FormatterDispatcher
		implements PostProcessor {

	// for generated C code
	private static final String HEADER_EXT = "h"; //$NON-NLS-1$
	private static final String C_EXT = "c"; //$NON-NLS-1$
	private static final String CPP_EXT = "cpp"; //$NON-NLS-1$	

	// for generated Makefiles
	private static final String MAKE_FRAGMENT_EXT = "mk"; //$NON-NLS-1$
	private static final String MAKEFILE = "makefile"; //$NON-NLS-1$
	private static final String DEPENDENCY_EXT = "dep"; //$NON-NLS-1$
	
	public void afterClose(FileHandle file) {
	}	
	
	public void beforeWriteAndClose(FileHandle file) {
		
		if (file.getTargetFile() == null)
			return;

		IPath path = new Path(file.getTargetFile().getAbsolutePath());

		if ( HEADER_EXT.equals(path.getFileExtension())
			|| C_EXT.equals(path.getFileExtension())
			|| CPP_EXT.equals(path.getFileExtension())) {
			OutputFormatter.formatCFile( file );
			
		} else if ( MAKE_FRAGMENT_EXT.equals(path.getFileExtension())
				|| MAKEFILE.equals(path.lastSegment().toLowerCase())
				|| DEPENDENCY_EXT.equals(path.getFileExtension())) {
			OutputFormatter.formatMakefile( file );
		}
	}
}	
	
	
