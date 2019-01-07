package com.zeligsoft.domain.sca.build.test;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.ZeligsoftURIConverter;

public abstract class AbstractBuildTests extends TestCase {

	protected final static String SCA_DOMAIN = "SCADomain";
	protected final static String TEST_MODEL = "com.zeligsoft.domain.sca.build.test/models/SCABuildTestModel.emx";
	protected URI modelURI = null;
	protected ResourceSet resourceSet = null;	
	protected Resource resource = null;
	
	protected Package model = null;
	protected Profile scaProfile;
	
	protected Stereotype deploymentStereotype = null;
	protected Stereotype applicationStereotype  = null;
	protected Stereotype nodeStereotype = null;
	protected Stereotype componentStereotype = null;
	protected Stereotype deviceStereotype = null;
	
	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public AbstractBuildTests(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// needed resource set
		resourceSet = new ResourceSetImpl();
				
		// load the test model SCA Model
		modelURI = URI.createPlatformPluginURI(TEST_MODEL, true);		
		resource = resourceSet.getResource(modelURI, true);
		model = (Package) EcoreUtil.getObjectByType( resource.getContents(), 
				UMLPackage.Literals.PACKAGE );
		
		// ensure that URIs resolved from relative URIs are corrected to
		// eliminate '..' segments that cause unwanted resource aliasing
		ZeligsoftURIConverter.install( resourceSet );
		
		assertFalse(model.getAllAppliedProfiles().size() == 0);
		
		// get the SCA Profile		
		for (Profile profile : model.getAllAppliedProfiles()) {
			String name = profile.getName();
			if ( ( name != null ) && name.compareTo(SCA_DOMAIN) == 0) {
				scaProfile = profile;
				break;
			}
		}

		assertNotNull(scaProfile);
		
		// set up stereotypes.
		deploymentStereotype = null;
		applicationStereotype  = scaProfile.getOwnedStereotype("SCAApplication");
		nodeStereotype = scaProfile.getOwnedStereotype("SCANode");
		componentStereotype = scaProfile.getOwnedStereotype("SCAComponent");
		deviceStereotype = scaProfile.getOwnedStereotype("SCADevice");	
	}

	@Override
	protected void tearDown() throws Exception {
		
		// delete the project
		// refresh workspace
		// close the SCA Model
		model = null;
		
		super.tearDown();		
	}
	
}
