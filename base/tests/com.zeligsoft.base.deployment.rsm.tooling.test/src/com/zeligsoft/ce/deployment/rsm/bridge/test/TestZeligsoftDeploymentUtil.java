package com.zeligsoft.ce.deployment.rsm.bridge.test;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;

public class TestZeligsoftDeploymentUtil extends TestCase {

	private Model model = null;
	private Profile profile = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		setUpModel();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	private void setUpModel() {
		model = UMLFactory.eINSTANCE.createModel();
        model.setName("Test Model");
		assertNotNull(model);
		model.createPackagedElement("Container", UMLPackage.Literals.COMPONENT);
		Component container = (Component)model.getPackagedElement("Container");			
		model.createPackagedElement("rtos", UMLPackage.Literals.COMPONENT);
		Component rtos = (Component)model.getPackagedElement("rtos");
		model.createPackagedElement("subcomponent", UMLPackage.Literals.COMPONENT);
		Component subcomponent = (Component)model.getPackagedElement("subcomponent");
		container.createOwnedAttribute("subcomponent1", subcomponent);
		container.createOwnedAttribute("subcomponent2", subcomponent);			
		model.createPackagedElement("subsubcomponent", UMLPackage.Literals.COMPONENT);
		Component subsubcomponent = (Component)model.getPackagedElement("subsubcomponent");
		subcomponent.createOwnedAttribute("subsubcomponent1", subsubcomponent);
		subcomponent.createOwnedConnector("connector1");
		model.createPackagedElement("thread", UMLPackage.Literals.COMPONENT);			
		Component thread = (Component)model.getPackagedElement("thread");
		rtos.createOwnedAttribute("thread1", thread);
		rtos.createOwnedAttribute("thread2", thread);
		rtos.createOwnedConnector("rtos bus");
			
		profile = ZDeploymentUtil.getProfile();
		model.applyProfile(profile);
	}
	
	public void testGetDeploymentsForModel()
	{
		ZDeploymentUtil.createDeployment(model, "aDeployment");		
		assertEquals(1, ZDeploymentUtil.getDeploymentsForModel(model).size());
		ZDeploymentUtil.createDeployment(model, "additionalDeployment");
		ZDeploymentUtil.createDeployment(model, "third");
		ZDeploymentUtil.createDeployment(model, "fourth");
		assertEquals(4, ZDeploymentUtil.getDeploymentsForModel(model).size());
		for( Object obj : ZDeploymentUtil.getDeploymentsForModel(model))
		{
			assertTrue(obj instanceof Component );
			Component comp = (Component)obj;
			assertNotNull(comp.getAppliedStereotype(ZDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME));			
		}
	}
	
	public void testBuildDeploymentSubstructureBasedOnComponent()
	{
		fail();
	}
	
	public void testSynchronizeDeploymentParts()
	{
		fail();
	}
	
	public void testGetModelElement() throws Exception {
		fail();
	}
	
	public void testGetModelComponent() throws Exception {
		fail();
	}
	
	public void testCreateDeployment() throws Exception {
		ZDeploymentUtil.createDeployment(model, "aDeployment");		
		assertEquals(1, ZDeploymentUtil.getDeploymentsForModel(model).size());
	}
	
	public void testCreateDeploymentPart() throws Exception 
	{
		testCreateDeployment(); // implicitly create the deployment we will use. 
		
		Component modelElement = (Component)model.getPackagedElement("Container");
		Component deployment = (Component)model.getPackagedElement("aDeployment");
		
		Property deploymentPart = ZDeploymentUtil.createDeploymentPart(deployment, modelElement, null);
		
		assertNull(ZDeploymentUtil.getConfiguration(deploymentPart));
		// TODO test something
	}
	

	protected static void testComponent(Component deployment, Component component)
	{	
		assertNotNull(deployment.getAppliedStereotype(ZDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME));
		assertNull(component.getAppliedStereotype(ZDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME));
		
		Property prop = (Property)ZDeploymentUtil.getDeploymentPartForModelElement(deployment, component);		
		assertNotNull(prop);
		assertNull(ZDeploymentUtil.getParentPart(prop));
		
		Stereotype stereotype = prop.getAppliedStereotype(ZDeploymentUtil.QUALIFIED_DEPLOYMENTPART_STEREOTYPE_NAME);
		assertEquals(component, prop.getValue(stereotype, ZDeploymentUtil.DEPLOYMENTPART__MODEL_ELEMENT));

		testDeploymentComponentPart(deployment, prop);		
	}
	
	protected static void testDeploymentComponentPart(Component deployment, Property deploymentPart)
	{
		assertNotNull(deployment.getAppliedStereotype(ZDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME));
		
		Component component = (Component)deploymentPart.getType();
		
		// make sure each non-deployment part of the component has a deployment part nestedPart in the deployment part.
		int partsTested = 0;
		for( Iterator<Property> partIterator = component.getOwnedAttributes().iterator(); partIterator.hasNext(); )
		{
			Property part = partIterator.next();
		
			if( part.getType() instanceof Component )
			{
				partsTested++;
				Property foundDeploymentPart = null;
				for( Property deploymentPartChild : ZDeploymentUtil.getDeploymentChildren(deploymentPart))
				{				
					if( ZDeploymentUtil.getModelElement(deploymentPartChild) == part )
					{
						foundDeploymentPart = deploymentPartChild;
					}
				}
				assertNotNull(foundDeploymentPart);
				assertEquals(ZDeploymentUtil.getParentPart(foundDeploymentPart), deploymentPart);
				testDeploymentComponentPart(deployment, (Property)foundDeploymentPart);
			}
		}
		for( Iterator<Connector> partIterator = component.getOwnedConnectors().iterator(); partIterator.hasNext(); )
		{
			Connector part = partIterator.next();
			
			partsTested++;
			boolean found = false;
			for( Property deploymentPartChild : ZDeploymentUtil.getDeploymentChildren(deploymentPart))
			{			
				if( ZDeploymentUtil.getModelElement(deploymentPartChild) == part )
				{
					found = true;
				}
			}
			assertTrue(found);
		}
		
		// make sure there are no extra nestedPart in prop
		assertEquals(partsTested, ZDeploymentUtil.getDeploymentChildren(deploymentPart).size());
	}
	
}
