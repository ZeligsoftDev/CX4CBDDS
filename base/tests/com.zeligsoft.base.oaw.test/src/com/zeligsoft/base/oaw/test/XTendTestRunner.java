package com.zeligsoft.base.oaw.test;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowEngine;

@SuppressWarnings("nls")
public class XTendTestRunner {

	private static final String WorflowPath = "workflow/xtend-junit-workflow.oaw";
	private static final String XTendTopRuleSlotName = "xtend-rule";
	private static final String ResultSlotName = "result";
	private static final String ZdlMMUrisSlotName = "zdlMMZdlUris";
	private static final String EmfMMPackagesSlotName = "emfMMPackages";
/*
	private static final List<String> ZdlMMUris = new LinkedList<String>();
	static {
		IExtensionPoint ep = Platform.getExtensionRegistry().getExtensionPoint("com.zeligsoft.base.zdl.domain_models");
		for( IConfigurationElement ce : ep.getConfigurationElements() ) {
			String path = ce.getAttribute("path");
			URI uri = URI.createURI(path, true);
			ZdlMMUris.add( uri.toString() );
		}
	}
*/
	private static String prepareXTendTopRule( String rule, Map<String, Object> externalSlots, Object...vargs ) {

		int vargs_len = vargs.length;

		StringBuilder result = new StringBuilder(rule);
		result.append( '(' );
		for( int i = 0; i < vargs_len; ++i ) {
			String slotName = "arg_" + i;
			externalSlots.put( slotName, vargs[i] );
			if( i > 0 )
				result.append( ',' );
			result.append( slotName );
		}
		result.append( ')' );
		return result.toString();
	}

	private static String prepareStringList( Iterable<String> values ) {
		if( values == null )
			return "";
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for( String value : values ) {
			if( first )
				first = false;
			else
				result.append( ',' );
			result.append(value);
		}
		return result.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T run( Iterable<String> zdlMMUris, Iterable<String> emfMMPackages, String xtendRule, Object...vargs ) {

		Map<String, String> props = new HashMap<String, String>();
		props.put(ZdlMMUrisSlotName, prepareStringList(zdlMMUris));
		props.put(EmfMMPackagesSlotName, prepareStringList(emfMMPackages));

		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		props.put(XTendTopRuleSlotName, prepareXTendTopRule(xtendRule, externalSlotContents, vargs));

		WorkflowEngine runner = new WorkflowEngine();
		runner.run(WorflowPath, null, props, externalSlotContents);
		return (T)runner.getContext().get(ResultSlotName);
	}
}
