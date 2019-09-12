package com.zeligsoft.domain.cbdds.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Element;

/** <b>Warning</b> : 
  As explained in <a href="http://wiki.eclipse.org/Eclipse4/RCP/FAQ#Why_aren.27t_my_handler_fields_being_re-injected.3F">this wiki page</a>, it is not recommended to define @Inject fields in a handler. <br/><br/>
  <b>Inject the values in the @Execute methods</b>
*/
public class GenerateHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object result = null;

		List<Element> elements = getSelection(event.getApplicationContext());
		for(Element el: elements) {
			el.getAppliedStereotypes();
			
			
		}
//		if (!elements.isEmpty()) {
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(elements.get(0));
//			if (domain != null) {
//				Command command = wrap(ExclusionCommand.getExclusionCommand(domain, elements, isExclude()));
//				domain.getCommandStack().execute(command);
//				result = command.getResult().isEmpty()
//						? null
//						: command.getResult().iterator().next();
//			}
//		}

		return result;
	}

	protected List<Element> getSelection(Object evaluationContext) {
		IStructuredSelection sel = TypeUtils.as(
				HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME),
				StructuredSelection.EMPTY);

		List<Element> result = ((List<?>) sel.toList()).stream()
				.map(e -> PlatformHelper.getAdapter(e, EObject.class))
				.filter(Element.class::isInstance).map(Element.class::cast)
				.collect(Collectors.toList());

		return result;
	}


}
