package com.zeligsoft.codegeneration.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.uml2.uml.Model;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;

import com.zeligsoft.ce.codegeneration.transformregistry.TransformRegistry;

/**
 * To test TransformRegistry API for code generation
 * @author Laura Li
 *
 */
public class TestCodegen extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		
	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testRunWorkflow() throws Exception {
		Map<String, String> properties = new HashMap<String, String>();
		String MODEL_URI_STRING = "modelURI";
		String SRC_GEN = "src-gen";
		String defaultFlow = "workflows/zeligsoft.oaw";
		Model m = CreateUMLModel.createModel("Laura");
		
		String result = TransformRegistry.INSTANCE.getTransformObjects(m);
		
		assertEquals(defaultFlow, result);
		
		properties.put(MODEL_URI_STRING, "model/Test.emx");
		properties.put(SRC_GEN, "codegen");
					
		new WorkflowRunner().run(result,
				new NullProgressMonitor(), properties, Collections.EMPTY_MAP);

		
	}
	
	public void testCreateUMLModel() throws Exception {
		
		Model  m = CreateUMLModel.createModel("Sample");
		
		assertNotNull(m);
		
	}
	
	public void testPluginRegistry() throws Exception 
	{
		String EXT_ROOT_NODE_NAME = "com.zeligsoft.ce.codegeneration.ui.EObjectTransformationArtifacts";
		String UNIQUE_ID = "test.EObjectTransformationArtifacts";
		String DEFAULT_ENTRY = "org.eclipse.uml2.uml.Model";
		String DEFAULT_ARTIFACT = "workflows/zeligsoft.oaw";
			
		IExtension extension = Platform.getExtensionRegistry().getExtensionPoint(EXT_ROOT_NODE_NAME).getExtension(UNIQUE_ID);
		
		IConfigurationElement[] entry = extension.getConfigurationElements();
		
		IConfigurationElement[] artifact = entry[0].getChildren();
		
		assertEquals(DEFAULT_ENTRY, entry[0].getAttribute("type"));
		assertEquals(DEFAULT_ARTIFACT, artifact[0].getAttribute("path"));
		
	}
}
