/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.services;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.uml.tools.model.ExtendedUmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.uml.tools.service.ProfileDefinitionService;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * 
 * This class overrides the service defined in {@link org.eclipse.papyrus.uml.tools.service.ProfileDefinitionService}
 * as it contains a bug as described in Issue #131 in github. 
 * 
 * <p>The problem is that the {@code lookupRoot} operation invoked by {@code addRootProfileDecorationIfRequired}
 * throws an exception always because the model with id {@code org.eclipse.papyrus.infra.core.resource.uml.UmlModel}
 * registered via the extension point {@code org.eclipse.papyrus.infra.core.model} (and in fact all models registered
 * via this extension point) are created dynamically and have their {@code resource} attribute set to {@code null}.
 *
 * <p> So by overriding the {@code ProfileDefinitionService} we provide an alternative implementation where instead
 * of logging an error we only log a warning.
 * 
 * <p> This solution is rather verbose because we need to duplicate the code in the {@link startService} and {@link initService}
 * methods because both of them access private fields and methods from the {@link ProfileDefinitionService} class.
 * 
 * @see {@link https://github.com/ZeligsoftDev/CX4CBDDS/issues/131}
 * 
 * @author eposse
 */
public class CustomProfileDefinitionService extends ProfileDefinitionService {

	/** The model set. */
	private ModelSet modelSet = null;

	public CustomProfileDefinitionService() {
		super();
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		super.init(servicesRegistry);
		modelSet = servicesRegistry.getService(ModelSet.class);
	}

	@Override
	public void startService() throws ServiceException {
		final UmlModel umlModel = (UmlModel) modelSet.getModel(ExtendedUmlModel.MODEL_ID);
		try {
			if (null != umlModel.getResource() && umlModel.getResource().getContents().isEmpty()) {
				final Resource res = umlModel.getResource();
				final Adapter waitingForRootAdapter = new AdapterImpl() {

					/**
					 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
					 *
					 * @param msg
					 */
					@Override
					public void notifyChanged(final Notification msg) {
						if (msg.getNewValue() instanceof Element && Notification.ADD == msg.getEventType()) {
							// it seems we add a root to the resource
							// but we check more
							if (res.getContents().size() > 0) {
								try {
									addRootProfileDecorationIfRequired(umlModel);
								} catch (NotFoundException | ServiceException e) {
									com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(e.getMessage(), e);
								} finally {
									res.eAdapters().remove(this);
								}
							}
						}
					}
				};

				res.eAdapters().add(waitingForRootAdapter);

			} else {

				addRootProfileDecorationIfRequired(umlModel);
			}

		} catch (NotFoundException e) {
			com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().warning(e.getLocalizedMessage());
		} catch (ServiceException e) {
			com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(e.getMessage(), e);
		}

	}

	/**
	 *
	 * @param umlModel the umlModel object
	 * @throws NotFoundException
	 * @throws ServiceException
	 */
	private final void addRootProfileDecorationIfRequired(final UmlModel umlModel)
			throws NotFoundException, ServiceException {
		final EObject rootElement = umlModel.lookupRoot();
		if (rootElement instanceof Profile) {
			EAnnotation umlAnnotation = ((Profile) rootElement).getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
			if (null != umlAnnotation && !umlAnnotation.getEAnnotations().isEmpty()) {
				EAnnotation emptyAnnotation = umlAnnotation
						.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
				if (null != emptyAnnotation) {
					PapyrusDefinitionAnnotation parsedAnnotation = PapyrusDefinitionAnnotation
							.parseEAnnotation(emptyAnnotation);
					if (PapyrusDefinitionAnnotation.UNDEFINED_ANNOTATION.equals(parsedAnnotation)) {
						DecorationService decorationService = ServiceUtilsForEObject.getInstance()
								.getService(DecorationService.class, rootElement);
						decorationService.addDecoration(getMarker((Profile) rootElement), rootElement);
					}
				}

			}
		}
	}

}
