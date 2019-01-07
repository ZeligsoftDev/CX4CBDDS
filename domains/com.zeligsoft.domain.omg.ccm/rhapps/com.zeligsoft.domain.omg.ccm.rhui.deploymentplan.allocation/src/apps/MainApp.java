package apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.rhapsody.apps.apps.*;
import com.telelogic.rhapsody.core.*;


public class MainApp extends UI5App {

	private interface IMatchStrategy {
		boolean matches(IRPProject project, IRPAttribute attribute);
	}
	
	private interface ICheckStrategy {
		boolean canAllocate(IRPAttribute elementToAllocate);
	}
	
	private static final IMatchStrategy CONTAINER_PROCESS_MATCH_STRATEGY = new IMatchStrategy() {
		
		@Override
		public boolean matches(IRPProject project, IRPAttribute attribute) {
			final String modelElementFullPath = attribute.getTag("modelElement").getValue();
			final IRPModelElement nodeInstance = project.findElementsByFullName(modelElementFullPath, "Attribute");
			return nodeInstance != null;
		}
	};
	
	private static final ICheckStrategy CONTAINER_PROCESS_CHECK_STRATEGY = new ICheckStrategy() {
		
		@Override
		public boolean canAllocate(IRPAttribute elementToAllocate) {
			return elementToAllocate.getTag("modelElement").getValue().equals(elementToAllocate.getType().getFullPathName());
		}
	};
	
	private static final ICheckStrategy CCM_COMPONENT_CHECK_STRATEGY = new ICheckStrategy() {
		
		@Override
		public boolean canAllocate(IRPAttribute elementToAllocate) {
			final IRPClass component = (IRPClass) elementToAllocate.getType();
			@SuppressWarnings("unchecked")
			final List<IRPClassifier> derivedClassfiers = component.getDerivedClassifiers().toList();
			for (IRPClassifier classifier : derivedClassfiers) {
				final IRPStereotype newTermStereotype = classifier.getNewTermStereotype();
				if(newTermStereotype != null && "AssemblyImplementation".equals(newTermStereotype.getName())) {
					
					return false;
				}
			}
			return true;
		}
	};
	
	private static final IMatchStrategy CCM_COMPONENT_MATCH_STRAGETY = new IMatchStrategy() {
		
		@Override
		public boolean matches(IRPProject project, IRPAttribute attribute) {
			return "ContainerProcess".equals(attribute.getType().getUserDefinedMetaClass());
		}
	};
	private Map<String, IRPModelElement> choiceMap;

	protected void initialize() {
		super.initialize();
		
		// Rename controls to create a dialog according to your needs
		
		sShell.setText("Add Plan Allocation");
		label1.setText("Depends On:");
		buttonOK.setText("OK");
		buttonCancel.setText("Cancel");	
		
		final IRPProject project = rhapsody.activeProject();
		final IRPAttribute elementToAllocate = (IRPAttribute) rhapsody.getSelectedElement();
		choiceMap = getChoicesForElement(project, elementToAllocate);
		final List<String> entries = new ArrayList<String>(choiceMap.keySet());
		Collections.sort(entries);
		for (String entry : entries) {
			combo.add(entry);
		}
		combo.select(0);
	}
	
	private Map<String, IRPModelElement> getChoicesForElement(
			IRPProject project, IRPAttribute elementToAllocate) {
		final Map<String,IRPModelElement> result = new HashMap<String, IRPModelElement>();
		
		final String userDefinedMetaClass = elementToAllocate.getType().getUserDefinedMetaClass();
		final ICheckStrategy checkStrategy = getCheckStrategy(userDefinedMetaClass);
		if(!checkStrategy.canAllocate(elementToAllocate)) {
			return result;
		}
		
		final IRPClass plan = (IRPClass) elementToAllocate.getOwner();
		final IMatchStrategy matchStrategy = getMatchStrategy(userDefinedMetaClass);
		@SuppressWarnings("unchecked")
		final List<IRPAttribute> attributes = plan.getAttributes().toList();
		for (IRPAttribute attribute : attributes) {
			
			if(matchStrategy.matches(project, attribute)) {
				result.put(attribute.getName(), attribute);
			}
		}
		
		return result;
	}

	private ICheckStrategy getCheckStrategy(String userDefinedMetaClass) {
		if("ContainerProcess".equals(userDefinedMetaClass)) {
			return CONTAINER_PROCESS_CHECK_STRATEGY;
		} else if("CCMComponent".equals(userDefinedMetaClass)) {
			return CCM_COMPONENT_CHECK_STRATEGY;
		}
		throw new IllegalArgumentException("No available check strategy found for " + userDefinedMetaClass + " nodes.");
	}

	private IMatchStrategy getMatchStrategy(String userDefinedMetaClass) {
		if("ContainerProcess".equals(userDefinedMetaClass)) {
			return CONTAINER_PROCESS_MATCH_STRATEGY;
		} else if("CCMComponent".equals(userDefinedMetaClass)) {
			return CCM_COMPONENT_MATCH_STRAGETY;
		}
		throw new IllegalArgumentException("No match strategy found for " + userDefinedMetaClass + " nodes.");
	}

	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	* value    - Input in dialog
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement elementToAllocate, String value) {
		final IRPModelElement dependsOnElement = choiceMap.get(value);
		final IRPDependency dependency = elementToAllocate.addDependencyTo(dependsOnElement);
		dependency.changeTo("Allocation");
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
