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
package com.zeligsoft.domain.zml.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * The class <code>WorkerFunctionUtilTest</code> contains tests for the class <code>{@link WorkerFunctionUtil}</code>.
 *
 * @author Toby McClean (tmcclean)
 */
@SuppressWarnings("static-access")
public class WorkerFunctionUtilTest {
	private static final String IMPLEMENTATION_DEFAULT_NAME = "myWorkerFunctionImpl"; //$NON-NLS-1$
	private static final String IMPLEMENTATION_DEFAULT_NAME_FORMAT = IMPLEMENTATION_DEFAULT_NAME + "%d"; //$NON-NLS-1$
	private static final String TEST_RESOURCE_URI = "http://workerfunction.emx"; //$NON-NLS-1$
	protected static final String ZML_PROFILE_URI = "pathmap://ZML_PROFILES/ZML.profile.uml"; //$NON-NLS-1$
	private ResourceSet rset;
	private Resource profile;
	private Profile zml;
	private Resource testResource;
	private org.eclipse.uml2.uml.Package testPackage;
	private org.eclipse.uml2.uml.Interface i_1;
	private org.eclipse.uml2.uml.Interface i_2;
	private org.eclipse.uml2.uml.Interface i_3;
	private org.eclipse.uml2.uml.Class pt_1;
	private org.eclipse.uml2.uml.Class pt_2;
	private Component ci_1;
	private Component ci_2;
	private Component sr_1;
	private Component sr_2;
	private Component sr_3;
	private TransactionalEditingDomain domain;
	private PortOperationsTrigger portOperationsSemProc;

	/**
	 * Run the void destroyWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testDestroyWorkerFunctionImpls_WithNull()
		throws Exception {
		WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		
		try {
			fixture.destroyWorkerFunctionImpls(null);
		} catch (IllegalArgumentException ex) {
			// nothing to do
			return;
		}
		
		Assert.fail("Expecting to fail because a null was passed in."); //$NON-NLS-1$
	}

	/**
	 * Run the void destroyWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testDestroyWorkerFunctionImpls_NotWorkerFunction() {
		WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		
		Command addOpCommand = new RecordingCommand(this.domain) {
			
			@Override
			protected void doExecute() {
				sr_1.createOwnedOperation("notAWorkerFunction", null, null); //$NON-NLS-1$
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
		
		Operation notWorkerFunction = sr_1.getOperation("notAWorkerFunction", null, null); //$NON-NLS-1$
		assertNotNull(notWorkerFunction);
		
		try {
			fixture.destroyWorkerFunctionImpls(notWorkerFunction);
		} catch(IllegalArgumentException ex) {
			return;
		}
		
		Assert.fail("Expecting to fail because object passed was not a worker function."); //$NON-NLS-1$
	}

	/**
	 * Run the void destroyWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testDestroyWorkerFunctionImpls_NoImplementations()
		throws Exception {
		WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				EObject newOp = ZDLUtil.createZDLConcept(sr_1, 
						ZMLMMNames.STRUCTURAL_REALIZATION, 
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER, 
						ZMLMMNames.WORKER_FUNCTION);
				ZDLUtil.setValue(newOp, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						"myWorkerFunction"); //$NON-NLS-1$
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
		
		Operation workerFunction = sr_1.getOperation("myWorkerFunction", null, null); //$NON-NLS-1$
		assertNotNull(workerFunction);
		
		Object rawImpls = ZDLUtil.getValue(sr_1, 
				ZMLMMNames.STRUCTURAL_REALIZATION, 
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL);
		assertNotNull(rawImpls);
		assertTrue(rawImpls instanceof Collection);
		Collection<?> impls = (Collection<?>) rawImpls;
		assertTrue(impls.isEmpty());
		
		try {
			fixture.destroyWorkerFunctionImpls(workerFunction);
		} catch(IllegalArgumentException ex) {
			Assert.fail("Should not throw any exceptions since it is a valid worker function"); //$NON-NLS-1$
		}
	}
	
	/**
	 * Run the void destroyWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testDestroyWorkerFunctionImpls_OneImplementation()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				EObject newOp = ZDLUtil.createZDLConcept(sr_1, 
						ZMLMMNames.STRUCTURAL_REALIZATION, 
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER, 
						ZMLMMNames.WORKER_FUNCTION);
				ZDLUtil.setValue(newOp, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						"myWorkerFunction"); //$NON-NLS-1$
				EObject newImpl = ZDLUtil.createZDLConcept(sr_1, 
						ZMLMMNames.STRUCTURAL_REALIZATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL,
						ZMLMMNames.WORKER_FUNCTION_IMPL);
				ZDLUtil.setValue(newImpl, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						"myWorkerFunctionImpl"); //$NON-NLS-1$
				ZDLUtil.setValue(newImpl, 
						ZMLMMNames.WORKER_FUNCTION_IMPL, 
						ZMLMMNames.WORKER_FUNCTION_IMPL__WORKER_FUNCTION, 
						newOp);
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
		
		final Operation workerFunction = sr_1.getOperation("myWorkerFunction", null, null); //$NON-NLS-1$
		assertNotNull(workerFunction);
		
		Object rawImpls = ZDLUtil.getValue(sr_1, 
				ZMLMMNames.STRUCTURAL_REALIZATION, 
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL);
		assertNotNull(rawImpls);
		assertTrue(rawImpls instanceof Collection);
		Collection<?> impls = (Collection<?>) rawImpls;
		assertEquals(1, impls.size());
		
		try {
			Command destroyCommand = new RecordingCommand(this.domain) {

				@Override
				protected void doExecute() {
					fixture.destroyWorkerFunctionImpls(workerFunction);
				}
			};
			domain.getCommandStack().execute(destroyCommand);
		} catch(IllegalArgumentException ex) {
			Assert.fail("Should not throw any exceptions since it is a valid worker function"); //$NON-NLS-1$
		}
		
		rawImpls = ZDLUtil.getValue(sr_1, 
				ZMLMMNames.STRUCTURAL_REALIZATION, 
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL);
		assertNotNull(rawImpls);
		assertTrue(rawImpls instanceof Collection);
		impls = (Collection<?>) rawImpls;
		assertEquals(0, impls.size());
	}
	
	/**
	 * Run the void destroyWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testDestroyWorkerFunctionImpls_MultipleImplementations()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final int numberOfImpls = 3;
		final String workerFunctionName = "myMultipleImplWF"; //$NON-NLS-1$
		createWorkerFunctionImplementations(workerFunctionName, numberOfImpls, sr_1);
		
		final Operation workerFunction = sr_1.getOperation(workerFunctionName, null, null);
		assertNotNull(workerFunction);
		
		Object rawImpls = ZDLUtil.getValue(sr_1, 
				ZMLMMNames.STRUCTURAL_REALIZATION, 
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL);
		assertNotNull(rawImpls);
		assertTrue(rawImpls instanceof Collection);
		Collection<?> impls = (Collection<?>) rawImpls;
		assertEquals(numberOfImpls, impls.size());
		
		try {
			Command destroyCommand = new RecordingCommand(this.domain) {

				@Override
				protected void doExecute() {
					fixture.destroyWorkerFunctionImpls(workerFunction);
				}
			};
			domain.getCommandStack().execute(destroyCommand);
		} catch(IllegalArgumentException ex) {
			Assert.fail("Should not throw any exceptions since it is a valid worker function"); //$NON-NLS-1$
		}
		
		rawImpls = ZDLUtil.getValue(sr_1, 
				ZMLMMNames.STRUCTURAL_REALIZATION, 
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL);
		assertNotNull(rawImpls);
		assertTrue(rawImpls instanceof Collection);
		impls = (Collection<?>) rawImpls;
		assertEquals(0, impls.size());
	}

	

	/**
	 * Run the List<EObject> getWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetWorkerFunctionImpls_Null()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		EObject workerFunction = null;
		
		try {
		fixture.getWorkerFunctionImpls(workerFunction);
		} catch(IllegalArgumentException ex) {
			return;
		}
		
		Assert.fail("Should have thrown an IllegalArgumentException"); //$NON-NLS-1$
	}

	/**
	 * Run the List<EObject> getWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetWorkerFunctionImpls_NotAWorkerFunction()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String operationName = "notAWorkerFunction";  //$NON-NLS-1$
		
		createOperation(operationName, sr_1);
		
		Operation notWorkerFunction = getOperation(operationName, sr_1);
		
		try {
			fixture.getWorkerFunctionImpls(notWorkerFunction);
		} catch(IllegalArgumentException ex) {
			return;
		}
		
		Assert.fail("Expecting to fail because object passed was not a worker function."); //$NON-NLS-1$
	}

	

	/**
	 * Run the List<EObject> getWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetWorkerFunctionImpls_NoImplementations()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName = "testGetWorkerFunctionImpls_NoImplementations"; //$NON-NLS-1$
		
		createWorkerFunctionCommand(workerFunctionName, sr_1);
		
		final Operation wf = getOperation(workerFunctionName, sr_1);
		try{
			List<EObject> wrImpls = fixture.getWorkerFunctionImpls(wf);
			assertNotNull(wrImpls);
			assertTrue(wrImpls.isEmpty());
		} catch(Exception ex) {
			Assert.fail(String.format("Wasn't expecting exection: %s", ex.getMessage())); //$NON-NLS-1$
		}
	}

	/**
	 * Run the List<EObject> getWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetWorkerFunctionImpls_OneImplementation()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName0 = "testGetWorkerFunctionImpls_OneImplementation"; //$NON-NLS-1$
		final int workerFunction0NumImpls = 1;
		createWorkerFunctionImplementations(workerFunctionName0, workerFunction0NumImpls, sr_1);
		
		final Operation wf0 = getOperation(workerFunctionName0, sr_1);
		try {
			List<EObject> wf0Impls = fixture.getWorkerFunctionImpls(wf0);
			assertNotNull(wf0Impls);
			assertEquals(workerFunction0NumImpls, wf0Impls.size());
		} catch (IllegalArgumentException e) {
			Assert.fail("Not expecting an exception"); //$NON-NLS-1$
		}
	}

	/**
	 * Run the List<EObject> getWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetWorkerFunctionImpls_MultipleImplementations()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName0 = "testGetWorkerFunctionImpls_MultipleImplementations"; //$NON-NLS-1$
		final int workerFunction0NumImpls = 5;
		createWorkerFunctionImplementations(workerFunctionName0, workerFunction0NumImpls, sr_1);
		
		final Operation wf0 = getOperation(workerFunctionName0, sr_1);
		try {
			List<EObject> wf0Impls = fixture.getWorkerFunctionImpls(wf0);
			assertNotNull(wf0Impls);
			assertEquals(workerFunction0NumImpls, wf0Impls.size());
		} catch (IllegalArgumentException e) {
			Assert.fail("Not expecting an exception"); //$NON-NLS-1$
		}
	}
	
	/**
	 * Run the List<EObject> getWorkerFunctionImpls(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetWorkerFunctionImpls_ImplementationsOnAnotherWorkerFunction()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName0 = "testGetWorkerFunctionImpls_ImplementationsOnAnotherWorkerFunction0"; //$NON-NLS-1$
		final String workerFunctionName1 = "testGetWorkerFunctionImpls_ImplementationsOnAnotherWorkerFunction1"; //$NON-NLS-1$
		final int workerFunction0NumImpls = 1;
		final int workerFunction1NumImpls = 2;
		
		createWorkerFunctionCommand(workerFunctionName0, sr_1);
		createWorkerFunctionImplementations(workerFunctionName1, workerFunction1NumImpls, sr_1);
				
		final Operation wf0 = getOperation(workerFunctionName0, sr_1);
		final Operation wf1 = getOperation(workerFunctionName1, sr_1);
		
		try {
			List<EObject> wf0Impls = fixture.getWorkerFunctionImpls(wf0);
			List<EObject> wf1Impls = fixture.getWorkerFunctionImpls(wf1);
			
			assertEquals(0, wf0Impls.size());
			assertEquals(workerFunction1NumImpls, wf1Impls.size());
			
			createWorkerFunctionImplementations(wf0, workerFunctionName0, workerFunction0NumImpls, sr_1);
			
			wf0Impls = fixture.getWorkerFunctionImpls(wf0);
			assertEquals(workerFunction0NumImpls, wf0Impls.size());
		} catch(IllegalArgumentException ex) {
			Assert.fail("Not expecting to get an exception"); //$NON-NLS-1$
		}
	}

	/**
	 * Run the boolean hasWorkerFunctionImplementation(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testHasWorkerFunctionImplementation_NoWorkerFunctions()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName = "testHasWorkerFunctionImplementation_NoWorkerFunctions"; //$NON-NLS-1$
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				EObject newOp = ZDLUtil.createZDLConcept(sr_1, 
						ZMLMMNames.STRUCTURAL_REALIZATION, 
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER, 
						ZMLMMNames.WORKER_FUNCTION);
				ZDLUtil.setValue(newOp, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						workerFunctionName); 
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
		
		final Operation workerFunction = sr_1.getOperation(workerFunctionName, null, null);
		assertNotNull(workerFunction);
		assertTrue(!fixture.hasWorkerFunctionImplementation(workerFunction));
	}

	/**
	 * Run the boolean hasWorkerFunctionImplementation(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testHasWorkerFunctionImplementation_WithWorkerFunctions()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName = "testHasWorkerFunctionImplementation_WithWorkerFunctions"; //$NON-NLS-1$
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				EObject newOp = ZDLUtil.createZDLConcept(sr_1, 
						ZMLMMNames.STRUCTURAL_REALIZATION, 
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER, 
						ZMLMMNames.WORKER_FUNCTION);
				ZDLUtil.setValue(newOp, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						workerFunctionName);
				EObject newImpl = ZDLUtil.createZDLConcept(sr_1, 
						ZMLMMNames.STRUCTURAL_REALIZATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL,
						ZMLMMNames.WORKER_FUNCTION_IMPL);
				ZDLUtil.setValue(newImpl, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						workerFunctionName+"Impl"); //$NON-NLS-1$
				ZDLUtil.setValue(newImpl, 
						ZMLMMNames.WORKER_FUNCTION_IMPL, 
						ZMLMMNames.WORKER_FUNCTION_IMPL__WORKER_FUNCTION, 
						newOp);
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
		
		final Operation workerFunction = sr_1.getOperation(workerFunctionName, null, null);
		assertNotNull(workerFunction);
		assertTrue(fixture.hasWorkerFunctionImplementation(workerFunction));
	}
	
	/**
	 * Run the boolean hasWorkerFunctionImplementation(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testHasWorkerFunctionImplementation_NotAWorkerFunction()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName = "testHasWorkerFunctionImplementation_NotAWorkerFunction"; //$NON-NLS-1$
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				sr_1.createOwnedOperation(workerFunctionName, null, null);
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
		
		final Operation workerFunction = sr_1.getOperation(workerFunctionName, null, null);
		assertNotNull(workerFunction);
		try {
			fixture.hasWorkerFunctionImplementation(workerFunction);
		} catch(IllegalArgumentException ex) {
			return;
		}
		
		Assert.fail("Should have thrown an illegal argument exception."); //$NON-NLS-1$
	}
	
	/**
	 * Run the boolean hasWorkerFunctionImplementation(EObject) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testHasWorkerFunctionImplementation_Null()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		try {
			fixture.hasWorkerFunctionImplementation(null);
		} catch(IllegalArgumentException ex) {
			return;
		}
		
		Assert.fail("Should have thrown an illegal argument exception."); //$NON-NLS-1$
	}

	/**
	 * Run the void renameWorkerFunctionImpls(EObject,String,String) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testRenameWorkerFunctionImpls_Null()
		throws Exception {
		WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		EObject workerFunction = null;
		String oldWorkerFunctionName = "wfOrig"; //$NON-NLS-1$
		String newWorkerFunctionName = "wfNew"; //$NON-NLS-1$
		
		try {
			fixture.renameWorkerFunctionImpls(workerFunction,
					oldWorkerFunctionName, newWorkerFunctionName);
		} catch (IllegalArgumentException e) {
			return;
		}
		
		Assert.fail("Was expecting an IllegalArgumentException"); //$NON-NLS-1$
	}

	/**
	 * Run the void renameWorkerFunctionImpls(EObject,String,String) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testRenameWorkerFunctionImpls_NotWorkerFunction()
		throws Exception {
		WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		EObject workerFunction = null;
		String oldWorkerFunctionName = "wfOld"; //$NON-NLS-1$
		String newWorkerFunctionName = "wfNew"; //$NON-NLS-1$
		
		createOperation(oldWorkerFunctionName, sr_1);
		workerFunction = getOperation(oldWorkerFunctionName, sr_1);
		assertNotNull(workerFunction);
		
		try {
			fixture.renameWorkerFunctionImpls(workerFunction, oldWorkerFunctionName, newWorkerFunctionName);
		} catch (IllegalArgumentException e) {
			return;
		}

		Assert.fail("Should have thrown and exception when trying to rename a worker function which is not actual a worker function."); //$NON-NLS-1$
	}

	/**
	 * Run the void renameWorkerFunctionImpls(EObject,String,String) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testRenameWorkerFunctionImpls_NormalPath()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String oldWorkerFunctionName = "wfOld"; //$NON-NLS-1$
		final String newWorkerFunctionName = "wfNew"; //$NON-NLS-1$
		
		createWorkerFunctionCommand(oldWorkerFunctionName, sr_1);
		final Operation workerFunction = getOperation(oldWorkerFunctionName, sr_1);
		assertNotNull(workerFunction);
		createWorkerFunctionImplementations(workerFunction, oldWorkerFunctionName, 1, sr_1);
		final Behavior workerFunctionImpl = getWorkerFunctionImpl(
				String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, 0), sr_1);
		assertNotNull(workerFunctionImpl);
		
		try {
			Command command = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					workerFunctionImpl.setName(fixture.workerFunctionImplDefaultName(oldWorkerFunctionName));
					fixture.renameWorkerFunctionImpls(workerFunction, oldWorkerFunctionName, newWorkerFunctionName);
				}
			};
			domain.getCommandStack().execute(command);
		} catch(Exception e) {
			Assert.fail(String.format("Should not throw an exception: ", e.toString())); //$NON-NLS-1$
		}
		
		final Behavior workerFunctionImpl2 = getWorkerFunctionImpl(
				 fixture.workerFunctionImplDefaultName(newWorkerFunctionName), sr_1);
		 assertNotNull(workerFunctionImpl2);
	}

	/**
	 * Run the String workerFunctionImplDefaultName(String) method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testWorkerFunctionImplDefaultName_NotDefaultImplName()
		throws Exception {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String oldWorkerFunctionName = "wfOld"; //$NON-NLS-1$
		final String newWorkerFunctionName = "wfNew"; //$NON-NLS-1$
		
		createWorkerFunctionCommand(oldWorkerFunctionName, sr_1);
		final Operation workerFunction = getOperation(oldWorkerFunctionName, sr_1);
		assertNotNull(workerFunction);
		createWorkerFunctionImplementations(workerFunction, oldWorkerFunctionName, 1, sr_1);
		final Behavior workerFunctionImpl = getWorkerFunctionImpl(
				String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, 0), sr_1);
		assertNotNull(workerFunctionImpl);
		
		try {
			Command command = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					fixture.renameWorkerFunctionImpls(workerFunction, oldWorkerFunctionName, newWorkerFunctionName);
				}
			};
			domain.getCommandStack().execute(command);
		} catch(Exception e) {
			Assert.fail(String.format("Should not throw an exception: ", e.toString())); //$NON-NLS-1$
		}
		
		final Behavior workerFunctionImpl2 = getWorkerFunctionImpl(
				String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, 0), sr_1);
		 assertNotNull(workerFunctionImpl2);
	}

	@Test
	public void testSetWorkerImplCode() {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName = "wf"; //$NON-NLS-1$
		final String code = "//my code"; //$NON-NLS-1$
		final String language = "C++"; //$NON-NLS-1$
		
		createWorkerFunctionCommand(workerFunctionName, sr_1);
		final Operation workerFunction = getOperation(workerFunctionName, sr_1);
		assertNotNull(workerFunction);
		createWorkerFunctionImplementations(workerFunction, workerFunctionName, 1, sr_1);
		final Behavior workerFunctionImpl = getWorkerFunctionImpl(
				String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, 0), sr_1);
		assertNotNull(workerFunctionImpl);
		
		try {
			Command command = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					fixture.setWorkerFunctionImplementationCode(sr_1, workerFunction, language, code);
				}
			};
			domain.getCommandStack().execute(command);
		} catch(Exception e) {
			Assert.fail(String.format("Should not throw an exception: ", e.toString())); //$NON-NLS-1$
		}
	}
	
	@Test
	public void testGetWorkerImplCode() {
		final WorkerFunctionUtil fixture = WorkerFunctionUtil.INSTANCE;
		final String workerFunctionName = "wf"; //$NON-NLS-1$
		final String code = "//my code"; //$NON-NLS-1$
		final String language = "C++"; //$NON-NLS-1$
		
		createWorkerFunctionCommand(workerFunctionName, sr_1);
		final Operation workerFunction = getOperation(workerFunctionName, sr_1);
		assertNotNull(workerFunction);
		createWorkerFunctionImplementations(workerFunction, workerFunctionName, 1, sr_1);
		final Behavior workerFunctionImpl = getWorkerFunctionImpl(
				String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, 0), sr_1);
		assertNotNull(workerFunctionImpl);
		
		try {
			Command command = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					fixture.setWorkerFunctionImplementationCode(sr_1, workerFunction, language, code);
				}
			};
			domain.getCommandStack().execute(command);
		} catch(Exception e) {
			Assert.fail(String.format("Should not throw an exception: ", e.toString())); //$NON-NLS-1$
		}
		
		final String codeBlock = fixture.getWorkerFunctionImplementationCode(sr_1, workerFunction, language);
		
		assertTrue(code.equals(codeBlock));
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 */
	@Before
	public void setUp()
		throws Exception {
		rset = new ResourceSetImpl();
		profile = rset.getResource(URI.createURI(ZML_PROFILE_URI), true);
		zml = (Profile) EcoreUtil.getObjectByType(profile.getContents(), UMLPackage.Literals.PROFILE);
		assertNotNull("No ZML profile", zml); //$NON-NLS-1$
		
		testResource = rset.createResource(URI.createURI(TEST_RESOURCE_URI));
		
		assertNotNull("Unable to create test resource", testResource); //$NON-NLS-1$
		
		testPackage = UMLFactory.eINSTANCE.createPackage();
		testPackage.setName("test"); //$NON-NLS-1$
		testResource.getContents().add(testPackage);
		testPackage.applyProfile(zml);
		
		i_1 = (org.eclipse.uml2.uml.Interface) testPackage.createOwnedType("I_1", //$NON-NLS-1$
				UMLPackage.Literals.INTERFACE);
		ZDLUtil.addZDLConcept(i_1, ZMLMMNames.INTERFACE);
		i_1.createOwnedOperation("OP_1", null, null); //$NON-NLS-1$
		i_1.createOwnedOperation("OP_2", null, null); //$NON-NLS-1$

		i_2 = (org.eclipse.uml2.uml.Interface) testPackage.createOwnedType("I_2", //$NON-NLS-1$
				UMLPackage.Literals.INTERFACE);
		ZDLUtil.addZDLConcept(i_2, ZMLMMNames.INTERFACE);
		i_2.createOwnedOperation("OP_3", null, null); //$NON-NLS-1$
		i_2.createOwnedOperation("OP_4", null, null); //$NON-NLS-1$

		i_3 = (org.eclipse.uml2.uml.Interface) testPackage.createOwnedType("I_3", //$NON-NLS-1$
			UMLPackage.Literals.INTERFACE);
		ZDLUtil.addZDLConcept(i_3, ZMLMMNames.INTERFACE);
		i_3.createOwnedOperation("OP_5", null, null); //$NON-NLS-1$

		pt_1 = testPackage.createOwnedClass("PT_1", false); //$NON-NLS-1$
		ZDLUtil.addZDLConcept(pt_1, ZMLMMNames.PORT_TYPE);
		pt_2 = testPackage.createOwnedClass("PT_2", false); //$NON-NLS-1$
		ZDLUtil.addZDLConcept(pt_2, ZMLMMNames.PORT_TYPE);

		ci_1 = (Component) testPackage.createOwnedType("CI_1", //$NON-NLS-1$
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(ci_1, ZMLMMNames.COMPONENT_INTERFACE);
		ci_2 = (Component) testPackage.createOwnedType("CI_2", //$NON-NLS-1$
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(ci_2, ZMLMMNames.COMPONENT_INTERFACE);

		sr_1 = (Component) testPackage.createOwnedType("SR_1", //$NON-NLS-1$
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(sr_1, ZMLMMNames.STRUCTURAL_REALIZATION);
		sr_2 = (Component) testPackage.createOwnedType("SR_2", //$NON-NLS-1$
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(sr_2, ZMLMMNames.STRUCTURAL_REALIZATION);
		sr_3 = (Component) testPackage.createOwnedType("SR_3", //$NON-NLS-1$
			UMLPackage.Literals.COMPONENT);
		ZDLUtil.addZDLConcept(sr_3, ZMLMMNames.STRUCTURAL_REALIZATION);

		domain = TransactionalEditingDomain.Factory.INSTANCE
			.createEditingDomain(rset);
		portOperationsSemProc = new PortOperationsTrigger();
		domain.addResourceSetListener(portOperationsSemProc);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 */
	@After
	public void tearDown()
		throws Exception {
		domain.removeResourceSetListener(portOperationsSemProc);
		ci_1 = ci_2 = null;
		sr_1 = sr_2 = null;
		i_1 = i_2 = i_3 = null;
		pt_1 = pt_2 = null;
		
		for(Resource res : rset.getResources()) {
			res.unload();
		}
		
		rset = null;
	}
	
	/**
	 * 
	 */
	private void createOperation(final String workerFunctionName, final Component structuralRealization) {
		Command command = new RecordingCommand(this.domain) {
			
			@Override
			protected void doExecute() {
				structuralRealization.createOwnedOperation(workerFunctionName, null, null);
			}
		};
		
		domain.getCommandStack().execute(command);
	}
	
	private void createWorkerFunctionCommand(final String workerFunctionName, final Component structuralRealization) {
		Command command = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				EObject newOp = ZDLUtil.createZDLConcept(structuralRealization, 
						ZMLMMNames.STRUCTURAL_REALIZATION, 
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER, 
						ZMLMMNames.WORKER_FUNCTION);
				ZDLUtil.setValue(newOp, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						workerFunctionName); 
			}
		};
		domain.getCommandStack().execute(command);
	}
	
	private void createWorkerFunctionImplementations(
			final String workerFunctionName, final int numberOfImpls,
			final EObject structuralRealization) {
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				EObject newOp = ZDLUtil.createZDLConcept(structuralRealization, 
						ZMLMMNames.STRUCTURAL_REALIZATION, 
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER, 
						ZMLMMNames.WORKER_FUNCTION);
				ZDLUtil.setValue(newOp, 
						ZMLMMNames.NAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME, 
						workerFunctionName); 
				for(int i = 0; i < numberOfImpls; i++) {
					EObject newImpl = ZDLUtil.createZDLConcept(sr_1, 
							ZMLMMNames.STRUCTURAL_REALIZATION,
							ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL,
							ZMLMMNames.WORKER_FUNCTION_IMPL);
					ZDLUtil.setValue(newImpl, 
							ZMLMMNames.NAMED_ELEMENT, 
							ZMLMMNames.NAMED_ELEMENT__NAME, 
							String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, i));
					ZDLUtil.setValue(newImpl, 
							ZMLMMNames.WORKER_FUNCTION_IMPL, 
							ZMLMMNames.WORKER_FUNCTION_IMPL__WORKER_FUNCTION, 
							newOp);
				}
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
	}
	
	private void createWorkerFunctionImplementations(final Operation workerFunction,
			final String workerFunctionName, final int numberOfImpls,
			final EObject structuralRealization) {
		Command addOpCommand = new RecordingCommand(this.domain) {
			@Override
			protected void doExecute() {
				for(int i = 0; i < numberOfImpls; i++) {
					EObject newImpl = ZDLUtil.createZDLConcept(sr_1, 
							ZMLMMNames.STRUCTURAL_REALIZATION,
							ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL,
							ZMLMMNames.WORKER_FUNCTION_IMPL);
					ZDLUtil.setValue(newImpl, 
							ZMLMMNames.NAMED_ELEMENT, 
							ZMLMMNames.NAMED_ELEMENT__NAME, 
							String.format(IMPLEMENTATION_DEFAULT_NAME_FORMAT, i));
					ZDLUtil.setValue(newImpl, 
							ZMLMMNames.WORKER_FUNCTION_IMPL, 
							ZMLMMNames.WORKER_FUNCTION_IMPL__WORKER_FUNCTION, 
							workerFunction);
				}
			}
		};
		
		domain.getCommandStack().execute(addOpCommand);
	}
	
	private static Operation getOperation(final String workerFunctionName, 
			final Component structuralRealization) {
		Operation workerFunction = structuralRealization.getOperation(workerFunctionName, null, null); 
		assertNotNull(workerFunction);
		return workerFunction;
	}
	
	private static Behavior getWorkerFunctionImpl(final String implName, final Component structuralRealization) {
		Behavior impl = structuralRealization.getOwnedBehavior(implName);
		
		return impl;
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WorkerFunctionUtilTest.class);
	}
}