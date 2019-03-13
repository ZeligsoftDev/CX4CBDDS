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


package com.zeligsoft.domain.zml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.PortOperationsTrigger;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepairTrigger;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepair;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * PortOperationsTrigger tests.
 * 
 * @author jcorchis
 * 
 */
@SuppressWarnings("nls")
public class WorkerFunctionTests {

	private ResourceSet rset;

	private TransactionalEditingDomain domain;

	private WorkerFunctionRepairTrigger portOperationsSemProc;

	private Profile zml;

	private Resource testResource;

	private Package testPackage;

	private Component CI_1;

	private Component CI_2;

	private Component SR_1;

	private Component SR_2;

	private Component SR_3;

	private Port P_1;

	private Port P_2;

	private Interface I_1;

	private Interface I_2;

	private Interface I_3;

	private org.eclipse.uml2.uml.Class PT_1;

	private org.eclipse.uml2.uml.Class PT_2;

	private Operation OP_1;

	private Operation OP_2;

	private Operation OP_3;

	private Operation OP_4;

	private Operation OP_5;

	private Generalization GEN_1;

	private InterfaceRealization IR_1;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public WorkerFunctionTests() {
		// Default constructor
	}

	@Before
	public void setUp()
			throws Exception {

		rset = new ResourceSetImpl();

		Resource profile = rset.getResource(URI
			.createURI("pathmap://ZML_PROFILES/ZML.profile.uml"), true);
		zml = (Profile) EcoreUtil.getObjectByType(profile.getContents(),
			UMLPackage.Literals.PROFILE);
		assertNotNull("No ZML profile", zml);

		testResource = rset.createResource(URI
			.createURI("http:///workerfunction.emx"));

		testPackage = UMLFactory.eINSTANCE.createPackage();
		testPackage.setName("test");
		testResource.getContents().add(testPackage);
		testPackage.applyProfile(zml);

		I_1 = (Interface) testPackage.createOwnedType("I_1",
			UMLPackage.Literals.INTERFACE);
		ZDLUtil.addZDLConcept(I_1, ZMLMMNames.INTERFACE);
		OP_1 = I_1.createOwnedOperation("OP_1", null, null);
		OP_2 = I_1.createOwnedOperation("OP_2", null, null);

		I_2 = (Interface) testPackage.createOwnedType("I_2",
			UMLPackage.Literals.INTERFACE);
		ZDLUtil.addZDLConcept(I_2, ZMLMMNames.INTERFACE);
		OP_3 = I_2.createOwnedOperation("OP_3", null, null);
		OP_4 = I_2.createOwnedOperation("OP_4", null, null);

		I_3 = (Interface) testPackage.createOwnedType("I_3",
			UMLPackage.Literals.INTERFACE);
		ZDLUtil.addZDLConcept(I_3, ZMLMMNames.INTERFACE);
		OP_5 = I_3.createOwnedOperation("OP_5", null, null);

		PT_1 = testPackage.createOwnedClass("PT_1", false);
		ZDLUtil.addZDLConcept(PT_1, ZMLMMNames.PORT_TYPE);
		PT_2 = testPackage.createOwnedClass("PT_2", false);
		ZDLUtil.addZDLConcept(PT_2, ZMLMMNames.PORT_TYPE);

		CI_1 = (Component) testPackage.createOwnedType("CI_1",
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(CI_1, ZMLMMNames.COMPONENT_INTERFACE);
		CI_2 = (Component) testPackage.createOwnedType("CI_2",
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(CI_2, ZMLMMNames.COMPONENT_INTERFACE);

		SR_1 = (Component) testPackage.createOwnedType("SR_1",
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(SR_1, ZMLMMNames.STRUCTURAL_REALIZATION);
		SR_2 = (Component) testPackage.createOwnedType("SR_2",
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(SR_2, ZMLMMNames.STRUCTURAL_REALIZATION);
		SR_3 = (Component) testPackage.createOwnedType("SR_3",
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(SR_3, ZMLMMNames.STRUCTURAL_REALIZATION);

		domain = TransactionalEditingDomain.Factory.INSTANCE
			.createEditingDomain(rset);
		portOperationsSemProc = new PortOperationsTrigger();
		domain.addResourceSetListener(portOperationsSemProc);

	}

	@After
	public void tearDown()
			throws Exception {
		domain.removeResourceSetListener(portOperationsSemProc);
		CI_1 = CI_2 = null;
		SR_1 = SR_2 = null;
		I_1 = I_2 = I_3 = null;
		OP_1 = OP_2 = OP_3 = OP_4 = OP_5 = null;
		PT_1 = PT_2 = null;
		GEN_1 = null;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_CreateGeneralization()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Build Gen Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				CI_1.createInterfaceRealization("IR_1", I_3);
				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		assertEquals(null, ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE));
		assertTrue(((List<EObject>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)).isEmpty());

		AbstractTransactionalCommand createGeneralization = new AbstractTransactionalCommand(
			domain, "Create Generalization", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				ZDLUtil.setValue(SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
					ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE, CI_1);
				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			createGeneralization, null, null);

		List<Operation> ownedOperations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(3, ownedOperations.size());
		for (Operation thisOperation : ownedOperations) {
			Port receivingPort = (Port) ZDLUtil.getValue(thisOperation,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
			if (receivingPort != null) {
				assertEquals(receivingPort, P_1);
			} else {
				// if the receiving port is not set the check that
				// it is a interface realization operation
				assertEquals(thisOperation.getName(), OP_5.getName());
			}

		}

	}

	/**
	 * Tests generalization specific changes on structural realizations.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_ChangeGeneralizationSpecific()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Change Generalization Specific Senario",
			Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				CI_1.createInterfaceRealization("IR_1", I_3);
				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);
				GEN_1 = SR_1.createGeneralization(CI_1);
				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		AbstractTransactionalCommand changeGenSpecific = new AbstractTransactionalCommand(
			domain, "Change Generalization Specific", Collections.EMPTY_MAP,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				GEN_1.setSpecific(SR_2);
				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			changeGenSpecific, null, null);

		assertEquals(0, SR_1.getOwnedOperations().size());

		List<Operation> ownedOperations = SR_2.getOwnedOperations();
		assertEquals(3, ownedOperations.size());
		for (Operation thisOperation : ownedOperations) {
			assertTrue(ZDLUtil.isZDLConcept(thisOperation,
				ZMLMMNames.WORKER_FUNCTION));
			Port receivingPort = (Port) ZDLUtil.getValue(thisOperation,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
			if (receivingPort != null) {
				assertEquals(receivingPort, P_1);
			} else {
				// if the receiving port is not set the check that
				// it is a interface realization operation
				assertEquals(thisOperation.getName(), OP_5.getName());
			}

		}
	}

	/**
	 * Tests changes to the generalization general feature on component
	 * interface.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_ChangeGeneralizationGeneral()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Change Generalization General Senario",
			Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				CI_1.createInterfaceRealization("IR_1", I_3);
				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);

				PT_2.createInterfaceRealization("P_2", I_2);
				P_2 = CI_2.createOwnedPort("P_2", PT_2);
				ZDLUtil.addZDLConcept(P_2, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> srOperations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(3, srOperations.size());

		AbstractTransactionalCommand changeGenGeneral = new AbstractTransactionalCommand(
			domain, "Change Generalization General", Collections.EMPTY_MAP,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				GEN_1.setGeneral(CI_2);
				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(changeGenGeneral,
			null, null);

		List<Operation> ownedOperations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, ownedOperations.size());

	}

	/**
	 * Tests removing an generalization between a structural realization and a
	 * component interface.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_DeleteGeneralization()
			throws Exception {

		AbstractTransactionalCommand buildDeleteSenario = new AbstractTransactionalCommand(
			domain, "Build Delete Generalization", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				CI_1.createInterfaceRealization("IR_1", I_3);
				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			buildDeleteSenario, null, null);

		List<Operation> operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		assertEquals(3, operations.size());

		AbstractTransactionalCommand deleteGeneralization = new AbstractTransactionalCommand(
			domain, "Delete Generalization", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				GEN_1.destroy();

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			deleteGeneralization, null, null);

		operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, operations.size());

	}

	/**
	 * Test to add a Port on a component interface
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_AddPort()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Add Ports to CI Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr2Operations.size());

		AbstractTransactionalCommand addPortCommand = new AbstractTransactionalCommand(
			domain, "Add Port to CI Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);

				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};

		IStatus result = OperationHistoryFactory.getOperationHistory().execute(addPortCommand,
			null, null);
		assertTrue(result.isOK());

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		for (int i = 0; i < sr1Operations.size(); i++) {
			Operation thisOperation = sr1Operations.get(i);
			if (thisOperation.getName() == OP_1.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1);
			} else if (thisOperation.getName() == OP_2.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2);
			}
			assertTrue(ZDLUtil.getValue(thisOperation,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);

		}

		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());
		for (int i = 0; i < sr1Operations.size(); i++) {
			Operation thisOperation = sr1Operations.get(i);
			if (thisOperation.getName() == OP_1.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1);
			} else if (thisOperation.getName() == OP_2.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2);
			}
			assertTrue(ZDLUtil.getValue(thisOperation,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}

	}

	/**
	 * Test to add a Port on a component interface
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_AddMultiplePortOfSameType()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Add Ports to CI Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr2Operations.size());

		AbstractTransactionalCommand addPortCommand = new AbstractTransactionalCommand(
			domain, "Add Ports to CI Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				P_2 = CI_1.createOwnedPort("P_2", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);
				ZDLUtil.addZDLConcept(P_2, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(addPortCommand,
			null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(4, sr1Operations.size());

		boolean[] testCase = new boolean[4];

		for (int i = 0; i < sr1Operations.size(); i++) {
			Operation thisOperation = sr1Operations.get(i);
			if (thisOperation.getName().equals("P_1_OP_1")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
				testCase[0] = true;
			} else if (thisOperation.getName().equals("P_1_OP_2")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
				testCase[1] = true;
			} else if (thisOperation.getName().equals("P_2_OP_1")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_2);
				testCase[2] = true;
			} else if (thisOperation.getName().equals("P_2_OP_2")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_2);
				testCase[3] = true;
			}

		}

		for (int i = 0; i < testCase.length; i++) {
			assertTrue(testCase[i]);
			// reset for next tests
			testCase[i] = false;
		}

		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(4, sr2Operations.size());

		for (int i = 0; i < sr2Operations.size(); i++) {
			Operation thisOperation = sr1Operations.get(i);
			if (thisOperation.getName().equals("P_1_OP_1")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
				testCase[0] = true;
			} else if (thisOperation.getName().equals("P_1_OP_2")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
				testCase[1] = true;
			} else if (thisOperation.getName().equals("P_2_OP_1")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_2);
				testCase[2] = true;
			} else if (thisOperation.getName().equals("P_2_OP_2")) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2);
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_2);
				testCase[3] = true;
			}

		}

		for (int i = 0; i < testCase.length; i++) {
			assertTrue(testCase[i]);
		}

	}

	/**
	 * Tests worker function synchronization updates when a port's type is
	 * changed.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_ChangePortType()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Change PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);

				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());

		AbstractTransactionalCommand changePortTypeCommand = new AbstractTransactionalCommand(
			domain, "Change PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_2.createInterfaceRealization("P_1", I_2);
				P_1.setType(PT_2);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			changePortTypeCommand, null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		for (int i = 0; i < sr1Operations.size(); i++) {
			Operation thisOperation = sr1Operations.get(i);
			if (thisOperation.getName() == OP_3.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_3);
			} else if (thisOperation.getName() == OP_4.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_4);
			}
			assertTrue(ZDLUtil.getValue(thisOperation,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);

		}

		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());
		for (int i = 0; i < sr1Operations.size(); i++) {
			Operation thisOperation = sr1Operations.get(i);
			if (thisOperation.getName() == OP_3.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_3);
			} else if (thisOperation.getName() == OP_4.getName()) {
				assertTrue(ZDLUtil.getValue(thisOperation,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_4);
			}
			assertTrue(ZDLUtil.getValue(thisOperation,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
	}

	/**
	 * Test to delete a ZML port with provides interface on a component
	 * interface and verify that all structural realization are updated.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_DeletePort()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Delete PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());

		AbstractTransactionalCommand deletePortCommand = new AbstractTransactionalCommand(
			domain, "Change PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				P_1.destroy();

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			deletePortCommand, null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr1Operations.size());
		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr2Operations.size());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_RepairWorkerFunctionNonDestructive()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Delete PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		final Operation workerFunction = sr1Operations.get(0);

		AbstractTransactionalCommand repairCommand = new AbstractTransactionalCommand(
			domain, "Delete PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				ZDLUtil.setValue(workerFunction, ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__BODY, "This is body");
				WorkerFunctionRepair.INSTANCE.repair(SR_1);

				return CommandResult.newOKCommandResult();

			}
		};

		OperationHistoryFactory.getOperationHistory().execute(repairCommand,
			null, null);
		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		Operation newWorkerFunction = sr1Operations.get(0);
		String value = (String) ZDLUtil.getValue(newWorkerFunction,
			ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__BODY);

		assertEquals("This is body", value);
	}

	/**
	 * Test to delete a ZML port with provides interface on a component
	 * interface and verify that all structural realization are updated.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_RenamePort()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Delete PortType Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());

		AbstractTransactionalCommand renamePortCommand = new AbstractTransactionalCommand(
			domain, "Rename Port Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				P_1.setName("P_1_New");

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			renamePortCommand, null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		assertEquals(sr1Operations.get(0).getName(), P_1.getName() + "_"
			+ "OP_1");

		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());
		assertEquals(sr1Operations.get(0).getName(), P_1.getName() + "_"
			+ "OP_1");

		final Operation workerFunction = sr1Operations.get(0);
		AbstractTransactionalCommand renameWorkerFunctionCommand = new AbstractTransactionalCommand(
			domain, "Rename Worker Function Senario", Collections.EMPTY_MAP,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				workerFunction.setName("My Name");

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(
			renameWorkerFunctionCommand, null, null);

		AbstractTransactionalCommand renamePortCommand2 = new AbstractTransactionalCommand(
			domain, "Rename Port Senario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				P_1.setName("P_1_New");

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			renamePortCommand2, null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		assertEquals(sr1Operations.get(0).getName(), "My Name");
	}

	/**
	 * Test to add an interface realization on the component interface and
	 * verify that all structural realization are updated.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_AddInterfaceRealization()
			throws Exception {

		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Add InterfaceRealization Senario", Collections.EMPTY_MAP,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());

		AbstractTransactionalCommand addInterfaceRealization = new AbstractTransactionalCommand(
			domain, "Add InterfaceRealization Senario", Collections.EMPTY_MAP,
			null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				CI_1.createInterfaceRealization("IR_1", I_3);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			addInterfaceRealization, null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(3, sr1Operations.size());

		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(3, sr2Operations.size());

	}

	/**
	 * Test to remove a interface realization from the component interface and
	 * verify that all structural realization are updated.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_DeleteInterfaceRealization()
			throws Exception {
		AbstractTransactionalCommand buildSenario = new AbstractTransactionalCommand(
			domain, "Delete InterfaceRealization Senario",
			Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);
				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);
				IR_1 = CI_1.createInterfaceRealization("IR_1", I_3);
				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(buildSenario,
			null, null);

		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(3, sr1Operations.size());

		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(3, sr2Operations.size());

		AbstractTransactionalCommand deleteInterfaceRealization = new AbstractTransactionalCommand(
			domain, "Delete InterfaceRealization Senario",
			Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				IR_1.destroy();

				return CommandResult.newOKCommandResult();
			}

		};

		OperationHistoryFactory.getOperationHistory().execute(
			deleteInterfaceRealization, null, null);

		sr1Operations = (List<Operation>) ZDLUtil.getValue(SR_1,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());

		sr2Operations = (List<Operation>) ZDLUtil.getValue(SR_2,
			ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr2Operations.size());

	}
	
	/**
	 * Tests the scenario in which a port is moved from one
	 * <tt>ComponentInterface</tt> to another, where both have exactly one
	 * <tt>StructuralRealization</tt>.
	 * 
	 * @throws ExecutionException in case the test fails to mutate the model
	 */
	@Test
	public void test_movePortFromOneCIToAnother_unambiguousSRs_bug14207()
			throws ExecutionException {

		// establish the CI-SR implementation relationships
		AbstractTransactionalCommand buildScenario = new AbstractTransactionalCommand(
			domain, "Link SRs to CIs", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				// each CI has exactly one SR
				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_2.createGeneralization(CI_2);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(buildScenario,
			null, null);

		// add a port to the first CI, with some operations
		AbstractTransactionalCommand addPortCommand = new AbstractTransactionalCommand(
			domain, "Add Port to CI Scenario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);

				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(addPortCommand,
			null, null);

		// make sure that SR2 doesn't accidentally have any workers, yet
		@SuppressWarnings("unchecked")
		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr2Operations.size());
		
		@SuppressWarnings("unchecked")
		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		int found = 0;
		String body1 = "body text 1";
		String body2 = "body text 2";
		for (Operation next : sr1Operations) {
			if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1) {
				found |= 1;
				OperationHistoryFactory.getOperationHistory().execute(
					new SetBodyCommand(next, body1), null, null);
			} else if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2) {
				found |= 2;
				OperationHistoryFactory.getOperationHistory().execute(
					new SetBodyCommand(next, body2), null, null);
			}
			assertTrue(ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
		assertEquals("Not all workers found", 3, found);

		// copy the SR1 operations for comparison at the next stage
		sr1Operations = new java.util.ArrayList<Operation>(sr1Operations);

		// now, move the port
		AbstractTransactionalCommand movePortCommand = new AbstractTransactionalCommand(
			domain, "Move port from CI1 to CI2", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				CI_2.getOwnedAttributes().add(P_1);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(movePortCommand,
			null, null);

		// the same exact workers are moved
		@SuppressWarnings("unchecked")
		List<Operation> newSR2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertTrue("Workers not moved as expected", newSR2Operations
			.containsAll(sr1Operations));
		assertEquals("Too many operations in SR2", 2, newSR2Operations.size());

		// check that the workers were not damaged by the move
		assertEquals(2, newSR2Operations.size());
		found = 0;
		for (Operation next : newSR2Operations) {
			if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1) {
				found |= 1;
				assertEquals("Worker lost its body text", body1, ZDLUtil
					.getValue(next, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__BODY));
			} else if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2) {
				found |= 2;
				assertEquals("Worker lost its body text", body2, ZDLUtil
					.getValue(next, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__BODY));
			}
			assertTrue(ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
		assertEquals("Not all workers found", 3, found);

		// the first SR no longer has any workers
		@SuppressWarnings("unchecked")
		List<Operation> newSR1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertTrue("SR1 still has worker functions", newSR1Operations.isEmpty());
	}
	
	/**
	 * Tests the scenario in which a port is moved from one
	 * <tt>ComponentInterface</tt> to another, where the source CI has more than
	 * one <tt>StructuralRealization</tt>.
	 * 
	 * @throws ExecutionException in case the test fails to mutate the model
	 */
	@Test
	public void test_movePortFromOneCIToAnother_ambiguousSRsInSource_bug14207()
			throws ExecutionException {

		// establish the CI-SR implementation relationships
		AbstractTransactionalCommand buildScenario = new AbstractTransactionalCommand(
			domain, "Link SRs to CIs", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				// the source CI has more than one SR
				GEN_1 = SR_1.createGeneralization(CI_1);
				SR_3.createGeneralization(CI_1);
				
				SR_2.createGeneralization(CI_2);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(buildScenario,
			null, null);

		// add a port to the first CI, with some operations
		AbstractTransactionalCommand addPortCommand = new AbstractTransactionalCommand(
			domain, "Add Port to CI Scenario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);

				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(addPortCommand,
			null, null);

		// make sure that SR2 doesn't accidentally have any workers, yet
		@SuppressWarnings("unchecked")
		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr2Operations.size());
		
		@SuppressWarnings("unchecked")
		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		int found = 0;
		String body1 = "body text 1";
		String body2 = "body text 2";
		for (Operation next : sr1Operations) {
			if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1) {
				found |= 1;
				OperationHistoryFactory.getOperationHistory().execute(
					new SetBodyCommand(next, body1), null, null);
			} else if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2) {
				found |= 2;
				OperationHistoryFactory.getOperationHistory().execute(
					new SetBodyCommand(next, body2), null, null);
			}
			assertTrue(ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
		assertEquals("Not all workers found", 3, found);

		// copy the SR1 operations for comparison at the next stage
		sr1Operations = new java.util.ArrayList<Operation>(sr1Operations);

		// now, move the port
		AbstractTransactionalCommand movePortCommand = new AbstractTransactionalCommand(
			domain, "Move port from CI1 to CI2", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				CI_2.getOwnedAttributes().add(P_1);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(movePortCommand,
			null, null);

		// the old workers are not moved, but newly re-created
		@SuppressWarnings("unchecked")
		List<Operation> newSR2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertFalse("Workers were moved", newSR2Operations
			.containsAll(sr1Operations));
		assertEquals("Wrong number of operations in SR2", 2, newSR2Operations.size());

		// check that the new workers do not have any body text
		assertEquals(2, newSR2Operations.size());
		found = 0;
		for (Operation next : newSR2Operations) {
			if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1) {
				found |= 1;
				assertNull("Worker retained its body text", ZDLUtil
					.getValue(next, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__BODY));
			} else if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2) {
				found |= 2;
				assertNull("Worker retained its body text", ZDLUtil
					.getValue(next, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__BODY));
			}
			assertTrue(ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
		assertEquals("Not all workers found", 3, found);

		// the first SR no longer has any workers
		@SuppressWarnings("unchecked")
		List<Operation> newSR1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertTrue("SR1 still has worker functions", newSR1Operations.isEmpty());
	}
	
	/**
	 * Tests the scenario in which a port is moved from one
	 * <tt>ComponentInterface</tt> to another, where the destination CI has
	 * more than one <tt>StructuralRealization</tt>.
	 * 
	 * @throws ExecutionException in case the test fails to mutate the model
	 */
	@Test
	public void test_movePortFromOneCIToAnother_ambiguousSRsInDestination_bug14207()
			throws ExecutionException {

		// establish the CI-SR implementation relationships
		AbstractTransactionalCommand buildScenario = new AbstractTransactionalCommand(
			domain, "Link SRs to CIs", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				SR_2.createGeneralization(CI_2);
				SR_3.createGeneralization(CI_2);
				
				GEN_1 = SR_1.createGeneralization(CI_1);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(buildScenario,
			null, null);

		// add a port to the first CI, with some operations
		AbstractTransactionalCommand addPortCommand = new AbstractTransactionalCommand(
			domain, "Add Port to CI Scenario", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				PT_1.createInterfaceRealization("P_1", I_1);

				P_1 = CI_1.createOwnedPort("P_1", PT_1);
				ZDLUtil.addZDLConcept(P_1, ZMLMMNames.MESSAGE_PORT);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(addPortCommand,
			null, null);

		// make sure that SR2 doesn't accidentally have any workers, yet
		@SuppressWarnings("unchecked")
		List<Operation> sr2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(0, sr2Operations.size());
		
		@SuppressWarnings("unchecked")
		List<Operation> sr1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertEquals(2, sr1Operations.size());
		int found = 0;
		String body1 = "body text 1";
		String body2 = "body text 2";
		for (Operation next : sr1Operations) {
			if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1) {
				found |= 1;
				OperationHistoryFactory.getOperationHistory().execute(
					new SetBodyCommand(next, body1), null, null);
			} else if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2) {
				found |= 2;
				OperationHistoryFactory.getOperationHistory().execute(
					new SetBodyCommand(next, body2), null, null);
			}
			assertTrue(ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
		assertEquals("Not all workers found", 3, found);

		// copy the SR1 operations for comparison at the next stage
		sr1Operations = new java.util.ArrayList<Operation>(sr1Operations);

		// now, move the port
		AbstractTransactionalCommand movePortCommand = new AbstractTransactionalCommand(
			domain, "Move port from CI1 to CI2", Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {

				CI_2.getOwnedAttributes().add(P_1);

				return CommandResult.newOKCommandResult();
			}

		};
		OperationHistoryFactory.getOperationHistory().execute(movePortCommand,
			null, null);

		// the old workers are not moved, but newly re-created
		@SuppressWarnings("unchecked")
		List<Operation> newSR2Operations = (List<Operation>) ZDLUtil.getValue(
			SR_2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertFalse("Workers were moved", newSR2Operations
			.containsAll(sr1Operations));
		assertEquals("Wrong number of operations in SR2", 2, newSR2Operations.size());

		// check that the new workers do not have any body text
		assertEquals(2, newSR2Operations.size());
		found = 0;
		for (Operation next : newSR2Operations) {
			if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_1) {
				found |= 1;
				assertNull("Worker retained its body text", ZDLUtil
					.getValue(next, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__BODY));
			} else if (ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION) == OP_2) {
				found |= 2;
				assertNull("Worker retained its body text", ZDLUtil
					.getValue(next, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__BODY));
			}
			assertTrue(ZDLUtil.getValue(next, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == P_1);
		}
		assertEquals("Not all workers found", 3, found);

		// the first SR no longer has any workers
		@SuppressWarnings("unchecked")
		List<Operation> newSR1Operations = (List<Operation>) ZDLUtil.getValue(
			SR_1, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		assertTrue("SR1 still has worker functions", newSR1Operations.isEmpty());
	}

	//
	// Nested classes
	//

	private class SetBodyCommand
			extends AbstractTransactionalCommand {

		private String body;

		private Operation workerFunction;

		SetBodyCommand(Operation workerFunction, String body) {
			super(domain, "Set Worker Body", null);
			this.body = body;
			this.workerFunction = workerFunction;
		}

		@Override
		protected CommandResult doExecuteWithResult(
				IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {

			ZDLUtil.setValue(workerFunction, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__BODY, body);
			return CommandResult.newOKCommandResult();
		}

	}
	
}
