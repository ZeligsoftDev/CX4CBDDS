package com.zeligsoft.domain.omg.corba.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.junit.Test;

public class IDLImportTest {

	@Test
	public void testIDL()
	{
		generate();
	}
	
	private void generate()
	{
		
		Map<String, String> properties = new HashMap<String, String>();
		WorkflowEngine workflow = new WorkflowEngine();
		Issues issues = new IssuesImpl();
		

		String defaultFlow = "workflow/idlimport.oaw"; //$NON-NLS-1$
		
		properties.put("modelFile", "/model/CF.idl"); //$NON-NLS-1$ //$NON-NLS-2$
		properties.put("sourceModel", "model/Source.emx"); //$NON-NLS-1$ //$NON-NLS-2$
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
					
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK); //$NON-NLS-1$
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0); //$NON-NLS-1$
		
	}
}
