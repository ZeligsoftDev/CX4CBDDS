package apps.idl3plus.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import apps.idl3plus.IDL3PlusNames;
import apps.utils.CXRhapsodyUtils;
import apps.utils.Copier;
import apps.utils.WizardDialog;

import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPTemplateParameter;

/**
 * Wizard for template instantiation
 * 
 * @author ysroh
 * 
 */
public class TemplateInstantiationWizard extends WizardDialog {

	protected IRPModelElement context;
	protected Combo combo;
	protected IRPModelElement selected = null;

	public TemplateInstantiationWizard(IRPModelElement context) {
		super("Instantiate Template Module");
		this.context = context;
	}

	@Override
	protected Composite createPageContent(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createSelectionArea(composite);

		return composite;
	}

	@Override
	protected void okPressed() {
		if (selected == null) {
			return;
		}
		List<String> paramFullPath = new ArrayList<String>();
		IRPCollection parameters = selected.getTemplateParameters();
		for (int i = 1; i <= parameters.getCount(); i++) {
			IRPTemplateParameter element = (IRPTemplateParameter) parameters
					.getItem(i);
			paramFullPath.add(element.getRepresentative().getFullPathName());
		}
		IRPCollection col = selected.getNestedElements();
		for (int i = 1; i <= col.getCount(); i++) {
			IRPModelElement element = (IRPModelElement) col.getItem(i);
			String path = element.getFullPathName();
			if (!paramFullPath.contains(path)
					&& !(element instanceof IRPTemplateParameter)) {
				element.clone(element.getName(), context);
			}
		}

		Copier.copyReferences(selected, context);
		
		context.becomeTemplateInstantiationOf(selected);
	}

	/**
	 * Create element selection area
	 * 
	 * @param parent
	 */
	private void createSelectionArea(Composite parent) {

		Composite listAreaComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.horizontalSpacing = 0;
		listAreaComposite.setLayout(layout);
		listAreaComposite.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		GridData viewerData = new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);

		viewerData.heightHint = 200;
		viewerData.widthHint = 200;

		Label listLabel = new Label(listAreaComposite, SWT.NONE);
		listLabel.setText("Select template module to instantiate");

		combo = new Combo(listAreaComposite, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER | SWT.MULTI);
		combo.setLayoutData(viewerData);

		final Map<String, IRPModelElement> templateModules = getAllTemplateModule();
		final String[] items = templateModules.keySet().toArray(new String[0]);
		combo.setItems(items);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int index = combo.getSelectionIndex();
				if (index != -1) {
					selected = templateModules.get(items[index]);
				}
			}
		});
	}

	private Map<String, IRPModelElement> getAllTemplateModule() {
		Map<String, IRPModelElement> result = new HashMap<String, IRPModelElement>();
		IRPCollection allColl = context.getProject()
				.getNestedElementsRecursive();
		for (int i = 1; i <= allColl.getCount(); i++) {
			IRPModelElement element = (IRPModelElement) allColl.getItem(i);
			String concept = CXRhapsodyUtils.getZdlConcept(element);
			if (IDL3PlusNames.TEMPLATE_MODULE.equals(concept)) {
				result.put(element.getFullPathName(), element);
			}
		}
		return result;
	}
}
