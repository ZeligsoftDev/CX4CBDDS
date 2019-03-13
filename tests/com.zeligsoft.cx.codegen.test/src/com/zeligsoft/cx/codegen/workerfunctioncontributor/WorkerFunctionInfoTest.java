package com.zeligsoft.cx.codegen.workerfunctioncontributor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.eclipse.uml2.uml.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionConfigurator;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionInfo;

/**
 * The class <code>WorkerFunctionInfoTest</code> contains tests for the class <code>{@link WorkerFunctionInfo}</code>.
 *
 * @generatedBy CodePro at 8/22/11 9:51 AM
 * @author zeligsoft
 * @version $Revision: 1.0 $
 */
public class WorkerFunctionInfoTest {
	/**
	 * Run the WorkerFunctionInfo(Operation) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testWorkerFunctionInfo_SingleParameterConstructor()
		throws Exception {
		Operation operation = EasyMock.createMock(Operation.class);

		EasyMock.replay(operation);

		WorkerFunctionInfo result = new WorkerFunctionInfo(operation);
		result.configure(operation);
		
		EasyMock.verify(operation);
		assertNotNull(result);
		assertEquals(operation, result.getOperation());
	}

	/**
	 * Run the WorkerFunctionInfo(Operation,Map<String,Object>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testWorkerFunctionInfo_TwoParameterConstructor()
		throws Exception {
		Operation operation = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		
		EasyMock.replay(operation);
		EasyMock.replay(data);

		WorkerFunctionInfo result = new WorkerFunctionInfo(operation, data);

		assertNotNull(result);
		
		result.configure(operation);
		
		EasyMock.verify(operation);
		EasyMock.verify(data);
		
		assertEquals(operation, result.getOperation());
	}

	/**
	 * Run the WorkerFunctionInfo(Operation,Map<String,Object>,WorkerFunctionConfigurator) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testWorkerFunctionInfo_ThreeParameterConstructor()
		throws Exception {
		Operation operation = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		WorkerFunctionConfigurator configurator = EasyMock.createMock(WorkerFunctionConfigurator.class);
		
		EasyMock.replay(operation);
		EasyMock.replay(data);
		EasyMock.replay(configurator);

		WorkerFunctionInfo result = new WorkerFunctionInfo(operation, data, configurator);

		EasyMock.verify(operation);
		EasyMock.verify(data);
		EasyMock.verify(configurator);
		assertNotNull(result);
		assertEquals(operation, result.getOperation());
	}

	/**
	 * Run the void configure(Operation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testConfigure_1()
		throws Exception {
		Operation workerFunction = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		WorkerFunctionConfigurator configurator = EasyMock.createMock(WorkerFunctionConfigurator.class);
		
		WorkerFunctionInfo fixture = 
			new WorkerFunctionInfo(workerFunction, data, configurator);
		
		configurator.configure(workerFunction, fixture);

		EasyMock.replay(configurator);

		fixture.configure(workerFunction);

		EasyMock.verify(configurator);
	}

	/**
	 * Run the Object getData(String,Class<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testGetData_NonNullValidKey()
		throws Exception {
		Operation workerFunction = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		WorkerFunctionConfigurator configurator = EasyMock.createMock(WorkerFunctionConfigurator.class);
		
		WorkerFunctionInfo fixture = 
			new WorkerFunctionInfo(workerFunction, data, configurator);
		
		EasyMock.expect(data.get("myKey")).andAnswer(new IAnswer<String>() { //$NON-NLS-1$
			@Override
			public String answer() {
				return "myValue"; //$NON-NLS-1$
			}
		});
		
		EasyMock.replay(data);
		
		String resultOfGet = fixture.getData("myKey", String.class); //$NON-NLS-1$
		
		EasyMock.verify(data);
		
		assertTrue(resultOfGet.equals("myValue")); //$NON-NLS-1$
	}

	/**
	 * Run the Object getData(String,Class<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testGetData_InvalidCast()
		throws Exception {
		Operation workerFunction = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		WorkerFunctionConfigurator configurator = EasyMock.createMock(WorkerFunctionConfigurator.class);
		
		WorkerFunctionInfo fixture = 
			new WorkerFunctionInfo(workerFunction, data, configurator);
		
		EasyMock.expect(data.get("myKey")).andAnswer(new IAnswer<String>() { //$NON-NLS-1$
			@Override
			public String answer() {
				return "myValue"; //$NON-NLS-1$
			}
		});
		
		EasyMock.replay(data);
		
		@SuppressWarnings("rawtypes")
		List resultOfGet = fixture.getData("myKey", List.class); //$NON-NLS-1$
		
		EasyMock.verify(data);
		
		assertEquals(resultOfGet, null);
	}
	
	/**
	 * Run the Object getData(String,Class<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testGetData_NullKey()
		throws Exception {
		Operation workerFunction = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		WorkerFunctionConfigurator configurator = EasyMock.createMock(WorkerFunctionConfigurator.class);
		
		WorkerFunctionInfo fixture = 
			new WorkerFunctionInfo(workerFunction, data, configurator);
		
		EasyMock.expect(data.get(null)).andAnswer(new IAnswer<Object>() {
			@Override
			public Object answer() {
				return null;
			}
		});
		
		EasyMock.replay(data);
		
		Object resultOfGet = fixture.getData(null, Object.class);
		
		EasyMock.verify(data);
		
		assertEquals(resultOfGet, null);
	}

	/**
	 * Run the Operation getOperation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Test
	public void testGetOperation_1()
		throws Exception {
		Operation workerFunction = EasyMock.createMock(Operation.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> data = EasyMock.createMock(Map.class);
		WorkerFunctionConfigurator configurator = EasyMock.createMock(WorkerFunctionConfigurator.class);
		
		WorkerFunctionInfo fixture = 
			new WorkerFunctionInfo(workerFunction, data, configurator);
		
		
		Operation result = fixture.getOperation();

		assertEquals(result, workerFunction);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// nothing to do
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		//nothing to do
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 8/22/11 9:51 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WorkerFunctionInfoTest.class);
	}
}