package com.zeligsoft.domain.sca.datasoft.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;

public class TestDataSoft extends TestCase {

	public void testResourceLog() {
		
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/parseResourceLog.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("modelFile", "xml/ResourceUsageExample.xml");
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();		
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
		
	}
	
	public void testCCCC() {
		
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/parseCCCCProject.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("modelFile", "xml/cccc.xml");
		properties.put("src-gen", "src-gen");
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();		
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
		
	}
	
	public void testPDML() {
		
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/parsePDML.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("modelFile", "xml/DataFlowExample.xml");
		properties.put("src-gen", "src-gen");
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		externalSlotContents.put("modelElement", this);
		externalSlotContents.put("additionalModelElement", null);
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
		
	}
	
	public void testPDML_port() {
		
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/parsePDML.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("modelFile", "xml/DataFlowExample.xml");
		properties.put("src-gen", "src-gen");
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		Component comp = UMLFactory.eINSTANCE.createComponent();
		comp.setName("fm-demod1");
		Port p = comp.createOwnedPort("dataIn", null);
		externalSlotContents.put("modelElement", p);
		externalSlotContents.put("additionalModelElement", null);
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
		
	}
	
	public void testPDML_component() {
		
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/parsePDML.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("modelFile", "xml/DataFlowExample.xml");
		properties.put("src-gen", "src-gen");
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		Component comp = UMLFactory.eINSTANCE.createComponent();
		comp.setName("Demodulator");
		Property prop = UMLFactory.eINSTANCE.createProperty();
		prop.setName("fm-demod1");
		prop.setType(comp);
		externalSlotContents.put("modelElement", prop);
		externalSlotContents.put("additionalModelElement", null);
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
		
	}
	
	public void testPDML_port_and_component() {
	
		Map<String, String> properties = new HashMap<String, String>();
		String defaultFlow = "workflow/parsePDML.oaw";
		WorkflowRunner workflow = new WorkflowRunner();
		Issues issues = new IssuesImpl();
		
		properties.put("modelFile", "xml/DataFlowExample.xml");
		properties.put("src-gen", "src-gen");
		
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		Component comp = UMLFactory.eINSTANCE.createComponent();
		comp.setName("Demodulator");
		Property prop = UMLFactory.eINSTANCE.createProperty();
		prop.setName("fm-demod1");
		prop.setType(comp);
		Port p = comp.createOwnedPort("dataIn", null);
		externalSlotContents.put("modelElement", p);
		externalSlotContents.put("additionalModelElement", prop);
			
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK);
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0);
		
	}
}
