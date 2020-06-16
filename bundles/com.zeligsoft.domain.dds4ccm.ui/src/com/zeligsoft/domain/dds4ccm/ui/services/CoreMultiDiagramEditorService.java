/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.services;

import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.editor.CoreMultiDiagramEditor;

/**
 * This is a dummy service registered via the org.eclipse.papyrus.infra.core.service extension point in order to
 * deal with issue #136 (see {@link https://github.com/ZeligsoftDev/CX4CBDDS/issues/136}).
 * 
 * <p> The problem arises when using Papyrus Compare and during a model diff, the "DiagramContentMergeViewer" and
 * others request the "IMultiDiagramEditor" service, but such service is not registered by default in Papyrus Compare,
 * leading to a "ServiceNotFoundException" which is then logged. 
 * 
 * <p> By creating an instance of this service and registering via the extension point mentioned above, the service is
 * successfully resolved.
 * 
 * <p> This class simply extends the existing {@link CoreMultiDiagrapEditor} by making it into an {@link IService}
 * which can be registered with Papyrus' ServiceRegistry. It doesn't need to provide any specific implementation of
 * the {@link IService} operations, as Papyrus Compare doesn't make use of it as a service. In fact the only uses of
 * the MultiDiagramEditor instance are ignored.
 * 
 * @author eposse
 */
public class CoreMultiDiagramEditorService extends CoreMultiDiagramEditor implements IService {

	public CoreMultiDiagramEditorService() {
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
	}

	@Override
	public void startService() throws ServiceException {
	}

	@Override
	public void disposeService() throws ServiceException {
	}

}
