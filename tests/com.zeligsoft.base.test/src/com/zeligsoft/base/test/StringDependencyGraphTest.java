package com.zeligsoft.base.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Test;

import com.zeligsoft.base.util.CycleDetectedException;

/**
 * These test cases test the topological sorting algorithm of the AbstractDependencyGraph using the 
 * simple StringDependencyGraph implementation.
 *  * 
 * @author Tony Niro (tniro)
 */
@SuppressWarnings("nls")
public class StringDependencyGraphTest {

	private StringDependencyGraph graph = new StringDependencyGraph();
	
	/**
	 * @param name
	 */
	public StringDependencyGraphTest() {
		// Default constructor
	}

	/**
	 * Tests simple linear graph
	 */
	@Test
	public void test_LinearGraph() {
		String [] expected = new String[4];
		expected[0] = "D";
		expected[1] = "C";
		expected[2] = "B";
		expected[3] = "A";
		
		graph.addDependency("A", "B");
		graph.addDependency("B", "C");
		graph.addDependency("C", "D");
		
		try {
			assertTrue(graph.initialize());
			
			Collection<String> dependencies = graph.topologicalSort();
			assertNotNull(dependencies);
			
			assertEquals(expected.length, dependencies.size());
			
			int i = 0;
			for(String node : dependencies) {
				assertEquals(expected[i], node);
				i++;
			}
			
		} catch (CycleDetectedException e) {
			assertFalse(true);
		}
	}

	/**
	 * Tests simple multi-linear graph
	 */
	@Test
	public void test_MultiLinearGraph() {
		String [] expected = new String[4];
		expected[0] = "B";
		expected[1] = "C";
		expected[2] = "D";
		expected[3] = "A";
		
		graph.addDependency("A", "B");
		graph.addDependency("A", "C");
		graph.addDependency("A", "D");
		
		try {
			assertTrue(graph.initialize());
			
			Collection<String> dependencies = graph.topologicalSort();
			assertNotNull(dependencies);
			
			assertEquals(expected.length, dependencies.size());
			
			int i = 0;
			for(String node : dependencies) {
				assertEquals(expected[i], node);
				i++;
			}
			
		} catch (CycleDetectedException e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Tests a little more complex graph
	 */
	@Test
	public void test_ComplexGraph() {
	
		// finish this test case..
		
		graph.addDependency("A", "B");
		graph.addDependency("A", "C");
		graph.addDependency("A", "D");
		graph.addDependency("C", "D");
		graph.addDependency("C", "E");
		graph.addDependency("C", "F");
		graph.addDependency("F", "G");
		graph.addDependency("G", "H");
		graph.addDependency("I", "J");
		
		
		try {
			assertTrue(graph.initialize());
			graph.dump();

			Collection<String> dependencies = graph.topologicalSort();
			assertNotNull(dependencies);

			String [] objs = dependencies.toArray(new String[dependencies.size()]);
			
			// all terminals should be at the beginning of the list.
			Collection<String> terminals = graph.getTerminalNodesX();
			int count = 0;

			for( String n : terminals ) {
				for(int i = 0; i < terminals.size(); i++) {
					if ( n.equals(objs[i])) {
						count++;
					}
				}
			}
			
			// did we find all terminals
			assertEquals(terminals.size(),count);
			
			// validate that non-terminals are found after there dependencies
			Collection<String> nonterminals = graph.getNonTerminalNodesX();
			for ( String n : nonterminals ) {
				Collection<String> deps = graph.getDependenciesX(n);
				int [] locations = new int[deps.size()];
				int iloc = 0;
				
				// find location of dependencies.
				for (String d : deps) {
					for (int idep = 0; idep < objs.length; idep++) {
						if (d.equals(objs[idep])) {
							locations[iloc] = idep;
							break;
						}
					}
					iloc++;
				}
				
				// find location of non-terminal
				int test = 0;
				for (int i = 0; i < objs.length; i++) {
					if ( n.equals(objs[i])) {
						test = i;
						break;
					}
				}

				// make sure non-terminal has higher index then all of its dependents.
				for (int j = 0; j < locations.length; j++){
					assertTrue( test > locations[j]);
				}
			}
			
		} catch (CycleDetectedException e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Tests cycle detection exception
	 */
	@Test
	public void test_CycleDetection_1() {
		
		graph.addDependency("A", "B");
		graph.addDependency("A", "C");
		graph.addDependency("B", "A");
		
		try {
			assertTrue(graph.initialize());
			
			graph.topologicalSort();
			assertTrue(false);
			
		} catch (CycleDetectedException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Tests cycle detection exception
	 */
	@Test
	public void test_CycleDetection_2() {
		
		graph.addDependency("A", "B");
		graph.addDependency("B", "C");
		graph.addDependency("C", "A");
		graph.addDependency("E", "F");
		
		try {
			assertTrue(graph.initialize());
			
			graph.topologicalSort();
			assertTrue(false);
			
		} catch (CycleDetectedException e) {
			assertTrue(true);
		}
	}

	@After
	public void tearDown() throws Exception {
		graph.reset();
	}
	

}
