package com.zeligsoft.base.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import com.zeligsoft.base.util.AbstractDependencyGraph;

/**
 * A simple implementation of the AbstractDependencyGraph for strings to
 * be used for testing the AbstractDependencyGraph topological sort algorithm.
 *  * 
 * @author Tony Niro (tniro)
 */
public class StringDependencyGraph extends AbstractDependencyGraph<String> {
	
	LinkedHashMap<String,ArrayList<String>> dependencies = new LinkedHashMap<String,ArrayList<String>>();
	
	public StringDependencyGraph() {
		super();
	}


	boolean addDependency(String m, String n) {
		
		if (m == null || n == null)
			return false;
		
		ArrayList<String> values = dependencies.get(m);
		if (values == null) {
			values = new ArrayList<String>();
		} 

		values.add(n);
		dependencies.put(m, values);
		return true;
	}
	
	void reset() {
		dependencies.clear();
	}
	
	@SuppressWarnings("nls")
	void dump() {
		System.out.println("Terminals:");
		
		for (String t : getTerminalNodes()) {
			System.out.println("\t"+t);
		}
		
		System.out.println("Non-Terminals:");
		for (String t : getNonTerminalNodes()) {
			System.out.println("\t"+t);
		}
		
		System.out.println("Dependencies:");
		Set<String> keys = dependencies.keySet();
		
		for( String str : keys ) {
			ArrayList<String> values = dependencies.get(str);
			for( String dep : values ) {
				System.out.println("\t"+str+" : "+dep);
			}
		}
		
	}
	
	
	@Override
	protected Collection<String> getDependencies(String node){

		ArrayList<String> deps = dependencies.get(node);
		if (deps == null)
			deps = new ArrayList<String>();
		return deps;
	}
	
	@Override
	protected Collection<String> getNonTerminalNodes() {
		return dependencies.keySet();
	}
	
	@Override
	protected Collection<String> getTerminalNodes() {
		HashSet<String> nodes = new HashSet<String>();
		Set<String> keys = dependencies.keySet();
		
		for( String str : keys ) {
			ArrayList<String> values = dependencies.get(str);
			for( String dep : values ) {
				ArrayList<String> v = dependencies.get(dep);
				if (v == null)
					nodes.add(dep);
			}
		}
		
		return nodes;
	}
	
	// make protected functions available for testing..
	public Collection<String> getDependenciesX(String node) {
		return getDependencies(node);
	}
	
	public Collection<String> getNonTerminalNodesX() {
		return getNonTerminalNodes();
	}
	
	public Collection<String> getTerminalNodesX() {
		return getTerminalNodes();
	}
	
}
