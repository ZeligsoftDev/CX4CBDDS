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
package com.zeligsoft.base.oaw.test;

import java.util.LinkedList;
import java.util.List;


import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import com.zeligsoft.base.zdl.oaw.ZDLMetamodel;

public class OawWorkflowComponent extends XtendComponent {

	private Iterable<String> parseStringList( String list ) {
		List<String> values = new LinkedList<String>();
		for( int l = 0, n = 0; n >= 0; l = n + 1 ) {
			n = list.indexOf( ',', l );
			String value
				= n < 0
					? list.substring( l )
					: list.substring( l, n );
			value = value.trim();
			if( ! value.isEmpty() )
				values.add( value );
		}

		return values;
	}

	public void setZdlMMZdlUris( String models ) {
		for( String model : parseStringList( models ) ) {
			ZDLMetamodel mm = new ZDLMetamodel();
			mm.setZdl( model );
			addMetaModel(mm);
		}
	}

	public void setEmfMMPackages( String models ) {
		for( String model : parseStringList( models ) ) {
			EmfMetaModel mm = new EmfMetaModel();
			mm.setMetaModelPackage( model );
			addMetaModel(mm);
		}
	}
}
