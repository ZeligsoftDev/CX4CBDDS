package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

/**
 * Define the CX model services that a Rhapsody CX client can invoke.
 * These services are implemented in an Eclipse-based process distinct from
 * the Rhapsody instance.
 *
 */
public interface ICXModelServices {
	
	/**
	 * Transform the current Rhapsody project into an UML2 model.
	 * This method is likely for test purposes only.
	 */
	boolean transformToUML2(String modelName);

}
