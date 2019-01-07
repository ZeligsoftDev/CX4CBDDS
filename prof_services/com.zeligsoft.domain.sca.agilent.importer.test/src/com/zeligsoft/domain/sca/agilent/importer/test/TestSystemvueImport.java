package com.zeligsoft.domain.sca.agilent.importer.test;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;


public class TestSystemvueImport extends TestCase {
	
	/**
	 * The suite of tests owned by this test case.
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(TestSystemvueImport.class, "Systemvue Import");
	}
	 
	@SuppressWarnings("unchecked")
	public void testImport() {
	
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/systemvueImport.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("sourceModel", "models/SCATestModel.emx");		
		properties.put("modelFile", "models/CIC_Filter_CG.xml");
		
		HashMap externalSlotContents = new HashMap<String, Object>();
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
	}
	
	@SuppressWarnings("unchecked")
	public void testImport2() {
	
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/systemvueImport.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("sourceModel", "models/SCATestModel.emx");		
		properties.put("modelFile", "models/QPSK_Tx_Rx.xml");
		
		HashMap externalSlotContents = new HashMap<String, Object>();
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
	}

}
