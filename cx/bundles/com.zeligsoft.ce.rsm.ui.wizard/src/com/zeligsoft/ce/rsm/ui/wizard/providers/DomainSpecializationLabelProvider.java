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

package com.zeligsoft.ce.rsm.ui.wizard.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import com.zeligsoft.ce.domainregistration.DomainSpecialization;

/**
 * 
 *  
 * @author jcorchis
 *
 */
public class DomainSpecializationLabelProvider extends LabelProvider implements	ITableLabelProvider 
{

	public Image getColumnImage(Object element, int columnIndex)
	{
		return null;
	}

	public String getColumnText(Object element, int columnIndex) 
	{	
		if (element instanceof DomainSpecialization)
		{
			DomainSpecialization domainInfo = (DomainSpecialization) element;
			switch (columnIndex) 
			{
				case 0:
					return domainInfo.getName();
				case 1:
					return domainInfo.getDescription();
				case 2:
					return domainInfo.getContributor();
				default:
					return "";//$NON-NLS-1$
			}
		}
		if (element == null)
			return "<null>";//$NON-NLS-1$
		try 
		{
			return element.toString();
		} 
		catch (Exception e) 
		{
			return e.toString();
		}
	}
}
