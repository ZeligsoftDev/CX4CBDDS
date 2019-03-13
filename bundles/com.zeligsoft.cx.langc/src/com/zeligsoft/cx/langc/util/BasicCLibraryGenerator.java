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
package com.zeligsoft.cx.langc.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.zeligsoft.cx.langc.BuiltInType;
import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.PrimitiveType;

/**
 * A utility class to generate the basic C model library. 
 */
@SuppressWarnings("nls")
public final class BasicCLibraryGenerator {

	private BasicCLibraryGenerator() { /*empty */ }

	public static void main( String[] args ) {

		if( args.length <= 0 )
		{
			System.out.println( "Usage: M2TGenerator <target-filename>" );
			return;
		}

		String filename = args[0];

		URI uri = URI.createFileURI( filename );
		Resource res = new XMIResourceImpl(uri);

		res.getContents().add(createBuiltIn(PrimitiveType.INT32));
		res.getContents().add(createBuiltIn(PrimitiveType.CHAR));
		res.getContents().add(createBuiltIn(PrimitiveType.VOID));

		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println( "Model library generated to " + filename );
	}

	private static BuiltInType createBuiltIn( PrimitiveType primitiveType ) {
		BuiltInType builtIn = LangCFactory.eINSTANCE.createBuiltInType();
		builtIn.setType(primitiveType);
		return builtIn;
	}
}
