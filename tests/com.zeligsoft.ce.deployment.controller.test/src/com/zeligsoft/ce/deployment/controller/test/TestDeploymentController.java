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
package com.zeligsoft.ce.deployment.controller.test;

import junit.framework.TestCase;

import com.zeligsoft.ce.deployment.controller.DeploymentController;

/**
 * Test class for Deployment Controllers
 * 
 * @author smcfee
 *
 */
public abstract class TestDeploymentController extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	protected abstract DeploymentController getController();	
	
	

//
//	/**
//	 * Test that makes sure when we create a component part for a component in a deployment, the
//	 * appropriate deployment parts are also created.
//	 * 
//	 * Makes use of domain-specific editing domains so implemented by sub-class.
//	 * 
//	 * @throws Exception
//	 */
//	abstract public void testCreateComponentPart() throws Exception;
//		
//	/**
//	 * Test that when a component in use in a deployment is removed, its corresponding parts in a 
//	 * deployment are also removed.
//	 * 
//	 * Makes use of domain-specific editing domains so implemented by sub-class.
//	 * 
//	 * @throws Exception
//	 */
//	abstract public void testRemoveComponent() throws Exception;
//	
//	/**
//	 * Test that removing a part from a component will remove any corresponding parts from a 
//	 * deployment.
//	 * 
//	 * Makes use of domain-specific editing domains so implemented by sub-class.
//	 *  
//	 * @throws Exception
//	 */
//	abstract public void testRemoveComponentPart() throws Exception;
//	
//	/**
//	 * Test that renaming a component will rename any deployment parts that point to it.
//	 * 
//	 * Makes use of domain-specific editing domains so implemented by sub-class.
//	 * 
//	 * @throws Exception
//	 */
//	abstract public void testRenameComponent() throws Exception;
//	
//	/**
//	 * Test that renaming a component part will rename any deployment parts that point to it.
//	 * 
//	 * Makes use of domain-specific editing domains so implemented by sub-class.
//	 * 
//	 * @throws Exception
//	 */
//	abstract public void testRenameComponentPart() throws Exception;
//	
//	public void testSaveAndLoadDeployment() throws Exception
//	{
//		Deployment deployment = getController().getDeployment();
//		URI fileURI = URI.createFileURI("C:\\junit-test.cetable2");
//		
//		int deploymentPartCount = deployment.getDeploymentParts().size();
//		int allocationCount = deployment.getAllocation().size();
//		
//				
//		getController().setFileURI(fileURI);		
//		getController().save();
//		deployment = null;
//		getController().load();
//		deployment = getController().getDeployment();		
//		
//		assertNotNull(deployment);
//		assertEquals(deploymentPartCount, deployment.getDeploymentParts().size());
//		assertEquals(allocationCount, deployment.getAllocation().size());
//		
//	}
	
}
