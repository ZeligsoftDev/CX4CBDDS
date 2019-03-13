package com.zeligsoft.domain.omg.corba.test;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer;
import com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest;

public class ValidationCoverageTest {
	
	@SuppressWarnings("nls")
	@Test
	public void testValidationCoverage() {
	
		URI modelURI = URI.createURI("platform:/plugin/com.zeligsoft.domain.omg.corba.test/models/validationModel.valModel");
		
		ResourceSet rset = new ResourceSetImpl();
		Resource r = rset.getResource(modelURI, true);
		TestContainer container = (TestContainer)r.getContents().get(0);
		
		int numFails = 0;
		StringBuilder failString = new StringBuilder();
		for( UnitTest test : container.getTests()) {
			if( test.isIsTested() == false ) {
				numFails++;
				failString.append("Constraint not covered: ");
				failString.append(test.getId());
				failString.append("\n");
			}
		}
		if( numFails > 0 ) {
			failString.insert(0, " constraints not covered:\n");
			failString.insert(0, numFails);
			failString.insert(0, "There are ");
			fail(failString.toString());
		}
	}
}
