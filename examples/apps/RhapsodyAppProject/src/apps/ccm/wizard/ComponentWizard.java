package apps.ccm.wizard;

import org.eclipse.swt.widgets.Composite;

import apps.utils.WizardDialog;

import com.ibm.rhapsody.apps.utils.Reporter;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;

public class ComponentWizard extends WizardDialog {

	protected IRPPackage container;
	protected IRPModelElement selected;

	NewCCMComponentComposite composite;

	public ComponentWizard(IRPModelElement selected) {
		super("Create CCM Component");
		this.selected = selected;
		this.container = (IRPPackage) selected.getOwner();
	}

	public class ComponentController implements
			INewCCMComponentCompositeController {

		@Override
		public String computeDefaultPackageName(String text) {
			return text;
		}

		@Override
		public String computeDefaultComponentDiagramName(String text) {
			return text + "_diag";
		}

		@Override
		public String computeDefaultAssemblyName(String text) {
			return text + "_asm";
		}

		@Override
		public String computeDefaultStructureDiagramName(String text) {
			return text + "_diag";

		}

		@Override
		public void onComplete(String componentName,
				String componentPackageName, String componentDiagramName,
				String assemblyName, String structureDiagramName) {
			Reporter.report("execute");
			final IRPPackage contentPackage = componentPackageName != null ? container
					.addNestedPackage(componentPackageName) : container;

			selected.setOwner(contentPackage);
			selected.setName(componentName);
			if (componentDiagramName != null) {
				contentPackage.addComponentDiagram(componentDiagramName);
			}
			if (assemblyName != null) {
				final IRPClass assembly = (IRPClass) contentPackage.addNewAggr(
						"AssemblyImplementation", assemblyName);
				assembly.addGeneralization((IRPClassifier) selected);
				if (structureDiagramName != null) {
					assembly.addNewAggr("StructureDiagram",
							structureDiagramName);
				}
			}
		}

	}

	@Override
	public Composite createPageContent(Composite parent) {
		final INewCCMComponentCompositeController controller = new ComponentController();
		composite = new NewCCMComponentComposite(sShell, 0, controller);
		return composite;
	}

	@Override
	protected void okPressed() {
		composite.onComplete();
	}
}
