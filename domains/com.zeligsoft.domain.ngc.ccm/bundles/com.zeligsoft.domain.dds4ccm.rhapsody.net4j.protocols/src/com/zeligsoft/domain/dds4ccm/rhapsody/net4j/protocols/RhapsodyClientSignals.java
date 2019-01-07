package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols;

/**
 * Net4j 'signals' sent to the Rhapsody client (from the Eclipse server).
 * These messages are typically 'results' from asynchronous client requests.
 *
 */
public enum RhapsodyClientSignals {
	
	/**
	 * A simply asynchronous result, suitable for presentation in a dialog.
	 */
	AsyncResult;
	
	/**
	 * The unique name of the Net4j protocol that implements this signals.
	 */
	public static final String PROTOCOL_NAME = "CXRhapsodyClient";

}
