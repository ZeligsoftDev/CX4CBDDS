package com.zeligsoft.domain.idl3plus.idlimport;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.idlimport.IDL3ReaderComponent;

public class IDL3PlusReaderComponent extends IDL3ReaderComponent {

	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		if( issues.getErrors().length > 0) {
			return;
		}
		
		addImportedPackage(issues, (Package)ctx.get(getModelSlot()));
		
		prune((Package)ctx.get(getModelSlot()));
		
	}
	
	void prune(Package pkg) {
		
		Object[] packagedElements = pkg.getPackagedElements().toArray();
		for( Object pe : packagedElements) {
			if( pe instanceof Package ) {
				prune((Package)pe);
			}
		}
		
		if( pkg.getPackagedElements().size() == 0) {
			if( ZDLUtil.isZDLConcept(pkg, IDL3PlusNames.MODULE_INSTANTIATION) == false 
				&& ZDLUtil.isZDLConcept(pkg, IDL3PlusNames.TEMPLATE_MODULE) == false) {
				pkg.destroy();
			}
		}
	}
	
}
