package apps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.rhapsody.apps.*;
import com.telelogic.rhapsody.core.*;
import com.ibm.rhapsody.apps.TriggerAdapter.Trigger;

public class MainApp extends App {
	
	private static final String MODULE_INSTANTIATION_STEREOTYPE = "ModuleInstantiation_Class";

	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected) {
		copyTemplateModule(rhapsody, selected);
	}	

	// XXX WARNING: This code is not correct. It does not update references in copied elements that refer to other copied elements
	private void copyTemplateModule(final IRPApplication rpy,
			final IRPModelElement ele) {
		final String metaClass = ele.getMetaClass();
		System.out.println("metaClass: " + metaClass);
		if(metaClass.equals("Class")) {
			final IRPStereotype newTermStereotype = ele.getNewTermStereotype();
			if(newTermStereotype != null && MODULE_INSTANTIATION_STEREOTYPE.equals(newTermStereotype.getName())) {
				final IRPClass target = (IRPClass) ele;
				final IRPGeneralization generalization = (IRPGeneralization) target.getGeneralizations().toList().get(0);
				
				final IRPClass source = (IRPClass) generalization.getBaseClass();
				System.out.println("source.name = <<" + source.getNewTermStereotype().getName() + ">> <" + source.getMetaClass() +"> " + source.getName());
				System.out.println("target.name = <<" + target.getNewTermStereotype().getName() + ">> <" + target.getMetaClass() +"> "+ target.getName());
				
				final Map<String,String> mappings = new HashMap<String,String>();
				
				final List<IRPClassifier> srcElements = source.getNestedClassifiers().toList();
				final int pathPrefixLength = source.getFullPathName().length() + 2;
				for (IRPClassifier sme : srcElements) {
					final IRPStereotype nts = sme.getNewTermStereotype();
					final String relPath = sme.getFullPathName().substring(pathPrefixLength);
					System.out.println("  " + (nts != null ? "<<" + nts.getName() + ">> " : "") + sme.getMetaClass() + " "+ relPath);
					if(nts != null) {
						IRPClassifier tme = target.findNestedClassifier(sme.getName());
						if(tme == null) {
							try {
								tme = (IRPClassifier) sme.clone(sme.getName(), target);
								System.out.println("    cloned to target");
							} catch (RhapsodyRuntimeException e) {
								// TODO Auto-generated catch block
								System.out.println("      " + rpy.getErrorMessage());;
							}
						}
						mappings.put(sme.getFullPathName(), tme.getFullPathName());
					} else {
						System.out.println("    ignored");
					}
				}
				
				// Fix up 'references'
				// XXX This doesn't work! Rh has not meta concept of reference. We need to 'know'
				// what kinds of objects are being copied, and where they are referenced from.
				final List<IRPModelElement> allNested = target.getNestedClassifiers().toList();
				for (IRPModelElement nested : allNested) {
					final List<IRPModelElement> references = nested.getReferences().toList();
					boolean first = true;
						for (IRPModelElement ref : references) {
//							if(mappings.containsKey(ref.getFullPathName())) {
								if(first) {
									System.out.println("  <" + nested.getMetaClass() + "> " + nested.getFullPathName()+ " has unresolved references:");
								}
								System.out.println("    <" + ref.getMetaClass() + "> " + ref.getFullPathName());
								
//							}
						}
				}
				
				System.out.println("Did it!");
				
			}
		}
	}

    /*
     *  Debug app by launching it as "Java Application" is Eclipse.
	 *  Note: Select an element in Rhapsody in order to simulate launching app on a selected element in the browser.
     */	
	public static void main(String[] args) {
		MainApp app = new MainApp();
        app.setTrigger(Trigger.TestingTrigger);
		app.invokeFromMain();
	}		
}
