package com.zeligsoft.domain.sca.agilent.importer.test;

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel;
import com.zeligsoft.domain.sca.agilent.importer.test.util.AgilentImporterTestRunner;
import com.zeligsoft.domain.sca.agilent.importer.test.util.AgilentImporterTestUtil;

/**
 * 
 */
public class RuleUnitTests extends TestCase
{
	private ResourceSet rs;
	private Resource TestModel;
	private Resource TargetModel;
	
	private DocumentRoot DocRoot;
	private SystemvueModel Model;
	
	private Model targetContainer;
	
	@Override
	protected void setUp() throws Exception {
		try {
			rs = new ResourceSetImpl();
			TestModel
				= rs.createResource(
					URI.createURI(AgilentImporterTestUtil.getLocalURL("models/test.systemvue").toString(), true));
			TestModel.load(Collections.EMPTY_MAP);
			TargetModel 
				= rs.createResource(
					URI.createURI(AgilentImporterTestUtil.getLocalURL("models/SCATestModel.emx").toString(), true));
			TargetModel.load(Collections.EMPTY_MAP);
			
			DocRoot =
				(DocumentRoot) TestModel.getContents().get(0);
			Model =
				DocRoot.getSystemvueModel();
			
			targetContainer = (Model) TargetModel.getContents().get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testParameterType_XTend()
	{
		assertTrue(true);
		
		Object result
			= AgilentImporterTestRunner.run(
				"com::zeligsoft::domain::sca::agilent::importer::template::systemvueimport::visit",
				targetContainer, Model );
		assertNotNull( result );
	}
}
