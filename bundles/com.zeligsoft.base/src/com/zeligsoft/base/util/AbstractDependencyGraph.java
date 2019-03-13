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
package com.zeligsoft.base.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

import com.zeligsoft.base.l10n.Messages;

/**
 * An abstract class that creates a Dependency Graph for the given object
 * that will allow the user to execute an Topological Sort on the graph to
 * get the elements in the appropriate dependency order.
 * 
 * @param <E>
 *            the element type of the entity to determine the dependency graph
 * 
 * @author Tony Niro (tniro)
 */
public abstract class AbstractDependencyGraph<E> {
	
	// Basic Algorithm
	//
	// First, find a list of "start nodes" which have no incoming edges and insert them 
	// into a set S; at least one such node must exist if graph is acyclic
	//
	// L <-Empty list that will contain the sorted elements
	// S <-Set of all nodes with no incoming edges
	//
	// while S is non-empty do
	//	    remove a node n from S
	//	    insert n into L
	//	    for each node m with an edge e from n to m do
	//	        remove edge e from the graph
	//	        if m has no other incoming edges then
	//	            insert m into S
	// if graph has edges then
	//	    output error message (graph has at least one cycle)
	// else 
	//	    output message (proposed topologically sorted order: L)
	
	/**
	 * This class represents an edge in the graph, where m "depends on n.
	 */	
	private class Edge<X> {
		public X n = null;
		public X m = null;
		
		public Edge(X m, X n){
			this.n = n;
			this.m = m;
		}
	}

	// Dependency Graph
	private HashSet<Edge<E>> graph = new HashSet<Edge<E>>();
	
	// set (S) of nodes with no incoming edges (i.e. no dependencies)
	private LinkedHashSet<E> terminals = new LinkedHashSet<E>();
	
	// list (L) of nodes in topological order.
	private ArrayList<E> nodes = new ArrayList<E>();


	/**
	 * Get all nodes that have no dependencies (leaves)
	 */	
	abstract protected Collection<E> getTerminalNodes();
	
	/**
	 * Get all nodes that have dependencies
	 */	
	abstract protected Collection<E> getNonTerminalNodes();

	/**
	 * Get dependencies for the given node
	 */	
	abstract protected Collection<E> getDependencies(E n);


	/**
	 * Initialize the data structures required to do the sort
	 */	
	public boolean initialize() {
		
		// get terminal nodes, must have some...
		terminals.addAll(getTerminalNodes());
		if (terminals.isEmpty())
			return false;
		
		// get non terminal nodes
		Collection<E> nonterminals = getNonTerminalNodes();
		
		// build the graph
		for (E m : nonterminals) {
			Collection<E> depends = getDependencies(m);
			for (E n : depends) {
				Edge<E> edge = new Edge<E>(m, n);
				graph.add(edge);
			}
		}
		
		return true;
	}

	/**
	 * Determine the topological sort order for this graph.
	 * 
	 * @returns an ordered collection - least dependent to most dependent
	 */	
	public Collection<E> topologicalSort() throws CycleDetectedException {
		
		Collection<Edge<E>> tmpGraph = new HashSet<Edge<E>>();
		tmpGraph.addAll(graph);
		
		// build topological order
		while (!terminals.isEmpty()) {

			// remove node from (S) and add it the (L)
			E n = terminals.iterator().next();
			terminals.remove(n);
			nodes.add(n);
			
			for ( Edge<E> edge : tmpGraph ) {
				
				// find edge that has n as dependency
				if (edge.n.equals(n) ) {
					E m = edge.m;
					
					// remove this edge from the graph
					graph.remove(edge);
					
					// if m is not dependent on anything else
					// add it to the terminals
					if (graph.isEmpty()) {
						terminals.add(m);
					} else {
						boolean found = false;
						for ( Edge<E> edge2 : graph ) {
							if (edge2.m.equals(m)) {
								// m has another dependency, don't add
								found = true;
								break;
							}
						}
						if (!found) {		// m has no more dependencies, add it
							terminals.add(m);
						}
					}
				}
			}
		}
		
		// check if a cycle has been detected...
		if (!graph.isEmpty()) {
			StringBuilder message = new StringBuilder();
			message.append(Messages.Dependency_Graph_Cycle_Detected);
			for (Edge<E> edge : graph) {
				message.append(edge.m.toString());
				message.append(' ');
				message.append(Messages.Depends_On);
				message.append(' ');				
				message.append(edge.n.toString());
				message.append('\n');
			}
			throw new CycleDetectedException(message.toString());
		}
		
		return nodes;
	}
	
	/**
	 * Returns the ordered list of dependencies after a sort has been performed.
	 * Usually called if interested on what was available before a cycle was 
	 * detected:
	 *
	 * @returns an ordered collection - least dependent to most dependent
	 */
	protected Collection<E> getLastResult() {
		return nodes;
	}

	/**
	 * Returns the remaining elements in the graph after a sort was performed.
	 * Should be empty unless one or more cycles were detected.
	 * 
	 * @returns a list of the remaining elements in the graph
	 */
	protected Collection<E> getRemainingElements() {
		HashSet<E> remaining = new HashSet<E>();
		
		for ( Edge<E> edge : graph ) {
			remaining.add(edge.n);
			remaining.add(edge.m);
		}
		return remaining;
	}
	
}
