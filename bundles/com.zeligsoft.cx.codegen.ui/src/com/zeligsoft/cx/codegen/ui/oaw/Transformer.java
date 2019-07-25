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
package com.zeligsoft.cx.codegen.ui.oaw;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.XtendComponent;

import com.zeligsoft.cx.codegen.ui.internal.OawUtil;

public class Transformer extends XtendComponent
{
	private boolean invokeValue = false;

	@Override
	public void setInvoke(String invokeExpr) {
		super.setInvoke(invokeExpr);
		this.invokeValue = true;
	}

	@Override
	protected void invokeInternal( WorkflowContext ctx, ProgressMonitor monitor, Issues issues )
	{
		if( this.invokeValue )
			super.invokeInternal(ctx, monitor, issues);
	}

	public void setMetaModelClasses( String metaModels )
	{
		OawUtil.setMetaModelClasses( this, metaModels );
	}

	public void setProfileMetaModels( String profiles )
	{
		OawUtil.setProfileMetaModels( this, profiles );
	}

	public void setEMFMetaModelPackages( String mmPackages )
	{
		OawUtil.setEMFMetaModelPackages( this, mmPackages );
	}

	public void setZDLMetaModels( String zdlMMs )
	{
		OawUtil.setZDLMetaModels( this, zdlMMs );
	}
}
