package apps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.rhapsody.apps.apps.UI5App;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPort;
import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.IRPStereotype;
import com.telelogic.rhapsody.core.IRPTag;


public class MainApp extends UI5App {

	protected final Map<String,IRPClass> deploymentPlanMap = new HashMap<String, IRPClass>();
	
	protected void initialize() {
		super.initialize();
		
		// Rename controls to create a dialog according to your needs
		
		sShell.setText("Add to Deployment Plan");
		label1.setText("Deployment Plan:");
		buttonOK.setText("OK");
		buttonCancel.setText("Cancel");	
		
		
		final IRPProject project = rhapsody.activeProject();
		@SuppressWarnings("unchecked")
		final List<IRPClass> classes = project.getNestedElementsByMetaClass("Class", 1).toList();
		final List<IRPClass> plans = new ArrayList<IRPClass>();
		for (IRPClass irpClass : classes) {
			final IRPStereotype newTermStereotype = irpClass.getNewTermStereotype();
			if(newTermStereotype != null && "DeploymentPlan".equals(newTermStereotype.getName())) {
				plans.add(irpClass);
			}
		}
		for (IRPClass plan : plans) {
			combo.add(plan.getFullPathNameIn());
			deploymentPlanMap.put(plan.getFullPathNameIn(), plan);
		}
		combo.select(0);
	}
	
	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	* value    - Input in dialog
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected, String value) {
		IRPClass plan = deploymentPlanMap.get(value);
		final String concept = selected.getNewTermStereotype().getName();
		final String planConcept = computePlanConcept(concept);
		final IRPAttribute planAttribute = (IRPAttribute) plan.addNewAggr(planConcept, selected.getName());
		
		planAttribute.setTagValue(planAttribute.getTag("modelElement"), selected.getFullPathName());
		planAttribute.setType((IRPClassifier) selected);
		
		processChildren(selected, concept, plan, planAttribute);
	}	
	
    private void processChildren(IRPModelElement selected, String concept,
			IRPClass plan, IRPAttribute planAttribute) {
		if("CCMComponent".equals(concept)) {
			processComponentNested((IRPClass) selected, plan, planAttribute);
		} else if("Domain".equals(concept)) {
			processDomainNested((IRPClass)selected, plan, planAttribute);
		}
		
	}

	private void processDomainNested(IRPClass domain, IRPClass plan,
			IRPAttribute planParentAttribute) {
		@SuppressWarnings("unchecked")
		final List<IRPAttribute> attributes = domain.getAttributes().toList();
		final List<IRPAttribute> nestedParts = new ArrayList<IRPAttribute>();
		for (IRPAttribute attr : attributes) {
			final String userDefinedMetaClass = attr.getUserDefinedMetaClass();
			
			if("BridgeInstance".equals(userDefinedMetaClass)
					|| "InterconnectInstance".equals(userDefinedMetaClass)
					|| "NodeInstance".equals(userDefinedMetaClass)) {
				final IRPAttribute planAttribute = (IRPAttribute) plan.addNewAggr("DeploymentPart", attr.getName());
				planAttribute.setType(attr.getType());
				planAttribute.setTagValue(planAttribute.getTag("modelElement"), attr.getFullPathName());
				nestedParts.add(planAttribute);
			}
		}
		
		setNestedParts(planParentAttribute, nestedParts);
	}

	private void processComponentNested(IRPClass component, IRPClass plan, IRPAttribute planParentAttribute) {
		@SuppressWarnings("unchecked")
		final List<IRPClassifier> derivedClassfiers = component.getDerivedClassifiers().toList();
		for (IRPClassifier classifier : derivedClassfiers) {
			final IRPStereotype newTermStereotype = classifier.getNewTermStereotype();
			if(newTermStereotype != null && "AssemblyImplementation".equals(newTermStereotype.getName())) {
				
				processAssemblyNested(classifier, plan, planParentAttribute);
			}
		}
		
		final List<IRPAttribute> nestedParts = new ArrayList<IRPAttribute>();
		@SuppressWarnings("unchecked")
		final List<IRPPort> nestedPorts = component.getNestedElementsByMetaClass("Port", 0).toList();
		for (IRPPort irpPort : nestedPorts) {
			final IRPStereotype newTermStereotype = irpPort.getStereotype(); // hack getNewTermStereotype doesn't work here!
			if(newTermStereotype != null && "InterfazePort".equals(newTermStereotype.getName())) {
				final IRPAttribute planAttribute = (IRPAttribute) plan.addNewAggr("PerPortConnectorTypeDeploymentPart", irpPort.getName());
				nestedParts.add(planAttribute);
				planAttribute.setTagValue(planAttribute.getTag("modelElement"), irpPort.getFullPathName());
				planAttribute.setType(irpPort.getContract());
			}
		}
		setNestedParts(planParentAttribute, nestedParts);
		
	}

	private void setNestedParts(IRPAttribute planParentAttribute,
			List<IRPAttribute> nestedParts) {
		if(nestedParts.size() == 0) {
			return;
		}
		final IRPTag newTag = planParentAttribute.setTagElementValue((IRPTag) planParentAttribute.getTag("nestedPart"), nestedParts.get(0));
		for (IRPAttribute attribute : nestedParts.subList(1, nestedParts.size())) {
			newTag.addElementDefaultValue(attribute);
		}
	}

	private void processAssemblyNested(IRPClassifier assembly, IRPClass plan, IRPAttribute planParentAttribute) {
		@SuppressWarnings("unchecked")
		final List<IRPInstance> objects = assembly.getNestedElementsByMetaClass("Object", 0).toList();
		final List<IRPAttribute> nested = new ArrayList<IRPAttribute>();
		for (IRPInstance instance : objects) {
			final IRPStereotype newTermStereotype = instance.getNewTermStereotype();
			if (newTermStereotype != null
					&& ("DataSpace".equals(newTermStereotype.getName()) 
						|| "CCMPart".equals(newTermStereotype.getName()))) {
				final IRPAttribute planAttribute = (IRPAttribute) plan.addNewAggr("ComponentDeploymentPart", instance.getName());
				final IRPClass component = (IRPClass) instance.getOtherClass();
				planAttribute.setType(component);
				planAttribute.setTagValue(planAttribute.getTag("modelElement"), instance.getFullPathName());
				nested.add(planAttribute);
				if("CCMPart".equals(newTermStereotype.getName())) {
					processComponentNested(component, plan, planAttribute);
				}
			}
		}
		setNestedParts(planParentAttribute, nested);
	}

	private String computePlanConcept(String concept) {
		if("CCMComponent".equals(concept)) {
			return "ComponentDeploymentPart";
		} else if("InterfacePort".equals(concept)) {
			return "PerPortConnectorTypeDeploymentPart";
		} else {
			return "DeploymentPart";
		}
	}

	/*
     *  Debug app by launching it as "Java Application" is Eclipse.
	 *  Note: Select an element in Rhapsody in order to simulate launching app on a selected element in the browser.
     */		
	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.invokeFromMain();
	}
}
