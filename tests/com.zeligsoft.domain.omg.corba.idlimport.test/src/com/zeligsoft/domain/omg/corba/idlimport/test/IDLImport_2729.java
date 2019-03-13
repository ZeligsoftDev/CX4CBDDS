/**
 * 
 */
package com.zeligsoft.domain.omg.corba.idlimport.test;

/**
 * Duplicate interface name already in the tool blocks interface import.
 * 
 * @author Toby McClean
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2729 extends IDLImportTestCase {

	public void test2729() {
		String idlFile = "idl/interface.idl";
		boolean importOk = importIDL(idlFile);

		// make sure that there were no issues
		assertTrue(importOk);

		// make sure that there is only one element under the root
		// model element
		assertTrue(this.model.getPackagedElements().size() == 1);

		// repeat the import
		importOk = importIDL(idlFile);

		assertTrue(importOk);

		// make sure that there is only one element under the root
		// model element
		assertTrue(String.format(
				"There are more elements (%d) in the model than expected.", model
						.getPackagedElements().size()), model.getPackagedElements()
				.size() == 1);
	}
}
