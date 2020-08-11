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
package com.zeligsoft.ddk.zdl.zdlgen.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;

/**
 * @author prismtech
 *
 */
public class ZDLGenUtil {

	public static Collection<GenDomainSpecialization> getSpecializations(
			final List<GenDomainPackageableElement> elements) {
		Collection<GenDomainPackageableElement> specializations = 
				Collections2.filter(elements, Predicates.instanceOf(GenDomainSpecialization.class));
		final Function<GenDomainPackageableElement, GenDomainSpecialization> function = 
				new Function<GenDomainPackageableElement, GenDomainSpecialization>() {
					@Override
					public GenDomainSpecialization apply(GenDomainPackageableElement element) {
						if(element instanceof GenDomainSpecialization) {
							return (GenDomainSpecialization) element;
						} else {
							return null;
						}
					}
				};
		
		return Collections2.transform(specializations, function);
	}

	public static Set<String> targetsUsedInModel(GenDomainObject genDomainObject) {
		final Set<String> result = Sets.newHashSet();
		
		GenModel root = null; 
		if(genDomainObject instanceof GenModel) {
			root = (GenModel) genDomainObject;
		} else {
			root = genDomainObject.getGenModel();
		}
		
		if(root != null) {
			for(GenDomainModel domainModel : root.getDomainModels()) {
				final Collection<GenDomainSpecialization> specializations =
						getSpecializations(domainModel.getElements());
				for(GenDomainSpecialization specialization : specializations) {
					final String target = specialization.getCodeGenTarget();
					
					if(!Strings.isNullOrEmpty(target)) {
						result.add(target);
					}
				}
			}
		}
		
		return result;
	}

}
