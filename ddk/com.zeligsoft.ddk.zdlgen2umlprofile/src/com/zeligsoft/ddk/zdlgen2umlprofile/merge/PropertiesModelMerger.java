/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.merge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.zeligsoft.base.toolingmodel.PropertiesObject;
import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.PropertySheet;
import com.zeligsoft.base.toolingmodel.PropertySource;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;
import com.zeligsoft.base.toolingmodel.util.ToolingModelSwitch;
import com.zeligsoft.base.util.ModelMerger;

/**
 * 
 * Merger for the properties model.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class PropertiesModelMerger extends ModelMerger<PropertiesObject, Object> {

	private static final Set<EReference> EXTERNAL_REFERENCES = 
		new HashSet<EReference>();
	
	private static final Set<EReference> MERGEABLE_EXTERNAL_REFERENCES = 
		new HashSet<EReference>();
	
	private static final Set<EStructuralFeature> MERGEABLE_FEATURES = 
		new HashSet<EStructuralFeature>();
	
	static {
		// no references outside the tooling model
		
		// ... and tooling model references
		
		
		// add all of the mergeable external references to the external
		// references
		EXTERNAL_REFERENCES.addAll(MERGEABLE_EXTERNAL_REFERENCES);
		
		// we merge most attributes, except the exclusions, below
		for(Iterator<EObject> iter = ToolingModelPackage.eINSTANCE.eAllContents(); 
			iter.hasNext();) {
			EObject next = iter.next();
			if(next instanceof EAttribute) {
				EAttribute attr = (EAttribute) next;
				if(!attr.isDerived() && attr.isChangeable()){
					MERGEABLE_FEATURES.add(attr);
				}
			}
		}
		
		MERGEABLE_FEATURES.remove(ToolingModelPackage.Literals.NAMED_ELEMENT__NAME);
		MERGEABLE_FEATURES.remove(ToolingModelPackage.Literals.PROPERTY_SOURCE__CONCEPT_NAME);
		
		MERGEABLE_FEATURES.addAll(MERGEABLE_EXTERNAL_REFERENCES);
	}
	
	@Override
	protected com.zeligsoft.base.util.ModelMerger.IKeyExtractor<PropertiesObject, Object> createKeyExtractor() {
		return PropertiesModelExtractor.INSTANCE;
	}
	
	@Override
	protected com.zeligsoft.base.util.ModelMerger<PropertiesObject, Object>.CorrespondenceChecker createCorrespondenceChecker() {
		return new PropertiesModelCorrespondenceChecker();
	}
	
	private static class PropertiesModelExtractor extends ToolingModelSwitch<Object>
		implements IKeyExtractor<PropertiesObject, Object> {
		
		static IKeyExtractor<PropertiesObject, Object> INSTANCE =
				new PropertiesModelExtractor();
		
		private PropertiesModelExtractor() {
			// no need to create me by outside I'm stateless
		}
		
		@Override
		public Object getKey(PropertiesObject element) {
			return doSwitch(element);
		}
		
		@Override
		public Object casePropertyDefinition(PropertyDefinition object) {
			return object.getName();
		}
		
		@Override
		public Object casePropertySource(PropertySource object) {
			return object.getConceptName();
		}
	}

	private class PropertiesModelCorrespondenceChecker extends CorrespondenceChecker {
		private ToolingModelSwitch<Boolean> correspondenceSwitch =
			new ToolingModelSwitch<Boolean>() {
			
			@Override
			public Boolean casePropertyDefinition(PropertyDefinition object) {
				return basicCorresponds(object);
			}
			
			@Override
			public Boolean casePropertySource(PropertySource object) {
				return basicCorresponds(object);
			}
			
			@Override
			public Boolean casePropertySheet(PropertySheet object) {
				return Boolean.TRUE;
			}
		};
		
		@Override
		protected boolean corresponds(PropertiesObject object) {
			return correspondenceSwitch.doSwitch(object);
		}
	}
}
