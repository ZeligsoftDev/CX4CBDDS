package test;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.omg.CORBA.Any;
import org.omg.CORBA.TCKind;

import CF.Application;
import CF.ApplicationFactory;
import CF.DataType;
import CF.Device;
import CF.DeviceAssignmentType;
import CF.FileManager;
import CF.FileSystem;
import CF.PropertiesHolder;
import CF.DeviceManagerPackage.ServiceType;
import CF.FileSystemPackage.FileInformationType;

import cxCorbaBridge.CorbaBridge;

public class CXCorbaBridgeTest extends TestCase {

	private static CorbaBridge cb;
	final private String profileFileName = "/dmTK/qpskAlignApp/qpskAlignApp.sad.xml";
	final private String appName = "qpskAlignApp";
	final private String applicationId = "DCE:c91845fb-e38b-41b6-a3d5-81c0e3b7fc1d";
	final private String appFactoryId = "DCE:c91845fb-e38b-41b6-a3d5-81c0e3b7fc1d";
	
	// Processing Node Identifier
	final String DEVMGR_ID = "DCE:9DDA4F7F-3D4D-4800-94A7-9855384A3C81";
	
	final private String rfProfileFileName = "/dmTK/ProcessingNode/RFTest/SCA_Application.sad.xml";
	final private String rfAppName = "SCA_Application";
	final private String rfApplicationId = "DCE:11aeefc4-1d65-41d2-923c-4662ce38b9a3";
	final private String rfAppFactoryId = "DCE:11aeefc4-1d65-41d2-923c-4662ce38b9a3";

	/**
	 * Creates my test suite.
	 * 
	 * @return my test suite
	 */
	public static Test suite() {
		return new TestSuite(CXCorbaBridgeTest.class, "CXCorbaBridgeTest Tests (CXCorbaBridge Tests)");
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		if (cb == null) {
			cb = new CorbaBridge("corbaloc:iiop:127.0.0.1:2810/NameService", "/dmTK/DomainManager",
					"/dmTK/DomainLog");
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/*******************************************************************************/
	/***************************** NamingService Tests *****************************/
	/*******************************************************************************/

	/**
	 * Test that the NamingService root context has been narrowed to
	 * NamingService PASS - rootcontext is not null FAIL - rootcontext is null
	 */
	public void test_getNamingServiceContext() {
		Assert.assertNotNull(cb.getNamingServiceContext());
	}

	/*******************************************************************************/
	/***************************** DomainManager Tests *****************************/
	/*******************************************************************************/

	/**
	 * PASS - DomainManager, Profile and identifier are not null FAIL -
	 * DomainManager, Profile or identifier is null
	 */
	public void test_getDomainManager() {
		Assert.assertNotNull(cb.getDomainManager());
		Assert.assertNotNull(cb.getDomainManager().domainManagerProfile());
		Assert.assertNotNull(cb.getDomainManager().identifier());
	}

	/*******************************************************************************/
	/***************************** DeviceManager Tests *****************************/
	/*******************************************************************************/

	/**
	 * Tests the getDeviceManager() method when an identifier is passed as an
	 * argument, 
	 * PASS - A valid identifier is used and deviceManager is found,
	 * PASS - An invalid identifier is used and deviceManager is not found, 
	 * FAIL - A valid identifier is used and deviceManager is not found, 
	 * FAIL - An invalid identifier is used and deviceManager is found
	 */
	public void test_getDeviceManager() {
		Assert.assertNotNull(cb.getDeviceManager(DEVMGR_ID)); // valid identifier
		Assert.assertNull(cb.getDeviceManager("")); // invalid identifier
	}

	
	/*******************************************************************************/
	/******************************** Device Tests *********************************/
	/*******************************************************************************/
	

	/**
	 * Tests the getDevice() method when a deviceManager and a device
	 * identifier are passed as arguments, 
	 * PASS - A valid deviceManager and identifier are used and the device is found, 
	 * PASS - An invalid identifier is used and the device is not found, 
	 * FAIL - A valid deviceManager and identifier are used and the device is not found, 
	 * FAIL - An invalid deviceManager and identifier are used and the device is found
	 * deviceManager is found
	 */
	public void test_getDevice() {
		// sigproc_exec_device1
		final String DEVICE_ID = "DCE:C2D15394-D319-4097-8E2E-271E37511E30";

		Assert.assertNotNull( cb.getDevice(DEVMGR_ID, DEVICE_ID) ); 
		Assert.assertNull( cb.getDevice(DEVMGR_ID, "")); 
	}

	
	/*******************************************************************************/
	/******************************** Service Tests ********************************/
	/*******************************************************************************/
	
	/**
	 * Services are optional PASS - There are no services OR ServiceType and
	 * ServiceName are not null, FAIL - ServiceType or ServiceName are null
	 */
	public void test_getService() {
		ServiceType service = cb.getService(DEVMGR_ID, "DomainLog");
		Assert.assertNotNull(service);
	}
	
	/*******************************************************************************/
	/****************************** Properties Tests *******************************/
	/*******************************************************************************/
	
	/**
	 * PASS - DomainManager properties length > 0
	 * FAIL - DomainManager properties length == 0
	 */
	public void test_getAllProperties() {		
		// query domainManager for all properties. 
		PropertiesHolder configProperties = cb.getProperties(cb.getDomainManager());
		Assert.assertTrue(configProperties.value.length > 0);
	}
	
	/**
	 * PASS - The SourceDevice's Interval configure property is returned with value == 10
	 * FAIL - The SourceDevice's Interval configure property is not found or value != 10
	 */
	public void test_getSpecificProperties() {		
		// sourceDevice
		final String DEVICE_ID = "DCE:698a5110-e913-47ee-9c35-3a18d43f993a";
		final String INTERVAL = "Interval";

		// get the device
		Device device = cb.getDevice(DEVMGR_ID, DEVICE_ID); 
		
		// set the id for the properties you want to receive
		DataType [] dataTypes = new DataType[1];	
		dataTypes[0] = new DataType(INTERVAL, org.omg.CORBA.ORB.init().create_any());
		PropertiesHolder configProperties = new PropertiesHolder(dataTypes);
		
		cb.getProperties(device, configProperties);
		DataType[] properties = configProperties.value;
		Any anAny = properties[0].value;
		
		Assert.assertTrue(properties[0].id.equalsIgnoreCase(INTERVAL));
		if(anAny.type().kind() == TCKind.tk_ulong) {
			long value = anAny.extract_ulong();
			Assert.assertTrue(value == 10);
		} else {
			Assert.fail("Property value incorrect");
		}
	}
	
	
	/**
	 * PASS - The SourceDevice's Interval configure property is set to 50
	 * FAIL - The SourceDevice's Interval configure property is not found or value != 50
	 */
	public void test_setProperties()
	{
		// sourceDevice
		final String DEVICE_ID = "DCE:698a5110-e913-47ee-9c35-3a18d43f993a";
		final String INTERVAL = "Interval";

		// get the device
		Device device = cb.getDevice(DEVMGR_ID, DEVICE_ID); 
		
		// set the id for the properties you want to set
		DataType [] dataTypes = new DataType[1];			
		Any anAny = org.omg.CORBA.ORB.init().create_any();
		anAny.insert_ulong(50);	
		dataTypes[0] = new DataType(INTERVAL, anAny);
		
		cb.setProperties(device, dataTypes);
		
		// check the property is set to 50
		dataTypes[0] = new DataType(INTERVAL, org.omg.CORBA.ORB.init().create_any());
		PropertiesHolder configProperties = new PropertiesHolder(dataTypes);
		
		cb.getProperties(device, configProperties);
		DataType[] properties = configProperties.value;
		anAny = properties[0].value;
		
		Assert.assertTrue(properties[0].id.equalsIgnoreCase(INTERVAL));
		if(anAny.type().kind() == TCKind.tk_ulong) {
			long value = anAny.extract_ulong();
			Assert.assertTrue(value == 50);
		} else {
			Assert.fail("Property value incorrect");
		}
		
		// set the property back to it's initial value 10
		// so the next time we run the tests test_getSpecificProperties passes
		anAny.insert_ulong(10);	
		dataTypes[0] = new DataType(INTERVAL, anAny);
		cb.setProperties(device, dataTypes);
	}
	
	/*******************************************************************************/
	/****************************** FileSystem Tests *******************************/
	/*******************************************************************************/
	
	/**
	 * Tests that we can get the DomainManager's FileManager
	 * PASS - FileManager is not NULL
	 * FAIL - FileManager is NULL
	 */
	public void test_getFileManager() {
		FileManager fmgr =  cb.getDomainManager().fileMgr();
		Assert.assertNotNull(fmgr);
	}
	
	
	/**
	 * Tests that we can get the FileSystem for a DeviceManager
	 * PASS - All DeviceManager FileSystems are not NULL
	 * FAIL - Any DeviceManager FileSystem is not NULL
	 */
	public void test_getFileSystem() {
		FileSystem fs = cb.getFileSystem(DEVMGR_ID);
		Assert.assertNotNull(fs);
	}

	/**
	 * Tests that we can get the FileSystem Properties for 
	 * a DomainManager's FileManager and a DeviceManager's FileSystem
	 * PASS - SIZE and AVAILABLE_SPACE for all FileSystems are obtained
	 * FAIL - SIZE and AVAILABLE_SPACE for all FileSystems are not obtained
	 */
	public void test_getFileSystemProperties() {
		// get the domainManager fileManager which is also a fileSystem
		PropertiesHolder fsPropertiesHolder = cb.getFileSystemProperties(cb.getFileManager());
		DataType[] fsProperties = fsPropertiesHolder.value;
		assertTrue(fsProperties[0].id.equalsIgnoreCase("AVAILABLE_SPACE"));
		assertTrue(fsProperties[1].id.equalsIgnoreCase("SIZE"));
		
		for(int x=0; x < fsProperties.length; x++) {
			if (fsProperties[0].value.type().kind() == TCKind.tk_ulonglong) {
				assertNotNull(fsProperties[0].value.extract_ulonglong());
			}
		}
		
		fsPropertiesHolder = cb.getFileSystemProperties(cb.getFileSystem(DEVMGR_ID));
		fsProperties = fsPropertiesHolder.value;
		assertTrue(fsProperties[0].id.equalsIgnoreCase("AVAILABLE_SPACE"));
		assertTrue(fsProperties[1].id.equalsIgnoreCase("SIZE"));
			
		if (fsProperties[0].value.type().kind() == TCKind.tk_ulonglong) {
			assertNotNull(fsProperties[0].value.extract_ulonglong());
		}
	}
	

	/**
	 * each filesystem should have at least . and .. as files
	 * PASS - a deviceManager's fileSystem has at least two files
	 * FAIL - a deviceManager's fileSystem has less than two files
	 */
	public void test_listAllFiles() {
		FileSystem fs = cb.getFileSystem(DEVMGR_ID);
		FileInformationType [] fType = cb.getfileInformationTypes(fs);
		// should always have . and .. so length should be at least 2
		assertTrue(fType.length >= 2);
	}
	
	
	/*******************************************************************************/
	/****************************** Application Tests ******************************/
	/*******************************************************************************/
	
	/**
	 * PASS - the application is installed and is found in Application Factories
	 * FAIL - the application failed to install and is not found in Application Factories
	 */
	public void test_installApplication() {
		// uninstall the application if it already is installed
		if(cb.applicationFactoryExists(appFactoryId)) {
			cb.uninstallApplication(applicationId);
		}
		
		cb.installApplication(profileFileName);	
		assertTrue(cb.applicationFactoryExists(appFactoryId));
	}
	
	
	/**
	 * PASS - the application is uninstalled and is not found in Application Factories
	 * FAIL - the application is found in Application Factories
	 */
	public void test_uninstallApplication() {
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(appFactoryId)) {
			cb.installApplication(profileFileName);
		}
		
		cb.uninstallApplication(applicationId);
		assertFalse(cb.applicationFactoryExists(appFactoryId));
	}
	
	
	/**
	 * PASS - The installed application is retrieved from getApplicationFactories()
	 * FAIL - The installed application is not found
	 */
	public void test_getApplicationFactories() {
		boolean found = false;
		
		cb.installApplication(profileFileName);	
		ApplicationFactory[] appFactories = cb.getApplicationFactories();
		for(int x=0; x < appFactories.length; x++) {
			if(appFactories[x].name().equalsIgnoreCase("qpskAlignApp") && appFactories[x].identifier().equalsIgnoreCase(appFactoryId)) {
				found = true;
				assertTrue(true);
			}
		}
		if(found == false) {
			assertTrue(false);
		}
		
		cb.uninstallApplication(applicationId);
	}
	
	
	public void test_applicationFactoryExists() {
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(appFactoryId)) {
			cb.installApplication(profileFileName);
		}
		assertTrue(cb.applicationFactoryExists(appFactoryId));
		
		// uninstall the application if it is installed
		if(cb.applicationFactoryExists(appFactoryId)) {
			cb.uninstallApplication(applicationId);
		}
		assertFalse(cb.applicationFactoryExists(appFactoryId));
	}
	
	
	public void test_createApplication() {
		// release the application if it already exists
		if(cb.applicationExists(appName)) {
			cb.releaseApplication(appName);
		}
		
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(appFactoryId)) {
			cb.installApplication(profileFileName);
		}
		
		cb.createApplication(appFactoryId, appName);
		assertTrue(cb.applicationExists(appName));
		
		cb.releaseApplication(appName);
		assertFalse(cb.applicationExists(appName));
	}
	
	
	// create application with device assignment sequence
	public void test_createApplicationWithDeviceAssignmentSequence() {
		// release the application if it already exists
		if(cb.applicationExists(appName)) {
			cb.releaseApplication(appName);
		}
		
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(appFactoryId)) {
			cb.installApplication(profileFileName);
		}
		
		// create the deviceAssignmentSequence
		DeviceAssignmentType[] deviceAssignment = new DeviceAssignmentType[10];
		// DCE:8637F522-AFB9-4914-956A-CF2EA94423B5 (controller) to device DCE:E1DA93A0-18BF-4AB4-8DA9-9F348369A680 (gpp_exec_device)
		deviceAssignment[0] = new DeviceAssignmentType("DCE:8637F522-AFB9-4914-956A-CF2EA94423B5", "DCE:E1DA93A0-18BF-4AB4-8DA9-9F348369A680");
		// DCE:04DF6A92-07DD-4E73-AACC-3F459980A664 (bit2intconverter) to device DCE:C2D15394-D319-4097-8E2E-271E37511E30 (sigproc_exec_device1)
		deviceAssignment[1] = new DeviceAssignmentType("DCE:04DF6A92-07DD-4E73-AACC-3F459980A664", "DCE:C2D15394-D319-4097-8E2E-271E37511E30");
		// DCE:C4C7FC22-3C5D-42A0-A760-05AC8E120D98 (qpskmodulator) to device DCE:C2D15394-D319-4097-8E2E-271E37511E30 (sigproc_exec_device1)
		deviceAssignment[2] = new DeviceAssignmentType("DCE:C4C7FC22-3C5D-42A0-A760-05AC8E120D98", "DCE:C2D15394-D319-4097-8E2E-271E37511E30");
		// DCE:A1689DA6-47FA-414B-9EBE-5A9A99C74ACE (raisedcosinetxfilter) to device DCE:C2D15394-D319-4097-8E2E-271E37511E30 (sigproc_exec_device1)
		deviceAssignment[3] = new DeviceAssignmentType("DCE:A1689DA6-47FA-414B-9EBE-5A9A99C74ACE", "DCE:C2D15394-D319-4097-8E2E-271E37511E30");
		// DCE:BA1FA6C6-BEF1-4B6B-8527-8EEF2C10685E (bercalculator) to device DCE:E1DA93A0-18BF-4AB4-8DA9-9F348369A680 (gpp_exec_device)
		deviceAssignment[4] = new DeviceAssignmentType("DCE:BA1FA6C6-BEF1-4B6B-8527-8EEF2C10685E", "DCE:E1DA93A0-18BF-4AB4-8DA9-9F348369A680");
		// DCE:B301850D-5C60-4FA9-9F3B-24B8AE23F225 (int2bitconverter) to device DCE:0FDC7D5B-296E-4A9F-A3DA-BD5DABEDD4B5 (sigproc_exec_device2)
		deviceAssignment[5] = new DeviceAssignmentType("DCE:B301850D-5C60-4FA9-9F3B-24B8AE23F225", "DCE:0FDC7D5B-296E-4A9F-A3DA-BD5DABEDD4B5");
		// DCE:061D04E1-96FD-4983-9301-AC4B8058BF95 (raisedcosinerxfilter) to device DCE:0FDC7D5B-296E-4A9F-A3DA-BD5DABEDD4B5 (sigproc_exec_device2)
		deviceAssignment[6] = new DeviceAssignmentType("DCE:061D04E1-96FD-4983-9301-AC4B8058BF95", "DCE:0FDC7D5B-296E-4A9F-A3DA-BD5DABEDD4B5");
		// DCE:20AD90C8-8C9E-4FDD-86D9-BF0D9B183FD9 (qpskdemodulator) to device DCE:0FDC7D5B-296E-4A9F-A3DA-BD5DABEDD4B5 (sigproc_exec_device2)
		deviceAssignment[6] = new DeviceAssignmentType("DCE:20AD90C8-8C9E-4FDD-86D9-BF0D9B183FD9", "DCE:0FDC7D5B-296E-4A9F-A3DA-BD5DABEDD4B5");
		
		cb.createApplication(appFactoryId, appName);
		assertTrue(cb.applicationExists(appName));
		
		// do not release application. It is used by subsequent tests
	}
	
	
	public void test_getApplications() {
		Application[] app = cb.getApplications();
		// at the very least qpskAlignApp should be created
		assertTrue(app.length >=1);
	}
	
	
	public void test_applicationExists() {
		assertTrue(cb.applicationExists(appName));
	}
	
	
	public void test_startApplication() {
		cb.applicationStart(appName);
	}
	
	public void test_stopApplication() {
		cb.applicationStop(appName);
	}
	
	/**
	 * Outputs all information 
	 */
	public void test_toString() {
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(appFactoryId)) {
			cb.installApplication(profileFileName);
		}
		System.out.println(cb.toString());
	}
	
	public void test_releaseApplication() {
		cb.releaseApplication(appName);
		assertFalse(cb.applicationExists(appName));
		
		cb.uninstallApplication(applicationId);
	}
	
	
	/*******************************************************************************/
	/********************* Resource Factory Application Tests **********************/
	/*******************************************************************************/
	
	
	/**
	 * PASS - the ResourceFactory application is installed and is found in Application Factories
	 * FAIL - the ResourceFactory application failed to install and is not found in Application Factories
	 */
	public void test_installResourceFactoryApplication() {
		// uninstall the application if it already is installed
		if(cb.applicationFactoryExists(rfAppFactoryId)) {
			cb.uninstallApplication(rfApplicationId);
		}
		
		cb.installApplication(rfProfileFileName);	
		assertTrue(cb.applicationFactoryExists(rfAppFactoryId));
	}
	
	
	public void test_createResourceFactoryApplication() {
		// release the application if it already exists
		if(cb.applicationExists(rfAppName)) {
			cb.releaseApplication(rfAppName);
		}
		
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(rfAppFactoryId)) {
			cb.installApplication(rfProfileFileName);
		}
		
		cb.createApplication(rfAppFactoryId, rfAppName);
		assertTrue(cb.applicationExists(rfAppName));
	}
	
	
	/**
	 * Outputs all information with a ResourceFactory Application
	 */
	public void test_toStringResourceFactory() {
		// install the ResourceFactory application if it not already installed
		if(!cb.applicationFactoryExists(rfAppFactoryId)) {
			cb.installApplication(rfProfileFileName);
		}
		System.out.println(cb.toString());
	}
	
	
	public void test_releaseResourceFactoryApplication() {
		cb.releaseApplication(rfAppName);
		assertFalse(cb.applicationExists(rfAppName));
	}
	
	
	/**
	 * PASS - the ResourceFactory application is uninstalled and is not found in Application Factories
	 * FAIL - the ResourceFactory application is found in Application Factories
	 */
	public void test_uninstallResourceFactoryApplication() {
		// install the application if it not already installed
		if(!cb.applicationFactoryExists(rfAppFactoryId)) {
			cb.installApplication(rfProfileFileName);
		}
		
		cb.uninstallApplication(rfApplicationId);
		assertFalse(cb.applicationFactoryExists(rfAppFactoryId));
	}
	
}
