package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols;

/**
 * Net4j 'signals' sent to the Eclipse server (from the Rhapsody) client.
 *
 */
public enum EclipseServerSignals {
	
	/**
	 * Transform the current Rhapsody model to UML2
	 */
	TransformToUml2,
	/**
	 * Validate the current Rhapsody model, and asynchronously return results
	 */
	Validate,
	/**
	 * Generate code from the Rhapsody model (descriptors, idl or both)
	 */
	Generate,
	
	/**
	 * Test protocol for benchmarking...
	 */
	Benchmark,
	
	/**
	 * Expermimental 'fast' transformation
	 */
	FastTransform,
	
	/**
	 * Return the available code generators.
	 */
	GetGenerators,
	
	;
	
	/**
	 * The unique name of the Net4j 'protocol' that implements this signals.
	 */
	public static final String PROTOCOL_NAME = "CXEclipseServer";

}
