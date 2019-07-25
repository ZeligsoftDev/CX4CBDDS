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
package com.zeligsoft.domain.omg.ccm.descriptorgenerator.utils;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xtend.typesystem.xsd.XMLBeautifier;
import org.eclipse.xtend.typesystem.xsd.XMLMixedContentFormatter;

public class DescriptorBeautifier extends XMLBeautifier {

	private final String [] separators = {"implementation", "instance", "connection", "artifact", "localityConstraint"};
	
	public DescriptorBeautifier() {
		fileExtensions = new String[] { ".xml", ".xsl", ".xsd",
				".wsdd", ".wsdl", ".cdd", ".cdp" };
		this.setMaxLineWidth(500);
	}
	
	@Override
	public void beforeWriteAndClose(FileHandle impl) {
		super.beforeWriteAndClose(impl);
		// we want to place an extra new line between certain element tags
		String buffer = impl.getBuffer().toString();
		buffer = buffer.replace("zcxlt;", "&lt;").replace("zcxgt;", "&gt;")
				.replace("zcxapos;", "&apos;").replace("&#xD;", "")
				.replace("zcxamp;", "&amp;").replace("zcxquot;", "&quot;");
		
		for (String tag : separators){
			String toReplace = "(</" + tag + ">)";
			buffer = buffer.replaceAll(toReplace, "$1\n");	
		}
		
		//Any <string> values that were given new lines because of the line limit
		//should be put back on the same line as the <string> tag with no spaces
		buffer = buffer.replaceAll("<string>\\s*(.*)\\s*</string>", "<string>$1</string>");
		
		impl.setBuffer(buffer);
	}
	
	@Override
	protected XMLMixedContentFormatter createFormatter() {
		return new XMLContentFormatter();
	}
}
