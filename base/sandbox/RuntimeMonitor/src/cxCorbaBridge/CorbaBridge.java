package cxCorbaBridge;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import CF.Application;
import CF.ApplicationFactory;
import CF.DataType;
import CF.Device;
import CF.DeviceAssignmentType;
import CF.DeviceManager;
import CF.DomainManager;
import CF.DomainManagerHelper;
import CF.FileException;
import CF.FileManager;
import CF.FileSystem;
import CF.InvalidFileName;
import CF.InvalidProfile;
import CF.PropertiesHolder;
import CF.PropertySet;
import CF.Resource;
import CF.ResourceFactory;
import CF.ResourceFactoryHelper;
import CF.ResourceHelper;
import CF.UnknownProperties;
import CF.ApplicationFactoryPackage.CreateApplicationError;
import CF.ApplicationFactoryPackage.CreateApplicationRequestError;
import CF.ApplicationFactoryPackage.InvalidInitConfiguration;
import CF.ApplicationPackage.ComponentElementType;
import CF.ApplicationPackage.ComponentProcessIdType;
import CF.DeviceManagerPackage.ServiceType;
import CF.DevicePackage.AdminType;
import CF.DevicePackage.OperationalType;
import CF.DevicePackage.UsageType;
import CF.DomainManagerPackage.ApplicationAlreadyInstalled;
import CF.DomainManagerPackage.ApplicationInstallationError;
import CF.DomainManagerPackage.ApplicationUninstallationError;
import CF.DomainManagerPackage.InvalidIdentifier;
import CF.FileManagerPackage.MountType;
import CF.FileSystemPackage.FileInformationType;
import CF.FileSystemPackage.UnknownFileSystemProperties;
import CF.LifeCyclePackage.ReleaseError;
import CF.PropertySetPackage.InvalidConfiguration;
import CF.PropertySetPackage.PartialConfiguration;
import CF.ResourcePackage.StartError;
import CF.ResourcePackage.StopError;
import LogService.LogLevelSequenceTypeHelper;
import LogService.LogLevelType;

/**
 * @author tmcguire
 *
 */

public class CorbaBridge {

	private ORB orb;
	private NamingContext rootContext;
	private DomainManager dmgr;

	public CorbaBridge(String nsior, String dmgrPath, String logPath) {
		super();

		// set the NamingService
		setNamingServiceContext(nsior);
		// set the DomainManager
		setDomainManager(dmgrPath);
	}

	/*******************************************************************************/
	/******************************** NamingService ********************************/
	/*******************************************************************************/

	/**
	 * @return the NamingService Context
	 */
	public NamingContext getNamingServiceContext() {
		return rootContext;
	}

	/**
	 * Set the NamingService Context from the NamingService IOR
	 * 
	 * @param args
	 *            - used in ORB.init() method
	 * @param nsior
	 *            - the NamingService IOR
	 */
	public void setNamingServiceContext(String nsior) {
		try {
			String[] args =  null;
			
			// initialize the orb
			orb = ORB.init(args, null);
		} catch (SystemException ex) {
			System.err.println("setNamingServiceContext: ORB failed to initialize");
		}

		org.omg.CORBA.Object objRef;
		try {
			objRef = orb.string_to_object(nsior);
			rootContext = NamingContextHelper.narrow(objRef);

			if (rootContext == null) {
				System.err.println("setNamingServiceContext: Returned IOR is not a Naming Context");
				System.out.println("Exiting ...");
				System.exit(11);
			}
		} catch (org.omg.CORBA.SystemException ex) {
			System.err.println(ex);
		}
	}

	/*******************************************************************************/
	/******************************** DomainManager ********************************/
	/*******************************************************************************/

	/**
	 * @return the DomainManager
	 */
	public DomainManager getDomainManager() {
		return dmgr;
	}

	/**
	 * Set the DomainManager given the path to the DomainManager in the
	 * NamingService
	 * 
	 * @param dmgrPath
	 *            Path to the DomainManager in NamingService, i.e.
	 *            "/dmTK/DomainManager"
	 */
	public void setDomainManager(String dmgrPath) {

		org.omg.CORBA.Object objRef;

		String[] result = dmgrPath.split("/");
		// ignore the first '/'
		NameComponent[] nameComponent = new NameComponent[result.length - 1];
		for (int x = 0; x < result.length - 1; x++) {
			nameComponent[x] = new NameComponent(result[x + 1], "");
		}

		try {
			objRef = rootContext.resolve(nameComponent);
			dmgr = DomainManagerHelper.narrow(objRef);
		} catch (NotFound e) {
			System.err.println("setDomainManager: DomainManager not found");
		} catch (CannotProceed e) {
			System.err.println("setDomainManager: Cannot proceed");
		} catch (InvalidName e) {
			System.err.println("setDomainManager: Invalid Name");
		}
	}

	/**
	 * @return profile (DMD file name)
	 */
	public String getDomainManagerProfile() {
		return getDomainManager().domainManagerProfile();
	}

	/**
	 * @return DomainManager instance Id
	 */
	public String getDomainManagerIdentifier() {
		return getDomainManager().identifier();
	}
	

	/*******************************************************************************/
	/******************************** DeviceManager ********************************/
	/*******************************************************************************/

	/**
	 * @return DeviceManager array
	 */
	private DeviceManager[] getDeviceManagers() {
		return getDomainManager().deviceManagers();
	}

	/**
	 * @param identifier
	 *            i.e. DCE:9DDA4F7F-3D4D-4800-94A7-9855384A3C81
	 * @return the deviceManager matching the case insensitive identifier or
	 *         null if device is not found
	 */
	public DeviceManager getDeviceManager(String identifier) {
		DeviceManager[] devMgrs = getDeviceManagers();
		for (int x = 0; x < devMgrs.length; x++) {
			if (identifier.equalsIgnoreCase(devMgrs[x].identifier())) {
				return devMgrs[x];
			}
		}
		return null;
	}

	/*******************************************************************************/
	/************************************ Device ***********************************/
	/*******************************************************************************/

	/**
	 * @param devMgr - a deviceManager identifier
	 * @return the registered Devices for a DeviceManager
	 */
	private Device[] getDevices(String devMgrIdentifier) {
		return getDeviceManager(devMgrIdentifier).registeredDevices();
	}

	/**
	 * @param devMgr
	 *            - a deviceManager
	 * @param identifier
	 *            - a device identifier
	 * @return either a valid device or null
	 */
	public Device getDevice(String devMgrIdentifier, String identifier) {
		Device[] devices = getDevices(devMgrIdentifier);
		for (int x = 0; x < devices.length; x++) {
			if (identifier.equalsIgnoreCase(devices[x].identifier())) {
				return devices[x];
			}
		}
		return null;
	}

	
	/*******************************************************************************/
	/*********************************** Service ***********************************/
	/*******************************************************************************/

	/**
	 * @param devMgr
	 * @return the registered Services for a DeviceManager
	 */
	private ServiceType[] getServices(String devMgrIdentifier) {
		return getDeviceManager(devMgrIdentifier).registeredServices();
	}
	
	
	public ServiceType getService(String devMgrIdentifier, String serviceName) {
		ServiceType[] services = getServices(devMgrIdentifier);
		for (int x = 0; x < services.length; x++) {
			if (serviceName.equalsIgnoreCase(services[x].serviceName)) {
				return services[x];
			}
		}
		return null;
	}

	
	/*******************************************************************************/
	/********************************* Properties **********************************/
	/*******************************************************************************/

	/**
	 * queries a PropertySet element for all its properties.
	 * returns all configure properties that are readOnly or readWrite and
	 * external allocation properties
	 * @param resource
	 * @return all configure properties
	 */
	public PropertiesHolder getProperties(PropertySet resource) {
		DataType[] dataTypes = new DataType[0];
		PropertiesHolder configProperties = new PropertiesHolder(dataTypes);

		try {
			resource.query(configProperties);
		} catch (UnknownProperties e) {
			System.err.println("getProperties: Error querying configure properties");
		}
		return configProperties;
	}	
	
	/**
	 * queries a PropertySet element for one or more of its properties.
	 * @param resource - the PropertySet element to be queried
	 * @param configProperties - one or more property id's
	 */
	public void getProperties(PropertySet resource, PropertiesHolder configProperties) {
		try {
			resource.query(configProperties);
		} catch (UnknownProperties e) {
			System.err.println("getProperties: Error querying configure properties");
		}
	}

	/**
	 * @param resource
	 * @param configProperties
	 */
	public void setProperties(PropertySet resource, CF.DataType[] configProperties) {

			try {
				resource.configure(configProperties);
			} catch (InvalidConfiguration e) {
				System.err.println("setProperties: Error configuring properties");
			} catch (PartialConfiguration e) {
				System.err.println("setProperties: Partial Error configuring properties");
			}

	}
	
	/*******************************************************************************/
	/**************************** FileSystem utilities *****************************/
	/*******************************************************************************/
	
	/**
	 * Only the DomainManager can have a FileManager.
	 * Note: A FileManager is also a FileSystem
	 * @return the DomainManager's FileManager
	 */
	public FileManager getFileManager() {
		return getDomainManager().fileMgr();
	}
	
	
	/**
	 * Each DeviceManager will have a FileSystem
	 * @param devMgr
	 * @return the FileSystem
	 */
	public FileSystem getFileSystem(String devMgrIdentifier) {
		return getDeviceManager(devMgrIdentifier).fileSys();
	}
	
	
	/**
	 * @param fs - A FileSystem
	 * @return AVAILABLE_SPACE and SIZE of the FileSystem
	 */
	public PropertiesHolder getFileSystemProperties(FileSystem fs) {
				
		// set the id for the properties you want to receive
		DataType [] dataTypes = new DataType[2];	
		dataTypes[0] = new DataType(FileSystem.AVAILABLE_SPACE, org.omg.CORBA.ORB.init().create_any());
		dataTypes[1] = new DataType(FileSystem.SIZE, org.omg.CORBA.ORB.init().create_any());
		PropertiesHolder fsProperties = new PropertiesHolder(dataTypes);
		try {
			fs.query(fsProperties);
		} catch (UnknownFileSystemProperties e) {
			System.err.println("getFileSystemProperties: ERROR retrieving FileSystem properties");
		}
		return fsProperties;
	}
	
	/**
	 * @param fs
	 * @return all files in a FileSystem
	 */
	public FileInformationType [] getfileInformationTypes(FileSystem fs) {
		FileInformationType[] fsType = new FileInformationType[0];
		try {
			fsType = fs.list("/*");
		} catch (FileException e) {
			System.err.println("listAllFiles: a file-related error occurred");
		} catch (InvalidFileName e) {
			System.err.println("listAllFiles: ERROR, Invalid FileName");
		}
		return fsType;
	}
	
	
	
	/*******************************************************************************/
	/**************************** Application Factories ****************************/
	/*******************************************************************************/
	
	/**
	 * Install an application
	 * @param profileFileName - the path and name of the SAD file
	 */
	public void installApplication(String profileFileName) {
		try {
			getDomainManager().installApplication(profileFileName);
		} catch (InvalidProfile e) {
			System.err.println("installApplication: ERROR, Invalid Profile");
		} catch (InvalidFileName e) {
			System.err.println("installApplication: ERROR, Invalid File Name");
		} catch (ApplicationInstallationError e) {
			System.err.println("installApplication: ERROR, ApplicationInstallationError");
		} catch (ApplicationAlreadyInstalled e) {
			System.err.println("installApplication: ERROR, Application already installed");
		}
	}
	

	/**
	 * The uninstallApplication operation is used to uninstall 
	 * an application and its associated ApplicationFactory from 
	 * the DomainManager
	 * @param applicationId = the DCE UUID of the Application
	 */
	public void uninstallApplication(String applicationId) {
		try {
			getDomainManager().uninstallApplication(applicationId);
		} catch (InvalidIdentifier e) {
			System.err.println("uninstallApplication: ERROR, Invalid Identifier");
		} catch (ApplicationUninstallationError e) {
			System.err.println("uninstallApplication: ERROR, Application Uninstallation Error");
		}
	}

	
	/**
	 * Iterates through the ApplicationFactories
	 * @param identifier - the identifier of the application factory
	 * @return true if the ApplicationFactory exists
	 */
	public boolean applicationFactoryExists(String identifier) {
		ApplicationFactory[] appFactories = getApplicationFactories();
		for(int x=0; x < appFactories.length; x++) {
			if(appFactories[x].identifier().equalsIgnoreCase(identifier)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	/* The applicationFactories attribute contains a list with one 
	 * ApplicationFactory per application (SAD file and associated files) 
	 * successfully installed.
	 * @return - DomainManager's applicationFactories
	 */
	public ApplicationFactory[] getApplicationFactories() {
		ApplicationFactory[] appFactories = getDomainManager().applicationFactories();
		return appFactories;
	}
	
	
	/**
	 * @param identifier - the identifier of the application factory
	 * @return - either the application factory or null
	 */
	public ApplicationFactory getApplicationFactory(String identifier) {
		ApplicationFactory[] appFactories = getApplicationFactories();
		for(int x=0; x < appFactories.length; x++) {
			if(appFactories[x].identifier().equalsIgnoreCase(identifier)) {
				return appFactories[x];
			}
		}
		return null;
	}
		
	
	/*******************************************************************************/
	/******************************** Applications *********************************/
	/*******************************************************************************/
	
	/**
	 * Create an application using an Application Factory and a name
	 * The CF decides on the deployment in this case
	 * @param AppFactoryId - the ApplicationFactory's Identifier
	 * @param AppName - the name of the application to be instantiated
	 */
	public void createApplication(String appFactoryId, String appName) {	
		DataType[] initConfiguration = new DataType[0];
		DeviceAssignmentType[] deviceAssignments = new DeviceAssignmentType[0];
		createApplication(appFactoryId, appName, initConfiguration, deviceAssignments);
	}
	
	
	/**
	 * Create an application using an Application Factory with a name and a deviceAssgnmentSequence
	 * This method enforces a deployment
	 * @param AppFactoryId - the ApplicationFactory's Identifier
	 * @param AppName - the name of the application to be instantiated
	 * @param deviceAssignments - assignment of components to devices
	 */
	public void createApplicationWithDeviceAssignmentSequence(String appFactoryId, String appName, CF.DeviceAssignmentType[] deviceAssignments) {
		DataType[] initConfiguration = new DataType[0];
		createApplication(appFactoryId, appName, initConfiguration, deviceAssignments);
	}
	
	
	/**
	 * @param appFactoryId - the existing Application Factory ID
	 * @param name - the name of the Application to be created
	 * @param initConfiguration - assembly controller config properties provided by the user at create time
	 * @param deviceAssignments - assignment of components to devices
	 */
	public void createApplication(String appFactoryId, String name, CF.DataType[] initConfiguration, CF.DeviceAssignmentType[] deviceAssignments) {
		ApplicationFactory appFactory = getApplicationFactory(appFactoryId);
		
		try {
			if(appFactory != null) {
				appFactory.create(name, initConfiguration, deviceAssignments);
			}
		} catch (CreateApplicationError e) {
			System.err.println("creatApplication: ERROR, CreateApplicationError");
		} catch (CreateApplicationRequestError e) {
			System.err.println("creatApplication: ERROR, CreateApplicationRequestError");
		} catch (InvalidInitConfiguration e) {
			System.err.println("creatApplication: ERROR, InvalidInitConfiguration");
		}
	}
	
	
	/**
	 * Tear down an application. The application is still installed after this operation
	 * An Application inherits from LifeCycle so it understands releaseObject
	 * @param application
	 */
	public void releaseApplication(String name) {
		Application application = getApplication(name);
		
		if(application != null) {
			try {
				application.releaseObject();
			} catch (ReleaseError e) {
				System.err.println("releaseApplication: ERROR, ReleaseError");
			}
		}
	}

	
	/**
	/* The domainManager's applications attribute contains a list 
	 * of Applications that have been instantiated in the domain.
	 * @return - DomainManager's applications
	 */
	public Application[] getApplications() {
		Application[] applications = getDomainManager().applications();
		return applications;
	}
	
	
	/**
	 * Iterates through the Applications
	 * Can't use identifier as the parameter since the application's identifier created
	 * at runtime so we don't know what it is in advance
	 * @param name - the name of the application
	 * @return true if the Application exists
	 */
	public boolean applicationExists(String name) {
		Application[] applications = getApplications();
		for(int x=0; x < applications.length; x++) {
			if(applications[x].name().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Iterates through the Applications
	 * Can't use identifier as the parameter since the application's identifier created
	 * at runtime so we don't know what it is in advance
	 * @param name - the name of the application
	 * @return - either the application or null
	 */
	private Application getApplication(String name) {
		Application[] applications = getApplications();
		for(int x=0; x < applications.length; x++) {
			if(applications[x].name().equalsIgnoreCase(name)) {
				return applications[x];
			}
		}
		return null;
	}
	
	
	/**
	 * @param name - the name of the application
	 */
	public void applicationStart(String name) {
		Application app = getApplication(name);
		if(app != null) {
			try {
				app.start();
			} catch (StartError e) {
				System.err.println("applicationStart: ERROR, start error");
			}
		}
	}
	
	/**
	 * @param name - the name of the application
	 */
	public void applicationStop(String name) {
		Application app = getApplication(name);
		if(app != null) {
			try {
				app.stop();
			} catch (StopError e) {
				System.err.println("applicationStop: ERROR, stop error");
			}
		}
	}
				
	
	/*******************************************************************************/
	/********************************* Components **********************************/
	/*******************************************************************************/
	
	/**
	 * Given the NS context, the component is looked up in the namingService
	 * @param nsContext
	 * @return a CORBA object since it could either be a Resource or ResourceFactory
	 */
	private org.omg.CORBA.Object getComponent(String nsContext) {
		org.omg.CORBA.Object objRef = null;
		Resource component = null;
		ResourceFactory rfComponent = null;
		
		// example nsContext /dmTK/qpskAlignApp/bit2intconverter_10
		String[] result = nsContext.split("/");
		// ignore the first '/'
		NameComponent[] nameComponent = new NameComponent[result.length - 1];
		for (int x = 0; x < nameComponent.length; x++) {
			nameComponent[x] = new NameComponent(result[x + 1], "");
		}

		try {
			objRef = rootContext.resolve(nameComponent);
			
			if(objRef._is_a(ResourceFactoryHelper.id())) {
				rfComponent = ResourceFactoryHelper.narrow(objRef);
				return rfComponent;
			} else if (objRef._is_a(ResourceHelper.id())) {
				component = ResourceHelper.narrow(objRef);
				return component;
			}
			
		} catch (NotFound e) {
			System.err.println("getComponent: Component not found");
		} catch (CannotProceed e) {
			System.err.println("getComponent: Cannot proceed");
		} catch (InvalidName e) {
			System.err.println("getComponent: Invalid Name");;
		}
		return null;
	}
	
	
	/*******************************************************************************/
	/***************************** toString utilities ******************************/
	/*******************************************************************************/

	@Override
	public String toString() {
		return toString_DomainManager(getDomainManager());
	}
	
	private String toString_DomainManager(DomainManager aDomainManager) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Domain Manager ########################" + NEW_LINE);
		result.append("DomainManager profile    = " + this.getDomainManagerProfile() + NEW_LINE);
		result.append("DomainManager identifier = " + this.getDomainManagerIdentifier() + NEW_LINE);
		result.append(toString_FileSystem(getFileManager()));
		result.append(toString_Properties(getDomainManager()));
		result.append(toString_ApplicationFactories());
		result.append(toString_Applications());
		
		DeviceManager[] devMgrs = this.getDeviceManagers();
		for (int x = 0; x < devMgrs.length; x++) {
			result.append(this.toString_DeviceManager(devMgrs[x].identifier()));
		}
		return result.toString();
	}

	private String toString_DeviceManager(String devMgrIdentifier) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		DeviceManager devMgr = getDeviceManager(devMgrIdentifier);
		
		result.append("######################## Device Manager ########################" + NEW_LINE);
		result.append("DeviceManager label      = " + devMgr.label() + NEW_LINE);
		result.append("DeviceManager identifier = " + devMgr.identifier() + NEW_LINE);
		result.append("DeviceManager deviceConfigurationProfile = " + devMgr.deviceConfigurationProfile() + NEW_LINE);
		result.append(toString_FileSystem(getFileSystem(devMgr.identifier())));
		result.append(toString_Properties(devMgr));

		// Devices
		Device[] devs = this.getDevices(devMgr.identifier());
		for (int x = 0; x < devs.length; x++) {
			result.append(this.toString_Device(devs[x]));
		}

		// Services
		ServiceType[] services = this.getServices(devMgr.identifier());
		for (int x = 0; x < services.length; x++) {
			result.append(this.toString_Service(services[x]));
		}
		return result.toString();
	}

	private String toString_Device(Device dev) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("######################## Device ########################" + NEW_LINE); 
		result.append("Device label      		= " + dev.label() + NEW_LINE);
		result.append("Device identifier 		= " + dev.identifier() + NEW_LINE);
		result.append("Device softwareProfile 	= " + dev.softwareProfile() + NEW_LINE);
		result.append("Device adminState 		= " + toString_AdminState(dev.adminState().value()) + NEW_LINE);
		result.append("Device usageState 		= " + toString_UsageState(dev.usageState().value()) + NEW_LINE);
		result.append("Device operationalState 	= " + toString_OperationalState(dev.operationalState().value()) + NEW_LINE + NEW_LINE);
		result.append(toString_Properties(dev));
		return result.toString();
	}

	
	/**
	 * returns the device adminState as a String
	 * @param adminState
	 * @return
	 */
	private String toString_AdminState(int adminState) {
		String state;
		
		switch (adminState) {
		case AdminType._LOCKED: {
			state =  "LOCKED";
			break;
		}
		case AdminType._SHUTTING_DOWN: {
			state = "SHUTTING_DOWN";
			break;
		}
		case AdminType._UNLOCKED: {
			state = "UNLOCKED";
			break;
		}
		default:
			state = "UNKNOWN";
		}
		return state;
	}
	
	
	/**
	 * returns the device usageState as a String
	 * @param usageState
	 * @return
	 */
	private String toString_UsageState(int usageState) {
		String state;
		
		switch (usageState) {
		case UsageType._ACTIVE: {
			state =  "ACTIVE";
			break;
		}
		case UsageType._BUSY: {
			state = "BUSY";
			break;
		}
		case UsageType._IDLE: {
			state = "IDLE";
			break;
		}
		default:
			state = "UNKNOWN";
		}
		return state;
	}
	
	
	/**
	 * returns the device operationalState as a String
	 * @param operationalState
	 * @return
	 */
	private String toString_OperationalState(int operationalState) {
		String state;
		
		switch (operationalState) {
		case OperationalType._DISABLED: {
			state =  "DISABLED";
			break;
		}
		case OperationalType._ENABLED: {
			state = "ENABLED";
			break;
		}
		default:
			state = "UNKNOWN";
		}
		return state;
	}
	
	private String toString_Service(ServiceType service) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("######################## Services ########################" + NEW_LINE);
		result.append("Service name      		= " + service.serviceName + NEW_LINE + NEW_LINE);
		return result.toString();
	}

	private String toString_Properties(PropertySet resource) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Properties ########################" + NEW_LINE);
		PropertiesHolder configProperties = getProperties(resource);
		DataType[] properties = configProperties.value;

		for (int x = 0; x < properties.length; x++) {
			result.append(properties[x].id + "	= ");
			result.append(toString_PropertiesHelper(properties[x].value));
		}
		result.append(NEW_LINE);
		return result.toString();
	}

	
	/**
	 * Helper method to print properties
	 * @param anAny
	 * @return
	 */
	private String toString_PropertiesHelper(Any anAny) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		// get the typecode of the Any
		TypeCode tc = anAny.type();
		if (tc.kind() == TCKind.tk_string) {
			result.append(anAny.extract_string());
		} else if (tc.kind() == TCKind.tk_boolean) {
			result.append(anAny.extract_boolean());
		} else if (tc.kind() == TCKind.tk_char) {
			result.append(anAny.extract_char());
		} else if (tc.kind() == TCKind.tk_short) {
			result.append(anAny.extract_short());
		} else if (tc.kind() == TCKind.tk_ushort) {
			result.append(anAny.extract_ushort());
		} else if (tc.kind() == TCKind.tk_long) {
			result.append(anAny.extract_long());
		} else if (tc.kind() == TCKind.tk_ulong) {
			result.append(anAny.extract_ulong());
		} else if (tc.kind() == TCKind.tk_ulonglong) {
			result.append(anAny.extract_ulonglong());
		} else if (tc.kind() == TCKind.tk_float) {
			result.append(anAny.extract_float());
		} else if (tc.kind() == TCKind.tk_double) {
			result.append(anAny.extract_double());
		} else if (tc.kind() == TCKind.tk_octet) {
			result.append(anAny.extract_octet());
		} else if (tc.kind() == TCKind.tk_sequence) {
			result.append("SEQUENCE");
		} else if (tc.kind() == TCKind.tk_sequence) {
			result.append("STRUCT");
		} else if(tc.kind() == LogLevelSequenceTypeHelper.type().kind()) {
			// PRODUCER_LOG_LEVEL
			LogLevelType [] logLevels = LogLevelSequenceTypeHelper.extract(anAny);
			for(int x=0; x < logLevels.length; x++) {
				if(x>0) {
					result.append(", ");
				}
				result.append( toString_ProducerLogLevel(logLevels[x].value()));
			}
		}
		result.append(NEW_LINE);
		return result.toString();
	}
	
	
	/**
	 * @param level
	 * @return the String representing the LogLevelType value
	 */
	private String toString_ProducerLogLevel(int level) {
		String logLevel;
		
		switch (level) {
		case LogLevelType._FAILURE_ALARM: {
			logLevel =  "FAILURE_ALARM";
			break;
		}
		case LogLevelType._DEGRADED_ALRAM: { // Spelled incorrectly in IDL
			logLevel =  "DEGRADED_ALARM";    // Corrected spelling for printout
			break;
		}
		case LogLevelType._EXCEPTION_ERROR: {
			logLevel =  "EXCEPTION_ERROR";
			break;
		}
		case LogLevelType._FLOW_CONTROL_ERROR: {
			logLevel =  "FLOW_CONTROL_ERROR";
			break;
		}
		case LogLevelType._RANGE_ERROR: {
			logLevel =  "RANGE_ERROR";
			break;
		}
		case LogLevelType._USAGE_ERROR: {
			logLevel =  "USAGE_ERROR";
			break;
		}
		case LogLevelType._ADMINISTRATIVE_EVENT: {
			logLevel =  "ADMINISTRATIVE_EVENT";
			break;
		}
		case LogLevelType._STATISTIC_REPORT: {
			logLevel =  "STATISTIC_REPORT";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG1: {
			logLevel =  "PROGRAMMER_DEBUG1";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG2: {
			logLevel =  "PROGRAMMER_DEBUG2";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG3: {
			logLevel =  "PROGRAMMER_DEBUG3";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG4: {
			logLevel =  "PROGRAMMER_DEBUG4";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG5: {
			logLevel =  "PROGRAMMER_DEBUG5";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG6: {
			logLevel =  "PROGRAMMER_DEBUG6";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG7: {
			logLevel =  "PROGRAMMER_DEBUG7";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG8: {
			logLevel =  "PROGRAMMER_DEBUG8";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG9: {
			logLevel =  "PROGRAMMER_DEBUG9";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG10: {
			logLevel =  "PROGRAMMER_DEBUG10";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG11: {
			logLevel =  "PROGRAMMER_DEBUG11";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG12: {
			logLevel =  "PROGRAMMER_DEBUG12";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG13: {
			logLevel =  "PROGRAMMER_DEBUG13";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG14: {
			logLevel =  "PROGRAMMER_DEBUG14";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG15: {
			logLevel =  "PROGRAMMER_DEBUG15";
			break;
		}
		case LogLevelType._PROGRAMMER_DEBUG16: {
			logLevel =  "PROGRAMMER_DEBUG16";
			break;
		}
		default:
			logLevel = "UNKNOWN";
		}
		return logLevel;
	}
	

	/**
	 * @param fs
	 * @return
	 */
	private String toString_FileSystem(FileSystem fs) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
	
		if(fs instanceof FileManager) {
			result.append("######################## File Manager ########################" + NEW_LINE);
		} else {
			result.append("######################## File System ########################" + NEW_LINE);
		}
		
		PropertiesHolder fsPropertiesHolder = getFileSystemProperties(fs);
		DataType[] fsProperties = fsPropertiesHolder.value;
		result.append("Size = " + toString_PropertiesHelper(fsProperties[0].value));
		result.append("Available Space = " + toString_PropertiesHelper(fsProperties[1].value));

		if(fs instanceof FileManager) {
			// get the FileManager mount points
			MountType[] mounts = ((FileManager) fs).getMounts();
			for(int x=0; x< mounts.length; x++) {
				result.append("Mount Point = " + mounts[x].mountPoint + NEW_LINE);
				// recursive call to print each mount's file system
				result.append(toString_FileSystem(mounts[x].fs));
			}
		} else {
			FileInformationType [] fsType = getfileInformationTypes(fs);
			for(int x=0; x < fsType.length; x++) {
				result.append(fsType[x].name + NEW_LINE);
			}
		}
		result.append(NEW_LINE);
		return result.toString();
	}
	
	
	/**
	 * @param 
	 * @return
	 */
	private String toString_ApplicationFactories() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		ApplicationFactory[] appFactories = getApplicationFactories();
		result.append("Application Factories" + NEW_LINE);
		for(int x=0; x < appFactories.length; x++) {
			result.append(toString_ApplicationFactory(appFactories[x]));
		}
		result.append(NEW_LINE);
		return result.toString();
	}
	
	
	/**
	 * @param appFactory
	 * @return
	 */
	private String toString_ApplicationFactory(ApplicationFactory appFactory) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Application Factory ########################" + NEW_LINE);
		result.append("ApplicationFactory name = " + appFactory.name() + NEW_LINE);
		result.append("ApplicationFactory identifier = " + appFactory.identifier() + NEW_LINE);
		result.append("ApplicationFactory software profile = " + appFactory.softwareProfile() + NEW_LINE);
		return result.toString();
	}
	
	
	/**
	 * @param 
	 * @return
	 */
	private String toString_Applications() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		Application[] applications = getApplications();
		for(int x=0; x < applications.length; x++) {
			result.append(toString_Application(applications[x]));
		}
		result.append(NEW_LINE);
		return result.toString();
	}
	
	/**
	 * @param application
	 * @return
	 */
	private String toString_Application(Application application) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Application  ########################" + NEW_LINE);
		result.append("Application name = " + application.name() + NEW_LINE);
		result.append("Application identifier = " + application.identifier() + NEW_LINE);
		result.append("Application software profile = " + application.profile() + NEW_LINE + NEW_LINE);
		result.append(to_String_ComponentNamingContexts(application) + NEW_LINE);
		result.append(to_String_ComponentProcessIDs(application) + NEW_LINE);
		result.append(to_String_ComponentDevices(application) + NEW_LINE);
		result.append(to_String_ComponentImplementations(application) + NEW_LINE);
		result.append(to_String_Components(application) + NEW_LINE);
		
		return result.toString();
	}
	
	
	private String to_String_ComponentNamingContexts(Application application) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Component Naming Contexts  ########################" + NEW_LINE);
		ComponentElementType[] componentNamingContexts = application.componentNamingContexts();
	
		for(int x=0; x < componentNamingContexts.length; x++) {
			result.append("Component ID - " + componentNamingContexts[x].componentId + NEW_LINE);
			result.append("Component NC - " + componentNamingContexts[x].elementId + NEW_LINE);
		}
		return result.toString();
	}
	
	
	private String to_String_ComponentProcessIDs(Application application) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Component Process IDs  ########################" + NEW_LINE);
		ComponentProcessIdType[] componentProcessIds = application.componentProcessIds();
	
		for(int x=0; x < componentProcessIds.length; x++) {
			result.append("Component ID - " + componentProcessIds[x].componentId + NEW_LINE);
			result.append("Component Process ID - " + componentProcessIds[x].processId + NEW_LINE);
		}
		return result.toString();
	}
	
	
	private String to_String_ComponentDevices(Application application) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Component Devices  ########################" + NEW_LINE);
		DeviceAssignmentType[] componentDevices = application.componentDevices();
	
		for(int x=0; x < componentDevices.length; x++) {
			result.append("Component ID - " + componentDevices[x].componentId + NEW_LINE);
			result.append("Assigned Device ID - " + componentDevices[x].assignedDeviceId + NEW_LINE);
		}
		return result.toString();
	}
	
	
	private String to_String_ComponentImplementations(Application application) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append("######################## Component Implementations  ########################" + NEW_LINE);
		ComponentElementType[] componentImplementations = application.componentImplementations();
	
		for(int x=0; x < componentImplementations.length; x++) {
			result.append("Component ID - " + componentImplementations[x].componentId + NEW_LINE);
			result.append("Component Implementation ID - " + componentImplementations[x].elementId + NEW_LINE);
		}
		return result.toString();
	}
	
	
	private String to_String_Components(Application application) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		org.omg.CORBA.Object objRef = null;
		
		result.append("######################## Components  ########################" + NEW_LINE);
		ComponentElementType[] componentNamingContexts = application.componentNamingContexts();
		
		// Use the component naming Service contexts to get each component from the Naming Service
		for(int x=0; x < componentNamingContexts.length; x++) {
			objRef = getComponent(componentNamingContexts[x].elementId);
			if(objRef != null) {
				if(objRef instanceof Resource) {
					// component is a Resource
					result.append(to_String_ResourceComponent((Resource) objRef));
				} else if(objRef instanceof ResourceFactory){
					// component is a ResourceFactory
					result.append(to_String_ResourceFactoryComponent((ResourceFactory) objRef));
				}
			}
		}
		return result.toString();
	}
	
	
	private String to_String_ResourceComponent(Resource component) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append("######################## Component  ########################" + NEW_LINE);
		result.append("Component identifier = " + component.identifier() + NEW_LINE);
		result.append(toString_Properties(component));
		return result.toString();
	}
	
	
	private String to_String_ResourceFactoryComponent(ResourceFactory rfcomponent) {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append("######################## Component  ########################" + NEW_LINE);
		result.append("Resource Factory Component identifier = " + rfcomponent.identifier() + NEW_LINE);
		return result.toString();
	}
}
