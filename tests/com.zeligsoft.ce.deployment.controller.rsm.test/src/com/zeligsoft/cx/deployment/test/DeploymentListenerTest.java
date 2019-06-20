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

package com.zeligsoft.cx.deployment.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.commands.AddModelElementCommand;
import com.zeligsoft.cx.deployment.ui.commands.CreateAllocationCommand;
import com.zeligsoft.cx.deployment.ui.commands.DeleteAllocationCommand;
import com.zeligsoft.cx.deployment.ui.commands.ReallocateCommand;
import com.zeligsoft.cx.deployment.ui.listeners.DeploymentEMFNotificationBroker;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * JUnits for the RSM deployment controller.
 * 
 * @author smcfee
 * 
 */
@SuppressWarnings("nls")
public class DeploymentListenerTest {

	private Package model = null;

	private Component deployment = null;

	Resource modelResource = null;
	
	ResourceSet rset = null;

	private TransactionalEditingDomain domain = null;

	@Before
	public void setUp()
			throws Exception {
		model = null;
		deployment = null;
		model = getModel();
		deployment = (Component) model.getPackagedElement("Deployment");
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(deployment);
	}

	@After
	public void tearDown()
			throws Exception {
		
		DeploymentEMFNotificationBroker.getInstance().removeDeploymentListeners((Model)model);
		
		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;	
		
	}

	private Package getModel()
			throws Exception {
		
		Resource res = null;
		if (model == null) {
			
			
			rset = new ResourceSetImpl();
			res = rset.getResource(URI.createPlatformPluginURI(
					"com.zeligsoft.cx.deployment.test" + "/model/testModel.emx", true), true);
				assertTrue("Test resource not loaded", res.isLoaded());

			model = (Package) EcoreUtil.getObjectByType(res.getContents(),
					UMLPackage.Literals.PACKAGE);
			
			model.createPackagedElement("container",
				UMLPackage.Literals.COMPONENT);
			Component container = (Component) model
				.getPackagedElement("container");
			EcoreUtil.resolveAll(model);
			ZDLUtil.addZDLConcept(container, ZMLMMNames.COMPONENT_INTERFACE);

			model.createPackagedElement("containerRealization",
				UMLPackage.Literals.COMPONENT);
			Component containerRealization = (Component) model
				.getPackagedElement("containerRealization");
			ZDLUtil.addZDLConcept(containerRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION);

			containerRealization.createGeneralization(container);

			model.createPackagedElement("subcomponent",
				UMLPackage.Literals.COMPONENT);
			Component subcomponent = (Component) model
				.getPackagedElement("subcomponent");
			ZDLUtil.addZDLConcept(subcomponent, ZMLMMNames.COMPONENT_INTERFACE);

			model.createPackagedElement("subcomponentRealization",
				UMLPackage.Literals.COMPONENT);
			Component subcomponentRealization = (Component) model
				.getPackagedElement("subcomponentRealization");
			ZDLUtil.addZDLConcept(subcomponentRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION);

			subcomponentRealization.createGeneralization(subcomponent);

			containerRealization.createOwnedAttribute("subcomponent1",
				subcomponent);
			containerRealization.createOwnedAttribute("subcomponent2",
				subcomponent);

			model.createPackagedElement("subsubcomponent",
				UMLPackage.Literals.COMPONENT);
			Component subsubcomponent = (Component) model
				.getPackagedElement("subsubcomponent");
			ZDLUtil.addZDLConcept(subsubcomponent,
				ZMLMMNames.COMPONENT_INTERFACE);

			model.createPackagedElement("subsubcomponentRealization",
				UMLPackage.Literals.COMPONENT);
			Component subsubcomponentRealization = (Component) model
				.getPackagedElement("subsubcomponentRealization");
			ZDLUtil.addZDLConcept(subsubcomponentRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION);

			subsubcomponentRealization.createGeneralization(subsubcomponent);

			subcomponentRealization.createOwnedAttribute("subsubcomponent1",
				subsubcomponent);
			subcomponentRealization.createOwnedConnector("connector1");

			model.createPackagedElement("rtos", UMLPackage.Literals.COMPONENT);
			Component rtos = (Component) model.getPackagedElement("rtos");

			model
				.createPackagedElement("thread", UMLPackage.Literals.COMPONENT);
			Component thread = (Component) model.getPackagedElement("thread");

			rtos.createOwnedAttribute("thread1", thread);
			rtos.createOwnedAttribute("thread2", thread);
			rtos.createOwnedConnector("rtos bus");
			
			domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
			
			AbstractTransactionalCommand createDeploymentCommand = new AbstractTransactionalCommand(
				domain, "Create Deployment", Collections.EMPTY_MAP, null) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					ZDeploymentUtil.createDeployment(model, "Deployment");
					return CommandResult.newOKCommandResult();
				}
			};

			OperationHistoryFactory.getOperationHistory().execute(
				createDeploymentCommand, null, null);			
		}
		
		DeploymentEMFNotificationBroker.getInstance().addDeploymentListeners((Model)model);
		
		return model;
	}

	/**
	 * Helper function that adds Container, subcomponent, subsubcomponent, rtos,
	 * and thread to the default deployment.
	 */
	private void addDefaultElementsToDeployment()
			throws Exception {
		
		assertNotNull(deployment);
		assertEquals(0, ZDeploymentUtil.getDeploymentParts(deployment).size());

		Component container = (Component) model.getPackagedElement("container");
		OperationHistoryFactory.getOperationHistory().execute(
			new AddModelElementCommand(deployment, container, null, null,
				"Add Component"), null, null);
		assertEquals(7, ZDeploymentUtil.getDeploymentParts(deployment).size());

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		OperationHistoryFactory.getOperationHistory().execute(
			new AddModelElementCommand(deployment, subcomponent, null, null,
				"Add Component"), null, null);
		assertEquals(10, ZDeploymentUtil.getDeploymentParts(deployment).size());

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		OperationHistoryFactory.getOperationHistory().execute(
			new AddModelElementCommand(deployment, subsubcomponent, null, null,
				"Add Component"), null, null);
		assertEquals(11, ZDeploymentUtil.getDeploymentParts(deployment).size());

		Component rtos = (Component) model.getPackagedElement("rtos");
		OperationHistoryFactory.getOperationHistory().execute(
			new AddModelElementCommand(deployment, rtos, null, null,
				"Add Component"), null, null);
		assertEquals(15, ZDeploymentUtil.getDeploymentParts(deployment).size());

		Component thread = (Component) model.getPackagedElement("thread");
		OperationHistoryFactory.getOperationHistory().execute(
			new AddModelElementCommand(deployment, thread, null, null,
				"Add Component"), null, null);
		assertEquals(16, ZDeploymentUtil.getDeploymentParts(deployment).size());

	}

	@SuppressWarnings("unused")
	private void printDeployment(Component deployment, String label) {
		Collection<Property> deploymentParts = ZDeploymentUtil
			.getDeploymentParts(deployment);
		System.out.println(label + ", deploymentPartCount = "
			+ deploymentParts.size());

		for (Property deploymentPart : deploymentParts)
			System.out.print(deploymentPart.getName() + "\t");

		System.out.println(" ");
	}

	@SuppressWarnings("unused")
	private void printDeploymentVerbosely(Component deployment, String label) {
		Collection<Property> deploymentParts = ZDeploymentUtil
			.getDeploymentParts(deployment);
		System.out.println(label + ", deploymentPartCount = "
			+ deploymentParts.size());

		for (Property deploymentPart : deploymentParts)
			System.out.println(deploymentPart.getName() + "\tmodelElement = "
				+ ZDeploymentUtil.getModelElement(deploymentPart)
				+ "\tmodelComponent = "
				+ ZDeploymentUtil.getModelComponent(deploymentPart));

		System.out.println(" ");
	}

	/**
	 * Test for deployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeployComponent()
			throws Exception {

		assertNotNull(deployment);

		addDefaultElementsToDeployment();

		Property sourcePart = null;
		Property targetPart = null;
		int deploymentCount = ZDeploymentUtil.getAllocations(deployment).size();
		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertTrue(deploymentPartCount > 0);

		int index;
		Random generator = new Random();
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			sourcePart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (!(ZDeploymentUtil.getModelElement(sourcePart) instanceof Component));
		assertNotNull(sourcePart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(sourcePart));
		assertNotNull(ZDeploymentUtil.getModelElement(sourcePart));

		// If the part is not yet deployed this will be null.
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			targetPart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (sourcePart == targetPart);

		assertNotNull(targetPart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(targetPart));
		assertNotNull(ZDeploymentUtil.getModelElement(targetPart));

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);

		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size()
			- deploymentCount);
		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(ZDeploymentUtil.getDeploymentTargetPart(sourcePart),
			targetPart);
	
	}

	/**
	 * Test for deployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeployComponentPart()
			throws Exception {

		assertNotNull(deployment);

		addDefaultElementsToDeployment();

		Property sourcePart = null;
		Property targetPart = null;
		int deploymentCount = ZDeploymentUtil.getAllocations(deployment).size();
		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertTrue(deploymentPartCount > 0);

		int index;
		Random generator = new Random();
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			sourcePart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (!(ZDeploymentUtil.getModelElement(sourcePart) instanceof Property));
		assertNotNull(sourcePart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(sourcePart));
		assertNotNull(ZDeploymentUtil.getModelElement(sourcePart));
		assertNotNull(ZDeploymentUtil.getModelComponent(sourcePart));

		// If the part is not yet deployed this will be null.
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			targetPart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (sourcePart == targetPart);
		assertNotNull(targetPart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(targetPart));
		assertNotNull(ZDeploymentUtil.getModelElement(targetPart));

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);

		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size()
			- deploymentCount);
		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(ZDeploymentUtil.getDeploymentTargetPart(sourcePart),
			targetPart);
		
	}

	/**
	 * Test for deployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeployConnectorPart()
			throws Exception {

		assertNotNull(deployment);

		addDefaultElementsToDeployment();

		Property sourcePart = null;
		Property targetPart = null;
		int deploymentCount = ZDeploymentUtil.getAllocations(deployment).size();
		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertTrue(deploymentPartCount > 0);

		int index;
		Random generator = new Random();
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			sourcePart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (!(ZDeploymentUtil.getModelElement(sourcePart) instanceof Connector));
		assertNotNull(sourcePart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(sourcePart));
		assertNotNull(ZDeploymentUtil.getModelElement(sourcePart));

		// If the part is not yet deployed this will be null.
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			targetPart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (sourcePart == targetPart);

		assertNotNull(targetPart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(targetPart));
		assertNotNull(ZDeploymentUtil.getModelElement(targetPart));

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);

		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size()
			- deploymentCount);
		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(ZDeploymentUtil.getDeploymentTargetPart(sourcePart),
			targetPart);
		
	}

	/**
	 * Test for undeployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUndeployment()
			throws Exception {

		assertNotNull(deployment);
		Dependency allocation = null;

		int allocationCount = ZDeploymentUtil.getAllocations(deployment).size();
		// grab the first allocation. If none exists we will first have to
		// create one.
		if (allocationCount == 0) {
			testDeployComponent();
			allocationCount = 1;
		}

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertTrue(deploymentPartCount > 0);

		allocation = (Dependency) ZDeploymentUtil.getAllocations(deployment)
			.toArray()[0];
		Property sourcePart = ZDeploymentUtil
			.getSourcePartForAllocation(allocation);

		DeleteAllocationCommand command = new DeleteAllocationCommand(
			sourcePart, "Undeploy");
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertEquals(allocationCount - 1, ZDeploymentUtil.getAllocations(
			deployment).size());
		assertNull(ZDeploymentUtil.getDeploymentTargetPart(sourcePart));
		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		
	}

	@Test
	public void testRedeployment()
			throws Exception {

		testDeployComponent();

		int allocationCount = ZDeploymentUtil.getAllocations(deployment).size();
		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertTrue(deploymentPartCount > 0);

		Dependency allocation = (Dependency) ZDeploymentUtil.getAllocations(
			deployment).toArray()[0];
		Property sourcePart = ZDeploymentUtil
			.getSourcePartForAllocation(allocation);
		assertNotNull(sourcePart);
		Property targetPart = ZDeploymentUtil
			.getDeploymentTargetPart(sourcePart);
		assertNotNull(targetPart);
		Property newTargetPart = null;

		Random generator = new Random();
		int index = Math.abs(generator.nextInt()
			% ZDeploymentUtil.getDeploymentParts(deployment).size());
		do {
			index = Math.abs(generator.nextInt()
				% ZDeploymentUtil.getDeploymentParts(deployment).size());
			newTargetPart = (Property) ZDeploymentUtil.getDeploymentParts(
				deployment).toArray()[index];
		} while (sourcePart == newTargetPart || targetPart == newTargetPart);

		assertNotNull(newTargetPart);
		assertTrue(ZDeploymentUtil.isDeploymentPart(newTargetPart));
		assertNotNull(ZDeploymentUtil.getModelElement(newTargetPart));

		ReallocateCommand command = new ReallocateCommand(sourcePart,
			newTargetPart, "Redeploy");
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertEquals(allocationCount, ZDeploymentUtil
			.getAllocations(deployment).size());
		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(ZDeploymentUtil.getDeploymentTargetPart(sourcePart),
			newTargetPart);	

	}

	/**
	 * Test adding a component interface (thus, with a structural realization)
	 * to a deployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddComponentInterfaceToDeployment()
			throws Exception {
		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);

		AbstractTransactionalCommand createDeploymentCommand = new AbstractTransactionalCommand(
			domain, "Create Deployment", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				ZDeploymentUtil.createDeployment(model, "New Deployment");
				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			createDeploymentCommand, null, null);

		Component newDeployment = (Component) model
			.getPackagedElement("New Deployment");

		assertEquals(0, ZDeploymentUtil.getDeploymentParts(newDeployment)
			.size());

		Component container = (Component) model.getPackagedElement("container");
		AddModelElementCommand command = new AddModelElementCommand(
			newDeployment, container, null, null, "Add Component");
		assertTrue(command.canExecute());
		AddModelElementCommand anotherCommand = new AddModelElementCommand(
			newDeployment, container, null, null, "Add Component");
		assertTrue(anotherCommand.canExecute());

		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertEquals(7, ZDeploymentUtil.getDeploymentParts(newDeployment)
			.size());

		OperationHistoryFactory.getOperationHistory().execute(anotherCommand,
			null, null);
		assertEquals(14, ZDeploymentUtil.getDeploymentParts(newDeployment)
			.size());
		
	}

	/**
	 * Test adding a non-component interface (thus, no structural realization)
	 * to a deployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddRegularComponentToDeployment()
			throws Exception {
		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);

		AbstractTransactionalCommand newDeploymentCommand = new AbstractTransactionalCommand(
			domain, "Create Deployment", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				ZDeploymentUtil.createDeployment(model, "New Deployment");
				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			newDeploymentCommand, null, null);

		Component newDeployment = (Component) model
			.getPackagedElement("New Deployment");

		assertEquals(0, ZDeploymentUtil.getDeploymentParts(newDeployment)
			.size());

		Component rtos = (Component) model.getPackagedElement("rtos");
		AddModelElementCommand command = new AddModelElementCommand(
			newDeployment, rtos, null, null, "Add Component");
		assertTrue(command.canExecute());
		AddModelElementCommand anotherCommand = new AddModelElementCommand(
			newDeployment, rtos, null, null, "Add Component");
		assertTrue(anotherCommand.canExecute());

		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertEquals(4, ZDeploymentUtil.getDeploymentParts(newDeployment)
			.size());

		OperationHistoryFactory.getOperationHistory().execute(anotherCommand,
			null, null);
		assertEquals(8, ZDeploymentUtil.getDeploymentParts(newDeployment)
			.size());
		
	}

//	public void testCreateComponentPart()
//			throws Exception {
//
//		assertNotNull(deployment);
//
//		addDefaultElementsToDeployment();
//
//		Component container = (Component) model.getPackagedElement("container");
//		assert (ZDLUtil.isZDLConcept(container, ZMLMMNames.COMPONENT_INTERFACE) == true);
//
//		Component containerRealization = (Component) model
//			.getPackagedElement("containerRealization");
//
//		Component subcomponent = (Component) model
//			.getPackagedElement("subcomponent");
//		Component subsubcomponent = (Component) model
//			.getPackagedElement("subsubcomponent");
//		Component subcomponentRealization = (Component) model
//			.getPackagedElement("subcomponentRealization");
//		Property subsubcomponent1 = subcomponentRealization.getOwnedAttribute(
//			"subsubcomponent1", subsubcomponent);
//
//		int deploymentPartCount = ZDeploymentUtil
//			.getDeploymentParts(deployment).size();
//		assertTrue(deploymentPartCount > 0); // need container & subcomponent
//		// to be in the deployment for
//		// this test
//
//		TransactionalEditingDomain domain = getEditingDomain();
//
//		// Create the UML component part
//		AbstractTransactionalCommand command = new CreateModelElementRecordingCommand(
//			domain, containerRealization, subcomponent, "newsubcomponent");
//		assertTrue(command.canExecute());
//		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
//			command, null, null);
//		assertTrue(result.isOK());
//
//		Property newPart = containerRealization.getOwnedAttribute(
//			"newsubcomponent", subcomponent);
//
//		// Make sure the appropriate deployment parts were created as a result.
//		assertNotNull(newPart);
//
//		assertEquals(deploymentPartCount + 3, ZDeploymentUtil
//			.getDeploymentParts(deployment).size());
//
//		for (Property deploymentPart : ZDeploymentUtil
//			.getDeploymentParts(deployment)) {
//			if (deploymentPart.getName() == "newsubcomponent"
//				|| deploymentPart.getName() == "subsubcomponent1") {
//				assertNotNull(ZDeploymentUtil.getParentPart(deploymentPart));
//			}
//		}
//
//		for (Property deploymentPart : ZDeploymentUtil
//			.getDeploymentParts(deployment)) {
//			if (ZDeploymentUtil.getModelElement(deploymentPart) == container) {
//				// make sure there is exactly one child created for the new
//				// component
//				Property foundChild = getPartRelatedToModelElement(
//					deploymentPart, newPart);
//				assertNotNull(foundChild);
//
//				// make sure it has the proper substructure
//				assertNotNull(getPartRelatedToModelElement(foundChild,
//					subsubcomponent1));
//			}
//		}
//
//		// undo
//		OperationHistoryFactory.getOperationHistory().undoOperation(command,
//			null, null);
//		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
//			deployment).size());
//		// needs some more assertions but if this passes it's a good sign.
//
//		// redo
//		OperationHistoryFactory.getOperationHistory().redoOperation(command,
//			null, null);
//		assertTrue(deploymentPartCount < ZDeploymentUtil.getDeploymentParts(
//			deployment).size());
//
//		for (Property deploymentPart : ZDeploymentUtil
//			.getDeploymentParts(deployment)) {
//			if (ZDeploymentUtil.getModelElement(deploymentPart) == container) {
//				// make sure there is exactly one child created for the new
//				// component
//				Property foundChild = getPartRelatedToModelElement(
//					deploymentPart, newPart);
//				assertNotNull(foundChild);
//
//				// make sure it has the proper substructure
//				assertNotNull(getPartRelatedToModelElement(foundChild,
//					subsubcomponent1));
//			}
//		}
//	}
//
	/**
	 * This test differs from basic component part creation in that the part is
	 * added to a component that is itself used as a part elsewhere in the
	 * model. We need to make sure that the deployment part is not just added to
	 * the component where it was created, but also to every deployment part
	 * referencing a part that references the component.
	 * 
	 * @throws Exception
	 */
//	public void testCreateComponentSubPart()
//			throws Exception {
//
//		assertNotNull(deployment);
//
//		addDefaultElementsToDeployment();
//
//		int deploymentPartCount = ZDeploymentUtil
//			.getDeploymentParts(deployment).size();
//		Component subcomponentRealization = (Component) model
//			.getPackagedElement("subcomponentRealization");
//		assertNotNull(subcomponentRealization);
//		Component subsubcomponent = (Component) model
//			.getPackagedElement("subsubcomponent");
//		assertNotNull(subsubcomponent);
//
//		TransactionalEditingDomain domain = TransactionUtil
//			.getEditingDomain(model);
//
//		CreateModelElementRecordingCommand command = new CreateModelElementRecordingCommand(
//			domain, subcomponentRealization, subsubcomponent,
//			"newsubsubcomponent");
//		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
//			command, null, null);
//		assertTrue(result.isOK());
//
//		Property newPart = subcomponentRealization.getOwnedAttribute(
//			"newsubsubcomponent", subsubcomponent);
//		assertNotNull(newPart);
//
//		// Adding newsubsubcomponent should add three parts:
//		// subcomponent >> newsubsubcomponent,
//		// Container >> subcomponent1 >> newsubsubcomponent
//		// Container >> subcomponent2 >> newsubsubcomponent
//		assertEquals(deploymentPartCount + 3, ZDeploymentUtil
//			.getDeploymentParts(deployment).size());
//
//		// undo
//		OperationHistoryFactory.getOperationHistory().undoOperation(command,
//			null, null);
//		assertEquals(deploymentPartCount, ZDeploymentUtil.getDeploymentParts(
//			deployment).size());
//		// needs some more assertions but if this passes it's a good sign.
//
//		// redo
//		OperationHistoryFactory.getOperationHistory().redoOperation(command,
//			null, null);
//		assertEquals(deploymentPartCount + 3, ZDeploymentUtil
//			.getDeploymentParts(deployment).size());
//		assertNotNull(subcomponentRealization.getOwnedAttribute(
//			"newsubsubcomponent", subsubcomponent));
//
//	}

//	public void testCreateConnector()
//			throws Exception {
//
//		assertNotNull(deployment);
//		addDefaultElementsToDeployment();
//
//		int deploymentPartCount = ZDeploymentUtil
//			.getDeploymentParts(deployment).size();
//		Component containerRealization = (Component) model
//			.getPackagedElement("containerRealization");
//		assertNotNull(containerRealization);
//
//		assertTrue(deploymentPartCount > 0); // need container to be in the
//		// deployment for this test
//
//		TransactionalEditingDomain domain = TransactionUtil
//			.getEditingDomain(model);
//
//		CreateModelElementRecordingCommand command = new CreateModelElementRecordingCommand(
//			domain, containerRealization, null, "newConnector");
//		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
//			command, null, null);
//		assertTrue(result.isOK());
//
//		Connector newConnector = containerRealization
//			.getOwnedConnector("newConnector");
//		assertNotNull(newConnector);
//
//		assertEquals(deploymentPartCount + 1, ZDeploymentUtil
//			.getDeploymentParts(deployment).size());
//		for (Property deploymentPart : ZDeploymentUtil
//			.getDeploymentParts(deployment)) {
//			if (ZDeploymentUtil.getModelElement(deploymentPart) == containerRealization) {
//				// make sure there is exactly one child created for the new
//				// connector
//				Property foundChild = getPartRelatedToModelElement(
//					deploymentPart, newConnector);
//				assertNotNull(foundChild);
//			}
//		}
//	}

	/**
	 * Test to make sure that adding parts to model elements not involved in a
	 * deployment will not impact that deployment.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIrreleventCreations()
			throws Exception {

		assertNotNull(deployment);

		Component container = (Component) model.getPackagedElement("container");

		AddModelElementCommand command = new AddModelElementCommand(deployment,
			container, null, null, "Add Component");
		assertTrue(command.canExecute());
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);

		assertEquals(7, ZDeploymentUtil.getDeploymentParts(deployment).size());

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);

		Component rtos = (Component) model.getPackagedElement("rtos");

		CreateModelElementRecordingCommand command2 = new CreateModelElementRecordingCommand(
			domain, rtos, null, "newConnector");
		assertTrue(command2.canExecute());
		OperationHistoryFactory.getOperationHistory().execute(command2, null,
			null);

		assertEquals(7, ZDeploymentUtil.getDeploymentParts(deployment).size());

		Component thread = (Component) model.getPackagedElement("thread");

		CreateModelElementRecordingCommand command3 = new CreateModelElementRecordingCommand(
			domain, rtos, thread, "newThread");
		assertTrue(command3.canExecute());
		OperationHistoryFactory.getOperationHistory().execute(command3, null,
			null);

		assertEquals(7, ZDeploymentUtil.getDeploymentParts(deployment).size());

		AbstractTransactionalCommand command4 = new AbstractTransactionalCommand(
			TransactionUtil.getEditingDomain(model), "Create Deployment",
			Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				model.createPackagedElement("boris",
					UMLPackage.Literals.COMPONENT);
				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(command4, null,
			null);

		assertEquals(7, ZDeploymentUtil.getDeploymentParts(deployment).size());
	}

	@Test
	public void testRemoveContainer()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertEquals(16, deploymentPartCount);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component container = (Component) model.getPackagedElement("container");
		assertNotNull(container);

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove a component and make sure the appropriate deployment parts are
		// removed.

		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, container);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertNull(model.getPackagedElement("container"));

		assertEquals(9, ZDeploymentUtil.getDeploymentParts(deployment).size());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		// TODO needs assertions
		
	}

	@Test
	public void testRemoveRtos()
			throws Exception {
		
		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertEquals(16, deploymentPartCount);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		// System.out.println("deploymentPartCount = " + deploymentPartCount +
		// ", deployment.getDeploymentParts().size() = " +
		// deployment.getDeploymentParts().size());
		// for( int i = 0; i < deployment.getDeploymentParts().size(); i++ )
		// System.out.print(deployment.getDeploymentParts().get(i).getName() +
		// "\t");
		// System.out.println(" ");

		//TransactionalEditingDomain domain = TransactionUtil
		//	.getEditingDomain(model);
		// Remove a component and make sure the appropriate deployment parts are
		// removed.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, rtos);
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());

		assertNull(model.getPackagedElement("rtos"));
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(12, ZDeploymentUtil.getDeploymentParts(deployment).size());
		// System.out.println("deploymentPartCount = " + deploymentPartCount +
		// ", deployment.getDeploymentParts().size() = " +
		// deployment.getDeploymentParts().size());
		// for( int i = 0; i < deployment.getDeploymentParts().size(); i++ )
		// System.out.print(deployment.getDeploymentParts().get(i).getName() +
		// "\t");
		// System.out.println(" ");
		// TODO needs assertions	
	}

	@Test
	public void testRemoveComponentPart()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component scRealization = (Component) model
			.getPackagedElement("subcomponentRealization");
		assertNotNull(scRealization);

		Property subsubcomponent1 = scRealization.getOwnedAttribute(
			"subsubcomponent1", subsubcomponent);
		assertNotNull(subsubcomponent1);

		// printDeployment(deployment, "Before delete...");

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove a component part and make sure the appropriate deployment
		// parts are removed.
		// String original_id = getPartRelatedToModelElement(deployment,
		// subsubcomponent1).get(0).getId();

		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subsubcomponent1);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);

		assertNull(scRealization.getOwnedAttribute("subsubcomponent1",
			subsubcomponent));
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		// printDeployment(deployment, "After delete...");
		// TODO needs assertions		

	}

	@Test
	public void testRemoveConnector()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		// Component subcomponent = (Component)
		// model.getPackagedElement("subcomponent");
		Component scRealization = (Component) model
			.getPackagedElement("subcomponentRealization");
		Connector connector1 = scRealization.getOwnedConnector("connector1");
		assertNotNull(connector1);

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// printDeployment(deployment, "Before delete...");
		// String original_id = getPartRelatedToModelElement(deployment,
		// connector1).get(0).getId();
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, connector1);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);

		assertNull(scRealization.getOwnedConnector("connector1"));
		assertEquals(13, ZDeploymentUtil.getDeploymentParts(deployment).size());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		
	}

	@Test
	public void testRemoveDeployedComponent()
			throws Exception {

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		testDeployComponent();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		Property sourcePart = ZDeploymentUtil
			.getSourcePartForAllocation((Dependency) ZDeploymentUtil
				.getAllocations(deployment).toArray()[0]);
		assertNotNull(sourcePart.getType());

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove the component that was deployed.

		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, sourcePart.getType());
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());

		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());		

	}

	@Test
	public void testRemoveDeployedComponentPart()
			throws Exception {

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		testDeployComponentPart();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		Property sourcePart = ZDeploymentUtil
			.getSourcePartForAllocation((Dependency) ZDeploymentUtil
				.getAllocations(deployment).toArray()[0]);

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove a component part and make sure the appropriate deployment
		// parts are removed.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, ZDeploymentUtil.getModelElement(sourcePart));
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);

		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions		
	}

	@Test
	public void testRemoveDeployedConnector()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component scRealization = (Component) model
			.getPackagedElement("subcomponentRealization");
		assertNotNull(scRealization);

		Connector sourceConnector = scRealization.getOwnedConnector("connector1");
		assertNotNull(sourceConnector);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		Connector targetConnector = rtos.getOwnedConnector("rtos bus");
		assertNotNull(targetConnector);

		// Deploy the connector
		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, sourceConnector).get(0);
		assertNotNull(sourcePart);

		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, targetConnector).get(0);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);

		// Remove the deployed connector.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, ZDeploymentUtil.getModelElement(sourcePart));
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);

		assertNull(subcomponent.getOwnedConnector("connector1"));
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions
		
	}

	@Test
	public void testRemoveComponentDeployedOn()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		// Deploy something on a component
		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, subsubcomponent).get(0);
		assertNotNull(sourcePart);

		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, rtos).get(0);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		// Remove rtos and make sure the appropriate deployment parts are
		// removed.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, rtos);
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);

		assertTrue(result.isOK());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions

		
	}

	@Test
	public void testRemoveComponentPartDeployedOn()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component scRealization = (Component) model
			.getPackagedElement("subcomponentRealization");
		assertNotNull(scRealization);

		Property subsubcomponent1 = scRealization.getOwnedAttribute(
			"subsubcomponent1", subsubcomponent);
		assertNotNull(subsubcomponent1);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		// Deploy something on a component part
		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, rtos).get(0);
		assertNotNull(sourcePart);

		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, subsubcomponent1).get(0);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove subsubcomponent1 and make sure the appropriate deployment
		// parts are removed.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subsubcomponent1);
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());

		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions
		
	}

	@Test
	public void testRemoveConnectorDeployedOn()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		Connector targetConnector = rtos.getOwnedConnector("rtos bus");
		assertNotNull(targetConnector);

		// Deploy something on a connector
		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, rtos).get(0);
		assertNotNull(sourcePart);

		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, targetConnector).get(0);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		// Remove the deployed-on connector.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, targetConnector);
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());

		assertNull(rtos.getOwnedConnector("rtos bus"));
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions
	
	}

	@Test
	public void testRemoveAncestorOfDeployedComponentPart()
			throws Exception {

		Component container = (Component) model.getPackagedElement("container");
		assertNotNull(container);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		testDeployComponentPart();
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		Property sourcePart = ZDeploymentUtil
			.getSourcePartForAllocation((Dependency) ZDeploymentUtil
				.getAllocations(deployment).toArray()[0]);
		assertNotNull(ZDeploymentUtil.getModelComponent(sourcePart));
		assertTrue(ZDeploymentUtil.getModelElement(sourcePart) instanceof Property);
		assertNotNull(ZDeploymentUtil.getParentPart(sourcePart));

		// Remove the ancestor the source part.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, ZDeploymentUtil.getModelComponent(ZDeploymentUtil
				.getParentPart(sourcePart)));
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions		
		
	}

	@Test
	public void testRemoveAncestorOfComponentPartDeployedOn()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component container = (Component) model.getPackagedElement("container");
		assertNotNull(container);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component containerRealization = (Component) model
			.getPackagedElement("containerRealization");
		assertNotNull(containerRealization);

		Property subcomponent1 = containerRealization.getOwnedAttribute(
			"subcomponent1", subcomponent);
		assertNotNull(subcomponent1);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		Component thread = (Component) model.getPackagedElement("thread");
		assertNotNull(thread);

		Property thread1 = rtos.getOwnedAttribute("thread1", thread);
		assertNotNull(thread1);

		// Deploy a component part onto thread1.
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, subcomponent1).get(0);
		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, thread1).get(0);
		assertNotNull(sourcePart);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		// Remove the ancestor of thread1 (rtos)
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			this.domain, rtos);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertNull(model.getPackagedElement("rtos"));
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions
		
	}

	@Test
	public void testRemoveSubsubcomponent()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertEquals(16, deploymentPartCount);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component container = (Component) model.getPackagedElement("container");
		assertNotNull(container);

		// System.out.println("deploymentPartCount = " + deploymentPartCount +
		// ", deployment.getDeploymentParts().size() = " +
		// deployment.getDeploymentParts().size());
		// for( int i = 0; i < deployment.getDeploymentParts().size(); i++ )
		// System.out.print(deployment.getDeploymentParts().get(i).getName() +
		// "\t");
		// System.out.println(" ");

		// Remove a component and make sure the appropriate deployment parts are
		// removed.

		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subsubcomponent);
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());

		assertNull(model.getPackagedElement("subsubcomponent"));
		assertEquals(12, ZDeploymentUtil.getDeploymentParts(deployment).size());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());

		// System.out.println("deploymentPartCount = " + deploymentPartCount +
		// ", deployment.getDeploymentParts().size() = " +
		// deployment.getDeploymentParts().size());
		// for( int i = 0; i < deployment.getDeploymentParts().size(); i++ )
		// System.out.print(deployment.getDeploymentParts().get(i).getName() +
		// "\t");
		// System.out.println(" ");
		// TODO needs assertions

	}

	@Test
	public void testRemoveSubcomponent()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertEquals(16, deploymentPartCount);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove a component and make sure the appropriate deployment parts are
		// removed.
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subcomponent);
		IStatus result = OperationHistoryFactory.getOperationHistory().execute(
			command, null, null);
		assertTrue(result.isOK());

		assertNull(model.getPackagedElement("subcomponent"));
		assertEquals(7, ZDeploymentUtil.getDeploymentParts(deployment).size());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());

	}

	@Test
	public void testRemoveThread()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();
		assertEquals(16, deploymentPartCount);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component subsubcomponent = (Component) model
			.getPackagedElement("subsubcomponent");
		assertNotNull(subsubcomponent);

		Component thread = (Component) model.getPackagedElement("thread");
		assertNotNull(thread);

		// System.out.println("deploymentPartCount = " + deploymentPartCount +
		// ", deployment.getDeploymentParts().size() = " +
		// deployment.getDeploymentParts().size());
		// for( int i = 0; i < deployment.getDeploymentParts().size(); i++ )
		// System.out.print(deployment.getDeploymentParts().get(i).getName() +
		// "\t");
		// System.out.println(" ");

		DestroyElementCommand.destroy(thread);

		assertNull(model.getPackagedElement("thread"));
		assertEquals(13, ZDeploymentUtil.getDeploymentParts(deployment).size());
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());

		// System.out.println("deploymentPartCount = " + deploymentPartCount +
		// ", deployment.getDeploymentParts().size() = " +
		// deployment.getDeploymentParts().size());
		// for( int i = 0; i < deployment.getDeploymentParts().size(); i++ )
		// System.out.print(deployment.getDeploymentParts().get(i).getName() +
		// "\t");
		// System.out.println(" ");
		// TODO needs assertions

	}

	@Test
	public void testRemoveAncestorOfDeployedConnector()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component scRealization = (Component) model
			.getPackagedElement("subcomponentRealization");
		assertNotNull(scRealization);

		Connector sourceConnector = scRealization.getOwnedConnector("connector1");
		assertNotNull(sourceConnector);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		// Deploy a connector
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());

		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, sourceConnector).get(0);
		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, rtos).get(0);
		assertNotNull(sourcePart);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		// Remove the ancestor of connector1 (subcomponent)
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subcomponent);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions

	}

	@Test
	public void testRemoveDefinitionOfComponentPartDeployedOn()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component container = (Component) model.getPackagedElement("container");
		assertNotNull(container);

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component containerRealization = (Component) model
			.getPackagedElement("containerRealization");
		assertNotNull(containerRealization);

		Property subcomponent1 = containerRealization.getOwnedAttribute(
			"subcomponent1", subcomponent);
		assertNotNull(subcomponent1);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		Component thread = (Component) model.getPackagedElement("thread");
		assertNotNull(thread);

		Property thread1 = rtos.getOwnedAttribute("thread1", thread);
		assertNotNull(thread1);

		// Deploy on a component part
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, rtos).get(0);
		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, subcomponent1).get(0);
		assertNotNull(sourcePart);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		// Remove the ancestor of connector1 (subcomponent)
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subcomponent);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertNull(model.getPackagedElement("subcomponent"));
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions

	}

	@Test
	public void testRemoveAncestorOfConnectorDeployedOn()
			throws Exception {

		addDefaultElementsToDeployment();

		int deploymentPartCount = ZDeploymentUtil
			.getDeploymentParts(deployment).size();

		Component subcomponent = (Component) model
			.getPackagedElement("subcomponent");
		assertNotNull(subcomponent);

		Component scRealization = (Component) model
			.getPackagedElement("subcomponentRealization");
		assertNotNull(scRealization);

		Connector sourceConnector = scRealization.getOwnedConnector("connector1");
		assertNotNull(sourceConnector);

		Component rtos = (Component) model.getPackagedElement("rtos");
		assertNotNull(rtos);

		// Deploy on a connector
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());

		Property sourcePart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, rtos).get(0);
		Property targetPart = ZDeploymentUtil.getDeploymentPartForModelElement(
			deployment, sourceConnector).get(0);
		assertNotNull(sourcePart);
		assertNotNull(targetPart);

		CreateAllocationCommand cac = new CreateAllocationCommand(deployment,
			sourcePart, targetPart, "Deploy");
		OperationHistoryFactory.getOperationHistory().execute(cac, null, null);
		assertEquals(1, ZDeploymentUtil.getAllocations(deployment).size());

		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(model);
		// Remove the subcomponent
		DeleteModelElementRecordingCommand command = new DeleteModelElementRecordingCommand(
			domain, subcomponent);
		OperationHistoryFactory.getOperationHistory().execute(command, null,
			null);
		assertTrue(deploymentPartCount > ZDeploymentUtil.getDeploymentParts(
			deployment).size());
		assertEquals(0, ZDeploymentUtil.getAllocations(deployment).size());
		// TODO needs assertions

	}

}
